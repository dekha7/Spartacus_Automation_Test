package com.hcl.ikea.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecoveryUser_AcceptRequestPage {
  
	public WebDriver driver;
	public RecoveryUser_AcceptRequestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@id='changeUserRole']/ul/li/a/span")
	public WebElement role;
	@FindBy(xpath="//input[contains(@name,'txtSearch') and @id='Body_txtSearch']")
	public WebElement searchArticleComponentTxt;
	@FindBy(xpath="//input[contains(@name,'btnSearch') and @id='Body_btnSearch']")
	public WebElement searchArticleComponentBtn;
	@FindBy(xpath="//div[@id='sidebar-wrapper']/ul/li[2]")
	public WebElement requests;
	@FindBy(xpath="//div[@id='changeUserCountry']/ul/li/a/span")
	public WebElement country;
	@FindBy(xpath="ctl00$ddlStore")
    public WebElement storeID;
    @FindBy(xpath="//table[@id='DataTables_Table_0']//thead//tr//th[contains(text(),'Part No')]")
    public WebElement partNoHeading;
	@FindBy(xpath="//div[@id='TrackCompModalHistory']/div/div/div/button")
    public WebElement modalCloseBtn;
	@FindBy(xpath="//div[@id='confirm']/div[2]/div/div[2]/p")
	public WebElement confirmModalMessage;
	@FindBy(xpath="//select[@name='ctl00$Body$ddlRequestReason' and @id='Body_ddlRequestReason']")
	public WebElement reason2;
	@FindBy(xpath="//div[@id='confirm']//div[3]/button[1]")
	public WebElement modalConfirmOkBtn;
	@FindBy(xpath="//div[@id='confirm']/div[2]/div/child::div[3]/button[2]")
	public WebElement modalConfirmCancelBtn;
	@FindBy(xpath="") public WebElement rowNewRequest;
	@FindBy(xpath="//table[@id='NewRequestsTable']//tbody//tr[1]//td[1]") public WebElement chevronFirstNewRqst;
	@FindBy(xpath="//table[@id='Body_gvCustomers']/tbody/tr[1]/td[2]") public WebElement requestId;
	@FindBy(xpath="//table[@id='NewRequestsTable']//tbody//tr[@class='dataTableData col odd shown selected']/td[9]/div[@title='Accept']") public WebElement acceptBtn;
	
	@SuppressWarnings("unlikely-arg-type")
	public void acceptRequest() throws Exception {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(role).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Recovery']")).click();
		Thread.sleep(1000);
		action.moveToElement(country).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Repeater2_SwitchUserCountry_0']")).click();
		Thread.sleep(1000);
		System.out.println("request id is: " +requestId.getText());
		int rowNewRequest= driver.findElements(By.xpath("//table[@id='Body_gvCustomers']//tbody//tr")).size();
		for(int i=1;i<=rowNewRequest;i++) {
			try {
			boolean acceptIcon=driver.findElement(By.xpath("//table[@id='Body_gvCustomers']//tbody//tr["+Integer.toString(i)+"]//td//div[@title='Accept']")).isDisplayed();
			if(acceptIcon==true) {
				//String newRequestId=driver.findElement(By.xpath("//table[@id='NewRequestsTable']//tbody//tr["+Integer.toString(i)+"]//td[2]")).getText();
				driver.findElement(By.xpath("//table[@id='Body_gvCustomers']//tbody//tr["+Integer.toString(i)+"]//td[1]")).click();
				Thread.sleep(1000);
				acceptBtn.click();
				break;
			}
			}
			catch(Exception e)
			{
				continue;
			}
		}
		//chevronFirstNewRqst.click();
        //acceptBtn.click();
        Thread.sleep(5000);
		if(confirmModalMessage.getText().equals("Confirm the selected request?")) {
			modalConfirmOkBtn.click();
		}else {
			modalConfirmCancelBtn.click();
		}
	}

}
