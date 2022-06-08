package com.hcl.ikea.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
    
	@FindBy(xpath="//input[@name='txtUser'and @id='txtUser']")
	WebElement userName;
	
	@FindBy(xpath="//*[@name='txtPassword']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='btnLogin' and @type='submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//a[@id='SparePartsLoginLink' and @title='Click here']")
	WebElement clickHereBtn;
	
	@FindBy(xpath="//input[@id='LoginStatus1' and @title='Logout']")
	WebElement logoutbtn;
	
	public void setName(String uname) {
		userName.sendKeys(uname);
	}
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	public void submit() {
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("arguments[0].click()", submitBtn);
	}
	public void clickHere() {
		clickHereBtn.click();
	}
	public void clickLogout() {
		logoutbtn.click();
	}
	public void clearName() {
		userName.clear();
	}
}
