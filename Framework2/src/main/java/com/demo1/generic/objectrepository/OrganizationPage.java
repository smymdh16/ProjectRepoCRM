package com.demo1.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	public OrganizationPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//img[contains(@src,'images/btnL3Add.gif')]")
	private WebElement createOrg;

	public WebElement getCreateOrg() {
		return createOrg;
	}
	
	
}
