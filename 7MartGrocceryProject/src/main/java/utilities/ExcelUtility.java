package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constant;

public class ExcelUtility {
	static FileInputStream f; //to get details from file
	static XSSFWorkbook wb;   //to get details from workbook
	static XSSFSheet   sh;    //to get details from sheet
	
	public static String getStringData(int a,int b,String sheet) throws IOException
	{
		String filepath=Constant.TESTDATAFILE;
		f=new FileInputStream(filepath);
		wb=new XSSFWorkbook(f);
		sh=wb.getSheet(sheet); //method to get value from the sheet
		XSSFRow r=sh.getRow(a);//method to get value from the row
		XSSFCell c=r.getCell(b);//method to get value from the cell
		return c.getStringCellValue();
		
	}
	
	public static String getIntegerData(int a,int b, String sheet) throws IOException
	{
		String filepath=Constant.TESTDATAFILE;
		f=new FileInputStream(filepath);
		wb=new XSSFWorkbook(f);
		sh=wb.getSheet(sheet); //method to get value from the sheet
		XSSFRow r=sh.getRow(a);//method to get value from the row
		XSSFCell c=r.getCell(b);//method to get value from the cell
		int x=(int)c.getNumericCellValue();
		return String.valueOf(x);//valueOf() is used to convert any value to String
		
	}


}



