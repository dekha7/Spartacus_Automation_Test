package com.hcl.ikea.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CSCUser_SearchOrderRequest {

	public WebDriver driver;
	public CSCUser_SearchOrderRequest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@id='changeUserRole']/ul/li/a/span")public WebElement role;
	@FindBy(xpath="//input[contains(@name,'txtSearch') and @id='Body_txtSearch']")
	public WebElement searchArticleComponentTxt;
	@FindBy(xpath="//input[contains(@name,'btnSearch') and @id='Body_btnSearch']")
	public WebElement searchArticleComponentBtn;
	@FindBy(xpath="//table[@id='NewRequestsTable']//tbody//tr[1]//td[4]")public WebElement requester;
	@FindBy(xpath="//input[@name='txtUser'] [@id='txtUser']")public WebElement userName;
	@FindBy(xpath="//a//span[normalize-space(.)='Requests' and @title='Requests']") public WebElement requestTab;
	@FindBy(xpath="//table[@id='NewRequestsTable']//tbody//tr[1]//td[7]") public WebElement firstRequestType;
	@FindBy(xpath="") public WebElement rowNewRequest;
	@FindBy(xpath="//table[@id='NewRequestsTable']//tbody//tr[1]//td[1]") public WebElement chevronFirstNewRqst;
	@FindBy(xpath="//table[@id='NewRequestsTable']//tbody//tr[1]//td[2]") public WebElement firstRequestId;
	@FindBy(xpath="//table[@id='NewRequestsTable']//tbody//tr[1]//td[3]") public WebElement firstRequestDate;
	@FindBy(xpath="//table[@id='NewRequestsTable']//tbody//tr[1]//td[5]") public WebElement firstArticleNo;
	@FindBy(xpath="//table[@id='NewRequestsTable']//tbody//tr[contains(@class,'selected')]//td//div[@title='Preview']") public WebElement previewBtn;
	@FindBy(xpath="//span[contains(text(),'Welcome')]//span[@id='lblUsername']") public WebElement user ;
	@FindBy(xpath="//select[@id='ddlStore']") public WebElement storeId ;
	@FindBy(xpath="//h4[text()='View Details']//preceding-sibling::button[@class='close']//span") public WebElement closePreview;
	@FindBy(xpath="//table[@id='NewRequestsTable']//tbody//tr//td[text()='No Records Found']") public WebElement NoNewRequest;
	@FindBy(xpath="//span[contains(text(),'New Requests')]")
	public WebElement newRequests;
	@FindBy(xpath="//div[@id='sidebar-wrapper']/ul/li[3]")
	public WebElement requests;
	@FindBy(xpath="//label[contains(text(),'Search:')]/input[@type='search']")
	public WebElement searchCTA;
	
	public void searchOrderRequest(String orderId) throws InterruptedException {
		String storeIdNo=storeId.getText().trim();
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(role).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='Repeater1_SwitchUserRole_3' and normalize-space()='CSC']")).click();
		Thread.sleep(2000);
		action.moveToElement(requests).build().perform();
		Thread.sleep(4000);
		action.moveToElement(newRequests).build().perform();
		Thread.sleep(2000);
		newRequests.click();
		Thread.sleep(3000);
		action.moveToElement(searchCTA).build().perform();
		searchCTA.click();
		Thread.sleep(4000);
		searchCTA.sendKeys(orderId);
		Thread.sleep(2000);
}
}
