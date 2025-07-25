package com.demo1.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactheader;
	
	@FindBy(id="mouseArea_Last Name")
	private WebElement lastnameTxtF;
	
	@FindBy(xpath="//td[@id='mouseArea_Organization Name']")
	private WebElement orgtextF;
	
	@FindBy(xpath="//span[contains(@id,'dtlview_Support Start Date')]")
	private WebElement startdateTxt;
	
	@FindBy(xpath="//span[contains(@id,'dtlview_Support End Date')]")
	private WebElement enddateTxt;
	
	@FindBy(xpath="//a[text()='Create Sales Order']")
	private WebElement salesorderlnk;
	
	public WebElement getSalesorderlnk() {
		return salesorderlnk;
	}

	public WebElement getEnddateTxt() {
		return enddateTxt;
	}

	public WebElement getStartdateTxt() {
		return startdateTxt;
	}

	public WebElement getOrgtextF() {
		return orgtextF;
	}

	public WebElement getContactheader() {
		return contactheader;
	}

	public WebElement getLastnameTxtF() {
		return lastnameTxtF;
	}
	
	
}
