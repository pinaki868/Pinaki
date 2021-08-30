package com.deere.test_suites;

import com.deere.global.BrowserConfiguration;
import com.deere.page_actions.MobilePageActions;
import org.openqa.selenium.support.PageFactory;

public class MobileTestSuite {
    public static void test_TC13835() {
        MobilePageActions mobilePage = PageFactory.initElements(BrowserConfiguration.driver, MobilePageActions.class);
        mobilePage.openMobilePage();
        mobilePage.VerifyAndroidImage();
        mobilePage.VerifyIosImage();
        mobilePage.verifyAndroid();
        mobilePage.verifyIos();
    }
}