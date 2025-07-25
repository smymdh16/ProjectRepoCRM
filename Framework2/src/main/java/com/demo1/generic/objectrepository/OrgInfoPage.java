package com.demo1.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage {

	public OrgInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[contains(@class,'dvHeaderText')]")
	private WebElement orgHeader;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement orgTxtF;
	
	@FindBy(id="mouseArea_Industry")
	private WebElement industryF;
	
	@FindBy(id="mouseArea_Type")
	private WebElement typeF;
	
	@FindBy(id="dtlview_Phone")
	private WebElement phoneTxt;
	
	
	
	
	public WebElement getPhoneTxt() {
		return phoneTxt;
	}

	public WebElement getIndustryF() {
		return industryF;
	}

	public WebElement getTypeF() {
		return typeF;
	}


	

	public WebElement getOrgHeader() {
		return orgHeader;
	}

	public WebElement getOrgTxtF() {
		return orgTxtF;
	}
}
