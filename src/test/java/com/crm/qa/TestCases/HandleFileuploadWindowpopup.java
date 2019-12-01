package com.crm.qa.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFileuploadWindowpopup {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:/Chrome drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://html.com/input-type-file/");
		
		driver.findElement(By.xpath("//*[@id='fileupload']")).sendKeys("C:/Users/l/Desktop/Resumes_Rahul/Cover Letter.txt");
		
	}

}
