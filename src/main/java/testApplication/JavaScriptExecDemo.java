package testApplication;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JavaScriptExecDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement search =  driver.findElement(By.name("q"));
		js.executeScript("arguments[0].value='Selenium';", search);
		js.executeScript("arguments[0].click();", search);
//		search.sendKeys("Selenium");
		search.submit();
		Thread.sleep(2000);
		search.sendKeys();
		
		js.executeScript("window.scrollBy(0, 1800)");
		
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL);
		action.keyDown(Keys.TAB);
		action.keyUp(Keys.TAB);
		action.keyUp(Keys.CONTROL);
		action.build().perform();
		
	}

}
