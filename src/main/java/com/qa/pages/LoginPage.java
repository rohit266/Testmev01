package com.qa.pages;


import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory or Object Repository
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(), 'Sign Up')]")
	WebElement signupBtn;
	
	@FindBy(xpath="//a[contains(text(), 'Forgot your password?')]")
	WebElement forgotPasswordBtn;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);

		System.out.println("Local Changes");

	}
	
	public String validateLoginPageTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}

}
