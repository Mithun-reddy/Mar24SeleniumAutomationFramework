package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import constants.FileConstants;

public class BaseTest {
	public static WebDriver driver;
	public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
	public static ExtentReports extent;
	public static ThreadLocal<ExtentTest> threadExtentTest = new ThreadLocal<ExtentTest>();
	public static ExtentTest test;
	public static Logger logger = LogManager.getLogger("BaseTest");
	
	@BeforeSuite
	public void doConfiguration() {
		extent = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(FileConstants.REPORT_PATH);
		extent.attachReporter(sparkReporter);

	}
	
	@AfterSuite
	public void tearDownConfig() {
		extent.flush();
	}
	
	public static void setDriver(String browserName,  boolean headLess) {
		WebDriver driver = BaseTest.getBrowserDriver(browserName, false);
		threadLocalDriver.set(driver);
	}
	
	public static WebDriver getDriver() {
		return threadLocalDriver.get();
	}

	public static WebDriver getBrowserDriver(String bName, boolean headLess) {
		bName = bName.toLowerCase();
		switch (bName) {
		case "chrome":
			if (headLess) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless", "--diable-gpu");
				driver = new ChromeDriver(options);
			} else {
				driver = new ChromeDriver();
			}
			break;

		case "safari":
			driver = new SafariDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			driver = null;
			logger.error("Driver Configuration failed");
			System.out.println("You are only allowed to configure with chrome, safari and edge");
		}
		return driver;
	}

}
