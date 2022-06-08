package com.hcl.ikea.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidateComponentAdminOfRangeManagement {
	public WebDriver driver;

	public ValidateComponentAdminOfRangeManagement(WebDriver driver) {
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
	@FindBy(xpath="//li[contains(@class,'rangeManagement')]//a//span[normalize-space()='Component Admin']")
	public WebElement compAdmin;
	@FindBy(xpath="//table[@id='ImageRequests']//tbody//tr[1]//td[3]")
	public WebElement firstPartNo;
	@FindBy(xpath="//table[@id='ImageRequests']//tbody//tr[1]//td//div[@title='Approve']")
	public WebElement approveFirstPart;
	@FindBy(xpath="//table[@id='ImageRequests']//tbody//tr[1]//td//div[@title='Reject']")
	public WebElement rejectFirstPart;
	@FindBy(xpath="//table[@id='ImageRequests']//tbody//tr[1]//td//a[text()='Send mail']")
	public WebElement firstPartSendMail;
	@FindBy(xpath="//span[@class='notification handCursor']//span[@id='spancount']")
	public WebElement notificationCount;
	@FindBy(xpath="//table[@id='PhaseInPhaseOutTable']//tbody//tr//td[text()='No Records Available']")
	public WebElement noRecordRow;	

	public void verifyPicAdminSendMail() throws Exception {
		rangeManagementTab.click();
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(compAdmin).click(compAdmin).perform();
		Thread.sleep(4000);
		for(int i=1;i<=3;i++) {
			if(i==1) {
			String firstPartNum=firstPartNo.getText();
			approveFirstPart.click();
			}
		}
		firstPartSendMail.isDisplayed();
   }
}
