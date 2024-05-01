package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	
	}
	
	
	
	
	@FindBy(id = "useremail")
	public WebElement username;
	
	@FindBy(id = "password")
	public WebElement password;
	
	@FindBy(id = "login")
	public WebElement loginButton;
	
	public void loginToSFDC(String userEmail, String passWord) {
		this.username.sendKeys(userEmail);
		this.password.sendKeys(passWord);
		this.loginButton.click();
	}
	
	

}
