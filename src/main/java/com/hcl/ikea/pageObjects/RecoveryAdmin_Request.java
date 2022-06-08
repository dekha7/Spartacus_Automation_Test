package com.hcl.ikea.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class RecoveryAdmin_Request {
		public WebDriver driver;

		public RecoveryAdmin_Request(WebDriver driver) {
			this.driver = driver;
		    PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//input[@name='txtUser'] [@id='txtUser']")public WebElement userName;
		@FindBy(xpath="//input[contains(@name,'txtSearch') and @id='Body_txtSearch']")
		public WebElement searchArticleComponentTxt;
		@FindBy(xpath="//input[contains(@name,'btnSearch') and @id='Body_btnSearch']")
		public WebElement searchArticleComponentBtn;
		@FindBy(xpath="//a//span[normalize-space(.)='Requests' and @title='Requests']") public WebElement requestTab;
		@FindBy(xpath="") public WebElement rowNewRequest;
		@FindBy(xpath="//table[@id='NewRequestsTable']//tbody//tr[1]//td[1]") public WebElement chevronFirstNewRqst;
		@FindBy(xpath="//table[@id='NewRequestsTable']//tbody//tr[1]//td[2]") public WebElement requestId;
		@FindBy(xpath="//table[@id='NewRequestsTable']//tbody//tr[@class='dataTableData col odd shown selected']//td//div[@title='Cancel']") public WebElement cancelBtn;
		public void clickOnRequest() throws InterruptedException {
			requestTab.click();
			Thread.sleep(5000);
		}
		
		public void cancelRequest() throws InterruptedException {
			System.out.println("request id is: " +requestId.getText());
			int rowNewRequest= driver.findElements(By.xpath("//table[@id='NewRequestsTable']//tbody//tr")).size();
			for(int i=1;i<=rowNewRequest;i++) {
				try {
				boolean cancelIcon=driver.findElement(By.xpath("//table[@id='NewRequestsTable']//tbody//tr["+Integer.toString(i)+"]//td//div[@title='Cancel']")).isDisplayed();
				if(cancelIcon==true) {
					//String newRequestId=driver.findElement(By.xpath("//table[@id='NewRequestsTable']//tbody//tr["+Integer.toString(i)+"]//td[2]")).getText();
					driver.findElement(By.xpath("//table[@id='NewRequestsTable']//tbody//tr["+Integer.toString(i)+"]//td[1]")).click();
					Thread.sleep(5000);
					cancelBtn.click();
					break;
				}
				}
				catch(Exception e)
				{
					continue;
				}
			}
			chevronFirstNewRqst.click();
			
            cancelBtn.click();
            Thread.sleep(5000);
          //table[@id='HandleRequestsTable']//tbody//tr[1]//td[2]
		}
}
