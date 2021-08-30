package com.deere.page_actions;

import com.deere.global.BrowserConfiguration;
import com.deere.global.CommonConstants;
import com.deere.global.CommonWebElements;
import com.deere.page_objects.EquipmentPageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

import static com.deere.global.CommonFunctions.*;

public class EquipmentPageActions extends EquipmentPageObjects {
    CommonWebElements commonWebElements = PageFactory.initElements(BrowserConfiguration.driver, CommonWebElements.class);

    private String applicatorName;
    private String tenderName;

    private WebElement displayFullList;
    private WebElement typeLiquid;
    private WebElement typeDry;
    private WebElement typeGas;

    private static void handlingDynamicTable() {
        waitForByElement(By.xpath(CommonConstants.DIAGNOSTIC_DETAILS));
        WebElement tBody1 = BrowserConfiguration.driver.findElement(By.xpath(CommonConstants.DIAGNOSTIC_DETAILS));
        List<WebElement> tr = tBody1.findElements(By.tagName("tr"));
        String[] tr1Parts = tr.get(0).getText().split(" ");
        String[] tr3Parts = tr.get(2).getText().split(" ");
        String[] tr5Parts = tr.get(4).getText().split(" ");
        String[] tr7Parts = tr.get(6).getText().split(" ");
        String[] tr9Parts = tr.get(8).getText().split(" ");
        Assert.assertTrue(tr1Parts[tr1Parts.length - 1].equalsIgnoreCase("N")
                || tr3Parts[tr3Parts.length - 1].equalsIgnoreCase("N")
                || tr5Parts[tr5Parts.length - 1].equalsIgnoreCase("N")
                || tr7Parts[tr7Parts.length - 1].equalsIgnoreCase("N")
                || tr9Parts[tr9Parts.length - 1].equalsIgnoreCase("N"));
    }

    public void clickOnMobileDevice() {
        clickOnWebElementAndWaitForPageToLoad(mobileDeviceTab, CommonConstants.EQUIPMENT_MOBILE_DEVICE_PAGE);
    }

    public void clickOnMobileDeviceActivate() {
        clickOnWebElementAndWaitForPageToLoad(firstMobileNumber, CommonConstants.EQUIPMENT_UPDATE_MOBILE_DEVICE_PAGE);
        clickOnWebElement(activeCheckBox);
        clickOnWebElementAndWaitForPageToLoad(saveClick, CommonConstants.EQUIPMENT_MOBILE_DEVICE_PAGE);
    }

    public void clickOnDeactivatedDevice() {
        ((JavascriptExecutor) BrowserConfiguration.driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        clickOnWebElementAndWaitForPageToLoad(deactivatedMobileDevices, CommonConstants.EQUIPMENT_UPDATE_MOBILE_DEVICE_PAGE);
    }

    public void clickOnActiveCheckBox() {
        clickOnWebElement(activeCheckBox);
        selectElementByIndex(licenseDropDown, 1);
        clickOnWebElementAndWaitForPageToLoad(saveClick, CommonConstants.EQUIPMENT_MOBILE_DEVICE_PAGE);
    }

    public boolean verifyLicenses() {
        return waitForWebElement(licenses).isDisplayed();
    }

    public void clickOnApplicatorCancelButton() {
        clickOnByElementAndWaitForPageToLoad(By.linkText("Create Applicator"), CommonConstants.EQUIPMENT_CREATE_APPLICATOR_PAGE);
        clickOnWebElementAndWaitForPageToLoad(cancelEquipmentButton, CommonConstants.EQUIPMENT_APPLICATORS_PAGE);
    }

    public String createApplicator() {
        clickOnByElementAndWaitForPageToLoad(By.linkText("Create Applicator"), CommonConstants.EQUIPMENT_CREATE_APPLICATOR_PAGE);
        applicatorName = "Applicator_" + generateRandomAlphaNumeric(7);
        typeInputDetails(applicatorNameTextBox, applicatorName);
        selectElementByIndex(myjdEquipmentDropdown, 0);
        typeInputDetails(applicatorMakeTextBox, "Make_" + generateRandomAlphaNumeric(3));
        clickOnWebElement(typeLiquid);
        clickOnWebElement(typeDry);
        clickOnWebElement(typeGas);
        if (!tenderIds.isSelected())
            clickOnWebElement(tenderIds);
        clickOnSaveEquipmentEdit();
        Assert.assertTrue(isElementPresent(By.xpath("//a[text()='" + applicatorName + "']")));
        return applicatorName;
    }

    public void updateApplcator() {
        clickOnByElementAndWaitForPageToLoad(By.xpath("//a[text()='" + applicatorName + "']"), CommonConstants.EQUIPMENT_UPDATE_APPLICATOR_PAGE);
        selectElementByIndex(myjdEquipmentDropdown, 0);
        clickOnSaveEquipmentEdit();
    }

    public void createTender() {
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.tendersTab, CommonConstants.EQUIPMENT_TENDERS_PAGE);
        clickOnByElementAndWaitForPageToLoad(By.linkText("Create Tender"), CommonConstants.EQUIPMENT_CREATE_TENDER_PAGE);
        tenderName = "0Tender_" + generateRandomAlphaNumeric(7);
        typeInputDetails(applicatorNameTextBox, tenderName);
        clickOnWebElement(typeLiquid);
        clickOnWebElement(typeDry);
        clickOnWebElement(typeGas);
        clickOnWebElementAndWaitForPageToLoad(tenderSaveButton, CommonConstants.EQUIPMENT_TENDERS_PAGE);
        Assert.assertTrue(isElementPresent(By.xpath("//a[text()='" + tenderName + "']")));
    }

    public void updateEnabledTender() {
        clickOnByElementAndWaitForPageToLoad(By.xpath("//a[text()='" + tenderName + "']"), CommonConstants.EQUIPMENT_UPDATE_TENDER_PAGE);
        tenderName = "0UpdatedTender_" + generateRandomAlphaNumeric(7);
        typeInputDetails(applicatorNameTextBox, tenderName);
        clickOnWebElementAndWaitForPageToLoad(tenderSaveButton, CommonConstants.EQUIPMENT_TENDERS_PAGE);
        Assert.assertTrue(isElementPresent(By.xpath("//a[text()='" + tenderName + "']")));
    }

    public void enableDisabledTender() {
        clickOnByElementAndWaitForPageToLoad(By.xpath("//a[text()='" + tenderName + "']"), CommonConstants.EQUIPMENT_UPDATE_TENDER_PAGE);
        clickOnWebElement(activeCheckBox);
        clickOnWebElementAndWaitForPageToLoad(tenderSaveButton, CommonConstants.EQUIPMENT_TENDERS_PAGE);
        Assert.assertTrue(isElementPresent(By.xpath("//a[text()='" + tenderName + "']")));
    }

    public void disableTender() {
        clickOnByElementAndWaitForPageToLoad(By.xpath("//a[text()='" + tenderName + "']"), CommonConstants.EQUIPMENT_UPDATE_TENDER_PAGE);
        clickOnWebElement(disableTender);
        clickOnWebElementAndWaitForPageToLoad(tenderSaveButton, CommonConstants.EQUIPMENT_TENDERS_PAGE);
        if (!displayFullList.isSelected())
            clickOnWebElement(displayFullList);
        Assert.assertTrue(isElementPresent(By.xpath("//*[contains(@class,'deActivated')]//*[text()='" + tenderName + "']")));
    }

    public void deleteTender() {
        clickOnByElement(By.xpath("//*[contains(@class,'deActivated')]//*[text()='" + tenderName + "']/../..//*[@type='checkbox']"));
        clickOnWebElementAndWaitForPageToLoad(deleteEquipmentsButton, CommonConstants.EQUIPMENT_TENDERS_PAGE);
        Assert.assertFalse(isElementPresent(By.xpath("//*[text()='" + tenderName + "']")));
    }

    public void clickOnEquipmentMenu() {
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.equipmentTab, CommonConstants.EQUIPMENT_APPLICATORS_PAGE);
    }

    public void clickOnEquipmentTab() {
        clickOnEquipmentMenu();
        clickOnWebElementAndWaitForPageToLoad(mobileDeviceTab, CommonConstants.EQUIPMENT_MOBILE_DEVICE_PAGE);
        clickOnWebElementAndWaitForPageToLoad(createMobileDeviceLink, CommonConstants.EQUIPMENT_CREATE_MOBILE_DEVICE_PAGE);
        Assert.assertEquals(licenseDropDown.getTagName(), "select");
        Assert.assertEquals(optGroupOne.getAttribute("label"), "-----Advanced------");
    }

    public void clickOnCheckBox() {
        clickOnWebElement(commonWebElements.checkBox1);
    }

    public void assignButtonClick() {
        clickOnWebElement(commonWebElements.assignButtonLeft);
    }

    public String selectApplicatorFromPopUpWindow() {
        String applicatorText = getTextFromByElement(By.xpath(CommonConstants.APPLICATOR_COLUMN + "/td[2]"));
        clickOnByElement(By.xpath(CommonConstants.APPLICATOR_COLUMN + "/td[1]"));
        clickOnWebElement(commonWebElements.orderAssignOkButton);
        waitForPageTitleToBeAvailable(CommonConstants.SCHEDULE_PAGE);
        return applicatorText;
    }

    public void assignmentButtonClick(String applicator) {
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.equipmentTab, CommonConstants.EQUIPMENT_APPLICATORS_PAGE);
        clickOnByElement(By.xpath("//a[text()='" + applicator + "']/ancestor::tr[1]/td[2]/img/ancestor::tr[1]/td[1]/input[@class='equipmentDeleteCheckbox']"));
        clickOnDeleteEquipmentButton();
        AssertDeleteMessage();
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.scheduleTab, CommonConstants.SCHEDULE_PAGE);
        clickOnWebElement(commonWebElements.applicatorTab);
        clickOnByElement(By.xpath("//a[contains(text(),'" + applicator + "')]/preceding::a[@class='appStatus']/img/preceding::img[@class='appIconOffline']/preceding::button[@class='toggle expandAppList']"));
        clickOnByElement(By.xpath("//a[contains(text(),'" + applicator + "')]/preceding::a[@class='appStatus']/img/preceding::img[@class='appIconOffline']/preceding::input[@class='appChkBox']"));
    }

    public void AssertDeleteMessage() {
        String textDeleteAssignedOrders = getTextFromWebElement(assertDeleteEquipmentIfApplicatorHasAssignedOrders);
        if (textDeleteAssignedOrders.contains("orders")) {
            Assert.assertEquals(textDeleteAssignedOrders, CommonConstants.APPLICATOR_ORDER_DELETE_MESSAGE);
        } else {
            Assert.assertEquals(textDeleteAssignedOrders, CommonConstants.APPLICATOR_TENDER_DELETE_MESSAGE);
        }
    }

    public void changeAssignmentClick() {
        clickOnWebElement(commonWebElements.reAssignOrdersButton);
        waitForWebElement(unAssignRadio);
    }

    public void clickUnAssignApplicators() {
        clickOnWebElement(unAssignApplicators);
        while (!unAssignApplicators.isSelected()) {
            clickOnWebElement(unAssignApplicators);
        }
    }

    public void clickOrderAssignOk() {
        clickOnWebElement(commonWebElements.orderAssignOkButton);
        waitForPageTitleToBeAvailable(CommonConstants.SCHEDULE_PAGE);
    }

    public void clickONShowEquipmentTender() {
        clickOnWebElementAndWaitForPageToLoad(showEquipmentTender, CommonConstants.EQUIPMENT_UPDATE_APPLICATOR_PAGE);
    }

    public void unCheckAllTenders() {
        waitForByElement(By.xpath(CommonConstants.UNCHECK_TENDER_LIST));
        int size = BrowserConfiguration.driver.findElements(By.xpath(CommonConstants.UNCHECK_TENDER_LIST)).size();
        for (int l = 1; l <= size; l++) {
            if (BrowserConfiguration.driver.findElement(By.xpath(CommonConstants.UNCHECK_TENDER_LIST + "[" + l + "]/td[1]/input")).isSelected()) {
                clickOnByElement(By.xpath(CommonConstants.UNCHECK_TENDER_LIST + "[" + l + "]/td[1]/input"));
            }
        }
    }

    public void checkFirstTender() {
        clickOnWebElement(firstTenderClick);
    }

    public void clickOnSaveEquipmentEdit() {
        clickOnWebElementAndWaitForPageToLoad(saveEquipmentEditButton, CommonConstants.EQUIPMENT_APPLICATORS_PAGE);
    }

    public void clickOnEquipmentDeleteCheckbox() {
        clickOnWebElement(equipmentDeleteCheckbox);
    }

    public boolean isDeleteEquipmentButtonEnabled() {
        return deleteEquipmentsButton.isEnabled();
    }

    public void clickOnDeleteEquipmentButton() {
        clickOnWebElementAndWaitForPageToLoad(deleteEquipmentsButton, CommonConstants.EQUIPMENT_APPLICATORS_PAGE);
    }

    public void deleteApplicator(String applicatorName) {
        clickOnByElementAndWaitForPageToLoad(By.xpath("//*[contains(text(),'" + applicatorName + "')]"), CommonConstants.EQUIPMENT_UPDATE_APPLICATOR_PAGE);
        unCheckAllTenders();
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.submitTypeButton, CommonConstants.EQUIPMENT_APPLICATORS_PAGE);
        clickOnByElement(By.xpath("//*[contains(text(),'" + applicatorName + "')]//preceding::*[3]"));
        clickOnDeleteEquipmentButton();
        Assert.assertFalse(isElementPresent(By.xpath("//*[contains(text(),'" + applicatorName + "')]")));
    }

    public void clickOnEquipmentStatus() {
        clickOnWebElementAndWaitForPageToLoad(equipmentStatus, CommonConstants.EQUIPMENT_STATUS_PAGE);
        String redBackGroundText = redBackGround.getCssValue("background-color");
        if (redBackGroundText.equals("rgba(255, 69, 0, 1)")) {
            clickOnWebElement(redBackGround);
            handlingDynamicTable();
        }
    }

    public void verifyIsAdvancedValuesPresent(String[] inputTestDetails) {
        waitForByElement(By.xpath(CommonConstants.LICENCE_GROUP));
        List<WebElement> dropdownAdvancedValues = BrowserConfiguration.driver.findElements(By.xpath(CommonConstants.LICENCE_GROUP + "/option"));
        long phNumber = (long) (new Random().nextDouble() * 10000000000L);
        if (dropdownAdvancedValues.size() == 0) {
            clickOnWebElementAndWaitForPageToLoad(cancelButton, CommonConstants.EQUIPMENT_MOBILE_DEVICE_PAGE);
            clickOnWebElementAndWaitForPageToLoad(firstMobileNumber, CommonConstants.EQUIPMENT_UPDATE_MOBILE_DEVICE_PAGE);
            clickOnWebElement(activeCheckBox);
            Assert.assertTrue(isElementPresent(By.xpath(CommonConstants.LICENSE_TEXT)));
            Assert.assertTrue(phoneNumber.isEnabled());
            Assert.assertTrue(displayName.isEnabled());
            clickOnWebElementAndWaitForPageToLoad(saveClick, CommonConstants.EQUIPMENT_MOBILE_DEVICE_PAGE);
            clickOnWebElementAndWaitForPageToLoad(createMobileDeviceLink, CommonConstants.EQUIPMENT_CREATE_MOBILE_DEVICE_PAGE);
        }
        dropdownAdvancedValues = BrowserConfiguration.driver.findElements(By.xpath(CommonConstants.LICENCE_GROUP + "/option"));
        String licenseNumber = dropdownAdvancedValues.get(0).getText().replace(" ", "");
        clickOnWebElement(dropdownAdvancedValues.get(0));
        typeInputDetails(phoneNumber, Long.toString(phNumber));
        typeInputDetails(displayName, inputTestDetails[0]);
        clickOnWebElementAndWaitForPageToLoad(saveClick, CommonConstants.EQUIPMENT_MOBILE_DEVICE_PAGE);
        Assert.assertTrue(isElementPresent(By.xpath("//*[text()='" + licenseNumber + "']")));
    }
}