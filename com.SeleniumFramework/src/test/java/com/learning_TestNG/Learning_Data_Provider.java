package com.learning_TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Learning_Data_Provider {

	@DataProvider
	public String[][] flipkartSearchData() {
		
		String[][] data = new String[10][1];
		data[0][0] = "mobile";
		data[1][0] = "tv";
		data[2][0] = "fridge";
		data[3][0] = "ac";
		data[4][0] = "ipod";
		data[5][0] = "ipad";
		data[6][0] = "mac";
		data[7][0] = "shirt";
		data[8][0] = "watch";
		data[9][0] = "laptop";
		
		return data;
	}
	
	@Test(dataProvider = "flipkartSearchData")
	public void flipkartSearchTest(String data) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys(data, Keys.ENTER);
	}
	
}
