package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){
		
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("G:/Madhuri_Workspace/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
	
 public static void intialization(){
	 
	 String browserName= prop.getProperty("browser");
	 if(browserName.equals("InternetExplorer"))
	 {
//		 System.setProperty("webdriver.ie.driver", "G:\\Madhuri_Workspace\\FreeCRMTest\\driver\\IEDriverServer.exe");
//		 driver=new InternetExplorerDriver();
		 System.setProperty("webdriver.ie.driver","G:\\Madhuri_Workspace\\FreeCRMTest\\driver\\IEDriverServer.exe");
		 driver = new InternetExplorerDriver();
		 
	 }else if(browserName.equals("FF"))
	 {
		 System.setProperty("webdriver.gecko.driver", "G:\\Madhuri_Workspace\\FreeCRMTest\\driver\\geckodriver.exe");
		 driver = new FirefoxDriver();
//		 System.setProperty("webdriver.chrome.driver", "G:\\Madhuri_Workspace\\FreeCRMTest\\driver\\IEDriverServer.exe");
//		 driver = new InternetExplorerDriver();
	 }
	 else if(browserName.equals("chrome"))
	 {
		 System.setProperty("webdriver.chrome.driver", "G:\\Madhuri_Workspace\\FreeCRMTest\\driver\\chromedriver1.exe");
		 driver = new ChromeDriver();
//		 System.setProperty("webdriver.chrome.driver", "G:\\Madhuri_Workspace\\FreeCRMTest\\driver\\IEDriverServer.exe");
//		 driver = new InternetExplorerDriver();
	 }
	 
	 
	 e_driver = new EventFiringWebDriver(driver);
	 eventListener  = new WebEventListener();
	 e_driver.register(eventListener);
	 driver = e_driver;
	 
	 
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	 driver.get(prop.getProperty("url"));
	
}
}
