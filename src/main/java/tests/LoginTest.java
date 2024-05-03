package tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import listerners.TestListener;
import pages.LoginPage;
import utils.CommonUtils;
import utils.DataUtils;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {
	
	
	
	@BeforeMethod(dependsOnGroups = {""})
	public void preCondtions(Method name) {
		System.out.println("Pre condtion login to app");
		BaseTest.setDriver("chrome", false);
	}
	
	@AfterMethod
	public void postCondtions() {
		System.out.println("post condtion to home page of the app");
//		driver.quit();
		BaseTest.getDriver().close();
	}
	
	@Test
	public void verifyLoginWithCorrectCredentials() throws IOException {
		ExtentTest test = BaseTest.threadExtentTest.get();
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		driver.get(DataUtils.readLoginTestData("app.url"));
		lp.username.sendKeys(DataUtils.readLoginTestData("valid.username"));
		test.log(Status.INFO, "username is entered");
		lp.password.sendKeys(DataUtils.readLoginTestData("valid.password"));
		test.log(Status.INFO, "password is entered");
		CommonUtils.captureScreenShot(driver);
		throw new NoSuchElementException();
//		lp.loginButton.click();
//		test.log(Status.INFO, "login button is clicked");
		
	}
	@Test
	public void verifyLoginWithCorrectCredentials1() throws IOException {
//		BaseTest.test = BaseTest.extent.createTest("verifyLoginWithCorrectCredentials1");
		ExtentTest test = BaseTest.threadExtentTest.get();
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		driver.get(DataUtils.readLoginTestData("app.url"));
		lp.username.sendKeys(DataUtils.readLoginTestData("valid.username"));
		test.log(Status.INFO, "username is entered");
		lp.password.sendKeys(DataUtils.readLoginTestData("valid.password"));
		test.log(Status.INFO, "password is entered");
		CommonUtils.captureScreenShot(driver);
//		lp.loginButton.click();
		test.log(Status.INFO, "login button is clicked");
//		test.log(Status.PASS, "verifyLoginWithCorrectCredentials1");

	}
	@Test
	public void verifyLoginWithCorrectCredentials2() throws IOException {
//		BaseTest.test = BaseTest.extent.createTest("verifyLoginWithCorrectCredentials2");
		ExtentTest test = BaseTest.threadExtentTest.get();
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		driver.get(DataUtils.readLoginTestData("app.url"));
		lp.username.sendKeys(DataUtils.readLoginTestData("valid.username"));
		test.log(Status.INFO, "username is entered");
		lp.password.sendKeys(DataUtils.readLoginTestData("valid.password"));
		test.log(Status.INFO, "password is entered");
		CommonUtils.captureScreenShot(driver);
//		lp.loginButton.click();
//		test.log(Status.PASS, "verifyLoginWithCorrectCredentials2");

	}
}
