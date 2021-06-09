package org.cyient.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderUtilies {

	@DataProvider
	public Object[][] validCredentialData() throws IOException
	{
		Object[][] main= new Object[3][4];
		FileInputStream file = new FileInputStream("src\\test\\resources\\testData\\OpenEMRData.xlsx");
		XSSFWorkbook book= new XSSFWorkbook(file);
		XSSFSheet sheet= book.getSheet("validCredentialTest");
		
		for(int r=1;r<3;r++)
		{
			for(int c=0;c<4;c++)
			{
				XSSFRow row= sheet.getRow(r);
				XSSFCell cell= row.getCell(c);

				DataFormatter format = new DataFormatter();
				main[r-1][c]=format.formatCellValue(cell);
				System.out.println(main[r][c]);
			}
		}
	
		return main;		
	}
	
	
	@DataProvider
	public Object[][] invalidCredentialData() throws IOException
	{
		
		FileInputStream file = new FileInputStream("src/test/resources/testData/OpenEMRData.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet= book.getSheet("invalidCredentialTest");
		Object[][] main= new Object[3][4];
			
		for(int r=1;r<3;r++)
		{
			for(int c=0;c<4;c++)
			{
				XSSFRow row= sheet.getRow(r);
				XSSFCell cell= row.getCell(c);

				DataFormatter format = new DataFormatter();
				main[r-1][c]=format.formatCellValue(cell);
				System.out.println(main[r][c]);
			}
		}
				
		return main;
		
	}
	
	@DataProvider
	public Object[][] validCredentialExcelData() throws IOException
	{
		Object[][] main= ExcelUtilities.getSheetIntoObjectArray("src/test/resources/testData/OpenEMRData.xlsx","validCredentialTest");
		return main;
	
	}
	
	
	
	
	
}














