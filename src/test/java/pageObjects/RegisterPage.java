package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage

{

	public RegisterPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txt_FirstName;

	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txt_LastName;

	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_Email;

	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txt_Telephone;

	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_Password;

	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txt_ConfirmPassword;

	@FindBy(xpath="//input[@type='checkbox'][@name='agree']")
	WebElement chk_Policy;
	
	@FindBy(xpath="//input[@type='submit'][@value='Continue']")
	WebElement btn_Continue;
	
	@FindBy(xpath="//div[@id='content']/h1")
	WebElement msg_AccountSuccess;

	public void setFirstName(String firstname )
	{
		txt_FirstName.sendKeys(firstname);
	}

	public void setLastName(String lastname )
	{
		txt_LastName.sendKeys(lastname);
	}

	public void setEmail(String email)
	{
		txt_Email.sendKeys(email);
	}

	public void setTelephone(String telephoneNo)
	{
		txt_Telephone.sendKeys(telephoneNo);
	}

	public void setPassword(String password)
	{
		txt_Password.sendKeys(password);
	}

	public void setConfirmPassword(String confirmPassword)
	{
		txt_ConfirmPassword.sendKeys(confirmPassword);
	}

	public void checkPolicy()
	{
		chk_Policy.click();
	}

	public void clickContinue()
	{
		btn_Continue.click();
	}

	public String getAccountSuccessMsg()
	{
		return msg_AccountSuccess.getText();
	}
}

