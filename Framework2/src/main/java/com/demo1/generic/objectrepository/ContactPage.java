package com.demo1.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	
	public ContactPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//img[contains(@title,'Create Contact...')]")
	private WebElement createContactlink;

	public WebElement getCreateContactlink() {
		return createContactlink;
	}
	
	
}
