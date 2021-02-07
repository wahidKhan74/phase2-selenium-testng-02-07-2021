package com.ecom.selenium.tests.amazontests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgAnnotations {
	
	@Test
	public void testOne() {
		System.out.println("-- Test 1 is Exicuted --");
	}
	
	@Test
	public void testTwo() {
		System.out.println("-- Test 2 is Exicuted --");
	}
	
	@BeforeTest
	public void setUp() {
		System.out.println("-- Before Test Exicuted --");
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("-- After Test Exicuted --");
	}
	
	@BeforeMethod
	public void setUpEveryTest() {
		System.out.println("-- Before Everty Test Exicuted --");
	}
	
	@AfterMethod
	public void tearDwonEveryTest() {
		System.out.println("-- After Everty Test Exicuted --");
	}
}
