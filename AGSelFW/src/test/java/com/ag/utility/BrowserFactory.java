package com.ag.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
	
	public static WebDriver startLargeApp (WebDriver ldriver, String browserName, String launch_url) {
		
		final String USERNAME =  System.getenv("SAUCE_USERNAME");;
		final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
		final String SAUCE_URL = "https://"+USERNAME+":"+ACCESS_KEY+"@ondemand.us-west-1.saucelabs.com:443/wd/hub";
		
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
		else if (browserName.equals("sauce_chrome")) {
			DesiredCapabilities caps =  DesiredCapabilities.chrome();
			caps.setCapability("platform", "Windows 10");
			caps.setCapability("version", "latest");
			caps.setCapability("extendedDebugging", "true");
			caps.setCapability("name", "Test Script Name");
			caps.setCapability("buildNumber", "myBuild#3.0");
			
			try {
				ldriver = new RemoteWebDriver(new java.net.URL(SAUCE_URL), caps);
			} catch (Exception e) {
				System.out.println("Unable to connect Saucelabs CHROME browser..." +e.getMessage());
			}
		} 
		else if (browserName.equals("sauce_ie")) {
			MutableCapabilities sauceOptions = new MutableCapabilities();
			InternetExplorerOptions browserOptions = new InternetExplorerOptions();
			browserOptions.setCapability("platformName", "Windows 10");
			browserOptions.setCapability("browserVersion", "latest");
			browserOptions.setCapability("sauce:options", sauceOptions);
			browserOptions.setCapability("extendedDebugging", "true");
			
			try {
				ldriver = new RemoteWebDriver(new java.net.URL(SAUCE_URL), browserOptions);
			} catch (Exception e) {
				System.out.println("Unable to connect Saucelabs IE browser..." +e.getMessage());
			}
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
