package com.deere.global;

import com.deere.page_objects.AgLogicUiLoginPageObjects;
import org.apache.commons.lang3.RandomStringUtils;
import org.jasypt.util.text.BasicTextEncryptor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import static com.deere.global.BrowserConfiguration.driver;

public class CommonFunctions extends AgLogicUiLoginPageObjects {

    public static String[] getTestData(String propertyFileName, String key) {
        return getTestData(propertyFileName).getProperty(key).split(";");
    }

    public static Properties getTestData(String propertyFileName) {
        Properties properties = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream resourceStream = loader.getResourceAsStream(propertyFileName)) {
            properties.load(resourceStream);
        } catch (IOException e) {
            e.getCause().printStackTrace();
        }
        return properties;
    }

    public static void waitForByElement(By element) {
        WebDriverWait wait = new WebDriverWait(BrowserConfiguration.driver, 60);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public static WebElement waitForWebElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(BrowserConfiguration.driver, 20);
        return (wait.until(ExpectedConditions.visibilityOf(element)));
    }

    public static void waitForPageTitleToBeAvailable(String pageTitle) {
        WebDriverWait wait = new WebDriverWait(BrowserConfiguration.driver, 60);
        wait.until(ExpectedConditions.titleIs(pageTitle));
        waitForInvisibilityOfRotator();
    }

    public static void waitForContainsPageTitleToBeAvailable(String pageTitle) {
        WebDriverWait wait = new WebDriverWait(BrowserConfiguration.driver, 60);
        wait.until(ExpectedConditions.titleContains(pageTitle));
    }

    public static void clickOnWebElement(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(BrowserConfiguration.driver, 60);
        wait.until(ExpectedConditions.visibilityOf(webElement)).click();
    }

    public static void clickOnWebElementAndWaitForPageToLoad(WebElement webElement, String landingPageTitle) {
        WebDriverWait wait = new WebDriverWait(BrowserConfiguration.driver, 60);
        waitForInvisibilityOfRotator();
        wait.until(ExpectedConditions.visibilityOf(webElement));
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
        wait.until(ExpectedConditions.titleIs(landingPageTitle));
        waitForInvisibilityOfRotator();
    }

    public static void clickOnByElement(By byElement) {
        WebDriverWait wait = new WebDriverWait(BrowserConfiguration.driver, 60);
        wait.until(ExpectedConditions.presenceOfElementLocated(byElement)).click();
    }

    public static void clickOnByElementAndWaitForPageToLoad(By byElement, String landingPageTitle) {
        WebDriverWait wait = new WebDriverWait(BrowserConfiguration.driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(byElement));
        wait.until(ExpectedConditions.presenceOfElementLocated(byElement)).click();
        wait.until(ExpectedConditions.titleIs(landingPageTitle));
    }

    public static String getTextFromByElement(By byLocator) {
        WebDriverWait wait = new WebDriverWait(BrowserConfiguration.driver, 60);
        return wait.until(ExpectedConditions.presenceOfElementLocated(byLocator)).getText().trim();
    }

    public static String getTextFromWebElement(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(BrowserConfiguration.driver, 60);
        return wait.until(ExpectedConditions.visibilityOf(webElement)).getText().trim();
    }

    public static boolean isElementPresent(By element) {
        return driver.findElements(element).size() != 0;
    }

    public static void waitForInvisibilityOfRotator() {
        try {
            int i = 0;
            while (driver.getPageSource().contains("jqmOverlay") && i++ < 30) {
                sleepTimeInSeconds(1);
                System.out.println("Page source locator available for " + i + " second(s)");
            }
            while ((isElementPresent(By.xpath("//div[@class='jqmOverlay']"))
                    || isElementPresent(By.xpath("//*[@id='waitDialog'][contains(@style,'block')]"))) && i++ < 30) {
                sleepTimeInSeconds(1);
                System.out.println("Rotator present for " + i + " second(s)");
            }
            waitForPageToLoad();
        } catch (Exception InvalidSelectorException) {
            System.out.println("InvalidSelectorException present");
        }
    }

    public static void waitForInvisibilityOfSpinner() {
        int i = 0;
        while (!isElementPresent(By.xpath("//img[@id='spinner'][contains(@style,'display: none;')]")) && i++ < 10) {
            sleepTimeInSeconds(1);
            System.out.println("Spinner present for " + i + " second(s)");
        }
    }

    public static void typeInputDetails(WebElement webElement, String inputDetails) {
        WebDriverWait wait = new WebDriverWait(BrowserConfiguration.driver, 60);
        waitForInvisibilityOfRotator();
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).clear();
        wait.until(ExpectedConditions.visibilityOf(webElement)).sendKeys(inputDetails);
    }

    public static void typeInputDetailsWithOutCheckingVisibility(WebElement webElement, String inputDetails) {
        WebDriverWait wait = new WebDriverWait(BrowserConfiguration.driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).clear();
        wait.until(ExpectedConditions.visibilityOf(webElement)).sendKeys(inputDetails);
    }

    public static void testNavigate(String tabName, String landingPageName) {
        clickOnByElement(By.xpath("//a[text()='" + tabName + "']"));
        waitForPageTitleToBeAvailable(landingPageName);
    }

    public static void switchToNextTab(int tabNumber, String pageTitle) {
        int i = 0;
        while (driver.getWindowHandles().size() < tabNumber && i++ < 5) {
            sleepTimeInSeconds(5);
        }
        switchToTab(tabNumber, pageTitle);
    }

    public static void switchToNextTab(WebElement webElement, int tabNumber, String pageTitle) {
        int tabCount = driver.getWindowHandles().size();
        clickOnWebElement(webElement);
        int i = 0;
        while (tabCount >= driver.getWindowHandles().size() && i++ < 5) {
            sleepTimeInSeconds(5);
        }
        switchToTab(tabNumber, pageTitle);
    }

    public static void switchToPreviousTab(int tabNumber, String pageTitle) {
        int tabCount = driver.getWindowHandles().size();
        driver.close();
        int i = 0;
        while (tabCount <= driver.getWindowHandles().size() && i++ < 5) {
           sleepTimeInSeconds(5);
        }
        switchToTab(tabNumber, pageTitle);
    }

    private static void switchToTab(int tabNumber, String pageTitle) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber));
        waitForPageToLoad();
        waitForContainsPageTitleToBeAvailable(pageTitle);
        Assert.assertTrue(driver.getTitle().contains(pageTitle));
    }

    public static void switchToNextWindow(WebElement webElement, String pageTitle) {
        String originalHandle = driver.getWindowHandle();
        Set<String> firstWindow = driver.getWindowHandles();
        clickOnWebElement(webElement);
        int i = 5;
        while (i-- >= 0) {
            System.out.println(driver.getWindowHandles().size());
            if (firstWindow.size() >= driver.getWindowHandles().size()) {
                sleepTimeInSeconds(3);
            } else {
                for (String handle : driver.getWindowHandles()) {
                    if (!handle.equals(originalHandle)) {
                        driver.switchTo().window(handle);
                        waitForPageTitleToBeAvailable(pageTitle);
                    }
                }
                break;
            }
        }
    }

    public static void verifyExportedFile(String fileName) {
        int i = 0;
        while (!new File(CommonConstants.FILE_DOWNLOAD_DIRECTORY + fileName).exists() && i++ < 5) {
            System.out.println(i);
            sleepTimeInSeconds(3);
        }
        Assert.assertTrue(new File(CommonConstants.FILE_DOWNLOAD_DIRECTORY + fileName).exists());
    }

    public static String generateRandomAlphaNumeric(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public static double generateRandomNumber(int multiple) {
        return Math.floor((Math.random() * multiple) + 1);
    }

    public static void selectElementByIndex(WebElement element, int index) {
        new Select(element).selectByIndex(index);
    }

    public static void selectElementByText(WebElement element, String value) {
        new Select(element).selectByVisibleText(value);
    }

    public static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private static void sleepTimeInSeconds(Integer sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void waitForPageToLoad() {
        JavascriptExecutor js = (JavascriptExecutor) BrowserConfiguration.driver;
        js.executeScript("document.readyState === \"complete\"");
    }

    public static String decryptCredentials(String encryptedValue) {
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        encryptor.setPassword("aglogic");
        return encryptor.decrypt(encryptedValue);
    }
}