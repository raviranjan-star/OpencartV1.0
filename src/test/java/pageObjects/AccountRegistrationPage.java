package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	// TODO Auto-generated constructor stub
	WebDriver driver;
	
	//Constructor
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	//Locators

	@FindBy(xpath="//input[@id='input-firstname']") 
	@CacheLookup
	WebElement txtfirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']") 
	@CacheLookup
	WebElement txtlastName;
	
	@FindBy(xpath="//input[@id='input-email']") 
	@CacheLookup
	WebElement txteMail;
	
	@FindBy(xpath="//input[@id='input-telephone']") 
	@CacheLookup
	WebElement txtPhone;
	
	@FindBy(xpath="//input[@id='input-password']") 
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']") 
	@CacheLookup
	WebElement txtRePassword;
	
	@FindBy(xpath="//input[@name='agree']") 
	@CacheLookup
	WebElement chkAgree;
	
	@FindBy(xpath="//input[@value='Continue']") 
	@CacheLookup
	WebElement btnContinue;
	
	@FindBy(xpath="//div[@id='content']/h1") 
	@CacheLookup
	WebElement msgConfirmation;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") 
	@CacheLookup
	WebElement errEmailAlready;
	
	//Methods
	public void enterFirstName(String fname)
	{
		txtfirstName.sendKeys(fname);
	}
	
	public void enterLastName(String lname)
	{
		txtlastName.sendKeys(lname);
	}
	
	public void enterEmail(String email)
	{
		 txteMail.sendKeys(email);
	}
	
	public void enterPhone(String phn)
	{
		txtPhone.sendKeys(phn);
	}
	
	public void enterPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void enterRePassword(String pwd)
	{
		txtRePassword.sendKeys(pwd);
	}
	
	public void clickAgree()
	{
		 chkAgree.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	public String getConfigMsg()
	{
		try {
			return msgConfirmation.getText();
		}
		catch(Exception e)
		{
			return "false";
		}
	}	
	
	public String getErrEmailAlready()
	{
		try {
			return errEmailAlready.getText();
		}
		catch(Exception e)
		{
			return "false";
		}
	}
}
