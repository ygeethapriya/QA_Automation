package com.crm.objectRepository;

import java.io.FileInputStream;
import java.util.Properties;

public class CrmOr {

	public FileInputStream  fis = null;
	public Properties prop = null;
	
	public Properties getCrmObjects(){
		try {
			//System.out.println("Path : "+System.getProperty(("user.dir"))+"\\src\\test\\resource\\crmobjects.properties");
			fis = new FileInputStream("C:\\Users\\Assassin\\JavaPractise1\\SeleniumPractice\\src\\test\\resource\\crmobjects.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("I'm in catch");
			e.printStackTrace();
		}
		return prop;
		
	}

}
