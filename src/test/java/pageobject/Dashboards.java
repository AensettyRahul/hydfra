package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Dashboards extends BaseObject {

	public Dashboards(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//locators	
	
	@FindBy(xpath = "//span[normalize-space()='Time']")
	WebElement time;
	
	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement txtemplname;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btn;
	
	public void clktime()
	{
		time.click();
	}
	public void employename(String name) {
		txtemplname.sendKeys(name);
	}
	public void button() {
		btn.click();
	}
	
	
//Action Methods	
	
	
}
