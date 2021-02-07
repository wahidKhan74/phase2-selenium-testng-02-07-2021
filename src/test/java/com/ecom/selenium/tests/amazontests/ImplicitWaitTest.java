package com.ecom.selenium.tests.amazontests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class ImplicitWaitTest {
	
	WebDriver driver;
	final String siteURL = "https://www.amazon.in/";
	final String driverPATH = "/home/wahidkhan74gmai/eclipse-workspace/amazontests/driver/geckodriver";
	
	/**
	 * The Implicit wait in selenium tests is used for web driver to wait for a given time amount
	 * before throwing no such element. the default wait time is 0.
	 * One we use the implicit time the web driver waits for a  element for given time.
	 * 
	 */
	
	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver",driverPATH);
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(siteURL);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

	@Test
	public void testTitle() {
		String actual = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String expected = driver.getTitle();
		assertEquals(actual, expected);
	}
	
	@Test
	public void testMobileLink() {
		WebElement mlink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(3)"));
		mlink.click();
		String actual = "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
		assertEquals(actual, driver.getTitle());
	}


}
