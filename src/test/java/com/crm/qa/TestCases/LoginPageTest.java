package com.crm.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();
		
	}
	@BeforeMethod
	public void setup()
	{
		intialization();
		 loginPage=new LoginPage();
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest()
	{
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
		
	}
//	@Test(priority=2)
//	 public void validateLoginbtnclick()
//	 {
//		
//	 }
	
	 @Test(priority=2)
	 public void loginTest()
	 {
		homePage= loginPage.login(prop.getProperty("email"),prop.getProperty("password"));
	 }
	 
	 @AfterMethod
	 public void tearDown()
	 {
		 driver.quit();
	 }
}
