package com.deere.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AgLogicUiLoginPageObjects {

    @FindBy(xpath = "id('checkAllUnassigned')")
    protected WebElement orderSelect;

    @FindBy(xpath = ".//*[@id='all-orders']")
    protected WebElement chkAllOrders;

    @FindBy(xpath = ".//*[@id='toggle-detailed-info']")
    protected WebElement btnMore;

    @FindBy(xpath = "//*[contains(text(), 'Logout')]")
    protected WebElement agLogicLogout;

    @FindBy(xpath = ".//*[@id='userName']")
    protected WebElement myJdUsername;

    @FindBy(xpath = ".//*[@id='password']")
    protected WebElement myJdPassword;

    @FindBy(xpath = "//*[@class='cta_btn']")
    protected WebElement myJdSingInButton;

    @FindBy(xpath = ".//*[@class='signout']")
    protected WebElement myJdLogout;

    @FindBy(xpath = "//*[@alt='AgLogic']")
    protected WebElement agLogicLink;

    @FindBy(xpath = ".//*[@id='passwordDetails']")
    protected WebElement forgotPassword;

    @FindBy(xpath = ".//*[@id='passDetail']/span[1]")
    protected WebElement migratedCustomers;

    @FindBy(xpath = ".//*[@id='passDetail']/span[2]")
    protected WebElement nonmigratedCustomers;

    @FindBy(xpath = ".//*[@id='forgotPasswordLink']")
    protected WebElement forgotPasswordClickHere;

    @FindBy(xpath = ".//*[@id='username']")
    protected WebElement TextBox;

    @FindBy(xpath = ".//*[contains(text(),'Submit')]")
    protected WebElement SubmitButton;

    @FindBy(xpath = ".//*[contains(text(),'Log Out')]")
    protected WebElement assertLogoutButton;

    @FindBy(xpath = "(.//*[@class='descContentWrapper'])[10]")
    protected WebElement assertAglogicIcon;

    @FindBy(xpath = "//span[contains(text(),'AgLogic™')]")
    protected WebElement assertAglogicTM;
}