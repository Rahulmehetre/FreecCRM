package com.crm.qa.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class webDriverBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ff browser open  - Gekodriver - is the class in selenium - we have to create object of gekodriver
		// have to download .exe for gekodriver - fireflox driver class - have to create ff driver - have to import
		
		//System.setProperty("webdriver.gecko.driver", "Path");
		//WebDriver driver = new FirefoxDriver();  // implementing interface webdriver - available in selenium. firefox will launch
		
		//driver.get("www.google.com");
		
		System.setProperty("webdriver.chrome.driver", "C:/Chrome drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("www.google.com");
		
		String title = driver.getTitle();
		
		System.out.println(title);
		
		if(title.equals("google"))
		{
			System.out.println("correct title");
			
		}
		else
		{
		System.out.println("Incorrect title");	
			
		}
		System.out.println(driver.getCurrentUrl());
		
		//System.out.println(driver.getPageSource());
		
		driver.quit();
		
	}
		
}


