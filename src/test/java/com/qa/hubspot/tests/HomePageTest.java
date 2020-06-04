package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hupspot.pages.HomePage;
import com.qa.hupspot.pages.LoginPage;

public class HomePageTest {
	WebDriver driver;
	Properties prop;
	BasePage basepage;
	LoginPage loginpage;
	HomePage homepage;
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		basepage = new BasePage();
		prop = basepage.init_properties();
		String browseName =prop.getProperty("browser");
		//System.out.println("browser name is :"+browserName);
		driver = basepage.init_driver();
		driver.get(prop.getProperty("url"));
		loginpage = new LoginPage(driver);
		//homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));	
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(5000);
		
	}
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String title = homepage.getPageTitleTest();
		System.out.println("title of the browser is :"+title);
		Assert.assertEquals(title, "Reports dashboard");
		
	}
	@Test(priority=2)
	public void verifyhomepageHeaderTest() {
		String header = homepage.getHomePageHeader();
		System.out.println(" homepage header is :"+header);
		Assert.assertEquals(header, "Sales Dashboard");
		
	}
	@Test(priority=3)
	public void VerifyLoginInUserTest() {
		String actName = homepage.getAccountName();
		System.out.println(" account name is :"+actName);
		Assert.assertEquals(actName, "htc global services");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
