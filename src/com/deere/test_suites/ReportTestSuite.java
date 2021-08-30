package com.deere.test_suites;

import com.deere.global.*;
import com.deere.page_actions.ManagementPageActions;
import com.deere.page_actions.ReportPageActions;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;

public class ReportTestSuite {
    public static void test_TC13780() throws Throwable {
        ReportPageActions reportPage = PageFactory.initElements(BrowserConfiguration.driver, ReportPageActions.class);
        ManagementPageActions managementPage = PageFactory.initElements(BrowserConfiguration.driver, ManagementPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        reportPage.clickOnReportsTab();
        reportPage.clickOnCompletedOrderTab();
        reportPage.assertSearchDetails();
        managementPage.navigateToSchedulePageOptionsPage();
        String selectedValue = reportPage.verifyUOMinSearch();
        reportPage.assertSearchDetails();
        String[] valuesInQuotes = StringUtils.substringsBetween(reportPage.getGrandTotal(), "(", ")");
        Assert.assertEquals(valuesInQuotes[1], selectedValue);
        reportPage.clickOnExportButton();
        CommonFunctions.verifyExportedFile("completedOrders.csv");
        String column = "Date,Location,Order #,Customer,Farm,Field,Completed Area,Unit,WO(Area),Unit,Quantity,Unit,Rate,Unit,Applicator(s)";
        Assert.assertEquals(column, new LineNumberReader(new FileReader(new File(CommonConstants.FILE_DOWNLOAD_DIRECTORY + "completedOrders.csv"))).readLine());
    }

    public static void test_TC13781() {
        ReportPageActions reportPage = PageFactory.initElements(BrowserConfiguration.driver, ReportPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        reportPage.clickOnReportsTab();
        reportPage.clickBlendSummary();
        reportPage.clickOnBlendSummaryDateRange();
        reportPage.clickOnBlendSummaryLast7Days();
        reportPage.clickOnSearch(CommonConstants.BLEND_SUMMARY_PAGE);
        reportPage.dateWithInSelected();
        reportPage.orderStatus();
        reportPage.dateSortingResults();
        reportPage.orderNumberResults();
    }

    public static void test_TC13782() {
        ReportPageActions reportPage = PageFactory.initElements(BrowserConfiguration.driver, ReportPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        reportPage.clickOnReportsTab();
        reportPage.operatorStatisticsTab();
        reportPage.assertDate();
        reportPage.clickOnSearch(CommonConstants.OPERATOR_STATISTICS_PAGE);
        reportPage.clickOnExportButton();
        CommonFunctions.verifyExportedFile("OperatorStatistics.xlsm");
        reportPage.assertGroupDate();
        Assert.assertEquals(reportPage.assertWTacre(), "WO(Area)");
        Assert.assertEquals(reportPage.assertGrandTotal(), "Grand Total");
    }

    public static void test_TC13783() {
        ReportPageActions reportPage = PageFactory.initElements(BrowserConfiguration.driver, ReportPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        reportPage.clickOnReportsTab();
        reportPage.clickDeletedOrdersTab();
        reportPage.selectDateRange();
        reportPage.clickOnSearch(CommonConstants.DELETED_ORDERS_PAGE);
        Assert.assertEquals(reportPage.assertOrder(), "Order #");
        Assert.assertEquals(reportPage.assertCustomerFarmFieldTitle(), "Customer Farm Field");
        Assert.assertEquals(reportPage.assertDeletedBy(), "Deleted By");
        Assert.assertTrue(reportPage.assertDateRowPresent());
    }

    public static void test_TC13784() {
        ReportPageActions reportPage = PageFactory.initElements(BrowserConfiguration.driver, ReportPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        reportPage.clickOnReportsTab();
        reportPage.clickApplicatorStatisticsTab();
        reportPage.selectDateRange();
        reportPage.clickOnSearch();
        CommonFunctions.waitForContainsPageTitleToBeAvailable("Applicator");
        Assert.assertTrue(reportPage.assertPageTitle().contains("Applicator"));
    }

    public static void test_TC13787() {
        ReportPageActions reportPage = PageFactory.initElements(BrowserConfiguration.driver, ReportPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        reportPage.clickOnReportsTab();
        reportPage.clickOnCompletedOrderTab();
        reportPage.clickdaterange();
        reportPage.clickOnSearch(CommonConstants.COMPLETED_ORDERS_PAGE);
        String O1 = reportPage.getOrderNumber();
        reportPage.clickOnOrderNumberLink();
        String O2 = reportPage.getOrderNumberOnDetailsPage();
        Assert.assertEquals(O1.trim(), O2.trim());
        reportPage.returnFromOrderDetailsPage();
        Assert.assertEquals(O1.trim(), O2.trim());
    }

    public static void test_TC13793() {
        ReportPageActions reportPage = PageFactory.initElements(BrowserConfiguration.driver, ReportPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        reportPage.clickOnReportsTab();
        reportPage.datePickupOnAssignedOrderSummary();
        reportPage.clickOnSearch(CommonConstants.ASSIGNED_ORDER_SUMMERY_PAGE);
        reportPage.assertTableContent();
    }

    public static void test_TC13794() {
        ReportPageActions reportPage = PageFactory.initElements(BrowserConfiguration.driver, ReportPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        reportPage.clickOnReportsTab();
        reportPage.clickOnApplicatorSchedule();
        CommonFunctions.waitForContainsPageTitleToBeAvailable("Applicator");
        reportPage.datePickupOnAssignedOrderSummary();
        reportPage.clickOnSearch();
        reportPage.verifyApplicatorScheduleReports();
        reportPage.checkApplicatorRate();
    }
}