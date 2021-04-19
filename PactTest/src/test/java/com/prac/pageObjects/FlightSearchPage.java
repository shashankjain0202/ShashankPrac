package com.prac.pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.prac.utils.Actions.ActionsUtils;

public class FlightSearchPage extends ApplicationBase {
	
ActionsUtils actions;
WebDriverWait wait;

public FlightSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actions = new ActionsUtils(driver);
		wait = new WebDriverWait(driver, 30);
}

@FindBy(xpath = "(.//div[contains(@jsaction,'ticket_type')])[1]")
public WebElement flightSearch_TicketTypeDropDown;

@FindBy(xpath = "(.//div[contains(@jsaction,'ticket_type')])[1]//menu-item/span")
public List<WebElement> flightSearch_TicketTypeList;

@FindBy(id = "flt-pax-button")
public WebElement flightSearch_PassangerDropDown;

@FindBy(xpath = ".//div[contains(@jsaction,'seating_class')]")
public WebElement flightSearch_SeatingClassDropdown;

@FindBy(xpath = ".//div[contains(@jsaction,'seating_class')]//menu-item/span")
public List<WebElement> flightSearch_SeatingClassList;

@FindBy(xpath = ".//div[contains(@class,'gws-flights__flex-box')]/div[@data-flt-ve='origin_airport']")
public WebElement flightSearch_OriginAirportElementToBeClicked;

@FindBy(xpath = ".//div[@id='sb_ifc50']/input")
public WebElement flightSearch_OriginAirportInputField;

@FindBy(xpath = ".//div[@class='gstl_50 sbdd_a']//li//span")
public WebElement flightSearch_OriginAirportInputFirtListOption;

@FindBy(xpath = ".//div[contains(@class,'gws-flights__flex-box')]/div[@data-flt-ve='destination_airport']")
public WebElement flightSearch_DestinationAirportElementToBeClicked;

@FindBy(xpath = ".//div[@id='sb_ifc50']/input")
public WebElement flightSearch_DestinationAirportInputField;

@FindBy(xpath = ".//span[text()='Search']")
public WebElement flightSearch_SearchButton;

public By flightSearch_TicketTypeDropDown_By = By.xpath("(.//div[contains(@jsaction,'ticket_type')])[1]");
public By flightSearch_PassangerDropDown_By = By.id("flt-pax-button");
public By flightSearch_SeatingClassDropdown_By = By.xpath(".//div[contains(@jsaction,'seating_class')]");
public By flightSearch_OriginAirportElementToBeClicked_By = By.xpath(".//div[contains(@class,'gws-flights__flex-box')]/div[@data-flt-ve='origin_airport']");
public By flightSearch_DestinationAirportElementToBeClicked_By = By.xpath(".//div[contains(@class,'gws-flights__flex-box')]/div[@data-flt-ve='destination_airport']");
public By flightSearch_SearchButton_By = By.xpath(".//span[text()='Search']");


public void selectTicketType(String ticketType) {
	actions.clickElement(flightSearch_TicketTypeDropDown, "Ticket type Dropdown");
	 for (WebElement ticketTypeTemp:flightSearch_TicketTypeList) {
		 	if (ticketTypeTemp.getText().equals(ticketType)) {
		 		actions.clickElement(ticketTypeTemp, "Ticket Type");
		 		break;
		 	}
	 }
}

public void selectSeatingClass(String seatingClass) {
	actions.clickElement(flightSearch_SeatingClassDropdown, "seating class dropdown");
	 for (WebElement seatingClassTemp:flightSearch_SeatingClassList) {
		 	if (seatingClassTemp.getText().equals(seatingClass)) {
		 		actions.clickElement(seatingClassTemp, "Ticket Type");
		 		break;
		 	}
	 }
}

public void enterOneWayFlightSearchDataAndSearch(HashMap<String, String>inputData) {
	
	selectTicketType(inputData.get("TicketType"));
	selectSeatingClass(inputData.get("SeatingClass"));
	actions.clickElement(flightSearch_OriginAirportElementToBeClicked, "Origin airport field");
	wait.until(ExpectedConditions.elementToBeClickable(flightSearch_OriginAirportInputField));
	actions.clearAndTypeTextField(flightSearch_OriginAirportInputField, inputData.get("Origin"), "Origin Airport input field");
	wait.until(ExpectedConditions.elementToBeClickable(flightSearch_OriginAirportInputFirtListOption));
	actions.clickElement(flightSearch_OriginAirportInputFirtListOption, "First options from list for Origin Airport");
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	actions.clickElement(flightSearch_DestinationAirportElementToBeClicked, "Destination airport field");
	wait.until(ExpectedConditions.elementToBeClickable(flightSearch_DestinationAirportInputField));
	actions.clearAndTypeTextField(flightSearch_DestinationAirportInputField, inputData.get("Destination"), "Destination Airport input field");
	wait.until(ExpectedConditions.elementToBeClickable(flightSearch_OriginAirportInputFirtListOption));
	actions.clickElement(flightSearch_OriginAirportInputFirtListOption, "First options from list for Destination Airport");
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	actions.clickElement(flightSearch_SearchButton, "Flight search Button");

	
}
}
