package com.deere.page_actions;

import com.deere.global.BrowserConfiguration;
import com.deere.global.CommonConstants;
import com.deere.global.CommonWebElements;
import com.deere.page_objects.HomePageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.deere.global.CommonFunctions.*;

public class HomePageActions extends HomePageObjects {
    CommonWebElements commonWebElements = PageFactory.initElements(BrowserConfiguration.driver, CommonWebElements.class);

    public void clickOnFeedbackTab() {
        clickOnWebElementAndWaitForPageToLoad(FeedbackTab, CommonConstants.FEEDBACK_PAGE);
    }

    public String assertFeedbackPage() {
        return getTextFromWebElement(FeedbackPage);
    }

    public List<WebElement> multipleCategoryDropdown() {
        return new Select(CategoryDropdown).getOptions();
    }

    public String categoryText() {
        return new Select(CategoryDropdown).getFirstSelectedOption().getText();
    }

    public void enterFeedback(String inputDetails) {
        typeInputDetails(FeedbackTextField, inputDetails);
    }

    public void clickOnSubmitFeedbackButton() {
        clickOnWebElementAndWaitForPageToLoad(SubmitFeedback, CommonConstants.FEEDBACK_PAGE);
    }

    public String assertFeedbackThankYou() {
        return getTextFromWebElement(ThankYouMessage);
    }

    public String assertHomekTab() {
        return getTextFromWebElement(commonWebElements.homeTab);
    }

    public String assertScheduledWork() {
        return getTextFromWebElement(ScheduledWork);
    }

    public String assertCompletedWork() {
        return getTextFromWebElement(CompletedWork);
    }

    public String assertIntegrationErrors() {
        return getTextFromWebElement(IntegrationErrors);
    }

    public String assertUnscheduledWork() {
        return getTextFromWebElement(UnscheduledWork);
    }

    public void clickOnUnscheduledWorkLink() {
        clickOnWebElementAndWaitForPageToLoad(UnscheduledWorkLink, CommonConstants.SCHEDULE_PAGE);
        navigateToHomeTab();
    }

    public void clickOnCompletedWorkLink() {
        clickOnWebElementAndWaitForPageToLoad(CompletedWorkLink, CommonConstants.COMPLETED_ORDERS_PAGE);
        navigateToHomeTab();
    }

    public void clickOnIntegrationErrorsLink() {
        clickOnWebElementAndWaitForPageToLoad(IntegrationErrorsLink, "Integration Error Summary");
        navigateToHomeTab();
    }

    public String assertValueOnScheduleLink() {
        return getTextFromWebElement(scheduledOrderCount);
    }

    public String assertValueOnScheduleWorkAcreLink() {
        return getTextFromWebElement(scheduledWork);
    }

    public String assertValueUnscheduledWorkLink() {
        return getTextFromWebElement(UnscheduledWorkLink);
    }

    public String assertValueUnscheduledWorkAcreLink() {
        return getTextFromWebElement(unscheduledWork);
    }

    public String assertValueCompletedWorkLink() {
        return getTextFromWebElement(CompletedWorkLink);
    }

    public String assertValueCompletedWorkAcreLink() {
        return getTextFromWebElement(completedWork);
    }

    public String assertValueIntegrationErrorsLink() {
        return getTextFromWebElement(IntegrationErrorsLink);
    }

    public void clickOnMyInfoTab() {
        clickOnWebElementAndWaitForPageToLoad(MyInfoTab, CommonConstants.MY_INFO_PAGE);
    }

    public void clickCheckBox() {
        if (!MyInfoCheckBox.isSelected()) {
            clickOnWebElement(MyInfoCheckBox);
        }
    }

    public void clickMyInfoSaveButton() {
        clickOnWebElement(commonWebElements.saveButton);
    }

    public String assertGetStartedHomePage() {
        return getTextFromWebElement(HomePageGettingStarted);
    }

    public void clickInstallationInstruction() {
        switchToNextTab(InstallationInstructionUpdate, 1, CommonConstants.JOHN_DEERE_US_PAGE);
        switchToPreviousTab(0, CommonConstants.AGLOGIC_HOME_PAGE);
    }

    public void clickOnHideGettingStartedLink() {
        clickOnWebElementAndWaitForPageToLoad(HomePageGettingStarted, CommonConstants.AGLOGIC_HOME_PAGE);
    }

    public void clickWhatsNew() {
        switchToNextTab(WhatsNewLink, 1, CommonConstants.WHATS_NEW_PAGE);
        switchToPreviousTab(0, CommonConstants.AGLOGIC_HOME_PAGE);
    }

    public void clickOnTermsOfUseLink() {
        switchToNextTab(TermsOfUseLink, 1, CommonConstants.JOHN_DEERE_US_PAGE);
    }

    public void mandatoryFieldClear() {
        MyInfoEmail.clear();
        MyInfoFirstName.clear();
        MyInfoLastName.clear();
    }

    public String assertRequiredFields() {
        return getTextFromWebElement(RequiredField);
    }

    public void changesFirstName(String inputDetails) {
        typeInputDetails(MyInfoFirstName, inputDetails);
    }

    public void clickMyInfoSaveButtonAfterChanges() {
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.saveButton, CommonConstants.AGLOGIC_HOME_PAGE);
        waitForInvisibilityOfSpinner();
    }

    public void clickOnChangepasswordLink() {
        switchToNextTab(ChangeOrResetPasswordLink, 1, CommonConstants.FORGOT_YOUR_PASSWORD_PAGE);
        switchToPreviousTab(0, CommonConstants.MY_INFO_PAGE);
    }

    public void notifyMeWithAnEmail() {
        if (notifyMeWithAnEmail.isSelected()) {
            clickOnWebElement(notifyMeWithAnEmail);
        } else {
            new Actions(BrowserConfiguration.driver).doubleClick(notificationCheckBox).perform();
        }
    }

    public boolean assertUsername() {
        return DisableUserName.isEnabled();
    }

    public void changeAccountAssociation() {
        clickOnWebElement(ChangeJohnDeereAccountAssociation);
        ChangeusernameandPasswordTextBox.isDisplayed();
    }

    public boolean assertNewUsername() {
        return NewUsername.isEnabled();
    }

    public boolean assertNewPassword() {
        return NewPassword.isEnabled();
    }

    public boolean assertVerifyButton() {
        return VerifyButton.isEnabled();
    }

    public boolean assertCloseDialog() {
        return CloseDialog.isEnabled();
    }

    public void actionCloseDialog() {
        CloseDialog.isEnabled();
        clickOnWebElement(CloseDialog);
        if (ChangeusernameandPasswordTextBox.isDisplayed()) {
            BrowserConfiguration.driver.close();
        }
    }

    public String assertNewUserError() {
        clickOnWebElement(ChangeJohnDeereAccountAssociation);
        clickOnWebElement(VerifyButton);
        return getTextFromWebElement(UserNameError);
    }

    public void navigateToHomeTab() {
        clickOnWebElementAndWaitForPageToLoad(commonWebElements.homeTab, CommonConstants.AGLOGIC_HOME_PAGE);
        waitForInvisibilityOfSpinner();
    }

    public Boolean assertScheduleWorkInAcre() {
        return waitForWebElement(scheduledWork).getAttribute("title").contains("Acre");
    }

    public void clickOnScheduledWork() {
        clickOnWebElementAndWaitForPageToLoad(scheduledWork, CommonConstants.SCHEDULE_PAGE);
        navigateToHomeTab();
    }

    public boolean assertCompletedWorkInAcre() {
        return waitForWebElement(completedWork).getAttribute("title").contains("Acre");
    }

    public void clickOnCompletedWork() {
        clickOnWebElementAndWaitForPageToLoad(completedWork, CommonConstants.COMPLETED_ORDERS_PAGE);
        navigateToHomeTab();
    }

    public boolean assertUnscheduledWorkInAcre() {
        return waitForWebElement(unscheduledWork).getAttribute("title").contains("Acre");
    }

    public void clickOnUnscheduledWork() {
        clickOnWebElementAndWaitForPageToLoad(unscheduledWork, CommonConstants.SCHEDULE_PAGE);
        navigateToHomeTab();
    }

    public void clickScheduledOrderCount() {
        clickOnWebElementAndWaitForPageToLoad(scheduledOrderCount, CommonConstants.SCHEDULE_PAGE);
        navigateToHomeTab();
    }
}