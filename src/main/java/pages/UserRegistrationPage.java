package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="gender-male")
	WebElement genderRdoBtn;
	
	@FindBy(id="FirstName")
	WebElement fnTxtBox;
	
	@FindBy(id="LastName")
	WebElement lnTxtBox;
	
	@FindBy(id="Email")
	WebElement emailTxtBox;
	
	@FindBy(id="Password")
	WebElement passwordTxtBox;
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmPasswordTxtBox;
	
	@FindBy(id="register-button")
	WebElement  registrBtn;
	
	public void userRegistration(String firstName,String lastName,String email,String password) {
		genderRdoBtn.click();
		fnTxtBox.sendKeys(firstName);
		lnTxtBox.sendKeys(lastName);
		emailTxtBox.sendKeys(email);
		passwordTxtBox.sendKeys(password);
		confirmPasswordTxtBox.sendKeys(password);
		registrBtn.click();
	}
	

}
