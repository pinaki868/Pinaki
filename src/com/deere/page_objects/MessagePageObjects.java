package com.deere.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MessagePageObjects {

    @FindBy(xpath = ".//*[@id='messagesMenuItem']")
    protected WebElement messagesTab;

    @FindBy(xpath = ".//*[@type='checkbox' and @id='deleteAll']")
    protected WebElement deleteAllCheckbox;

    @FindBy(xpath = ".//*[@id='messages']/table/thead/tr/th[2]")
    protected WebElement reply;

    @FindBy(xpath = ".//*[@id='messages']/table/thead/tr/th[3]")
    protected WebElement from;

    @FindBy(xpath = ".//*[@id='messages']/table/thead/tr/th[4]")
    protected WebElement subject;

    @FindBy(xpath = ".//*[@id='messages']/table/thead/tr/th[5]")
    protected WebElement message;

    @FindBy(xpath = ".//*[@id='messages']/table/thead/tr/th[6]")
    protected WebElement date;

    @FindBy(xpath = ".//*[@id='createMessageButton']")
    protected WebElement createMessage;

    @FindBy(xpath = ".//*[@id='composeMessage']")
    protected WebElement composeMessagePopup;

    @FindBy(xpath = ".//*[@id='userId']")
    protected WebElement composeMessageToDropDown;

    @FindBy(xpath = ".//*[@id='subjectText']")
    protected WebElement composeMessageSubject;

    @FindBy(xpath = ".//*[@id='messageText']")
    protected WebElement composeMessage;

    @FindBy(xpath = ".//*[@id='sendButton']")
    protected WebElement composeMessageSend;

    @FindBy(xpath = ".//*[@id='composeMessage']/button[2]")
    protected WebElement composeMessageCancel;
}