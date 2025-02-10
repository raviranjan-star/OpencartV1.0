package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_LoginVerification extends BaseClass {

	@Test(groups={"Master","Sanity","Regression"})
	public void loginVerification()
	{
		logger.info("***** Login Verification Started*****");
		HomePage hp=new HomePage(driver);
		logger.info("HomePage Object is Created");
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.enterEmail(p.getProperty("email"));
		lp.enterPassword(p.getProperty("password"));
		lp.clicklogin();
		
		AccountPage ac=new AccountPage(driver);
		if(ac.msgStatus().equals("My Account")) {
			logger.info("***** Login Successful *****");
		}
		else
		{
			Assert.fail();
		}
		
		AccountPage ap=new AccountPage(driver);
		ap.clickBtnLogout();
				
	}
}
