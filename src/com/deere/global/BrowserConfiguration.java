package com.deere.global;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.ResourceBundle;

import static com.deere.global.CommonConstants.BROWSER;

public class BrowserConfiguration {
    public static WebDriver driver;
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("aglogic");

    public static void getDriver() {
        if (BROWSER.equals("FireFox")) {
            driver = new FirefoxDriver();
        } else if (BROWSER.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", resourceBundle.getString("chromedriver.path"));

            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", CommonConstants.FILE_DOWNLOAD_DIRECTORY);
            ChromeOptions options = new ChromeOptions();

            options.addArguments("disable-infobars");

            HashMap<String, Object> chromeOptionsMap = new HashMap<>();
            options.setExperimentalOption("prefs", chromePrefs);
            options.addArguments("test-type");
            options.addArguments("disable-extensions");
            options.addArguments("disable-popup-blocking");

            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
            cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            cap.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new ChromeDriver(cap);
        }
    }
}