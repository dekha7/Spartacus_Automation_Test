package com.hcl.ikea.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CureUser_SearchOrderRequestPage {
  
	public WebDriver driver;
	public CureUser_SearchOrderRequestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@id='changeUserRole']/ul/li/a/span")
	public WebElement role;
	@FindBy(xpath="//input[contains(@name,'txtSearch') and @id='Body_txtSearch']")
	public WebElement searchArticleComponentTxt;
	@FindBy(xpath="//input[contains(@name,'btnSearch') and @id='Body_btnSearch']")
	public WebElement searchArticleComponentBtn;
	@FindBy(xpath="//span[contains(text(),'New Requests')]")
	public WebElement newRequests;
	@FindBy(xpath="//span[contains(text(),'Requests') and @title='Requests']")
	public WebElement requests;
	@FindBy(xpath="//div[@id='changeUserCountry']/ul/li/a/span")
	public WebElement country;
	@FindBy(xpath="ctl00$ddlStore")
    public WebElement storeID;
    @FindBy(xpath="//button[contains(@class,'searchButton') and @onclick='GetRequestOrderHistory();']")
    public WebElement searchBtnCTA;
	@FindBy(xpath="//input[@id='Modal_SearchArticleTxt']")
	public WebElement trackordertxt;
	@FindBy(xpath="//div[@id='TrackCompModalHistory']/div/div/div/button")
    public WebElement modalCloseBtn;
	//@FindBy(xpath="//*[@id='modalRequest']/div[2]/div/div[3]/button[2]")
    //public WebElement gotoRequestForm;
	@FindBy(xpath="//label[contains(text(),'Search:')]/input[@type='search']")
	public WebElement searchCTA;
	@FindBy(xpath="//select[contains(@name,'RequestReason') and @id='Body_ddlRequestReason']")
	public WebElement reason2;
	@FindBy(xpath="//input[@id='Body_btnRequest']")
	public WebElement sendRequestToRecovery;
	@FindBy(xpath="//div[@id='confirm']/div[2]/div/child::div[3]/button[2]")
	public WebElement confirmCancelBtn;
	
	public void trackOrderRequest(String orderId) throws Exception {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(role).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Repeater1_SwitchUserRole_2']")).click();
		Thread.sleep(1000);
		action.moveToElement(country).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='AUSTRIA']")).click();
		Thread.sleep(2000);
		action.moveToElement(requests).build().perform();
		Thread.sleep(4000);
		action.moveToElement(newRequests).build().perform();
		Thread.sleep(2000);
		newRequests.click();
		Thread.sleep(6000);
		action.moveToElement(searchCTA).build().perform();
		searchCTA.click();
		Thread.sleep(4000);
		searchCTA.sendKeys(orderId);
		//searchBtnCTA.click();
		Thread.sleep(2000);
		//modalCloseBtn.click();
	}

}
