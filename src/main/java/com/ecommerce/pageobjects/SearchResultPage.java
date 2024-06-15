package com.ecommerce.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.actiondriver.Action;
import com.ecommerce.base.BaseClass;

public class SearchResultPage extends BaseClass {
Action action= new Action();
	
	@FindBy(xpath="//a[@href='/product_details/1']")
	private WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductAvailable() throws Throwable {
		return Action.isDisplayed(driver, productResult);
	}
	
	public AddToCartPage clickOnProduct() throws Throwable {
		Action.click(driver, productResult);
		return new AddToCartPage();
	}
	
}
