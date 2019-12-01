package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath = "//div[contains(text(),'Contacts')]")
	WebElement ContactsLabel;
	
	@FindBy(name = "first_name")
	WebElement fistname;
	
	@FindBy(name = "last_name")
	WebElement lastname;
	
	@FindBy(name = "department")
	WebElement department;
	
	@FindBy(xpath = "//button[@class='ui linkedin button']//i[@class='save icon']")
	WebElement savebtn;
	
	
	// inetialize the page objects
		public ContactsPage(){
			PageFactory.initElements(driver, this);
		}
	 
	
		public boolean verifyContactsLabel()
		{
			return ContactsLabel.isDisplayed();
		}
		
		public void selectContactsByname(String name){
			
			driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]")).click();
						
		}
		
		public void CreatNewContact(String fname, String lname, String dept){
			
			fistname.sendKeys(fname);
			lastname.sendKeys(lname);
			department.sendKeys(dept);
			savebtn.click();
			
		}
		
	
	

}
