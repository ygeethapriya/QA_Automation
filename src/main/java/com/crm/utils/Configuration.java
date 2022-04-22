package com.crm.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class Configuration {

	private static Properties configFile;
	public static void EstablishFileStream(String fileName){
		try {
			String path = "./config/" + fileName + ".properties";
			FileInputStream input = new FileInputStream(path);
			configFile = new Properties();
			configFile.load(input);
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String getProperty(String keyName){
		String fileName = "config";
		EstablishFileStream(fileName);
		return configFile.getProperty(keyName);
		
		
	}
	public static String getProperty(String fileName , String keyName){
		EstablishFileStream(fileName);
		return  configFile.getProperty(keyName);
		
	}
}
