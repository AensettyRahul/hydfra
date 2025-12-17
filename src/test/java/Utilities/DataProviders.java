package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	
	@DataProvider(name ="LoginData")
	public String [][] getData() throws IOException
	{
		String path =System.getProperty("user.dir") + ".\\testdata\\Book1.xlsx"; //taking xlfile from testdata
		
		ExcelUtility xlutil = new ExcelUtility(path);
		
		int rowcount = xlutil.getRowcount("Sheet1");
	    int cellcount = xlutil.getCellcount("Sheet1",1);
		
//		int rowcount = ExcelUtility.getRowcount(path,"Sheet1");//creating an object for ExcelUtility
//		
//		int cellcount = ExcelUtility.getCellcount(path,"Sheet1" ,1);
//		
		String logindata[][] = new String[rowcount][cellcount]; //created fot two dimesnion array which can store
		
		for(int i=1;i<=rowcount;i++) //rea he data from xl storing in two dimensional array
		{
			for(int j=0;j<cellcount;j++) //0  i is a row j is col
			{
				logindata[i-1][j] = xlutil.getcelldata("Sheet1", i, j);
			}
		}
		
		
		
		return logindata; //returing the two dimension array
		
	}
	
	
	
}
