package com.hcl.ikea.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//Verify the Cancel request for the Cure User
public class CureUser_CancelRequestPage {
  
	public WebDriver driver;
	public CureUser_CancelRequestPage(WebDriver driver) {
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
	@FindBy(xpath="//table[@id='NewRequestsTable']//tbody//tr[1]//td[1]") public WebElement chevronFirstNewRqst;
	@FindBy(xpath="//table[@id='NewRequestsTable']//tbody//tr[1]//td[2]") public WebElement firstRequestId;
	@FindBy(xpath="//table[@id='NewRequestsTable']//tbody//tr[contains(@class,'selected')]//td//div[@title='Cancel']") public WebElement cancelBtn;
	@FindBy(xpath="//button[@class='btn btn-ikeabrn confirm' and normalize-space()='OK']")public WebElement okBtn;
	@FindBy(xpath="//span[contains(text(),'New Requests')]")
	public WebElement newRequests;
	@FindBy(xpath="//span[contains(text(),'Requests') and @title='Requests']")
	public WebElement requests;
	@FindBy(xpath="//div[@id='changeUserCountry']/ul/li/a/span")
	public WebElement country;
	@FindBy(xpath="//table[@id='Body_gvCustomers']//tbody//tr[\"+Integer.toString(i)+\"]//td[1]")
	public WebElement expandBtn;
	@FindBy(xpath="//table[@id='Body_gvCustomers']//tbody//tr[\"+Integer.toString(i)+\"]//td//div[@title='Cancel']")
	public WebElement cancelIcon;
	
	public void cancelRequest() throws Exception {

		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(role).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='Repeater1_SwitchUserRole_2' and normalize-space()='CuRe']")).click();
		Thread.sleep(1000);
		action.moveToElement(country).build().perform();
		Thread.sleep(2000);
		//country.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
		driver.findElement(By.xpath("//*[text()='AUSTRIA']")).click();
		Thread.sleep(2000);
		//searchArticleComponentTxt.sendKeys("pax");
		//searchArticleComponentBtn.click();
		action.moveToElement(requests).build().perform();
		Thread.sleep(4000);
		action.moveToElement(newRequests).build().perform();
		Thread.sleep(2000);
		newRequests.click();
		Thread.sleep(6000);
		try {
			boolean isNewRqstExist=NoNewRequest.isDisplayed();
			if(isNewRqstExist==true) {
			}
	   }catch(Exception e){
		System.out.println("new requests present");
		String newRequestId="";
		String handleRequestId="";
		int rowNewRequest= driver.findElements(By.xpath("//table[@id='Body_gvCustomers']//tbody//tr")).size();
		for(int i=1;i<=rowNewRequest;i++) {
			try {
				Thread.sleep(6000);
				expandBtn.click();
				JavascriptExecutor jse = (JavascriptExecutor)driver;
	            Thread.sleep(5000);
	            Actions act = new Actions(driver);
	            act.moveToElement(cancelIcon);
	            Thread.sleep(2000);
			if(cancelIcon.isDisplayed()) {
				jse.executeScript("arguments[0].click()", cancelIcon);
				okBtn.click();
				break;
				//newRequestId=driver.findElement(By.xpath("//table[@id='Body_gvCustomers']//tbody//tr["+Integer.toString(i)+"]//td[2]")).getText();
				//cancelBtn.click();		
			}
			}
			catch(Exception e1)
			{
//				continue;
			}
		}
        Thread.sleep(5000);
        int rowHandledRequest =driver.findElements(By.xpath("//table[@id='HandleRequestsTable']//tbody//tr")).size(); 
        for(int j=1;j<=rowHandledRequest;j++) {
        	handleRequestId=driver.findElement(By.xpath("//table[@id='HandleRequestsTable']//tbody//tr["+Integer.toString(j)+"]//td[2]")).getText();
        	System.out.println("current handled request id is: " +handleRequestId);
        	if(handleRequestId.equalsIgnoreCase(newRequestId)) {
            	break;
            }
        }
	}
	}

	}

