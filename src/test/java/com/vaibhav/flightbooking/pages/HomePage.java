package com.vaibhav.flightbooking.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	
	private WebDriver driver; 
	
	public HomePage(WebDriver driver) {

		this.driver = driver;
		
    }
	
	private By welcomeText = By.xpath("//h1[contains(text(),'Welcome')]");
    private	By departureDropdown = By.name("fromPort");
    private By destinationDropdown = By.name("toPort");
    private By findFlightsButton = By.xpath("//input[@value='Find Flights']");
    
    public String getWelcomeText() {
    	return driver.findElement(welcomeText).getText();
    }
    
    public boolean isDepartureDropdownDisplayed() {
    	return driver.findElement(departureDropdown).isDisplayed();
    }

    public boolean isDestinationDropdownDisplayed(){
    	return driver.findElement(destinationDropdown).isDisplayed();
    }
    
    public List<String> getDepartureCities(){
    	Select departureCities = new Select (driver.findElement(departureDropdown));
    	List<WebElement> options = departureCities.getOptions();
    	
    	List<String> depCities = new ArrayList<>();
    	for (WebElement option: options) {
    		depCities.add(option.getText());
    	}
    	return depCities;
    }
	
	public void selectDepartureCity(String city) {
		Select departure = new Select(driver.findElement(departureDropdown));
		departure.selectByVisibleText(city);
		
	}
	
	public List<String> getDestinationCities(){
    	Select destinationCities = new Select (driver.findElement(destinationDropdown));
    	List<WebElement> options = destinationCities.getOptions();
    	
    	List<String> destCities = new ArrayList<>();
    	for (WebElement option: options) {
    		destCities.add(option.getText());
    	}
    	return destCities;
    }
	
    public void selectDestinationCity(String city) {
		Select destination = new Select (driver.findElement(destinationDropdown));
		destination.selectByVisibleText(city);
	}
    
    public void clickFindFlights() {
    	driver.findElement(findFlightsButton).click();
	}
	
}
