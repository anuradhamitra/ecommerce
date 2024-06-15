package com.ecommerce.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

import com.ecommerce.actiondriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;
	//loadConfig method is to load the configuration
		@BeforeTest
		public void loadConfig() {
			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream(
						System.getProperty("user.dir") + "\\Configuration\\config.properties");
				prop.load(ip);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void launchApp() {
			WebDriverManager.chromedriver().setup();
			String browserName = prop.getProperty("browser");
			if (browserName.contains("Chrome")) {	
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} 
			Action.implicitWait(driver, 10);
			
			driver.get(prop.getProperty("url"));
			try {
	            Thread.sleep(3000); // Adjust the time as needed
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Check if the URL contains the fragment and remove it
	        
			
		}
}
