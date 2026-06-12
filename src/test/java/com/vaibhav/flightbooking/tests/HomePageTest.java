package com.vaibhav.flightbooking.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vaibhav.flightbooking.base.BaseTest;
import com.vaibhav.flightbooking.pages.HomePage;

public class HomePageTest extends BaseTest{

	@Test
	public void verifyWelcomeMessageDisplayed() {
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.getWelcomeText().contains("Welcome"), "Welcome Text is not displayed correctly");
	}
	
	@Test
	public void verifyIsDepartureDropdownDisplayed() {
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isDepartureDropdownDisplayed(), "Departure dropdown is not displayed");
	}
	
	@Test
	public void verifyIsDestinationDropdownDisplayed() {
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isDestinationDropdownDisplayed(),"Destination dropdown is not displayed");
	}
	
	@Test
	public void verifyDepartureDropdownContainsExpectedCities() {
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.getDepartureCities().contains("Boston"),"Boston City is Not Present in Departure Dropdown");
		Assert.assertFalse(homePage.getDepartureCities().contains("London"), "London City should not be Present in Departure Dropdown");
	}
	
	@Test
	public void verifyDestinationDropdownContainsExpectedCities() {
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.getDestinationCities().contains("London"),"London City is Not Present in Destination Dropdown");
	}
	
	@Test
	public void verifyUserCanSearchFlightSuccessfully() {
		 HomePage homePage = new HomePage(driver);
		 homePage.selectDepartureCity("Boston");
		 homePage.selectDestinationCity("London");
		 homePage.clickFindFlights();
		 Assert.assertTrue(driver.getCurrentUrl().contains("reserve.php"), "User is not navigated to Flight Selection Page");
	}
}
