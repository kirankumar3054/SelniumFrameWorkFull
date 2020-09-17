package com.ag.testcases;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import com.ag.pages.BaseClass;
import com.ag.pages.HomePage;
import com.applitools.eyes.RectangleSize;

// We are using inheritance by extending other class for PRE/POSTt activities for 
// TestCase.  From now every class we write Must extend BaseClass to get PRE/POST. 
public class homePageLogin extends BaseClass {
	HomePage homePage; 

	
	@Test(priority=1)
	public void loginApp() {

		logger = report.createTest("1. SignIn");
		System.out.println(driver.getTitle());
		//		We are using ABSTRACTION here by hiding implementation details
		homePage = PageFactory.initElements(driver, HomePage.class);
		logger.info("Info Actual SignIN now.........");
		

		homePage.signIn(excel.getStringData("login", 0, 0), excel.getStringData("login", 0, 1));

		
	}
	
	@Test (priority=2)
	public void validateMyFavsCount() {
		logger = report.createTest("2. Validate fav count");
		homePage = PageFactory.initElements(driver, HomePage.class);
		logger.info("Info Actual Valiation now.........");
		homePage.validateMyFavCount();
	}

}
