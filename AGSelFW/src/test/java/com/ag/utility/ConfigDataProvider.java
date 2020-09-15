package com.ag.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider() {
		
		File src = new File("./Config/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			System.out.println("Unable to read Properties file:"+e.getMessage());
		}
		
	}

	public String getBrowser() {
		return pro.getProperty("browser");
		
	}
	
	public String getCanaryUrl() {
		return pro.getProperty("canaryUrl");
		
	}
	
	public String getProdUrl() {
		return pro.getProperty("prodUrl");
		
	}
	
	public String getQaUrl() {
		return pro.getProperty("qaURL");
		
	}
}
