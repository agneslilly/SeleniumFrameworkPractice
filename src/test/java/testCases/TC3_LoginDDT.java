package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC3_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="datadriven")
	public void testLoginDatadriven(String email,String password, String exp) throws InterruptedException
	{
		logger.info("*****Starting TC3_LoginDDT*****");
		HomePage hp=new HomePage(driver);
		logger.info("Clicking myAccount from Homepage");
		Thread.sleep(1000);
		hp.clickMyAccount();
		logger.info("Clicking Login from home page");
		Thread.sleep(2000);
		hp.clickLogin();
		LoginPage lp=new LoginPage(driver);
		logger.info("Entering email "+email);
		lp.enterEmail(email);
		logger.info("Entering password "+password);
		lp.enterPassword(password);
		logger.info("Clicking Login button");
		lp.Login();

		MyAccountPage ap=new MyAccountPage(driver);
		boolean targetPage=ap.myAccountIsDisplayed();
		if(exp.equalsIgnoreCase("Valid"))
		{
			
			if(targetPage==true)
			{ 
				logger.info("Logged in with valid data");
				ap.clickLogout();
				logger.info("Clicked on logout. Test will pass since logged in with Valid data");
				Assert.assertTrue(true);
			}
			else
			{
				logger.info("Could not login with Valid Data. Test will fail");
				Assert.fail();
			}
		}
		else if(exp.equalsIgnoreCase("Invalid"))
		{
            logger.info("Target page "+targetPage);
			if(targetPage==true)
			{
				logger.info("Logged in with Invalid data");
				ap.clickLogout();
				logger.info("Clicked on logout. Test will fail since logged in with Invalid data");
				Assert.fail();
			}
			else
			{   logger.info("Could not login with Invalid Data. Test will pass");
				Assert.assertTrue(true);
			}
		}
		logger.info("*****Finished TC3_LoginDDT*****");
		
		
		
		
		
		

	}

}
