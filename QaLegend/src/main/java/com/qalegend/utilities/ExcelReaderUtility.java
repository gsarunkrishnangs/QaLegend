package com.qalegend.utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.qalegend.constants.Constants;

public class ExcelReaderUtility {

	static FileInputStream file;
	static XSSFWorkbook excelworkbook;
	static XSSFSheet excelsheet;

	public static String getStringData(int a, int b, String sheet) {
		try {
			String path = Constants.HOME_DIRECTORY+Constants.TEST_DATA_EXCELPATH;
			file = new FileInputStream(path);
			excelworkbook = new XSSFWorkbook(file);
			excelsheet = excelworkbook.getSheet(sheet);
			Row r = excelsheet.getRow(a);
			Cell c = r.getCell(b);
			return c.getStringCellValue();
		} catch (Exception e) {
			throw new RuntimeException("TestData excel sheet not found");
		}

	}

	public static String getIntegerData(int a, int b, String sheet) {
		try {
			String path = Constants.HOME_DIRECTORY+Constants.TEST_DATA_EXCELPATH;
			file = new FileInputStream(path);
			excelworkbook = new XSSFWorkbook(file);
			excelsheet = excelworkbook.getSheet(sheet);
			Row r = excelsheet.getRow(a);
			Cell c = r.getCell(b);
			int x = (int) c.getNumericCellValue();
			return String.valueOf(x);
			
			//return (int) c.getNumericCellValue(); // converting double to integer

		} catch (Exception e) {
			throw new RuntimeException("TestData excel sheet not found");
		}
	}
	
}
