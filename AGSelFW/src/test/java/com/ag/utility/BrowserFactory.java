package com.ag.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
	
	public static WebDriver startLargeApp (WebDriver ldriver, String browserName, String launch_url) {
		
		if (browserName.equals("chrome") ) {
			System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver");
			ldriver = new ChromeDriver();
			
		} 
		else if (browserName.equals("firefox")){ 
			System.setProperty("webdriver.gecko.driver", ".//Drivers//geckodriver");
			ldriver = new FirefoxDriver();
		}
		else if (browserName.equals("safari")) {
			System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
			ldriver = new SafariDriver();
		} 
		else {
			System.out.println("Sorry, We don't support this browser..");
		}
			
		ldriver.manage().timeouts().pageLoadTimeout(30,  TimeUnit.SECONDS);
		ldriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ldriver.manage().window().maximize();
		ldriver.get(launch_url);
		
		return ldriver;
	}
	
	public static void quitBrowser(WebDriver ldriver) {
		ldriver.quit();
	}
}
