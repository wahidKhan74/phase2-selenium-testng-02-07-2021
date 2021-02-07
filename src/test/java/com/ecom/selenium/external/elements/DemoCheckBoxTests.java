package com.ecom.selenium.external.elements;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoCheckBoxTests {

	WebDriver driver;
	final String siteURL = "file:///home/wahidkhan74gmai/eclipse-workspace/amazontests/static/radio-check.html";
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

	@Test(priority=3)
	public void verifyCheckBoxExistTest() {
		WebElement checkBox1 = driver.findElement(By.id("vehicle1"));
		assertEquals(true, checkBox1.isDisplayed());
		assertEquals(true, checkBox1.isEnabled());
		assertEquals(false, checkBox1.isSelected());
	}
	

	@Test(priority=2)
	public void verifyDeaultCheckBoxTest() {
		WebElement checkBox1 = driver.findElement(By.id("vehicle2"));
		assertEquals(true, checkBox1.isDisplayed());
		assertEquals(true, checkBox1.isEnabled());
		assertEquals(true, checkBox1.isSelected());
	}
	
	@Test(priority=1)
	public void verifySelectALLCheckBoxTest() {
		driver.findElement(By.id("vehicle1")).click();
		driver.findElement(By.id("vehicle2")).click();
		driver.findElement(By.id("vehicle3")).click();
	}
}
