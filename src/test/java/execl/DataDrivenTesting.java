package execl;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Utilities.ExcelUtility;

public class DataDrivenTesting {

	public static void main(String[] args) throws IOException, InterruptedException {

		
//driver command		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
//file path and reading data from execl		

		String filepath = System.getProperty("user.dir") + "\\testdata\\rahultestdata.xlsx";

		int rows = ExcelUtility.getRowcount(filepath, "Sheet1");

		for(int i=1;i<=rows;i++)
		{
			//read data from excel
			String Firstname = ExcelUtility.getcelldata(filepath, "Sheet1", i, 0);
			String Lastname = ExcelUtility.getcelldata(filepath, "Sheet1", i, 1);
			String email = ExcelUtility.getcelldata(filepath, "Sheet1", i, 2);
			String telephone = ExcelUtility.getcelldata(filepath, "Sheet1", i, 3);
			//pass above data to application

//application locators			
			driver.findElement(By.xpath("//span[contains(.,'My Account')]")).click();
			driver.findElement(By.xpath("//a[contains(.,'Register')]")).click();
			driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(Firstname);;
			driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(Lastname);
			driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
			driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(telephone);  
			Thread.sleep(3000);

			//validation
		}
		System.out.println("Success");
		driver.close();
	}

}


