package com.deere.global;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;

import static org.apache.commons.lang3.ArrayUtils.isNotEmpty;

public class ExecutionConfiguration {

    @BeforeSuite
    public void createTestReportFolder() {
        cleanReportDirectory(new File(System.getProperty("user.dir") + "//.TestReport//"));
        System.out.println("Download file directory created " + new File(CommonConstants.FILE_DOWNLOAD_DIRECTORY).mkdir());
        System.out.println("Screenshot Capture directory created " + new File(CommonConstants.IMAGE_LOGS_DIRECTORY).mkdir());
    }

    @BeforeMethod
    public void initializeDriver() {
        BrowserConfiguration.getDriver();
    }

    @AfterMethod
    public void quitDriver(ITestResult testResult) throws Exception {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot) BrowserConfiguration.driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(CommonConstants.IMAGE_LOGS_DIRECTORY + testResult.getName() + ".png"));
            System.out.println("Screenshot placed at path - " + new File(CommonConstants.IMAGE_LOGS_DIRECTORY + testResult.getName() + ".png \n"));
        }
        BrowserConfiguration.driver.quit();
    }

    private static boolean cleanReportDirectory(File directory) {
        if (directory == null) {
            return false;
        }
        if (!directory.exists()) {
            return true;
        }
        if (!directory.isDirectory()) {
            return false;
        }
        String[] list = directory.list();
        if (isNotEmpty(list)) {
            for (String dirName : list) {
                if (!"DirectoryHolder".equalsIgnoreCase(dirName)) {
                    File entry = new File(directory, dirName);
                    if (entry.isDirectory()) {
                        if (!cleanReportDirectory(entry)) {
                            return false;
                        }
                    } else if (!entry.delete()) {
                        return false;
                    }
                }
            }
        }
        return directory.delete();
    }
}