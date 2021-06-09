package org.cyient.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	
	
	public static Object[][] getSheetIntoObjectArray(String filePath,String sheetName) throws IOException
	{
		FileInputStream file = new FileInputStream(filePath);
		XSSFWorkbook book= new XSSFWorkbook(file);
		XSSFSheet sheet= book.getSheet(sheetName);
		
		int rowCount= sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);
		
		int cellCount= sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(cellCount);
		
		Object[][] main= new Object[rowCount-1][cellCount];
		
		for(int r=1;r<rowCount;r++)
		{
			for(int c=0;c<cellCount;c++)
			{
				XSSFRow row= sheet.getRow(r);
				XSSFCell cell= row.getCell(c);

				DataFormatter format = new DataFormatter();
				String cellvalue= format.formatCellValue(cell);
				System.out.println(cellvalue);
				
				main[r-1][c]= cellvalue;
				
			}
		}
		
		return main;
	}

}
