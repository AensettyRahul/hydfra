package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseObject {

	public  WebDriver driver;
	
	public BaseObject(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

}

	