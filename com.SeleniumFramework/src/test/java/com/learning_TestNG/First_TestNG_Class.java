package com.learning_TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class First_TestNG_Class {

	@Test		//acts like a main() method
	public void registerTest() {	//acts like a test case
		
		Reporter.log("Executing Register Test Case....", true);
	}
	
	@Test
	public void addToCartTest() {
		Reporter.log("Executing Add To Cart Test Case....", true);
	}
	
	@Test
	public void loginTest() {
		Reporter.log("Executing Login Test Case....", true);
	}
	
}
