package com.adact.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel
{
	public static File file;
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static Object[][] obj;
	
	public static Object[][] readExcelSheet(String path) 
	{
		try
		{
			file=new File(path);
			fis=new FileInputStream(file);
			wb=new XSSFWorkbook(fis);
			XSSFSheet sheet=wb.getSheetAt(0);
			obj=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for (int i = 0; i < sheet.getLastRowNum(); i++) 
			{
				XSSFRow row=sheet.getRow(i);
				
				for (int j = 0; j < row.getLastCellNum(); j++)
				{
					XSSFCell cell=row.getCell(j);
					String cellData=(String)cell.getStringCellValue();
					System.out.println(cellData);
					obj[i][j]=cellData;
					System.out.println();
				}
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return obj;
	}
	
//	public static void main(String[] args) 
//	{
//		ReadExcel.readExcelSheet("C:\\Users\\Hp\\eclipse-workspace\\AdactinHotelApp\\src\\main\\java\\com\\adact\\testdata\\testData.xlsx");
//	}
}
