package com.ecommerce.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.actiondriver.Action;
import com.ecommerce.base.BaseClass;

public class Product_Page extends BaseClass {
	Action action= new Action();
	@FindBy(xpath="//input[@placeholder='Search Product']")
	public WebElement searchProductBox;
	@FindBy(id="submit_search")
	public WebElement searchButton;
	public Product_Page() {
		PageFactory.initElements(driver, this);
	}
	public SearchResultPage searchProduct(String productName) throws Throwable {
		Thread.sleep(4000);
		Action.scrollByVisibilityOfElement(driver, searchProductBox);
		
		Action.type(searchProductBox, productName);
		Action.click(driver, searchButton);
		
		return new SearchResultPage();
	}
	public String getCurrURL()
	{
		String homePageURL=driver.getCurrentUrl();
		return homePageURL;
	}
}
