package TestCases;

import org.testng.annotations.Test;

import Testbase.BaseClass;

import Utilities.DataProviders;
import jdk.internal.org.jline.utils.Log;
import pageobject.Login;

public class TC_002Login extends BaseClass{

@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups={"Regression"})

public void loginmethod(String email,String pwd)
{
	//Log.info("Starting the login method");
	Login ff = new Login(driver);
	//Log.info("Enterning the details");
	ff.clklogin(email);
	ff.clkpass(pwd);
	ff.btnsubmit();
	
          

}
}