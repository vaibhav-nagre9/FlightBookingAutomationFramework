package com.vaibhav.flightbooking.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vaibhav.flightbooking.base.BaseTest;
import com.vaibhav.flightbooking.pages.ConfirmationPage;
import com.vaibhav.flightbooking.pages.FlightSelectionPage;
import com.vaibhav.flightbooking.pages.HomePage;
import com.vaibhav.flightbooking.pages.PurchasePage;

public class ConfirmationPageTest extends BaseTest {
    public void navigateToConfirmationPage() {
	HomePage homePage = new HomePage(driver);
    homePage.selectDepartureCity("Paris");
    homePage.selectDestinationCity("London");
    homePage.clickFindFlights();

    FlightSelectionPage flightSelectionPage = new FlightSelectionPage(driver);
    flightSelectionPage.selectFlight();

    PurchasePage purchasePage = new PurchasePage(driver);

    purchasePage.fillPassengerDetails(
            "Vaibhav",
            "India",
            "Pune",
            "Maharashtra",
            "411057"
    );

    purchasePage.fillPaymentDetails(
            "American Express",
            "1234567891234567",
            "04",
            "2030",
            "Nagre"
    );

    purchasePage.clickRememberMe();
    purchasePage.clickPurchaseFlight();
    }
    
    @Test
    public void verifyUserCanBookFlightSuccessfully() {
    	
    	navigateToConfirmationPage();
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);

        String thankYouText = confirmationPage.getThankYouText();
        Assert.assertTrue(thankYouText.contains("Thank you"),
                "Thank you message is not displayed correctly");

        String bookingId = confirmationPage.getBookingId();
        Assert.assertNotNull(bookingId, "Booking ID is null");
        Assert.assertFalse(bookingId.isEmpty(), "Booking ID is empty");

        String bookingStatus = confirmationPage.getBookingStatus();
        Assert.assertEquals(bookingStatus, "PendingCapture",
                "Booking status mismatch");

        String bookingAmount = confirmationPage.getBookingAmount();
        Assert.assertNotNull(bookingAmount, "Booking amount is null");

        String cardNumber = confirmationPage.getCardNumber();
        Assert.assertFalse(cardNumber.isEmpty(), "Card number is empty");

        String cardExpiry = confirmationPage.getCardExpiry();
        Assert.assertFalse(cardExpiry.isEmpty(), "Card expiry is empty");

        String authCode = confirmationPage.getAuthCode();
        Assert.assertFalse(authCode.isEmpty(), "Auth code is empty");

        String bookingDate = confirmationPage.getBookingDate();
        Assert.assertFalse(bookingDate.isEmpty(), "Booking date is empty");

        System.out.println("===== BOOKING DETAILS =====");
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Status: " + bookingStatus);
        System.out.println("Amount: " + bookingAmount);
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Expiry: " + cardExpiry);
        System.out.println("Auth Code: " + authCode);
        System.out.println("Date: " + bookingDate);
    }
}