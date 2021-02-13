package com.ecom.selenium.external.browser.screenshot;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;

public class BrowserWindwoScreenShotTests {
	
	WebDriver driver;
	final String siteURL = "https://www.flipkart.com/";
	final String driverPATH = "/home/wahidkhan74gmai/eclipse-workspace/amazontests/driver/geckodriver";

	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", driverPATH);
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(siteURL);
		
	}

	@AfterMethod
	public void afterTest() {
		driver.close();
	}
	
	@Test
	public void takeScreenShotTest() throws IOException, URISyntaxException {	
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		URI uri = new URI(siteURL);
		FileHandler.copy(src, 
				new File("/home/wahidkhan74gmai/selenium-test-screenshots/"+uri.getHost()+".png"));
	}
}
