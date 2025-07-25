package com.demo1.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComposeMail {
	public ComposeMail(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="parent_type")
	private WebElement dropdown;
	
	@FindBy(id="parent_name")
	private WebElement title;
	
	@FindBy(id="subject")
	private WebElement subject;
	
	@FindBy(xpath="(//select[@name='parent_type']/..//img)[1]")
	private WebElement plusicon;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	

	public WebElement getPlusicon() {
		return plusicon;
	}

	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getSubject() {
		return subject;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
}
