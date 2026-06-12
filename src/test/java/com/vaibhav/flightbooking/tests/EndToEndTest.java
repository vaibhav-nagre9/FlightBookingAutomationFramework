package com.vaibhav.flightbooking.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vaibhav.flightbooking.base.BaseTest;
import com.vaibhav.flightbooking.pages.ConfirmationPage;
import com.vaibhav.flightbooking.pages.FlightSelectionPage;
import com.vaibhav.flightbooking.pages.HomePage;
import com.vaibhav.flightbooking.pages.PurchasePage;

public class EndToEndTest extends BaseTest {

	 @Test
	    public void verifyUserCanBookFlightSuccessfully() {
		 
		 //HomePage
		 HomePage homePage = new HomePage(driver);
		 homePage.selectDepartureCity("Boston");
		 homePage.selectDestinationCity("London");
		 homePage.clickFindFlights();
		 Assert.assertTrue(driver.getCurrentUrl().contains("reserve.php"));
		 System.out.println(driver.getCurrentUrl());
		 
		 //Flight Selection Page
		 FlightSelectionPage flightSelectionPage = new FlightSelectionPage(driver);
		 flightSelectionPage.selectFlight();
		 Assert.assertTrue(driver.getCurrentUrl().contains("purchase.php"));
		 System.out.println(driver.getCurrentUrl());
		 
		 
		 //Purchase Page
		 PurchasePage purchasePage = new PurchasePage(driver);
		 purchasePage.fillPassengerDetails("Vaibhav", "Hinjewadi", "Pune", "Maharashtra", "411057");
		 Assert.assertTrue(purchasePage.getPassengerName().contains("Vaibhav"));
		 purchasePage.fillPaymentDetails("Visa", "1234567890123456", "11", "2030", "VaibhavNagre");
		 Assert.assertEquals(
				    purchasePage.getSelectedCardType(),
				    "Visa");

				Assert.assertEquals(
				    purchasePage.getCreditCardMonth(),
				    "11");
		 purchasePage.clickRememberMe();
		 
		 Assert.assertTrue(
				    purchasePage.isRememberMeSelected());
		 
		 purchasePage.clickPurchaseFlight();
		 Assert.assertTrue(driver.getCurrentUrl().contains("confirmation.php"));
		 System.out.println(driver.getCurrentUrl());
		 
		 
		 //Confirmation Page
		 System.out.println("BookingDetails: ");
		 ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		 
		 Assert.assertTrue(confirmationPage.getThankYouText().contains("Thank you"));
		 System.out.println(confirmationPage.getThankYouText());
		 
		 Assert.assertFalse(confirmationPage.getBookingId().isEmpty(), "Booking ID is not Generated");
		 System.out.println(confirmationPage.getBookingId());
		 
		 Assert.assertEquals(
				    confirmationPage.getBookingStatus(),
				    "PendingCapture");
		 System.out.println(confirmationPage.getBookingStatus());
	    }
	 
}
