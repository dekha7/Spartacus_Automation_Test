package com.hcl.ikea.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Recovery_Request {

	public WebDriver driver;

	public Recovery_Request(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='txtUser'] [@id='txtUser']")public WebElement userName;
	@FindBy(xpath="//div[@id='changeUserRole']/ul/li/a/span")public WebElement role;
	@FindBy(xpath="//input[contains(@name,'txtSearch') and @id='Body_txtSearch']")
	public WebElement searchArticleComponentTxt;
	@FindBy(xpath="//input[contains(@name,'btnSearch') and @id='Body_btnSearch']")
	public WebElement searchArticleComponentBtn;
	@FindBy(xpath="//a//span[normalize-space(.)='Requests' and @title='Requests']") public WebElement requestTab;
	@FindBy(xpath="") public WebElement rowNewRequest;
	@FindBy(xpath="//table[@id='NewRequestsTable']//tbody//tr[1]//td[1]") public WebElement chevronFirstNewRqst;
	@FindBy(xpath="//table[@id='NewRequestsTable']//tbody//tr[1]//td[2]") public WebElement firstRequestId;
	@FindBy(xpath="//table[@id='NewRequestsTable']//tbody//tr[1]//td[7]") public WebElement firstRequestType;
	@FindBy(xpath="//table[@id='NewRequestsTable']//tbody//tr[contains(@class,'selected')]//td//div[@title='Cancel']") public WebElement cancelBtn;
	@FindBy(xpath="//table[@id='NewRequestsTable']//tbody//tr[contains(@class,'selected')]//td//div[@title='Accept']") public WebElement acceptBtn;
	@FindBy(xpath="//table[@id='NewRequestsTable']//tbody//tr[contains(@class,'selected')]//td//div[@title='Reject']") public WebElement rejectBtn;
	@FindBy(xpath="//table[@id='NewRequestsTable']//tbody//tr[contains(@class,'selected')]//td//div[@title='Preview']") public WebElement previewBtn;
	@FindBy(xpath="//button[@class='btn btn-ikeabrn confirm' and normalize-space()='OK']")public WebElement okBtn;
	@FindBy(xpath="//label[text()='The component is damaged']//preceding-sibling::input[@id='Modal_rblReasons_1']") public WebElement rejectDamageReasonRadio;
	@FindBy(xpath="//button[normalize-space()='Cancel']//preceding-sibling::button[normalize-space()='Next']") public WebElement nextBtn;
	@FindBy(xpath="//textarea[@id='txtComment']") public WebElement commentRejectTxtBx;
	@FindBy(xpath="//button[contains(text(),'Done')]") public WebElement doneBtn;
	@FindBy(xpath="//span[contains(text(),'Welcome')]//span[@id='lblUsername']") public WebElement user ;
	@FindBy(xpath="//select[@id='ddlStore']") public WebElement storeId ;
	@FindBy(xpath="//h4[text()='View Details']//preceding-sibling::button[@class='close']//span") public WebElement closePreview;
	//div[contains(text(),'Requested By')]//following-sibling::div[contains(text(),'sojha')]
			//div[contains(text(),'Request ID')]//following-sibling::div[contains(text(),'1360642')]
			//h4[text()='View Details']//preceding-sibling::button[@class='close']//span
			
	
	public void switchToRecoveryAndClickOnRequest() throws InterruptedException {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(role).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@id,'Repeater1_SwitchUserRole') and normalize-space()='Recovery']")).click();
		Thread.sleep(5000);
		requestTab.click();
		Thread.sleep(5000);
		
	}
	/*
	public void cancelRequest() throws InterruptedException {
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
			catch(Exception e)
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
	        Assert.assertTrue(false);
        }
	}
	
	*/
	/*
	public void acceptRequest() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("1st request id is: " +firstRequestId.getText());
		String newRequestId="";
		String handleRequestId="";
		int rowNewRequest= driver.findElements(By.xpath("//table[@id='NewRequestsTable']//tbody//tr")).size();
		for(int i=1;i<=rowNewRequest;i++) {
			try {
			boolean acceptIcon=driver.findElement(By.xpath("//table[@id='NewRequestsTable']//tbody//tr["+Integer.toString(i)+"]//td//div[@title='Accept']")).isDisplayed();
			if(acceptIcon==true) {
				newRequestId=driver.findElement(By.xpath("//table[@id='NewRequestsTable']//tbody//tr["+Integer.toString(i)+"]//td[2]")).getText();
				System.out.println("current new request id is: " +newRequestId);
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].click()", driver.findElement(By.xpath("//table[@id='NewRequestsTable']//tbody//tr["+Integer.toString(i)+"]//td[1]")));
//				driver.findElement(By.xpath("//table[@id='NewRequestsTable']//tbody//tr["+Integer.toString(i)+"]//td[1]")).click();
				Thread.sleep(5000);
				jse.executeScript("arguments[0].click()", acceptBtn);
//				acceptBtn.click();
				okBtn.click();
				break;
			}
			}
			catch(Exception e)
			{
//				continue;
			}
		}
//
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
        	Assert.assertTrue(false);
        }
	}
	*/
	/*	
	public void rejectRequest() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("1st request id is: " +firstRequestId.getText());
		String newRequestId="";
		String handleRequestId="";
//		String newRequestIdAfterReject="";
		int rowNewRequest= driver.findElements(By.xpath("//table[@id='NewRequestsTable']//tbody//tr")).size();
		for(int i=1;i<=rowNewRequest;i++) {
			try {
			boolean rejectIcon=driver.findElement(By.xpath("//table[@id='NewRequestsTable']//tbody//tr["+Integer.toString(i)+"]//td//div[@title='Reject']")).isDisplayed();
			if(rejectIcon==true) {
				newRequestId=driver.findElement(By.xpath("//table[@id='NewRequestsTable']//tbody//tr["+Integer.toString(i)+"]//td[2]")).getText();
				System.out.println("current new request id is: " +newRequestId);
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].click()", driver.findElement(By.xpath("//table[@id='NewRequestsTable']//tbody//tr["+Integer.toString(i)+"]//td[1]")));
//				driver.findElement(By.xpath("//table[@id='NewRequestsTable']//tbody//tr["+Integer.toString(i)+"]//td[1]")).click();
				Thread.sleep(5000);
				jse.executeScript("arguments[0].click()", rejectBtn);
//				rejecttBtn.click();
				Thread.sleep(5000);
				rejectDamageReasonRadio.click();
//				okBtn.click();
                nextBtn.click();
                Thread.sleep(5000);
                commentRejectTxtBx.sendKeys("test");
                doneBtn.click();
				break;
			}
			}
			catch(Exception e)
			{
//				continue;
			}
		}
//
        Thread.sleep(5000);
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
        	Assert.assertTrue(false);
        }
   }
   */
	
	public void previewRequest() throws InterruptedException {
		System.out.println("the first request id is : "+ firstRequestId.getText().trim());
		String firstRequestTypeName=firstRequestType.getText();
		chevronFirstNewRqst.click();
		String userName=user.getText().trim();
		String storeIdNo=storeId.getText().trim();
		previewBtn.click();
		if(firstRequestTypeName.contains("Asis")||firstRequestTypeName.contains("Repack")||firstRequestTypeName.contains("Show")) {
			driver.findElement(By.xpath("//div[contains(text(),'Requested By')]//following-sibling::div[contains(text(),'"+storeIdNo+"')]")).isDisplayed();
		}else {
		driver.findElement(By.xpath("//div[contains(text(),'Requested By')]//following-sibling::div[contains(text(),'"+userName.toLowerCase()+"')]")).isDisplayed();
		}
		driver.findElement(By.xpath("//div[contains(text(),'Request ID')]//following-sibling::div[contains(text(),'"+firstRequestId.getText().trim()+"')]")).isDisplayed();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", closePreview);		
	}
	

}
