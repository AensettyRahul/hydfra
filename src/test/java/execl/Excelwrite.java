package execl;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelwrite {
	
	public static void main(String[] args) throws IOException {
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\excel2.xlsx");
		
	XSSFWorkbook workbook = new XSSFWorkbook();
	XSSFSheet sheet = workbook.createSheet("Data");
	XSSFRow row1 = sheet.createRow(0);
	row1.createCell(0).setCellValue("Rahul");
	row1.createCell(1).setCellValue("23");
	row1.createCell(2).setCellValue("Accenture");
	
	XSSFRow row2 = sheet.createRow(1);
	row2.createCell(0).setCellValue("Vikas");
	row2.createCell(1).setCellValue("24");
	row2.createCell(2).setCellValue("omnicorn");
	
	workbook.write(file);
	workbook.close();
	file.close();
	
	System.out.println("File is created");
	
	
	
	
		
	}
	

}
