package com.deere.test_suites;

import com.deere.global.ApplicationLogin;
import com.deere.global.BrowserConfiguration;
import com.deere.global.CommonConstants;
import com.deere.global.CommonFunctions;
import com.deere.page_actions.CustomerFarmFieldPageActions;
import org.openqa.selenium.support.PageFactory;

public class CustomerFarmFieldTestSuite {
    public static void test_TC13718() {
        CustomerFarmFieldPageActions cffp = PageFactory.initElements(BrowserConfiguration.driver, CustomerFarmFieldPageActions.class);
        String[] inputTestDetails = CommonFunctions.getTestData(CommonConstants.REGRESSION_SUITE, "TC13718");
        ApplicationLogin.LoginToAgLogicWeb();
        cffp.verifyCustomerFamFieldSubTab1(inputTestDetails);
    }

    public static void test_TC13721() throws Exception {
        CustomerFarmFieldPageActions cffp = PageFactory.initElements(BrowserConfiguration.driver, CustomerFarmFieldPageActions.class);
        String[] inputTestDetails = CommonFunctions.getTestData(CommonConstants.REGRESSION_SUITE, "TC13721");
        ApplicationLogin.LoginToAgLogicWeb();
        cffp.exportToCSV(inputTestDetails);
    }

    public static void test_TC13790() {
        CustomerFarmFieldPageActions cffp = PageFactory.initElements(BrowserConfiguration.driver, CustomerFarmFieldPageActions.class);
        String[] inputTestDetails = CommonFunctions.getTestData(CommonConstants.REGRESSION_SUITE, "TC13790");
        ApplicationLogin.LoginToAgLogicWeb();
        cffp.uploadCFFFile();
        cffp.verifyCustomerFarmField(inputTestDetails);
    }

    public static void test_TC13861_TC13825() {
        CustomerFarmFieldPageActions cffp = PageFactory.initElements(BrowserConfiguration.driver, CustomerFarmFieldPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        cffp.uploadCFFFile();
        cffp.verifyCustomerTab();
    }

    public static void test_TC19578() {
        CustomerFarmFieldPageActions cffp = PageFactory.initElements(BrowserConfiguration.driver, CustomerFarmFieldPageActions.class);
        String[] inputTestDetails = CommonFunctions.getTestData(CommonConstants.REGRESSION_SUITE, "TC19578");
        ApplicationLogin.LoginToAgLogicWeb();
        cffp.uploadBoundary(inputTestDetails);
        cffp.verifyBoundary();
    }
}