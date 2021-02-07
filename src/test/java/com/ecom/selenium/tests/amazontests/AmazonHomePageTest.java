package com.ecom.selenium.tests.amazontests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class AmazonHomePageTest {
	
	WebDriver driver;
	final String siteURL = "https://www.amazon.in/";
	final String driverPATH = "/home/wahidkhan74gmai/eclipse-workspace/amazontests/driver/geckodriver";
	
	
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver",driverPATH);
		driver = new FirefoxDriver();
		driver.get(siteURL);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

	@Test
	public void verifyAmazonHomePageTitleTest() {
		String actual= "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		assertEquals(actual, driver.getTitle());
	}
	
	@Test
	public void verifyAmazonSourceURLTest() {
		assertEquals(siteURL, driver.getCurrentUrl());
	}

}
