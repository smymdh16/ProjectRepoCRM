package com.demo1.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgListPage {

	public OrgListPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="search_txt")
	private WebElement searchtxt;
	
	@FindBy(name="search")
	private WebElement searchB;

	public WebElement getSearchtxt() {
		return searchtxt;
	}

	public WebElement getSearchB() {
		return searchB;
	}
	
	

}
