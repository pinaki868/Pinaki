package com.deere.page_objects;

import com.deere.global.CommonFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrderPageObjects {

    @FindBy(how = How.ID, using = "orderNumberQuery")
    protected WebElement advOrderNumberTextBox;

    @FindBy(how = How.XPATH, using = "//*[@id='orderList']/table/thead/tr[3]/th[1]")
    protected WebElement deleteText;

    @FindBy(xpath = ".//*[@id='pageContainer']//span[contains(text(),'Upload Orders')]")
    protected WebElement uploadOrders;

    @FindBy(xpath = ".//*[@id='file']")
    protected WebElement browse;

    @FindBy(how = How.ID, using = "COMPLETE")
    protected WebElement completeCheckBox;

    @FindBy(how = How.ID, using = "chck_all_print")
    protected WebElement checkAllPrintFieldTicketCheckBox;

    @FindBy(how = How.ID, using = "printFieldTicketButton")
    protected WebElement printFieldTicketButton;

    @FindBy(how = How.ID, using = "savePDFButton")
    protected WebElement SaveAsPDFButton;

    @FindBy(how = How.ID, using = "app")
    protected WebElement ApplicatorDropDown;

    @FindBy(how = How.ID, using = "crop")
    protected WebElement CropTextBox;

    @FindBy(how = How.ID, using = "product")
    protected WebElement ProductTextBox;

    @FindBy(how = How.ID, using = "odFrom")
    protected WebElement OrderedDateStartTextBox;

    @FindBy(how = How.ID, using = "sdFrom")
    protected WebElement ScheduledDateStartTextBox;

    @FindBy(how = How.ID, using = "cdFrom")
    protected WebElement CompletedDateStartTextBox;

    @FindBy(how = How.ID, using = "rdFrom")
    protected WebElement RequestedDateStartTextBox;

    @FindBy(xpath = ".//*[@id='onlyOrderNumberQuery']")
    protected WebElement OrderNumberTextBox1;

    @FindBy(how = How.ID, using = "tags")
    protected WebElement LocationSelectBox;

    @FindBy(how = How.ID, using = "ordernumber1")
    protected WebElement selectFirstOrder;

    @FindBy(how = How.ID, using = "new-customer")
    protected WebElement newCustomer;

    @FindBy(how = How.ID, using = "deleteOrdersButton")
    protected WebElement deleteOrderButton;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Manage Orders')]")
    protected WebElement manageOrders;

    @FindBy(how = How.ID, using = "filterByOrderNumberButton")
    protected WebElement orderSearchButton;

    @FindBy(xpath = ".//*[@id='apptype1']/img[2][@title='Batched Order']")
    protected WebElement batchedOrders;

    @FindBy(how = How.ID, using = "batchesImg")
    protected WebElement plusButtonBatches;

    @FindBy(how = How.ID, using = "productName1")
    protected WebElement product1;

    @FindBy(how = How.ID, using = "productName2")
    protected WebElement product2;

    @FindBy(how = How.ID, using = "productQuantity1")
    protected WebElement product1Quantity;

    @FindBy(how = How.ID, using = "productQuantity2")
    protected WebElement product2Quantity;

    @FindBy(how = How.ID, using = "batchesTable")
    protected WebElement batchTablePresent;

    protected final Integer randomno = CommonFunctions.getRandomNumberInRange(1, 1000);

    @FindBy(how = How.ID, using = "submit-product")
    protected WebElement addButton;

    @FindBy(how = How.XPATH, using = "//td[contains(@class,'orderNumbers')]")
    protected WebElement orderNumberOnProductTotal;

    @FindBy(xpath = "id('breadcrumbRadioButton')")
    protected WebElement BreadScrum;

    @FindBy(xpath = ".//*[@id='productQuantity']")
    protected WebElement Quantityvalue;

    @FindBy(xpath = ".//*[@id='productQuantityUOM']")
    protected WebElement Quantityunit;

    @FindBy(xpath = ".//*[@id='productDensity']")
    protected WebElement Densityvalue;

    @FindBy(xpath = ".//*[@id='productDensityUOM']")
    protected WebElement Densityunit;

    @FindBy(xpath = ".//*[@id='productRate']")
    protected WebElement Ratevalue;

    @FindBy(xpath = ".//*[@id='productRateUOM']")
    protected WebElement Rateunit;

    @FindBy(xpath = "//li[contains(@style,'display: list-item;')]")
    protected WebElement addProductSection;

    @FindBy(xpath = ".//*[@id='FarmName-new']")
    protected WebElement farmNameEnter;

    @FindBy(xpath = ".//*[@id='FieldName-new']")
    protected WebElement fieldNameEnter;

    @FindBy(xpath = ".//*[@id='FieldId']")
    protected WebElement fieldIdEnter;

    @FindBy(how = How.XPATH, using = "//td[contains(@id,'status1')]")
    protected WebElement FirstOrder;

    @FindBy(how = How.XPATH, using = "(.//*[@name='orderDeleteCheckbox'])[1]")
    protected WebElement FirstDeleteOrder;

    @FindBy(xpath = ".//a[contains(text(),'legend')]")
    protected WebElement Legend_Link;

    @FindBy(how = How.XPATH, using = "//td[@class='frmlabel'][contains(text(),'Number of Batches:')]")
    protected WebElement NumberOfBatchesColumn;

    @FindBy(how = How.XPATH, using = "//div[@id='batchesContent']//table[@id='batchesTable']//tbody[@class='stripeProducts']//tr[1]//td[3]//p[1]")
    protected WebElement batchProduct1Quantity1;

    @FindBy(how = How.XPATH, using = "//div[@id='batchesContent']//table[@id='batchesTable']//tbody[@class='stripeProducts']//tr[2]//td[3]//p[1]")
    protected WebElement batchProduct1Quantity2;

    @FindBy(how = How.XPATH, using = "//div[@id='batchesContent']//table[@id='batchesTable']//tbody[@class='stripeProducts']//tr[1]//td[3]//p[2]")
    protected WebElement batchProduct2Quantity1;

    @FindBy(how = How.XPATH, using = "//div[@id='batchesContent']//table[@id='batchesTable']//tbody[@class='stripeProducts']//tr[2]//td[3]//p[2]")
    protected WebElement batchProduct2Quantity2;

    @FindBy(xpath = "//*[@id='orderList']//tr/td[3]")
    protected WebElement getCustomerName;

    @FindBy(xpath = "//div[@id='orderList']//tr[1]//input[contains(@class,'productTotalCheckbox')]")
    protected WebElement productTotalCheckBox;
}