package com.service;

import org.openqa.selenium.WebDriver;

public class Validation {
	boolean present;
	String status;

	public Validation() {

	}
	
		public String status(int id, String testName, String browserName, WebDriver driver){
		
			switch (id) {
			case 1:
				LTPlanning ltplanning = new LTPlanning();
				status=ltplanning.createNewProfile(driver);
				break;
			case 2:
				BOAChecking boachecking= new BOAChecking();
				status=boachecking.getCheckingAccount(driver);
				System.out.println("Inside BOA");
				break;

			default:
				status="Failed";
				break;
			}
			
			return status;
				
				
		
		}
	
}
