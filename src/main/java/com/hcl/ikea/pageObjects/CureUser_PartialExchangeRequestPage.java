package com.hcl.ikea.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CureUser_PartialExchangeRequestPage {
  
	public WebDriver driver;
	public CureUser_PartialExchangeRequestPage(WebDriver driver) {
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
    @FindBy(xpath="//div[@id='PartialExchangeModal']/div[2]/div/child::div[3]/a")
    public WebElement goToRequestFormCTA;
	@FindBy(xpath="//input[@id='Body_rptPartDetail_txtQty_0']")
	public WebElement quantity;
	@FindBy(xpath="//select[@name='ctl00$Modal$ddlReasons_iCompOrderFailed' and @id='Modal_ddlReasons_iCompOrderFailed']")
    public WebElement reason1;
	@FindBy(xpath="//*[@id='modalRequest']/div[2]/div/div[3]/button[2]")
    public WebElement gotoRequestForm;
	@FindBy(xpath="//table[@id='DataTables_Table_10']/tbody/tr[1]/td[1]/following-sibling::td[5]/div/label")
	public WebElement plusbtn;
	@FindBy(xpath="//textarea[@id='Body_txtComment']")
	public WebElement comment;
	@FindBy(xpath="//select[@name='ctl00$Body$ddlRequestReason' and @id='Body_ddlRequestReason']")
	public WebElement reason2;
	@FindBy(xpath="//input[@id='Body_btnRequest']")
	public WebElement sendRequestToRecovery;
	@FindBy(xpath="//div[@id='confirm']/div[2]/div/child::div[3]/button[2]")
	public WebElement confirmCancelBtn;
	
	public void partialExchangeRequest() throws Exception {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(role).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Repeater1_SwitchUserRole_2' and text()='CuRe']")).click();
		Thread.sleep(1000);
		action.moveToElement(country).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='AUSTRIA']")).click();
		Thread.sleep(2000);
		searchArticleComponentTxt.sendKeys("pax");
		searchArticleComponentBtn.click();
		Thread.sleep(3000);
		int rowNos= driver.findElements(By.xpath("//*[@id='tbl_Articles']/tbody/tr")).size();
		int firstExpandableRow=0;
		String partno1=null;
		String articleno=null;
		WebElement partialExchangeBtn;
		for(int i=1; i<=rowNos; i++) {
		    driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(i)+"]/td[1]")).click();
		    try{
		    	if(partNoHeading.isDisplayed()) {
		    	firstExpandableRow=i;
				System.out.println("the first part-decribed row is "+firstExpandableRow);
				partno1=driver.findElement(By.xpath("(//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr)[1]//td[2]")).getText();
				articleno=driver.findElement(By.xpath("(//table[@id='tbl_Articles']//tbody//tr//td[contains(@class,' col-md-2 full-width fixLineHeight paddingFix')])["+Integer.toString(i+1)+"]")).getText();
				System.out.println("the partno for which issue report to be done "+partno1);
				System.out.println("the Article No for which component should be issue report "+articleno);
				break;
		    	}
		    }catch(Exception e){
		    	System.out.println("No expendable row found for the row number "+i);
		    }
		}
		Thread.sleep(2000);
		partialExchangeBtn=driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr[1]/td[5]/div[2]"));
		partialExchangeBtn.click();
		Thread.sleep(1000);
		plusbtn.click();
		Thread.sleep(3000);
		gotoRequestForm.click();
		Thread.sleep(2000);
		Select select = new Select(reason1);
		select.selectByValue("2");
		goToRequestFormCTA.click();
		Thread.sleep(1000);
		quantity.click();
		quantity.sendKeys("1");
		comment.click();
		comment.sendKeys("Test123456");
		Thread.sleep(2000);
		Select sel = new Select(reason2);
		sel.selectByValue("2");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", sendRequestToRecovery);
		Thread.sleep(1000);
		confirmCancelBtn.click();
	}

}
