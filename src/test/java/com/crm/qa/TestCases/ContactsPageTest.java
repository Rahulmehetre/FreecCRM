package com.crm.qa.TestCases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	
	LoginPage loginPage;
	HomePage homepage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	String sheetName = "contacts";
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		intialization();
		testUtil = new TestUtil();
		 contactsPage = new ContactsPage();
		 loginPage=new LoginPage();
		 homepage = loginPage.login(prop.getProperty("email"),prop.getProperty("password"));
		 contactsPage = homepage.clickOnContactsLink();
	}
	
	@Test(priority = 1)
	public void verifyContactsPagelabel(){
		
		Assert.assertTrue(contactsPage.verifyContactsLabel());
		
	}
	
	@Test(priority = 2)
	public void selectContactsName(){
		
		contactsPage.selectContactsByname("Rahul M");
			
	}
	
	@Test(priority = 3)
	public void selectmultipleContactsName() throws InterruptedException{
		
		contactsPage.selectContactsByname("Naveen K");
		contactsPage.selectContactsByname("Rahul M");
		Thread.sleep(5000);
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
		
	}
		
	@Test(priority = 4, dataProvider = "getCRMTestData")
	public void ValidateCreateNewContacts(String fname, String lname, String dept) throws InterruptedException{
		
		homepage.clickonNewContactsButton();
		//contactsPage.CreatNewContact("Suresh", "Mehetre", "Google");
			contactsPage.CreatNewContact(fname, lname, dept);
			Thread.sleep(5000);
	}
	
	
	@AfterMethod	
	public void teardown()
	{
		driver.quit();
	}
	
	
}
