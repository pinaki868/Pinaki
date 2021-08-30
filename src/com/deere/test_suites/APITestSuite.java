package com.deere.test_suites;

import com.deere.global.ApplicationLogin;
import com.deere.global.BrowserConfiguration;
import com.deere.global.HttpConnection;
import com.deere.page_actions.OrderPageActions;
import com.deere.page_actions.SchedulePageActions;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class APITestSuite {
    public static void test_TC6045() throws Exception {
        OrderPageActions ordersPage = PageFactory.initElements(BrowserConfiguration.driver, OrderPageActions.class);
        HttpConnection httpConnection = PageFactory.initElements(BrowserConfiguration.driver, HttpConnection.class);

        HttpConnection.documentParser();
        HttpConnection.modifyOrderNumber();
        httpConnection.postAPIPayloadUsingRest(HttpConnection.APIHttpURL, "XML", null, "POST200");
        httpConnection.creatingNumberOfBatches();
        ApplicationLogin.LoginToAgLogicWeb();
        ordersPage.navigateToOrdersMenu();
        ordersPage.searchOrderNumber(String.valueOf(HttpConnection.OrderNumber));
        ordersPage.isBatchedOrderDisplayed();
        ordersPage.clickOnOrderNumber();
        ordersPage.isBatchColumnPresent();
        ordersPage.isProductsPresent();
        ordersPage.isBatchTablePresent();
        ordersPage.verifyProduct1QuantityWithBatchQuantity();
        ordersPage.verifyProduct2QuantityWithBatchQuantity();
    }

    public static void test_TC6047() throws Exception {
        SchedulePageActions schedulePage = PageFactory.initElements(BrowserConfiguration.driver, SchedulePageActions.class);
        HttpConnection httpConnection = PageFactory.initElements(BrowserConfiguration.driver, HttpConnection.class);

        String apiResponse = httpConnection.getAPIUsingRest(HttpConnection.getWorkRecordApiURL, "JSON");
        int count = StringUtils.countMatches(apiResponse, "workRecordId");
        System.out.println(count);
        ApplicationLogin.LoginToAgLogicWeb();
        int countUI = schedulePage.countWorkOrders();
        System.out.println(countUI);
        Assert.assertEquals(count, countUI);
        String uiOrderID = schedulePage.assignOrderToApplicator_API();
        System.out.println(uiOrderID);
        apiResponse = httpConnection.getAPIUsingRest(HttpConnection.getWorkRecordApiURL, "JSON");
        System.out.println(apiResponse);
        Assert.assertTrue(apiResponse.contains(uiOrderID), "The work order assigned does not exist in API response");
    }
}