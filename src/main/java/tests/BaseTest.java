package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseTest {
	public static WebDriver driver;

	public static WebDriver getDriver(String bName, boolean headLess) {

		bName = bName.toLowerCase();
		
		switch (bName) {
		case "chrome":

			if (headLess) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless", "--diable-gpu");
				driver = new ChromeDriver(options);
			} else {
				driver = new ChromeDriver();
			}
			break;

		case "safari":
			driver = new SafariDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			driver = null;
			System.out.println("You are only allowed to configure with chrome, safari and edge");
		}

		return driver;

	}

}
