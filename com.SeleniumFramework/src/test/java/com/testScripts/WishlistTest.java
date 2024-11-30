package com.testScripts;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Reporter;
import com.generic_Utilities.BaseTest;
import com.generic_Utilities.WebDriver_Utility;
import com.objectRepository.ApparelAndShoesPage;
import com.objectRepository.WelcomePage;
import com.objectRepository.WishlistPage;

public class WishlistTest extends BaseTest {

	@Test(groups = "regressionGroup")
	public void addToWishlistTest() throws InterruptedException, IOException {
		
		Thread.sleep(2000);
		WelcomePage wp = new WelcomePage(driver);
		wp.getApparelAndShoesLink().click();
		ApparelAndShoesPage asp = new ApparelAndShoesPage(driver);
		asp.getTopWearProduct().click();
		asp.getAddToWishlistButton().click();
		wp.getWishlistLink().click();
		WishlistPage wlp = new WishlistPage(driver);
		if (wlp.getTopWearProductInWishlist().isDisplayed()) {
			Reporter.log("Product is added to Wishlist.....", true);
		}
		Thread.sleep(2000);
		WebDriver_Utility.takeScreenshotOfWebpage(driver);
	}
	
	@Test(dependsOnMethods = "addToWishlistTest", groups = "regressionGroup")
	public void removeFromWishlistTest() throws InterruptedException, IOException {
		Thread.sleep(2000);
		WelcomePage wp = new WelcomePage(driver);
		wp.getWishlistLink().click();
		WishlistPage wlp = new WishlistPage(driver);
		wlp.getRemoveProductCheckBox().click();
		wlp.getUpdateCartButton().click();
		Thread.sleep(2000);
		WebDriver_Utility.takeScreenshotOfWebpage(driver);
	}
}
