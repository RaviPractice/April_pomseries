package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hupspot.pages.HomePage;
import com.qa.hupspot.pages.LoginPage;

public class LoginPageTest {
	WebDriver driver;
	public static Properties prop;
	BasePage basepage;
	LoginPage loginpage;
	HomePage homepage;
	
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		basepage = new BasePage();
		 prop = basepage.init_properties();
		String browseName =prop.getProperty("browser");
		System.out.println("browser name is :"+browseName);
		 driver = basepage.init_driver();
		driver.get(prop.getProperty("url"));
		loginpage = new LoginPage(driver);
		Thread.sleep(5000);
	}
	
	@Test(priority=1)
	public void verifyLoginPageTest() throws InterruptedException {
		Thread.sleep(5000);
		String title = loginpage.getPageTitle();
		System.out.println(" login page title is :"+title);
		Assert.assertEquals(title,"HubSpot Login");	
		
	}
	@Test(priority=2)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginpage.checkSignUpLink());
	}
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException {
		Thread.sleep(3000);
		homepage =loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(5000);
		String actName = homepage.getAccountName();
		System.out.println("account name is :"+actName);
		//Assert.assertEquals(actName,"htc global services");
		
		
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	

}
