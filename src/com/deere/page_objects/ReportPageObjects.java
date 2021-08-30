package com.deere.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportPageObjects {

    @FindBy(xpath = ".//*[@id='csvExport']")
    protected WebElement exportCSV;

    @FindBy(xpath = ".//*[@id='area']")
    protected WebElement AreaDropdown;

    @FindBy(xpath = ".//*[@id='grandtotal']")
    protected WebElement Grandtotal;

    @FindBy(xpath = "//*[@id='grandTotal']")
    protected WebElement grandTotal;

    @FindBy(xpath = ".//*[@id='pageContainer']/div/ul/li[7]/a")
    protected WebElement deletedOrdersTab;

    @FindBy(xpath = "html/body/div[6]/div/ul/li[4]/a")
    protected WebElement YearToDate;

    @FindBy(xpath = ".//*[@id='container']/table/thead/tr/th[2]/ul/li[1]")
    protected WebElement Customer;

    @FindBy(xpath = ".//*[@id='container']/table/thead/tr/th[2]/ul/li[2]")
    protected WebElement Farm;

    @FindBy(xpath = ".//*[@id='container']/table/thead/tr/th[2]/ul/li[3]")
    protected WebElement Field;

    @FindBy(xpath = ".//*[@id='pageContainer']/div/ul/li[2]/a/span")
    protected WebElement applicatorSchedule;

    @FindBy(xpath = ".//*[@id='calendarButton']")
    protected WebElement calendarButton;

    @FindBy(xpath = ".//*[@id='rdTo']")
    protected WebElement dateFromDatePicker;

    @FindBy(xpath = ".//*[@id='pageContainer']/div/ul/li[6]/a")
    protected WebElement operatorStatistics;

    @FindBy(xpath = "html/body/div[6]/div/ul/li[4]")
    protected WebElement selectYearToDays;

    @FindBy(xpath = "//*[@id='curdate1']")
    protected WebElement date1;

    @FindBy(xpath = "//*[@id='curdate2']")
    protected WebElement date2;

    @FindBy(xpath = "//*[@id='verifyWTAcres']")
    protected WebElement VerifyAcres;

    @FindBy(xpath = ".//*[@id='onumber1']/a")
    protected WebElement orderNumber;

    @FindBy(xpath = ".//*[@id='orderNumber']")
    protected WebElement orderDetailsNumber;

    @FindBy(linkText = "Return")
    protected WebElement returnFromOrderDetails;

    @FindBy(xpath = "//span[text()='Completed Orders']")
    protected WebElement completedOrdersuTab;

    @FindBy(xpath = "//*[text()='Location']")
    protected WebElement Locationcolumn;

    @FindBy(xpath = "//*[text()='Order #']")
    protected WebElement Ordercolumn;

    @FindBy(xpath = "//*[text()='Customer']")
    protected WebElement CustomerFarmFieldcolumn;

    @FindBy(xpath = "//*[text()='Completed/']")
    protected WebElement CompletedWOAreacolumn;

    @FindBy(xpath = "//*[text()='Quantity']")
    protected WebElement Quantitycolumn;

    @FindBy(xpath = "//*[text()='Rate']")
    protected WebElement Ratecolumn;

    @FindBy(xpath = "//*[text()='Applicator(s)']")
    protected WebElement Applicatorscolumn;

    @FindBy(xpath = "//*[text()='Unit of Measure Options']")
    protected WebElement UMOOption;

    @FindBy(xpath = ".//*[@id='startDate']")
    protected WebElement DaterangeDp;

    @FindBy(xpath = ".//*[@id='container']/table/thead/tr/th[1]")
    protected WebElement Order;

    @FindBy(xpath = ".//*[@id='container']/table/thead/tr/th[3]")
    protected WebElement DeletedBy;

    @FindBy(xpath = ".//*[@id='date']")
    protected WebElement DatePresentonDeletePage;

    @FindBy(xpath = ".//*[@id='pageContainer']/div/ul/li[5]/a")
    protected WebElement ApplicatorStatistics;

    @FindBy(xpath = "//span[text()='Blend Summary']")
    protected WebElement BlendSummary;

    @FindBy(xpath = ".//*[@id='rangeA']")
    protected WebElement blendsummaryDaterange;

    @FindBy(xpath = "html/body/div[6]/div/ul/li[2]/a")
    protected WebElement blendsummarylast7days;

    @FindBy(xpath = "html/body/div[6]/div/ul/li[1]/a")
    protected WebElement blendsummaryTodays;
}