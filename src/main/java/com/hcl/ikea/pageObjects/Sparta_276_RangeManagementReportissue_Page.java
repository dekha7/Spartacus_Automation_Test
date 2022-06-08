package com.hcl.ikea.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Sparta_276_RangeManagementReportissue_Page {
  
	public WebDriver driver;
	public Sparta_276_RangeManagementReportissue_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@id='changeUserRole']/ul/li/a/span")
	public WebElement role;
	@FindBy(xpath="//input[@name='ctl00$Body$txtSearch' and @id='Body_txtSearch']")
	public WebElement searchTextField;
	@FindBy(xpath="//input[@name='ctl00$Body$btnSearch' and @id='Body_btnSearch']")
	public WebElement searchButton;
	@FindBy(xpath="//table[contains(@class,'dataTableSubDatacontainer Component')]//thead//tr//th[contains(text(),'Part No')]")
	public WebElement partNoHeading;
	@FindBy(xpath="//div[@id='changeUserCountry']/ul/li/a/span")
	public WebElement country;
	@FindBy(xpath="//select[@id='ddlStore']")
    public WebElement storeID;
	@FindBy(xpath="//*[@id='modalRequest']/div[2]/div/div[3]/button[2]")
    public WebElement gotoRequestForm;
	@FindBy(xpath="//*[@id='Body_rptPartDetail_txtQty_0']")
	public WebElement quantity;
	@FindBy(xpath="//*[@id='Body_txtComment']")
	public WebElement comment;
	@FindBy(xpath="//*[@id='Body_ddlRequestReason']")
	public WebElement reason;
	@FindBy(xpath="//*//div[@id='sidebar-wrapper']/ul/li[5]")
	public WebElement rangeManagTab;
	@FindBy(xpath="//div[@id='sidebar-wrapper']/ul/li[5]/ul/li/a/span[contains(text(),'Phase-In')]")
	public WebElement phaseInPhaseOut;
	@FindBy(xpath="//div[@id='PhaseInPhaseOutTable_wrapper']/div[1]/div/div/table/thead/tr/th[2]")
	public WebElement partName;
	
	public void phaseInPhaseOutClick() throws Exception {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(role).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Repeater1_SwitchUserRole_0']")).click();
		//role.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
		Thread.sleep(1000);
		action.moveToElement(country).build().perform();
		Thread.sleep(2000);
		//country.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
		driver.findElement(By.xpath("//*[text()='ROMANIA']")).click();
		Thread.sleep(2000);
		action.moveToElement(storeID).build().perform();
		Select sel =new Select(storeID);
		sel.selectByValue("059");
		Thread.sleep(1000);
		rangeManagTab.click();
		Thread.sleep(1000);
		phaseInPhaseOut.click();
		Thread.sleep(1000);
	if(partName.getText().equals("C Component")) {
		Assert.assertTrue(true);
	}else {
		Assert.assertTrue(false);
		}
	}
}
