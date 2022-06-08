package com.hcl.ikea.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class RecoveryAdmin_Validate_EOL_Management_Page {
		public WebDriver driver;

		public RecoveryAdmin_Validate_EOL_Management_Page(WebDriver driver) {
			this.driver = driver;
		    PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//input[@name='txtUser'] [@id='txtUser']")public WebElement userName;
		@FindBy(xpath="//span[@title='Range Management' and text()='Range Management']") public WebElement rangeManagementTab;
		@FindBy(xpath="") public WebElement rowNewRequest;
		@FindBy(xpath="//div[@id='sidebar-wrapper']/ul/li[5]/ul/li[2]/a/span") public WebElement endOfLifeManagementTab;
		@FindBy(xpath="//span[text()='>Country']") public WebElement countrySelection;
		@FindBy(xpath="//a[text()='AUSTRALIA']") public WebElement countryOption;
		@FindBy(xpath="//table[@id='DataTables_Table_1']/tbody/tr[1]/td[4]/input[1]") public WebElement deleteButton;
		@FindBy(xpath="//h4[@id='gridSystemModalLabel' and text()='View Details']") public WebElement viewDetailsPage;
		@FindBy(xpath="//div[@id='iKeaModal']/div[2]/div/div/button[@class='close']") public WebElement closeBtn;
		@FindBy(xpath="//table[@id='Body_gvCustomers']//tbody//tr[1]//td[1]") public WebElement chevronFirstNewRqst;
		@FindBy(xpath="//table[@id='Body_gvCustomers']//tbody//tr[1]//td[2]") public WebElement requestId;
		@FindBy(xpath="//table[@id='Body_gvCustomers']//tbody//tr[@class='dataTableData col odd shown selected']//td//div[@title='Cancel']") public WebElement cancelBtn;
		@FindBy(xpath="//table[@id='Body_gvCustomers']//tbody//tr[@class='dataTableData col odd shown selected']//td//div[@title='Preview']") public WebElement previewBtn;
		@FindBy(xpath="//p[text()='Are You Sure You want to perform this action ?']")  public WebElement deleteMessage;
		@FindBy(xpath="//button[@class='btn btn-ikeabrn confirm' and normalize-space()='OK']") public WebElement oKBtn;
		public void clickOnRequest() throws InterruptedException{ 	
		Actions action = new Actions(driver);
		Thread.sleep(4000);
		action.moveToElement(countrySelection).build().perform();
		countryOption.click();
		Thread.sleep(6000);
		action.moveToElement(rangeManagementTab).build().perform();
		//requestTab.click();
		action.moveToElement(endOfLifeManagementTab).build().perform();
		endOfLifeManagementTab.click();
		Thread.sleep(5000);
	}
		
		public void recoveryAdminEOLManagement() throws InterruptedException {
			int rowCComponents= driver.findElements(By.xpath("//table[@id='EndOfLifeMgmt']/tbody/tr")).size();
			WebElement deleteButton= null;
			for(int i=1;i<=rowCComponents;i++) {
			    JavascriptExecutor js = (JavascriptExecutor)driver;
			    js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//table[@id='EndOfLifeMgmt']/tbody/tr["+Integer.toString(i)+"]/td[contains(@class,'chevron')]")));
			    int rowSize=driver.findElements(By.xpath("//input[@value='Delete']")).size();
			    for(int j=1;j<=rowSize;j++) {
			    deleteButton= driver.findElement(By.xpath("(//input[@value='Delete'])["+Integer.toString(j)+"]"));
			    if(deleteButton.isEnabled()) {
			    	Thread.sleep(3000);
					deleteButton.click();
					Thread.sleep(3000);
					deleteMessage.isDisplayed();
					oKBtn.click();
					break;
			     }
			    }
			    try {
			    if(deleteMessage.isDisplayed()) {
				oKBtn.click();
				break;
			    }
			    }catch(Exception e) {
			    	Thread.sleep(4000);
					js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//table[@id='EndOfLifeMgmt']/tbody/tr["+Integer.toString(i)+"]/td[contains(@class,'chevron')]")));
			    }
				Thread.sleep(4000);
			}
		}
}
