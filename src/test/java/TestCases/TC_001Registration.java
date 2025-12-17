package TestCases;

import org.testng.annotations.Test;

import Testbase.baseclass1;
import pageobject.Login;

public class TC_001Registration extends baseclass1 {

	
	@Test
	public void m1() {
		
		Login ff1 = new Login(driver);
	
	ff1.clklogin("Admin");
	ff1.clkpass("admin123");
	ff1.btnsubmit();
	}
	
	
}
