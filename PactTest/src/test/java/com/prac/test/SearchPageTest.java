package com.prac.test;

import java.util.HashMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.prac.pageObjects.ApplicationBase;
import com.prac.pageObjects.HomePage;
import com.prac.pageObjects.SearchPage;
import com.prac.utils.JSONUtils;
import com.prac.utils.Actions.ActionsUtils;

public class SearchPageTest extends ApplicationBase {
	
	ActionsUtils actions;
	HomePage homePage;
	SearchPage searchPage;
	
	
	

	@Test (dataProvider = "Default")
	public void validateSearchPageLinks(HashMap<String, String> testData) {
		Logger _log = Logger.getLogger(HomePageTest.class);
		homePage = new HomePage(driver);
		actions = new ActionsUtils(driver);
		searchPage = new SearchPage(driver);
		HashMap<String, String> InputDataMap =JSONUtils.readSimpleJSONTOMAP(testData.get("InputData"));
		homePage.searchText(InputDataMap.get("Text"));
		sAssert.assertTrue(actions.isWebElementExist(searchPage.searchPage_Links_All, "All link on search Page"),"All links not present of search Page");
		sAssert.assertTrue(actions.isWebElementExist(searchPage.searchPage_Links_Images, "Images link on search Page"),"Images links not present of search Page");
		sAssert.assertTrue(actions.isWebElementExist(searchPage.searchPage_Links_Books, "Books link on search Page"),"Books links not present of search Page");
		sAssert.assertTrue(actions.isWebElementExist(searchPage.searchPage_Links_Maps, "Maps link on search Page"),"Maps links not present of search Page");
		sAssert.assertTrue(actions.isWebElementExist(searchPage.searchPage_Links_News, "News link on search Page"),"News links not present of search Page");
		sAssert.assertAll();
	}

}
