package testCases;
import org.testng.annotations.Test;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC1_Register extends BaseClass {

	@Test(groups= {"master","sanity"})
	public void testRegister() throws InterruptedException
	{
		
		logger.info("*****STARTING TC1_Register*****");
	    HomePage hp=new HomePage(driver);
		logger.info("Clicking My account");
		hp.clickMyAccount();
		logger.info("Clicking on Register");
		hp.clickRegister();
		logger.info("Navigating to Register Page...");
		RegisterPage rp=new RegisterPage(driver);
		logger.info("Entering first name");
		rp.setFirstName(randomString(7));
		logger.info("Entering last name");
		rp.setLastName(randomString(3));
		logger.info("Entering email id");
		rp.setEmail("user"+randomString(7)+"@gmail.com");
		logger.info("Entering telephone no");
		rp.setTelephone(TelephoneNumberGenerator());
		String password= "User"+randomString(5)+"123!";
		logger.info("Entering password");
		rp.setPassword(password);
		logger.info("Entering confirm password");
		rp.setConfirmPassword(password);
		logger.info("Checking the policy checkbox");
		rp.checkPolicy();
		logger.info("Clicking on Continue");
		rp.clickContinue();
		String msg=rp.getAccountSuccessMsg();
		if(msg.equals("Your Account Has Been Created!"))
		{
			logger.info("*****TC1_Register completed*****");
			Assert.assertTrue(true);
		}
		else
		{ 
			logger.error("Account has not been created");
			Assert.fail();
		}

	}










}
