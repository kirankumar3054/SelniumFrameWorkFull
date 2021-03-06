package com.ag.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.ag.utility.BrowserFactory;
import com.ag.utility.ConfigDataProvider;
import com.ag.utility.ExcelDataProvider;
import com.ag.utility.Helper;
import com.applitools.eyes.selenium.Eyes;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider prop; 
	public ExtentReports report;
	public ExtentTest logger;
	public Eyes eyes;
	
	
	@BeforeSuite
	public void setUpSuite() {
		
		Reporter.log("Settingup Excel, Properties & Reporter...", true);
		excel = new ExcelDataProvider();
		prop = new ConfigDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter (new File(System.getProperty("user.dir")+"/Reports/AGrunReport_"+Helper.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Settingup Excel, Properties & Reporter - Completed", true);
		
		Reporter.log("Settingup Applitools for Visual testing - make sure export it's Key.", true);
		Eyes eyes = new Eyes();
		eyes.setApiKey("DEOpjtCLyNn108Mjk7a0osTYWbqdRRxEjtA2mCfka0gcE110");
		Reporter.log("Settingup Applitools for Visual testing - Completed.", true);
		
		
	}
	
	@Parameters({"browserToBeTested", "urlToBeTested"})
	@BeforeClass
	public void before (String browser, String url) {
		
		Reporter.log("Brining up desired browser with desired launch url...", true);
//		To Reads browser & url from config.properties file		
//		driver = BrowserFactory.startLargeApp(driver, prop.getBrowser(), prop.getQaUrl());
		
//		Below is to read browser & url from Maven System Properties at RUN TIME
		driver = BrowserFactory.startLargeApp(driver, browser, url);
		Reporter.log("Desired Browser ready with desired URL- completed", true);
	}

	@AfterClass
	public void after() {
		Reporter.log("Quitting the browser...", true);
		BrowserFactory.quitBrowser(driver);
		Reporter.log("Broser quitted - completed", true);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		Reporter.log("Test is about to end....", true);
		
		if(result.getStatus()==ITestResult.FAILURE) {
			logger.fail("Test Failed :( ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		} else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test Passed :) ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		report.flush();
		Reporter.log("Test completed >>>> Reports generated....", true);
	}

}
