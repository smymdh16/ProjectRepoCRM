package com.demo1.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {

	public ProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="dtlview_Product Name")
	private WebElement productname;
	
	@FindBy(id="dtlview_Product Category")
	private WebElement productCategoryF;
	
	@FindBy(xpath="//span[contains(@class,'lvtHeaderText')]")
	private WebElement productHeader;
	
	@FindBy(xpath="//a[text()='Create Sales Order']")
	private WebElement createsaleslink;
	
	public WebElement getCreatesaleslink() {
		return createsaleslink;
	}

	public WebElement getProductHeader() {
		return productHeader;
	}

	public WebElement getProductname() {
		return productname;
	}

	public WebElement getProductCategoryF() {
		return productCategoryF;
	}
	
	
}
