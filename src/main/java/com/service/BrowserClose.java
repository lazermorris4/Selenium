package com.service;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserClose {
	
	
	public BrowserClose() {
		
		}
	
	public void selectCloseBrowser(String browserName, WebDriver driver){
		
		if (browserName.equalsIgnoreCase("Google Chrome")) {
			closeChrome(driver);
		}else if (browserName.equalsIgnoreCase("Mozilla Firefox")) {
			closeFirefox(driver);
		}else if (browserName.equalsIgnoreCase("Internet Explorer")) {
			closeInternetExplorer(driver);
		}
	
	}


	public void closeInternetExplorer(WebDriver driver) {
		// TODO Auto-generated method stub		
		driver.quit();		
	}
	
	public void closeFirefox(WebDriver driver) {
		// TODO Auto-generated method stub
		driver.quit();
		
	}

	public void closeChrome(WebDriver driver) {
		// TODO Auto-generated method stub		
		 driver.quit();
		/*
		  try {
		        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
		    } catch (IOException e) {
		        e.printStackTrace();
		    }*/
		
	}

}
