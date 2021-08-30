package com.deere.page_actions;

import com.deere.global.BrowserConfiguration;
import com.deere.global.CommonConstants;
import com.deere.page_objects.MessagePageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

import static com.deere.global.CommonFunctions.*;

public class MessagePageActions extends MessagePageObjects {

    public void clickOnMessagesTab() {
        clickOnWebElementAndWaitForPageToLoad(messagesTab, CommonConstants.RECEIVED_MESSAGES_PAGE);
    }

    public boolean assertInboxDeleteAllCheckbox() {
        return deleteAllCheckbox.isDisplayed();
    }

    public String assertInboxReply() {
        return getTextFromWebElement(reply);
    }

    public String assertInboxFrom() {
        return getTextFromWebElement(from);
    }

    public String assertInboxSubject() {
        return getTextFromWebElement(subject);
    }

    public String assertInboxMessage() {
        return getTextFromWebElement(message);
    }

    public String assertInboxDate() {
        return getTextFromWebElement(date);
    }

    public void clickOnCreateMessage() {
        clickOnWebElement(createMessage);
    }

    public boolean assertComposeMessagePopup() {
        return composeMessagePopup.isDisplayed();
    }

    public int assertComposeMessageToDropDown() {
        return new Select(composeMessageToDropDown).getOptions().size();
    }

    public boolean assertComposeMessageSubjectText() {
        return composeMessageSubject.isEnabled();
    }

    public boolean assertComposeMessageText() {
        return composeMessage.isEnabled();
    }

    public boolean assertComposeMessageSend() {
        return composeMessageSend.isEnabled();
    }

    public boolean assertComposeMessageCancel() {
        return composeMessageCancel.isEnabled();
    }

    public void clickOnComposeWindowCancel() {
        clickOnWebElement(composeMessageCancel);
    }

    public void clickOnReplyInboxMessages() {
        List<WebElement> replyLink = BrowserConfiguration.driver.findElements(By.xpath(CommonConstants.HYPERLINK));
        if (!replyLink.isEmpty()) {
            clickOnByElement(By.xpath(".//*[@id='" + replyLink.get(0).getAttribute("id") + "']"));
            Assert.assertTrue(assertComposeMessagePopup());
            clickOnComposeWindowCancel();
        }
    }
}