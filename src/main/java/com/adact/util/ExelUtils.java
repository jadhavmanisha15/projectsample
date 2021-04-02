package com.adact.util;

import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExelUtils {
	 static XSSFWorkbook Workbook;
	private static XSSFSheet sheet;
	public static void main(String args[]) throws IOException
	{
		getRowCount();
		getCellData();
	}
public static void getRowCount() throws IOException
{
		
	String projectPath=System.getProperty("user.dir");
	XSSFWorkbook workbook=new XSSFWorkbook(projectPath+"/exel/data.xlsx");
	XSSFSheet sheet=workbook.getSheet("Sheet1");
	int rowCount=sheet.getPhysicalNumberOfRows();
	System.out.println("no of rows :"+rowCount);
}
	public static void getCellData() throws IOException
	{
		String projectPath=System.getProperty("user.dir");
		Workbook=new XSSFWorkbook(projectPath+"/exel/data.xlsx");
		sheet=Workbook.getSheet("Sheet1");
		String celldata=sheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println(celldata);
		
		
		
	}
}
