package com.hcl.ikea.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class RecoveryAdmin_Cancel_Request_Page {
		public WebDriver driver;

		public RecoveryAdmin_Cancel_Request_Page(WebDriver driver) {
			this.driver = driver;
		    PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//input[@name='txtUser'] [@id='txtUser']")public WebElement userName;
		@FindBy(xpath="//a//span[normalize-space(.)='Requests' and @title='Requests']") public WebElement requestTab;
		@FindBy(xpath="") public WebElement rowNewRequest;
		@FindBy(xpath="//div[@id='sidebar-wrapper']/ul/li[2]/ul/li[1]/a/span") public WebElement newRequestTab;
		@FindBy(xpath="//span[text()='>Country']") public WebElement countrySelection;
		@FindBy(xpath="//a[text()='AUSTRALIA']") public WebElement countryOption;
		@FindBy(xpath="//div[@id='confirm']/div[2]/div/div[3]/button[2]") public WebElement confirmModalCancelCTA;
		@FindBy(xpath="//div[@id='confirm']/div[2]/div/div[3]/button[1]") public WebElement confirmModalOKCTA;
		@FindBy(xpath="//p[text()='Cancel the selected request?']") public WebElement confirmModalMessage;
		@FindBy(xpath="//table[@id='Body_gvCustomers']//tbody//tr[1]//td[1]") public WebElement chevronFirstNewRqst;
		@FindBy(xpath="//table[@id='Body_gvCustomers']//tbody//tr[1]//td[2]") public WebElement requestId;
		@FindBy(xpath="//table[@id='Body_gvCustomers']/tbody/tr[@class='dataTableData col odd shown selected']/td/div[@title='Cancel']") public WebElement cancelBtn;
		public void clickOnRequest() throws InterruptedException { 	
			Actions action = new Actions(driver);
			Thread.sleep(4000);
			action.moveToElement(countrySelection).build().perform();
			countryOption.click();
			Thread.sleep(6000);
			action.moveToElement(requestTab).build().perform();
			//requestTab.click();
			action.moveToElement(newRequestTab).build().perform();
			newRequestTab.click();
			Thread.sleep(5000);
		}
		
		public void recoveryAdminCancelRequest() throws InterruptedException {
			System.out.println("request id is: " +requestId.getText());
			int rowNewRequest= driver.findElements(By.xpath("//table[@id='Body_gvCustomers']//tbody//tr")).size();
			for(int i=1;i<=rowNewRequest;i++) {
				try {
				driver.findElement(By.xpath("//table[@id='Body_gvCustomers']//tbody//tr["+Integer.toString(i)+"]//td[1]")).click();
				//boolean cancelIcon=driver.findElement(By.xpath("//table[@id='Body_gvCustomers']/tbody/tr["+Integer.toString(i)+"]/td/input[@title='Accept']")).isDisplayed();
				if(cancelBtn.isDisplayed()) {
					//String newRequestId=driver.findElement(By.xpath("//table[@id='NewRequestsTable']//tbody//tr["+Integer.toString(i)+"]//td[2]")).getText();
					
					Thread.sleep(2000);
					cancelBtn.click();
					cancelBtn.click();
					break;
				}
				}
				catch(Exception e)
				{
					continue;
				}
			}
			//chevronFirstNewRqst.click();
            cancelBtn.click();
            Thread.sleep(5000);
            if(confirmModalMessage.getText().equals("Cancel the selected request?")) {
            	confirmModalOKCTA.click();
            }else {
            	confirmModalCancelCTA.click();
            }
          //table[@id='HandleRequestsTable']//tbody//tr[1]//td[2]
		}
}