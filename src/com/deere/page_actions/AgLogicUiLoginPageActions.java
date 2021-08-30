package com.deere.page_actions;

import com.deere.global.BrowserConfiguration;
import com.deere.global.CommonConstants;
import com.deere.global.CommonFunctions;
import com.deere.global.CommonWebElements;
import com.deere.page_objects.AgLogicUiLoginPageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.deere.global.CommonConstants.*;
import static com.deere.global.CommonFunctions.*;

public class AgLogicUiLoginPageActions extends AgLogicUiLoginPageObjects {
    CommonWebElements commonWebElements = PageFactory.initElements(BrowserConfiguration.driver, CommonWebElements.class);

    public void singleSignOn() {
        clickOnWebElementAndWaitForPageToLoad(agLogicLogout, LOGIN_PAGE);
        BrowserConfiguration.driver.get(CommonConstants.MYJD_URL);
        typeInputDetails(myJdUsername, CommonFunctions.decryptCredentials(String.valueOf(CommonFunctions
                .getTestData(CommonConstants.REGRESSION_SUITE).get("Key1"))));
        typeInputDetails(myJdPassword, CommonFunctions.decryptCredentials(String.valueOf(CommonFunctions
                .getTestData(CommonConstants.REGRESSION_SUITE).get("Key2"))));
        clickOnWebElementAndWaitForPageToLoad(myJdSingInButton, MY_JOHN_DEERE_PAGE);
    }

    public void assertAgLogicLink() {
        switchToNextTab(agLogicLink, 1, SCHEDULE_PAGE);
        clickOnWebElementAndWaitForPageToLoad(agLogicLogout, LOGIN_PAGE);
        switchToPreviousTab(0, MY_JOHN_DEERE_PAGE);
        clickOnWebElementAndWaitForPageToLoad(myJdLogout, MY_JOHN_DEERE_LOGIN_PAGE);
    }

    public void goToMyJDApp() {
        switchToNextTab(1, EQUIPMENT_APPLICATORS_PAGE);
        BrowserConfiguration.driver.get(CommonConstants.MYJD_URL);
        waitForContainsPageTitleToBeAvailable(MY_JOHN_DEERE_PAGE);
    }

    public WebElement equipmentTab() {
        return waitForWebElement(commonWebElements.equipmentTab);
    }

    public boolean assertLogoutButton() {
        waitForWebElement(assertLogoutButton);
        return assertLogoutButton.isEnabled() && assertLogoutButton.isDisplayed();
    }

    public boolean assertAgLogicIcon() {
        waitForWebElement(assertAglogicIcon);
        return assertAglogicIcon.isEnabled() && assertAglogicIcon.isDisplayed();
    }

    public boolean assertAgLogicTM() {
        waitForWebElement(assertAglogicTM);
        return assertAglogicTM.isEnabled() && assertAglogicTM.isDisplayed();
    }

    public void agLogicTMClick() {
        switchToNextTab(assertAglogicTM, 2, SCHEDULE_PAGE);
    }

    public void clickLogoutButton() {
        clickOnWebElementAndWaitForPageToLoad(agLogicLogout, LOGIN_PAGE);
    }

    public boolean forgotPasswordButton() {
        return waitForWebElement(forgotPassword).isEnabled() && waitForWebElement(forgotPassword).isDisplayed();
    }

    public void forgotPasswordClick() {
        clickOnWebElementAndWaitForPageToLoad(forgotPassword, LOGIN_PAGE);
    }

    public boolean forMigratedCustomers() {
        return waitForWebElement(migratedCustomers).isEnabled() && waitForWebElement(migratedCustomers).isDisplayed();
    }

    public boolean forNonMigratedCustomers() {
        return waitForWebElement(nonmigratedCustomers).isEnabled() && waitForWebElement(nonmigratedCustomers).isDisplayed();
    }

    public void clickHere() {
        switchToNextTab(forgotPasswordClickHere, 1, FORGOT_YOUR_PASSWORD_PAGE);
    }

    public boolean forgotPasswordTextBox() {
        return TextBox.isEnabled() && TextBox.isDisplayed();
    }

    public boolean forgotPasswordSubmitButton() {
        return SubmitButton.isEnabled() && SubmitButton.isDisplayed();
    }

    public void orderAndCreateNewOrderClick() {
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.ordersTab, MANAGE_ORDERS_PAGE);
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.createOrderButton, CREATE_ORDER_PAGE);
    }

    public void verifyOrderDetails(String[] inputTestDetails) {
        int test = (int) generateRandomNumber(9999);
        System.out.println(test);
        typeInputDetails(commonWebElements.orderNumber, String.valueOf(test));
        commonWebElements.orderNumber.sendKeys(Keys.TAB);
        typeInputDetails(commonWebElements.textCustomerName, inputTestDetails[0]);
        commonWebElements.textCustomerName.sendKeys(Keys.ARROW_DOWN);
        commonWebElements.textCustomerName.sendKeys(Keys.TAB);
        commonWebElements.textCustomerName.sendKeys(Keys.TAB);
        typeInputDetails(commonWebElements.txtFarmName, inputTestDetails[1]);
        commonWebElements.txtFarmName.sendKeys(Keys.ARROW_DOWN);
        commonWebElements.txtFarmName.sendKeys(Keys.TAB);
        typeInputDetails(commonWebElements.workOrderAcres, inputTestDetails[2]);
        clickOnWebElement(btnMore);
        verifyUploadFile();
        verifyProductSection(inputTestDetails);
        orderAssignedToApplicator(test);
        verifyApplicatorToCheckOrder(test);
    }

    private void verifyApplicatorToCheckOrder(int test) {
        clickOnWebElement(orderSelect);
        clickOnWebElement(commonWebElements.assignOrdersButton);
        String ApplicatorName1 = getTextFromByElement(By.xpath(CommonConstants.APPLICATOR_COLUMN + "/td[2]"));
        clickOnByElement(By.xpath(CommonConstants.APPLICATOR_COLUMN + "/td[1]"));
        clickOnWebElement(commonWebElements.orderAssignOkButton);
        waitForPageTitleToBeAvailable(CommonConstants.SCHEDULE_PAGE);
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.applicatorTab, SCHEDULE_PAGE);
        clickOnByElement(By.xpath("//a[@title='" + ApplicatorName1 + "']/..//button[@class='toggle expandAppList']"));
        waitForByElement(By.xpath("//div[@class='appOrderContainer'][@style='display: block;']//a[@class='orderListOrderNumberRS'][text()='" + test + "']"));
        Assert.assertTrue(isElementPresent(By.xpath("//div[@style='display: block;']//a[text()='" + test + "']")));
    }

    private void orderAssignedToApplicator(int test) {
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.scheduleTab, SCHEDULE_PAGE);
        clickOnWebElement(commonWebElements.filterOrdersButton);
        clickOnWebElement(chkAllOrders);
        clickOnWebElement(commonWebElements.orderFilterOkButton);
        waitForPageTitleToBeAvailable(CommonConstants.SCHEDULE_PAGE);
        typeInputDetails(commonWebElements.searchTextBox, String.valueOf(test));
    }

    private void verifyProductSection(String[] inputTestDetails) {
        clickOnWebElement(commonWebElements.addProductsButton);
        int test = (int) generateRandomNumber(9999);
        typeInputDetails(commonWebElements.productName, inputTestDetails[3]);
        clickOnWebElement(commonWebElements.saveOrderButton);
        typeInputDetails(commonWebElements.customerId, String.valueOf(test));
        typeInputDetails(commonWebElements.farmId, String.valueOf(test));
        clickOnWebElement(commonWebElements.customerDoneButton);
        waitForWebElement(commonWebElements.orderNumber);
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.saveOrderButton, MANAGE_ORDERS_PAGE);
    }

    private void verifyUploadFile() {
        waitForWebElement(commonWebElements.browseButton).sendKeys(CommonConstants.FILE_UPLOAD_DIRECTORY + "zipFile.zip");
    }
}