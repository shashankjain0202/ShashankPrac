package com.prac.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.prac.utils.Actions.ActionsUtils;

public class SearchPage extends ApplicationBase {
	
ActionsUtils actions;

public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actions = new ActionsUtils(driver);
}

@FindBy(xpath = ".//*[@id='hdtb-msb-vis']/div[1]")
public WebElement searchPage_Links_All;

@FindBy(xpath = ".//*[@id='hdtb-msb-vis']/div[2]")
public WebElement searchPage_Links_Images;

@FindBy(xpath = ".//*[@id='hdtb-msb-vis']/div[3]")
public WebElement searchPage_Links_News;

@FindBy(xpath = ".//*[@id='hdtb-msb-vis']/div[4]")
public WebElement searchPage_Links_Books;

@FindBy(xpath = ".//*[@id='hdtb-msb-vis']/div[5]")
public WebElement searchPage_Links_Maps;

@FindBy(xpath = ".//*[@jscontroller='TJw5qb']")
public WebElement searchPage_ImagesSearch_CameraIcon;

@FindBy(xpath = ".//g-header-menu/a[@jsname='LgbsSe']/span[@class='more-vert z1asCe SaPW2b']")
public WebElement searchPage_moreOptionsLink;

@FindBy(xpath = ".//a[contains(@href,'flights')]")
public WebElement searchPage_moreOptionsLink_flights;

public By searchPage_Links_All_By = By.xpath(".//*[@id='hdtb-msb-vis']/div[1]");
public By searchPage_Links_Images_By =  By.xpath(".//*[@id='hdtb-msb-vis']/div[2]");
public By searchPage_Links_News_By = By.xpath(".//*[@id='hdtb-msb-vis']/div[3]");
public By searchPage_Links_Books_By = By.xpath(".//*[@id='hdtb-msb-vis']/div[4]");
public By searchPage_Links_Maps_By = By.xpath(".//*[@id='hdtb-msb-vis']/div[5]");



public void goToFligtSearchLink() {
	actions.clickElement(searchPage_moreOptionsLink, "More options link");
	actions.clickElement(searchPage_moreOptionsLink_flights, "flight search link");
}



}
