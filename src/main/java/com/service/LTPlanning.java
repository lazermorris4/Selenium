package com.service;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class LTPlanning {
	
	boolean present;
	WebElement userId;
	WebElement password;
	WebElement profileName;
	String loginId ="71000005";
	public String pwd ="5amL0ad01";
	String newProfile="TestAut";
	
	public String createNewProfile(WebDriver driver){
		
		WebDriverWait wait = new WebDriverWait(driver, 30);	
		wait.until(ExpectedConditions.elementToBeClickable(By.id("userLoginId")));
		
		try{
			//userId=driver.findElement(By.id("userLoginId"));
			//userId.sendKeys(loginId);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			System.out.println(loginId);
			js.executeScript("document.getElementById('userLoginId').setAttribute('value','"+loginId+"')");
			//password=driver.findElement(By.id("userPassword"));
			js.executeScript("document.getElementById('userPassword').setAttribute('value','"+pwd+"')");
			driver.findElement(By.id("loginButton")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("A[href*='flightPlaning']")));
			driver.findElement(By.cssSelector("A[href*='flightplan/consumer/flightPlaning']")).click();
			driver.findElement(By.cssSelector("A[name='manageProfilesLinkwords'][class='ltProfileLink']")).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Select dropdown = new Select(driver.findElement(By.id("selectProfileID")));
			dropdown.selectByValue("Create a new profile");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//profileName=driver.findElement(By.id("profilenameId"));
			//profileName.sendKeys(newProfile);
			js.executeScript("document.getElementById('profilenameId').setAttribute('value','"+newProfile+"')");
			Select dropdownDest = new Select(driver.findElement(By.cssSelector("select[name='_BS_FromList_availabletag']")));
			dropdownDest.selectByValue("BOS");
			driver.findElement(By.cssSelector("input[name='listAddButton']")).click();
			driver.findElement(By.cssSelector("input[name='saveBtntag'][class='profileEightBlackRegText']")).click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Select dropdownnew = new Select(driver.findElement(By.id("selProfID")));
			List<WebElement> profileOptions = dropdownnew.getOptions();
			for (WebElement option : profileOptions) {
				  if(option.getText().equalsIgnoreCase("TestAut"))
				  {
					 present=true;
					 option.click();
				  }
				}
						  			  
		  }catch (NoSuchElementException e) {
			  present=false;
			  }
		if (present==true) {
			return "Passed";
			
		} else {
			return "Failed";
		}
	}
	}


