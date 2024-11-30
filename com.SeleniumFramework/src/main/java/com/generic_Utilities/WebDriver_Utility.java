package com.generic_Utilities;

import java.io.File;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utility {

	public static void takeScreenshotOfWebpage(WebDriver driver) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./src/main/resources/screenshots/DWS_" + Java_Utility.getCurentTime() + ".png");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void takeScreenshotOfWebElement(WebElement element) {

		File src = element.getScreenshotAs(OutputType.FILE);
		File dest = new File("./src/main/resources/screenshots/DWS_WE_" + Java_Utility.getCurentTime() + ".png");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void switchToChildWindowByTitle(WebDriver driver, String title) { // amazon

		String parentWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		allWindowHandles.remove(parentWindowHandle);
		for (String windowHandle : allWindowHandles) {
			driver.switchTo().window(windowHandle);
			if (driver.getTitle().equals(title)) {
				break;
			} else {
				driver.close();
			}
		}
	}

	public static void switchToChildWindowByUrl(WebDriver driver, String url) { // amazon

		String parentWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		allWindowHandles.remove(parentWindowHandle);
		for (String windowHandle : allWindowHandles) {
			driver.switchTo().window(windowHandle);
			if (driver.getCurrentUrl().equals(url)) {
				break;
			} else {
				driver.close();
			}
		}
	}
	
	public static void selectDropdownOptionByText(WebElement element, String visibleText) {
		
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}
}
