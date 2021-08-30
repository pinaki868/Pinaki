package com.deere.test_suites;

import com.deere.global.ApplicationLogin;
import com.deere.global.BrowserConfiguration;
import com.deere.global.CommonConstants;
import com.deere.global.CommonFunctions;
import com.deere.page_actions.AgLogicUiLoginPageActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AgLogicUiLoginTestSuite {
    public static void test_TC13798() {
        AgLogicUiLoginPageActions agLogicLoginPage = PageFactory.initElements(BrowserConfiguration.driver, AgLogicUiLoginPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        new Actions(BrowserConfiguration.driver).keyDown(Keys.CONTROL).keyDown(Keys.SHIFT)
                .click(agLogicLoginPage.equipmentTab()).keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).build().perform();
        agLogicLoginPage.goToMyJDApp();
        Assert.assertTrue(agLogicLoginPage.assertLogoutButton());
        Assert.assertTrue(agLogicLoginPage.assertAgLogicIcon());
        Assert.assertTrue(agLogicLoginPage.assertAgLogicTM());
        agLogicLoginPage.agLogicTMClick();
    }

    public static void test_TC13804() {
        AgLogicUiLoginPageActions agLogicLoginPage = PageFactory.initElements(BrowserConfiguration.driver, AgLogicUiLoginPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        agLogicLoginPage.clickLogoutButton();
        Assert.assertTrue(agLogicLoginPage.forgotPasswordButton());
        agLogicLoginPage.forgotPasswordClick();
        Assert.assertTrue(agLogicLoginPage.forMigratedCustomers());
        Assert.assertTrue(agLogicLoginPage.forNonMigratedCustomers());
        agLogicLoginPage.clickHere();
        Assert.assertTrue(agLogicLoginPage.forgotPasswordTextBox());
        Assert.assertTrue(agLogicLoginPage.forgotPasswordSubmitButton());
    }

    public static void test_TC13859() {
        AgLogicUiLoginPageActions agLogicLoginPage = PageFactory.initElements(BrowserConfiguration.driver, AgLogicUiLoginPageActions.class);
        java.lang.String[] inputTestDetails = CommonFunctions.getTestData(CommonConstants.REGRESSION_SUITE, "TC13859");
        ApplicationLogin.LoginToAgLogicWeb();
        agLogicLoginPage.orderAndCreateNewOrderClick();
        agLogicLoginPage.verifyOrderDetails(inputTestDetails);
    }

    public static void test_TC21229() {
        AgLogicUiLoginPageActions agLogicLoginPage = PageFactory.initElements(BrowserConfiguration.driver, AgLogicUiLoginPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        agLogicLoginPage.singleSignOn();
        agLogicLoginPage.assertAgLogicLink();
    }
}