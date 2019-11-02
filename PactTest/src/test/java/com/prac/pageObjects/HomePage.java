package com.prac.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.prac.utils.Actions.ActionsUtils;

public class HomePage extends ApplicationBase {
	
ActionsUtils actions;

public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actions = new ActionsUtils(driver);
}
	
@FindBy(xpath = ".//*[text()='About']")
public WebElement homePage_AboutLink;

@FindBy(xpath = ".//*[text()='Store']")
public WebElement homePage_StoreLink;

@FindBy(xpath = ".//*[text()='Gmail']")
public WebElement homePage_GmailLink;

@FindBy(xpath = ".//*[text()='Images']")
public WebElement homePage_ImagesLink;

@FindBy(xpath = ".//*[@title='Google apps']")
public WebElement homePage_AppsLink;

@FindBy(name = "q")
public WebElement homePage_searchTextBox;

@FindBy(name = "btnK")
public WebElement homePage_searchButton;

public void searchText(String text) {
	
	actions.clearAndTypeTextField(homePage_searchTextBox, text, "Search Text field");
	actions.clickElement(homePage_searchButton, "Search Button");
	
}



}
