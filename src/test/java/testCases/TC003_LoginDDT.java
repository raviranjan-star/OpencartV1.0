package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

//DDT Data Driven testing
public class TC003_LoginDDT extends BaseClass{

		@Test(groups={"Regression","Master",},dataProvider="LoginData",dataProviderClass=DataProviders.class)
		public void verify_loginDDT(String email,String pwd,String exp)
		{
			logger.info("***** TC003_Test Started*****");
			try {
				//HomePage
				HomePage hp=new HomePage(driver);
				hp.clickMyAccount();
				hp.clickLogin();
				
				//Login
				LoginPage lp=new LoginPage(driver);
				lp.enterEmail(email);
				lp.enterPassword(pwd);
				lp.clicklogin();
				
				//Account page
				AccountPage ap=new AccountPage(driver);
				
				
				/*Data is valid  -	login success - test pass  - logout
									login failed - 	test fail

				Data is invalid -	login success - test fail  - logout
					login failed -	test pass*/
				
				if(exp.equalsIgnoreCase("valid")) {
					if(ap.msgStatus().equals("My Account")) {
						logger.info("***** Test Passed valid is found*****");
						ap.clickBtnLogout();
					}
					else {
						logger.info("***** Test Failed valid*****");
						Assert.fail();
					}
				}
			
				else
				{
					if(ap.msgStatus().equals("My Account")) {
						ap.clickBtnLogout();
						logger.info("***** Test Failed invalid*****");
						Assert.fail();	
					}
					else {
						logger.info("***** Test Passed invalid*****");
					}
					
				}
			}
			catch(Exception e) {
				Assert.fail();
			}
			logger.info("***** TC003_Test Finished *****");
		}
}
