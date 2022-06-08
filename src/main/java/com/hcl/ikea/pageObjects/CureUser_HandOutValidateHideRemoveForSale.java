package com.hcl.ikea.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CureUser_HandOutValidateHideRemoveForSale {
	public WebDriver driver;
	public CureUser_HandOutValidateHideRemoveForSale(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@id='changeUserRole']/ul/li/a/span")
	public WebElement role;
	@FindBy(xpath="//input[contains(@name,'txtSearch') and @id='Body_txtSearch']")
	public WebElement searchArticleComponentTxt;
	@FindBy(xpath="//input[contains(@name,'btnSearch') and @id='Body_btnSearch']")
	public WebElement searchArticleComponentBtn;
	@FindBy(xpath="//table[contains(@class,'dataTableSubDatacontainer Component')]//thead//tr//th[contains(text(),'Part No')]")
	public WebElement partNoHeading;
	@FindBy(xpath="//div[@id='changeUserCountry']/ul/li/a/span")
	public WebElement country;
	@FindBy(xpath="ctl00$ddlStore")
    public WebElement storeID;
	@FindBy(xpath="//*[@id='modalRequest']/div[2]/div/div[3]/button[2]")
    public WebElement gotoRequestForm;
	@FindBy(xpath="//*[@id='Body_rptPartDetail_txtQty_0']")
	public WebElement quantity;
	@FindBy(xpath="//*[@id='Body_txtComment']")
	public WebElement comment;
	@FindBy(xpath="//*[@id='Body_ddlRequestReason']")
	public WebElement reason;
	@FindBy(xpath="//*[@id='Body_btnRequest']")
	public WebElement sendToRecovery;
	@FindBy(xpath="//h4[@class='modal-title' and @id='confirm-label']")
	public WebElement confirmModal;
	@FindBy(xpath="//*[@id=\"confirm\"]/div[2]/div/div[3]/button[2]")
	public WebElement cancelBtn;
	@FindBy(xpath="//label[contains(text(),'Against Warranty')]//preceding-sibling::input[@type='radio']")
	public WebElement warrantyRadio;
	
	public void handOutRequestValidateHideRemoveSale() throws Exception {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(role).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Repeater1_SwitchUserRole_2']")).click();
		//role.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
		Thread.sleep(1000);
		action.moveToElement(country).build().perform();
		Thread.sleep(2000);
		//country.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
		driver.findElement(By.xpath("//*[@id='Repeater2_SwitchUserCountry_0' and text()='AUSTRIA']")).click();
		Thread.sleep(2000);
		searchArticleComponentTxt.sendKeys("pax");
		searchArticleComponentBtn.click();
		Thread.sleep(3000);
		int rowNos= driver.findElements(By.xpath("//*[@id='tbl_Articles']/tbody/tr")).size();
		int firstExpandableRow=0;
		String partno1=null;
		String articleno=null;
		WebElement handOutBtn;
		for(int i=1; i<=rowNos; i++) {
		    driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(i)+"]/td[1]")).click();
		    try{
		    	if(partNoHeading.isDisplayed()) {
		    	firstExpandableRow=i;
				System.out.println("the first part-decribed row is "+firstExpandableRow);
				break;
		    	}
		    }catch(Exception e){
		    	System.out.println("No expendable row found for the row number "+i);
		    }
		}
		Thread.sleep(2000);
		int houtNo=driver.findElements(By.xpath("//img[@title='Hand-Out']//parent::div")).size();
		for(int j=1;j<=houtNo;j++) {
			String enable=driver.findElement(By.xpath("(//img[@title='Hand-Out']//parent::div)["+Integer.toString(j)+"]")).getAttribute("class");
			if(!enable.contains("disable")) {
				driver.findElement(By.xpath("(//img[@title='Hand-Out']//parent::div)["+Integer.toString(j)+"]")).click();
				break;
			}
		}
//		handOutBtn=driver.findElement(By.xpath(""));
//		handOutBtn.click();
		Thread.sleep(2000);
		gotoRequestForm.click();
		Thread.sleep(5000);
		String selected=warrantyRadio.getAttribute("checked");
		System.out.println("radio attribute: "+selected);
		Assert.assertEquals(selected, "true");
		
	}

}
