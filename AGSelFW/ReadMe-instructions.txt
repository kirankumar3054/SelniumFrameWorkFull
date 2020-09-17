	
	Features of this Frame Work (Java/Selenium/TestNG)
	==================================================
	1. Extent Reports (Listeners cannot be customized. Hence Extent Reports preferred)
	2. Reporter Log
	3. Automatic ScreenShot capability with Date & Time (on TC fail/pass)
	4. Three ways of data reading from outside: 
			a. Excel reading capability for Application data.
			b. PROPERTIES file reading for Configuration data.
			c. Reading value from CLI for run time (i.e Maven systemPropertyVariables).
	5. Maven Build (Both from UI & CLI)
	6. Local three browser envs (chrome, firefox & Safari).
	7. SauceLabs connectivity (chrome & ie)
	8. BDD implementation  -- Pending
	9. Visual Testing   -- Pending



This framework is cable of run scripts local system as well as SauceLabs.  
And it is configured to take sauce user & access key from local terminal (which are already exported to local like below example:)
export SAUCE_USERNAME=krudrangi SAUCE_ACCESS_KEY=eaed9e16-e999-4b16-a510-8a57eb740d97


1st option - you can use config.PROPERTIES file for parameters

OR

2nd option - command line run using MAVEN with parameters.
export M2_HOME=/Users/krudrangi/apache-maven-3.6-2.3/
export PATH=$PATH:/Users/krudrangi/apache-maven-3.6-2.3/bin
export APPLITOOLS_API_KEY=DEOpjtCLyNn108Mjk7a0osTYWbqdRRxEjtA2mCfka0gcE110
export SAUCE_USERNAME=krudrangi SAUCE_ACCESS_KEY=dkdYOUR_KEYkdkdkdkdkdkdkdkdkdkdkdkd

# krudrangi@it-mbp-krudrangi (master *) ~/git/SelniumFrameWorkFull/AGSelFW: mvn install -DbrowserToBeTested=firefox -DurlToBeTested=https://www.qa.apartmentguide.com -DxmlFiles=testng.xml
# krudrangi@it-mbp-krudrangi (master *) ~/git/SelniumFrameWorkFull/AGSelFW: mvn install -DbrowserToBeTested=sauce_ie -DurlToBeTested=https://www.qa.apartmentguide.com -DxmlFiles=testng.xml




		eyes.open(driver, "Demo App", "Smoke Test", new RectangleSize(800, 800));
				
		// Visual checkpoint #1 - Check the login page.
		eyes.checkWindow("Login Window");

		// Visual checkpoint #2 - Check the app page.
		eyes.checkWindow("App Window");

		// End the test.
		eyes.closeAsync();