package com.deere.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SchedulePageObjects {

    @FindBy(xpath = "(//*[@class='wrapFormDiv'])[2]")
    protected WebElement CustomerName;

    @FindBy(xpath = "(.//*[@id='dropzone-Form']/div/span)[1]")
    protected WebElement ClickFirstElement;

    @FindBy(xpath = "//div[@id='orderInfo']")
    protected WebElement orderInfoWindow;

    @FindBy(xpath = ".//*[@id='buttons']/input[2]")
    protected WebElement ClickOrderEdit;

    @FindBy(xpath = "//table[@id='orderListTable']/tbody/tr[1]/td[1]/input")
    protected WebElement firstOrderCheckBox;

    @FindBy(how = How.XPATH, xpath = "//*[@id='farmName']/a[1]")
    protected WebElement farmName;

    @FindBy(xpath = "(//*[@class='wrapFormDiv'])[4]")
    protected WebElement fieldName;

    @FindBy(xpath = ".//td[@class='orderListCustomerRS'][contains(text(),'AutomationCustomer')]//preceding-sibling::*[3]")
    protected WebElement resultListFirstOrder;

    @FindBy(xpath = ".//td[@class='orderListFieldRS'][contains(text(),'fieldName')]//preceding-sibling::*[5]")
    protected WebElement resultListFirstfieldOrder;

    @FindBy(xpath = ".//td[@class='orderListFarmRS'][contains(text(),'farmName')]//preceding-sibling::*[4]")
    protected WebElement resultListFirstOrderFarm;

    @FindBy(xpath = "(//*[@class='dz-default dz-message'])[1]")
    protected WebElement orderFirstOrderId;

    @FindBy(xpath = ".//*[@id='expandAppListLink']/img")
    protected WebElement expandAllApplicatorsIcon;

    @FindBy(xpath = ".//*[@id='reassignTendersButton']")
    protected WebElement changeTendersAssignmentButton;

    @FindBy(xpath = ".//*[@id='productsInfo']/span")
    protected WebElement totalWorkHourSelected;

    @FindBy(xpath = " .//*[@id='ordersSelected']/p")
    protected WebElement orderSelected;

    @FindBy(xpath = " .//*[@id='printProductInfo']")
    protected WebElement printButton;

    @FindBy(xpath = ".//*[@class='orderTabSpan']")
    protected WebElement orderTab;

    @FindBy(xpath = "(.//*[@class='orderSelector'])[1]")
    protected WebElement assignFirstOrder;

    @FindBy(xpath = "(.//*[@id='appList']/li//table//td[starts-with(@class,'indicator')]/img[@alt='No Tender']/parent::td)/following-sibling::td")
    protected WebElement noTenderOrder;

    @FindBy(xpath = "//*[@src='../images/SMTruck.png']")
    protected WebElement assertOrderImagesIcon;

    @FindBy(how = How.XPATH, xpath = "//*[@id='orderNumber']/a")
    protected WebElement orderNumber;

    @FindBy(how = How.ID, id = "orderDetails")
    protected WebElement informationSubTab;

    @FindBy(how = How.ID, id = "orderDetailsContent")
    protected WebElement informationSubTabOpen;

    @FindBy(how = How.ID, id = "productList")
    protected WebElement productsSubTab;

    @FindBy(how = How.ID, id = "orderTasks")
    protected WebElement workRecordsSubTab;

    @FindBy(how = How.ID, id = "auditHist")
    protected WebElement auditHistorySubTab;

    @FindBy(how = How.ID, id = "orderTasksImg")
    protected WebElement workRecordsSubTabClosed;

    @FindBy(how = How.ID, id = "auditHistImg")
    protected WebElement auditHistorySubTabClosed;

    @FindBy(how = How.XPATH, xpath = "//*[@id='customerName']//a[1]")
    protected WebElement customerDetails;

    @FindBy(how = How.XPATH, xpath = "//*[@id='farmName']//a[1]")
    protected WebElement farmDetails;

    @FindBy(how = How.XPATH, xpath = "//*[@id='fieldName']//a[1]")
    protected WebElement fieldDetails;

    @FindBy(how = How.ID, using = "customerTab1")
    protected WebElement customerFarmFieldPage;

    @FindBy(how = How.ID, using = "locationAwareImpl.acres")
    protected WebElement areafield;

    @FindBy(how = How.ID, using = "locationAwareImpl.areaUom")
    protected WebElement acresDropDown;

    @FindBy(how = How.ID, using = "streetOne")
    protected WebElement streettextfield;

    @FindBy(how = How.ID, using = "city")
    protected WebElement cityfield;

    @FindBy(how = How.ID, using = "state")
    protected WebElement statefield;

    @FindBy(how = How.ID, using = "zip")
    protected WebElement zipfield;

    @FindBy(how = How.ID, using = "email")
    protected WebElement emailfield;

    @FindBy(how = How.ID, using = "textMsg")
    protected WebElement textMessagefield;

    @FindBy(how = How.ID, using = "phone")
    protected WebElement phonefield;

    @FindBy(how = How.ID, using = "entryPoint_lat")
    protected WebElement latitudefield;

    @FindBy(how = How.ID, using = "entryPoint_lon")
    protected WebElement longitudefield;

    @FindBy(xpath = ".//td[@class='orderListCustomerRS'][contains(text(),'AutomationCustomer')]")
    protected WebElement searchCustomerName;

    @FindBy(xpath = ".//td[@class='orderListFarmRS'][contains(text(),'farmName')]")
    protected WebElement searchFarmName;

    @FindBy(xpath = ".//td[@class='orderListFieldRS'][contains(text(),'fieldName')]")
    protected WebElement searchFieldName;

    @FindBy(xpath = "//*[@title='Hide All']")
    protected WebElement hideAllList;

    @FindBy(xpath = "(//input[starts-with(@id,'appCheckbox')])[1]")
    protected WebElement firstApplicator;

    @FindBy(xpath = "(//input[starts-with(@id,'appCheckbox')])[2]")
    protected WebElement secondApplicator;

    @FindBy(id = "tenderAssignOk")
    protected WebElement tenderAssignOkButton;

    @FindBy(xpath = ".//*[@id='resetFilterButton']")
    protected WebElement resetFilterButton;

    @FindBy(xpath = ".//*[@id='advancrSearchedFlag']/div")
    protected WebElement advancedFilterCustomerName;

    @FindBy(xpath = ".//*[@id='assignTenderButton']")
    protected WebElement assignTenderButton;

    @FindBy(xpath = "(.//*[@class='toggle expandAppList'])[1]")
    protected WebElement firstPlusCheckBox;

    @FindBy(xpath = "(.//*[@class='assignedOrderSelector'])[1]")
    protected WebElement firstAssignedOrderCheckBox;

    @FindBy(xpath = "(.//*[@class='orderListOrderNumberRS'])[1]")
    protected WebElement firstAssignedOrderNumber;

    @FindBy(xpath = "(.//*[@class='availableTenders'])[2]")
    protected WebElement secondTenderCheckBox;

    @FindBy(xpath = "(//*[contains(@id,'ValidApp')])[2]")
    protected WebElement secondApplicatorName;

    @FindBy(xpath = "(//*[contains(@id,'ValidTender')])[2]")
    protected WebElement secondTenderName;

    @FindBy(xpath = "//*[@id='ordersToDisplayForTenders']//td[last()]")
    protected WebElement getLastTenderAssigned;

    @FindBy(xpath = ".//*[@id='appDirectionsButton']")
    protected WebElement getDirectionButton;

    @FindBy(xpath = ".//*[@id='turnByturnDialog']/div[2]/div[2]/p")
    protected WebElement assertBottomPopUp;

    @FindBy(xpath = ".//*[@id='addSelectedButton']")
    protected WebElement addButton;

    @FindBy(xpath = ".//*[@id='removeSelectedButton']")
    protected WebElement removeSelectedButton;

    @FindBy(xpath = ".//*[@id='sourceList']/optgroup[1]/option[1]")
    protected WebElement option1;

    @FindBy(xpath = ".//*[@id='targetList']")
    protected WebElement targetList;

    @FindBy(xpath = "(//input[starts-with(@id,'checkbox')])[2]")
    protected WebElement checkBox2;

    @FindBy(xpath = ".//*[@id='product-total-btn-map']")
    protected WebElement mapProductTotalButton;

    @FindBy(xpath = ".//*[@id='map-controls-dialog']")
    protected WebElement assignPopup;

    @FindBy(xpath = ".//*[@class='ui-datepicker-trigger']")
    protected WebElement calenderpicker;

    @FindBy(xpath = ".//*[@class='ui-icon ui-icon-circle-triangle-w']")
    protected WebElement Previousmonth;

    @FindBy(xpath = ".//*[@class='ui-icon ui-icon-circle-triangle-e']")
    protected WebElement Nextmonth;

    @FindBy(xpath = ".//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[4]/a")
    protected WebElement selectdatecalenderpicker;

    @FindBy(xpath = ".//*[@id='orderRolloverButton']")
    protected WebElement orderrollover;

    @FindBy(xpath = ".//*[@id='rolloverRolloverRadio']")
    protected WebElement rolloverRadioButton;

    @FindBy(xpath = ".//*[@id='rolloverUnassignRadio']")
    protected WebElement rolloverUnassignRadio;

    @FindBy(xpath = ".//*[@id='rolloverCancel']")
    protected WebElement cancelOrderRolloverButton;

    @FindBy(xpath = ".//*[@class='assign-orders-btn-map assign-orders-map']")
    protected WebElement assignPopUp;

    @FindBy(xpath = "(.//*[@class='availableApplicators'])[1]")
    protected WebElement applicatorNameFirstCheckbox;

    @FindBy(xpath = "(.//*[@class='availableApplicators'])[2]")
    protected WebElement applicatorNameSecondCheckbox;

    @FindBy(xpath = ".//*[@id='ui_tpicker_hour_rollOverTime']")
    protected WebElement getHourSlider;

    @FindBy(xpath = ".//*[@id='ui-datepicker-div']/div[3]/button[2]")
    protected WebElement doneButton;

    @FindBy(xpath = ".//*[@id='scheduleDate']")
    protected WebElement scheduleStartDate;

    @FindBy(xpath = "//input[@value='Remove']")
    protected WebElement removeButton;
}