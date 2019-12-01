package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath= "//span[contains(text(),'Rahul Mehetre')]")
	@CacheLookup
	WebElement usernamelabel;
	
	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath = "//button[@class='ui linkedin button']//i[@class='edit icon']")
	WebElement AddNewContactButton;
	
	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath = "//span[contains(text(),'Tasks')]")
	WebElement taskslink;
	
	
	// Inetialization of page objects
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
		
	}
	public boolean varifyUserName()
	{
		return usernamelabel.isDisplayed();
		
	}
	
	public ContactsPage clickOnContactsLink()
	{
		contactslink.click();
		return new ContactsPage();
	}
	
	
	public void clickonNewContactsButton(){
		
		Actions action = new Actions(driver);
		
		action.moveToElement(contactslink).build().perform();
		
		AddNewContactButton.click();
		
				
	}
	
	
	public Dealspage clickOnDealssLink()
	{
		dealslink.click();
		return new Dealspage();
	} 
	public TaskPage clickOnTasksLink()
	{
		taskslink.click();
		return new TaskPage();
	} 
	
	
	
	
	
	
}
