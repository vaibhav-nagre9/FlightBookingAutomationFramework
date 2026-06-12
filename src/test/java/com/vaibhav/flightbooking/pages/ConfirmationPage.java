package com.vaibhav.flightbooking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {

    private WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By thankYouMessage = By.xpath("//h1[contains(text(),'Thank you')]");
    private By bookingId = By.xpath("//td[text()='Id']/following-sibling::td");
    private By bookingStatus = By.xpath("//td[text()='Status']/following-sibling::td");
    private By bookingAmount = By.xpath("//td[text()='Amount']/following-sibling::td");
    private By bookingCardNumber = By.xpath("//td[text()='Card Number']/following-sibling::td");
    private By cardExpiry = By.xpath("//td[text()='Expiration']/following-sibling::td");
    private By authCode = By.xpath("//td[text()='Auth Code']/following-sibling::td");
    private By bookingDate = By.xpath("//td[text()='Date']/following-sibling::td");

    public String getThankYouText() {
        return driver.findElement(thankYouMessage).getText();
    }

    public String getBookingId() {
        return driver.findElement(bookingId).getText();
    }

    public String getBookingStatus() {
        return driver.findElement(bookingStatus).getText();
    }

    public String getBookingAmount() {
        return driver.findElement(bookingAmount).getText();
    }

    public String getCardNumber() {
        return driver.findElement(bookingCardNumber).getText();
    }

    public String getCardExpiry() {
        return driver.findElement(cardExpiry).getText();
    }

    public String getAuthCode() {
        return driver.findElement(authCode).getText();
    }

    public String getBookingDate() {
        return driver.findElement(bookingDate).getText();
    }
}