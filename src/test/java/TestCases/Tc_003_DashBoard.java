package TestCases;

import org.testng.annotations.Test;

import Testbase.BaseClass;

import pageobject.Dashboards;
import pageobject.Login;

public class Tc_003_DashBoard extends BaseClass {

	
	//@Test(groups={"sanity"})
	@Test
	public void Dashboardmethod() {
		
		Login ff = new Login(driver);
	
	ff.clklogin("Admin");
	ff.clkpass("admin123");
	ff.btnsubmit();
		
		Dashboards dp = new Dashboards(driver);
		
		dp.clktime();
		dp.employename("Thomas Kutty Benny");
		dp.button();
	}
	
	
} 
