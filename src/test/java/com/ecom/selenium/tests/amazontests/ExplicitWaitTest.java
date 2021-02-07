package com.ecom.selenium.tests.amazontests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class ExplicitWaitTest {
	
	WebDriver driver;
	WebDriverWait wait;
	final String siteURL = "https://www.amazon.in/";
	final String driverPATH = "/home/wahidkhan74gmai/eclipse-workspace/amazontests/driver/geckodriver";
	
	/**
	 * The Explicit wait is used to tell selenium web driver to wait for a certain conditions
	 * (Explicit Condition for wait )
	 * Once time is maximum or Element not visible Exception.
	 * 
	 */
	
	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver",driverPATH);
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get(siteURL);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
	@Test
	public void mobileLinkTest() {
		WebElement mlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-xshop\"]/a[2]")));
		mlink.click();
		String actual = "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
		assertEquals(actual, driver.getTitle());
	}

}
