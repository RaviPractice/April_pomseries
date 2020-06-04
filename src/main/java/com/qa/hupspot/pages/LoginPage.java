package com.qa.hupspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage {
	WebDriver driver;
	
	//1.locators :By class
	By emailId = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}
	//2.page Actions
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public boolean checkSignUpLink() {
		return driver.findElement(signUpLink).isDisplayed();
	}
	
	public HomePage doLogin(String UserName,String pwd) {
		driver.findElement(emailId).sendKeys(UserName);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
		return new HomePage(driver);
		
	}
	
	
	
	
	
	
	
	
	

}
