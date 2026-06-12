package com.vaibhav.flightbooking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightSelectionPage {

	private WebDriver driver;
	
	public FlightSelectionPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By chooseFlight = By.xpath("(//input[@value='Choose This Flight'])[1]");
    private	By price = By.xpath("//tbody/tr[1]/td[6]");
    private	By departTime = By.xpath("//tbody/tr[1]/td[4]");
	
	public void selectFlight() {
		driver.findElement(chooseFlight).click();
	}
	
	public String getPrice() {
		
	return driver.findElement(price).getText();
	}
	
	public String getDepartureTime() {
		return driver.findElement(departTime).getText();
	}
	public boolean isChooseFlightButtonDisplayed() {
	    return driver.findElement(chooseFlight).isDisplayed();
	}
}
