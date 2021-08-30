package com.deere.global;

import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static com.deere.global.BrowserConfiguration.driver;
import static com.deere.global.CommonConstants.CERT_URL;
import static com.deere.global.CommonConstants.DEVL_URL;
import static com.deere.global.CommonFunctions.*;

public class ApplicationLogin {

    public static void LoginToAgLogicWeb() {
        driver.manage().window().maximize();
        String environment = System.getenv("NODE_NAME");
        if ("SmokeTestSlave-cert".equalsIgnoreCase(environment)) {
            driver.get(CERT_URL);
            System.out.println("****** Running Smoke Suite On SmokeTestSlave-cert ******");
        } else if ("SmokeTestSlave-devl".equalsIgnoreCase(environment)) {
            driver.get(DEVL_URL);
            System.out.println("****** Running Smoke Suite On SmokeTestSlave-devl ******");
        } else {
            driver.get(CERT_URL);
            System.out.println("Running Regression Suite On Local System");
        }
        waitForPageTitleToBeAvailable(CommonConstants.LOGIN_PAGE);
        waitForByElement(By.name("j_username"));
        if("SmokeTestSlave-devl".equalsIgnoreCase(environment)){
            driver.findElement(By.name("j_username")).sendKeys(decryptCredentials(String.valueOf(getTestData
                    (CommonConstants.SMOKE_SUITE).get("Key1"))));
            driver.findElement(By.name("j_password")).sendKeys(decryptCredentials(String.valueOf(getTestData
                    (CommonConstants.SMOKE_SUITE).get("Key2"))));
        }else {
            driver.findElement(By.name("j_username")).sendKeys(decryptCredentials(String.valueOf(getTestData
                    (CommonConstants.REGRESSION_SUITE).get("Key1"))));
            driver.findElement(By.name("j_password")).sendKeys(decryptCredentials(String.valueOf(getTestData
                    (CommonConstants.REGRESSION_SUITE).get("Key2"))));
        }
        driver.findElement(By.name("submit")).click();
        waitForPageTitleToBeAvailable(CommonConstants.SCHEDULE_PAGE);
        driver.manage().timeouts().implicitlyWait(150, TimeUnit.MILLISECONDS);
    }
}