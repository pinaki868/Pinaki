package com.deere.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CustomerFarmFieldPageObjects {

    @FindBy(how = How.ID, id = "numberOfCustomers")
    protected WebElement NoofCustomers;

    @FindBy(how = How.ID, id = "clientName1")
    protected WebElement customer1;

    @FindBy(how = How.ID, id = "customerTab3")
    protected WebElement deletecustomerfarmfield;

    @FindBy(how = How.ID, id = "FieldName")
    protected WebElement FieldNameField;

    @FindBy(how = How.XPATH, xpath = "//*[@id='page-buttons']/input[1]")
    protected WebElement DeleteButton;

    @FindBy(how = How.XPATH, xpath = "//*[@id='page-buttons']/input[2]")
    protected WebElement CancelButton;

    @FindBy(how = How.XPATH, xpath = ".//*[@id='deleteForm']/label")
    protected WebElement deletefarm;

    @FindBy(how = How.ID, id = "customerTab2")
    protected WebElement customertab;

    @FindBy(how = How.XPATH, xpath = ".//*[@id='expandAllButton']/img")
    protected WebElement expandButton;

    @FindBy(how = How.ID, id = "farmName11")
    protected WebElement verifyFarmName;

    @FindBy(how = How.ID, id = "farmName21")
    protected WebElement verifysFarmName;

    @FindBy(how = How.ID, id = "fieldName211")
    protected WebElement verifyFieldName;

    @FindBy(how = How.ID, id = "fieldName111")
    protected WebElement verifySFieldName;

    @FindBy(how = How.ID, id = "nextPgImg")
    protected WebElement forwardButton;

    @FindBy(how = How.ID, id = "prevPgImg")
    protected WebElement backButton;

    @FindBy(how = How.ID, id = "lastPgImg")
    protected WebElement firstButton;

    @FindBy(how = How.ID, id = "firstPgImg")
    protected WebElement lastButton;

    @FindBy(how = How.XPATH, xpath = "//*[@id='numberOfCustomers']/option[1]")
    protected WebElement Option1;

    @FindBy(how = How.XPATH, xpath = "//*[@id='numberOfCustomers']/option[2]")
    protected WebElement Option2;

    @FindBy(how = How.XPATH, xpath = "//*[@id='numberOfCustomers']/option[3]")
    protected WebElement Option3;

    @FindBy(how = How.XPATH, xpath = "//*[@id='exportLink']/a")
    protected WebElement exportToCSVButton;

    @FindBy(xpath = "//a[contains(.,'Print this Page')]")
    protected WebElement printThisPage;

    @FindBy(xpath = "//*[@id='searchForm']/div[1]/fieldset/label[4]")
    protected WebElement searchForm;

    @FindBy(xpath=".//*[@class='submit']")
    public WebElement searchButton;

    @FindBy(xpath="//*[contains(text(),'AAA')]/following::ul[2]")
    public WebElement cfField;

    @FindBy(xpath="//input[@class='shapefile'][1]")
    public WebElement shapeButton;

    @FindBy(xpath="//input[@class='shapefile'][2]")
    public WebElement boundaryButton;

    @FindBy(xpath="//*[@id='removeBoundaryButton']")
    public WebElement removeBoundary;
}