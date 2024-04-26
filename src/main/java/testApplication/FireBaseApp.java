package testApplication;

import org.openqa.selenium.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Basic actions of webdriver
 * @author user mithun
 */
public class FireBaseApp {
	static WebDriver driver;

	public static void mouseHover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public static void dragAndDrop(WebElement element1, WebElement element2) {
		Actions action = new Actions(driver);
		Dimension size = element2.getSize();
//		action.dragAndDropBy(element1, size.getHeight()/2, size.getWidth()/2).build().perform();
		action.dragAndDrop(element1, element2).build().perform();
//		action.clickAndHold(element1).moveToElement(element2).release().build().perform();
	}

	public static void selectAnOptionFromDropDown(WebElement dropDown, String value) {
		Select cityDropDown = new Select(dropDown);
		cityDropDown.selectByVisibleText(value);
	}

	public static void explicityWait(By loc) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(loc));
	}
	

	public static WebElement fluentlyWait(By loc) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(loc);
			}
		});
		return element;
	}

	
	/**
	 * Call the function to login to the application while on login screen
	 * @param driver pass webdriver object
	 * @return boolean true if login is succcess
	 */
	public boolean loginToApp(WebDriver driver) {
		boolean isLoginSuccess = false;
		if(driver.findElement(By.id("email_field")).isDisplayed()) {
			driver.findElement(By.id("email_field")).sendKeys("admin123@gmail.com");
			driver.findElement(By.id("password_field")).sendKeys("admin123");
			driver.findElement(By.xpath("//button[text()='Login to Account']")).click();
			isLoginSuccess = true;
		} else {
			System.out.println("Email feild is not displayed");
		}
		return isLoginSuccess;
	}
	
	
	public static void main(String[] args) throws InterruptedException {

//		System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver-mac-arm64 2/chromedriver");
		ChromeOptions options  = new ChromeOptions();
		options.addArguments("--disbale-notifications");
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		
		driver = new ChromeDriver(options);

		driver.get("https://selenium-prd.firebaseapp.com");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		driver.findElement(By.linkText("Terms of use")).click();

//		List<WebElement> links =driver.findElements(By.tagName(""));	

		WebElement username = driver.findElement(By.id("email_field"));
		username.sendKeys("admin123@gmail.com");

		driver.findElement(By.id("password_field")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()='Login to Account']")).click();
//		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Home']")).click();
//		WebElement ele =  driver.findElement(By.id("rememberUn"));
//		ele.click();
		WebElement switchTo = driver.findElement(By.xpath("//*[contains(text(),'Intrac')]"));
		FireBaseApp.mouseHover(switchTo);
		driver.findElement(By.xpath("//a[text()='Drag & Drop']")).click();
		WebElement cat = driver.findElement(By.id("drag1"));
		WebElement rightBox = driver.findElement(By.xpath("//div[@id='div1'][2]"));
//		
		FireBaseApp.dragAndDrop(cat, rightBox);

		System.out.println("Drag and drop complete");
//		FireBaseApp.explicityWait(By.xpath(""));

//		for(int row = 1; row < 6; row++) {
//			for(int cell = 1; cell <= 4; cell++) {
//				String rowData = "";
//				if(row == 1) {
//					rowData = "/th["+cell+"]";
//					String data = driver.findElement(By.xpath("//table/tbody/tr["+row+"]"+rowData)).getText();
//					System.out.print (data+" ");
//				} else {
//					rowData = "/td["+cell+"]/input";
//					String data = driver.findElement(By.xpath("//table/tbody/tr["+row+"]"+rowData)).getAttribute("value");
//					System.out.print (data+" ");
//				}
//			}
//			System.out.println();
//		}

//		String parentFrameID = driver.getWindowHandle();
//		System.out.println(parentFrameID);
//		
//		driver.findElement(By.xpath("(//*[contains(text(),'Click To Open New')])[1]")).click();
//		
//		Thread.sleep(2000);
//		Set<String> windowIds = driver.getWindowHandles();
//		windowIds.remove(parentFrameID);
//		
//		String childWindow = "";
//		
//		for(String id: windowIds) {
//
//			childWindow = id;
//		}
//		System.out.println(childWindow);
//		
//		driver.switchTo().window(childWindow);
//		Thread.sleep(2000);
//		WebElement search =  driver.findElement(By.name("q"));
//		search.sendKeys("Padmaja");
//		search.submit();
//		Thread.sleep(3000);
//		driver.close();
//		
//		driver.switchTo().window(parentFrameID);

//		if(!(ele.isSelected())) {
//			ele.click();
//		} else {
//			System.out.println("Checkbox is already selected");

//		

//		Thread.sleep(3000);

//		driver.findElement(By.xpath("//a[text()='Drag & Drop']")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//button[text()='Window Alert']")).click();
//		Thread.sleep(3000);
//		driver.switchTo().alert().accept();

//		}
//		WebElement cityDd = driver.findElement(By.id("city"));
//		
//		FireBaseApp.selectAnOptionFromDropDown(cityDd, "GOA");

//		FireBaseApp.mouseHover(driver.findElement(By.className("tooltipl")));
//		Thread.sleep(3000);
//		String actualLeftToolTipText = driver.findElement(By.className("tooltiptextl")).getText();
//		Thread.sleep(3000);
//		if(actualLeftToolTipText.equals("Left")) {
//			System.out.println("Tool tip messgae is verified");
//		}

//		driver.findElement(By.xpath("//input[@value='female']")).click();

//		driver.switchTo().frame("contactInfoContentId");
//		driver.findElement(By.id("contactTab")).click();
//		driver.switchTo().parentFrame();

		Thread.sleep(3000);
		driver.close();

	}

}
