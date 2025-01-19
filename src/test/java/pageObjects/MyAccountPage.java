
package pageObjects;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;


public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement h2_MyAccount;
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
	WebElement lnk_Logout;
	
	//*[@id="content"]/h2[1]
	//h2[normalize-space()='My Account']
	public boolean myAccountIsDisplayed()
	{
		try
		{
			return h2_MyAccount.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}

			
	
	public void clickLogout()
	{
	  
	   lnk_Logout.click();
	}

}
