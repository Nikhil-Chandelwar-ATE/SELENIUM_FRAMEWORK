package com.learning_TestNG;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.generic_Utilities.BaseTest;

@Listeners(com.generic_Utilities.Listener_Implementation.class)
public class Learning_Soft_Assert extends BaseTest {

	@Test
	public void searchTest() throws InterruptedException {
		
		driver.findElement(By.name("q")).sendKeys("laptop");
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		
		SoftAssert ast = new SoftAssert();
		ast.assertEquals(driver.getTitle(), "Demo Web Shop", "Validating Search Page.");
		System.out.println("hello");
		ast.assertEquals(driver.getTitle(), "Demo Web Shop", "Validating Search Page.");
		Thread.sleep(2000);
		ast.assertEquals(driver.getTitle(), "Demo Web Shop", "Validating Search Page.");
		ast.assertAll();
	}
}
