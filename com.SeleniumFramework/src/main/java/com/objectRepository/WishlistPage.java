package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage {

	public WishlistPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "50's Rockabilly Polka Dot Top JR Plus Size")
	private WebElement topWearProductInWishlist;
	
	@FindBy(xpath = "//a[text()=\"50's Rockabilly Polka Dot Top JR Plus Size\"]/../..//input[@name='removefromcart']")
	private WebElement removeProductCheckBox;
	
	@FindBy(name = "updatecart")
	private WebElement updateCartButton;

	public WebElement getTopWearProductInWishlist() {
		return topWearProductInWishlist;
	}

	public WebElement getRemoveProductCheckBox() {
		return removeProductCheckBox;
	}

	public WebElement getUpdateCartButton() {
		return updateCartButton;
	}
}
