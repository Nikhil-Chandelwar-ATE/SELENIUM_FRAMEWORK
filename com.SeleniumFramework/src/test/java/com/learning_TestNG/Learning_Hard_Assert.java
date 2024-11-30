package com.learning_TestNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.generic_Utilities.BaseTest;
import com.generic_Utilities.WebDriver_Utility;

public class Learning_Hard_Assert extends BaseTest {

	@Test
	public void searchTest() throws InterruptedException {
		
		driver.findElement(By.name("q")).sendKeys("laptop");
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop", "Validating Search Page");
		
		WebDriver_Utility.takeScreenshotOfWebpage(driver);
		
		System.out.println("hello");
		Thread.sleep(2000);
	}
}
