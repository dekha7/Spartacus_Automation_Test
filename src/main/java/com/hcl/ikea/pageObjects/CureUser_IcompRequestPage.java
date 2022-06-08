package com.hcl.ikea.pageObjects;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CureUser_IcompRequestPage {
  
	public WebDriver driver;
	public CureUser_IcompRequestPage(WebDriver driver) {
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
	@FindBy(xpath="//input[@name='quantity' and @id='txtIcompQty']")
    public WebElement quantity;
	@FindBy(xpath="//input[@name='ctl00$Modal$chkForSale' and @id='Modal_chkForSale_1']")
	public WebElement againstWarranty;
	@FindBy(xpath="//select[@name='ctl00$Modal$ddlRequestReason' and @id='Modal_ddlRequestReason']")
	public WebElement reason;
	@FindBy(xpath="//button[@onclick='iCompModalAction();']")
    public WebElement yesBtn;
	
	public void iCompRequest() throws Exception {
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
		searchArticleComponentTxt.sendKeys("pax");
		searchArticleComponentBtn.click();;
		Thread.sleep(3000);
		int rowNos= driver.findElements(By.xpath("//*[@id='tbl_Articles']/tbody/tr")).size();
		int firstExpandableRow=0;
		String partno1=null;
		String articleno=null;
		WebElement iCompBtn;
		for(int i=1; i<=rowNos; i++) {
		    driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(i)+"]/td[1]")).click();
		    try{
		    	if(partNoHeading.isDisplayed()) {
		    	firstExpandableRow=i;
				System.out.println("the first part-decribed row is "+firstExpandableRow);
				partno1=driver.findElement(By.xpath("(//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr)[1]//td[2]")).getText();
				articleno=driver.findElement(By.xpath("(//table[@id='tbl_Articles']//tbody//tr//td[contains(@class,' col-md-2 full-width fixLineHeight paddingFix')])["+Integer.toString(i+1)+"]")).getText();
				System.out.println("the partno for which iComp to be done "+partno1);
				System.out.println("the Article No for which component should be iComp "+articleno);
				break;
		    	}
		    }catch(Exception e){
		    	System.out.println("No expendable row found for the row number "+i);
		    }
		}
		Thread.sleep(2000);
		String parentWindow = driver.getWindowHandle();
		iCompBtn=driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr[1]/td[6]/div[2]"));
		iCompBtn.click();
		Thread.sleep(1000);
		quantity.click();
		quantity.sendKeys("3");
        againstWarranty.click();
		Select select = new Select(reason);
		select.selectByValue("2");
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", yesBtn);
		Set<String> s1 = driver.getWindowHandles();
		for(String s:s1) {
			if(!s.equalsIgnoreCase(parentWindow)) {
				driver.switchTo().window(s);
				driver.close();
				driver.switchTo().window(parentWindow);
				break;
			}
		}
	}

}
