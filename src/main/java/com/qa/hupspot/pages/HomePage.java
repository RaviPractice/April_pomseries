package com.qa.hupspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class HomePage extends BasePage {
	WebDriver driver;
	
	//1.locators using by class
	By hompePageHeader = By.cssSelector("h1.private-page__title");
	//By accountName = By.cssSelector("span.account-name");
	By accountName = By.xpath("(//div[@class='navAccount-accountName'])[1]");
	
	//2.page Actions
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		
	}
	public String getPageTitleTest() {
		return driver.getTitle();
	}
	
	public String getHomePageHeader() {
		return driver.findElement(hompePageHeader).getText();
	}
	
	public String getAccountName() {
		return driver.findElement(accountName).getText();
	}
	
	
	
	
	

}
