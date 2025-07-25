package com.demo1.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="productname")
	private WebElement productFB;
	
	@FindBy(name="productcategory")
	private WebElement ProductCat;

	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;

	@FindBy(id="unit_price")
	private WebElement price;
	
	@FindBy(id="my_file_element")
	private WebElement file;
	
	@FindBy(xpath="//img[@title='Export Products']")
	private WebElement exportlink;
	
	@FindBy(name="search_text")
	private WebElement searchtxt;
	
	@FindBy(name="search_field")
	private WebElement searchBy;
	
	
	@FindBy(xpath="(//input[@value=' Search Now '])[1]")
	private WebElement searchB;
	
	@FindBy(name="Export")
	private WebElement exportb;
	
	@FindBy(xpath="//input[@value='currentpage']")
	private WebElement radioexportdata;
	
	public WebElement getSearchtxt() {
		return searchtxt;
	}

	public WebElement getSearchBy() {
		return searchBy;
	}

	public WebElement getSearchB() {
		return searchB;
	}
	public WebElement getRadioexportdata() {
		return radioexportdata;
	}

	public WebElement getExportb() {
		return exportb;
	}

	public WebElement getExportlink() {
		return exportlink;
	}

	public WebElement getFile() {
		return file;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getProductCat() {
		return ProductCat;
	}

	public WebElement getProductFB() {
		return productFB;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	
}
