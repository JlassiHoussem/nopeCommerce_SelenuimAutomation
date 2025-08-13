package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase{
	
	HomePage homeObject;
	UserRegistrationPage registernObject;
	LoginPage loginObject;
	
	@Test(priority=1 ,alwaysRun = true )
	public void UserCanRegisterSuccessfully() {
		
		homeObject =new HomePage(driver);
		homeObject.openRegistrationPage();
		registernObject = new UserRegistrationPage(driver);
		registernObject.userRegistration("Houssem", "Jlassi", "testemail4@gmail.com", "1234567889");
		System.out.println("Please solve the CAPTCHA manually...");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Wait 20 seconds for human to solve
		
		//Assert.assertTrue(registernObject.successMessage.getText().contains("Your registration completed"));	
	}
	
	@Test(dependsOnMethods = {"UserCanRegisterSuccessfully"} )
	public void RegisteredUserCanLogout() {
		registernObject.userLogout();
	}
	
	@Test(dependsOnMethods = {"RegisteredUserCanLogout"} )
	public void RegisteredUserCanLogin() {
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin("testemail4@gmail.com", "1234567889");
		Assert.assertTrue(registernObject.logoutLink.getText().contains("Log out"));	

	}

}
