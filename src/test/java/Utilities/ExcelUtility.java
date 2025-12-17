package Utilities;

import java.io.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtility {
	
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wk;
	public static XSSFSheet sh;
	public static XSSFRow ro;
	public static XSSFCell c;
	public static CellStyle cs;
	static String path;
	
	public ExcelUtility(String path)
	{
		this.path=path;
	}
	
	
	public static int getRowcount(String xsheet) throws IOException
	{
		fi=new FileInputStream(path);
		wk=new XSSFWorkbook(fi);
		sh=wk.getSheet(xsheet);	
		int rowcount = sh.getLastRowNum();
		wk.close();
		fi.close();
		return rowcount;
	}
	
	public static int getCellcount( String xlsheet , int rownum ) throws IOException
	{
	  fi = new FileInputStream(path);
	  wk = new XSSFWorkbook(fi);
	  sh= wk.getSheet(xlsheet);
	  ro = sh.getRow(rownum);
	  int cellcount = ro.getLastCellNum();	 
	  wk.close();
	  fi.close();
	  return cellcount;
	  
	  
	  
	}
	
	public static String getcelldata(String xlsheet,int rownum,int colnum) throws IOException
	{
		fi = new FileInputStream(path);
		wk = new XSSFWorkbook(fi);
		sh = wk.getSheet(xlsheet);
		ro = sh.getRow(rownum);
		c= ro.getCell(colnum);
		
		 String data;
		try {
			data=c.toString();
		}
		catch(Exception e)
		{
			data="";
		}
		wk.close();
		fi.close();
		return data;
	}
	
	
	public static void setCelldata(String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi = new FileInputStream(path);
		wk=new XSSFWorkbook(fi);
		sh = wk.getSheet(xlsheet);
		ro = sh.getRow(rownum);
		
		c= ro.createCell(colnum);
		c.setCellValue(data);
		fo = new FileOutputStream(path);
		wk.write(fo);
		wk.close();
		fi.close();
		fo.close();
		
		
	}
	
	
	

}
