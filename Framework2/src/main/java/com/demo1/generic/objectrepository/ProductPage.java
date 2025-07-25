package com.demo1.generic.objectrepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createproductlink;
	
	@FindBy(name="search_text")
	private WebElement searchtext;
	
	@FindBy(name="search_field")
	private WebElement searchdrop;

	@FindBy(xpath="(//input[@value=' Search Now '])[1]")
	private WebElement searchb;
	
	public WebElement getSearchtext() {
		return searchtext;
	}

	public WebElement getSearchdrop() {
		return searchdrop;
	}

	public WebElement getSearchb() {
		return searchb;
	}

	public WebElement getCreateproductlink() {
		return createproductlink;
	}
	
	
	
	
}
