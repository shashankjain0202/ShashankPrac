package com.prac.test;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.prac.base.baseClass;
import com.prac.pageObjects.ApplicationBase;
import com.prac.pageObjects.HomePage;
import com.prac.utils.JSONUtils;
import com.prac.utils.OtherUtils;
import com.prac.utils.Actions.ActionsUtils;;

public class HomePageTest extends ApplicationBase{
 
	HomePage homePage;
	ActionsUtils actions;

	@Test (dataProvider = "Default")
	public void validateHomePageTitle(HashMap<String, String> testData) {
		Logger _log = Logger.getLogger(HomePageTest.class);
		HashMap<String, String> ValidationDataMap =JSONUtils.readSimpleJSONTOMAP(testData.get("ValidationData"));	
		String title = driver.getTitle();
		String expectedTitle = ValidationDataMap.get("Title");
		_log.info("Title is:"+ expectedTitle);
		sAssert.assertEquals(title, expectedTitle);
		sAssert.assertAll();
	
	}
	
	@Test (dataProvider = "Default")
	public void verifyTopLinksHomePage(HashMap<String, String> testData) {
		Logger _log = Logger.getLogger(HomePageTest.class);
		actions = new ActionsUtils(driver);
		homePage = new HomePage(driver);
		sAssert.assertTrue(actions.isWebElementExist(homePage.homePage_AboutLink, "About Link"), "About link not found");
		sAssert.assertTrue(actions.isWebElementExist(homePage.homePage_StoreLink, "About Link"), "Store link not found");
		sAssert.assertTrue(actions.isWebElementExist(homePage.homePage_GmailLink, "About Link"), "Gmail link not found");
		sAssert.assertTrue(actions.isWebElementExist(homePage.homePage_ImagesLink, "About Link"), "Images link not found");
		sAssert.assertTrue(actions.isWebElementExist(homePage.homePage_AppsLink, "About Link"), "Apps link not found");	
		sAssert.assertAll();
	
	}
		
	

}
