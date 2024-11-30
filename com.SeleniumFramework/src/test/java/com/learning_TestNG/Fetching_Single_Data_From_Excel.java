package com.learning_TestNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.generic_Utilities.FileUtility;

public class Fetching_Single_Data_From_Excel {

	@Test
	public void registerTest() throws EncryptedDocumentException, IOException {
		
//		create java representation object
		FileInputStream fis = new FileInputStream("./src/test/resources/testScriptData/testScriptData.xlsx");
		
//		open workbook/excel in read mode
		Workbook book = WorkbookFactory.create(fis);
		
//		traverse to a specific sheet by sheet name
		Sheet sheet = book.getSheet("registerData");
		
//		traverse to a specific row by index		
		Row row = sheet.getRow(1);
		
//		traverse to a specific cell by index		
		Cell cell = row.getCell(0);
		
//		from the cell fetch the data
		String gender = cell.getStringCellValue();
		String firstName = row.getCell(1).toString();
		String lastName = row.getCell(2).toString();
		String email = row.getCell(3).toString();
		String password = row.getCell(4).toString();
		
		String confirmPassword = FileUtility.getSingleDataFromExcelFile("registerData", 1, 5);
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(FileUtility.getDataFromPropertiesFile("url"));
		
		driver.findElement(By.linkText("Register")).click();
		
		if (gender.equals("male")) {
			driver.findElement(By.id("gender-male")).click();
		} else {
			driver.findElement(By.id("gender-female")).click();
		}
		driver.findElement(By.id("FirstName")).sendKeys(firstName);
		driver.findElement(By.id("LastName")).sendKeys(lastName);
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);
		
		driver.findElement(By.id("register-button")).click();
	}
}
