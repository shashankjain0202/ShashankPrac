package com.prac.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class excelUtils {
	
	
	public static Object[][] readTestData(String className, String testName) throws IOException {
		Logger _log = Logger.getLogger(excelUtils.class);
		String rootPath = "src\\test\\resources\\com\\prac\\testdata";
		File file =    new File(rootPath+"\\"+className+".xlsx");
		_log.info("Opened test data file: "+rootPath+"\\"+className+".xlsx");
		Map<String, String> testDataMap;
		int matchedTestCases = 0;
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		int counter = 0;
		
		Sheet sheet = workbook.getSheet("Sheet1");
		
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		_log.info("Started reading data from sheet: Sheet1");
		for (int row=1; row<=rowCount; row++) {
	    	Row eachRow = sheet.getRow(row);
	    	String testCaseName = eachRow.getCell(0).getStringCellValue();
	    	if (testCaseName.equalsIgnoreCase(testName)) {
	    		matchedTestCases++;
	    	}
	    	
	    }
		
		_log.info("Number of matched test cases in test data sheet: "+matchedTestCases);
		
		Object [][] result = new Object[matchedTestCases][1];
		
		for (int row=1; row<=rowCount; row++) {
			Row eachRow = sheet.getRow(row);
			String testCaseName = eachRow.getCell(0).getStringCellValue();
			if (testCaseName.equalsIgnoreCase(testName)) {
				counter++;
				testDataMap = new HashMap<>();
				for (int col=1; col<sheet.getRow(0).getLastCellNum();col++) {
					try {
						testDataMap.put(sheet.getRow(0).getCell(col).getStringCellValue(), eachRow.getCell(col).getStringCellValue());
					}
					catch (Exception e) {
						testDataMap.put(sheet.getRow(0).getCell(col).getStringCellValue(), "");
					}
				}
				
				result[counter-1][0] = testDataMap;
				_log.info("testData:"+"/n"+ testDataMap);
				testDataMap = null;
			
			}
		}
		
		inputStream.close();
	
	 return result;
	}

}
