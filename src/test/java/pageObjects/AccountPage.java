package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{

	public AccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Locators
	
	@FindBy(xpath="//h2[normalize-space()='My Account']") 
	@CacheLookup
	WebElement status;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") 
	@CacheLookup
	WebElement btnLogout;
	
	public String msgStatus()
	{
		try {
			return status.getText();
		}catch(Exception e)
		{
			return "false";
		}
	}

	public void clickBtnLogout()
	{
		btnLogout.click();
	}
}
