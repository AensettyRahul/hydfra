package execl;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExeclRead {

	
	
	public static void main(String[] args) throws IOException
	{
		
		FileInputStream file = new FileInputStream("C:\\Users\\shrav\\eclipse-workspace\\hydfra\\testdata\\rahultestdata.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(file);
	     XSSFSheet sheet = workbook.getSheet("sheet1");
	     
	    int totalRows = sheet.getLastRowNum();	
	    int totalCells = sheet.getRow(0).getLastCellNum();
	    
	    System.out.println("Number of rows" + totalRows);
	    System.out.println("Number of cells" + totalCells);
	   
	    System.out.println(sheet.getPhysicalNumberOfRows());
	
	for(int r=0;r<=totalRows;r++)
	{
		XSSFRow currentrow = sheet.getRow(r);
		for(int c=0;c<totalCells;c++)
		{
			XSSFCell currentcell = currentrow.getCell(c);
			System.out.println(currentcell.toString() + "\t");
		}
				
	}
	workbook.close();
	file.close();
		
		
	
	
	}
}
