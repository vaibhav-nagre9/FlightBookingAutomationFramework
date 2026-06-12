package com.vaibhav.flightbooking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PurchasePage {

		
	private WebDriver driver;
	
	public PurchasePage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	//Locators
	//Flight Details
	private By airlineName = By.xpath("//p[contains(text(),'Airline')]");
	private By flightNumber = By.xpath("//p[contains(text(),'Flight')]");
	private By price = By.xpath("//p[contains(text(),'Price')]");
	private By feesAndTaxes = By.xpath("//p[contains(text(),'Arbitrary')]");
	private By totalCost = By.xpath("//p[contains(text(),'Total Cost')]");
			
	//Passenger Details
	private By inputName = By.id("inputName");
	private By inputAddress = By.id("address");
	private By inputCity = By.id("city");
	private By inputState = By.id("state");
	private By inputZipCode = By.id("zipCode");
	
	//Payment form
	private By selectCardType = By.id("cardType");
	private By creditCardNumber = By.id("creditCardNumber");
	private By creditCardMonth = By.id("creditCardMonth");
	private By creditCardYear = By.id("creditCardYear");
	private By nameOnCard = By.id("nameOnCard");
	
	//Remember me checkbox
	private By rememberMeCheckbox = By.id("rememberMe");
	
	//Purchase Flight Button
	private By purchaseFlightButton = By.xpath("//input[@value='Purchase Flight']");
	
	
	
	//Methods
	//Airline Details Methods
	public String getAirlineName() {
		return driver.findElement(airlineName).getText();
	}
	
	public String getFlightNumber() {
	return driver.findElement(flightNumber).getText();
	}
	
	public String getPrice() {
		return driver.findElement(price).getText();
		}
	
	public String getFeesAndTaxes() {
		return driver.findElement(feesAndTaxes).getText();
		}
	
	public String getTotalCost() {
		return driver.findElement(totalCost).getText();
		}
	
	//Passenger Details Method
	public void fillPassengerDetails(
			String name, 
			String address, 
			String city, 
			String state, 
			String zipCode) {
		driver.findElement(inputName).sendKeys(name);
		driver.findElement(inputAddress).sendKeys(address);
		driver.findElement(inputCity).sendKeys(city);
		driver.findElement(inputState).sendKeys(state);
		driver.findElement(inputZipCode).sendKeys(zipCode);
	}
	
	//Payment Details Method
	public void fillPaymentDetails( 
		String cardTypeDropdown,	
		String cardNumber,
		String cardMonth,
		String cardYear,
		String cardHolderName) {
		
		Select dropdown = new Select(driver.findElement(selectCardType));
		dropdown.selectByVisibleText(cardTypeDropdown); //is this correct?
		driver.findElement(creditCardNumber).sendKeys(cardNumber);
		driver.findElement(creditCardMonth).clear();
		driver.findElement(creditCardMonth).sendKeys(cardMonth);
		driver.findElement(creditCardYear).clear();
		driver.findElement(creditCardYear).sendKeys(cardYear);
		driver.findElement(nameOnCard).sendKeys(cardHolderName);
	}
	
	public String getPassengerName() {
	    return driver.findElement(inputName).getAttribute("value");
	}

	public String getPassengerAddress() {
	    return driver.findElement(inputAddress).getAttribute("value");
	}

	public String getPassengerCity() {
	    return driver.findElement(inputCity).getAttribute("value");
	}

	public String getPassengerState() {
	    return driver.findElement(inputState).getAttribute("value");
	}

	public String getPassengerZipCode() {
	    return driver.findElement(inputZipCode).getAttribute("value");
	}
	
	public String getSelectedCardType() {

	    Select dropdown =
	            new Select(driver.findElement(selectCardType));

	    return dropdown.getFirstSelectedOption().getText();
	}

	public String getCreditCardNumber() {
	    return driver.findElement(creditCardNumber)
	            .getAttribute("value");
	}

	public String getCreditCardMonth() {
	    return driver.findElement(creditCardMonth)
	            .getAttribute("value");
	}

	public String getCreditCardYear() {
	    return driver.findElement(creditCardYear)
	            .getAttribute("value");
	}

	public String getCardHolderName() {
	    return driver.findElement(nameOnCard)
	            .getAttribute("value");
	}
	
	public void clickRememberMe() {
	WebElement checkbox = driver.findElement(rememberMeCheckbox);
		if(!checkbox.isSelected()) {
			checkbox.click();
		}
	}
	
	public boolean isRememberMeSelected() {

	    return driver.findElement(
	            rememberMeCheckbox).isSelected();
	}
	
	public void clickPurchaseFlight() {
		driver.findElement(purchaseFlightButton).click();
	}


}
