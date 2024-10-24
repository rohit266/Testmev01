package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test (priority=1)
	public void testusername() {
		boolean b = homepage.verifyCorrectUsername();
		Assert.assertEquals(b, true);
	}
	
	@Test (priority=2)
	public void contactLinkTest() {
		contactspage = homepage.clickOnContactLink();
		boolean b = contactspage.verifyContactLabel();
		Assert.assertEquals(b, true);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
