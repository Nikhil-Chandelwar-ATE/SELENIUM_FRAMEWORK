package com.generic_Utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener_Implementation implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		
		WebDriver_Utility.takeScreenshotOfWebpage(BaseTest.sDriver);
	}
}
