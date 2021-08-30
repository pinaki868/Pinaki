package com.deere.test_suites;

import com.deere.global.ApplicationLogin;
import com.deere.global.BrowserConfiguration;
import com.deere.page_actions.MessagePageActions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MessageTestSuite {
    public static void test_TC13756() {
        MessagePageActions messagesPage = PageFactory.initElements(BrowserConfiguration.driver, MessagePageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        messagesPage.clickOnMessagesTab();
        Assert.assertTrue(messagesPage.assertInboxDeleteAllCheckbox());
        Assert.assertEquals(messagesPage.assertInboxReply(), "Reply");
        Assert.assertEquals(messagesPage.assertInboxFrom(), "From");
        Assert.assertEquals(messagesPage.assertInboxSubject(), "Subject");
        Assert.assertEquals(messagesPage.assertInboxMessage(), "Message");
        Assert.assertEquals(messagesPage.assertInboxDate(), "Date");
        messagesPage.clickOnCreateMessage();
        Assert.assertTrue(messagesPage.assertComposeMessagePopup());
        Assert.assertTrue(messagesPage.assertComposeMessageToDropDown() > 0);
        Assert.assertTrue(messagesPage.assertComposeMessageSubjectText());
        Assert.assertTrue(messagesPage.assertComposeMessageText());
        Assert.assertTrue(messagesPage.assertComposeMessageSend());
        Assert.assertTrue(messagesPage.assertComposeMessageCancel());
        messagesPage.clickOnComposeWindowCancel();
        messagesPage.clickOnReplyInboxMessages();
    }
}