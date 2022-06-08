package com.hcl.ikea.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CureUser_PreviewRequestPage {
  
	public WebDriver driver;
	public CureUser_PreviewRequestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@id='changeUserRole']/ul/li/a/span")
	public WebElement role;
	@FindBy(xpath="//input[contains(@name,'txtSearch') and @id='Body_txtSearch']")
	public WebElement searchArticleComponentTxt;
	@FindBy(xpath="//input[contains(@name,'btnSearch') and @id='Body_btnSearch']")
	public WebElement searchArticleComponentBtn;
	@FindBy(xpath="//div[@id='sidebar-wrapper']/ul/li[3]")
	public WebElement requests;
	@FindBy(xpath="//div[@id='changeUserCountry']/ul/li/a/span")
	public WebElement country;
	@FindBy(xpath="ctl00$ddlStore")
    public WebElement storeID;
    @FindBy(xpath="//table[@id='DataTables_Table_0']//thead//tr//th[contains(text(),'Part No')]")
    public WebElement partNoHeading;
	@FindBy(xpath="//div[@id='sidebar']/div[@class='c01147']/div/button[1]/span")
	public WebElement printBtn;
	@FindBy(xpath="//div[@id='iKeaModal']/div[2]/div/div/button")
    public WebElement modalCloseBtn;
	@FindBy(xpath="//h4[@id='gridSystemModalLabel']")
    public WebElement modalTitle;
	@FindBy(xpath="//div[@id='confirm']/div[2]/div/div[2]/p")
	public WebElement confirmModalMessage;
	@FindBy(xpath="//select[contains(@name,'RequestReason') and @id='Body_ddlRequestReason']")
	public WebElement reason2;
	@FindBy(xpath="//div[@id='confirm']//div[3]/button[1]")
	public WebElement modalConfirmOkBtn;
	@FindBy(xpath="//div[@id='confirm']/div[2]/div/child::div[3]/button[2]")
	public WebElement modalConfirmCancelBtn;
	@FindBy(xpath="//span[contains(text(),'New Requests')]")
	public WebElement newRequests;
	
	@SuppressWarnings("unlikely-arg-type")
	public void previewRequest() throws Exception {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(role).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Repeater1_SwitchUserRole_2']")).click();
		Thread.sleep(1000);
		action.moveToElement(country).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='AUSTRIA']")).click();
		Thread.sleep(2000);
		action.moveToElement(requests).build().perform();
		Thread.sleep(4000);
		action.moveToElement(newRequests).build().perform();
		Thread.sleep(2000);
		newRequests.click();
		Thread.sleep(3000);
		WebElement previewRequestBtn;
		driver.findElement(By.xpath("//table[@id='Body_gvCustomers']/tbody/tr[1]/td[1]")).click();
		Thread.sleep(1000);
		previewRequestBtn=driver.findElement(By.xpath("//table[@id='Body_gvCustomers']/tbody/tr[1]/td[11]/div[contains(@class,'actButton edit')]"));
		action.moveToElement(previewRequestBtn).build().perform();
		Thread.sleep(1000);
		previewRequestBtn.click();
		Thread.sleep(2000);
		if(driver.getTitle().equals(modalTitle)) {
			modalCloseBtn.click();
		}
	}

}
