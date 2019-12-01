package com.crm.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;
	ContactsPage contactsPage;
	
	public HomePageTest()
	{
		super();
	}
	
	// test cases should be seperated - independent to each other
	// before each test case launch browser and login
	// each test cases close the browser
	//@Test - execute test case
	
	@BeforeMethod
	public void setup()
	{
		intialization();
		 contactsPage = new ContactsPage();
		 loginPage=new LoginPage();
		 homepage = loginPage.login(prop.getProperty("email"),prop.getProperty("password"));
	}
	
	
	@Test(priority = 1)
	public void verifyHomeTitletest()
	{
		String homepagetitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "Cogmento CRM");
	}
	
	@Test(priority = 2)
	public void varifyUserNameTest()
	{
		Assert.assertTrue(homepage.varifyUserName());
	}
	
	@Test(priority = 3)
	public void verifyContactslinkTest()
	{
		contactsPage = homepage.clickOnContactsLink();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
	@AfterMethod	
	public void teardown()
	{
		driver.quit();
	}
	
}
