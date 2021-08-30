package com.deere.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EquipmentPageObjects {

    @FindBy(xpath = ".//*[@id='pdaNumber1']/a")
    protected WebElement firstMobileNumber;

    @FindBy(xpath = "//span[contains(.,'Equipment Status')]")
    protected WebElement equipmentStatus;

    @FindBy(how = How.ID_OR_NAME, using = "equipment.name")
    protected WebElement applicatorNameTextBox;

    @FindBy(how = How.ID, using = "machineVin")
    protected WebElement myjdEquipmentDropdown;

    @FindBy(how = How.ID, using = "make")
    protected WebElement applicatorMakeTextBox;

    @FindBy(how = How.CLASS_NAME, using = "saveEquipmentEdit")
    protected WebElement saveEquipmentEditButton;

    @FindBy(how = How.ID, using = "submitTender")
    protected WebElement tenderSaveButton;

    @FindBy(how = How.CLASS_NAME, using = "cancelEquipmentEdit")
    protected WebElement cancelEquipmentButton;

    @FindBy(xpath = "(//input[@name='pdaDeleteCheckbox']/ancestor::tr[1]//*[contains(@id,'pdaNumber')]/a)[last()]")
    protected WebElement deactivatedMobileDevices;

    @FindBy(how = How.ID, using = "active")
    protected WebElement activeCheckBox;

    @FindBy(xpath = "//*[@class='licenseCountMessage'][contains(text(),'Advance licenses')]/."
            + "/following-sibling::div[1][contains(text(),'Basic licenses')]")
    protected WebElement licenses;

    @FindBy(xpath = "//*[@id='active'][@checked='checked']")
    protected WebElement disableTender;

    @FindBy(how = How.NAME, using = "associatedTenderIds")
    protected WebElement tenderIds;

    @FindBy(xpath = "//span[text()='Mobile Device']")
    protected WebElement mobileDeviceTab;

    @FindBy(xpath = "//a[text()='Create Mobile Device']")
    protected WebElement createMobileDeviceLink;

    @FindBy(xpath = ".//*[@id='license']")
    protected WebElement licenseDropDown;

    @FindBy(xpath = "//select[@id='license']/optgroup[1]")
    protected WebElement optGroupOne;

    @FindBy(id = "pda.number")
    protected WebElement phoneNumber;

    @FindBy(id = "pdaname")
    protected WebElement displayName;

    @FindBy(id = "submitPDA")
    protected WebElement saveClick;

    @FindBy(xpath = "//div[@class='errorText']/p")
    protected WebElement assertDeleteEquipmentIfApplicatorHasAssignedOrders;

    @FindBy(xpath = "//tbody/tr[2]/td[2]/input[@id='unassignRadio']")
    protected WebElement unAssignApplicators;

    @FindBy(xpath = "(//td[3]/a[@class='showEquipment'])[1]")
    protected WebElement showEquipmentTender;

    @FindBy(xpath = "//table[@class='listTble']/tbody/tr[1]/td[1]/input")
    protected WebElement firstTenderClick;

    @FindBy(xpath = "(//input[@class='equipmentDeleteCheckbox'])[1]")
    protected WebElement equipmentDeleteCheckbox;

    @FindBy(id = "deleteEquipmentsButton")
    protected WebElement deleteEquipmentsButton;

    @FindBy(xpath = "//input[@id='unassignRadio']")
    protected WebElement unAssignRadio;

    @FindBy(xpath = "//a[@class='redBackground']")
    protected WebElement redBackGround;

    @FindBy(xpath = "//input[@name='CANCEL']")
    protected WebElement cancelButton;
}