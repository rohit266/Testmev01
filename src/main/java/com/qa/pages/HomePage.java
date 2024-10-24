package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//span[contains(text(), 'Rohit Kumar')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains(text(), 'Contacts')]")
	WebElement contactlinks;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCorrectUsername() {
		return userNameLabel.isDisplayed();
	}
	
	public String validateHomePageTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public ContactsPage clickOnContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactlinks).click().build().perform();
		return new ContactsPage();
	}
}
