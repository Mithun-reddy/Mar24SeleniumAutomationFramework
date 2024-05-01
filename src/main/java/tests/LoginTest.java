package tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.DataUtils;

public class LoginTest extends BaseTest {
	
	@BeforeSuite
	
	@BeforeTest
	public void setupDriver() {
	}
	
	@BeforeMethod(dependsOnGroups = {""})
	public void preCondtions() {
		System.out.println("Pre condtion login to app");
		BaseTest.setDriver("chrome", false);
	}
	
	@AfterMethod
	public void postCondtions() {
		System.out.println("post condtion to home page of the app");
//		driver.quit();
	}
	
	@Test
	public void verifyLoginWithCorrectCredentials() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		driver.get(DataUtils.readLoginTestData("app.url"));
		lp.username.sendKeys(DataUtils.readLoginTestData("valid.username"));
		lp.password.sendKeys(DataUtils.readLoginTestData("valid.password"));
		lp.loginButton.click();
		driver.quit();
	}
//	@Test
	public void verifyLoginWithCorrectCredentials1() {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		driver.get("https://login.salesforce.com");
		lp.username.sendKeys("jul22.mithun@ta.com");
		lp.password.sendKeys("Sfdc@2024");
		lp.loginButton.click();
		driver.quit();
	}
//	@Test
	public void verifyLoginWithCorrectCredentials2() {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		driver.get("https://login.salesforce.com");
		lp.username.sendKeys("jul22.mithun@ta.com");
		lp.password.sendKeys("Sfdc@2024");
		lp.loginButton.click();
		driver.quit();
	}
}
