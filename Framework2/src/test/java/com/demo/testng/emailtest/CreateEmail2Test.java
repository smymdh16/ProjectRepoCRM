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
public class CreateEmail2Test extends BaseClass {
	@Test(groups="smokeTest")
	public void searchEmailAndDeleteTest() throws EncryptedDocumentException, IOException {// To read data from excel
																							// file

		String orgname = e.toGetDataFromExcelFile("Org", 1, 2) + j.getRandomNumber();
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
		cop.getOrgTxtB().sendKeys(orgname);
		cop.getEmail().sendKeys(emailorg);
		cop.getSaveBtn().click();

		OrgInfoPage oi = new OrgInfoPage(driver);

		String actualH = oi.getOrgHeader().getText();
		
		
		boolean status=actualH.contains(orgname);
		Assert.assertEquals(status, true);
		Reporter.log("Organization created successfully",true);
		
		String actualR = oi.getOrgTxtF().getText();
		SoftAssert sft=new SoftAssert();
		boolean status1=actualR.contains(orgname);
		sft.assertEquals(status1,true);
		sft.assertAll();
		
		
		/*
		 * if (actualH.contains(orgname)) { System.out.println(orgname +
		 * " Organization is created successfull " + " PASS"); } else {
		 * System.out.println(orgname + " Organization is not created successfull " +
		 * " FAIL"); }
		 * 
		 * String actualR = oi.getOrgTxtF().getText(); if (actualR.contains(orgname)) {
		 * System.out.println(orgname + " Organization field is verified " + " PASS"); }
		 * else { System.out.println(orgname + " Organization field is not verified " +
		 * " FAIL"); }
		 */
		
		h.getEmaillink().click();
		String url = w.toCaptureUrl(driver);
		EmailPage em = new EmailPage(driver);
		em.getComposelink().click();
		w.toSwitchToWindowByTitle(driver, "Emails");

		ComposeMail c = new ComposeMail(driver);
		c.getTitle().sendKeys(To);
		w.selectByVisibleText(c.getDropdown(), dropdown1);
		c.getPlusicon().click();
		w.toSwitchToWindowByTitle(driver, "Accounts");
		OrgListPage olp = new OrgListPage(driver);
		olp.getSearchtxt().sendKeys(orgname);
		olp.getSearchB().click();
		driver.findElement(By.xpath("//a[text()='" + orgname + "']")).click();
		w.toSwitchToWindowByTitle(driver, "Emails");
		c.getSubject().sendKeys(subject);
		c.getSaveBtn().click();
		Reporter.log("Email created successfully",true);
		w.toSwitchToWindowByUrl(driver, url);
		String subject1 = e.toGetDataFromExcelFile("Email", 4, 2);
		em.getSearchtext().sendKeys(subject1);
		em.getFindB().click();
		em.getCheckbox().click();
		em.getDelete().click();
		w.switchToAlertToGettext(driver);
		Reporter.log("Email deleted successfully",true);

		w.switchToAlertToAccept(driver);

	}

}
