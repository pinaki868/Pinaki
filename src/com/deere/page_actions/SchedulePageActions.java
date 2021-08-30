package com.deere.page_actions;

import com.deere.global.BrowserConfiguration;
import com.deere.global.CommonConstants;
import com.deere.global.CommonWebElements;
import com.deere.page_objects.SchedulePageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static com.deere.global.CommonFunctions.*;
import static com.deere.global.HttpConnection.workRecordApplicatorID;

public class SchedulePageActions extends SchedulePageObjects {
    CommonWebElements commonWebElements = PageFactory.initElements(BrowserConfiguration.driver, CommonWebElements.class);

    public boolean assertTodayDate() {
        return new SimpleDateFormat("MM/dd/yyyy").format(new Date()).trim().equals(scheduleStartDate.getAttribute("value").trim());
    }

    public boolean assertOrderRolloverPrevious() {
        clickOnWebElement(calenderpicker);
        clickOnWebElement(Previousmonth);
        clickOnWebElement(selectdatecalenderpicker);
        return orderrollover.isEnabled();
    }

    public void assertOrderRolloverNext() {
        waitForPageTitleToBeAvailable(CommonConstants.SCHEDULE_PAGE);
        clickOnWebElement(calenderpicker);
        clickOnWebElement(Nextmonth);
        clickOnWebElement(Nextmonth);
        clickOnWebElement(selectdatecalenderpicker);
        waitForPageTitleToBeAvailable(CommonConstants.SCHEDULE_PAGE);
    }

    public void orderRolloverOption() {
        waitForPageTitleToBeAvailable(CommonConstants.SCHEDULE_PAGE);
        clickOnWebElement(orderrollover);
        waitForWebElement(rolloverRadioButton).isDisplayed();
        waitForWebElement(rolloverUnassignRadio).isDisplayed();
        clickOnWebElement(cancelOrderRolloverButton);
    }

    public void managementTabAdjustTime() {
        if (!waitForWebElement(commonWebElements.rollOverSchedule).isSelected()) {
            clickOnWebElement(commonWebElements.rollOverSchedule);
        }
        clickOnWebElement(commonWebElements.rollOverTime);
        if (!getTextFromWebElement(commonWebElements.timeRollOverTime).equalsIgnoreCase("12:00 am")) {
            Actions hour = new Actions(BrowserConfiguration.driver);
            hour.dragAndDropBy(getHourSlider, -80, 0).build().perform();
            hour.dragAndDropBy(commonWebElements.minuteRollOverTime, -130, 0).build().perform();
            clickOnWebElementAndWaitForPageToLoad(doneButton, CommonConstants.EDIT_PROGRAM_OPTIONS_PAGE);
        }
    }

    public void assertAssignOrdersToApplicator(String orderIdAssigned) {
        clickOnWebElement(commonWebElements.assignOrdersButton);
        clickOnWebElement(applicatorNameFirstCheckbox);
        clickOnWebElement(applicatorNameSecondCheckbox);
        clickOnWebElement(commonWebElements.orderAssignOkButton);
        waitForPageTitleToBeAvailable(CommonConstants.SCHEDULE_PAGE);
        clickOnApplicatorTab();
        expandAllApplicators();
        Assert.assertTrue(isElementPresent(By.xpath("//*[contains(text(), '" + orderIdAssigned + "')]")));
    }

    public void verifyOrdersFunctionality() {
        searchOrder();
        clickOnWebElementAndWaitForPageToLoad(orderNumber, CommonConstants.ORDER_DETAILS_PAGE);
        verifyOrderDetailsTab();
    }

    private void verifyOrderDetailsTab() {
        Assert.assertTrue(informationSubTab.isDisplayed());
        Assert.assertTrue(informationSubTabOpen.isDisplayed());
        Assert.assertTrue(productsSubTab.isDisplayed());
        Assert.assertTrue(workRecordsSubTab.isDisplayed());
        Assert.assertTrue(auditHistorySubTab.isDisplayed());
        Assert.assertTrue(commonWebElements.productList.isDisplayed());
        Assert.assertTrue(workRecordsSubTabClosed.isDisplayed());
        Assert.assertTrue(auditHistorySubTabClosed.isDisplayed());
    }

    public void linkingCustomerFarmField() {
        searchOrder();
        saveAndVerifyAllCustomerDetails();
        searchOrder();
        saveAndVerifyAllFarmDetails();
        searchOrder();
        saveAndVerifyAllFieldDetails();
    }

    public void searchOrder() {
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.ordersSubTab, CommonConstants.SCHEDULE_PAGE);
        typeInputDetails(commonWebElements.searchTextBox, orderFirstOrderId.getText());
        clickOnWebElementAndWaitForPageToLoad(orderFirstOrderId, CommonConstants.SCHEDULE_PAGE);
    }

    private void saveAndVerifyAllCustomerDetails() {
        clickOnWebElementAndWaitForPageToLoad(customerDetails, CommonConstants.CFF_EDIT_PAGE);
        verifyCommonFields();
        typeInputDetails(commonWebElements.nameField, "Customer_DO Not Delete" + new Random().nextInt());
        typeInputDetails(commonWebElements.externalIdField, "" +  new Random().nextInt());
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.saveButton, CommonConstants.SCHEDULE_PAGE);
    }

    private void saveAndVerifyAllFarmDetails() {
        clickOnWebElementAndWaitForPageToLoad(farmDetails, CommonConstants.CFF_EDIT_PAGE);
        verifyCommonFields();
        typeInputDetails(commonWebElements.nameField, "Jensen Farms" + new Random().nextInt());
        typeInputDetails(commonWebElements.externalIdField, "" +  new Random().nextInt());
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.saveButton, CommonConstants.SCHEDULE_PAGE);
    }

    private void saveAndVerifyAllFieldDetails() {
        clickOnWebElementAndWaitForPageToLoad(fieldDetails, CommonConstants.CFF_EDIT_PAGE);
        verifyCommonFields();
        typeInputDetails(commonWebElements.nameField, "Agriland Fields" + new Random().nextInt());
        typeInputDetails(commonWebElements.externalIdField, "" +  new Random().nextInt());
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.saveButton, CommonConstants.SCHEDULE_PAGE);
    }

    private void verifyCommonFields() {
        Assert.assertTrue(CommonConstants.CFF_MANAGE_PAGE.contains(getTextFromWebElement(customerFarmFieldPage)));
        Assert.assertTrue(commonWebElements.nameField.isDisplayed());
        Assert.assertTrue(commonWebElements.externalIdField.isDisplayed());
        Assert.assertTrue(areafield.isDisplayed());
        Assert.assertTrue(acresDropDown.isDisplayed());
        Assert.assertTrue(streettextfield.isDisplayed());
        Assert.assertTrue(cityfield.isDisplayed());
        Assert.assertTrue(statefield.isDisplayed());
        Assert.assertTrue(zipfield.isDisplayed());
        Assert.assertTrue(emailfield.isDisplayed());
        Assert.assertTrue(textMessagefield.isDisplayed());
        Assert.assertTrue(phonefield.isDisplayed());
        Assert.assertTrue(latitudefield.isDisplayed());
        Assert.assertTrue(longitudefield.isDisplayed());
    }

    public void searchTextBoxFieldOrdersSubTab() {
        Assert.assertTrue(commonWebElements.ordersTab.isDisplayed());
        Assert.assertTrue(commonWebElements.searchTextBox.isDisplayed());
    }

    public void searchTextBoxFieldApplicatorsSubTab() {
        clickOnApplicatorTab();
        Assert.assertTrue(commonWebElements.applicatorTab.isDisplayed());
        Assert.assertTrue(!commonWebElements.searchTextBox.isDisplayed());
    }

    public void searchTextBoxFieldTendersSubTab() {
        clickOnTendersTab();
        Assert.assertTrue(!commonWebElements.searchTextBox.isDisplayed());
    }

    public void searchCustomer() {
        typeInputDetails(commonWebElements.searchTextBox, "AutomationCustomer");
        clickOnWebElementAndWaitForPageToLoad(resultListFirstOrder, CommonConstants.SCHEDULE_PAGE);
        waitForWebElement(orderInfoWindow);
        Assert.assertTrue(getTextFromWebElement(CustomerName).contains(getTextFromWebElement(searchCustomerName)));
    }

    public void searchFarm() {
        typeInputDetails(commonWebElements.searchTextBox, "farmName");
        clickOnWebElementAndWaitForPageToLoad(resultListFirstOrderFarm, CommonConstants.SCHEDULE_PAGE);
        waitForWebElement(orderInfoWindow);
        Assert.assertTrue(getTextFromWebElement(farmName).contains(getTextFromWebElement(searchFarmName)));
    }

    public void searchField() {
        typeInputDetails(commonWebElements.searchTextBox, "fieldName");
        clickOnWebElementAndWaitForPageToLoad(resultListFirstfieldOrder, CommonConstants.SCHEDULE_PAGE);
        waitForWebElement(orderInfoWindow);
        Assert.assertTrue(getTextFromWebElement(fieldName).contains(getTextFromWebElement(searchFieldName)));
    }

    public void clickOnCheckBox1() {
        clickOnWebElement(commonWebElements.checkBox1);
        Assert.assertTrue(waitForWebElement(commonWebElements.assignOrdersButton).isEnabled());
        Assert.assertTrue(waitForWebElement(commonWebElements.assignButtonLeft).isDisplayed());
        clickOnWebElementAndWaitForPageToLoad(ClickFirstElement, CommonConstants.SCHEDULE_PAGE);
        waitForWebElement(orderInfoWindow);
        clickOnWebElement(ClickOrderEdit);
        waitForByElement(By.xpath(CommonConstants.ATTACHMENT_FILE_INPUT));
        if (isElementPresent(By.xpath(CommonConstants.ATTACHMENT_FILE_INPUT + "[contains(@style,'display:none')]"))) {
            clickOnWebElement(removeButton);
        }
        waitForWebElement(commonWebElements.browseButton).sendKeys(CommonConstants.FILE_UPLOAD_DIRECTORY + "farmField.csv");
        clickOnWebElement(commonWebElements.saveButtonID);
    }

    public void assignApplicator() {
        clickOnWebElement(commonWebElements.assignButtonLeft);
        clickOnWebElement(secondApplicator);
        clickOnWebElement(commonWebElements.orderAssignOkButton);
        waitForPageTitleToBeAvailable(CommonConstants.SCHEDULE_PAGE);
    }

    public void enterSearchField(String search) {
        typeInputDetails(commonWebElements.searchTextBox, search);
        clickOnResetFilter();
    }

    public String assertSearchText() {
        return commonWebElements.searchTextBox.getAttribute("value").trim();
    }

    public void clickOnAdvancedFilterButton(String[] inputDetails) {
        clickOnWebElement(commonWebElements.filterOrdersButton);
        typeInputDetailsWithOutCheckingVisibility(commonWebElements.customerName, inputDetails[0]);
        typeInputDetailsWithOutCheckingVisibility(commonWebElements.farmName, inputDetails[1]);
        typeInputDetailsWithOutCheckingVisibility(commonWebElements.fieldName, inputDetails[2]);
        clickOnWebElement(commonWebElements.orderFilterClearButton);
        if (commonWebElements.customerName.getAttribute("value").isEmpty() && commonWebElements.farmName.getAttribute("value").isEmpty()
                && commonWebElements.fieldName.getAttribute("value").isEmpty()) {
            typeInputDetailsWithOutCheckingVisibility(commonWebElements.customerName, inputDetails[0]);
            typeInputDetailsWithOutCheckingVisibility(commonWebElements.farmName, inputDetails[1]);
            typeInputDetailsWithOutCheckingVisibility(commonWebElements.fieldName, inputDetails[2]);
            clickOnWebElement(commonWebElements.orderFilterOkButton);
            waitForPageTitleToBeAvailable(CommonConstants.SCHEDULE_PAGE);
        }
    }

    public void clickPopUpAdvancedFilterButton(String[] inputDetails) {
        waitForPageTitleToBeAvailable(CommonConstants.SCHEDULE_PAGE);
        clickOnWebElement(commonWebElements.filterOrdersButton);
        typeInputDetailsWithOutCheckingVisibility(commonWebElements.customerName, inputDetails[1]);
        clickOnWebElement(commonWebElements.orderFilterOkButton);
        waitForPageTitleToBeAvailable(CommonConstants.SCHEDULE_PAGE);
    }

    public String getAdvancedCustomerName() {
        System.out.println(getTextFromWebElement(advancedFilterCustomerName));
        return getTextFromWebElement(advancedFilterCustomerName);
    }

    public void clickOnResetFilter() {
        clickOnWebElement(resetFilterButton);
    }

    public void clickOnApplicatorTab() {
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.applicatorTab, CommonConstants.SCHEDULE_PAGE);
    }

    public void clickApplicatorTabAndSelectOrder() {
        clickOnApplicatorTab();
        clickOnWebElement(firstPlusCheckBox);
        if (isElementPresent(By.xpath(CommonConstants.NO_ORDERS_BLOCK + "[1]"))) {
            clickOnWebElement(orderTab);
            clickOnWebElement(assignFirstOrder);
            clickOnWebElement(commonWebElements.assignOrdersButton);
            clickOnWebElement(firstApplicator);
            clickOnWebElement(commonWebElements.orderAssignOkButton);
            waitForPageTitleToBeAvailable(CommonConstants.SCHEDULE_PAGE);
            clickOnApplicatorTab();
            clickOnWebElement(firstPlusCheckBox);
        }
        clickOnWebElement(firstAssignedOrderCheckBox);
        Assert.assertTrue(commonWebElements.reAssignOrdersButton.isEnabled() && assignTenderButton.isEnabled());
    }

    public List<String> getOrderNumbers() {
        List<WebElement> orderNumbers = BrowserConfiguration.driver.findElements(By.xpath(CommonConstants.DISPLAY_ORDERS));
        List<String> orders = new ArrayList<>();
        for (WebElement orderNumber : orderNumbers) {
            orders.add(getTextFromWebElement(orderNumber));
        }
        return orders;
    }

    public void clickAssignTenderButton() {
        clickOnWebElement(assignTenderButton);
        String assignedTenderName = getTextFromWebElement(secondTenderName);
        clickOnWebElement(secondTenderCheckBox);
        clickOnWebElement(tenderAssignOkButton);
        waitForPageTitleToBeAvailable(CommonConstants.SCHEDULE_PAGE);
        clickOnApplicatorTab();
        clickOnWebElement(firstPlusCheckBox);
        verifyAssignedTender(assignedTenderName);
    }

    private void verifyAssignedTender(String assignedTenderName) {
        clickOnWebElementAndWaitForPageToLoad(firstAssignedOrderCheckBox, CommonConstants.SCHEDULE_PAGE);
        clickOnWebElement(assignTenderButton);
        String getAssignedTender = getTextFromWebElement(getLastTenderAssigned);
        Assert.assertTrue(getAssignedTender.contains(assignedTenderName));
    }

    public void clickOnChangeAssignmentButton() {
        clickOnWebElement(commonWebElements.reAssignOrdersButton);
    }

    public String getSecondApplicatorName() {
        clickOnWebElement(secondApplicator);
        return getTextFromWebElement(secondApplicatorName);
    }

    public void assignOrderToApplicator() {
        clickOnWebElement(commonWebElements.orderAssignOkButton);
        waitForPageTitleToBeAvailable(CommonConstants.SCHEDULE_PAGE);
        clickOnApplicatorTab();
    }

    public void verifyAssignedOrderWithApplicator(String assignedApplicatorName, List<String> orderNumber) {
        for (String anOrderNumber : orderNumber) {
            clickOnWebElementAndWaitForPageToLoad(hideAllList, CommonConstants.SCHEDULE_PAGE);
            clickOnByElement(By.xpath("//a[text()='" + assignedApplicatorName + "']/..//*[contains(@class,'expandAppList')]"));
            waitForByElement(By.xpath("//a[text()='" + anOrderNumber + "']"));
            Assert.assertTrue(isElementPresent(By.xpath
                    ("//a[text()='" + assignedApplicatorName + "']/../..//a[text()='" + anOrderNumber + "']")));
        }
    }

    public void enableGetDirectionButton() {
        clickOnWebElement(commonWebElements.expandAllList);
        List<WebElement> checkBoxes = BrowserConfiguration.driver.findElements(By.xpath(CommonConstants.ASSIGNED_ORDER_SELECTOR));
        for (WebElement checkBox : checkBoxes) {
            clickOnWebElement(checkBox);
            if (waitForWebElement(getDirectionButton).isEnabled()) {
                break;
            }
            clickOnWebElement(checkBox);
        }
        Assert.assertTrue(waitForWebElement(getDirectionButton).isEnabled());
    }

    public void clickGetDirectionButton() {
        clickOnWebElement(getDirectionButton);
    }

    public String assertPopUp() {
        return getTextFromWebElement(assertBottomPopUp);
    }

    public String assertAddButton() {
        return addButton.getAttribute("value").trim();
    }

    public String assertRemoveButton() {
        return removeSelectedButton.getAttribute("value").trim();
    }

    public List<WebElement> assertLandMark() {
        clickOnWebElement(option1);
        clickOnWebElement(addButton);
        return new Select(targetList).getOptions();
    }

    public void clickOnMultipleOrderCheckBoxes() {
        clickOnWebElement(commonWebElements.checkBox1);
        clickOnWebElement(checkBox2);
        Assert.assertTrue(commonWebElements.assignOrdersButton.isDisplayed());
        Assert.assertTrue(commonWebElements.assignButtonLeft.isDisplayed());
        Assert.assertTrue(mapProductTotalButton.isDisplayed());
        Assert.assertTrue(assignPopup.isDisplayed());
    }

    public void clickOnAssignButton(String buttonType) {
        if (buttonType.equals("right") && commonWebElements.assignOrdersButton.isDisplayed()) {
            clickOnWebElement(commonWebElements.assignOrdersButton);
        } else if (buttonType.equals("left") && commonWebElements.assignButtonLeft.isDisplayed()) {
            clickOnWebElement(commonWebElements.assignButtonLeft);
        }
    }

    public boolean assertOrderImagesIcon() {
        clickOnWebElement(commonWebElements.expandAllList);
        new Actions(BrowserConfiguration.driver).moveToElement(assertOrderImagesIcon).perform();
        clickOnWebElement(assertOrderImagesIcon);
        return assertOrderImagesIcon.getAttribute("title").isEmpty();
    }

    public String assertOrderTabAssign() {
        clickOnWebElement(assignFirstOrder);
        commonWebElements.assignOrdersButton.isEnabled();
        assignPopUp.isEnabled();
        mapProductTotalButton.isEnabled();
        return getTextFromWebElement(firstAssignedOrderNumber);
    }

    public String findNoTenderOrder() {
        clickOnApplicatorTab();
        expandAllApplicators();
        if (isElementPresent(By.xpath(CommonConstants.NO_TENDER)))
            return noTenderOrder.getAttribute("title");
        else
            return null;
    }

    public void clickOnTendersTab() {
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.tendersTab, CommonConstants.SCHEDULE_PAGE);
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.tenderExpandAllList, CommonConstants.SCHEDULE_PAGE);
    }

    public void clickProductTotalButton() {
        clickOnWebElement(commonWebElements.productTotalButton);
    }

    public String assertTotalWorkHourSelected() {
        return getTextFromWebElement(totalWorkHourSelected);
    }

    public boolean assertOrderID() {
        return orderSelected.isDisplayed();
    }

    public void clickPrintButton() {
        switchToNextWindow(printButton, CommonConstants.ASSIGNED_ORDERS_PRODUCT_TOTAL_PAGE);
        Assert.assertTrue(BrowserConfiguration.driver.getTitle().equalsIgnoreCase(CommonConstants.ASSIGNED_ORDERS_PRODUCT_TOTAL_PAGE));
    }

    public void expandAllApplicators() {
        clickOnWebElementAndWaitForPageToLoad(expandAllApplicatorsIcon, CommonConstants.SCHEDULE_PAGE);
    }

    public void checkChangeAssignmentBtnStatus(String pageName) {
        if (pageName.equalsIgnoreCase("Applicator")) {
            Assert.assertFalse(commonWebElements.reAssignOrdersButton.isEnabled());
        } else if (pageName.equalsIgnoreCase("Tenders")) {
            Assert.assertFalse(changeTendersAssignmentButton.isEnabled());
        }
    }

    public void verifyAndClickChangeAssignmentBtn(String pageName) {
        if (pageName.equalsIgnoreCase("Applicator")) {
            Assert.assertTrue(commonWebElements.reAssignOrdersButton.isEnabled());
            clickOnWebElement(commonWebElements.reAssignOrdersButton);
        } else if (pageName.equalsIgnoreCase("Tenders")) {
            Assert.assertTrue(changeTendersAssignmentButton.isEnabled());
            clickOnWebElement(changeTendersAssignmentButton);
        }
        waitForByElement(By.xpath("//td[starts-with(@id,'Valid')]"));
    }

    public String findUniqueOrder(String entity) {
        String uniqueOrder = "";
        List<WebElement> orderList = BrowserConfiguration.driver.findElements(By.xpath("//ul[@id='" + entity + "']//a[starts-with(@class,'orderList')]"));
        for (int i = 0; i < orderList.size(); i++) {
            for (int j = i + 1; j < orderList.size(); j++) {
                if (orderList.get(i).getText().equalsIgnoreCase(orderList.get(j).getText())) {
                    break;
                } else {
                    if (j == orderList.size() - 1) {
                        return orderList.get(i).getText();
                    }
                }
            }
        }
        return uniqueOrder;
    }

    public String selectUniqueOrderEntity(String entity, String uniqueOrder) {
        clickOnByElement(By.xpath("//*[@id='" + entity + "']//td[@title='" + uniqueOrder + "']/ancestor::tr[1]//input"));
        return getTextFromByElement(By.xpath(getSelectedEntity(entity, uniqueOrder)));
    }

    private String getSelectedEntity(String entityType, String uniqueOrder) {
        return "//*[@id='" + entityType + "']//a[contains(text(),'" + uniqueOrder + "')]" +
                "//ancestor::div[contains(@class,'OrderContainer')]/preceding-sibling::div//a[@class='equipStatusLink']";
    }

    public String assignToApplicator(String applicatorName) {
        List<WebElement> applicators = BrowserConfiguration.driver.findElements(By.xpath(CommonConstants.APPLICATOR_LIST));
        return assignTo(commonWebElements.orderAssignOkButton, applicators, applicatorName);
    }

    public String assignToTender(String tenderName) {
        List<WebElement> tenders = BrowserConfiguration.driver.findElements(By.xpath(CommonConstants.TENDER_LIST));
        return assignTo(tenderAssignOkButton, tenders, tenderName);
    }

    private String assignTo(WebElement webElement, List<WebElement> webElements, String entity) {
        String selectedEntityOnPopup = entity;
        for (WebElement elementToSelect : webElements) {
            if (!entity.equals(elementToSelect.getText())) {
                selectedEntityOnPopup = elementToSelect.getText();
                clickOnByElement(By.xpath("//td[contains(text(),'" + selectedEntityOnPopup + "')]/preceding-sibling::td/input"));
                clickOnWebElement(webElement);
                waitForPageTitleToBeAvailable(CommonConstants.SCHEDULE_PAGE);
                break;
            }
        }
        return selectedEntityOnPopup;
    }

    public void verifyReassignedOrderApplicator(String uniqueOrder, String applicatorName) {
        clickOnApplicatorTab();
        clickOnWebElement(commonWebElements.expandAllList);
        Assert.assertEquals(getTextFromByElement(By.xpath(getSelectedEntity("appList", uniqueOrder))), applicatorName);
    }

    public void verifyReassignedOrderTender(String uniqueOrder, String tenderName) {
        clickOnTendersTab();
        Assert.assertEquals(getTextFromByElement(By.xpath(getSelectedEntity("tenderList", uniqueOrder))), tenderName);
    }

    public int countWorkOrders() {
        clickOnApplicatorTab();
        expandAllApplicators();
        clickOnByElement(By.id("toggle" + workRecordApplicatorID + "Img"));
        return BrowserConfiguration.driver.findElements(By.xpath
                ("//div[@id=\"" + "App" + workRecordApplicatorID + "Orders" + "\"]/table/tbody/tr/td/input")).size();
    }

    public String assignOrderToApplicator_API() {
        clickOnWebElement(commonWebElements.ordersSubTab);
        clickOnWebElement(firstOrderCheckBox);
        String uiWorkRecordId = firstOrderCheckBox.getAttribute("value");
        clickOnWebElement(commonWebElements.assignOrdersButton);
        clickOnByElement(By.xpath(".//*[@id='appCheckbox" + workRecordApplicatorID + "']"));
        clickOnWebElement(commonWebElements.orderAssignOkButton);
        clickOnApplicatorTab();
        return uiWorkRecordId;
    }
}