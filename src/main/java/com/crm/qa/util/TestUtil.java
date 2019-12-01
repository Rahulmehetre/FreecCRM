package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestUtil {
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=20;
	
	public static String TESTDATA_SHEET_PATH = "G:/Madhuri_Workspace/FreeCRMTest/src/main/java/cpm"
			+ "/crm/qa/testdata/FreeCRMTestData.xlsx";
	
	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	private static TakesScreenshot driver;
	
	
	public static Object[][] getTestData(String sheetName){
		
		FileInputStream file = null;
		
		try{
			
			file = new FileInputStream(TESTDATA_SHEET_PATH);
						
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		try{
			
			book = WorkbookFactory.create(file);
			
		}catch(InvalidFormatException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum(); i++)
		{
			for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++)
			{
				
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
			
		}
		
		return data;	
		
	}
	

	public static void takeScreenshotAtEndOfTest() throws IOException{
		
		//TakesScreenshot driver = null;
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() +".png" ));
		
			
	}
	
		
	
}