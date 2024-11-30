package com.learning_TestNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.generic_Utilities.BaseTest;

@Listeners(com.generic_Utilities.Listener_Implementation.class)
public class Learning_Listeners extends BaseTest {

	@Test
	public void searchTest() throws InterruptedException {

		driver.findElement(By.name("q")).sendKeys("laptop");
		driver.findElement(By.xpath("//input[@value='Search']")).click();

		Assert.assertEquals(driver.getTitle(), "Demo Web Shop", "Validating Search Page");

		System.out.println("hello");
		Thread.sleep(2000);
	}
}
