package com.deere.page_actions;

import com.deere.global.BrowserConfiguration;
import com.deere.global.CommonConstants;
import com.deere.global.CommonFunctions;
import com.deere.global.CommonWebElements;
import com.deere.page_objects.ManagementPageObjects;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.deere.global.CommonFunctions.*;

public class ManagementPageActions extends ManagementPageObjects {
    CommonWebElements commonWebElements = PageFactory.initElements(BrowserConfiguration.driver, CommonWebElements.class);

    private String enterName() {
        String locationName = "AutomationUser_" + generateRandomAlphaNumeric(7);
        typeInputDetails(nameTextBox, locationName);
        return locationName;
    }

    private String enterExternalId() {
        String ExternalID = "ExternalID_" + getRandomNumberInRange(1, 10000);
        typeInputDetails(externalIdTextBox, ExternalID);
        return ExternalID;
    }

    private void enterpestLicenseNum() {
        typeInputDetails(pestLicenseNumTextBox, String.valueOf(getRandomNumberInRange(1, 1000)));
    }

    private void enterstreetTextBox1() {
        typeInputDetails(streetTextBox1, RandomStringUtils.randomAlphabetic(10));
    }

    private void enterCity() {
        typeInputDetails(cityTextBox, RandomStringUtils.randomAlphabetic(7));
    }

    private void enterState() {
        typeInputDetails(stateTextBox, RandomStringUtils.randomAlphabetic(5));
    }

    private void enterZip() {
        typeInputDetails(zipTextBox, String.valueOf(getRandomNumberInRange(1, 1000)));
    }

    public void clickOnBackOfficeIntegrationOptionsTab() {
        clickOnWebElement(clickOnBackOfficeIntegrationOptionsTab);
    }

    public boolean assertPreserveFieldEntrances() {
        return PreserveFieldEntrances.isDisplayed();
    }

    public boolean assertPreserveEmail() {
        return PreserveEmail.isDisplayed();
    }

    public boolean assertPreservePhoneNumbers() {
        return PreservePhoneNumbers.isDisplayed();
    }

    public void clickOnUnitofMeasureOptions() {
        clickOnWebElement(clickOnUnitofMeasureOptions);
    }

    public String assertOrganizationDropDownStd() {
        return new Select(organizationDropDown).getFirstSelectedOption().getText();
    }

    public List<WebElement> orgnizationDropdown() {
        return new Select(organizationDropDown).getOptions();
    }

    public String assertAreaDropDownStd() {
        return new Select(areaDropDown).getFirstSelectedOption().getText();
    }

    public List<WebElement> areaDropdown() {
        return new Select(areaDropDown).getOptions();
    }

    public String assertdistanceDropDownStd() {
        return new Select(distanceDropDown).getFirstSelectedOption().getText();
    }

    public List<WebElement> distanceDropdown() {
        return new Select(distanceDropDown).getOptions();
    }

    public void selectcreateManualOrderCheckBox() {
        clickOnWebElement(createManualOrder);
        clickOnWebElementAndWaitForPageToLoad(saveButton, CommonConstants.ORGANIZATION_PAGE);
    }

    public boolean createOrderButton() {
        return waitForWebElement(commonWebElements.createOrderButton).isEnabled();
    }

    public boolean createManualOrderCheckBox() {
        if (!waitForWebElement(createManualOrder).isSelected()) {
            clickOnWebElement(createManualOrder);
        }
        return createManualOrder.isSelected();
    }

    public boolean assertOfflineIndicatiorField() {
        return waitForWebElement(assertOfflineIndicatorText).isDisplayed();
    }

    public void enterIndicatorFieldValue(String token) {
        typeInputDetails(assertOfflineIndicatorText, token);
    }

    public boolean assertOfflineIndicatorError() {
        waitForWebElement(assertOfflineIndicatorText).clear();
        clickOnWebElementAndWaitForPageToLoad(saveButton, CommonConstants.EDIT_PROGRAM_OPTIONS_PAGE);
        return (getTextFromWebElement(assertOfflineIndicatorError).contains(CommonConstants.VALID_NUMBER_ERROR));
    }

    public boolean assertAdvanceLicense() {
        return waitForWebElement(advanceLicense).isDisplayed();
    }

    public boolean assertBasicLicense() {
        return waitForWebElement(basicLicenses).isDisplayed();
    }

    public boolean assertAdvanceDemoLicense() {
        return waitForWebElement(advancedDemoLicenses).isDisplayed();
    }

    public boolean assertBasicDemoLicense() {
        return waitForWebElement(basicDemoLicenses).isDisplayed();
    }

    public String getHideStatusText() {
        return getTextFromWebElement(hideStatusesOlderThanText);
    }

    public boolean assertHideStatusIconCheckBox() {
        return waitForWebElement(hideStatusIconCheckBox).isSelected();
    }

    public void checkHideStatusCheckBox() {
        clickOnWebElementAndWaitForPageToLoad(hideStatusIconCheckBox, CommonConstants.EDIT_PROGRAM_OPTIONS_PAGE);
    }

    public boolean assertHideStatusIconsTimeTextBox() {
        return waitForWebElement(hideStatusIconsTimeTextBoxDisabled).isDisplayed();
    }

    public String getHideStatusIconsTimeTextBox() {
        return waitForWebElement(hideStatusIconsTimeTextBox).getAttribute("value");
    }

    public void clickOnSaveButton() {
        clickOnWebElementAndWaitForPageToLoad(saveButton, CommonConstants.ORGANIZATION_PAGE);
    }

    public void enterDriftWatchToken(String token) {
        typeInputDetails(driftWatchToken, token);
        waitForPageTitleToBeAvailable(CommonConstants.EDIT_PROGRAM_OPTIONS_PAGE);
    }

    public String invalidTokenError() {
        return getTextFromWebElement(invalidTokenError);
    }

    public void clickOnMapTab() {
        clickOnWebElement(mapTab);
    }

    public void clickOnDriftWatch() {
        clickOnWebElement(driftWatchCheckbox);
    }

    public boolean assertProximityCheckBox() {
        return waitForWebElement(proximityCheckBox).isDisplayed();
    }

    public void clickOnAreaCheckbox() {
        if (!waitForWebElement(areaCheckBox).isSelected()) {
            clickOnWebElementAndWaitForPageToLoad(areaCheckBox, CommonConstants.EDIT_PROGRAM_OPTIONS_PAGE);
        }
    }

    public void clickOnCropTypeCheckbox() {
        if (!waitForWebElement(cropTypeCheckBox).isSelected()) {
            clickOnWebElementAndWaitForPageToLoad(cropTypeCheckBox, CommonConstants.EDIT_PROGRAM_OPTIONS_PAGE);
        }
    }

    public void clickOnProductCheckbox() {
        if (!waitForWebElement(productCheckBox).isSelected()) {
            clickOnWebElementAndWaitForPageToLoad(productCheckBox, CommonConstants.EDIT_PROGRAM_OPTIONS_PAGE);
        }
    }

    public boolean assertAllTabs() {
        return waitForWebElement(assertAllColumns).isDisplayed();
    }

    public void clickOnApplicatorTab() {
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.applicatorTab, CommonConstants.SCHEDULE_PAGE);
    }

    public void clickOnTenderTab() {
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.tendersTab, CommonConstants.SCHEDULE_PAGE);
    }

    public void clickOnApplicatorExpandAllIcon() {
        clickOnWebElement(commonWebElements.expandAllList);
    }

    public void clickOnTenderExpandAllIcon() {
        clickOnWebElement(commonWebElements.tenderExpandAllList);
    }

    public boolean assertAreaText() {
        return isElementPresent(By.xpath("//td[contains(text(),'ac')][@class='orderListAcersRS']"));
    }

    public void clickOnEnableReviewCheckBox() {
        if (!waitForWebElement(enableReviewOrderCheckBox).isSelected()) {
            clickOnWebElement(enableReviewOrderCheckBox);
        }
    }

    public void clickOnFilterButton() {
        clickOnWebElement(commonWebElements.filterOrdersButton);
    }

    public void clickOnOpenStatusCheckBox() {
        if (waitForWebElement(commonWebElements.openStatusCheckBox).isSelected()) {
            clickOnWebElement(commonWebElements.openStatusCheckBox);
        }
    }

    public void clickOnAssignedStatusCheckBox() {
        if (waitForWebElement(commonWebElements.assignedStatusCheckBox).isSelected()) {
            clickOnWebElement(commonWebElements.assignedStatusCheckBox);
        }
    }

    public void clickOnOrderPopUpFilterButton() {
        clickOnWebElement(commonWebElements.orderFilterOkButton);
    }

    public boolean assertReviewedCheckBox() {
        return waitForWebElement(reviewedCheckBox).isDisplayed();
    }

    public void clickOnOrderPopUpClearFilterButton() {
        clickOnWebElement(commonWebElements.orderFilterClearButton);
    }

    public void clickOnOrderPopUpCloseFilterButton() {
        clickOnWebElement(orderPopUpCloseFilterButton);
    }

    public void orderSet() {
        clickOnWebElement(editProgramOptions);
        clickOnWebElement(orderOptions);
        if (!waitForWebElement(createManualOrder).isSelected()) {
            clickOnWebElement(createManualOrder);
            if (!waitForWebElement(autoGeneratedOrderNumber).isSelected()) {
                clickOnWebElement(autoGeneratedOrderNumber);
            }
        }
    }

    public void clearTheFieldGeneratedOrderNumber() {
        if (!waitForWebElement(createManualOrder).isSelected()) {
            clickOnWebElement(createManualOrder);
        }
        if (!waitForWebElement(autoGeneratedOrderNumber).isSelected()) {
            clickOnWebElement(autoGeneratedOrderNumber);
        }
    }

    public void setValueInTheField_generatedOrderNumber() {
        typeInputDetails(generateOrderNumberTextBox, "123");
    }

    public void clickOnTheSaveButton() {
        clickOnWebElement(saveButton);
    }

    public void addWebUser(String[] inputTestDetails) {
        clickOnWebElementAndWaitForPageToLoad(addWebUser, CommonConstants.ADD_EDIT_WEB_USER_PAGE);
        userDetails(inputTestDetails[0], inputTestDetails[1], inputTestDetails[2], inputTestDetails[3]);
    }

    private void userDetails(String userEmail, String userFirstName, String userLastName, String userPermissionSet) {
        typeInputDetails(webUserEmail, userEmail);
        typeInputDetails(webUserFirstName, userFirstName);
        typeInputDetails(webUseLastName, userLastName);
        new Select(dropdownDefaultPermissionSet).selectByValue(userPermissionSet);
        clickOnWebElement(commonWebElements.savButtonValue);
        clickOnWebElementAndWaitForPageToLoad(addWebUser, CommonConstants.ADD_EDIT_WEB_USER_PAGE);
    }

    public boolean assertdisplayGettingStartedCheckbox() {
        return displayGettingStartedCheckbox.isEnabled();
    }

    public boolean assertNotifyScheduleCheckBox() {
        return tenderNearDepotNotificationCheckbox.isEnabled();
    }

    public boolean assertNotifyCustomer() {
        return favClientWOCNotificationCheckbox.isEnabled();
    }

    public boolean assertMobileCheckbox() {
        return assetChangeNotificationCheckbox.isEnabled();
    }

    public void checkEditableFields() {
        Assert.assertNull(latitude.getAttribute("readonly"));
        Assert.assertNull(longitude.getAttribute("readonly"));
        Assert.assertNull(phone.getAttribute("readonly"));
        Assert.assertNull(contactName.getAttribute("readonly"));
        Assert.assertNull(contactEmail.getAttribute("readonly"));
    }

    public void checkMandatory() {
        Assert.assertTrue(getTextFromWebElement(latitudeMandatory).contains("*"));
        Assert.assertTrue(getTextFromWebElement(longitudeMandatory).contains("*"));
        Assert.assertTrue(getTextFromWebElement(phoneMandatory).contains("*"));
        Assert.assertTrue(getTextFromWebElement(contactNameMandatory).contains("*"));
        Assert.assertTrue(getTextFromWebElement(contactEmailMandatory).contains("*"));
        Assert.assertFalse(getTextFromWebElement(backOfficeNonMandatory).contains("*"));
    }

    public void checkBackOffice() {
        Assert.assertFalse(new Select(backOffice).getOptions().isEmpty());
    }

    public boolean assertSaveButtonForEditFirstRecord() {
        return commonWebElements.submitTypeButton.isEnabled() && commonWebElements.submitTypeButton.isDisplayed();
    }

    public boolean assertCancelButtonForEditFirstRecord() {
        return cancelButtonForEditFirstRecord.isEnabled() && cancelButtonForEditFirstRecord.isDisplayed();
    }

    public boolean assertEmailPresent() {
        return webUserEmail.getAttribute("value") != null;
    }

    public boolean assertFirstNamePresent() {
        return webUserFirstName.getAttribute("value") != null;
    }

    public boolean assertLastNamePresent() {
        return webUseLastName.getAttribute("value") != null;
    }

    public boolean assertUserNameEditable() {
        return ussrnameEditable.getText() != null;
    }

    public void regionDropDown() {
        new Select(BrowserConfiguration.driver.findElement(By.id("tagGroup"))).selectByVisibleText("NONE");
    }

    public void permissionDropDown() {
        new Select(dropdownDefaultPermissionSet).selectByVisibleText("Admin");
    }

    public boolean assertactiveButtonChecked() {
        return activeUsersCheckbox.isEnabled();
    }

    public void webUserEditFirstRecord() {
        clickOnWebElementAndWaitForPageToLoad(webUserEditFirstRecord, CommonConstants.ADD_EDIT_WEB_USER_PAGE);
    }

    public void navigateToManagementMenu() {
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.managementTab, CommonConstants.WEB_USERS_PAGE);
    }

    public void navigateToEditProgramOptionsTab() {
        clickOnWebElementAndWaitForPageToLoad(editProgramOptions, CommonConstants.EDIT_PROGRAM_OPTIONS_PAGE);
    }

    public void navigateToEditOrganizationTab() {
        clickOnWebElementAndWaitForPageToLoad(editOrganizationDetails, CommonConstants.EDIT_ORGANIZATION_PAGE);
    }

    public void navigateToOrganizationTab() {
        clickOnWebElementAndWaitForPageToLoad(organizationSubTab, CommonConstants.ORGANIZATION_PAGE);
    }

    private void navigateToSchedulePageOptionsMenu() {
        clickOnWebElementAndWaitForPageToLoad(schedulePageOption, CommonConstants.EDIT_PROGRAM_OPTIONS_PAGE);
    }

    private void navigateToOrderOptionsMenu() {
        clickOnWebElementAndWaitForPageToLoad(orderOptions, CommonConstants.EDIT_PROGRAM_OPTIONS_PAGE);
    }

    public void navigateToMobileUsersMenu() {
        clickOnWebElementAndWaitForPageToLoad(mobileUsersTab, CommonConstants.MOBILE_USERS_PAGE);
    }

    public void navigateToSchedulePageOptionsPage() {
        navigateToManagementMenu();
        navigateToOrganizationTab();
        navigateToEditProgramOptionsTab();
        navigateToSchedulePageOptionsMenu();
    }

    public void navigateToOrderOptionsPage() {
        navigateToManagementMenu();
        navigateToOrganizationTab();
        navigateToEditProgramOptionsTab();
        navigateToOrderOptionsMenu();
    }

    public void verifyOrderPopupPanel() {
        Assert.assertTrue(orderPopup.isDisplayed());
        Assert.assertTrue(orderPopupCheckboxArea.isDisplayed());
        Assert.assertFalse(displayQtyDensityRateCheckbox.isSelected());
    }

    public void verifyAutomatedRolloverCheckbox() {
        if (commonWebElements.rollOverSchedule.isSelected()) {
            automatedRolloverCheckbox();
        }
    }

    private void automatedRolloverCheckbox() {
        clickOnWebElement(commonWebElements.rollOverSchedule);
        clickOnWebElement(saveButton);
        clickOnWebElement(editProgramOptions);
        clickOnWebElement(schedulePageOption);
        Assert.assertFalse(commonWebElements.rollOverSchedule.isSelected());
    }

    public void verifyTimeFieldIsNonEditable() {
        Assert.assertFalse(commonWebElements.rollOverTime.isEnabled());
    }

    public void clickOnAdjustTimeLink() {
        clickOnWebElement(commonWebElements.rollOverSchedule);
        clickOnWebElement(adjustTimeLink);
    }

    public void setTime() {
        String timePopupVal = slideAndSetTime(commonWebElements.minuteRollOverTime.getSize().getWidth());
        clickOnWebElement(editProgramOptions);
        clickOnWebElement(schedulePageOption);
        compareRolloverTime(timePopupVal);
    }

    private String slideAndSetTime(int width) {
        Actions move = new Actions(BrowserConfiguration.driver);
        move.moveToElement(commonWebElements.minuteRollOverTime, ((width * 30) / 100), 0).click();
        move.build().perform();
        String timePopupVal = commonWebElements.timeRollOverTime.getText();
        clickOnWebElement(doneButton);
        clickOnWebElement(saveButton);
        return timePopupVal;
    }

    private void compareRolloverTime(String time) {
        Assert.assertEquals(time, commonWebElements.rollOverTime.getAttribute("value"));
    }

    public void checkUserExistsOrNot(String[] inputTestDetails) {
        String uname = ".//*[@id='edits']/table//td[contains(text(),'" + inputTestDetails[0] + "')]";
        if (isElementPresent(By.xpath(uname))) {
            clickOnByElement(By.xpath(uname + "//preceding-sibling::*[2]/input"));
            clickOnWebElement(deleteUserButton);
        }
    }

    public void clickOnAddMobileUserLink() {
        clickOnWebElementAndWaitForPageToLoad(addMobileUserLink, CommonConstants.ADD_EDIT_MOBILE_USER_PAGE);
    }

    public void checkActiveUserCheckboxStatus() {
        Assert.assertTrue(activeUsersCheckbox.isSelected());
    }

    public String[] createNewUser(String[] inputTestDetails) {
        String fName = "FirstName_" + generateRandomAlphaNumeric(7);
        String lName = "LastName_" + generateRandomAlphaNumeric(7);
        String uName = "UserName_" + generateRandomAlphaNumeric(7);
        typeInputDetails(webUserFirstName, fName);
        typeInputDetails(webUseLastName, lName);
        typeInputDetails(userName, uName);
        typeInputDetails(password, inputTestDetails[0]);
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.savButtonValue, CommonConstants.MOBILE_USERS_PAGE);
        return new String[]{uName, fName, lName};
    }

    public void verifyNewUserAddedToList(String[] userData) {
        Assert.assertEquals(getTextFromByElement(By.xpath("//td[text()='" + userData[0] + "']" +
                "/./following-sibling::td[1]")), userData[1] + " " + userData[2]);
    }

    public void clickOnLocationsTab() {
        clickOnWebElementAndWaitForPageToLoad(locationsTab, CommonConstants.LOCATIONS_PAGE);
    }

    public void clickOnAddLocation() {
        clickOnWebElementAndWaitForPageToLoad(addLocation, CommonConstants.ADD_EDIT_LOCATIONS_PAGE);
    }

    public void checkMandatoryFields() {
        typeInputDetails(nameTextBox, "");
        typeInputDetails(externalIdTextBox, "");
        clickOnWebElement(commonWebElements.saveButton);
        Assert.assertTrue(nameError.isDisplayed());
        Assert.assertTrue(extIdError.isDisplayed());
    }

    public void clickOnAddWebUser() {
        clickOnWebElementAndWaitForPageToLoad(addWebUser, CommonConstants.ADD_EDIT_WEB_USER_PAGE);
    }

    public void verifyAdminRoles() {
        List<WebElement> listWebElement = BrowserConfiguration.driver.findElements(By.xpath("//input[contains(@id,'ROLE_')]"));
        for (WebElement Element : listWebElement) {
            Assert.assertTrue(Element.isSelected() && !Element.isEnabled());
        }
    }

    public void verifyManagerRoles() {
        List<WebElement> listWebElement = BrowserConfiguration.driver.findElements(By.xpath("//input[contains(@id,'ROLE_')]"));
        for (WebElement Element : listWebElement) {
            if (Element.getAttribute("id").equals("ROLE_ORG_ADMIN") || Element.getAttribute("id").contains("ROLE_DELETE_USER") ||
                    Element.getAttribute("id").contains("ROLE_EDIT_USER") || Element.getAttribute("id").contains("ROLE_DELETE_DEPOT") ||
                    Element.getAttribute("id").contains("ROLE_EDIT_DEPOT") || Element.getAttribute("id").contains("ROLE_DELETE_TAG") ||
                    Element.getAttribute("id").contains("ROLE_EDIT_TAG")) {
                Assert.assertFalse(Element.isSelected() || Element.isEnabled());
            } else {
                Assert.assertTrue(Element.isSelected() && !Element.isEnabled());
            }
        }
    }

    public void verifySchedulerRoles() {
        List<WebElement> listWebElement = BrowserConfiguration.driver.findElements(By.xpath("//input[contains(@id,'ROLE_')]"));
        for (WebElement Element : listWebElement) {
            if (Element.getAttribute("id").equals("ROLE_ORG_ADMIN") || Element.getAttribute("id").contains("USER")
                    || Element.getAttribute("id").contains("DEPOT") || Element.getAttribute("id").contains("TAG")) {
                Assert.assertFalse(Element.isSelected() || Element.isEnabled());
            } else {
                Assert.assertTrue(Element.isSelected() && !Element.isEnabled());
            }
        }
    }

    public void createLocationAndVerify() {
        String locationName = enterName();
        String externalID = enterExternalId();
        enterpestLicenseNum();
        enterstreetTextBox1();
        enterCity();
        enterState();
        enterZip();
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.saveButton, CommonConstants.LOCATIONS_PAGE);
        Assert.assertEquals(getTextFromByElement(By.xpath("//td[text()='" + externalID + "']/./preceding-sibling::td[1]")), locationName);
    }

    public void clickOnOrganizationLink(String[] testDataFromExcel) {
        verifyTextAndCheckBoxOfMobilePage(testDataFromExcel);
        verifyForCheckboxToUnCheck();
        verifyFirstCheckbox();
    }

    private void verifyTextAndCheckBoxOfMobilePage(String[] testDataFromExcel) {
        List<String> testData = new ArrayList<>();
        testData.addAll(Arrays.asList(testDataFromExcel));
        waitForByElement(By.xpath(CommonConstants.FIELD_CONDITION_VALUE));
        List<WebElement> chkBoxList = BrowserConfiguration.driver.findElements(By.xpath(CommonConstants.FIELD_CONDITION_VALUE));
        for (int j = 0; j < chkBoxList.size() - 1; j++) {
            Assert.assertTrue(chkBoxList.get(j).getAttribute("value").equalsIgnoreCase(testData.get(j)) && chkBoxList.get(j).isEnabled());
        }
    }

    private void verifyForCheckboxToUnCheck() {
        ((JavascriptExecutor) BrowserConfiguration.driver).executeScript("window.scrollBy(0, 500)");
        waitForByElement(By.xpath(CommonConstants.FIELD_CONDITION_VALUE));
        List<WebElement> chkBoxList = BrowserConfiguration.driver.findElements(By.xpath(CommonConstants.FIELD_CONDITION_VALUE));
        for (WebElement aChkBoxList : chkBoxList) {
            if (!aChkBoxList.isSelected()) {
                clickOnWebElement(aChkBoxList);
            }
        }
        for (WebElement aChkBoxList1 : chkBoxList) {
            clickOnWebElementAndWaitForPageToLoad(aChkBoxList1, CommonConstants.EDIT_PROGRAM_OPTIONS_PAGE);
            Assert.assertTrue(!aChkBoxList1.isSelected());
        }
    }

    private void verifyFirstCheckbox() {
        ((JavascriptExecutor) BrowserConfiguration.driver).executeScript("window.scrollBy(0, 500)");
        waitForByElement(By.xpath(CommonConstants.FIELD_CONDITION_VALUE + "[1]"));
        List<WebElement> chkBoxList = BrowserConfiguration.driver.findElements(By.xpath(CommonConstants.FIELD_CONDITION_VALUE + "[1]"));
        for (WebElement aChkBoxList : chkBoxList) {
            clickOnWebElementAndWaitForPageToLoad(aChkBoxList, CommonConstants.EDIT_PROGRAM_OPTIONS_PAGE);
        }
        clickOnWebElementAndWaitForPageToLoad(saveButton, CommonConstants.ORGANIZATION_PAGE);
        navigateToEditProgramOptionsTab();
        CommonFunctions.testNavigate("Mobile Options", CommonConstants.EDIT_PROGRAM_OPTIONS_PAGE);
        ((JavascriptExecutor) BrowserConfiguration.driver).executeScript("window.scrollBy(0, 500)");
        waitForByElement(By.xpath(CommonConstants.FIELD_CONDITION_VALUE + "[1]"));
        List<WebElement> chkBoxList1 = BrowserConfiguration.driver.findElements(By.xpath(CommonConstants.FIELD_CONDITION_VALUE + "[1]"));
        for (WebElement aChkBoxList1 : chkBoxList1) {
            Assert.assertTrue(aChkBoxList1.isSelected());
        }
    }

    public void verifyAllCheckBoxChecked() {
        Assert.assertEquals(accessAllCheckBoxes.isSelected(), true);
    }

    public void verifyAllCheckBoxUnChecked() {
        Assert.assertEquals(accessAllCheckBoxes.isSelected(), false);
    }

    public void navigateToLocationsTab() {
        clickOnWebElementAndWaitForPageToLoad(locationsTab, CommonConstants.LOCATIONS_PAGE);
    }

    public void checkingAddLocationLink() {
        clickOnWebElementAndWaitForPageToLoad(addLocation, CommonConstants.ADD_EDIT_LOCATIONS_PAGE);
        clickOnWebElement(cancelButtonLocationTab);
        clickOnWebElementAndWaitForPageToLoad(editLink, CommonConstants.ADD_EDIT_LOCATIONS_PAGE);
    }

    public void verifyAllFieldsAndUpdateLocationTab() {
        createUpdateLocation();
        if (organizationAddressCheckBox.isSelected()) {
            verifyLocationAddressTextBoxDisabled();
        } else {
            clickOnWebElement(organizationAddressCheckBox);
            verifyLocationAddressTextBoxDisabled();
        }
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.saveButton, CommonConstants.LOCATIONS_PAGE);
        Assert.assertEquals(getTextFromWebElement(nameColumn), "Automation");
        Assert.assertEquals(getTextFromWebElement(externalIDcolumn), "Testing123");
    }

    private void createUpdateLocation() {
        typeInputDetails(nameTextBox, "Automation");
        typeInputDetails(externalIdTextBox, "Testing123");
        typeInputDetails(pestLicenseNumTextBox, "4789123");
    }

    private void verifyLocationAddressTextBoxDisabled() {
        Assert.assertEquals(streetTextBox1.isEnabled(), false);
        Assert.assertEquals(streetTextBox2.isEnabled(), false);
        Assert.assertEquals(cityTextBox.isEnabled(), false);
        Assert.assertEquals(stateTextBox.isEnabled(), false);
        Assert.assertEquals(zipTextBox.isEnabled(), false);
    }

    public void verifySalesFunctionalityFullAccess() {
        Assert.assertTrue(uploadOrdersCheckBox_FullAccess.isSelected());
        Assert.assertTrue(reportsCheckBox_FullAccess.isSelected());
        Assert.assertTrue(ordersCheckBox_FullAccess.isSelected());
    }

    public void verifySalesFunctionalityEditAccess() {
        Assert.assertTrue(ordersCheckBox_EditAccess.isSelected());
        Assert.assertTrue(cffCheckBox_EditAccess.isSelected());
    }

    public void verifySalesFunctionalityViewAccess() {
        for (int i = 6; i < 12; i++) {
            List<WebElement> allElements = BrowserConfiguration.driver.findElements(By.xpath("//*[@class='listTble']//tr[" + i + "]/td[4]/input"));
            Assert.assertTrue(allElements.get(0).isSelected());
        }
    }

    public void permissionDropDown(String str) {
        new Select(waitForWebElement(dropdownDefaultPermissionSet)).selectByVisibleText(str);
    }

    public List<String> assertWebUserTableCol() {
        List<String> colNames = new ArrayList<>();
        for (int numberOfCol = 1; numberOfCol <= 6; numberOfCol++) {
            colNames.add(getTextFromByElement(By.xpath("//div[@id='edits']/table/thead/tr/th[" + numberOfCol + "]")));
        }
        return colNames;
    }
}