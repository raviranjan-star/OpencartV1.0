package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups={"Sanity","Master","Regresssion"})
	public void verifyAccountRegistration()
	{
		logger.info("*****Starting TC001 Account Registration Test case *****");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		try
		{
			AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
			regpage.enterFirstName(random(5));
			regpage.enterLastName(random(5));
			regpage.enterEmail(random(10)+"@gmail.com");
			regpage.enterPhone(random(10));
			String pwd=random(8);
			regpage.enterPassword(pwd);
			regpage.enterRePassword(pwd);
			regpage.clickAgree();
			regpage.clickContinue();
			String confmsg=regpage.getConfigMsg();
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");// if Assertion failed catch block will not execute
		}
		catch(Exception e)
		{
			logger.error("***** Test Failled *****");
			Assert.fail();
		}
		
		logger.info("*****Ended TC001 Account Registration Test case *****");
	}
}
