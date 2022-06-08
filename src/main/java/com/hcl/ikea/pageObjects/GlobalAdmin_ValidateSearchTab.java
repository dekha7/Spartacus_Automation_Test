package com.hcl.ikea.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GlobalAdmin_ValidateSearchTab {

	public WebDriver driver;
	public GlobalAdmin_ValidateSearchTab(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@id='changeUserRole']/ul/li/a/span")
	public WebElement role;
	@FindBy(xpath="//span[@title='Change Country']")
	public WebElement countrySwitch;
	@FindBy(xpath="//a[contains(@id,'Repeater1_SwitchUserRole') and normalize-space()='GlobalAdmin']")
	public WebElement globalAdminRole;
	@FindBy(xpath="//input[contains(@name,'txtSearch') and @id='Body_txtSearch']")
	public WebElement searchArticleComponentTxt;
	@FindBy(xpath="//input[contains(@name,'btnSearch') and @id='Body_btnSearch']")
	public WebElement searchArticleComponentBtn;
	@FindBy(xpath="//table[contains(@class,'dataTableSubDatacontainer Component')]//thead//tr//th[contains(text(),'Part No')]") public WebElement partNoHeading;
	@FindBy(xpath="//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr//td[1]") public WebElement compChevron;
	@FindBy(xpath="//table[contains(@class,'dataTableSubDatacontainer')]//thead//th[text()='Store']")public WebElement Store;

	public void validateSearchTabGlobalAdmin() throws Exception {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(role).build().perform();
		Thread.sleep(2000);
		globalAdminRole.click();
		Thread.sleep(1000);
		searchArticleComponentTxt.sendKeys("pax");
		searchArticleComponentBtn.click();
		int rowNos=driver.findElements(By.xpath("//table[@id='tbl_Articles']/tbody/tr")).size();
		int firstExpandableRow=0;
		for(int i=1;i<=rowNos;i++) {
			driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(i)+"]/td[1]")).click();
			try {
				if(partNoHeading.isDisplayed()) {
					firstExpandableRow=i;
					System.out.println("the first part-decribed row is "+firstExpandableRow);
					int compRowNos=driver.findElements(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr")).size();
					for(int j=1;j<=compRowNos;j++) {
						driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(j)+"]//td[1]")).click();
//						compChevron.click();
						try {
						if(Store.isDisplayed()) {
							int storeRowSize=driver.findElements(By.xpath("//table[contains(@class,'dataTableSubDatacontainer')]//thead//th[text()='Store']//parent::th//parent::tr//parent::thead//parent::table//tbody//tr")).size();
							int storeCount=0;
							for(int k=1;k<=storeRowSize;k++) {
								int stockInStore=Integer.parseInt(driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer')]//thead//th[text()='Store']//parent::th//parent::tr//parent::thead//parent::table//tbody//tr["+Integer.toString(k)+"]//td[5]")).getText());
								storeCount=storeCount+stockInStore;
								Thread.sleep(4000);
								System.out.println("store rowNo : "+k+" count : "+stockInStore+" total count: "+storeCount);	
							}
							Assert.assertNotEquals(0, storeCount);
							break;
						}
						 }catch(Exception e){
					    	 
			             }
						
					}
					
	              }
				}catch(Exception e){
	    	 
	             }
			break;
       }
		}
	}

