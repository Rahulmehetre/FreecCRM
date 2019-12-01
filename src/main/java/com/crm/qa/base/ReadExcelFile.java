package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static void main(String[] args){
		
		try{
			
			// Specify the path of file
			File src = new File("G:/Madhuri_Workspace/FreeCRMTest/src/main/java/com/crm/qa/config/ReadExcel.xlsx");
			
			//Load file
			FileInputStream fis = new FileInputStream(src);
			
			//Load WorkBook
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			// Load sheet- Here we are loading first sheetonly
			XSSFSheet sh1= wb.getSheetAt(0);
			
			/*getRow() specify which row we want to read.
			and getCell() specify which column to read.
	 		getStringCellValue() specify that we are reading String data.*/
			
			System.out.println(sh1.getRow(0).getCell(0).getStringCellValue());
			System.out.println(sh1.getRow(0).getCell(1).getStringCellValue());
			System.out.println(sh1.getRow(1).getCell(0).getStringCellValue());
			System.out.println(sh1.getRow(1).getCell(1).getStringCellValue());
			System.out.println(sh1.getRow(2).getCell(0).getStringCellValue());
			System.out.println(sh1.getRow(2).getCell(1).getStringCellValue());
			
			
			/*sh1.getRow(0).createCell(2).setCellValue("ROck");
			sh1.getRow(1).createCell(2).setCellValue("Test");
			sh1.getRow(2).createCell(2).setCellValue("Test");
			 
			// here we need to specify where you want to save file
			 
			 FileOutputStream fout = new FileOutputStream(new File("G:/Madhuri_Workspace/FreeCRMTest/src/main/"
			 		+ "java/com/crm/qa/config/ReadExcel.xlsx"));
			 
			 // finally write content 
			 
			 wb.write(fout);
			 
			// close the file
			 
			 fout.close();*/
			
			
			}catch(Exception e){
				System.out.println(e.getMessage());
		}
	}
	
}
