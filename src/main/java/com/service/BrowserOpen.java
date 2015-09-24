package com.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserOpen {
	
	public String url;
	public WebDriver driver;
	

	
	public void openInternetExplorer(String url, WebDriver driver) {
		// TODO Auto-generated method stub		
			driver.manage().window().maximize();
		    driver.navigate().to(url);
		    if (driver.findElement(By.id("overridelink")).isDisplayed()) {
		    	driver.get("javascript:document.getElementById('overridelink').click();");
			}
		    
		
	}
	public void openFirefox(String url, WebDriver driver) {
		// TODO Auto-generated method stub
	    driver.manage().window().maximize();
		driver.navigate().to(url);
		
	}

	public void openChrome(String url, WebDriver driver) {
		// TODO Auto-generated method stub		
		driver.manage().window().maximize();
		driver.navigate().to(url);
		
	}

}
