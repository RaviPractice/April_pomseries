package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	Properties prop;
	WebDriver driver;
	
	
	
	public WebDriver init_driver() {
		//System.out.println("browser name :"+browsername);
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		/*
		if(browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
			else if(browserName.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}
		*/	/*else {
				System.out.println(" browser name : "+browsername +" is not found ,please pass the correct browser");
			}*/
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		//driver.get(url);
		return driver;
		
		
	}
	
	public Properties init_properties() {
		try {
		 prop = new Properties();
		 String path =".\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties";
		
		 try {
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("some issue with config properties ..please correct your config.");
					
		} catch (IOException e) {
			e.printStackTrace();
		}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		 return prop;
		 
	}
	
	

}
