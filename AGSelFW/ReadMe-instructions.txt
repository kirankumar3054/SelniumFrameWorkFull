
This framework is cable of run scripts local system as well as SauceLabs.  
And it is configured to take sauce user & access key from local terminal (which are already exported to local like below example:)
export SAUCE_USERNAME=krudrangi SAUCE_ACCESS_KEY=eaed9e16-e999-4b16-a510-8a57eb740d97


1st option - you can use config.PROPERTIES file for parameters

OR

2nd option - command line run using MAVEN with parameters.
export M2_HOME=/Users/krudrangi/apache-maven-3.6-2.3/
export PATH=$PATH:/Users/krudrangi/apache-maven-3.6-2.3/bin

# krudrangi@it-mbp-krudrangi (master *) ~/git/SelniumFrameWorkFull/AGSelFW: mvn install -DbrowserToBeTested=firefox -DurlToBeTested=https://www.qa.apartmentguide.com -DxmlFiles=testng.xml
# krudrangi@it-mbp-krudrangi (master *) ~/git/SelniumFrameWorkFull/AGSelFW: mvn install -DbrowserToBeTested=sauce_ie -DurlToBeTested=https://www.qa.apartmentguide.com -DxmlFiles=testng.xml