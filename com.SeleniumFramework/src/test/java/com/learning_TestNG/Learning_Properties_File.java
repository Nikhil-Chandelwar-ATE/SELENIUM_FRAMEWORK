package com.learning_TestNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Learning_Properties_File {

	@Test
	public void loginToDWS() throws InterruptedException, IOException {
		
//		create java representation object for external file
		FileInputStream fis = new FileInputStream("./src/main/resources/commonData/dws_commonData.properties");
		
//		create the object of Properties class
		Properties prop = new Properties();
		
//		load the file from fis to properties object
		prop.load(fis);
		
//		fetch data from properties file
		String URL = prop.getProperty("url");
		String EMAIL = prop.getProperty("email");
		String PASSWORD = prop.getProperty("password");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(EMAIL);
		driver.findElement(By.id("Password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Log out")).click();
		driver.quit();
	}
}
