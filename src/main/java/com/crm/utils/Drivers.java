package com.crm.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Drivers {

	
      public static WebDriver driver;
      public static WebDriver getInstance(){
    	  if(driver==null ||((RemoteWebDriver) driver).getSessionId()==null){
    		  switch (Configuration.getProperty("browser")) {
			case "firefox":
				System.setProperty("webdriver.gecko.driver", Configuration.getProperty("firefox"));
				driver= new FirefoxDriver();
				break;
			case "ie":
				System.setProperty("webdriver.ie.driver", Configuration.getProperty("ie"));
				driver = new InternetExplorerDriver();
			break;
			case "chrome":
				System.setProperty("webdriver.chrome.driver", Configuration.getProperty("chrome"));
				driver = new ChromeDriver();
				break;
			}
    		  
    	  }
		return driver;
    	  
      
	}

}
