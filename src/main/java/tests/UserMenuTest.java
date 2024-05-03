package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import constants.FileConstants;
import constants.WaitConstants;
import listerners.TestListener;
import pages.LoginPage;
import pages.UserMenuPage;
import utils.DataUtils;

@Listeners(TestListener.class)
public class UserMenuTest extends BaseTest {
	
	@BeforeMethod()
	public void preCondtions() {
		System.out.println("Pre condtion login to app");
		BaseTest.setDriver("chrome", false);
	}
	
	@AfterMethod
	public void postCondtions() {
		System.out.println("post condtion to home page of the app");
	}
	
	@Test
	public void verifyMyProfile_TC06() throws IOException, InterruptedException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
		lp.loginToSFDC(DataUtils.readLoginTestData("valid.username"), DataUtils.readLoginTestData("valid.password"));
		ump.selectUserMenu();
		Assert.assertTrue(ump.selectUserMenuOption(driver, "My Profile"), "UserMenu option should be selected");
		ump.selectEditIcon(driver);
		Assert.assertTrue(ump.verifyEditContactIframe(driver), "Iframe should be loaded");
		Assert.assertTrue(ump.verifyLastNameChangeInAboutTab(driver, "QA"), "LastName should be changed");
		Assert.assertTrue(ump.verifyCreatePost(driver, "Hello JAva"), "Post should be created");
		Assert.assertTrue(ump.verifyFileUpload(driver, FileConstants.FILE_PATH), "File should be uploaded successfully");
		Assert.assertTrue(ump.verifyPhotoUpload(driver, FileConstants.IMAGE_PATH), "Photo should be uploaded successfully");
		driver.quit();
	}
	
	
	

}
