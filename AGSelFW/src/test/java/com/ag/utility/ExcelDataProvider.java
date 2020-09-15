package com.ag.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	
	public ExcelDataProvider() {
		
		File src = new File("./TestData/testData.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook (fis);
		} catch (Exception e) {
			System.out.println("Unable to read excel file "+e.getMessage());
		}
	}
	

	public String getStringData(String sheetName, int row, int col) {
		
		return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
		
	}
	
	// This method is overloaded - String type SheetName is replaced by int type SheetIndex
	public String getStringData(int sheetIndex, int row, int col) {
		
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
		
	}
	
	public double getNumericData(String sheetName, int row, int col) {
		
		return wb.getSheet("login").getRow(row).getCell(col).getNumericCellValue();
		
	}
	
}
