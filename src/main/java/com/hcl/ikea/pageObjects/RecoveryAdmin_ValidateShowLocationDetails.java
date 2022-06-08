package com.hcl.ikea.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RecoveryAdmin_ValidateShowLocationDetails {

	public WebDriver driver;

	public RecoveryAdmin_ValidateShowLocationDetails(WebDriver driver) {
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
	
	public void clickOnTheLocation() throws InterruptedException {
		Actions ac = new Actions(driver);
		ac.moveToElement(manageLocation).click(manageLocation).perform();
		Thread.sleep(3000);
	}
	
	public void VerifyStoreNumbersINLocation() throws InterruptedException {
		firstLocationChkBx.click();
		String firstLocation=firstLocationDesc.getText().trim();
		int stockNo1stLocation=Integer.parseInt(firstLocationStock.getText().trim());
		JavascriptExecutor js2 = (JavascriptExecutor)driver;
		js2.executeScript("arguments[0].click()", showBtn);
		chevronFirstLocation.click();
		Thread.sleep(3000);
		partNoHeadings.isDisplayed();
		int rowNosOfPartsInLocation= driver.findElements(By.xpath("//table[contains(@id,'DataTables_Table')]//tbody//tr")).size();	
		Assert.assertEquals(stockNo1stLocation, rowNosOfPartsInLocation);
	}
	
}
