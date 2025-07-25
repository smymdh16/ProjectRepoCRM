package com.demo1.generic.base;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.demo1.generic.fileutility.ExcelUtility;
import com.demo1.generic.fileutility.FileUtility;
import com.demo1.generic.objectrepository.HomePage;
import com.demo1.generic.objectrepository.LoginPage;
import com.demo1.generic.webdriverUtility.JavaUtility;
import com.demo1.generic.webdriverUtility.WebDriverUtility;




public class BaseClass {

	public WebDriver driver = null;
	
	public FileUtility f=new FileUtility();
	public ExcelUtility e=new ExcelUtility();
	public JavaUtility j=new JavaUtility();
	public WebDriverUtility w=new WebDriverUtility();
	public static WebDriver Sdriver=null;
	
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void configBeforeSuite()
	{
		System.out.println("===connect to database ,Configure report======");
	}
	
	//@Parameters("browser")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void configureBeforeClass(/*String browser*/) throws IOException
	{
		System.out.println("=====Launch the Browser==========");
		String BROWSER =f.toReadDataFromPropertyFile("browser");
		String URL =f.toReadDataFromPropertyFile("url");
		System.out.println(BROWSER);
		if (BROWSER.equals("chrome")){
			
			driver = new ChromeDriver();	
		}
		else if (BROWSER.equals("firefox")) {
			
			driver=new FirefoxDriver();
			
		}
		else 
		{
			driver=new EdgeDriver();
			
		}
		Sdriver=driver;
		driver.get(URL);
		w.toMaximize(driver);
		w.toWaitImplicitly(driver);
	}
	
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void configureBeforeMethod() throws IOException
	{	System.out.println("Login to Application");
		//String URL =f.toReadDataFromPropertyFile("url");
		String USERNAME = System.getProperty("username", f.toReadDataFromPropertyFile("username"));
		String PASSWORD = System.getProperty("password",f.toReadDataFromPropertyFile("password"));
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME,PASSWORD);
	}
	
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configureAfterMethod()
	{	
		HomePage h=new HomePage(driver);
		h.logoutFromApp();
		System.out.println("Logged out successfully");
		
	}
	
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configureAfterClass()
	{
		System.out.println("Browser closed successfully");
		driver.quit();
	}
	
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void configureAfterSUite()
	{
		System.out.println("Database connection closed ");
		
	}
	
}
