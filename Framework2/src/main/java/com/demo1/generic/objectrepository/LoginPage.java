package com.demo1.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//Rule 1:Create a separate java class
	
	//Rule 2: Object Creation
	WebDriver driver;//this is how we can get driver object within business method
	public LoginPage(WebDriver driver)
	{	this.driver=driver;
		PageFactory.initElements(driver,this);//this keyword refers to cuurent class object
	}
	
	
	@FindBy(name="user_name")
	private WebElement usernameTxt;
	
	@FindBy(name="user_password")
	private WebElement passwordTxt;
	
	@FindBy(xpath="//input[@id='submitButton']")
	private WebElement loginButton;

	public WebElement getUsername() {
		return usernameTxt;
	}

	public WebElement getPassword() {
		return passwordTxt;
	}

	public WebElement getLoginB() {
		return loginButton;
	}

	
	
	//Rule 3:Object initialization
	
	//Rule 4:Object Encapsulation generating getters method
	
	//Step 5:Provide Action
	//This is Business Method
	public void loginToApp(String username,String password)
	{   //We can do with the global variable driver.manage().window().maximize();
		
		usernameTxt.sendKeys(username);
		passwordTxt.sendKeys(password);
		loginButton.click();
		
	}
	
	
	
	
	
}
