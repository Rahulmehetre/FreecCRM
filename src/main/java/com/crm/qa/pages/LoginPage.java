package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory -OR:
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//span[contains(text(), 'Log In')]")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[@class='ui fluid large blue submit button']")
	WebElement loginOK;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	
	// inetialize the page objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle(){
		return driver.getTitle();
		
	}
	
		public void validateLoginbtnclick()
		{
			
			loginBtn.click();
			
		}
	public HomePage login(String un, String pwd)
	{
		
		loginBtn.click();
		email.sendKeys(un);
		password.sendKeys(pwd);
		loginOK.click();
		
		return new HomePage();
	}

}
