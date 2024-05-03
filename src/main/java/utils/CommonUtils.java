package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import constants.FileConstants;

public class CommonUtils {

	public static String captureScreenShot(WebDriver driver) {
		String filePath = FileConstants.SCREENSHOTS_FOLDER_PATH;
		TakesScreenshot page = (TakesScreenshot) driver;
		File src = page.getScreenshotAs(OutputType.FILE);
		File dst = new File(filePath);
		src.renameTo(dst);
		return filePath;
	}

	public static String getTimeStamp() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}

	public static void mouseHover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		
	}
	

}
