package com.ecom.selenium.external.elements;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class DemoConfirmationAlertTest {

	WebDriver driver;
	final String siteURL = "file:///home/wahidkhan74gmai/eclipse-workspace/amazontests/static/alerts.html";
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

	@Test(priority=1)
	public void testForWebConfirmationBox() throws InterruptedException {
		// click on try it button.
		driver.findElement(By.xpath("/html/body/p[2]/button")).click();
		Thread.sleep(3000);

		// accept the alert popup
		Alert alert = driver.switchTo().alert();
		alert.accept();

		// click on try it button.
		driver.findElement(By.xpath("/html/body/p[2]/button")).click();
		Thread.sleep(3000);

		// dismiss popup
		driver.switchTo().alert().dismiss();

		// click on try it button.
		driver.findElement(By.xpath("/html/body/p[2]/button")).click();
		Thread.sleep(3000);
		
		assertEquals("Press a button !", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	@Test(priority=2)
	public void testForWebAlertBox() throws InterruptedException {
		// click on try it button.
		driver.findElement(By.xpath("/html/body/p[4]/button")).click();
		Thread.sleep(3000);

		// accept the alert popup
		Alert alert = driver.switchTo().alert();
		alert.accept();


		// click on try it button.
		driver.findElement(By.xpath("/html/body/p[4]/button")).click();
		Thread.sleep(3000);
		
		assertEquals("Are you sure !", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

}
