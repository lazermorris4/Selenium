package com.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverController {
	
	public String status;
	public WebDriver driver;
	
	

	public DriverController() {
}
	
	

	public String selectBrowser(int testId, String browserName, String url, String testName){
		
		Validation validation = new Validation();
		CaptureScreenshot captureScreenshot = new CaptureScreenshot();
		BrowserClose browserClose = new BrowserClose();
		BrowserOpen browserOpen= new BrowserOpen();
		
		if (browserName.equalsIgnoreCase("Google Chrome")) {
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			browserOpen.openChrome(url,driver);
			status= validation.status(testId, testName, browserName, driver);
			captureScreenshot.createFolder();
			captureScreenshot.capturPic(browserName, testName,driver);
			browserClose.selectCloseBrowser(browserName, driver);
			
		}
		
		
		
		
		else if (browserName.equalsIgnoreCase("Mozilla Firefox")) {
			WebDriver driver = new FirefoxDriver();
			browserOpen.openFirefox(url, driver);
			status= validation.status(testId, testName, browserName, driver);
			captureScreenshot.createFolder();
			captureScreenshot.capturPic(browserName, testName,driver);
			browserClose.selectCloseBrowser(browserName,driver);
		}
		
		
		
		
		else if (browserName.equalsIgnoreCase("Internet Explorer")) {
		
			System.setProperty("webdriver.ie.driver","IEDriverServer.exe");
			WebDriver driver = new InternetExplorerDriver();
			browserOpen.openInternetExplorer(url, driver);		  
			status= validation.status(testId, testName, browserName, driver);
			captureScreenshot.createFolder();
			captureScreenshot.capturPic(browserName, testName,driver);
			browserClose.selectCloseBrowser(browserName,driver);
		}
		return status;
		
	}

	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}


	
	
}