package com.ecom.selenium.external.browser.popup;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class BrowserWindowTest {

	WebDriver driver;
	final String siteURL = "https://www.amazon.in/";
	final String driverPATH = "/home/wahidkhan74gmai/eclipse-workspace/amazontests/driver/geckodriver";

	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", driverPATH);
		driver = new FirefoxDriver();
		driver.get(siteURL);
	}

	@AfterMethod
	public void afterTest() {
		driver.close();
	}

	@Test
	public void verifyLocationWindowAmazonTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("nav-global-location-popover-link")).click();
		Thread.sleep(2000);
		String mainWindow = driver.getWindowHandle();

		// to handle all new open windows
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itrs = windows.iterator();

		while (itrs.hasNext()) {
			String childWindow = itrs.next();
			// switch to child window
			driver.switchTo().window(childWindow);
			driver.findElement(By.cssSelector("#GLUXZipUpdateInput")).sendKeys("500038");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#GLUXZipUpdate > span > input")).click();
		}
		driver.switchTo().window(mainWindow);

	}

}
