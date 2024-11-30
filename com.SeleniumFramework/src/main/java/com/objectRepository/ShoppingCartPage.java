package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

	public ShoppingCartPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "14.1-inch Laptop")
	private WebElement laptopProduct;
	
	@FindBy(xpath = "(//a[text()='14.1-inch Laptop'])[2]/../..//input[@name='removefromcart']")
	private WebElement removeFromCartCheckBox;
	
	@FindBy(name = "updatecart")
	private WebElement updateCartButton;

	public WebElement getLaptopProduct() {
		return laptopProduct;
	}

	public WebElement getRemoveFromCartCheckBox() {
		return removeFromCartCheckBox;
	}

	public WebElement getUpdateCartButton() {
		return updateCartButton;
	}
	
}
