package com.vaibhav.flightbooking.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vaibhav.flightbooking.base.BaseTest;
import com.vaibhav.flightbooking.pages.FlightSelectionPage;
import com.vaibhav.flightbooking.pages.HomePage;

public class FlightSelectionTest extends BaseTest {

	private void navigetToFlightSelectionPage(){
	HomePage homePage = new HomePage(driver);
	homePage.selectDepartureCity("Paris");
	homePage.selectDestinationCity("London");
	homePage.clickFindFlights();
	}
	
	@Test
	public void verifyPriceIsDisplayed() {
		navigetToFlightSelectionPage();
	 FlightSelectionPage flightSelectionPage = new FlightSelectionPage(driver);
	 String price = flightSelectionPage.getPrice();
	 Assert.assertFalse(price.isEmpty(),"Price is Not Displayed Correctly");
	 System.out.println("Price :"+price);
	}
	 
	@Test
	public void verifyDepartureTimeIsDisplayed() {
		navigetToFlightSelectionPage();
	 FlightSelectionPage flightSelectionPage = new FlightSelectionPage(driver);
	 String departureTime =  flightSelectionPage.getDepartureTime();
	 Assert.assertFalse(departureTime.isEmpty(), "Departure Time is Not Displayed");
	 System.out.println("Departure time :"+departureTime);
	}
	
	@Test
	public void verifyUserCanSelectFlight() {
		navigetToFlightSelectionPage();
	 FlightSelectionPage flightSelectionPage = new FlightSelectionPage(driver);
	 flightSelectionPage.selectFlight();
	 Assert.assertTrue(driver.getCurrentUrl().contains("purchase.php"), "User is not Navigated to purchase flight page");
	 System.out.println(driver.getCurrentUrl());
	 
	}
	
	@Test
	public void verifyChooseFlightButton() {
		navigetToFlightSelectionPage();
		 FlightSelectionPage flightSelectionPage = new FlightSelectionPage(driver);
	 Assert.assertTrue(flightSelectionPage.isChooseFlightButtonDisplayed(),"Choose Flight button is not displayed");
	}
	
}
