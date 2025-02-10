package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	//Constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	//Locators
	
	@FindBy(xpath="//input[@id='input-email']") 
	@CacheLookup
	WebElement txteMail;
	
	
	@FindBy(xpath="//input[@id='input-password']")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(xpath="//div[@class='form-group']//a[normalize-space()='Forgotten Password']") 
	@CacheLookup
	WebElement btnforgottenPassword;
	
	@FindBy(xpath="//input[@value='Login']") 
	@CacheLookup
	WebElement btnlogin;
	
	//Methods
	
	public void enterEmail(String email)
	{
		txteMail.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		txtpassword.sendKeys(password);
	}
	
	public void clicklogin()
	{
		btnlogin.click();
	}
	
	public void clickForgottenPassword()
	{
		btnforgottenPassword.click();
	}
}
