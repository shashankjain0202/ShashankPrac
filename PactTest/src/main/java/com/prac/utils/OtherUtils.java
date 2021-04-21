package com.prac.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class OtherUtils {
	
	public static WebDriver driver;
	public OtherUtils(WebDriver driver){
		this.driver = driver;
	}
	
	public By getElementLocator(WebElement element) {
		
		By byLocator = null;
		String objLocator = getNameFromObjectID(element);
		objLocator.replaceAll("::", "@@@@");
		String[] path = objLocator.split(":");
		String ByName = path[0].trim();
		String locator = path[1].trim().replaceAll("@@@@", "::");
		switch (ByName) {
		case "className":
			byLocator = By.className(locator);
			break;
		case "cssSelector":
			byLocator = By.cssSelector(locator);
			break;
		case "id":
			byLocator = By.id(locator);
			break;
		case "linkText":
			byLocator = By.linkText(locator);
			break;
		case "name":
			byLocator = By.name(locator);
			break;
		case "partialLinkText":
			byLocator = By.partialLinkText(locator);
			break;
		case "tagName":
			byLocator = By.tagName(locator);
			break;
		case "xpath":
			byLocator = By.xpath(locator);
			break;
		default:
			break;
		}
		
		return byLocator;
		
	}
	
	public String getNameFromObjectID(WebElement element) {
		
		String[] obj = element.toString().split("->");
		if(obj.length>1){
			obj[1] = obj[1].substring(1, obj[1].length()-1);
			return obj[1].trim();
		}
		else {
			return "not found";
		}
				
	}
	
	public static void takeScreenshot(File destFile, WebDriver driver) {
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File src= scrShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
