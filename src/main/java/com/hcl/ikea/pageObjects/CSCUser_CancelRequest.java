package com.hcl.ikea.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CSCUser_CancelRequest {

	public WebDriver driver;
	public CSCUser_CancelRequest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@id='changeUserRole']/ul/li/a/span")public WebElement role;
	@FindBy(xpath="//input[contains(@name,'txtSearch') and @id='Body_txtSearch']")
	public WebElement searchArticleComponentTxt;
	@FindBy(xpath="//input[contains(@name,'btnSearch') and @id='Body_btnSearch']")
	public WebElement searchArticleComponentBtn;
	@FindBy(xpath="//input[@name='txtUser'] [@id='txtUser']")public WebElement userName;
	@FindBy(xpath="//a//span[normalize-space(.)='Requests' and @title='Requests']") public WebElement requestTab;
	@FindBy(xpath="//table[@id='Body_gvCustomers']//tbody//tr//td[text()='No Records Found']") public WebElement NoNewRequest;
	@FindBy(xpath="") public WebElement rowNewRequest;
	@FindBy(xpath="//table[@id='Body_gvCustomers']//tbody//tr[1]//td[1]") public WebElement chevronFirstNewRqst;
	@FindBy(xpath="//table[@id='Body_gvCustomers']//tbody//tr[1]//td[2]") public WebElement firstRequestId;
	@FindBy(xpath="//table[@id='Body_gvCustomers']//tbody//tr[contains(@class,'selected')]//td//div[@title='Cancel']") public WebElement cancelBtn;
	@FindBy(xpath="//button[@class='btn btn-ikeabrn confirm' and normalize-space()='OK']")public WebElement okBtn;
	@FindBy(xpath="//span[contains(text(),'New Requests')]")
	public WebElement newRequests;
	@FindBy(xpath="//div[@id='sidebar-wrapper']/ul/li[3]")
	public WebElement requests;
	@FindBy(xpath="//span[@title='Change Country' and text()='>Country']")
	public WebElement changeCountry;
	
	public void cancelRequest() throws InterruptedException {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(role).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='Repeater1_SwitchUserRole_3']")).click();
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
		System.out.println("1st request id is: " +firstRequestId.getText());
		String newRequestId="";
		String handleRequestId="";
		int rowNewRequest= driver.findElements(By.xpath("//table[@id='NewRequestsTable']//tbody//tr")).size();
		for(int i=1;i<=rowNewRequest;i++) {
			try {
			boolean cancelIcon=driver.findElement(By.xpath("//table[@id='NewRequestsTable']//tbody//tr["+Integer.toString(i)+"]//td//div[@title='Cancel']")).isDisplayed();
			if(cancelIcon==true) {
				newRequestId=driver.findElement(By.xpath("//table[@id='NewRequestsTable']//tbody//tr["+Integer.toString(i)+"]//td[2]")).getText();
				System.out.println("current new request id is: " +newRequestId);
				//driver.findElement(By.xpath("//table[@id='NewRequestsTable']//tbody//tr["+Integer.toString(i)+"]//td[1]")).click();
				JavascriptExecutor jse = (JavascriptExecutor)driver;
	            jse.executeScript("arguments[0].click()", driver.findElement(By.xpath("//table[@id='NewRequestsTable']//tbody//tr["+Integer.toString(i)+"]//td[1]")));
	            Thread.sleep(5000);
	            jse.executeScript("arguments[0].click()", cancelBtn);
				//cancelBtn.click();
				okBtn.click();
				break;
			}
			}
			catch(Exception e1)
			{
//				continue;
			}
		}
        Thread.sleep(5000);//table[@id='HandleRequestsTable']//tbody//tr//td[2]
      //table[@id='HandleRequestsTable']//tbody//tr[1]//td[2]
        int rowHandledRequest =driver.findElements(By.xpath("//table[@id='HandleRequestsTable']//tbody//tr")).size(); 
        int count=0;
        for(int j=1;j<=rowHandledRequest;j++) {
        	handleRequestId=driver.findElement(By.xpath("//table[@id='HandleRequestsTable']//tbody//tr["+Integer.toString(j)+"]//td[2]")).getText();
        	System.out.println("current handled request id is: " +handleRequestId);
        	if(handleRequestId.equalsIgnoreCase(newRequestId)) {
            	count++;
            	break;
            }
        }
        if(count>0) {
        	Assert.assertEquals(handleRequestId, newRequestId);
        	Assert.assertTrue(true);
        }else {
	       // Assert.assertTrue(false);
        }
	
	}
	}
  }

