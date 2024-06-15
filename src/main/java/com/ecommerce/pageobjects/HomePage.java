package com.ecommerce.pageobjects;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.actiondriver.Action;
import com.ecommerce.base.BaseClass;

import org.openqa.selenium.WebElement;

public class HomePage extends BaseClass{

@FindBy(xpath = "//a[@href='/login']") 
private WebElement signInBtn;
@FindBy(xpath = "//a[@href='/products']") 
private WebElement products;

@FindBy(xpath = "//img[@alt='Website for automation practice']")
private WebElement myStoreLogo;

@FindBy(xpath = "//i[@class='fa fa-shopping-cart']")
private WebElement myCart;

@FindBy(xpath = "//a[text()='View Product']")
private WebElement myViewPro;

public HomePage() {
	PageFactory.initElements(driver, this);
}
public LoginPage clickOnSignIn() throws Throwable {
	Action.fluentWait(driver, signInBtn, 10);
	Action.click(driver, signInBtn);
	return new LoginPage();
}
public boolean validateLogo() throws Throwable {
	return Action.isDisplayed(driver, myStoreLogo);
}
public boolean validateCart() throws Throwable {
	return Action.isDisplayed(driver, myCart);
}
public String getCurrURL()
{
	String homePageURL=driver.getCurrentUrl();
	return homePageURL;
}
public boolean validateViewPro() throws Throwable {
	return Action.isDisplayed(driver, myViewPro);
}
public String getMyStoreTitle() {
	String ecommerceTitel=driver.getTitle();
	return ecommerceTitel;
}

public Product_Page clickOnProduct() throws Throwable {
    Action.fluentWait(driver, products, 10);
    Action.click(driver, products);
    
    // Wait a moment to let the page fully load after clicking
    Thread.sleep(3000); // Adjust the time as needed

    // Check if the URL contains the fragment and remove it
    String currentURL = driver.getCurrentUrl();
    if (currentURL.contains("#google_vignette")) {
        String cleanURL = currentURL.replace("#google_vignette", "");
        driver.get(cleanURL);
    }
    
    return new Product_Page();
}
}