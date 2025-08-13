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
	
	@FindBy(css="div.result")
	public WebElement successMessage;
	
	@FindBy(linkText = "Log out")
	public WebElement logoutLink;
	
	@FindBy(linkText = "My account")
	WebElement myAccountLink;
	
	@FindBy(className ="cb-i")
	public WebElement captchaBtn;
			
	
	public void userRegistration(String firstName,String lastName,String email,String password) {
		clickButton(genderRdoBtn);
		fnTxtBox.sendKeys(firstName);
		setTextElementText(fnTxtBox, firstName);
		setTextElementText(lnTxtBox, lastName);
		setTextElementText(passwordTxtBox, password);
		setTextElementText(confirmPasswordTxtBox, password);
		clickButton(registrBtn);
		 
	}
	
	public void userLogout() {
		clickButton(logoutLink);
	}
	
	public void openMyAccountPage() {
		clickButton(myAccountLink);
	}

}
