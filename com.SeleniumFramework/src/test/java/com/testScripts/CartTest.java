package com.testScripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.generic_Utilities.BaseTest;
import com.generic_Utilities.WebDriver_Utility;
import com.objectRepository.SearchPage;
import com.objectRepository.ShoppingCartPage;
import com.objectRepository.WelcomePage;

public class CartTest extends BaseTest {

	@Test(groups = "smokeGroup")
	public void addToCartTest() throws InterruptedException {
		
		Thread.sleep(2000);
		WelcomePage wp = new WelcomePage(driver);
		wp.getSearchTextField().sendKeys("laptop");
		wp.getSearchButton().click();
		Reporter.log("Search Page displayed.", true);
		SearchPage sp = new SearchPage(driver);
		sp.getAddToCartButton().click();
		
		wp.getShoppingCartLink().click();
		Reporter.log("Shopping Cart Page displayed", true);
		
		ShoppingCartPage scp = new ShoppingCartPage(driver);
		if (scp.getLaptopProduct().isDisplayed()) {
			Reporter.log("Product is added into the cart....", true);
			WebDriver_Utility.takeScreenshotOfWebElement(scp.getLaptopProduct());
		}
		WebDriver_Utility.takeScreenshotOfWebpage(driver);
		
		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods = "addToCartTest", groups = "smokeGroup")
	public void removeFromCartTest() throws InterruptedException {
		Thread.sleep(2000);
		WelcomePage wp = new WelcomePage(driver);
		wp.getShoppingCartLink().click();
		Reporter.log("Shopping Cart Page displayed", true);
		
		ShoppingCartPage scp = new ShoppingCartPage(driver);
		scp.getRemoveFromCartCheckBox().click();
		scp.getUpdateCartButton().click();
		Reporter.log("Product is removed from the cart....", true);
		Thread.sleep(2000);
		WebDriver_Utility.takeScreenshotOfWebpage(driver);
	}
}