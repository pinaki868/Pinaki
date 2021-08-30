package com.deere.page_actions;

import com.deere.global.BrowserConfiguration;
import com.deere.global.CommonConstants;
import com.deere.global.CommonWebElements;
import com.deere.page_objects.OrderPageObjects;
import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

import static com.deere.global.CommonFunctions.*;
import static org.testng.Assert.assertEquals;

public class OrderPageActions extends OrderPageObjects {
    CommonWebElements commonWebElements = PageFactory.initElements(BrowserConfiguration.driver, CommonWebElements.class);

    public void navigateToOrdersMenu() {
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.ordersTab, CommonConstants.MANAGE_ORDERS_PAGE);
    }

    public void clickAdvanceFilterButton() {
        clickOnWebElement(commonWebElements.filterOrdersButton);
    }

    public void clickOrderFilterOkButton() {
        clickOnWebElement(commonWebElements.orderFilterOkButton);
        waitForPageTitleToBeAvailable(CommonConstants.MANAGE_ORDERS_PAGE);
    }

    public void clickOpenCheckBox() {
        if (waitForWebElement(commonWebElements.openStatusCheckBox).isSelected())
            clickOnWebElement(commonWebElements.openStatusCheckBox);
    }

    public void clickAssignedCheckBox() {
        if (waitForWebElement(commonWebElements.assignedStatusCheckBox).isSelected())
            clickOnWebElement(commonWebElements.assignedStatusCheckBox);
    }

    public boolean isCompleteCheckBoxChecked() {
        return completeCheckBox.isSelected();
    }

    public void isBatchedOrderDisplayed() {
        Assert.assertTrue(batchedOrders.isDisplayed());
    }

    public void isBatchColumnPresent() {
        Assert.assertTrue(NumberOfBatchesColumn.isDisplayed());
    }

    public void isBatchTablePresent() {
        clickOnWebElement(plusButtonBatches);
        Assert.assertTrue(batchTablePresent.isDisplayed());
    }

    public void isProductsPresent() {
        clickOnWebElement(commonWebElements.productList);
        Assert.assertTrue(product1.isDisplayed());
        Assert.assertTrue(product2.isDisplayed());
    }

    private int getBatchProduct1Quantity() {
        int quantity1 = Integer.valueOf(batchProduct1Quantity1.getText().substring(10, 13).trim());
        int quantity2 = Integer.valueOf(batchProduct1Quantity2.getText().substring(10, 13).trim());
        return quantity1 + quantity2;
    }

    public void verifyProduct1QuantityWithBatchQuantity() {
        int productQuantity = Integer.valueOf(product1Quantity.getText().substring(0, 2).trim());
        Assert.assertEquals(productQuantity, getBatchProduct1Quantity());
    }

    private int getBatchProduct2Quantity() {
        int quantity1 = Integer.valueOf(batchProduct2Quantity1.getText().substring(10, 13).trim());
        int quantity2 = Integer.valueOf(batchProduct2Quantity2.getText().substring(10, 13).trim());
        return quantity1 + quantity2;
    }

    public void verifyProduct2QuantityWithBatchQuantity() {
        int productQuantity = Integer.valueOf(product2Quantity.getText().substring(0, 2).trim());
        Assert.assertEquals(productQuantity, getBatchProduct2Quantity());
    }

    public String selectApplicatorDropDown() {
        Select select = new Select(ApplicatorDropDown);
        select.selectByIndex(1);
        return select.getFirstSelectedOption().getText();
    }

    public void setCustomerNameTextBox(String CustomerName) {
        typeInputDetailsWithOutCheckingVisibility(commonWebElements.customerName, CustomerName);
    }

    public void setOrderNumberTextBox(String orderNumber) {
        typeInputDetails(OrderNumberTextBox1, orderNumber);
    }

    public void clickCheckAllPrintFieldTicketCheckBox() {
        clickOnWebElement(checkAllPrintFieldTicketCheckBox);
    }

    public void clickOrderSearchButton() {
        clickOnWebElementAndWaitForPageToLoad(orderSearchButton, CommonConstants.MANAGE_ORDERS_PAGE);
    }

    public void clickManageOrder() {
        clickOnWebElementAndWaitForPageToLoad(manageOrders, CommonConstants.MANAGE_ORDERS_PAGE);
    }

    public void matchOrders(String orderNumber) {
        Assert.assertEquals(getTextFromWebElement(selectFirstOrder), orderNumber);
    }

    public boolean searchResultForCompleteOrder() {
        return getTextFromWebElement(FirstOrder).equalsIgnoreCase("Complete");
    }

    public void clickLegendLink() {
        clickOnWebElement(Legend_Link);
    }

    public void multipleLegendTypes() {
        waitForByElement(By.className("tdAlignleft"));
        List<WebElement> DescriptionList = BrowserConfiguration.driver.findElements(By.className("tdAlignleft"));
        assertEquals(DescriptionList.get(0).getText(), "Description");
        assertEquals(DescriptionList.get(1).getText(), "Attachment");
        assertEquals(DescriptionList.get(2).getText(), "Documentation");
        assertEquals(DescriptionList.get(3).getText(), "Liquid Order");
        assertEquals(DescriptionList.get(4).getText(), "Dry Order");
        assertEquals(DescriptionList.get(5).getText(), "Gas Order");
        assertEquals(DescriptionList.get(6).getText(), "Batched Order");
    }

    public void clickUploadOrders() {
        clickOnWebElementAndWaitForPageToLoad(uploadOrders, CommonConstants.UPLOAD_ORDERS_PAGE);
    }

    public void browseFile() {
        waitForWebElement(browse).sendKeys(CommonConstants.FILE_UPLOAD_DIRECTORY + "uploadOrders.csv");
    }

    public void clickUpload() {
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.submitButton, CommonConstants.UPLOAD_ORDERS_PAGE);
        Assert.assertTrue(isElementPresent(By.xpath(CommonConstants.UPLOAD_SUCCESS_MESSAGE)));
        //Assert.assertFalse(isElementPresent(By.xpath(CommonConstants.UPLOAD_ERROR_CLASS)));
    }

    public boolean verifyPrintFieldTicketButton() {
        return printFieldTicketButton.isEnabled() && printFieldTicketButton.isDisplayed();
    }

    public void clickAndVerifyFieldTicketPage() {
        switchToNextWindow(printFieldTicketButton, CommonConstants.FIELD_TICKET_PAGE);
        Assert.assertTrue(BrowserConfiguration.driver.getTitle().contains(CommonConstants.FIELD_TICKET_PAGE));
        Assert.assertTrue(waitForWebElement(BreadScrum).isDisplayed());
        clickOnWebElement(SaveAsPDFButton);
    }

    public void createManualOrder() {
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.createOrderButton, CommonConstants.CREATE_ORDER_PAGE);
        String manualOrderNumber = orderNumber(new Random()).trim();
        newCustomerValidation(new Random());
        newCustomerInformation(new Random());
        addingProducts();
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.saveOrderButton, CommonConstants.MANAGE_ORDERS_PAGE);
        orderCreatedVerification(manualOrderNumber);
    }

    public void selectFilterForCompleteOrder() {
        clickOrderSearchButton();
        verifyCheckbox();
    }

    private void verifyCheckbox() {
        clickAdvanceFilterButton();
        clickOpenCheckBox();
        clickAssignedCheckBox();
        if (!(completeCheckBox.isSelected())) {
            clickOnWebElement(completeCheckBox);
        }
        clickOrderFilterOkButton();
    }

    public void deletingOrder() {
        advanceFilterOrder();
        Assert.assertEquals(getTextFromWebElement(deleteText), "Delete");
        Assert.assertTrue(checkAllPrintFieldTicketCheckBox.isDisplayed());
        searchOrderNumber(deleteOrder());
        Assert.assertEquals(getTextFromWebElement(commonWebElements.msgID), CommonConstants.FILTER_CRITERIA);
    }

    private String deleteOrder() {
        clickOnWebElement(FirstDeleteOrder);
        String orderNumber = getTextFromWebElement(selectFirstOrder);
        Assert.assertTrue(deleteOrderButton.isEnabled());
        clickOnWebElementAndWaitForPageToLoad(deleteOrderButton, CommonConstants.MANAGE_ORDERS_PAGE);
        waitForInvisibilityOfRotator();
        return orderNumber;
    }

    public void clickOnOrderNumber() {
        clickOnWebElementAndWaitForPageToLoad(selectFirstOrder, CommonConstants.ORDER_DETAILS_PAGE);
    }

    public void searchOrderNumber(String orderNumber) {
        clickOnWebElement(OrderNumberTextBox1);
        typeInputDetails(OrderNumberTextBox1, orderNumber);
        clickOrderSearchButton();
    }

    private void advanceFilterOrder() {
        navigateToOrdersMenu();
        clickAdvanceFilterButton();
        clickOnWebElement(commonWebElements.assignedStatusCheckBox);
        clickOnWebElement(completeCheckBox);
        clickOrderFilterOkButton();
    }

    private String orderNumber(Random random) {
        String manualOrderNumber = "-" + random.nextInt();
        typeInputDetails(commonWebElements.orderNumber, manualOrderNumber);
        return manualOrderNumber;
    }

    private void newCustomerInformation(Random random) {
        typeInputDetails(commonWebElements.customerId, "15" + random.nextInt());
        typeInputDetails(farmNameEnter, "farmName");
        typeInputDetails(commonWebElements.farmId, "farmId");
        typeInputDetails(fieldNameEnter, "fieldName");
        typeInputDetails(fieldIdEnter, "fieldId");
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.customerDoneButton, CommonConstants.CREATE_ORDER_PAGE);
    }

    private void addingProducts() {
        typeInputDetails(commonWebElements.workOrderAcres, "15");
        clickOnWebElement(commonWebElements.addProductsButton);
        typeInputDetails(commonWebElements.productName, "Automated Product");
        typeInputDetails(Quantityvalue, "2016");
        typeInputDetails(Quantityunit, "Gal");
        typeInputDetails(Densityvalue, "25");
        typeInputDetails(Densityunit, "Gal/Acre");
        typeInputDetails(Ratevalue, "35");
        typeInputDetails(Rateunit, "Gal/Acre");
        clickOnByElement(By.xpath("//*[contains(text(),'Gal/Acre')]"));
        clickOnWebElementAndWaitForPageToLoad(addButton, CommonConstants.CREATE_ORDER_PAGE);
        waitForWebElement(addProductSection);
    }

    private void newCustomerValidation(Random random) {
        typeInputDetails(commonWebElements.textCustomerName, "AutomationCustomer" + random.nextInt());
        assertEquals(getTextFromWebElement(newCustomer), CommonConstants.NEW_CUSTOMER);
        clickOnWebElement(newCustomer);
    }

    private void orderCreatedVerification(String manualOrderNumber) {
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.scheduleTab, CommonConstants.SCHEDULE_PAGE);
        typeInputDetails(commonWebElements.searchTextBox, manualOrderNumber);
        clickOnByElement(By.xpath("//*[contains(text(),'" + manualOrderNumber + "')]"));
        Assert.assertTrue(isElementPresent(By.xpath("//*[contains(text(),'" + manualOrderNumber + "')]")));
    }

    public void clickProductTotalAndVerifyOrders() {
        clickOnWebElement(productTotalCheckBox);
        String orderNumber = getTextFromWebElement(selectFirstOrder);
        switchToNextWindow(commonWebElements.productTotalButton, CommonConstants.PRODUCT_TOTAL_PAGE);
        Assert.assertTrue(BrowserConfiguration.driver.getTitle().contains(CommonConstants.PRODUCT_TOTAL_PAGE));
        Assert.assertTrue(getTextFromWebElement(orderNumberOnProductTotal).contains(orderNumber));
    }

    private boolean verifyTextFieldIsClear(WebElement TestElement) {
        return TestElement.getAttribute("value").length() == 0;
    }

    public void enterDetailedFilterData() {
        waitForWebElement(ApplicatorDropDown);
        selectElementByIndex(ApplicatorDropDown, 0);
        setFieldValue();
        new Actions(BrowserConfiguration.driver).sendKeys(Keys.ESCAPE).build().perform();
        typeInputDetailsWithOutCheckingVisibility(advOrderNumberTextBox, randomno.toString());
        selectElementByText(LocationSelectBox, "All");
        clickOnWebElement(commonWebElements.orderFilterClearButton);
        verifyFieldClear();
    }

    private void setFieldValue() {
        setCustomerNameTextBox(RandomStringUtils.randomAlphabetic(7));
        typeInputDetailsWithOutCheckingVisibility(commonWebElements.farmName, RandomStringUtils.randomAlphabetic(7));
        typeInputDetailsWithOutCheckingVisibility(commonWebElements.fieldName, RandomStringUtils.randomAlphabetic(7));
        typeInputDetailsWithOutCheckingVisibility(CropTextBox, RandomStringUtils.randomAlphabetic(5));
        typeInputDetailsWithOutCheckingVisibility(ProductTextBox, RandomStringUtils.randomAlphabetic(6));
        typeInputDetailsWithOutCheckingVisibility(OrderedDateStartTextBox, "01/01/2016");
        typeInputDetailsWithOutCheckingVisibility(ScheduledDateStartTextBox, "01/01/2016");
        typeInputDetailsWithOutCheckingVisibility(CompletedDateStartTextBox, "01/01/2016");
        typeInputDetailsWithOutCheckingVisibility(RequestedDateStartTextBox, "01/01/2016");
    }

    private void verifyFieldClear() {
        Assert.assertTrue(verifyTextFieldIsClear(commonWebElements.customerName));
        Assert.assertTrue(verifyTextFieldIsClear(commonWebElements.farmName));
        Assert.assertTrue(verifyTextFieldIsClear(commonWebElements.fieldName));
        Assert.assertTrue(verifyTextFieldIsClear(CropTextBox));
        Assert.assertTrue(verifyTextFieldIsClear(ProductTextBox));
        Assert.assertTrue(verifyTextFieldIsClear(OrderedDateStartTextBox));
        Assert.assertTrue(verifyTextFieldIsClear(ScheduledDateStartTextBox));
        Assert.assertTrue(verifyTextFieldIsClear(CompletedDateStartTextBox));
        Assert.assertTrue(verifyTextFieldIsClear(RequestedDateStartTextBox));
        Assert.assertTrue(verifyTextFieldIsClear(advOrderNumberTextBox));
    }

    public void verifyAdvFilterData(String filterData) {
        waitForPageTitleToBeAvailable(CommonConstants.MANAGE_ORDERS_PAGE);
        waitForByElement(By.xpath("//*[contains(@id,'workRecord')]//li[2][contains(text(),'" + filterData + "')]"));
        List<WebElement> listWorkRecord = BrowserConfiguration.driver.findElements(By.xpath("//*[contains(@id,'workRecord')]//li[2][contains(text(),'" + filterData + "')]"));
        Assert.assertTrue(listWorkRecord.size() > 0);
    }

    public void verifyCustNameFilterData(String filterData) {
        waitForPageTitleToBeAvailable(CommonConstants.MANAGE_ORDERS_PAGE);
        waitForByElement(By.xpath("//li[contains(@id,'cust')][contains(text(),'" + filterData.substring(0, filterData.indexOf(' ')) + "')]"));
        List<WebElement> listWorkRecord = BrowserConfiguration.driver.findElements(By.xpath("//li[contains(@id,'cust')][contains(text(),'" + filterData.substring(0, filterData.indexOf(' ')) + "')]"));
        Assert.assertTrue(listWorkRecord.size() > 0);
    }

    public String getCustomerName() {
        clickOrderSearchButton();
        return getTextFromWebElement(getCustomerName);
    }


}