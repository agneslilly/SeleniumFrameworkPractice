package pageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {

	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnk_MyAccount;
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnk_Register;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement lnk_Login;
	
	
	public void clickMyAccount()
	{
		lnk_MyAccount.click();
	}
	
	public void clickRegister()
	{
		lnk_Register.click();
	}
	
	public void clickLogin()
	{
//		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(lnk_Login));
		lnk_Login.click();
	}


}
