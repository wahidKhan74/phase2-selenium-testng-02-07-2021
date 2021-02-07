package com.ecom.selenium.external.elements;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class DemoRadioButtonTest {
	
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
	public void radioButtonExistTest() {
		WebElement radio1 = driver.findElement(By.id("male"));
		assertEquals(true, radio1.isDisplayed());
		assertEquals(true, radio1.isEnabled());
		assertEquals(false, radio1.isSelected());
		
		WebElement radio2 = driver.findElement(By.id("female"));
		assertEquals(true, radio2.isDisplayed());
		assertEquals(true, radio2.isEnabled());
		assertEquals(false, radio2.isSelected());
		
		WebElement radio3 = driver.findElement(By.id("other"));
		assertEquals(true, radio3.isDisplayed());
		assertEquals(true, radio3.isEnabled());
		assertEquals(false, radio3.isSelected());
	}
	
	@Test(priority=1)
	public void radioButtonClickTest() {
		WebElement radio1 = driver.findElement(By.id("male"));
		radio1.click();
		assertEquals(true, radio1.isSelected());
	}

	@Test(priority=2)
	public void radioButtonClickTest2() {
		WebElement radio2 = driver.findElement(By.id("female"));
		radio2.click();
		assertEquals(true, radio2.isSelected());
	}

}
