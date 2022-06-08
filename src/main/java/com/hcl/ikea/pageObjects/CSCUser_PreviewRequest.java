package com.hcl.ikea.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CSCUser_PreviewRequest {

	public WebDriver driver;
	public CSCUser_PreviewRequest(WebDriver driver) {
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
	@FindBy(xpath="//table[@id='Body_gvCustomers']//tbody//tr[1]//td[1]") public WebElement chevronFirstNewRqst;
	@FindBy(xpath="//table[@id='Body_gvCustomers']//tbody//tr[1]/td") public WebElement firstRequestId;
	@FindBy(xpath="//table[@id='Body_gvCustomers']//tbody//tr[1]/td") public WebElement expandBtn;
	@FindBy(xpath="//table[@id='Body_gvCustomers']//tbody//tr[1]//td[3]") public WebElement firstRequestDate;
	@FindBy(xpath="//table[@id='Body_gvCustomers']//tbody//tr[1]//td[5]") public WebElement firstArticleNo;
	@FindBy(xpath="//table[@id='Body_gvCustomers']//tbody//tr[contains(@class,'selected')]//td//div[@title='Preview']") public WebElement previewBtn;
	@FindBy(xpath="//span[contains(text(),'Welcome')]//span[@id='lblUsername']") public WebElement user ;
	@FindBy(xpath="//select[@id='ddlStore']") public WebElement storeId;
	@FindBy(xpath="//span[contains(text(),'New Requests')]")
	public WebElement newRequests;
	@FindBy(xpath="//div[@id='sidebar-wrapper']/ul/li[3]")
	public WebElement requests;
	@FindBy(xpath="//span[@title='Change Country' and text()='>Country']")
	public WebElement changeCountry;
	@FindBy(xpath="//h4[text()='View Details']//preceding-sibling::button[@class='close']//span") public WebElement closePreview;
	@FindBy(xpath="//table[@id='Body_gvCustomers']//tbody//tr//td[text()='No Records Found']") public WebElement NoNewRequest;
	
	public void previewRequest() throws InterruptedException {
		String storeIdNo=storeId.getText().trim();
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(role).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='Repeater1_SwitchUserRole_3' and normalize-space()='CSC']")).click();
		Thread.sleep(2000);
		action.moveToElement(changeCountry).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='UNITED STATES']")).click();
		Thread.sleep(4000);
		action.moveToElement(requests).build().perform();
		Thread.sleep(4000);
		action.moveToElement(newRequests).build().perform();
		Thread.sleep(2000);
		newRequests.click();
		Thread.sleep(3000);
		try {
			boolean isNewRqstExist=NoNewRequest.isDisplayed();
			if(isNewRqstExist==true) {
			}
	   }catch(Exception e){
		System.out.println("new requests present");
		String requestID= firstRequestId.getText().trim();
		String articleNo=firstArticleNo.getText().trim();
		expandBtn.click();
		Thread.sleep(4000);
		previewBtn.click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[contains(text(),'Request ID')]//following-sibling::div[contains(text(),'"+requestID+"')]")).isDisplayed();
		driver.findElement(By.xpath("//div[contains(text(),'"+articleNo+"')]")).isDisplayed();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", closePreview);
	   }	
	}
}
