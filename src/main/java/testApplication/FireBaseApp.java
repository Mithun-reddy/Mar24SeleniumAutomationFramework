package testApplication;
import org.openqa.selenium.*;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

public class FireBaseApp {
	static WebDriver driver;
	
	public static void mouseHover(WebElement element) {
		Actions action = new Actions(driver);
		action. moveToElement(element).build().perform();
	}
	
	public static void dragAndDrop(WebElement element1, WebElement element2) {
		Actions action = new Actions(driver);
		Dimension size = element2.getSize();
		action.dragAndDropBy(element1, size.getHeight()/2, size.getWidth()/2).build().perform();
//		action.dragAndDrop(element1, element2).build().perform();
//		action.clickAndHold(element1).moveToElement(element2).release().build().perform();
	}
	
	public static void selectAnOptionFromDropDown(WebElement dropDown, String value) {
		Select cityDropDown = new Select(dropDown);
		cityDropDown.selectByVisibleText(value);
	}


	public static void main(String[] args) throws InterruptedException {
		
//		System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver-mac-arm64 2/chromedriver");
		
		driver = new SafariDriver();
		
		driver.get("https://selenium-prd.firebaseapp.com");
		
		driver.manage().window().maximize();
//		driver.findElement(By.linkText("Terms of use")).click();
		
//		List<WebElement> links =driver.findElements(By.tagName(""));	
		
		WebElement username =  driver.findElement(By.id("email_field"));
		username.sendKeys("admin123@gmail.com");
		
		driver.findElement (By.id("password_field")).sendKeys("admin123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Login to Account']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Home']")).click();
//		WebElement ele =  driver.findElement(By.id("rememberUn"));
//		ele.click();
		Thread.sleep(3000);
//		if(!(ele.isSelected())) {
//			ele.click();
//		} else {
//			System.out.println("Checkbox is already selected");
		
		WebElement switchTo = driver.findElement(By.xpath("//*[contains(text(),'Intractions')]"));
		FireBaseApp.mouseHover(switchTo);
		
//		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[text()='Drag & Drop']")).click();
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//button[text()='Window Alert']")).click();
//		Thread.sleep(3000);
//		driver.switchTo().alert().accept();
		
//		}
//		WebElement cityDd = driver.findElement(By.id("city"));
//		
//		FireBaseApp.selectAnOptionFromDropDown(cityDd, "GOA");
		
//		FireBaseApp.mouseHover(driver.findElement(By.className("tooltipl")));
		WebElement cat =  driver.findElement(By.id("drag1"));
		WebElement rightBox = driver.findElement(By.xpath("//div[@id='div1'][2]"));
		
		FireBaseApp.dragAndDrop(cat, rightBox);
		
		Thread.sleep(3000);
//		String actualLeftToolTipText = driver.findElement(By.className("tooltiptextl")).getText();
//		Thread.sleep(3000);
//		if(actualLeftToolTipText.equals("Left")) {
//			System.out.println("Tool tip messgae is verified");
//		}
		
//		driver.findElement(By.xpath("//input[@value='female']")).click();
		
		Thread.sleep(3000);
		driver.close();
		

	}

}
