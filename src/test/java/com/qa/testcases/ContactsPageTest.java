package com.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	//TestUtil testutil;
	
	String sheetName = "contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		LoginPage loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactspage = homepage.clickOnContactLink();
		contactspage.VerifyShowFilterButton();
		//testutil = new TestUtil();
	}
	
	@Test(priority=1)
	public void testContactLabel() {
		boolean b = contactspage.verifyContactLabel02();
		Assert.assertEquals(b, true);
	}
	
//	@Test(priority=2)
//	public void selectSingleContactTest() {
//		String attribute = contactspage.selectContactByName("Shobha Singh");
//		Assert.assertEquals(attribute, "ui checked fitted read-only checkbox", "Checkbox not Checked");
//	}
//	
//	@Test(priority=3)
//	public void selectMultipleContactTest() {
//		String attribute = contactspage.selectContactByName("Monika Verma");
//		Assert.assertEquals(attribute, "ui checked fitted read-only checkbox", "Checkbox not Checked");
//		
//		String attribute01 = contactspage.selectContactByName("Dhruv Singh");
//		Assert.assertEquals(attribute01, "ui checked fitted read-only checkbox", "Checkbox not Checked");
//	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String ftName, String ltName, String email) {
		
		//boolean b = contactspage.createNewContact("Lambu", "Singh", "Lambu123@yopmail.com");
		boolean b = contactspage.createNewContact(ftName, ltName, email);
		Assert.assertEquals(b, true, "Contact Not Created");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
