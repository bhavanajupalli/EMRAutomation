package org.cyient.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DemoTest {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file = new FileInputStream("src\\test\\resources\\testData\\OpenEMRData.xlsx");
		XSSFWorkbook book= new XSSFWorkbook(file);
		XSSFSheet sheet= book.getSheet("validCredentialTest");
		
		int rowCount= sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);
		
		int cellCount= sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(cellCount);
		
		Object[][] main= new Object[rowCount-1][cellCount];
		DataFormatter format = new DataFormatter();
		
		for(int r=1;r<rowCount;r++)
		{
			for(int c=0;c<cellCount;c++)
			{
				XSSFRow row= sheet.getRow(r);
				XSSFCell cell= row.getCell(c);
		
				String cellvalue= format.formatCellValue(cell);
				System.out.println(cellvalue);
				
				main[r-1][c]= cellvalue;
				
			}
		}
		
	}

}
