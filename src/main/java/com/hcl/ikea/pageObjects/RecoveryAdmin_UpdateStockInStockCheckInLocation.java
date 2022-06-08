package com.hcl.ikea.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RecoveryAdmin_UpdateStockInStockCheckInLocation {

	public WebDriver driver;

	public RecoveryAdmin_UpdateStockInStockCheckInLocation(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='txtUser'] [@id='txtUser']") WebElement userName;
	@FindBy(xpath = "//div[@id='sidebar-wrapper']/ul/li[@class='manageLocation ']") public WebElement location;
	@FindBy(xpath= "(//div[contains(@class,'stockCheck flag')])[1]") public WebElement firstLocationFlag;
	@FindBy(xpath="//a[@id='Body_StockCheckBtn']") public WebElement stockCheckBtn;
	@FindBy(xpath="(//span[@class='locationBox']//input[contains(@id,'Location') and @type='checkbox'])[1]") public WebElement firstLocationChkBx;
	@FindBy(xpath="(//span[@class='locationBox']//parent::div//following-sibling::div[1])[1]")public WebElement firstLocationDesc;
	@FindBy(xpath="(//span[@class='locationBox']//parent::div//following-sibling::div//following-sibling::div//child::div[1])[1]")public WebElement firstLocationStock;
	@FindBy(xpath="(//div[contains(@class,'dataTableData')])[1]//div[contains(@class,'chevron')]")public WebElement chevron1stLocInStockCheck;
	@FindBy(xpath="(//input[contains(@id,'Body_rptLocation') and @type='text'])[1]//parent::div//parent::div//parent::div//span[contains(@id,'lblStock')]") public WebElement firstPartStockNo;
	@FindBy(xpath="(//input[contains(@id,'Body_rptLocation') and @type='text'])[1]") public WebElement firstPartNewStockNoTextBx;
	@FindBy(xpath="//input[@id='Body_lnkSave']") public WebElement saveToUpdateStock;
	@FindBy(xpath="//table[contains(@class,'dataTableSubDatacontainer')]//thead//tr//th[contains(text(),'Part No')]") public WebElement partNoHeadings;
	@FindBy(xpath="//input[@type='submit' and @value='Show']") public WebElement showBtn;
	@FindBy(xpath="(//table[contains(@id,'DataTables_Table')]//tbody//tr//td[2])[1]") public WebElement firstPartNumberInLocation;
//	@FindBy(xpath="//table[contains(@id,'DataTables_Table')]//tbody//tr") public WebElement rowNosOfPartsInLocation;
    @FindBy(xpath="(//table[contains(@id,'DataTables_Table')]//tbody//tr//td[6]//button[@class='locChange'])[1]") public WebElement firstPartMoveFromLocation;
	@FindBy(xpath="//h4[contains(text(),'Move Part To Another Location')]//parent::div//parent::div//div//button[normalize-space()='Save']") public WebElement saveBtn;
	@FindBy(xpath="//p[text()='Part moved to new location successfully.' and @class='message']") public WebElement partMoveSuccessMsg;
	@FindBy(xpath="//p[text()='Part moved to new location successfully.' and @class='message']//parent::div//following-sibling::div//button[normalize-space()='OK']") public WebElement partMoveSuccessOKBtn;
    
	public void clickOnTheLocation() throws InterruptedException {
		Actions ac = new Actions(driver);
		ac.moveToElement(location).click(location).perform();
		Thread.sleep(3000);
	}
	
	public void verifyStockChkBtnAndUnFlagLocations() throws InterruptedException {
		try {
			if(stockCheckBtn.isDisplayed()) {
				int flagCount=driver.findElements(By.xpath("(//div[contains(@class,'stockCheck flag')])")).size();
				for(int i=1;i<=flagCount;i++) {
					String atrribute=driver.findElement(By.xpath("(//div[contains(@class,'stockCheck flag')])["+Integer.toString(i)+"]")).getAttribute("class");
					if(atrribute.contains("Inventory selected")) {
						JavascriptExecutor jse = (JavascriptExecutor)driver;
						jse.executeScript("arguments[0].click()", driver.findElement(By.xpath("(//div[contains(@class,'stockCheck flag')])["+Integer.toString(i)+"]")));
						Thread.sleep(3000);
					}
				}
			}
	      }  catch(Exception e) {
	   
	    }
	}
			
	 public void verifyUpdateStockFor1stLocation() throws InterruptedException {
			firstLocationFlag.click();
			Thread.sleep(3000);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click()",stockCheckBtn);
//			stockCheckBtn.click();
			Thread.sleep(3000);
			chevron1stLocInStockCheck.click();
			int beforeStockCount=Integer.parseInt(firstPartStockNo.getText());
			firstPartNewStockNoTextBx.clear();
			firstPartNewStockNoTextBx.sendKeys("5");
			saveToUpdateStock.click();
			Thread.sleep(8000);
			if(!firstLocationFlag.getAttribute("class").contains("Inventory selected")) {
			firstLocationFlag.click();
			}
//			stockCheckBtn.click();
			jse.executeScript("arguments[0].click()",stockCheckBtn);
			Thread.sleep(3000);
			chevron1stLocInStockCheck.click();
			int aftereStockCount=Integer.parseInt(firstPartStockNo.getText());
			Assert.assertEquals(5, aftereStockCount);
		}
	}

