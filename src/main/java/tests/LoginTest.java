package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseTest {
	
	@Test
	public void firstTest() {
		WebDriver driver = BaseTest.getDriver("chrome", false);
		LoginPage lp = new LoginPage(driver);
		driver.get("");
//		lp.username.sendKeys("");
//		lp.password.sendKeys("");
//		lp.loginButton.click();
		lp.loginToSFDC("", "");
	}
	
	
}
