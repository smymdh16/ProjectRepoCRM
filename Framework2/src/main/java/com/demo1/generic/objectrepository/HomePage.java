package com.demo1.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
		
	public HomePage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText="Organizations")
	private WebElement orglink;
	
	

	@FindBy(linkText="Contacts")
	private WebElement contactlink;
	
	@FindBy(xpath="//a[contains(text(),'Products')]")
	private WebElement productlink;
	
	@FindBy(xpath="(//a[text()='Documents'])[1]")
	private WebElement documentlink;
	
	public WebElement getDocumentlink() {
		return documentlink;
	}
	
	@FindBy(xpath="(//img[contains(@src,'themes/softed/ima')])[2]")
	private WebElement imageBtn;

	@FindBy(xpath="//a[text()='Email']")	
	private WebElement emaillink;
	
	public WebElement getEmaillink() {
		return emaillink;
	}

	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutBtn;
	
	
	public WebElement getProductlink() {
		return productlink;
	}

	
	public WebElement getOrglink() {
		return orglink;
	}

	
	public WebElement getContactlink() {
		return contactlink;
	}

	public WebElement getImageBtn() {
		return imageBtn;
	}


	public WebElement getSignoutBtn() {
		return signoutBtn;
	}
	
	
	
  public void logoutFromApp()
  {
	  imageBtn.click();
	  signoutBtn.click();
	   
  }

	
	
	
}
