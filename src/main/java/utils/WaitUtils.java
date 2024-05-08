package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.WaitConstants;

/**
 * 
 */
public class WaitUtils {
	
	/**
	 * @param driver
	 * @param element
	 * @return
	 */
	public static boolean waitForElement(WebDriver driver, WebElement element) {
		boolean isElementFound = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitConstants.WAIT_FOR_ELEMENT_TO_BE_CLICKABLE);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			isElementFound = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isElementFound;
	}
	
	
	/**
	 * @param driver
	 * @param element
	 * @return
	 */
	public static boolean waitForElementToDisappear(WebDriver driver, WebElement element) {
		boolean isElementDisappeared = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitConstants.WAIT_FOR_ELEMENT_TO_DISAPPEAR);
		try {
			wait.until(ExpectedConditions.invisibilityOf(element));
			isElementDisappeared = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isElementDisappeared;
	}

}
