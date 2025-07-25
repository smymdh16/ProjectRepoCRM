package com.demo.testng.emailtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.demo1.generic.base.BaseClass;
import com.demo1.generic.objectrepository.ComposeMail;
import com.demo1.generic.objectrepository.CreateOrgPage;
import com.demo1.generic.objectrepository.EmailPage;
import com.demo1.generic.objectrepository.HomePage;
import com.demo1.generic.objectrepository.OrgInfoPage;
import com.demo1.generic.objectrepository.OrgListPage;
import com.demo1.generic.objectrepository.OrganizationPage;

import junit.framework.Assert;
@Listeners(com.demo1.generic.listenerutility.ListenerImplClass1.class)
public class CreateEmailMTest extends BaseClass {

	@Test(groups = "regressionTest")
	public void createEmailTest() throws EncryptedDocumentException, IOException {
		// To read data from excel file

		String Orgname = e.toGetDataFromExcelFile("Org", 1, 2) + j.getRandomNumber();
		System.out.println(Orgname);

		String emailorg = e.toGetDataFromExcelFile("Org", 4, 5);
		// String title=e.toGetDataFromExcelFile("Email", 1, 2);
		String dropdown1 = e.toGetDataFromExcelFile("Email", 1, 2);
		String To = e.toGetDataFromExcelFile("Email", 1, 3);
		String subject = e.toGetDataFromExcelFile("Email", 1, 4);
		HomePage h = new HomePage(driver);
		h.getOrglink().click();

		OrganizationPage o = new OrganizationPage(driver);
		o.getCreateOrg().click();

		CreateOrgPage cop = new CreateOrgPage(driver);
		cop.getOrgTxtB().sendKeys(Orgname);
		cop.getEmail().sendKeys(emailorg);
		cop.getSaveBtn().click();

		OrgInfoPage oi = new OrgInfoPage(driver);
		String actualH = oi.getOrgHeader().getText();
		boolean status=actualH.contains(Orgname);
		Assert.assertEquals(status, true);
		Reporter.log("Organization created successfully",true);
		
		String actualR = oi.getOrgTxtF().getText();
		SoftAssert sft=new SoftAssert();
		boolean status1=actualR.contains(Orgname);
		sft.assertEquals(status1,true);
		sft.assertAll();
		/*
		 * String actualH = oi.getOrgHeader().getText(); if (actualH.contains(Orgname))
		 * { System.out.println(Orgname + " Organization is created successfull " +
		 * " PASS"); } else { System.out.println(Orgname +
		 * " Organization is not created successfull " + " FAIL"); }
		 * 
		 * String actualR = oi.getOrgTxtF().getText(); if (actualR.contains(Orgname)) {
		 * System.out.println(Orgname + " Organization field is verified " + " PASS"); }
		 * else { System.out.println(Orgname + " Organization field is not verified " +
		 * " FAIL"); }
		 */

		h.getEmaillink().click();

		EmailPage em = new EmailPage(driver);
		String url = w.toCaptureUrl(driver);
		em.getComposelink().click();
		w.toSwitchToWindowByTitle(driver, "Emails");

		ComposeMail c = new ComposeMail(driver);
		c.getTitle().sendKeys(To);
		w.selectByVisibleText(c.getDropdown(), dropdown1);
		c.getPlusicon().click();
		w.toSwitchToWindowByTitle(driver, "Accounts");

		OrgListPage olp = new OrgListPage(driver);
		olp.getSearchtxt().sendKeys(Orgname);
		olp.getSearchB().click();
		driver.findElement(By.xpath("//a[text()='" + Orgname + "']")).click();
		w.toSwitchToWindowByTitle(driver, "Emails");

		c.getSubject().sendKeys(subject);
		c.getSaveBtn().click();
		w.toSwitchToWindowByUrl(driver, url);
		Reporter.log("Email saved successfully",true);
		
	

	}

}
