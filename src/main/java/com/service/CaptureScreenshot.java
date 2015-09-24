package com.service;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot {
	public String userName=System.getProperty("user.name");
	String timestamp;
	
	public CaptureScreenshot() {

	}
	
	
	public void createFolder(){
		System.out.println("Inside create folder");
		try{
			File file = new File("C://Users/"+userName+"/UIAutomation");
			if(!file.exists()){
				file.mkdirs();
			}
			}catch(Exception e) {
			e.printStackTrace();}
	}

	public void capturPic(String browserName, String testName, WebDriver driver){   
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
		Calendar cal = Calendar.getInstance();
		timestamp = dateFormat.format(cal.getTime());
		System.out.println("Inside create time");
		System.out.println(timestamp);
	      
			if (browserName.equalsIgnoreCase("Google Chrome")) {
				screenshotChrome(testName,userName,driver,timestamp);
			}else if (browserName.equalsIgnoreCase("Mozilla Firefox")) {
				screenshotFirefox(testName,userName,driver,timestamp);
			}else if (browserName.equalsIgnoreCase("Internet Explorer")) {
				screenshotInternetExplorer(testName,userName,driver,timestamp);
			}
	}
	

	
	public void screenshotChrome(String testName, String userName, WebDriver driver, String timestamp){
		
		System.out.println("Inside create screenshot");
		try{
			File scrnsht = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrnsht, new	File("C://Users/"+userName+"/UIAutomation/"+testName+"_Chrome_"+timestamp+".png"));
			}
		catch (Exception e) {
			e.printStackTrace();}
				
	}

	public void screenshotFirefox(String testName, String userName, WebDriver driver, String timestamp){
		
		
		try{
			File scrnsht = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrnsht, new	File("C://Users/"+userName+"/UIAutomation/"+testName+"_Firefox_"+timestamp+".png"));
			}
		catch (Exception e) {
			e.printStackTrace();}
		
	}
	public void screenshotInternetExplorer(String testName, String userName, WebDriver driver, String timestamp){
		
	   
	   try{
			File scrnsht = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrnsht, new	File("C://Users/"+userName+"/UIAutomation/"+testName+"_IEexplorer_"+timestamp+".png"));
			}
		catch (Exception e) {
			e.printStackTrace();}
	   
	}
	
}
