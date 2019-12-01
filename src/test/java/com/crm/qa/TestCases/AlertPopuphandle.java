package com.crm.qa.TestCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopuphandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:/Chrome drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("www.rediffmail.com");
		
		driver.findElement(By.name("proceed")).click();
		
		Thread.sleep(2000);		

		Alert alert = driver.switchTo().alert();
		
		System.out.println(alert.getText());
			
		String text = alert.getText();
		
		if(alert.equals("Please enter valid user name"))
		{
			System.out.println("Correct message");
			
		}
		else
		{
			System.out.println("incorrect message");
		}
		
		alert.accept(); // click on OK
		
		alert.dismiss(); // to close alert
		
		driver.quit();

	}

}
