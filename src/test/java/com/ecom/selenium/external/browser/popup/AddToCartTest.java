package com.ecom.selenium.external.browser.popup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTest {

	WebDriver driver;
	final String siteURL = "https://www.amazon.in/";
	final String driverPATH = "/home/wahidkhan74gmai/eclipse-workspace/amazontests/driver/geckodriver";

	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", driverPATH);
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.get(siteURL);
	}

	@AfterMethod
	public void afterTest() {
		driver.close();
	}

	@Test
	public void addToCartTest() throws InterruptedException {
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 11 pro max");
		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a"))
				.click();
		
		String mainWindow = driver.getWindowHandle();
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		
		driver.switchTo().window(tabs.get(1));
		
		driver.findElement(By.cssSelector("#add-to-cart-button")).click();
		
		driver.close();
		
		driver.switchTo().window(tabs.get(0));
		    
	//		Set<String> childWs = driver.getWindowHandles();
	//		Iterator<String> windowIterator = childWs.iterator();
	//		
	//		while(windowIterator.hasNext()) {
	//			String childWindow = windowIterator.next();
	//			if(mainWindow.equalsIgnoreCase(childWindow)) {
	//				Thread.sleep(2000);
	//				driver.switchTo().window(childWindow);
	//				Thread.sleep(2000);
	//				driver.findElement(By.cssSelector("#add-to-cart-button")).click();
	//				driver.close();
	//			}
	//		}	
		
	}
}
