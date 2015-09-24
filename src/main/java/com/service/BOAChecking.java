package com.service;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.crypto.*;


public class BOAChecking {
	boolean present;
	WebElement userId;
	String loginId ="lazermorris4";
	String pwd = "";
	//String encryptedPassword = encrypt(pwd);
    List<WebElement> Trans = new ArrayList<WebElement>();
	
	public String getCheckingAccount(WebDriver driver){
		
		WebDriverWait wait = new WebDriverWait(driver,20);	
		wait.until(ExpectedConditions.elementToBeClickable(By.name("state_select_submit")));
		Select dropdownDest = new Select(driver.findElement(By.cssSelector("select[id='stateListId']")));
		dropdownDest.selectByValue("TX");
		driver.findElement(By.name("state_select_submit")).click();
		
		
		try {			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			wait.until(ExpectedConditions.elementToBeClickable(By.id("skw-enter-online-id-submit")));
			userId=driver.findElement(By.id("skw-enter-online-id"));
			userId.sendKeys(loginId);
			js.executeScript("document.getElementById('tlpvt-skw-enter-pass').setAttribute('value','"+pwd+"')");
			driver.findElement(By.id("skw-enter-online-id-submit")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.name("DDA_details")));
			driver.findElement(By.cssSelector("a[name='DDA_details']")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[name='Account_balance_history']")));
			Trans= driver.findElements(By.cssSelector("[class='amount TL_NPI_Amt isDebit']"));
					
			for (int i = 0; i < Trans.size(); i++) {
				System.out.println("Elements are "+Trans.get(i).getText());
			}
			
					
			present=true;
			} catch (NoSuchElementException e) {
			// TODO: handle exception
			present=false;
		} 
		if (present==true) {
			return "Passed";
			
		} else {
			return "Failed";
		}
	}

}
