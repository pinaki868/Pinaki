package com.deere.page_actions;

import com.deere.global.BrowserConfiguration;
import com.deere.global.CommonConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.deere.global.CommonFunctions.*;

public class MobilePageActions {

    @FindBy(xpath = "//*[@id='appCheck']//*[@href='https://play.google.com/store/apps/details?id=com.deere.aglogictender']")
    private WebElement androidlogo;

    @FindBy(xpath = ".//*[@id='appCheck']/li[2]/a[2]")
    private WebElement ioslogo;

    public void openMobilePage() {
        BrowserConfiguration.driver.get(CommonConstants.MOBILE_URL);
        waitForContainsPageTitleToBeAvailable(CommonConstants.AGLOGIC_MOBILE_PAGE);
        Assert.assertEquals(CommonConstants.AGLOGIC_MOBILE_PAGE, BrowserConfiguration.driver.getTitle());
    }

    public void verifyAndroid() {
        clickOnWebElement(androidlogo);
        waitForContainsPageTitleToBeAvailable(CommonConstants.ANDROID_APPS_PAGE);
        Assert.assertTrue(BrowserConfiguration.driver.getTitle().contains(CommonConstants.ANDROID_APPS_PAGE));
        Assert.assertTrue(BrowserConfiguration.driver.getTitle().contains(CommonConstants.AGLOGIC_TENDER_PAGE));
        BrowserConfiguration.driver.get(CommonConstants.MOBILE_URL);
    }

    public void verifyIos() {
        clickOnWebElementAndWaitForPageToLoad(ioslogo, CommonConstants.TENDER_APPS_PAGE);
        Assert.assertEquals(BrowserConfiguration.driver.getTitle(), CommonConstants.TENDER_APPS_PAGE);
    }

    public void VerifyAndroidImage() {
        Assert.assertTrue(waitForWebElement(androidlogo).isDisplayed());
    }

    public void VerifyIosImage() {
        Assert.assertTrue(waitForWebElement(ioslogo).isDisplayed());
    }
}