package com.deere.test_suites;

import com.deere.global.ApplicationLogin;
import com.deere.global.BrowserConfiguration;
import com.deere.global.CommonConstants;
import com.deere.global.CommonFunctions;
import com.deere.page_actions.HomePageActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomeTestSuite {
    public static void test_TC13711() {
        HomePageActions homeLinksPageActions = PageFactory.initElements(BrowserConfiguration.driver, HomePageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        homeLinksPageActions.navigateToHomeTab();
        Assert.assertEquals(homeLinksPageActions.assertHomekTab(), "Home");
        Assert.assertEquals(homeLinksPageActions.assertScheduledWork(), "Scheduled Work");
        Assert.assertEquals(homeLinksPageActions.assertCompletedWork(), "Completed Work");
        Assert.assertEquals(homeLinksPageActions.assertUnscheduledWork(), "Unscheduled Work");
        Assert.assertEquals(homeLinksPageActions.assertIntegrationErrors(), "Integration Errors");
        Assert.assertTrue(Double.parseDouble(homeLinksPageActions.assertValueOnScheduleLink()) >= 0);
        Assert.assertTrue(Double.parseDouble(homeLinksPageActions.assertValueOnScheduleWorkAcreLink()) >= 0);
        homeLinksPageActions.clickOnScheduledWork();
        Assert.assertTrue(Double.parseDouble(homeLinksPageActions.assertValueUnscheduledWorkLink()) >= 0);
        Assert.assertTrue(Double.parseDouble(homeLinksPageActions.assertValueUnscheduledWorkAcreLink()) >= 0);
        homeLinksPageActions.clickOnUnscheduledWorkLink();
        Assert.assertTrue(Double.parseDouble(homeLinksPageActions.assertValueCompletedWorkLink()) >= 0);
        Assert.assertTrue(Double.parseDouble(homeLinksPageActions.assertValueCompletedWorkAcreLink()) >= 0);
        homeLinksPageActions.clickOnCompletedWorkLink();
        Assert.assertTrue(Double.parseDouble(homeLinksPageActions.assertValueIntegrationErrorsLink()) >= 0);
        homeLinksPageActions.clickOnIntegrationErrorsLink();
    }

    public static void test_TC13712() {
        HomePageActions homeLinksPageActions = PageFactory.initElements(BrowserConfiguration.driver, HomePageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        homeLinksPageActions.clickOnMyInfoTab();
        homeLinksPageActions.clickCheckBox();
        homeLinksPageActions.clickMyInfoSaveButtonAfterChanges();
        Assert.assertEquals(homeLinksPageActions.assertGetStartedHomePage(), "Hide Getting Started...");
        homeLinksPageActions.clickInstallationInstruction();
        homeLinksPageActions.clickOnHideGettingStartedLink();
        homeLinksPageActions.clickWhatsNew();
    }

    public static void test_TC13713() {
        HomePageActions homeLinksPageActions = PageFactory.initElements(BrowserConfiguration.driver, HomePageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        String[] inputTestDetails = CommonFunctions.getTestData(CommonConstants.REGRESSION_SUITE, "TC13713");
        homeLinksPageActions.clickOnMyInfoTab();
        homeLinksPageActions.mandatoryFieldClear();
        homeLinksPageActions.clickMyInfoSaveButton();
        Assert.assertEquals(homeLinksPageActions.assertRequiredFields(), "Required Field.");
        homeLinksPageActions.clickOnMyInfoTab();
        homeLinksPageActions.changesFirstName(inputTestDetails[0]);
        homeLinksPageActions.clickMyInfoSaveButtonAfterChanges();
        homeLinksPageActions.clickOnMyInfoTab();
        homeLinksPageActions.clickOnChangepasswordLink();
        homeLinksPageActions.notifyMeWithAnEmail();
        Assert.assertFalse(homeLinksPageActions.assertUsername());
    }

    public static void test_TC13716() {
        HomePageActions homeLinksPageActions = PageFactory.initElements(BrowserConfiguration.driver, HomePageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        homeLinksPageActions.navigateToHomeTab();
        Assert.assertTrue(homeLinksPageActions.assertScheduleWorkInAcre());
        Assert.assertTrue(homeLinksPageActions.assertCompletedWorkInAcre());
        Assert.assertTrue(homeLinksPageActions.assertUnscheduledWorkInAcre());
        homeLinksPageActions.clickOnScheduledWork();
        homeLinksPageActions.clickOnCompletedWork();
        homeLinksPageActions.clickOnUnscheduledWork();
        homeLinksPageActions.clickScheduledOrderCount();
    }

    public static void test_TC13805() {
        HomePageActions homeLinksPageActions = PageFactory.initElements(BrowserConfiguration.driver, HomePageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        homeLinksPageActions.clickOnMyInfoTab();
        homeLinksPageActions.changeAccountAssociation();
        Assert.assertTrue(homeLinksPageActions.assertNewUsername());
        Assert.assertTrue(homeLinksPageActions.assertNewPassword());
        Assert.assertTrue(homeLinksPageActions.assertVerifyButton());
        Assert.assertTrue(homeLinksPageActions.assertCloseDialog());
        homeLinksPageActions.actionCloseDialog();
        Assert.assertEquals(homeLinksPageActions.assertNewUserError(), "Sorry, but we could not verify your existing John Deere account. Please check your username and password and try again.");
    }

    public static void test_TC13834() {
        HomePageActions homeLinksPageActions = PageFactory.initElements(BrowserConfiguration.driver, HomePageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        homeLinksPageActions.clickOnTermsOfUseLink();
    }

    public static void test_TC14110() {
        HomePageActions homeLinksPageActions = PageFactory.initElements(BrowserConfiguration.driver, HomePageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        String[] inputTestDetails = CommonFunctions.getTestData(CommonConstants.REGRESSION_SUITE, "TC14110");
        homeLinksPageActions.clickOnFeedbackTab();
        Assert.assertEquals(homeLinksPageActions.assertFeedbackPage(), "Have an idea? Help us improve the functionality we already have on AgLogic!");
        Assert.assertEquals(homeLinksPageActions.categoryText(), "General Feedback");
        List<WebElement> options = homeLinksPageActions.multipleCategoryDropdown();
        Assert.assertEquals(options.get(0).getText(), "General Feedback");
        Assert.assertEquals(options.get(1).getText(), "Complaints");
        Assert.assertEquals(options.get(2).getText(), "Suggestion");
        homeLinksPageActions.enterFeedback(inputTestDetails[0]);
        homeLinksPageActions.clickOnSubmitFeedbackButton();
        Assert.assertEquals(homeLinksPageActions.assertFeedbackThankYou(), "Thank you for the valuable feedback.");
    }
}