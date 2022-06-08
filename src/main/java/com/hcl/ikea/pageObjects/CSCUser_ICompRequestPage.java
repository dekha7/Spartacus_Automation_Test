package com.hcl.ikea.pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CSCUser_ICompRequestPage {
	public WebDriver driver;
	public static int firstExpandableRow=1;
	public CSCUser_ICompRequestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@id='changeUserRole']/ul/li/a/span")public WebElement role;
	@FindBy(xpath="//input[contains(@name,'txtSearch') and @id='Body_txtSearch']")
	public WebElement searchArticleComponentTxt;
	@FindBy(xpath="//input[contains(@name,'btnSearch') and @id='Body_btnSearch']")
	public WebElement searchArticleComponentBtn;
	@FindBy(xpath="//table[contains(@class,'dataTableSubDatacontainer Component')]//thead//tr//th[contains(text(),'Part No')]")public WebElement partNoHeading;
	@FindBy(xpath="//table[contains(@class,'dataTableSubDatacontainer')]//thead//th[text()='Store']")public WebElement Store;
	@FindBy(xpath="//table[contains(@class,'dataTableSubDatacontainer')]//thead//th[text()='Store']//parent::tr//parent::thead//parent::table//tbody//tr[1]//td[6]//div[@title='ASAP']")
	public WebElement icompBtn;
	@FindBy(xpath="//input[contains(@id,'Modal_chkForSale')]//following-sibling::label[normalize-space()='Against Warranty']")public WebElement warrantyRadio;
	//select[@id='Modal_ddlRequestReason']
	@FindBy(xpath="//select[@id='Modal_ddlRequestReason']")public WebElement iCompReason;
	@FindBy(xpath="//button[contains(text(),'Yes')]")public WebElement yesBtnToIcomp;
	@FindBy(xpath="//select[contains(@id,'CountryCode')]")public WebElement country;
	@FindBy(xpath="(//input[@type='number' and contains(@class,'salesQty')])[1]")public WebElement quantity;
	@FindBy(xpath="//button[@id='btnSubmit']")public WebElement submit;
	@FindBy(xpath="//button[contains(@class,'confirm') and normalize-space(.)='OK']") public WebElement okButn;
	@FindBy(xpath="ctl00$ddlStore")public WebElement storeID;
	
	public void cscICompRequest() throws Exception {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(role).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@id,'Repeater1_SwitchUserRole') and normalize-space()='CSC']")).click();
		Thread.sleep(2000);
		searchArticleComponentTxt.sendKeys("pax");
		searchArticleComponentBtn.click();
		Thread.sleep(3000);
		int rowNos= driver.findElements(By.xpath("//*[@id='tbl_Articles']/tbody/tr")).size();
//		int firstExpandableRow;
		WebElement expandBtn;
		for(int i=firstExpandableRow; i<=rowNos; i++) {
			try {
				expandBtn=  driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(i)+"]/td[1]"));
				expandBtn.click();
		    }catch(Exception e) {
		    	expandBtn=  driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(i-1)+"]/td[1]"));
		      JavascriptExecutor jse = (JavascriptExecutor)driver;
		      int y = expandBtn.getLocation().getY();
		  	  System.out.println("Y coordinate of expandBtn is "+y);
		  	  jse.executeScript("window.scrollBy(0,564)", " ");
		  	  expandBtn=  driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(i-1)+"]/td[1]"));
		  	  expandBtn.click();
		    }
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
		int size1stInnerRow=driver.findElements(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr")).size();
		for(int j=1;j<=size1stInnerRow;j++) {
			driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(j)+"]//td[1]")).click();
			try {
			   if(Store.isDisplayed()) {
				   String mainWindow= driver.getWindowHandle();
				   icompBtn.click();
				   Set<String> windows = driver.getWindowHandles();
				   Iterator<String> itr= windows.iterator();
				   while(itr.hasNext()) {
					   String window= itr.next();
					   if(window.equalsIgnoreCase(mainWindow)) {
						   driver.switchTo().window(mainWindow);
						   JavascriptExecutor jse = (JavascriptExecutor)driver;
						   jse.executeScript("arguments[0].click()", warrantyRadio);
//						   warrantyRadio.click();
						   Select reason = new Select(iCompReason);
						   reason.selectByIndex(1);
						   Thread.sleep(6000);
						   yesBtnToIcomp.click();
						   }
//			    	break;
			      }
			     }
			      break;
			   }
			   
			catch(Exception e) {
				if(j==size1stInnerRow) {
					driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(firstExpandableRow)+"]/td[1]")).click();
					firstExpandableRow=firstExpandableRow+1;
					cscICompRequest();
					break;
			}
		}

	}
  }
}	

