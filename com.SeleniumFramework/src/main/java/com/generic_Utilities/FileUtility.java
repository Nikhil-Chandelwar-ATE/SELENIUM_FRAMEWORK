package com.generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {

	public static String getDataFromPropertiesFile(String key) {

		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./src/main/resources/commondata/dws_commonData.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value = prop.getProperty(key);
		return value;
	}

	public static String getSingleDataFromExcelFile(String sheetName, int rowNum, int cellNum) {

		FileInputStream fis = null;
		Workbook book = null;
		try {
			fis = new FileInputStream("./src/test/resources/testScriptData/testScriptData.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String value = cell.toString();
		return value;
	}
}