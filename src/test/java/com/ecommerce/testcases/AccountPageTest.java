package com.ecommerce.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseClass;
import com.ecommerce.dataprovider.DataProviders;
import com.ecommerce.pageobjects.AccountCreationPage;
import com.ecommerce.pageobjects.HomePage;
import com.ecommerce.pageobjects.LoginPage;
import com.ecommerce.utility.Log;

public class AccountPageTest extends BaseClass {
    private LoginPage loginPage;
    private HomePage indexPage;
    private AccountCreationPage accountPage;

    @Parameters("browser")
    @BeforeMethod(groups= {"Smoke","Sanity","Regression"})
    public void setup(String browser) {
        Log.info("Setting up test with browser: " + browser);
        launchApp(browser); 
        Log.info("Setup completed");
    }

    @AfterMethod(groups= {"Smoke","Sanity","Regression"})
    public void tearDown() {
        Log.info("Starting tearDown method");
        getDriver().quit();
        Log.info("Driver quit successfully");
    }

    @Test(groups="Sanity", dataProvider="accountsignupemail", dataProviderClass = DataProviders.class)
    public void verifyCreateAccountPageTest( String Name, String Email ) throws Throwable {
        Log.info("Starting verifyCreateAccountPageTest");
        indexPage = new HomePage();
        loginPage = indexPage.clickOnSignIn();
        accountPage = loginPage.createNewAccount(Name,Email);
        String actualURL = accountPage.getCurrURL();
        String expectedURL = "https://automationexercise.com/signup";
        Log.info("Actual URL"+ actualURL);
        Log.info("Expected URL: "+ expectedURL);
        Assert.assertEquals(actualURL, expectedURL);
        Log.info("URL verification passed");
        boolean result = accountPage.validateAcountCreatePage();
        Log.info("Account creation page validation result: "+ result);
        Assert.assertTrue(result);
        Log.info("verifyCreateAccountPageTest completed successfully");
    }
}