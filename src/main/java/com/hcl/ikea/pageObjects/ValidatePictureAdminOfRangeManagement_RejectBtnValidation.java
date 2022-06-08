package com.hcl.ikea.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidatePictureAdminOfRangeManagement_RejectBtnValidation {

	public WebDriver driver;

	public ValidatePictureAdminOfRangeManagement_RejectBtnValidation(WebDriver driver) {
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
	@FindBy(xpath="//li[contains(@class,'rangeManagement')]//a//span[normalize-space()='Picture Admin']")
	public WebElement picAdmin;
	@FindBy(xpath="//table[@id='ImageRequests']//tbody//tr[1]//td//a[text()='Send mail']")
	public WebElement firstPartSendMail;
	@FindBy(xpath="//span[@class='notification handCursor']//span[@id='spancount']")
	public WebElement notificationCount;
	@FindBy(xpath="//div[@id='sidebar-wrapper']/ul/li[5]/ul/li[3]/a/span")
	public WebElement pictureAdmin;
	@FindBy(xpath="//div[@id='BadImagePopUp']/div[2]/div/div/button")
	public WebElement reportedImageCancelButton;
	@FindBy(xpath="//table[@id='ImageRequests']/tbody/tr/td/span[@title='Approve']")
	public WebElement approveBtn;
	@FindBy(xpath="//table[@id='ImageRequests']/tbody/tr/td/span[@title='Reject']")
	public WebElement rejectBtn;
	@FindBy(xpath="//p[text()='Are You Sure You want to perform this action ?']")
	public WebElement confirmModalMessage;
	@FindBy(xpath="//div[@id='confirm']/div[2]/div/div[3]/button[1]")
	public WebElement confirmModalOkCTA;
	@FindBy(xpath="//div[@id='confirm']/div[2]/div/div[3]/button[2]")
	public WebElement confirmModalCancelCTA;
	@FindBy(xpath="//table[@id='PhaseInPhaseOutTable']//tbody//tr//td[text()='No Records Available']")
	public WebElement noRecordRow;	

	public void verifyRejectButton() throws Exception {
		//rangeManagementTab.click();
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(rangeManagementTab).build().perform();
		pictureAdmin.click();
		Thread.sleep(6000);
		rejectBtn.click();
		Thread.sleep(4000);
		if(confirmModalMessage.getText().equals("Are You Sure You want to perform this action ?")) {
			confirmModalOkCTA.click();
		}else {
			confirmModalCancelCTA.click();
		}
   }
}
