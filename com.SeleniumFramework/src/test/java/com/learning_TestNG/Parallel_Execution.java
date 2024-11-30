package com.learning_TestNG;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class Parallel_Execution {

	@Test(invocationCount = 5, threadPoolSize = 2)
	public void searchTest() throws IOException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com");
		driver.findElement(By.name("q")).sendKeys("mobile", Keys.ENTER);
		
		int num = new Random().nextInt(100);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./src/main/resources/screenshots/flipkartSearch"+num+".png");
		FileHandler.copy(src, dest);
		Thread.sleep(2000);
		driver.quit();
	}
}
