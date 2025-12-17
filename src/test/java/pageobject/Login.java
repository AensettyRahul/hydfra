package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//import execl.Select;

public class Login extends BaseObject {

//contructor	
	
	//public WebDriver driver;
	public Login(WebDriver driver) {
		super(driver);
		
	}

//locators
	
	
		
    @FindBy(xpath = "//input[@placeholder='username']")
	WebElement txtemail;;
	
	@FindBy(xpath = "//input[@placeholder='username']")
	WebElement txtpass;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement btn;
	
	
	
	public void clklogin (String em)
	{
		txtemail.sendKeys(em);
		
		
	}
	
	public void clkpass(String pwd)
	{
		txtpass.sendKeys(pwd);
	}
	
	public void btnsubmit()
	{
		btn.click();
	}
	
}
