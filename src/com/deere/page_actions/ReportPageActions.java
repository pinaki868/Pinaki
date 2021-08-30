package com.deere.page_actions;

import com.deere.global.BrowserConfiguration;
import com.deere.global.CommonConstants;
import com.deere.global.CommonWebElements;
import com.deere.page_objects.ReportPageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.deere.global.CommonFunctions.*;

public class ReportPageActions extends ReportPageObjects {
    CommonWebElements commonWebElements = PageFactory.initElements(BrowserConfiguration.driver, CommonWebElements.class);

    public void clickOnApplicatorSchedule() {
        clickOnWebElement(applicatorSchedule);
    }

    public void clickOnSearch(String pageTitle) {
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.submitFilterButton, pageTitle);
    }

    public void clickOnSearch() {
        clickOnWebElement(commonWebElements.submitFilterButton);
    }

    public void operatorStatisticsTab() {
        clickOnWebElementAndWaitForPageToLoad(operatorStatistics, CommonConstants.OPERATOR_STATISTICS_PAGE);
    }

    public void assertDate() {
        verifyDate(selectYearToDays);
    }

    public void assertGroupDate() {
        Assert.assertNotSame(getTextFromWebElement(date1), getTextFromWebElement(date2));
    }

    public String assertWTacre() {
        return getTextFromWebElement(VerifyAcres);
    }

    public String assertGrandTotal() {
        return getTextFromWebElement(Grandtotal);
    }

    public String getGrandTotal() {
        return getTextFromWebElement(grandTotal);
    }

    public void clickOnExportButton() {
        clickOnWebElement(exportCSV);
    }

    public void clickOnReportsTab() {
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.reportsTab, CommonConstants.ASSIGNED_ORDER_SUMMERY_PAGE);
    }

    public void clickOnCompletedOrderTab() {
        clickOnWebElementAndWaitForPageToLoad(completedOrdersuTab, CommonConstants.COMPLETED_ORDERS_PAGE);
    }

    public void clickdaterange() {
        clickOnWebElement(DaterangeDp);
        clickOnWebElement(selectYearToDays);
    }

    public void assertSearchDetails() {
        Assert.assertTrue(Locationcolumn.isDisplayed());
        Assert.assertTrue(Ordercolumn.isDisplayed());
        Assert.assertTrue(Applicatorscolumn.isDisplayed());
        Assert.assertTrue(CompletedWOAreacolumn.isDisplayed());
        Assert.assertTrue(CustomerFarmFieldcolumn.isDisplayed());
        Assert.assertTrue(Quantitycolumn.isDisplayed());
        Assert.assertTrue(Ratecolumn.isDisplayed());
    }

    public String verifyUOMinSearch() {
        clickOnWebElementAndWaitForPageToLoad(UMOOption, CommonConstants.EDIT_PROGRAM_OPTIONS_PAGE);
        String selectedValue = getTextFromWebElement(new Select(AreaDropdown).getFirstSelectedOption());
        clickOnReportsTab();
        clickOnCompletedOrderTab();
        clickdaterange();
        clickOnSearch(CommonConstants.COMPLETED_ORDERS_PAGE);
        return selectedValue;
    }

    public void clickDeletedOrdersTab() {
        clickOnWebElementAndWaitForPageToLoad(deletedOrdersTab, CommonConstants.DELETED_ORDERS_PAGE);
    }

    public void selectDateRange() {
        verifyDate(YearToDate);
    }

    private void verifyDate(WebElement webElement) {
        clickOnWebElement(calendarButton);
        clickOnWebElement(webElement);
    }

    public String assertOrder() {
        return getTextFromWebElement(Order);
    }

    public String assertDeletedBy() {
        return getTextFromWebElement(DeletedBy);
    }

    public boolean assertDateRowPresent() {
        return DatePresentonDeletePage.isDisplayed();
    }

    public void clickApplicatorStatisticsTab() {
        clickOnWebElement(ApplicatorStatistics);
        waitForContainsPageTitleToBeAvailable("Statistics");
    }

    public String assertPageTitle() {
        return BrowserConfiguration.driver.getTitle();
    }

    public void datePickupOnAssignedOrderSummary() {
        clickOnWebElement(calendarButton);
        typeInputDetails(dateFromDatePicker, new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
    }

    public void assertTableContent() {
        List<WebElement> listElements = BrowserConfiguration.driver.findElements(By.xpath(CommonConstants.COLUMN_CONTAIN));
        ArrayList<String> valuesOfHeader = new ArrayList<>();
        for (int i = 1; i <= listElements.size(); i++) {
            valuesOfHeader.add(getTextFromByElement(By.xpath(CommonConstants.COLUMN_CONTAIN + "[" + i + "]")));
        }
        assertTableValue(valuesOfHeader);
    }

    private void assertTableValue(ArrayList<String> valuesOfHeader) {
        Assert.assertTrue(valuesOfHeader.get(0).contains("Location"));
        Assert.assertTrue(valuesOfHeader.get(1).contains("Order #"));
        Assert.assertTrue(valuesOfHeader.get(3).contains("Customer"));
        Assert.assertTrue(valuesOfHeader.get(4).contains("Area"));
        Assert.assertTrue(valuesOfHeader.get(5).contains("Analysis"));
        Assert.assertTrue(valuesOfHeader.get(6).contains("Quantity"));
        Assert.assertTrue(valuesOfHeader.get(7).contains("Rate"));
        Assert.assertTrue(valuesOfHeader.get(9).contains("Priority"));
    }

    public void clickBlendSummary() {
        clickOnWebElementAndWaitForPageToLoad(BlendSummary, CommonConstants.BLEND_SUMMARY_PAGE);
    }

    public void clickOnBlendSummaryDateRange() {
        clickOnWebElement(blendsummaryDaterange);
    }

    public void clickOnBlendSummaryLast7Days() {
        clickOnWebElement(blendsummaryTodays);
    }

    public void dateSortingResults() {
        Assert.assertEquals(BrowserConfiguration.driver.findElements(By.className("date-start-header")).size(), 1);
    }

    public void dateWithInSelected() {
        Assert.assertTrue(isElementPresent(By.className("date-start-header")));
    }

    public void orderNumberResults() {
        List<WebElement> listWebElement = BrowserConfiguration.driver.findElements(By.className("order-number-break-row"));
        for (WebElement Element : listWebElement) {
            Assert.assertTrue(Element.getText() != null);
        }
    }

    public void orderStatus() {
        Assert.assertFalse(isElementPresent(By.xpath(CommonConstants.ORDER_STATUS)));
    }

    public String getOrderNumber() {
        return getTextFromWebElement(orderNumber);
    }

    public void clickOnOrderNumberLink() {
        clickOnWebElementAndWaitForPageToLoad(orderNumber, CommonConstants.ORDER_DETAILS_PAGE);
    }

    public String getOrderNumberOnDetailsPage() {
        return getTextFromWebElement(orderDetailsNumber);
    }

    public void returnFromOrderDetailsPage() {
        clickOnWebElementAndWaitForPageToLoad(returnFromOrderDetails, CommonConstants.COMPLETED_ORDERS_PAGE);
    }

    public String assertCustomerFarmFieldTitle() {
        return Customer.getText().trim().concat(" " + Farm.getText().trim() + " " + Field.getText().trim());
    }

    public void verifyApplicatorScheduleReports() {
        waitForContainsPageTitleToBeAvailable(BrowserConfiguration.driver.getTitle());
        List<WebElement> applicatorName = BrowserConfiguration.driver.findElements(By.xpath(CommonConstants.APPLICATOR_REPORT_OPTIONS));
        List<String> currentOptions = new ArrayList<>();
        for (WebElement match : applicatorName) {
            currentOptions.add((match.getText()).trim());
        }
        List<WebElement> applicatorSearchResult = BrowserConfiguration.driver.findElements(By.xpath(CommonConstants.REPORT_HEADER));
        for (int i = 1; i < applicatorSearchResult.size(); i++) {
            String words[] = getTextFromByElement(By.xpath(CommonConstants.REPORT_HEADER + "[" + i + "]")).split("-");
            Assert.assertTrue(currentOptions.contains(words[0].trim()));
        }
    }

    public void checkApplicatorRate() {
        if (isElementPresent(By.xpath(CommonConstants.APPLICATOR_HECTARE_RATE))) {
            Assert.assertTrue(isElementPresent(By.xpath(CommonConstants.APPLICATOR_HECTARE_RATE)));
        } else if (isElementPresent(By.xpath(CommonConstants.APPLICATOR_ACRE_RATE1))) {
            Assert.assertTrue(isElementPresent(By.xpath(CommonConstants.APPLICATOR_ACRE_RATE1)));
        } else {
            Assert.assertTrue(isElementPresent(By.xpath(CommonConstants.APPLICATOR_ACRE_RATE2)));
        }
    }
}