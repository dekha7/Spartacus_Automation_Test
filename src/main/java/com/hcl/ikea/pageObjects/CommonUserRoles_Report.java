package com.hcl.ikea.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CommonUserRoles_Report {

	public WebDriver driver;

	public CommonUserRoles_Report(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@id='sidebar-wrapper']/ul/li/a/span[@title='Reports']")public  WebElement reportTab;
	@FindBy(xpath="//select[@id='Body_CountryCode']")public WebElement countryDrpDwn;
	@FindBy(xpath="//span[normalize-space()='Select Store']")public WebElement storeSelectBtn;
	@FindBy(xpath="//span[normalize-space()='Select Store']//parent::button//parent::div//ul//li//label[@class='checkbox']//input[contains(@value,'385')]")public WebElement store385checkBX;
	@FindBy(xpath="//input[contains(@class,'txtFrom calender')]")public WebElement fromCalender;
	@FindBy(xpath="//a[contains(@class,'datepicker')]//span[normalize-space()='Prev']")public WebElement prevMonthBtn;
	@FindBy(xpath="//table[contains(@class,'datepicker-calendar')]//tbody//tr//td[normalize-space()='1']")public WebElement date1stOfMonth;
	@FindBy(xpath="//input[contains(@class,'txtTo calender')]")public WebElement toCalender;
	@FindBy(xpath="//a[contains(@class,'datepicker')]//span[normalize-space()='Next']")public WebElement nextMonthBtn;
	@FindBy(xpath="//span[normalize-space()='Financial Report']") public WebElement financialReport;
	@FindBy(xpath="//a[@id='Body_DetailHandOut' and normalize-space()='Details on savings done by Hand-Out']")public WebElement handOutFinancialReport;
	@FindBy(xpath="//input[@value='Export to csv']")  public WebElement exportCSV;
	@FindBy(xpath="//input[@value='Export to excel']")  public WebElement exportExcel;
	
	public void verifyReport() throws Exception {
		Actions action = new Actions(driver);
//		action.moveToElement(reportTab).click(reportTab);
		JavascriptExecutor jse=  (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", reportTab);
//		reportTab.click();
		Thread.sleep(3000);
		Select cntry= new Select(countryDrpDwn);
        cntry.selectByVisibleText("Australia");
        storeSelectBtn.click();
        store385checkBX.click();
        fromCalender.click();
        for(int i=1;i<=24;i++) {
        	prevMonthBtn.click();	
        }
        date1stOfMonth.click();
        toCalender.click();
        date1stOfMonth.click();
        action.moveToElement(financialReport).click(financialReport).perform();;
        Thread.sleep(5000);
        action.moveToElement(handOutFinancialReport).click(handOutFinancialReport).perform();;
//        jse.executeScript("arguments[0].click()", handOutFinancialReport);
        Thread.sleep(5000);
        exportCSV.isDisplayed();
        exportExcel.isDisplayed();
        exportExcel.click();
	}
}
