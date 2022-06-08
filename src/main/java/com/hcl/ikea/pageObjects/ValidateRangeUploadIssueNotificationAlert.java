package com.hcl.ikea.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ValidateRangeUploadIssueNotificationAlert {
	public WebDriver driver;

	public ValidateRangeUploadIssueNotificationAlert(WebDriver driver) {
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
	@FindBy(xpath="//span[@class='notification handCursor']//span[@id='spancount']")
	public WebElement notificationCount;
	@FindBy(xpath="//table[@id='PhaseInPhaseOutTable']//tbody//tr//td[text()='No Records Available']")
	public WebElement noRecordRow;	

	public void notificationAndCCompCount() throws Exception {
		rangeManagementTab.click();
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(phaseInOut).click(phaseInOut).perform();
		Thread.sleep(4000);
		String countNotification=notificationCount.getText();
		int rowCount= driver.findElements(By.xpath("//table[@id='PhaseInPhaseOutTable']//tbody//tr")).size();
		if(countNotification.equals("")) {
			Thread.sleep(2000);
			Assert.assertEquals(1, rowCount);
			noRecordRow.isDisplayed();
		}
		else {
			int notificationCounts=Integer.parseInt(countNotification);
			Assert.assertEquals(notificationCounts, rowCount);
		}
		
	}

}
