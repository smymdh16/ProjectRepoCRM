package com.demo.testng.producttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demo1.generic.base.BaseClass;
import com.demo1.generic.objectrepository.CreateProductPage;
import com.demo1.generic.objectrepository.HomePage;
import com.demo1.generic.objectrepository.ProductInfoPage;
import com.demo1.generic.objectrepository.ProductPage;

import junit.framework.Assert;
@Listeners(com.demo1.generic.listenerutility.ListenerImplClass1.class)
public class CreateProduct2Test extends BaseClass{
	@Test(groups="smokeTest")
	public void createProductAndSearchTest() throws EncryptedDocumentException, IOException
	{
		String productname = e.toGetDataFromExcelFile("Products", 1, 2)+j.getRandomNumber();
		String dropdown1 =e.toGetDataFromExcelFile("Products", 1,3);
		HomePage h=new HomePage(driver);
		h.getProductlink().click();
		
		ProductPage p=new ProductPage(driver);
		p.getCreateproductlink().click();
		
		CreateProductPage cpp=new CreateProductPage(driver);
		cpp.getProductFB().sendKeys(productname);
		cpp.getSaveBtn().click();
		
		ProductInfoPage pif = new ProductInfoPage(driver);
		String actualH = pif.getProductHeader().getText();

		String actualP = pif.getProductname().getText();
		
		
		boolean status=actualH.contains(productname);
		Assert.assertEquals(status,true);
		Reporter.log("Product created successfully");
		
		boolean status1=actualP.contains(productname);
		Assert.assertEquals(status1,true);
		Reporter.log("Product textfield verified successfully");
		
		/*
		 * if (actualH.contains(productname)) { System.out.println(productname +
		 * " product header information verified successfully"); } else {
		 * System.out.println(productname +
		 * " product header information not verified successfully"); }
		 * 
		 * if (actualP.contains(productname)) { System.out.println(productname +
		 * " product created successfully"); } else { System.out.println(productname +
		 * " product not created successfully"); }
		 */
		
		h.getProductlink().click();
		p.getSearchtext().sendKeys(productname);
		w.selectByVisibleText(p.getSearchdrop(), dropdown1);
		//w.selectByIndex(p.getSearchdrop(), 1);
		p.getSearchb().click();
		
		String prod=driver.findElement(By.xpath("//a[@title='Products'and text()='"+productname+"']")).getText();
				
			//driver.findElement(By.xpath("//a[text()='" +productname+ "']")).getText();
		
		boolean status2=prod.contains(productname);
		Assert.assertEquals(status2,true);
		Reporter.log("Product added successfully");
		/*
		 * 
		 * if(prod.contains(productname)) {
		 * System.out.println(productname+"product is added successfully"); } else
		 * {System.out.println(productname+" product is not added");
		 * 
		 * }
		 * 
		 */
		
	}
}
