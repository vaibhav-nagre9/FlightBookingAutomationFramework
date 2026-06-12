package com.vaibhav.flightbooking.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vaibhav.flightbooking.base.BaseTest;
import com.vaibhav.flightbooking.pages.FlightSelectionPage;
import com.vaibhav.flightbooking.pages.HomePage;
import com.vaibhav.flightbooking.pages.PurchasePage;

public class PurchasePageTest extends BaseTest{

	private void navigateToPurchasePage() {

	    HomePage homePage = new HomePage(driver);
	    homePage.selectDepartureCity("Paris");
	    homePage.selectDestinationCity("London");
	    homePage.clickFindFlights();

	    FlightSelectionPage flightSelectionPage = new FlightSelectionPage(driver);
	    flightSelectionPage.selectFlight();
	}
	
	@Test
	public void verifyAirlineName() {
		navigateToPurchasePage();
		PurchasePage purchasePage = new PurchasePage(driver);
		System.out.println("Airline: "+purchasePage.getAirlineName());
		Assert.assertTrue(purchasePage.getAirlineName().contains("United"), "United Airline is not Selected");
	}
	
	@Test
	public void verifyFlightIsDisplayed() {
		navigateToPurchasePage();
		PurchasePage purchasePage = new PurchasePage(driver);
		Assert.assertTrue(purchasePage.getFlightNumber().startsWith("Flight Number:"),"Flight Number is not displayed correctly");
		System.out.println("Flight Number: "+purchasePage.getFlightNumber());
	}
	 
	@Test
	public void verifyPrice() {
		navigateToPurchasePage();
		PurchasePage purchasePage = new PurchasePage(driver);
		Assert.assertTrue(
			    purchasePage.getPrice().startsWith("Price:"));
		System.out.println("Price: "+purchasePage.getPrice());
	}
	 
	@Test
	public void verifyFeesAndTaxes() {
		navigateToPurchasePage();
		PurchasePage purchasePage = new PurchasePage(driver);
		Assert.assertEquals(purchasePage.getFeesAndTaxes(), "Arbitrary Fees and Taxes: 514.76"); 
		System.out.println("Fees and Taxes: "+purchasePage.getFeesAndTaxes());


	}
	 
	@Test
	public void verifyTotalCost() {
		navigateToPurchasePage();
		 PurchasePage purchasePage = new PurchasePage(driver);
		 Assert.assertTrue(purchasePage.getTotalCost().contains("914.76"));
		 System.out.println("Total Cost: "+purchasePage.getTotalCost());
		 
	}
	
	@Test
	public void verifyUserCanFillPassengerDetails() {

	    navigateToPurchasePage();

	    PurchasePage purchasePage =
	            new PurchasePage(driver);

	    purchasePage.fillPassengerDetails(
	            "Vaibhav",
	            "India",
	            "Pune",
	            "Maharashtra",
	            "411057");

	    Assert.assertEquals(
	            purchasePage.getPassengerName(),
	            "Vaibhav");

	    Assert.assertEquals(
	            purchasePage.getPassengerAddress(),
	            "India");

	    Assert.assertEquals(
	            purchasePage.getPassengerCity(),
	            "Pune");

	    Assert.assertEquals(
	            purchasePage.getPassengerState(),
	            "Maharashtra");

	    Assert.assertEquals(
	            purchasePage.getPassengerZipCode(),
	            "411057");
	}
	
	@Test
	public void verifyUserCanFillPaymentDetails() {

	    navigateToPurchasePage();

	    PurchasePage purchasePage =
	            new PurchasePage(driver);

	    purchasePage.fillPaymentDetails(
	            "American Express",
	            "1234567891234567",
	            "04",
	            "2030",
	            "Nagre");

	    Assert.assertEquals(
	            purchasePage.getSelectedCardType(),
	            "American Express");

	    Assert.assertEquals(
	            purchasePage.getCreditCardNumber(),
	            "1234567891234567");

	    Assert.assertEquals(
	            purchasePage.getCreditCardMonth(),
	            "04");

	    Assert.assertEquals(
	            purchasePage.getCreditCardYear(),
	            "2030");

	    Assert.assertEquals(
	            purchasePage.getCardHolderName(),
	            "Nagre");
	}
	 
	@Test
	public void verifyRememberMeCheckboxCanBeSelected() {

	    navigateToPurchasePage();

	    System.out.println(driver.getCurrentUrl());

	    PurchasePage purchasePage =
	            new PurchasePage(driver);

	    purchasePage.clickRememberMe();

	    Assert.assertTrue(
	            purchasePage.isRememberMeSelected(),
	            "Remember Me checkbox is not selected");
	}
	 
	@Test
	public void verifyUserCanPurchaseFlightSuccessfully() {

	    navigateToPurchasePage();
	    System.out.println(driver.getCurrentUrl());

	    PurchasePage purchasePage =
	            new PurchasePage(driver);

	    purchasePage.fillPassengerDetails(
	            "Vaibhav",
	            "India",
	            "Pune",
	            "Maharashtra",
	            "411057");

	    purchasePage.fillPaymentDetails(
	            "American Express",
	            "1234567891234567",
	            "04",
	            "2030",
	            "Nagre");

	    purchasePage.clickPurchaseFlight();

	    Assert.assertTrue(
	            driver.getCurrentUrl().contains("confirmation.php"),"User is not navigated to Confirmation Page");
	}

}
