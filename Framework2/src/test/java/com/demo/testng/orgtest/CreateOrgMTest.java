package com.demo.testng.orgtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.demo1.generic.base.BaseClass;
import com.demo1.generic.objectrepository.CreateOrgPage;
import com.demo1.generic.objectrepository.HomePage;
import com.demo1.generic.objectrepository.OrgInfoPage;
import com.demo1.generic.objectrepository.OrganizationPage;

import junit.framework.Assert;
@Listeners(com.demo1.generic.listenerutility.ListenerImplClass1.class)
public class CreateOrgMTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createOrgTest() throws EncryptedDocumentException, IOException {

		String orgname = e.toGetDataFromExcelFile("Org", 1, 2) + j.getRandomNumber();
		HomePage h = new HomePage(driver);
		h.getOrglink().click();

		OrganizationPage o = new OrganizationPage(driver);
		o.getCreateOrg().click();

		CreateOrgPage cop = new CreateOrgPage(driver);
		cop.getOrgTxtB().sendKeys(orgname);

		cop.getSaveBtn().click();

		OrgInfoPage oi = new OrgInfoPage(driver);

		String actualH = oi.getOrgHeader().getText();
		/*
		 * if (actualH.contains(orgname)) { System.out.println(orgname +
		 * " Organization is created successfull " + " PASS"); } else {
		 * System.out.println(orgname + " Organization is not created successfull " +
		 * " FAIL"); }
		 */

		boolean status=actualH.contains(orgname);
		Assert.assertEquals(status, true);
		Reporter.log("Organization created successfully",true);
		
		 String actualR=oi.getOrgTxtF().getText();
		 
		 
		/* if (actualR.contains(orgname)) {
		  System.out.println(orgname + " Organization field is verified " + " PASS"); }
		  else { System.out.println(orgname + " Organization field is not verified " +
		  " FAIL"); }
		 */
		
		SoftAssert sft=new SoftAssert();
		boolean status1=actualR.contains(orgname);
		sft.assertEquals(status1,true);
		sft.assertAll();
		Reporter.log("Organization textfield verified");
	}

	@Test(groups = "regressionTest")
	public void createOrgWithIndustry() throws EncryptedDocumentException, IOException {
		String orgname = e.toGetDataFromExcelFile("Org", 4, 2) + j.getRandomNumber();
		String industry = e.toGetDataFromExcelFile("Org", 4, 3);
		String type = e.toGetDataFromExcelFile("Org", 4, 4);

		HomePage h = new HomePage(driver);
		h.getOrglink().click();

		OrganizationPage o = new OrganizationPage(driver);
		o.getCreateOrg().click();

		CreateOrgPage cop = new CreateOrgPage(driver);
		cop.getOrgTxtB().sendKeys(orgname);
		w.selectByVisibleText(cop.getIndustryDD(), industry);

		w.selectByVisibleText(cop.getTypeDD(), type);

		cop.getSaveBtn().click();

		OrgInfoPage oi = new OrgInfoPage(driver);

		String actualH = oi.getOrgHeader().getText();
		
		boolean status=actualH.contains(orgname);
		Assert.assertEquals(status, true);
		Reporter.log("Organization created successfully",true);
		
		/*
		 * if (actualH.contains(orgname)) { System.out.println(orgname +
		 * " is successfull " + " PASS"); } else { System.out.println(orgname +
		 * " is not successfull " + " FAIL"); }
		 */

		// verify the industry
		String actualorgT = oi.getOrgTxtF().getText();
		boolean status1=actualorgT.contains(orgname);
		
		Assert.assertEquals(status1,true);

		/*
		 * if (actualorgT.contains(orgname)) { System.out.println(orgname +
		 * " is successfull " + " PASS"); } else { System.out.println(orgname +
		 * " is not successfull " + " FAIL"); }
		 */
		String actualI = oi.getIndustryF().getText();
		
		SoftAssert sft=new SoftAssert();
		sft.assertEquals(actualI,industry,"Industry Dropdown verified");
		sft.assertAll();
		/*
		 * if (actualI.contains(industry)) { System.out.println(industry +
		 * "  is verified " + " PASS"); } else { System.out.println(industry +
		 * " is not verified " + " FAIL"); }
		 */

		// verify industry type

		
		
		String actualT = oi.getTypeF().getText();
		
		sft.assertEquals(actualT,type,"Type Dropdown verified ");
		sft.assertAll();
		
		/*
		 * if (actualT.contains(type)) { System.out.println(type + "  is verified " +
		 * " PASS"); } else { System.out.println(type + " is not verified " + " FAIL");
		 * }
		 */

	}

	@Test(groups = "smokeTest")
	public void CreateOrgWithPhoneNo() throws EncryptedDocumentException, IOException {// To read data from excel file
		String orgname = e.toGetDataFromExcelFile("Org", 7, 2) + j.getRandomNumber();

		String phoneNo = e.toGetDataFromExcelFile("Org", 7, 3);
		HomePage h = new HomePage(driver);
		h.getOrglink().click();

		OrganizationPage o = new OrganizationPage(driver);
		o.getCreateOrg().click();

		CreateOrgPage co = new CreateOrgPage(driver);
		co.getOrgTxtB().sendKeys(orgname);
		co.getPhoneNo().sendKeys(phoneNo);
		co.getSaveBtn().click();

		OrgInfoPage oi = new OrgInfoPage(driver);
		String actualH = oi.getOrgHeader().getText();
		boolean status=actualH.contains(orgname);
		Assert.assertEquals(status, true);
		Reporter.log("Organization created successfully",true);
		// Verification---------------------------------------------------
		
		String actualP = oi.getPhoneTxt().getText(); 
		boolean status1=actualP.contains(phoneNo);
		Reporter.log("Phone no textfield verified");
		
		
		/*
		 * if (actualH.contains(orgname)) { System.out.println(orgname +
		 * " Organization is created successfull " + " PASS"); } else {
		 * System.out.println(orgname + " Organization is not created successfull " +
		 * " FAIL"); }
		 * 
		 * String actualP = oi.getPhoneTxt().getText(); if (actualP.contains(phoneNo)) {
		 * System.out.println(phoneNo + " Phone no is verified " + " PASS"); } else {
		 * System.out.println(phoneNo + " Phone no is not verified " + " FAIL"); }
		 */

	}

}
