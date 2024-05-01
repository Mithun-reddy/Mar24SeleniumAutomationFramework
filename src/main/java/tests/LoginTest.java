package tests;

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
	public void verifyLoginWithCorrectCredentials() {
		
		WebDriver driver = BaseTest.getDriver();
		driver.get("https://login.salesforce.com");
		
		
	}
}
