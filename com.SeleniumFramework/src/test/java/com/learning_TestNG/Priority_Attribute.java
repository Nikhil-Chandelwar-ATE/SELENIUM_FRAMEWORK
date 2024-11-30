package com.learning_TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Priority_Attribute {

	@Test(priority = 5)		
	public void registerTest() {
		
		Reporter.log("Executing Register Test Case....", true);
	}
	
	@Test(priority = 1000)
	public void addToCartTest() {
		Reporter.log("Executing Add To Cart Test Case....", true);
	}
	
	@Test(priority = 500)
	public void loginTest() {
		Reporter.log("Executing Login Test Case....", true);
	}
	
}
