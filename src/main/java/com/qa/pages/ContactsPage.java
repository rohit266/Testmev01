package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//i[@class='users icon']/following-sibling::span[@class='item-text']")
	WebElement contactsLabel;
	
	@FindBy(xpath="//div[@class='ui loader']//following-sibling::span[@class='selectable ']")
	WebElement contactsLabel2;
	
	@FindBy(xpath="//button[contains(text(), 'Show Filters')]")
	WebElement contactfilter;
	
	@FindBy(xpath = "//button[contains(text(), 'Create')]")
	WebElement createContactButton;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@placeholder='Email address']")
	WebElement emailAddress;
	
	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement saveBtn;
	
	@FindBy(xpath="//span[contains(text(), 'Contacts')]")
	WebElement contactlinks;
	
	//a[contains(text(),'Dhruv Singh')]//parent::td[1]//preceding-sibling::td//div[@class='ui fitted read-only checkbox']
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public boolean verifyContactLabel02() {
		return contactsLabel2.isDisplayed();
	}
	
	public void VerifyShowFilterButton() {
		Actions action = new Actions(driver);
		action.moveToElement(contactfilter).build().perform();
	}
	
	public String selectContactByName(String name) {
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent::td[1]//"
				                               +"preceding-sibling::td//div[@class='ui fitted read-only checkbox']"));
		element.click();
		return element.getAttribute("class");
	}
	
	public boolean createNewContact(String ftName, String ltName, String email) {
		createContactButton.click();
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		emailAddress.sendKeys(email);
		saveBtn.click();
		WebElement contactElement = driver.findElement(By.xpath("//span[text()= '"+ftName+" "+ ltName+"']"));
		TestUtil.visible(driver, contactElement, 30);
		//Thread.sleep(5000);
		Actions action = new Actions(driver);
		action.moveToElement(contactlinks).click().build().perform();
		action.moveToElement(contactfilter).build().perform();
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'"+ftName+" "+ltName+"')]"));
		return element.isDisplayed();
	}

}
