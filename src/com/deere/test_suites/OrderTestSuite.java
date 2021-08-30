package com.deere.test_suites;

import com.deere.global.ApplicationLogin;
import com.deere.global.BrowserConfiguration;
import com.deere.global.CommonConstants;
import com.deere.global.CommonFunctions;
import com.deere.page_actions.ManagementPageActions;
import com.deere.page_actions.OrderPageActions;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderTestSuite {
    public static void test_TC13767() {
        OrderPageActions ordersPage = PageFactory.initElements(BrowserConfiguration.driver, OrderPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        ordersPage.navigateToOrdersMenu();
        ordersPage.clickUploadOrders();
        ordersPage.browseFile();
        ordersPage.clickUpload();
    }

    public static void test_TC13775() {
        OrderPageActions ordersPage = PageFactory.initElements(BrowserConfiguration.driver, OrderPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        ordersPage.navigateToOrdersMenu();
        ordersPage.clickAdvanceFilterButton();
        ordersPage.enterDetailedFilterData();
        String selectedApplicator = ordersPage.selectApplicatorDropDown();
        ordersPage.clickOrderFilterOkButton();
        ordersPage.verifyAdvFilterData(selectedApplicator);
        String CustomerName = ordersPage.getCustomerName();
        ordersPage.clickAdvanceFilterButton();
        ordersPage.setCustomerNameTextBox(CustomerName);
        ordersPage.verifyCustNameFilterData(CustomerName);
    }

    public static void test_TC13792() {
        OrderPageActions ordersPage = PageFactory.initElements(BrowserConfiguration.driver, OrderPageActions.class);
        ManagementPageActions managementPage = PageFactory.initElements(BrowserConfiguration.driver, ManagementPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        managementPage.navigateToOrderOptionsPage();
        managementPage.clearTheFieldGeneratedOrderNumber();
        managementPage.clickOnSaveButton();
        ordersPage.navigateToOrdersMenu();
        ordersPage.createManualOrder();
        ordersPage.deletingOrder();
    }

    public static void test_TC13839() {
        OrderPageActions ordersPage = PageFactory.initElements(BrowserConfiguration.driver, OrderPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        ordersPage.navigateToOrdersMenu();
        Assert.assertFalse(ordersPage.verifyPrintFieldTicketButton());
        ordersPage.selectFilterForCompleteOrder();
        ordersPage.clickCheckAllPrintFieldTicketCheckBox();
        Assert.assertTrue(ordersPage.verifyPrintFieldTicketButton());
        ordersPage.clickAndVerifyFieldTicketPage();
    }

    public static void test_TC16877() {
        OrderPageActions ordersPage = PageFactory.initElements(BrowserConfiguration.driver, OrderPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        ordersPage.navigateToOrdersMenu();
        ordersPage.clickAdvanceFilterButton();
        ordersPage.clickOpenCheckBox();
        ordersPage.clickAssignedCheckBox();
        Assert.assertTrue(ordersPage.isCompleteCheckBoxChecked());
        ordersPage.clickOrderFilterOkButton();
        Assert.assertTrue(ordersPage.searchResultForCompleteOrder());
        ordersPage.clickProductTotalAndVerifyOrders();
    }

    public static void test_TC21241() {
        OrderPageActions ordersPage = PageFactory.initElements(BrowserConfiguration.driver, OrderPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        String[] inputTestDetails = CommonFunctions.getTestData(CommonConstants.REGRESSION_SUITE, "TC21241");
        ordersPage.navigateToOrdersMenu();
        ordersPage.setOrderNumberTextBox(inputTestDetails[0]);
        ordersPage.clickOrderSearchButton();
        ordersPage.matchOrders(inputTestDetails[0]);
        ordersPage.clickUploadOrders();
        ordersPage.clickManageOrder();
        ordersPage.matchOrders(inputTestDetails[0]);
    }
    public static void test_TC21246() {
        OrderPageActions ordersPage = PageFactory.initElements(BrowserConfiguration.driver, OrderPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        ordersPage.navigateToOrdersMenu();
        ordersPage.clickLegendLink();
        ordersPage.multipleLegendTypes();
    }
}