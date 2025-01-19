package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_Email;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_Password;
	@FindBy(xpath="//input[@type='submit'][@value='Login']")
	WebElement btn_Login;

	
	public void enterEmail(String email)
	{
	  
		txt_Email.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		
		 txt_Password.sendKeys(password);
	}
	
	public void Login()
	{
		btn_Login.click();
	}
	
	
	
	

}
