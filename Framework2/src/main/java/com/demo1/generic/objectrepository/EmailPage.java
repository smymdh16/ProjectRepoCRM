package com.demo1.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPage {
	public EmailPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//a[text()='Compose']")
	private WebElement composelink;

	@FindBy(xpath="//a[text()='All Mails']")
	private WebElement allmailink;
	
	@FindBy(name="search_text")
	private WebElement searchtext;
	
	@FindBy(name="find")
	private WebElement findB;
	
	@FindBy(name="selected_id")
	private WebElement checkbox;
	
	@FindBy(name="Button2")
	private WebElement delete;
	
	public WebElement getDelete() {
		return delete;
	}

	public WebElement getCheckbox() {
		return checkbox;
	}

	public WebElement getComposelink() {
		return composelink;
	}
	
	public WebElement getAllmailink() {
		return allmailink;
	}

	public WebElement getSearchtext() {
		return searchtext;
	}

	public WebElement getFindB() {
		return findB;
	}
}
