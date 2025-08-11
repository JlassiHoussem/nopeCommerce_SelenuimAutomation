package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase{
	
	HomePage homeObject;
	UserRegistrationPage registernObject;
	@Test
	public void UserCanRegisterSuccessfully() {
		
		homeObject =new HomePage(driver);
		homeObject.openRegistrationPage();
		registernObject = new UserRegistrationPage(driver);
		registernObject.userRegistration("Houssem", "Jlassi", "testemail@gmail.com", "123456788");
		
		
	}

}
