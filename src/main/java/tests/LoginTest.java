package tests;

import java.time.Duration;

import org.openqa.selenium.By;
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
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest {
	
	@BeforeSuite
	
	@BeforeTest
	public void setupDriver() {
		driver = BaseTest.getDriver("chrome", false);
	}
	
	@BeforeMethod(dependsOnGroups = {""})
	public void preCondtions() {
		System.out.println("Pre condtion login to app");
	}
	
	@AfterMethod
	public void postCondtions() {
		System.out.println("post condtion to home page of the app");
//		driver.quit();
	}
	
//	@Optional("browser")
	@Test(priority = 0, groups = {"regression", "smoke"}, dataProvider = "getcreds")
	public void test1(String userID, String pass) throws InterruptedException {
		
		System.out.println();
		driver.get("https://selenium-prd.firebaseapp.com");
		SoftAssert sa = new SoftAssert();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		sa.assertTrue(driver.findElement(By.id("email_field")).isDisplayed(), "Loginpage should be displayed");
		WebElement username = driver.findElement(By.id("email_field"));
		username.sendKeys(userID);
		driver.findElement(By.id("password_field")).sendKeys(pass);
		driver.findElement(By.xpath("//button[text()='Login to Account']")).click();
		WebElement homeTab = driver.findElement(By.xpath("//*[text()='Home']"));
		sa.assertTrue(homeTab.isDisplayed(), "Home page should be loaded");
		System.out.println("Continue");
		sa.assertAll();

	}
	
	@Test(priority = -1, groups = {"regression"}, dependsOnGroups = {"smoke"})
	public void test2() {
		System.out.println();
		driver.get("https://selenium-prd.firebaseapp.com");
		SoftAssert sa = new SoftAssert();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		sa.assertTrue(driver.findElement(By.id("email_field")).isDisplayed(), "Loginpage should be displayed");
		WebElement username = driver.findElement(By.id("email_field"));
		username.sendKeys("admin123@gmail.com");
		driver.findElement(By.id("password_field")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()='Login to Account']")).click();
		WebElement homeTab = driver.findElement(By.xpath("//*[text()='Home']"));
		sa.assertTrue(homeTab.isDisplayed(), "Home page should be loaded");
		System.out.println("Continue");
		sa.assertAll();
	}
	
	@DataProvider
	public Object[][] getcreds() {
		// logic to fetch set of credentials
		return new Object[][] {{"cred1@gmail.com","1234"} , {"admin@gmail.com","admin123"}} ;
	}
}
