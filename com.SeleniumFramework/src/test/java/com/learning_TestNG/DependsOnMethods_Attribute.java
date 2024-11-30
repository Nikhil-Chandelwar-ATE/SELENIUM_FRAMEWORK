package com.learning_TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DependsOnMethods_Attribute {

	@Test		
	public void registerTest() {
		
		Reporter.log("Executing Register Test Case....", true);
	}
	
	@Test(dependsOnMethods = {"registerTest", "loginTest"})
	public void addToCartTest() {
		Reporter.log("Executing Add To Cart Test Case....", true);
	}
	
	@Test(dependsOnMethods = "registerTest")
	public void loginTest() {
		Reporter.log("Executing Login Test Case....", true);
	}
	
}
