package com.deere.test_suites;

import com.deere.global.*;
import com.deere.page_actions.EquipmentPageActions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EquipmentTestSuite {
    public static void test_TC13726() {
        EquipmentPageActions equipmentPageActions = PageFactory.initElements(BrowserConfiguration.driver, EquipmentPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        String[] inputTestDetails = CommonFunctions.getTestData(CommonConstants.REGRESSION_SUITE, "TC13726");
        equipmentPageActions.clickOnEquipmentTab();
        equipmentPageActions.verifyIsAdvancedValuesPresent(inputTestDetails);
    }

    public static void test_TC13727() {
        EquipmentPageActions equipmentPageActions = PageFactory.initElements(BrowserConfiguration.driver, EquipmentPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        equipmentPageActions.clickOnEquipmentMenu();
        String createdApplicator = equipmentPageActions.createApplicator();
        equipmentPageActions.updateApplcator();
        equipmentPageActions.deleteApplicator(createdApplicator);
        equipmentPageActions.clickOnApplicatorCancelButton();
    }

    public static void test_TC13728() {
        EquipmentPageActions equipmentPageActions = PageFactory.initElements(BrowserConfiguration.driver, EquipmentPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        equipmentPageActions.clickOnCheckBox();
        equipmentPageActions.assignButtonClick();
        equipmentPageActions.assignmentButtonClick(equipmentPageActions.selectApplicatorFromPopUpWindow());
        equipmentPageActions.changeAssignmentClick();
        equipmentPageActions.clickUnAssignApplicators();
        equipmentPageActions.clickOrderAssignOk();
        equipmentPageActions.clickOnEquipmentMenu();
        equipmentPageActions.clickONShowEquipmentTender();
        equipmentPageActions.unCheckAllTenders();
        equipmentPageActions.clickOnSaveEquipmentEdit();
        equipmentPageActions.clickONShowEquipmentTender();
        equipmentPageActions.checkFirstTender();
        equipmentPageActions.clickOnSaveEquipmentEdit();
        Assert.assertFalse(equipmentPageActions.isDeleteEquipmentButtonEnabled());
        equipmentPageActions.clickOnEquipmentDeleteCheckbox();
        equipmentPageActions.clickOnDeleteEquipmentButton();
        equipmentPageActions.AssertDeleteMessage();
        equipmentPageActions.clickONShowEquipmentTender();
        equipmentPageActions.unCheckAllTenders();
        equipmentPageActions.clickOnSaveEquipmentEdit();
        equipmentPageActions.clickOnEquipmentDeleteCheckbox();
        equipmentPageActions.clickOnDeleteEquipmentButton();
    }

    public static void test_TC13766() {
        EquipmentPageActions equipmentPageActions = PageFactory.initElements(BrowserConfiguration.driver, EquipmentPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        equipmentPageActions.clickOnEquipmentMenu();
        equipmentPageActions.clickOnEquipmentStatus();
    }

    public static void test_TC13801() {
        EquipmentPageActions equipmentPageActions = PageFactory.initElements(BrowserConfiguration.driver, EquipmentPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        equipmentPageActions.clickOnEquipmentMenu();
        equipmentPageActions.createTender();
        equipmentPageActions.updateEnabledTender();
        equipmentPageActions.disableTender();
        equipmentPageActions.enableDisabledTender();
        equipmentPageActions.disableTender();
        equipmentPageActions.deleteTender();
    }

    public static void test_TC13850() {
        EquipmentPageActions equipmentPageActions = PageFactory.initElements(BrowserConfiguration.driver, EquipmentPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        equipmentPageActions.clickOnEquipmentMenu();
        equipmentPageActions.clickOnMobileDevice();
        equipmentPageActions.clickOnMobileDeviceActivate();
        equipmentPageActions.clickOnDeactivatedDevice();
        equipmentPageActions.clickOnActiveCheckBox();
    }

    public static void test_TC13851() {
        EquipmentPageActions equipmentPageActions = PageFactory.initElements(BrowserConfiguration.driver, EquipmentPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        equipmentPageActions.clickOnEquipmentMenu();
        equipmentPageActions.clickOnMobileDevice();
        Assert.assertTrue(equipmentPageActions.verifyLicenses());
    }
}