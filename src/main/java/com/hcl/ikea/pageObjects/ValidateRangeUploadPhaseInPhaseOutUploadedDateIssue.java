package com.hcl.ikea.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidateRangeUploadPhaseInPhaseOutUploadedDateIssue {

	public WebDriver driver;

	public ValidateRangeUploadPhaseInPhaseOutUploadedDateIssue(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='txtUser'] [@id='txtUser']")public WebElement userName;
	@FindBy(xpath="//input[contains(@name,'txtSearch') and @id='Body_txtSearch']")
	public WebElement searchArticleComponentTxt;
	@FindBy(xpath="//input[contains(@name,'btnSearch') and @id='Body_btnSearch']")
	public WebElement searchArticleComponentBtn;
	@FindBy(xpath="//a//span[normalize-space(.)='Range Management' and @title='Range Management']")
	public WebElement rangeManagementTab;
	@FindBy(xpath="//li[contains(@class,'rangeManagement')]//a//span[normalize-space()='Phase-In/ Phase-Out']")
	public WebElement phaseInOut;
	@FindBy(xpath="//span[contains(text(),'Last Uploaded Date')]")
	public WebElement lastUploadDateMsg;
	@FindBy(xpath="//table[@class='dataTable no-footer']//th[text()='C Component']")
	public WebElement cCompHeader;
	@FindBy(xpath="//table[@class='dataTable no-footer']//th[text()='C Part Description']")
	public WebElement cPartDesc;
	
	public void phaseInOutDateIssue() throws Exception {
		rangeManagementTab.click();
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(phaseInOut).click(phaseInOut).perform();
		Thread.sleep(4000);
		lastUploadDateMsg.isDisplayed();
		cPartDesc.isDisplayed();
		cCompHeader.isDisplayed();
	}
}
