package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class PDFValidation  {
	
	public static void validate() throws IOException  {
	
	File file=new File("C://Users//l//Desktop//340077_Proof_of_Residence .PDF");
	FileInputStream fis=new FileInputStream(file);
	PDFParser parser=new PDFParser(fis);
	parser.parse();
	COSDocument cosDoc =parser.getDocument();
	PDDocument pdDoc=new PDDocument(cosDoc);
	PDFTextStripper strip=new PDFTextStripper();
	String data=strip.getText(pdDoc);
	System.out.println(data);
	System.out.println("Madhuri"+strip.getPageSeparator());
	for(int i=1;i<=pdDoc.getNumberOfPages();i++)
	{
		System.out.println("Number Of Pages"+pdDoc.getNumberOfPages());
		
	}
	}
	

}
