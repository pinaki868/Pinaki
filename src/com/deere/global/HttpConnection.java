package com.deere.global;

import org.apache.commons.codec.binary.Base64;
import org.testng.Assert;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpConnection {

    public static final int OrderNumber = ((Double) CommonFunctions.generateRandomNumber(8528525)).intValue();
    public static final String APIHttpURL = "https://aglogicawscert.deere.com/nulog/v1/source/xxx/order/"
            + OrderNumber;
    public static final String workRecordApplicatorID = "188884603";
    public static final String getWorkRecordApiURL = "https://aglogicawscert.deere.com/nulog/v3/workRecord?assetId="
            + workRecordApplicatorID + "&pendingOnly=true";

    private static HttpURLConnection rest_Authentication(URL url, String payloadType, String method) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        byte[] authEncBytes = Base64.encodeBase64(authorizationCredentials().getBytes());
        String authStringEnc = new String(authEncBytes);
        set_Conn_Property(conn, authStringEnc, payloadType, method);
        return conn;
    }

    private static void payloadWriter(HttpURLConnection conn) throws IOException {
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.writeBytes(readPayloadFile(CommonConstants.FILE_UPLOAD_DIRECTORY + "createOrderPayload.xml"));
        wr.flush();
    }

    private static String authorizationCredentials() {
        return CommonFunctions.decryptCredentials(String.valueOf(CommonFunctions.getTestData
                (CommonConstants.REGRESSION_SUITE).get("Key1"))) + ":"
                + CommonFunctions.decryptCredentials(String.valueOf(CommonFunctions.getTestData
                (CommonConstants.REGRESSION_SUITE).get("Key2")));
    }

    private static void set_Conn_Property(HttpURLConnection conn, String authStringEnc, String payloadType, String method) throws ProtocolException {
        if (payloadType.equals("XML")) {
            conn.setRequestProperty("Content-Type", "application/xml");
            conn.setRequestProperty("Accept", "application/xml");
        } else if (payloadType.equals("JSON")) {
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
        }
        conn.setRequestProperty("Authorization", "Basic " + authStringEnc);
        conn.setRequestMethod(method);
        conn.setDoOutput(true);
    }

    private static URL get_url(String Test_URL) throws MalformedURLException {
        return new URL(Test_URL);
    }

    private static String readPayloadFile(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        }
    }

    public static void modifyOrderNumber() throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        DOMSource source = new DOMSource(documentParser());
        StreamResult result = new StreamResult(new File(CommonConstants.FILE_UPLOAD_DIRECTORY + "createOrderPayload.xml"));
        transformer.transform(source, result);
    }

    public static Document documentParser() throws Exception {
        File createOrderInputFile = new File(new File(CommonConstants.FILE_UPLOAD_DIRECTORY + "createOrderPayload.xml").toString());
        Document doc1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(createOrderInputFile);
        org.w3c.dom.Node orderNumber = doc1.getElementsByTagName("order-number").item(0);
        orderNumber.setTextContent(String.valueOf(OrderNumber));
        System.out.println(OrderNumber);
        return doc1;
    }

    private static void JSONPayloadWriter(HttpURLConnection conn, String jsonPayload) throws IOException {
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.writeBytes(jsonPayload);
        wr.flush();
    }

    public void postAPIPayloadUsingRest(String url, String payloadType, String jsonPayload, String method) throws IOException {
        HttpURLConnection conn = rest_Authentication(get_url(url), payloadType, "POST");
        if (payloadType.equals("XML"))
            payloadWriter(conn);
        else if (payloadType.equals("JSON"))
            JSONPayloadWriter(conn, jsonPayload);
        verifyHttpSuccessStatus(conn, method);
    }

    public void creatingNumberOfBatches() throws IOException {
        HttpURLConnection conn1 = rest_Authentication(get_url(APIHttpURL + 1), "XML", "POST");
        payloadWriter(conn1);
        verifyHttpSuccessStatus(conn1, "POST200");
    }

    private void verifyHttpSuccessStatus(HttpURLConnection conn, String method) throws IOException {
        int successMessage = conn.getResponseCode();
        switch (method) {
            case "POST":
                if (successMessage == 409)
                    System.out.println("Please login with the applicator on mobile");
                Assert.assertEquals(successMessage, HttpURLConnection.HTTP_NO_CONTENT);
                break;
            case "POST200":
                Assert.assertEquals(successMessage, HttpURLConnection.HTTP_OK);
                break;
            case "GET":
                Assert.assertEquals(successMessage, HttpURLConnection.HTTP_OK);
                break;
        }
    }

    public String getAPIUsingRest(String url, String payloadType) throws IOException {
        HttpURLConnection conn = rest_Authentication(get_url(url), payloadType, "GET");
        verifyHttpSuccessStatus(conn, "GET");
        return getAPIResponse(conn);
    }

    private String getAPIResponse(HttpURLConnection conn) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        StringBuilder sb = new StringBuilder();
        String output;
        while ((output = br.readLine()) != null) {
            sb.append(output);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}