package com.deere.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ManagementPageObjects {

    @FindBy(xpath = "//*[contains(text(),'Reviewed')]/input[@id='chck_all_review']")
    protected WebElement reviewedCheckBox;

    @FindBy(xpath = "//span[text()='Locations']")
    protected WebElement locationsTab;

    @FindBy(xpath = "//span[text()='Mobile Users']")
    protected WebElement mobileUsersTab;

    @FindBy(xpath = "//a[text()='AddLocation']")
    protected WebElement addLocation;

    @FindBy(how = How.ID, using = "name")
    protected WebElement nameTextBox;

    @FindBy(how = How.ID, using = "externalId")
    protected WebElement externalIdTextBox;

    @FindBy(how = How.ID, using = "nameError")
    protected WebElement nameError;

    @FindBy(how = How.ID, using = "extIdError")
    protected WebElement extIdError;

    @FindBy(how = How.ID, using = "pestLicenseNum")
    protected WebElement pestLicenseNumTextBox;

    @FindBy(how = How.ID, using = "street")
    protected WebElement streetTextBox1;

    @FindBy(how = How.ID, using = "street2")
    protected WebElement streetTextBox2;

    @FindBy(how = How.ID, using = "city")
    protected WebElement cityTextBox;

    @FindBy(how = How.ID, using = "state")
    protected WebElement stateTextBox;

    @FindBy(how = How.ID, using = "zip")
    protected WebElement zipTextBox;

    @FindBy(xpath = ".//*[@id='defaultRoleSelector']")
    protected WebElement dropdownDefaultPermissionSet;

    @FindBy(xpath = "//a/span[text()='Organization']")
    protected WebElement organizationSubTab;

    @FindBy(how = How.ID, using = "editProgOption")
    protected WebElement editProgramOptions;

    @FindBy(how = How.ID, using = "editOrg")
    protected WebElement editOrganizationDetails;

    @FindBy(xpath = ".//*[@id='programOptions']//a[contains(text(),'Schedule Page Options')]")
    protected WebElement schedulePageOption;

    @FindBy(xpath = ".//*[@id='programOptions']//a[contains(text(),'Order Options')]")
    protected WebElement orderOptions;

    @FindBy(xpath = ".//*[@id='visibleColumns']/legend[contains(text(),'Order Popup')]")
    protected WebElement orderPopup;

    @FindBy(xpath = ".//*[@id='visibleColumns']//label[contains(text(),'Display')]")
    protected WebElement orderPopupCheckboxArea;

    @FindBy(xpath = ".//*[@id='displayAdjustedQuantityRate1']")
    protected WebElement displayQtyDensityRateCheckbox;

    @FindBy(xpath = ".//*[@id='rollOverTimeLink']")
    protected WebElement adjustTimeLink;

    @FindBy(xpath = ".//*[@id='ui-datepicker-div']//div/button[contains(text(),'Done')]")
    protected WebElement doneButton;

    @FindBy(xpath = ".//*[@id='container']/a")
    protected WebElement addMobileUserLink;

    @FindBy(xpath = ".//*[@id='enabledCheckbox']")
    protected WebElement activeUsersCheckbox;

    @FindBy(xpath = ".//*[@id='user.username']")
    protected WebElement userName;

    @FindBy(xpath = ".//*[@id='user.password']")
    protected WebElement password;

    @FindBy(xpath = ".//*[@id='deleteUsersButton']")
    protected WebElement deleteUserButton;

    @FindBy(xpath = ".//*[@id='userForm']/table/tbody/tr[2]/td[1]/label[2]")
    protected WebElement ussrnameEditable;

    @FindBy(xpath = ".//*[@id='user.email']")
    protected WebElement webUserEmail;

    @FindBy(xpath = ".//*[@id='user.firstName']")
    protected WebElement webUserFirstName;

    @FindBy(xpath = ".//*[@id='user.lastName']")
    protected WebElement webUseLastName;

    @FindBy(xpath = ".//*[@id='cancelUserEdit']")
    protected WebElement cancelButtonForEditFirstRecord;

    @FindBy(xpath = ".//*[@id='locationLat']")
    protected WebElement latitude;

    @FindBy(xpath = "(//*[@class='labelFixWd'])[1]")
    protected WebElement latitudeMandatory;

    @FindBy(xpath = ".//*[@id='locationLon']")
    protected WebElement longitude;

    @FindBy(xpath = "(//*[@class='labelFixWd'])[2]")
    protected WebElement longitudeMandatory;

    @FindBy(xpath = ".//*[@id='phone']")
    protected WebElement phone;

    @FindBy(xpath = "(//*[@class='labelFixWd'])[4]")
    protected WebElement phoneMandatory;

    @FindBy(xpath = ".//*[@id='contactName']")
    protected WebElement contactName;

    @FindBy(xpath = "(//*[@class='labelFixWd'])[5]")
    protected WebElement contactNameMandatory;

    @FindBy(xpath = ".//*[@id='contactEmail']")
    protected WebElement contactEmail;

    @FindBy(xpath = "(//*[@class='labelFixWd'])[6]")
    protected WebElement contactEmailMandatory;

    @FindBy(xpath = "(//*[@class='labelFixWdNoAsterick'])[10]")
    protected WebElement backOfficeNonMandatory;

    @FindBy(xpath = ".//*[@id='backOfficeName']")
    protected WebElement backOffice;

    @FindBy(xpath = ".//*[@class='addButton']")
    protected WebElement addWebUser;

    @FindBy(xpath = ".//*[@id='displayGettingStartedCheckbox']")
    protected WebElement displayGettingStartedCheckbox;

    @FindBy(xpath = ".//*[@id='tenderNearDepotNotificationCheckbox']")
    protected WebElement tenderNearDepotNotificationCheckbox;

    @FindBy(xpath = ".//*[@id='assetChangeNotificationCheckbox']")
    protected WebElement assetChangeNotificationCheckbox;

    @FindBy(xpath = ".//*[@id='favClientWOCNotificationCheckbox']")
    protected WebElement favClientWOCNotificationCheckbox;

    @FindBy(xpath = "//table//label[text()='Advanced Licenses']/../table[2]//th[text()='#']/.."
            + "/th[contains(text(),'License Number')]/../th[text()='Order Number']/../th[text()='Order Date']")
    protected WebElement advanceLicense;

    @FindBy(xpath = "//table//label[text()='Basic Licenses']/../table[3]//th[text()='#']/.."
            + "/th[contains(text(),'License Number')]/../th[text()='Order Number']/../th[text()='Order Date']")
    protected WebElement basicLicenses;

    @FindBy(xpath = "//table//label[text()='Advanced Demo Licenses']/../table[4]//th[text()='#']/.."
            + "/th[contains(text(),'License Number')]/../th[text()='Order Number']/../th[text()='Expire Date']")
    protected WebElement advancedDemoLicenses;

    @FindBy(xpath = "//table//label[text()='Bas" +
            "ic Demo Licenses']/../table[5]//th[text()='#']/.."
            + "/th[contains(text(),'License Number')]/../th[text()='Order Number']/../th[text()='Expire Date']")
    protected WebElement basicDemoLicenses;

    @FindBy(xpath = "//*[@id='statusIcons']//li[1]")
    protected WebElement hideStatusesOlderThanText;

    @FindBy(xpath = "//input[@name='hideStatusIcons']")
    protected WebElement hideStatusIconCheckBox;

    @FindBy(xpath = "//input[@name='hideStatusIconsTime'][@disabled]")
    protected WebElement hideStatusIconsTimeTextBoxDisabled;

    @FindBy(xpath = "//input[@name='hideStatusIconsTime']")
    protected WebElement hideStatusIconsTimeTextBox;

    @FindBy(how = How.ID, using = "saveOptions")
    protected WebElement saveButton;

    @FindBy(how = How.ID, using = "driftWatchToken")
    protected WebElement driftWatchToken;

    @FindBy(how = How.ID, using = "driftWatchToken.errors")
    protected WebElement invalidTokenError;

    @FindBy(xpath = "//span[text()='Map']")
    protected WebElement mapTab;

    @FindBy(how = How.ID, using = "sensitiveCropEnabled")
    protected WebElement driftWatchCheckbox;

    @FindBy(xpath = "//input[@id='releventSensitiveCropFilter']/..")
    protected WebElement proximityCheckBox;

    @FindBy(xpath = "//*[text()='Column Visibility']/..//label[text()='Area']/..//*[@id='displayAcres1']")
    protected WebElement areaCheckBox;

    @FindBy(xpath = "//*[text()='Column Visibility']/..//label[text()='Crop Type']/..//*[@id='displayCropType1']")
    protected WebElement cropTypeCheckBox;

    @FindBy(xpath = "//*[text()='Column Visibility']/..//label[text()='Product']/..//*[@id='displayProduct1']")
    protected WebElement productCheckBox;

    @FindBy(xpath = "//a[@id='prd.name']/ancestor::tr[1]//a[@id='area']/ancestor::tr[1]//a[@id='crop']")
    protected WebElement assertAllColumns;

    @FindBy(xpath = "//input[@id='reviewOrder']")
    protected WebElement enableReviewOrderCheckBox;

    @FindBy(how = How.ID, using = "orderFilterCancel")
    protected WebElement orderPopUpCloseFilterButton;

    @FindBy(xpath = "//input[@id='offlineIndicator']")
    protected WebElement assertOfflineIndicatorText;

    @FindBy(xpath = ".//*[@id='offlineIndicator.errors']")
    protected WebElement assertOfflineIndicatorError;

    @FindBy(xpath = "(.//*[@class='showEquipment'])[1]")
    protected WebElement webUserEditFirstRecord;

    @FindBy(xpath = ".//*[@id='preserveEntryPoint']")
    protected WebElement PreserveFieldEntrances;

    @FindBy(xpath = ".//*[@id='preserveEmail']")
    protected WebElement PreserveEmail;

    @FindBy(xpath = ".//*[@id='preservePhone']")
    protected WebElement PreservePhoneNumbers;

    @FindBy(xpath = ".//*[@id='uomOptionsSpan']")
    protected WebElement clickOnUnitofMeasureOptions;

    @FindBy(xpath = ".//*[@id='systemOfMeasurement']")
    protected WebElement organizationDropDown;

    @FindBy(xpath = ".//*[@id='area']")
    protected WebElement areaDropDown;

    @FindBy(xpath = ".//*[@id='distance']")
    protected WebElement distanceDropDown;

    @FindBy(xpath = ".//*[@id='programOptions']/div/h3[7]/span")
    protected WebElement clickOnBackOfficeIntegrationOptionsTab;

    @FindBy(linkText = "Edit")
    protected WebElement editLink;

    @FindBy(how = How.ID, using = "useOrgAddress")
    protected WebElement organizationAddressCheckBox;

    @FindBy(xpath = "//*[@id='tagForm']/input[3]")
    protected WebElement cancelButtonLocationTab;

    @FindBy(how = How.CLASS_NAME, using = "roleCheckbox")
    protected WebElement accessAllCheckBoxes;

    @FindBy(xpath = "//*[@id='edits']/table/tbody/tr[1]/td[2]")
    protected WebElement nameColumn;

    @FindBy(xpath = "//*[@id='edits']/table/tbody/tr[1]/td[3]")
    protected WebElement externalIDcolumn;

    @FindBy(how = How.ID, using = "ROLE_UPLOAD_ORDER")
    protected WebElement uploadOrdersCheckBox_FullAccess;

    @FindBy(how = How.ID, using = "ROLE_VIEW_REPORT")
    protected WebElement reportsCheckBox_FullAccess;

    @FindBy(how = How.ID, using = "ROLE_DELETE_ORDER")
    protected WebElement ordersCheckBox_FullAccess;

    @FindBy(how = How.ID, using = "ROLE_EDIT_ORDER")
    protected WebElement ordersCheckBox_EditAccess;

    @FindBy(how = How.ID, using = "ROLE_EDIT_FIELD")
    protected WebElement cffCheckBox_EditAccess;

    @FindBy(xpath = ".//*[@id='createManualOrder']")
    protected WebElement createManualOrder;

    @FindBy(how = How.ID_OR_NAME, using = "autoGenerateOrderNumber")
    protected WebElement autoGeneratedOrderNumber;

    @FindBy(how = How.ID_OR_NAME, using = "generatedOrderNumber")
    protected WebElement generateOrderNumberTextBox;
}