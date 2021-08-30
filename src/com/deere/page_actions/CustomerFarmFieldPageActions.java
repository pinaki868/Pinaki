package com.deere.page_actions;

import com.deere.global.BrowserConfiguration;
import com.deere.global.CommonConstants;
import com.deere.global.CommonWebElements;
import com.deere.page_objects.CustomerFarmFieldPageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.Random;
import java.util.UUID;

import static com.deere.global.BrowserConfiguration.driver;
import static com.deere.global.CommonFunctions.*;

public class CustomerFarmFieldPageActions extends CustomerFarmFieldPageObjects {
    CommonWebElements commonWebElements = PageFactory.initElements(BrowserConfiguration.driver, CommonWebElements.class);

    public void verifyCustomerFarmField(String[] inputDetails) {
        verifyTextFieldsDeleteCFFTab();
        SearchByCustomerName(inputDetails[0]);
        clickOnWebElementAndWaitForPageToLoad(deletecustomerfarmfield, CommonConstants.CFF_DELETE_PAGE);
        deleteCFF(inputDetails[0]);
        typeInputDetails(commonWebElements.textCustomerName, inputDetails[0]);
        clickOnWebElementAndWaitForPageToLoad(DeleteButton, CommonConstants.CFF_DELETE_PAGE);
        if (!getTextFromWebElement(deletefarm).contains(CommonConstants.CFF_DELETE_MESSAGE)) {
            deleteCFF(inputDetails[0]);
        }
        verifyDeletedCustomerFarm(inputDetails[0]);
    }

    private void deleteCFF(String cName) {
        typeInputDetails(commonWebElements.textCustomerName, cName);
        clickOnByElement(By.cssSelector("a.ui-corner-all"));
        clickOnWebElementAndWaitForPageToLoad(DeleteButton, CommonConstants.CFF_DELETE_PAGE);
    }

    private void verifyDeletedCustomerFarm(String cName) {
        clickOnWebElement(commonWebElements.customerFarmFieldTab);
        typeInputDetails(commonWebElements.customerName, cName);
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.submitFilterButton, CommonConstants.CFF_MANAGE_PAGE);
        Assert.assertEquals(getTextFromWebElement(commonWebElements.msgID), CommonConstants.FILTER_CRITERIA_MESSAGE);
    }

    private void SearchByCustomerName(String cName) {
        typeInputDetails(commonWebElements.textCustomerName, cName);
        clickOnWebElementAndWaitForPageToLoad(CancelButton, CommonConstants.CFF_MANAGE_PAGE);
        Assert.assertTrue(commonWebElements.customerFarmFieldTab.isDisplayed());
        typeInputDetails(commonWebElements.customerName, cName);
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.submitFilterButton, CommonConstants.CFF_MANAGE_PAGE);
        Assert.assertEquals(getTextFromWebElement(customer1), cName);
    }

    private void verifyTextFieldsDeleteCFFTab() {
        clickOnWebElementAndWaitForPageToLoad(deletecustomerfarmfield, CommonConstants.CFF_DELETE_PAGE);
        Assert.assertTrue(commonWebElements.textCustomerName.isDisplayed());
        Assert.assertTrue(commonWebElements.txtFarmName.isDisplayed());
        Assert.assertTrue(FieldNameField.isDisplayed());
        Assert.assertTrue(DeleteButton.isDisplayed());
        Assert.assertTrue(CancelButton.isDisplayed());
    }

    public void uploadCFFFile() {
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.customerFarmFieldTab, CommonConstants.CFF_MANAGE_PAGE);
        clickOnWebElementAndWaitForPageToLoad(customertab, CommonConstants.CFF_UPLOAD_PAGE);
        waitForWebElement(commonWebElements.browseButton).sendKeys(CommonConstants.FILE_UPLOAD_DIRECTORY + "farmField.csv");
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.submitButton, CommonConstants.CFF_UPLOAD_PAGE);
        Assert.assertTrue(isElementPresent(By.xpath(CommonConstants.UPLOAD_SUCCESS_MESSAGE)));
        Assert.assertFalse(isElementPresent(By.xpath(CommonConstants.UPLOAD_ERROR_CLASS)));
    }

    public void uploadBoundary(String[] inputDetails){
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.customerFarmFieldTab, CommonConstants.CFF_MANAGE_PAGE);
        typeInputDetails(commonWebElements.customerName, inputDetails[0]);
        clickOnWebElementAndWaitForPageToLoad(searchButton, CommonConstants.CFF_MANAGE_PAGE);
        clickOnWebElementAndWaitForPageToLoad(expandButton, CommonConstants.CFF_MANAGE_PAGE);
        Assert.assertTrue(cfField.isDisplayed());
        clickOnByElement(By.id("fieldName111"));
        Assert.assertFalse(driver.getPageSource( ).contains("new google.maps.Polygon"));
        waitForWebElement(shapeButton).sendKeys(CommonConstants.FILE_UPLOAD_DIRECTORY + "2_rectangles_1_entry.shp");
        waitForWebElement(boundaryButton).sendKeys(CommonConstants.FILE_UPLOAD_DIRECTORY + "2_rectangles_1_entry.dbf");
    }

    public void verifyCustomerTab() {
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.customerFarmFieldTab, CommonConstants.CFF_MANAGE_PAGE);
        verifyCustomerFarmFieldTab();
        verifyCustomer1();
    }

    public void verifyBoundary(){
        Assert.assertTrue(removeBoundary.isEnabled());
        Assert.assertTrue(driver.getPageSource( ).contains("new google.maps.Polygon"));

    }

    private void verifyCustomerFarmFieldTab() {
        Assert.assertTrue(commonWebElements.customerFarmFieldTab.isDisplayed());
        Assert.assertTrue(commonWebElements.customerName.isDisplayed());
        Assert.assertTrue(commonWebElements.farmName.isDisplayed());
        Assert.assertTrue(commonWebElements.fieldName.isDisplayed());
        Assert.assertTrue(NoofCustomers.isDisplayed());
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.submitFilterButton, CommonConstants.CFF_MANAGE_PAGE);
        Assert.assertTrue(commonWebElements.msgID.isDisplayed());
    }

    private void verifyCustomer1() {
        clickOnWebElement(expandButton);
        clickOnWebElementAndWaitForPageToLoad(customer1, CommonConstants.CFF_EDIT_PAGE);
        Assert.assertEquals(getTextFromWebElement(printThisPage), "Print this Page");
        String CustomerName = "" + new Random().nextInt();
        String CustomerID = "" + new Random().nextInt();
        typeInputDetails(commonWebElements.nameField, CustomerName);
        typeInputDetails(commonWebElements.externalIdField, CustomerID);
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.saveButton, CommonConstants.CFF_MANAGE_PAGE);
        Assert.assertTrue(commonWebElements.customerFarmFieldTab.isDisplayed());
        Assert.assertTrue(commonWebElements.msgID.isDisplayed());
        Assert.assertEquals(CustomerName, getTextFromWebElement(customer1));
        verifyFarmAndField();
    }

    private void verifyFarmAndField() {
        clickOnWebElement(expandButton);
        String NewfarmName = UUID.randomUUID().toString();
        String NewfieldName = UUID.randomUUID().toString();
        clickOnWebElement(verifysFarmName);
        typeInputDetails(commonWebElements.nameField, NewfarmName);
        commonWebElements.nameField.sendKeys(Keys.TAB);
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.saveButton, CommonConstants.CFF_MANAGE_PAGE);
        clickOnWebElement(expandButton);
        Assert.assertEquals(getTextFromWebElement(verifysFarmName), NewfarmName);
        clickOnWebElement(verifyFieldName);
        typeInputDetails(commonWebElements.nameField, NewfieldName);
        commonWebElements.nameField.sendKeys(Keys.TAB);
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.saveButton, CommonConstants.CFF_MANAGE_PAGE);
        clickOnWebElement(expandButton);
        Assert.assertEquals(getTextFromWebElement(verifyFieldName), NewfieldName);
    }

    public void verifyCustomerFamFieldSubTab1(String[] inputTestDetails) {
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.customerFarmFieldTab, CommonConstants.CFF_MANAGE_PAGE);
        cffSelectNoCustomerOption(Option1);
        cffSelectNoCustomerOption(Option2);
        cffSelectNoCustomerOption(Option3);
        verifySearchOptions(assertSearchOptions(), inputTestDetails[0]);
        verifyDisplayOptions();
        assertDisplayOptions();
    }

    private void verifySearchOptions(String s, String cff) {
        Assert.assertTrue(s.contains("Select Number Of Customer"));
        Select select = new Select(NoofCustomers);
        select.selectByVisibleText("10");
        select.selectByVisibleText("25");
        select.selectByVisibleText("50");
        typeInputDetails(commonWebElements.farmName, cff);
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.submitFilterButton, CommonConstants.CFF_MANAGE_PAGE);
        Assert.assertTrue(verifyFarmName.isDisplayed(), "Condition Verified");
        typeInputDetails(commonWebElements.fieldName, cff);
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.submitFilterButton, CommonConstants.CFF_MANAGE_PAGE);
    }

    private String assertSearchOptions() {
        Assert.assertEquals(getTextFromWebElement(commonWebElements.customerName), "");
        Assert.assertEquals(getTextFromWebElement(commonWebElements.farmName), "");
        Assert.assertEquals(getTextFromWebElement(commonWebElements.fieldName), "");
        return getTextFromWebElement(searchForm);
    }

    private void verifyDisplayOptions() {
        Assert.assertTrue(verifySFieldName.isDisplayed());
        Assert.assertTrue(forwardButton.isEnabled());
        Assert.assertTrue(backButton.isEnabled());
        Assert.assertTrue(firstButton.isEnabled());
        Assert.assertTrue(lastButton.isEnabled());
        commonWebElements.farmName.clear();
        commonWebElements.fieldName.clear();
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.submitFilterButton, CommonConstants.CFF_MANAGE_PAGE);
    }

    private void assertDisplayOptions() {
        Assert.assertTrue(forwardButton.isEnabled());
        Assert.assertTrue(backButton.isEnabled());
        Assert.assertTrue(firstButton.isEnabled());
        Assert.assertTrue(lastButton.isEnabled());
    }

    private void cffSelectNoCustomerOption(WebElement webElement) {
        clickOnWebElement(webElement);
        int num1 = Integer.parseInt(getTextFromWebElement(webElement));
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.submitFilterButton, CommonConstants.CFF_MANAGE_PAGE);
        Assert.assertEquals(driver.findElements(By.xpath(CommonConstants.CLIENT_NAME)).size(), num1);
    }

    public void exportToCSV(String[] inputTestDetails) throws Exception {
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.customerFarmFieldTab, CommonConstants.CFF_MANAGE_PAGE);
        Assert.assertFalse(driver.getPageSource().contains("Export to CSV"));
        typeInputDetails(commonWebElements.customerName, inputTestDetails[0]);
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.submitFilterButton, CommonConstants.CFF_MANAGE_PAGE);
        Assert.assertTrue(exportToCSVButton.isDisplayed());
        clickOnWebElement(exportToCSVButton);
        verifyExportedFile("customerFarmField.csv");
        Assert.assertEquals("Customer, Farm, Field", new LineNumberReader
                (new FileReader(new File(CommonConstants.FILE_DOWNLOAD_DIRECTORY + "customerFarmField.csv"))).readLine());
    }
}