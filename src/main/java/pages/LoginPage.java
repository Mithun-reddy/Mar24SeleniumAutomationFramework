package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "username")
	public WebElement username;
	
	@FindBy(id = "password")
	public WebElement password;
	
	@FindBy(id = "Login")
	public WebElement loginButton;
	
	@FindBy(xpath = "//*[@id='rememberUn']")
	public WebElement rememberMe;

	@FindBy(id = "error")
	public WebElement errorMessage;

	@FindBy(partialLinkText = "Forgot")
	public WebElement forgotPassword;

	@FindBy(id = "idcard-identity")
	public WebElement savedUsername;

	@FindBy(id = "un")
	public WebElement forgotUsername;
	
	public void loginToSFDC(String userEmail, String passWord) {
		logger.info("Siging in to application");
		this.username.sendKeys(userEmail);
		this.password.sendKeys(passWord);
		this.loginButton.click();
		logger.info("Should be signed in to application");
	}
	
	

}
