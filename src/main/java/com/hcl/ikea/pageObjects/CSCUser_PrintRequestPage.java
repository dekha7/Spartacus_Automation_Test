package com.hcl.ikea.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CSCUser_PrintRequestPage {

	public WebDriver driver;
	public CSCUser_PrintRequestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@id='changeUserRole']/ul/li/a/span")public WebElement role;
	@FindBy(xpath="//input[@name='ctl00$Body$txtSearch' and @id='Body_txtSearch']")public WebElement searchTextField;
	@FindBy(xpath="//input[@name='ctl00$Body$btnSearch' and @id='Body_btnSearch']")public WebElement searchButton;
	@FindBy(xpath="//input[@name='txtUser'] [@id='txtUser']")public WebElement userName;
	@FindBy(xpath="//a//span[normalize-space(.)='Requests' and @title='Requests']") public WebElement requestTab;
	@FindBy(xpath="//table[@id='Body_gvCustomers']//tbody//tr//td[text()='No Records Found']") public WebElement NoNewRequest;
	@FindBy(xpath="//div[@id='sidebar-wrapper']/ul/li[3]/ul/li[1]/a/span") public WebElement newRequestTab;
	@FindBy(xpath="//a[text()='United Kingdom']") public WebElement countryOption;
	@FindBy(xpath="//span[text()='>Country']") public WebElement changeCountry;
	@FindBy(xpath="//table[@id='NewRequestsTable']//tbody//tr[1]//td[1]") public WebElement chevronFirstNewRqst;
	@FindBy(xpath="//table[@id='Body_gvCustomers']//tbody//tr[1]//td[2]") public WebElement firstRequestId;
	@FindBy(xpath="//table[@id='Body_gvCustomers']//tbody//tr[contains(@class,'selected')]//td//div[@title='Print']") public WebElement printBtn;
	@FindBy(xpath="//button[@class='btn btn-ikeabrn confirm' and normalize-space()='OK']")public WebElement okBtn;
	
	public void printRequestMethod() throws InterruptedException {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(role).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='Repeater1_SwitchUserRole_3']")).click();
		Thread.sleep(1000);
		action.moveToElement(changeCountry).build().perform();
		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("arguments[0].click()", countryOption);
		Thread.sleep(1000);
		action.moveToElement(requestTab).build().perform();
		Thread.sleep(1000);
		newRequestTab.click();
		Thread.sleep(5000);
		int rowNewRequest= driver.findElements(By.xpath("//table[@id='Body_gvCustomers']//tbody//tr")).size();
		for(int i=1;i<=rowNewRequest;i++) {
			try {
			driver.findElement(By.xpath("//table[@id='Body_gvCustomers']//tbody//tr[\"+Integer.toString(i)+\"]//td[1]")).click();
			boolean printIcon=driver.findElement(By.xpath("//table[@id='Body_gvCustomers']//tbody//tr[\"+Integer.toString(i)+\"]//td//div[@title='Print']")).isDisplayed();
			if(printIcon==true) {
				JavascriptExecutor jse = (JavascriptExecutor)driver;
	            Thread.sleep(5000);
	            jse.executeScript("arguments[0].click()", printBtn);
				okBtn.click();
				break;
			}
			break;
			}
			catch(Exception e1)
			{
				break;
//				continue;
			}
		}
	}
	}