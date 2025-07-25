package com.demo.testng.contacttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.demo1.generic.base.BaseClass;
import com.demo1.generic.objectrepository.ContactInfoPage;
import com.demo1.generic.objectrepository.ContactPage;
import com.demo1.generic.objectrepository.CreateContactPage;
import com.demo1.generic.objectrepository.CreateOrgPage;
import com.demo1.generic.objectrepository.HomePage;
import com.demo1.generic.objectrepository.OrgInfoPage;
import com.demo1.generic.objectrepository.OrgListPage;
import com.demo1.generic.objectrepository.OrganizationPage;


@Listeners(com.demo1.generic.listenerutility.ListenerImplClass1.class)
public class CreateContactMTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createContactTest() throws EncryptedDocumentException, IOException {// To read data from excel file
		String lastname = e.toGetDataFromExcelFile("Contact", 1, 2);
		HomePage h = new HomePage(driver);
		h.getContactlink().click();
		ContactPage cp = new ContactPage(driver);
		cp.getCreateContactlink().click();
		CreateContactPage cop = new CreateContactPage(driver);
		cop.getLastnameTxtB().sendKeys(lastname);

		cop.getSaveBtn().click();

		// verify contact created successfully--------------------

		ContactInfoPage cip = new ContactInfoPage(driver);

		/*
		 * String actualH = cip.getContactheader().getText();
		 * Assert.assertEquals(actualH.contains(lastname),
		 * true,"contact created successfully");
		 * Reporter.log("contact created successfully");
		 */

		String actualH = cip.getContactheader().getText();
		boolean status2 = actualH.contains(lastname);
		Assert.assertEquals(status2, true);
		Reporter.log("Contact created successfully");
		

		/*
		 * if (actualH.contains(lastname)) { System.out.println(lastname +
		 * " Contact is created successfull " + " PASS"); } else {
		 * System.out.println(lastname + "Contact is not created successfull " +
		 * " FAIL"); }
		 */
		SoftAssert sft = new SoftAssert();
		String actualR = cip.getLastnameTxtF().getText().trim();
		sft.assertEquals(actualR, lastname,"Lastname verified successfully");
		sft.assertAll();
		//Reporter.log("Lastname verified successfully", true);

		/*
		 * if (actualR.contains(lastname)) { System.out.println("Contact is verified" +
		 * " PASS");
		 * 
		 * } else { System.out.println("Contact is not verfied" + " FAIL"); }
		 */
		

	}

	@Test(groups="regressionTest")
	public void demoTest()
	{
		Reporter.log("hello how are you");
	
		String user=System.getProperty("username");
		
		System.out.println(user);
	}
	
	@Test(groups = "regressionTest")
	public void createContactWithOrgTest() throws EncryptedDocumentException, IOException {
		// To read data from excel
		// file--------------------------------------------------
		String orgname = e.toGetDataFromExcelFile("Contact", 7, 2) + j.getRandomNumber();
		String lastname = e.toGetDataFromExcelFile("Contact", 7, 3);
		SoftAssert sft = new SoftAssert();
		HomePage h = new HomePage(driver);
		h.getOrglink().click();

		OrganizationPage o = new OrganizationPage(driver);
		o.getCreateOrg().click();

		CreateOrgPage cop = new CreateOrgPage(driver);
		cop.getOrgTxtB().sendKeys(orgname);

		cop.getSaveBtn().click();

		OrgInfoPage oi = new OrgInfoPage(driver);

		String actualH = oi.getOrgHeader().getText();
		boolean status = actualH.contains(orgname);
		Assert.assertEquals(status, true);
		Reporter.log("Organization created successfully", true);
		/*
		 * if (actualH.contains(orgname)) { System.out.println(orgname +
		 * " Organization is created successfull " + " PASS"); } else {
		 * System.out.println(orgname + " Organization is not created successfull " +
		 * " FAIL"); }
		 */
		String actualR = oi.getOrgTxtF().getText();

		sft.assertEquals(actualR, orgname);
		sft.assertAll();
		Reporter.log("Organization verified successfully", true);
		/*
		 * if (actualR.contains(orgname)) { System.out.println(orgname +
		 * " Organization field is verified " + " PASS"); } else {
		 * System.out.println(orgname + " Organization field is not verified " +
		 * " FAIL"); }
		 */
		// navigating to contact
		// page-----------------------------------------------------------------------------

		h.getContactlink().click();
		ContactPage cp = new ContactPage(driver);
		cp.getCreateContactlink().click();

		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getLastnameTxtB().sendKeys(lastname);

		ccp.getOrgcreateB().click();

		ccp.getOrgcreateB().click();
		w.toSwitchToWindowByTitle(driver, "Accounts");

		OrgListPage oip = new OrgListPage(driver);
		oip.getSearchtxt().sendKeys(orgname);
		oip.getSearchB().click();

		driver.findElement(By.xpath("//a[text()='" + orgname + "']")).click();

		w.toSwitchToWindowByTitle(driver, "Contacts");

		ccp.getSaveBtn().click();

		ContactInfoPage cip = new ContactInfoPage(driver);

		String actualH1 = cip.getContactheader().getText();

		boolean status1 = actualH1.contains(lastname);
		Assert.assertEquals(status1, true);
		Reporter.log("Contact is successfully created", true);
		/*
		 * if(actualH1.contains(lastname)) {
		 * System.out.println(lastname+" Contact is successfull created "+" PASS"); }
		 * else {
		 * System.out.println(lastname+" Contact is not created successfull "+" FAIL");
		 * }
		 */

		String actualL = cip.getLastnameTxtF().getText();

		sft.assertEquals(actualL, lastname);
		Reporter.log("Lastname verified successfully", true);

		/*
		 * if(actualL.contains(lastname)) {
		 * System.out.println(lastname+" lastname verified successfully"); } else {
		 * System.out.println(lastname+" lastname not verified successfully"); }
		 */

		String orgR = cip.getOrgtextF().getText();
		sft.assertEquals(orgR, orgname);
		Reporter.log("Organization verified successfully", true);

		/*
		 * if(orgR.contains(orgname)) {
		 * System.out.println(orgname+" Organization verified successfully"+" PASS"); }
		 * else {
		 * System.out.println(orgname+" Organization not verified successfully"+" FAIL"
		 * ); }
		 */

	}

	@Test(groups = "smokeTest")
	public void createContactWithSupportDateTest() throws EncryptedDocumentException, IOException {
		String lastname = e.toGetDataFromExcelFile("Contact", 4, 2);

		// To capture the current date
		String startDate = j.getCurrentDate();
		System.out.println(startDate);
		// To capture date for next 30 days

		String endDate = j.getRequiredDate(30);
		System.out.println(endDate);

		HomePage h = new HomePage(driver);
		h.getContactlink().click();
		ContactPage cp = new ContactPage(driver);
		cp.getCreateContactlink().click();

		CreateContactPage cop = new CreateContactPage(driver);
		cop.getLastnameTxtB().sendKeys(lastname);

		cop.getStartdate().clear();
		cop.getStartdate().sendKeys(startDate);
		cop.getEnddate().clear();
		cop.getEnddate().sendKeys(endDate);

		cop.getSaveBtn().click();

		// verify contact created successfully--------------------

		ContactInfoPage cip = new ContactInfoPage(driver);

		String actualH = cip.getContactheader().getText();

		boolean status = actualH.contains(lastname);
		Assert.assertEquals(status, true);
		Reporter.log("Contact created successfully", true);
		/*
		 * if (actualH.contains(lastname)) { System.out.println(lastname +
		 * " Contact is created successfull " + " PASS"); } else {
		 * System.out.println(lastname + "Contact is not created successfull " +
		 * " FAIL"); }
		 */

		String actualR = cip.getLastnameTxtF().getText();
		SoftAssert sft = new SoftAssert();
		boolean status3 = actualR.contains(lastname);
		sft.assertEquals(status3, true);
		Reporter.log("Lastname verified successfully");

		/*
		 * if (actualR.contains(lastname)) { System.out.println("Contact is verified" +
		 * " PASS");
		 * 
		 * } else { System.out.println("Contact is not verfied" + " FAIL"); }
		 */

		// To verify the start date
		String actualStartDate = cip.getStartdateTxt().getText();
		sft.assertEquals(actualStartDate, startDate, "startDate Date is verified successfully");
		sft.assertAll();
		Reporter.log("Start date verified successfully");

		/*
		 * if (actualStartDate.contains(startDate)) { System.out.println(startDate +
		 * " startDate Date  is verified " + " PASS"); } else {
		 * System.out.println(startDate + "startDate  Date  is not verified " +
		 * " FAIL"); }
		 */

		// To verify the end date
		String actualEndDate = cip.getEnddateTxt().getText();
		sft.assertEquals(actualEndDate, endDate,"End date verified successfully");
		//Reporter.log("End date verified successfully");
		/*
		 * if (actualEndDate.contains(endDate)) { System.out.println(endDate +
		 * " endDate Date  is verified " + " PASS"); } else { System.out.println(endDate
		 * + " endDate Date  is not verified " + " FAIL"); }
		 */

	}

}
