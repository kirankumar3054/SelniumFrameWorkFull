
1st option - you can use config.Properties file for parameters

OR

2nd option - command line run using Maven with parameters.
export M2_HOME=/Users/krudrangi/apache-maven-3.6-2.3/
export PATH=$PATH:/Users/krudrangi/apache-maven-3.6-2.3/bin
# krudrangi@it-mbp-krudrangi (master *) ~/git/SelniumFrameWorkFull/AGSelFW: mvn install -DbrowserToBeTested=firefox -DurlToBeTested=https://www.qa.apartmentguide.com -DxmlFiles=testng.xml