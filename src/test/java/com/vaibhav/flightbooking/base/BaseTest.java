package com.vaibhav.flightbooking.base;

import org.testng.annotations.BeforeMethod;

import com.vaibhav.flightbooking.utils.ConfigReader;
import com.vaibhav.flightbooking.utils.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {

	 protected WebDriver driver;

	    @BeforeMethod
	    public void setup() {

	        driver = DriverFactory.initializeDriver();

	        driver.get(ConfigReader.getUrl());
	    }

	    @AfterMethod
	    public void tearDown() {

	        if(driver != null) {
	            driver.quit();
	        }
	    }
	
}
