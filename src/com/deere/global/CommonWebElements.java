package com.deere.global;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CommonWebElements {

    @FindBy(linkText = "Home")
    public WebElement homeTab;

    @FindBy(linkText = "Schedule")
    public WebElement scheduleTab;

    @FindBy(linkText = "Orders")
    public WebElement ordersTab;

    @FindBy(linkText = "Customer/Farm/Field")
    public WebElement customerFarmFieldTab;

    @FindBy(linkText = "Equipment")
    public WebElement equipmentTab;

    @FindBy(linkText = "Management")
    public WebElement managementTab;

    @FindBy(linkText = "Reports")
    public WebElement reportsTab;

    @FindBy(xpath = "//a[@class='orderTabSpan']")
    public WebElement ordersSubTab;

    @FindBy(linkText = "Applicators")
    public WebElement applicatorTab;

    @FindBy(linkText = "Tenders")
    public WebElement tendersTab;

    @FindBy(xpath = "//*[@id='save']")
    public WebElement saveButtonID;

    @FindBy(xpath = "//*[@id='save-order']")
    public WebElement saveOrderButton;

    @FindBy(how = How.ID, using = "saveButton")
    public WebElement saveButton;

    @FindBy(xpath = "//input[@value='Save']")
    public WebElement savButtonValue;

    @FindBy(xpath = "//*[@id='assignOrdersButton']")
    public WebElement assignOrdersButton;

    @FindBy(xpath = ".//*[@id='reassignOrdersButton']")
    public WebElement reAssignOrdersButton;

    @FindBy(xpath = ".//*[@id='orderFilterOk']")
    public WebElement orderFilterOkButton;

    @FindBy(xpath = ".//*[@id='filterOrdersButton']")
    public WebElement filterOrdersButton;

    @FindBy(xpath = "//*[@id='orderAssignOk']")
    public WebElement orderAssignOkButton;

    @FindBy(xpath = ".//*[@id='createOrder']")
    public WebElement createOrderButton;

    @FindBy(how = How.ID, using = "customer-done")
    public WebElement customerDoneButton;

    @FindBy(xpath = "//*[@id='order.orderNumber']")
    public WebElement orderNumber;

    @FindBy(xpath = ".//*[@id='CustomerName']")
    public WebElement textCustomerName;

    @FindBy(how = How.ID, id = "customerName")
    public WebElement customerName;

    @FindBy(xpath = ".//*[@id='FarmName']")
    public WebElement txtFarmName;

    @FindBy(how = How.ID, id = "farmName")
    public WebElement farmName;

    @FindBy(xpath = ".//*[@id='WorkOrderAcres']")
    public WebElement workOrderAcres;

    @FindBy(xpath = ".//*[@id='add-products']")
    public WebElement addProductsButton;

    @FindBy(xpath = ".//*[@id='productName']")
    public WebElement productName;

    @FindBy(xpath = ".//*[@id='CustomerId']")
    public WebElement customerId;

    @FindBy(xpath = ".//*[@id='FarmId']")
    public WebElement farmId;

    @FindBy(how = How.ID, id = "fieldName")
    public WebElement fieldName;

    @FindBy(how = How.ID, id = "submit-filter")
    public WebElement submitFilterButton;

    @FindBy(how = How.ID, id = "msgId")
    public WebElement msgID;

    @FindBy(how = How.ID, id = "locationAwareImpl.name")
    public WebElement nameField;

    @FindBy(how = How.ID, id = "locationAwareImpl.externalId")
    public WebElement externalIdField;

    @FindBy(xpath = ".//*[@id='attachmentFileInput']")
    public WebElement browseButton;

    @FindBy(how = How.ID, id = "submitButton")
    public WebElement submitButton;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement submitTypeButton;

    @FindBy(xpath = ".//*[@id='map-controls-dialog']/p/button[1]")
    public WebElement assignButtonLeft;

    @FindBy(xpath = "(//input[starts-with(@id,'checkbox')])[1]")
    public WebElement checkBox1;

    @FindBy(xpath = ".//*[@id='rollOverSchedule']")
    public WebElement rollOverSchedule;

    @FindBy(xpath = ".//*[@id='rollOverTime']")
    public WebElement rollOverTime;

    @FindBy(xpath = ".//*[@id='ui_tpicker_time_rollOverTime']")
    public WebElement timeRollOverTime;

    @FindBy(xpath = ".//*[@id='ui_tpicker_minute_rollOverTime']")
    public WebElement minuteRollOverTime;

    @FindBy(xpath = "//*[@title='Show All']")
    public WebElement expandAllList;

    @FindBy(how = How.ID, using = "expandTenderListLink")
    public WebElement tenderExpandAllList;

    @FindBy(how = How.ID, using = "OPEN")
    public WebElement openStatusCheckBox;

    @FindBy(how = How.ID, using = "INPROCESS")
    public WebElement assignedStatusCheckBox;

    @FindBy(how = How.ID, using = "orderFilterClear")
    public WebElement orderFilterClearButton;

    @FindBy(how = How.ID, using = "searchText")
    public WebElement searchTextBox;

    @FindBy(xpath = "//input[contains(@id,'productTotal')]")
    public WebElement productTotalButton;

    @FindBy(how = How.ID, using = "productListImg")
    public WebElement productList;


}