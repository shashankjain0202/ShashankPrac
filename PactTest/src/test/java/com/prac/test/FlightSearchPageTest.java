package com.prac.test;

import static org.junit.Assert.assertArrayEquals;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.prac.pageObjects.ApplicationBase;
import com.prac.pageObjects.FlightSearchPage;
import com.prac.pageObjects.HomePage;
import com.prac.pageObjects.SearchPage;
import com.prac.utils.JSONUtils;
import com.prac.utils.Actions.ActionsUtils;

public class FlightSearchPageTest extends ApplicationBase {
	
	ActionsUtils actions;
	HomePage homePage;
	SearchPage searchPage;
	FlightSearchPage flightSearchPage;
	
	
	

	@Test (dataProvider = "Default")
	public void validateFlightSearchFeature(HashMap<String, String> testData) {
		Logger _log = Logger.getLogger(HomePageTest.class);
		homePage = new HomePage(driver);
		actions = new ActionsUtils(driver);
		searchPage = new SearchPage(driver);
		flightSearchPage = new FlightSearchPage(driver);
		
		HashMap<String, String> inputDataMap =JSONUtils.readSimpleJSONTOMAP(testData.get("InputData"));
		homePage.searchText(inputDataMap.get("Text"));
		
		searchPage.goToFligtSearchLink();
		
		sAssert.assertTrue(actions.isWebElementExist(flightSearchPage.flightSearch_TicketTypeDropDown, "Ticket Type dropdown"), "Ticket Type dropdown is missing");
		sAssert.assertTrue(actions.isWebElementExist(flightSearchPage.flightSearch_PassangerDropDown, "Passanger dropdown"), "Passanger dropdown is missing");
		sAssert.assertTrue(actions.isWebElementExist(flightSearchPage.flightSearch_SeatingClassDropdown, "Seating Class dropdown"), "Seating class dropdown is missing");
		sAssert.assertTrue(actions.isWebElementExist(flightSearchPage.flightSearch_OriginAirportElementToBeClicked, "Origin Airport field"), "Origin Airport field is missing");
		sAssert.assertTrue(actions.isWebElementExist(flightSearchPage.flightSearch_DestinationAirportElementToBeClicked, "Destination Airport field"), "Destination Airport field is missing");
		sAssert.assertTrue(actions.isWebElementExist(flightSearchPage.flightSearch_SearchButton, "Flight search button"), "Flight search button is missing");
		
		
		flightSearchPage.enterOneWayFlightSearchDataAndSearch(inputDataMap);
		
		
		sAssert.assertAll();
	}

}
