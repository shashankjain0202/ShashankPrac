package com.prac.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class fileUtils {
	
	public final String filePath = System.getProperty("user.dir")+"\\src\\test\\resources\\env.properties";
	Properties properties;
	
	public void configPropertyFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getProperty(String propertyName) {
		fileUtils utils = new fileUtils();
		utils.configPropertyFileReader();
		return utils.properties.getProperty(propertyName);		
		
	}

}
