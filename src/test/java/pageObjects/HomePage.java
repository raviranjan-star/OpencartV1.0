package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	WebDriver driver;
	
	//Constructor
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	@FindBy(xpath="//a[@title='My Account']") 
	@CacheLookup
	WebElement linkMyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	@CacheLookup
	WebElement linkRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	@CacheLookup
	WebElement linkLogin;
	
	//Methods
	public void clickMyAccount()
	{
		linkMyAccount.click();
	}
	
	public void clickRegister()
	{
		linkRegister.click();
	}
	
	public void clickLogin()
	{
		linkLogin.click();
	}
	
}
