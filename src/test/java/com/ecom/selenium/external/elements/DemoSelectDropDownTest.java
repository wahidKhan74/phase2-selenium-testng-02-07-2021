package com.ecom.selenium.external.elements;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoSelectDropDownTest {

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

	@Test
	public void testforSelect() {
		WebElement select = driver.findElement(By.id("vehicle"));
		Select vehicle = new Select(select);
		vehicle.selectByVisibleText("Bike");
		WebElement selectedElm = vehicle.getFirstSelectedOption();
		assertEquals("Bike", selectedElm.getText());
		
	}
	
	
	@Test
	public void testforSelectByIndex() {
		WebElement select = driver.findElement(By.id("vehicle"));
		Select vehicle = new Select(select);
		vehicle.selectByIndex(2);
		List<WebElement> selectedElms = vehicle.getAllSelectedOptions();
		assertEquals("Train", selectedElms.get(0).getText());
		
	}
}
