package com.demo1.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	public CreateContactPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="lastname")
	private WebElement lastnameTxtB;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement orgcreateB;

	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	@FindBy(name="support_start_date")
	private WebElement startdate;
	
	@FindBy(name="support_end_date")
	private WebElement enddate;
	
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getLastnameTxtB() {
		return lastnameTxtB;
	}
	
	public WebElement getOrgcreateB() {
		return orgcreateB;
	}
	
	public WebElement getStartdate() {
		return startdate;
	}

	public WebElement getEnddate() {
		return enddate;
	}
	
}
