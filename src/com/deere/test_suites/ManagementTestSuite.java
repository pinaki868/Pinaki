package com.deere.test_suites;

import com.deere.global.*;
import com.deere.page_actions.ManagementPageActions;
import com.deere.page_actions.OrderPageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ManagementTestSuite {
    public static void test_TC13672() {
        ManagementPageActions managementPage = PageFactory.initElements(BrowserConfiguration.driver, ManagementPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        managementPage.navigateToSchedulePageOptionsPage();
        managementPage.verifyOrderPopupPanel();
    }

    public static void test_TC13704() {
        ManagementPageActions managementPage = PageFactory.initElements(BrowserConfiguration.driver, ManagementPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        String[] inputTestDetails = CommonFunctions.getTestData(CommonConstants.REGRESSION_SUITE, "TC13704");
        managementPage.navigateToSchedulePageOptionsPage();
        Assert.assertTrue(managementPage.assertOfflineIndicatiorField());
        Assert.assertTrue(managementPage.assertOfflineIndicatorError());
        managementPage.enterIndicatorFieldValue(inputTestDetails[0]);
        managementPage.clickOnSaveButton();
    }

    public static void test_TC13708() {
        ManagementPageActions managementPage = PageFactory.initElements(BrowserConfiguration.driver, ManagementPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        managementPage.navigateToSchedulePageOptionsPage();
        managementPage.clickOnAreaCheckbox();
        managementPage.clickOnCropTypeCheckbox();
        managementPage.clickOnProductCheckbox();
        managementPage.clickOnSaveButton();
        CommonFunctions.testNavigate("Schedule", CommonConstants.SCHEDULE_PAGE);
        Assert.assertTrue(managementPage.assertAllTabs());
        managementPage.clickOnApplicatorTab();
        managementPage.clickOnApplicatorExpandAllIcon();
        Assert.assertTrue(managementPage.assertAreaText());
        managementPage.clickOnTenderTab();
        managementPage.clickOnTenderExpandAllIcon();
        Assert.assertTrue(managementPage.assertAreaText());
    }

    public static void test_TC13720() {
        ManagementPageActions managementPage = PageFactory.initElements(BrowserConfiguration.driver, ManagementPageActions.class);
        OrderPageActions orderPage = PageFactory.initElements(BrowserConfiguration.driver, OrderPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        try {
            managementPage.navigateToOrderOptionsPage();
            managementPage.clickOnEnableReviewCheckBox();
            managementPage.clickOnSaveButton();
            orderPage.navigateToOrdersMenu();
            managementPage.clickOnFilterButton();
            managementPage.clickOnAssignedStatusCheckBox();
            managementPage.clickOnOpenStatusCheckBox();
            managementPage.clickOnOrderPopUpFilterButton();
            BrowserConfiguration.driver.switchTo().defaultContent();
            Assert.assertTrue(managementPage.assertReviewedCheckBox());
        } finally {
            orderPage.navigateToOrdersMenu();
            managementPage.clickOnFilterButton();
            managementPage.clickOnOrderPopUpClearFilterButton();
            managementPage.clickOnOrderPopUpCloseFilterButton();
        }
    }

    public static void test_TC13729() {
        ManagementPageActions managementPage = PageFactory.initElements(BrowserConfiguration.driver, ManagementPageActions.class);
        OrderPageActions orderPage = PageFactory.initElements(BrowserConfiguration.driver, OrderPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        managementPage.navigateToOrderOptionsPage();
        managementPage.clearTheFieldGeneratedOrderNumber();
        managementPage.setValueInTheField_generatedOrderNumber();
        managementPage.clickOnSaveButton();
        orderPage.navigateToOrdersMenu();
        managementPage.navigateToManagementMenu();
        managementPage.navigateToOrganizationTab();
        managementPage.orderSet();
    }

    public static void test_TC13757() {
        ManagementPageActions managementPage = PageFactory.initElements(BrowserConfiguration.driver, ManagementPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        managementPage.navigateToSchedulePageOptionsPage();
        Assert.assertTrue(managementPage.assertHideStatusIconCheckBox());
        Assert.assertEquals(managementPage.getHideStatusText(), "Hide Statuses Older Than:");
        managementPage.checkHideStatusCheckBox();
        Assert.assertTrue(managementPage.assertHideStatusIconsTimeTextBox());
        Assert.assertNotNull(managementPage.getHideStatusIconsTimeTextBox());
        managementPage.checkHideStatusCheckBox();
        managementPage.clickOnSaveButton();
    }

    public static void test_TC13760() {
        ManagementPageActions managementPage = PageFactory.initElements(BrowserConfiguration.driver, ManagementPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        String[] inputTestDetails = CommonFunctions.getTestData(CommonConstants.REGRESSION_SUITE, "TC13760");
        managementPage.navigateToManagementMenu();
        managementPage.navigateToMobileUsersMenu();
        managementPage.checkUserExistsOrNot(inputTestDetails);
        managementPage.clickOnAddMobileUserLink();
        managementPage.checkActiveUserCheckboxStatus();
        String[] userData = managementPage.createNewUser(inputTestDetails);
        managementPage.verifyNewUserAddedToList(userData);
    }

    public static void test_TC13761() {
        ManagementPageActions managementPage = PageFactory.initElements(BrowserConfiguration.driver, ManagementPageActions.class);
        OrderPageActions orderPage = PageFactory.initElements(BrowserConfiguration.driver, OrderPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        managementPage.navigateToOrderOptionsPage();
        Assert.assertTrue(managementPage.createManualOrderCheckBox());
        managementPage.clickOnSaveButton();
        orderPage.navigateToOrdersMenu();
        Assert.assertTrue(managementPage.createOrderButton());
        managementPage.navigateToOrderOptionsPage();
        managementPage.selectcreateManualOrderCheckBox();
        orderPage.navigateToOrdersMenu();
        Assert.assertFalse(CommonFunctions.isElementPresent(By.id("createOrder")));
        managementPage.navigateToManagementMenu();
        managementPage.navigateToOrganizationTab();
        managementPage.orderSet();
        managementPage.clickOnSaveButton();
    }

    public static void test_TC13769() {
        ManagementPageActions managementPage = PageFactory.initElements(BrowserConfiguration.driver, ManagementPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        String[] inputTestDetails = CommonFunctions.getTestData(CommonConstants.REGRESSION_SUITE, "TC13769");
        managementPage.navigateToManagementMenu();
        managementPage.navigateToOrganizationTab();
        managementPage.navigateToEditProgramOptionsTab();
        CommonFunctions.testNavigate("Mobile Options", CommonConstants.EDIT_PROGRAM_OPTIONS_PAGE);
        managementPage.clickOnOrganizationLink(inputTestDetails);
    }

    public static void test_TC13791() {
        ManagementPageActions managementPage = PageFactory.initElements(BrowserConfiguration.driver, ManagementPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        managementPage.navigateToManagementMenu();
        managementPage.navigateToOrganizationTab();
        managementPage.navigateToEditProgramOptionsTab();
        managementPage.clickOnUnitofMeasureOptions();
        Assert.assertEquals(managementPage.assertOrganizationDropDownStd(), "Standard");
        List<WebElement> options = managementPage.orgnizationDropdown();
        Assert.assertEquals(options.get(0).getText(), "Standard");
        Assert.assertEquals(options.get(1).getText(), "Metric");
        Assert.assertEquals(managementPage.assertAreaDropDownStd(), "Acre");
        List<WebElement> options1 = managementPage.areaDropdown();
        Assert.assertEquals(options1.get(0).getText(), "Acre");
        Assert.assertEquals(options1.get(1).getText(), "Hectare");
        Assert.assertEquals(managementPage.assertdistanceDropDownStd(), "Mile");
        List<WebElement> options2 = managementPage.distanceDropdown();
        Assert.assertEquals(options2.get(0).getText(), "Kilometer");
        Assert.assertEquals(options2.get(1).getText(), "Mile");
    }

    public static void test_TC13796() {
        ManagementPageActions managementPage = PageFactory.initElements(BrowserConfiguration.driver, ManagementPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        String[] inputTestDetails = CommonFunctions.getTestData(CommonConstants.REGRESSION_SUITE, "TC13796");
        managementPage.navigateToManagementMenu();
        managementPage.addWebUser(inputTestDetails);
        Assert.assertTrue(managementPage.assertdisplayGettingStartedCheckbox());
        Assert.assertTrue(managementPage.assertNotifyScheduleCheckBox());
        Assert.assertTrue(managementPage.assertNotifyCustomer());
        Assert.assertTrue(managementPage.assertMobileCheckbox());
    }

    public static void test_TC13797() {
        ManagementPageActions managementPage = PageFactory.initElements(BrowserConfiguration.driver, ManagementPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        managementPage.navigateToManagementMenu();
        List<String> options = managementPage.assertWebUserTableCol();
        Assert.assertEquals(options.get(0), "Edit");
        Assert.assertEquals(options.get(1), "Username");
        Assert.assertEquals(options.get(2), "Role");
        Assert.assertEquals(options.get(3), "Email");
        Assert.assertEquals(options.get(4), "Name");
        Assert.assertEquals(options.get(5), "Region");
    }

    public static void test_TC13809() {
        ManagementPageActions managementPage = PageFactory.initElements(BrowserConfiguration.driver, ManagementPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        managementPage.navigateToManagementMenu();
        managementPage.navigateToOrganizationTab();
        managementPage.navigateToEditProgramOptionsTab();
        managementPage.clickOnBackOfficeIntegrationOptionsTab();
        Assert.assertTrue(managementPage.assertPreserveFieldEntrances());
        Assert.assertTrue(managementPage.assertPreserveEmail());
        Assert.assertTrue(managementPage.assertPreservePhoneNumbers());
    }

    public static void test_TC13810() {
        ManagementPageActions managementPage = PageFactory.initElements(BrowserConfiguration.driver, ManagementPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        managementPage.navigateToSchedulePageOptionsPage();
        managementPage.verifyAutomatedRolloverCheckbox();
        managementPage.verifyTimeFieldIsNonEditable();
        managementPage.clickOnAdjustTimeLink();
        managementPage.setTime();
    }

    public static void test_TC13811() {
        ManagementPageActions managementPage = PageFactory.initElements(BrowserConfiguration.driver, ManagementPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        managementPage.navigateToManagementMenu();
        managementPage.webUserEditFirstRecord();
        Assert.assertTrue(managementPage.assertactiveButtonChecked());
        Assert.assertTrue(managementPage.assertUserNameEditable());
        Assert.assertTrue(managementPage.assertEmailPresent());
        Assert.assertTrue(managementPage.assertFirstNamePresent());
        Assert.assertTrue(managementPage.assertLastNamePresent());
        managementPage.regionDropDown();
        managementPage.permissionDropDown();
        Assert.assertTrue(managementPage.assertSaveButtonForEditFirstRecord());
        Assert.assertTrue(managementPage.assertCancelButtonForEditFirstRecord());
    }

    public static void test_TC13836() {
        ManagementPageActions managementPage = PageFactory.initElements(BrowserConfiguration.driver, ManagementPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        managementPage.navigateToManagementMenu();
        managementPage.navigateToOrganizationTab();
        managementPage.navigateToEditOrganizationTab();
        Assert.assertTrue(managementPage.assertAdvanceLicense());
        Assert.assertTrue(managementPage.assertBasicLicense());
        Assert.assertTrue(managementPage.assertAdvanceDemoLicense());
        Assert.assertTrue(managementPage.assertBasicDemoLicense());
    }

    public static void test_TC13849() {
        ManagementPageActions managementPage = PageFactory.initElements(BrowserConfiguration.driver, ManagementPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        managementPage.navigateToManagementMenu();
        managementPage.clickOnAddWebUser();
        managementPage.permissionDropDown("Manager");
        managementPage.verifyManagerRoles();
    }

    public static void test_TC14350() {
        ManagementPageActions managementPage = PageFactory.initElements(BrowserConfiguration.driver, ManagementPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        String[] inputTestDetails = CommonFunctions.getTestData(CommonConstants.REGRESSION_SUITE, "TC14350");
        managementPage.navigateToSchedulePageOptionsPage();
        managementPage.enterDriftWatchToken(inputTestDetails[0]);
        managementPage.clickOnTheSaveButton();
        Assert.assertEquals(managementPage.invalidTokenError(), inputTestDetails[1]);
        managementPage.enterDriftWatchToken(inputTestDetails[2]);
        managementPage.clickOnSaveButton();
        CommonFunctions.testNavigate("Schedule", CommonConstants.SCHEDULE_PAGE);
        CommonFunctions.testNavigate("Map Controls", CommonConstants.SCHEDULE_PAGE);
        managementPage.clickOnMapTab();
        managementPage.clickOnDriftWatch();
        Assert.assertTrue(managementPage.assertProximityCheckBox());
    }

    public static void test_TC14758() {
        ManagementPageActions managementPage = PageFactory.initElements(BrowserConfiguration.driver, ManagementPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        managementPage.navigateToManagementMenu();
        managementPage.clickOnLocationsTab();
        managementPage.clickOnAddLocation();
        managementPage.checkMandatoryFields();
        managementPage.createLocationAndVerify();
    }

    public static void test_TC21321() {
        ManagementPageActions managementPage = PageFactory.initElements(BrowserConfiguration.driver, ManagementPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        managementPage.navigateToManagementMenu();
        managementPage.clickOnAddWebUser();
        managementPage.permissionDropDown("Admin");
        managementPage.verifyAdminRoles();
        managementPage.permissionDropDown("Scheduler");
        managementPage.verifySchedulerRoles();
    }

    public static void test_TC21323() {
        ManagementPageActions managementPage = PageFactory.initElements(BrowserConfiguration.driver, ManagementPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        managementPage.navigateToManagementMenu();
        managementPage.clickOnAddWebUser();
        managementPage.permissionDropDown("Admin");
        managementPage.verifyAllCheckBoxChecked();
        managementPage.permissionDropDown("Sales");
        managementPage.verifySalesFunctionalityFullAccess();
        managementPage.verifySalesFunctionalityEditAccess();
        managementPage.verifySalesFunctionalityViewAccess();
    }

    public static void test_TC21324() {
        ManagementPageActions managementPage = PageFactory.initElements(BrowserConfiguration.driver, ManagementPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        managementPage.navigateToManagementMenu();
        managementPage.navigateToLocationsTab();
        managementPage.checkingAddLocationLink();
        managementPage.verifyAllFieldsAndUpdateLocationTab();
    }

    public static void test_TC21325() {
        ManagementPageActions managementPage = PageFactory.initElements(BrowserConfiguration.driver, ManagementPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        managementPage.navigateToManagementMenu();
        managementPage.clickOnAddWebUser();
        managementPage.permissionDropDown("Admin");
        managementPage.verifyAllCheckBoxChecked();
        managementPage.permissionDropDown("No Access");
        managementPage.verifyAllCheckBoxUnChecked();
    }

    public static void test_TC21327() {
        ManagementPageActions managementPage = PageFactory.initElements(BrowserConfiguration.driver, ManagementPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        managementPage.navigateToManagementMenu();
        managementPage.navigateToOrganizationTab();
        managementPage.navigateToEditOrganizationTab();
        managementPage.checkEditableFields();
        managementPage.checkMandatory();
        managementPage.checkBackOffice();
    }
}