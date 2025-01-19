package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC2_Login extends BaseClass{
	
    @Test(groups= {"master","sanity","regression"})
	public void testLogin()
	{
		logger.info("*****Starting TC2_Login*****");
		HomePage hp=new HomePage(driver);
		logger.info("Clicking myAccount from Homepage");
		hp.clickMyAccount();
		logger.info("Clicking Login from home page");
		hp.clickLogin();
		LoginPage lp=new LoginPage(driver);
		logger.info("Entering email");
		lp.enterEmail(p.getProperty("email"));
		logger.info("Entering password");
		lp.enterPassword(p.getProperty("password"));
		logger.info("Clicking Login button");
		lp.Login();

		MyAccountPage ap=new MyAccountPage(driver);
		if(ap.myAccountIsDisplayed()==true)
		{
			logger.info("*****TC2_Login Completed*****");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("myAccount not displayed or not landed to myAccount page");
			Assert.fail();
		}

	}
}
