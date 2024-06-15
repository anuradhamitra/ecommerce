package com.ecommerce.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.actiondriver.Action;
import com.ecommerce.base.BaseClass;


public class AddToCartPage extends BaseClass {
Action action= new Action();
	
	@FindBy(id="quantity")
	private WebElement quantity;
	
	
	@FindBy(xpath="//button[@type='button' and contains(@class, 'btn btn-default cart')]")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//div[@id='cartModal']//h4[contains(text(), 'Added!')]")
	private WebElement addToCartMessag;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterQuantity(String quantity1) throws Throwable {
		Action.type(quantity, quantity1);
	}
	
	
	public void clickOnAddToCart() throws Throwable {
		Action.click(driver, addToCartBtn);
	}
	
	public boolean validateAddtoCart() throws Throwable {
		Action.fluentWait(driver, addToCartMessag, 10);
		return Action.isDisplayed(driver, addToCartMessag);
	}
	
	
	
}
