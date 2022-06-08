package com.hcl.ikea.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class RecoveryAdmin_Preview_Request_Page {
		public WebDriver driver;

		public RecoveryAdmin_Preview_Request_Page(WebDriver driver) {
			this.driver = driver;
		    PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//input[@name='txtUser'] [@id='txtUser']")public WebElement userName;
		@FindBy(xpath="//a//span[normalize-space(.)='Requests' and @title='Requests']") public WebElement requestTab;
		@FindBy(xpath="") public WebElement rowNewRequest;
		@FindBy(xpath="//div[@id='sidebar-wrapper']/ul/li[2]/ul/li[1]/a/span") public WebElement newRequestTab;
		@FindBy(xpath="//span[text()='>Country']") public WebElement countrySelection;
		@FindBy(xpath="//a[text()='AUSTRALIA']") public WebElement countryOption;
		@FindBy(xpath="//h4[@id='gridSystemModalLabel' and text()='View Details']") public WebElement viewDetailsPage;
		@FindBy(xpath="//div[@id='iKeaModal']/div[2]/div/div/button[@class='close']") public WebElement closeBtn;
		@FindBy(xpath="//table[@id='Body_gvCustomers']//tbody//tr[1]//td[1]") public WebElement chevronFirstNewRqst;
		@FindBy(xpath="//table[@id='Body_gvCustomers']//tbody//tr[1]//td[2]") public WebElement requestId;
		@FindBy(xpath="//table[@id='Body_gvCustomers']//tbody//tr[@class='dataTableData col odd shown selected']//td//div[@title='Cancel']") public WebElement cancelBtn;
		@FindBy(xpath="//table[@id='Body_gvCustomers']//tbody//tr[@class='dataTableData col odd shown selected']//td//div[@title='Preview']") public WebElement previewBtn;
		public void clickOnRequest() throws InterruptedException{ 	
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
		
		public void recoveryAdminPreviewRequest() throws InterruptedException {
			System.out.println("request id is: " +requestId.getText());
			int rowNewRequest= driver.findElements(By.xpath("//table[@id='Body_gvCustomers']//tbody//tr")).size();
			for(int i=1;i<=rowNewRequest;i++) {
				try {
				boolean previewIcon=driver.findElement(By.xpath("//table[@id='Body_gvCustomers']/tbody/tr[\"+Integer.toString(i)+\"]/td/div[@title='Preview']")).isDisplayed();
				if(previewIcon==true) {
					//String newRequestId=driver.findElement(By.xpath("//table[@id='NewRequestsTable']//tbody//tr["+Integer.toString(i)+"]//td[2]")).getText();
					driver.findElement(By.xpath("//table[@id='Body_gvCustomers']//tbody//tr[\"+Integer.toString(i)+\"]//td[1]")).click();
					Thread.sleep(2000);
					previewBtn.click();
					previewBtn.click();
					Thread.sleep(1000);
					if(viewDetailsPage.isDisplayed()) {
						closeBtn.click();
					}
					break;
				}
				}
				catch(Exception e)
				{
					continue;
				}
			}
		}
}
