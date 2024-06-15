package com.ecommerce.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ecommerce.base.BaseClass;
import com.ecommerce.pageobjects.AddToCartPage;
import com.ecommerce.pageobjects.HomePage;
import com.ecommerce.pageobjects.LoginPage;
import com.ecommerce.pageobjects.Product_Page;
import com.ecommerce.pageobjects.SearchResultPage;

public class EndToEndTest extends BaseClass {
	private SearchResultPage searchPage;
	private HomePage indexPage;
	private Product_Page productPage;
	private AddToCartPage cartPage;
	private LoginPage loginPage;
	@BeforeMethod
	public void setup() {
		launchApp(); 
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void productAvailable() throws Throwable
	{
		indexPage= new HomePage();
		loginPage=indexPage.clickOnSignIn();
		indexPage=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	    String actualURL=indexPage.getCurrURL();
	    String expectedURL="https://automationexercise.com/";
	    Assert.assertEquals(actualURL, expectedURL);
		productPage=indexPage.clickOnProduct();
		searchPage=productPage.searchProduct("Blue Top");
		boolean isAvailable=searchPage.isProductAvailable();
	    Assert.assertTrue(isAvailable);
	    cartPage=searchPage.clickOnProduct();
	    cartPage.enterQuantity("3");
	    cartPage.clickOnAddToCart();
	    boolean isPresent=cartPage.validateAddtoCart();
	    Assert.assertTrue(isPresent);
	}
}
