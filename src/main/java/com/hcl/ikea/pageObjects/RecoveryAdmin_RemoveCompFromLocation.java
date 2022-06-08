package com.hcl.ikea.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RecoveryAdmin_RemoveCompFromLocation {

	public WebDriver driver;

	public RecoveryAdmin_RemoveCompFromLocation(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='txtUser'] [@id='txtUser']") WebElement userName;
	@FindBy(xpath = "//div[@id='sidebar-wrapper']/ul/li[@class='manageLocation ']") public WebElement manageLocation;
	@FindBy(xpath="//span[contains(text(),'Component Inventory')]") public WebElement compInventory;
	@FindBy(xpath = "//span[contains(text(),'Component Replenishment')]")public WebElement compReplenishment;
	@FindBy(xpath="//input[contains(@name,'txtSearch') and @id='Body_txtSearch']")
	public WebElement searchArticleComponentTxt;
	@FindBy(xpath="//input[contains(@name,'btnSearch') and @id='Body_btnSearch']")
	public WebElement searchArticleComponentBtn; 
	@FindBy(xpath = "//div[@class = 'col-md-12 col-sm-12 col-lg-8 searchFormArea']/input[@type='submit']") public WebElement SearchButtonAddStock;
	@FindBy(xpath="//table[contains(@class,'dataTableSubDatacontainer Component')]//thead//tr//th[contains(text(),'Part No')]") public WebElement partNoHeading;
	@FindBy(xpath="(//span[@class='locationBox']//input[contains(@id,'Location') and @type='checkbox'])[1]") public WebElement firstLocationChkBx;
	@FindBy(xpath="(//span[@class='locationBox']//parent::div//following-sibling::div[1])[1]")public WebElement firstLocationDesc;
	@FindBy(xpath="(//span[@class='locationBox']//parent::div//following-sibling::div//following-sibling::div//child::div[1])[1]")public WebElement firstLocationStock;
	@FindBy(xpath="//table[@id='tbl_Articles']//tbody//tr//td[1]")public WebElement chevronFirstLocation;
	@FindBy(xpath="//table[contains(@class,'dataTableSubDatacontainer')]//thead//tr//th[contains(text(),'Part No')]") public WebElement partNoHeadings;
	@FindBy(xpath="//input[@type='submit' and @value='Show']") public WebElement showBtn;
//	@FindBy(xpath="//table[contains(@id,'DataTables_Table')]//tbody//tr") public WebElement rowNosOfPartsInLocation;
	@FindBy(xpath="(//table[contains(@id,'DataTables_Table')]//tbody//tr//td[7]//input[@title='Remove component'])[1]")public WebElement removeFirstCompChkBx;
//	@FindBy(xpath="//table[contains(@id,'DataTables_Table')]//tbody//tr") public WebElement rowNosOfPartsInLocation;
	@FindBy(xpath="(//table[contains(@id,'DataTables_Table')]//tbody//tr//td[2])[1]") public WebElement firstPartNumberInLocation;
	@FindBy(xpath="//table[contains(@id,'tbl_Articles')]//tbody//tr//td//div[@title='Remove component(s)']") public WebElement removeBtn;
	@FindBy(xpath="//div[contains(text(),'want to remove component')]//following-sibling::div//button[normalize-space()='OK']") public WebElement removeOK;
	
	public void clickOnTheLocation() throws InterruptedException {
		Actions ac = new Actions(driver);
		ac.moveToElement(manageLocation).click(manageLocation).perform();
		Thread.sleep(3000);
	}
	
	public void VerifyStoreNumbersINLocation() throws InterruptedException {
		firstLocationChkBx.click();
		String firstLocation=firstLocationDesc.getText().trim();
		int stockNo1stLocation=Integer.parseInt(firstLocationStock.getText().trim());
		showBtn.click();
		chevronFirstLocation.click();
		Thread.sleep(3000);
		partNoHeadings.isDisplayed();
		int rowNosOfPartsInLocation= driver.findElements(By.xpath("//table[contains(@id,'DataTables_Table')]//tbody//tr")).size();	
		Assert.assertEquals(stockNo1stLocation, rowNosOfPartsInLocation);
	}
	public void VerifyRemoveFirstComp() throws InterruptedException {
		String firstPartNoBeforeRemove=firstPartNumberInLocation.getText();
		removeFirstCompChkBx.click();
		removeBtn.click();
		removeOK.click();
		Thread.sleep(5000);
		firstLocationChkBx.click();
		showBtn.click();
		chevronFirstLocation.click();
		Thread.sleep(3000);
		String firstPartNoafterRemove=firstPartNumberInLocation.getText();
		Assert.assertNotEquals(firstPartNoBeforeRemove, firstPartNoafterRemove);
	}
	
}
