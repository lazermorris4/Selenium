	package com.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TripController {

   // private final AtomicLong counter = new AtomicLong();
	//public String url="https://www.google.com";
	public String returnedStatus;

    @RequestMapping("/test/{testId}")
    public @ResponseBody String validation (@PathVariable(value="testId") int testId, @RequestParam(value="testCase", required =false) String testName, @RequestParam(value="browser", required =false) String browserName,@RequestParam(value="url", required =false) String urlName){
 
        DriverController driverController = new DriverController();
    	String returnedStatus =driverController.selectBrowser(testId, browserName, urlName,testName);   	
    	return returnedStatus; 
        
    }
    
    @RequestMapping()
    public String displayHtmlPage() {
       	return "executionstatus";
    }


}
