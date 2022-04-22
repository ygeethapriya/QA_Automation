package com.crm.config;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseConfiguration {
	public FileInputStream fis= null;
	public Properties prop = null;
	public WebDriver driver = null;
	
	public void invokebrowser(){
	try {
		fis = new FileInputStream(System.getProperty(("user.dir"))+"\\src\\test\\resource\\config.properties");
		prop = new Properties();
		prop.load(fis);
		String br = prop.getProperty("browser");
		if (br.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\java\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if(br.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.home")+"//"+"Documents//Script Drivers//geckodriver.exe");
            driver = new FirefoxDriver();
		}else if (br.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.home")+"//"+"Documents//Script Drivers//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.navigate().to(prop.getProperty("Uat_Url"));
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
 
	

}
