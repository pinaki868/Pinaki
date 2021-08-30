package com.deere.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObjects {

    @FindBy(xpath = ".//*[@id='remainingAcres']")
    protected WebElement scheduledWork;

    @FindBy(xpath = ".//*[@id='totalCompletedAcres']")
    protected WebElement completedWork;

    @FindBy(xpath = ".//*[@id='remainingOpenOrderAcres']")
    protected WebElement unscheduledWork;

    @FindBy(xpath = ".//*[@id='scheduledOrderCount']")
    protected WebElement scheduledOrderCount;

    @FindBy(xpath = "//*[@id='toplinkNav']/ul/li[7]/a")
    protected WebElement FeedbackTab;

    @FindBy(xpath = "//*[@id='feedback']/h3")
    protected WebElement FeedbackPage;

    @FindBy(xpath = "//*[@id='category']")
    protected WebElement CategoryDropdown;

    @FindBy(id = "feedbackText")
    protected WebElement FeedbackTextField;

    @FindBy(xpath = "//*[@id='feedback']/fieldset/ul/li[4]/ul/li/input")
    protected WebElement SubmitFeedback;

    @FindBy(xpath = "//div[@id='content']/h3")
    protected WebElement ThankYouMessage;

    @FindBy(xpath = ".//*[@id='dashboardList']/li[1]/dl/dt")
    protected WebElement ScheduledWork;

    @FindBy(xpath = ".//*[@id='dashboardList']/li[2]/dl/dt")
    protected WebElement CompletedWork;

    @FindBy(xpath = ".//*[@id='dashboardList']/li[3]/dl/dt")
    protected WebElement UnscheduledWork;

    @FindBy(xpath = ".//*[@id='dashboardList']/li[4]/dl/dt")
    protected WebElement IntegrationErrors;

    @FindBy(xpath = ".//*[@id='openOrderCount']")
    protected WebElement UnscheduledWorkLink;

    @FindBy(xpath = ".//*[@id='completedOrderCount']")
    protected WebElement CompletedWorkLink;

    @FindBy(xpath = ".//*[@id='restErrorCount']")
    protected WebElement IntegrationErrorsLink;

    @FindBy(xpath = ".//*[@id='myinfo']")
    protected WebElement MyInfoTab;

    @FindBy(xpath = ".//*[@id='displayGettingStartedCheckbox']")
    protected WebElement MyInfoCheckBox;

    @FindBy(xpath = ".//*[@id='stopShowingGS']")
    protected WebElement HomePageGettingStarted;

    @FindBy(xpath = ".//*[@id='impGuideNotification']/a")
    protected WebElement InstallationInstructionUpdate;

    @FindBy(xpath = " .//*[@id='pageContainer']/div[4]/a")
    protected WebElement WhatsNewLink;

    @FindBy(xpath = "//li/a[text()='Terms of Use']")
    protected WebElement TermsOfUseLink;

    @FindBy(xpath = ".//*[@id='email']")
    protected WebElement MyInfoEmail;

    @FindBy(xpath = ".//*[@id='firstname']")
    protected WebElement MyInfoFirstName;

    @FindBy(xpath = ".//*[@id='lastname']")
    protected WebElement MyInfoLastName;

    @FindBy(xpath = ".//*[@id='user.email.errors']")
    protected WebElement RequiredField;

    @FindBy(xpath = ".//*[@id='editUserForm']/table/tbody/tr/td[1]/div/a")
    protected WebElement ChangeOrResetPasswordLink;

    @FindBy(xpath = ".//*[@id='editUserForm']/table/tbody/tr/td[2]/a")
    protected WebElement ChangeJohnDeereAccountAssociation;

    @FindBy(xpath = ".//*[@id='editUserForm']/table/tbody/tr/td[2]/div/div")
    protected WebElement ChangeusernameandPasswordTextBox;

    @FindBy(xpath = ".//*[@id='assetChangeNotificationCheckbox']")
    protected WebElement notifyMeWithAnEmail;

    @FindBy(xpath = ".//*[@id='user.username']")
    protected WebElement DisableUserName;

    @FindBy(xpath = ".//*[@id='newUserName']")
    protected WebElement NewUsername;

    @FindBy(xpath = ".//*[@id='newPassword']")
    protected WebElement NewPassword;

    @FindBy(xpath = ".//*[@id='verifyButton']")
    protected WebElement VerifyButton;

    @FindBy(xpath = ".//*[@id='closeAuthDialog']")
    protected WebElement CloseDialog;

    @FindBy(xpath = ".//*[@id='newUsername.errors']")
    protected WebElement UserNameError;

    @FindBy(xpath = "//*[@id='assetChangeNotificationCheckbox']")
    protected WebElement notificationCheckBox;
}