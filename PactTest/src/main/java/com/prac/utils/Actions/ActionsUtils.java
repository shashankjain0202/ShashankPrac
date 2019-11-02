package com.prac.utils.Actions;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.prac.utils.OtherUtils;

public class ActionsUtils {
	
	WebDriver driver;
	Logger _log;
	public ActionsUtils(WebDriver driver) {
		this.driver = driver;
		_log = Logger.getLogger(ActionsUtils.class);
	}
	
	public boolean isWebElementExist(WebElement element, String Desc) {
		
		OtherUtils oUtils = new OtherUtils(driver);
		List<WebElement> lst = driver.findElements(oUtils.getElementLocator(element));
		if (lst.size()>0) {
			_log.info("Element: "+ Desc+ " is found with"+ element.toString());
			return true;
		}
		else {
			_log.info("Element: "+ Desc+ " is not found with"+ element.toString());
			return false;		
		}
	}
	
	public void clearAndTypeTextField(WebElement element, String text, String eleDesc) {
		
		element.click();
		element.clear();
		_log.info("Cleared field: "+ eleDesc);
		element.sendKeys(text);
		_log.info("Entered"+ text+ "in field: "+ eleDesc);
	}
	
	public void clickElement(WebElement element, String eleDesc) {
		element.click();
		_log.info("Clicked field: "+ eleDesc);
	}

}
