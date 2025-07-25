package com.demo.testng.producttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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
public class CreateProductTest extends BaseClass{

	@Test(groups="regressionTest")
	public void createProductAndExportTest() throws EncryptedDocumentException, IOException
	{	String productname = e.toGetDataFromExcelFile("Products", 4, 2)+j.getRandomNumber();
	String productcategory = e.toGetDataFromExcelFile("Products", 4, 3);
	String price=e.toGetDataFromExcelFile("Products",4, 4);
	HomePage h = new HomePage(driver);
	h.getProductlink().click();

	ProductPage p = new ProductPage(driver);
	p.getCreateproductlink().click();

	CreateProductPage cpp = new CreateProductPage(driver);
	cpp.getProductFB().sendKeys(productname);
	w.selectByVisibleText(cpp.getProductCat(), productcategory);
	
	cpp.getPrice().sendKeys(price);
	

	cpp.getSaveBtn().click();
	
	ProductInfoPage pif = new ProductInfoPage(driver);
	
	String actualH = pif.getProductHeader().getText();

	String actualP = pif.getProductname().getText();

	String actualPC = pif.getProductCategoryF().getText();
	
	boolean status=actualH.contains(productname);
	Assert.assertEquals(status,true);
	Reporter.log("Product created successfully");
	
	boolean status1=actualP.contains(productname);
	Assert.assertEquals(status1,true);
	Reporter.log("Product textfield verified successfully");
	
	
	
	boolean status2=actualPC.contains(productcategory);
	Assert.assertEquals(status2,true);
	Reporter.log("Product category verified successfully");
	/*
	 * if (actualH.contains(productname)) { System.out.println(productname +
	 * " product header information verified successfully"); } else {
	 * System.out.println(productname +
	 * " product header information not verified successfully"); }
	 * 
	 * if (actualP.contains(productname)) { System.out.println(productname +
	 * " product created successfully"); } else {
	 * 
	 * System.out.println(productname + " product not created successfully"); }
	 * 
	 * if (actualPC.contains(productcategory)) { System.out.println(productcategory
	 * + " category verified successfully"); } else {
	 * System.out.println(productcategory + " category not verified successfully");
	 * }
	 */
	
	
	
	h.getProductlink().click();
	w.selectByIndex(cpp.getSearchBy(),1);
	
	cpp.getSearchtxt().sendKeys(productname);
	cpp.getSearchB().click();
	cpp.getExportlink().click();
	cpp.getRadioexportdata().click();
	
	cpp.getExportb().click();
	
	}

	

}
