package com.ag.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage {
	WebDriver driver;
	
	
	public HomePage(WebDriver ldriver) {
		this.driver = ldriver;
		
	}
	
// We are using Assertion here (called Hard Assertions)
//	@FindBy(<locator>) WebElement <PO name> 

	@FindBy(xpath="//button[@data-tid='login']") WebElement SignInLink;
	@FindBy(xpath="//div[@data-tid='modal']") WebElement LoginModal;
	@FindBy(xpath="//div[@data-tid='modal'] //*[@data-tid='close-modal']") WebElement LoginModalXbutton;
	@FindBy(id="email") WebElement loginEmail;
	@FindBy(id="password") WebElement loginPass;
	@FindBy(xpath="//input[@data-tid='submit-button']") WebElement submitButton;
	@FindBy(xpath="//button[@data-tid='my-places']") WebElement myPlacesLink;
	@FindBy(xpath="//button[@data-tid='my-places']/a/span") WebElement myPlacesLinkCount;
	
	
	
	public void signIn(String uName, String pass) {
		// As execution is going super fast, added below 5 sec pause to see what it is doing.
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertTrue(SignInLink.isDisplayed(), "SignIn Link NOT Visible!");
		SignInLink.click();
		Assert.assertTrue(LoginModal.isDisplayed(), "Login Modal NOT appeared!");
		loginEmail.sendKeys(uName);
		loginPass.sendKeys(pass);
		submitButton.click();		
	}
	
	public void validateMyFavCount() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(myPlacesLink.isDisplayed(),"My Places link NOT appeared!");
		String myPlacesText = myPlacesLinkCount.getText();
		System.out.println("myPlacesText: "+myPlacesText);
		Assert.assertEquals(myPlacesText,"My Favorites (3)" ,"My favs value is NOT 2. Please check.");
		
	}
	
	
}
