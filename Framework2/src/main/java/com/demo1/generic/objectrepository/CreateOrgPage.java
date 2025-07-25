package com.demo1.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgPage {
	
	public CreateOrgPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(name="accountname")
	private WebElement orgTxtB;
	
	@FindBy(name="industry")
	private WebElement industryDD;
	
	@FindBy(name="accounttype")
	private WebElement typeDD;
	
	@FindBy(id="phone")
	private WebElement phoneNo;
	
	@FindBy(id="email1")
	private WebElement email;
	
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	

	
	public WebElement getOrgTxtB() {
		return orgTxtB;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getTypeDD() {
		return typeDD;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getPhoneNo() {
		return phoneNo;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	
}

