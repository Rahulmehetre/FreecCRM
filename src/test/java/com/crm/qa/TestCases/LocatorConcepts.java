package com.crm.qa.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcepts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:/Chrome drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("rmehetre87@gmail.com");
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("rahul@2012");
		driver.findElement(By.linkText("Log in")).click();
		
		//css selector
		
		driver.findElement(By.cssSelector("#u_0_4")).sendKeys("Rahul");

	}

}
