package Testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class baseclass1 {

	public  WebDriver driver;
	
	@BeforeClass 
	
	public void setup() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
	}
	
	@AfterClass()
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}


	
}
