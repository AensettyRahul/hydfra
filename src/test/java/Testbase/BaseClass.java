package Testbase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.beust.jcommander.Parameters;


public class BaseClass {

	public static WebDriver driver;
//	public Logger logger;
	public Properties p;

	//@BeforeClass(groups = {"sanity"})
	@BeforeClass
//	@Parameters({"os","browser"})
	
	public void setup (String os,String br) throws  InterruptedException, IOException
	{

//config file 		
		FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\Config.properties");
		p = new Properties();
		p.load(file);

//logger		
//		logger = LogManager.getLogger(this.getClass());


//Selenium Grid	for remote machine	
		if(p.getProperty("execute_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();

			//os
			if(os.equalsIgnoreCase("winodws"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);

			}
			else
			{
				System.out.print("No matching os");
			}

			//browser
			switch(br.toLowerCase())
			{
			case "chrome" : capabilities.setBrowserName("Chrome"); break;
			case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No Matching Browser"); return;
			}
			
			
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


//Selenium grid for local machine		
		if(p.getProperty("execute_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
			case "chrome" : driver=new ChromeDriver(); break;
			case "edge" : driver=new EdgeDriver(); break;
			case "firefox" : driver=new FirefoxDriver(); break;
			default: System.out.println("No Matching Browser"); return;
			}
		}


//
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		Thread.sleep(3000);
	}

	@AfterClass(groups = {"sanity","Regression"})
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}


//	//Capture Screenshot in Extend report 
//	public String captureScreen(String tname) {
//		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//
//		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
//
//
//		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" +timeStamp + ".png";
//		File targetFile = new File(targetFilePath);
//
//		sourceFile.renameTo(targetFile);
//
//
//
//		return targetFilePath;
//	}

}
