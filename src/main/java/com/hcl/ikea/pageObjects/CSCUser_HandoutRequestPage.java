package com.hcl.ikea.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CSCUser_HandoutRequestPage {
  
	public WebDriver driver;
	public static int firstExpandableRow=1;
	public CSCUser_HandoutRequestPage(WebDriver driver) {
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
	@FindBy(xpath="//select[contains(@id,'CountryCode')]")public WebElement country;
	@FindBy(xpath="(//input[@type='number' and contains(@class,'salesQty')])[1]")public WebElement quantity;
	@FindBy(xpath="//button[@id='btnSubmit']")public WebElement submit;
	@FindBy(xpath="//button[contains(@class,'confirm') and normalize-space(.)='OK']") public WebElement okButn;
	@FindBy(xpath="ctl00$ddlStore")public WebElement storeID;
	@FindBy(xpath="//table[@id='DataTables_Table_2']/tbody/tr[1]/td[6]/div[2]")public WebElement reserveCta;
	@FindBy(xpath="//table[@id='DataTables_Table_0']/tbody/tr[1]/td[6]/input")public WebElement quantity1;
	@FindBy(xpath="//table[@id='DataTables_Table_0']/tbody/tr[4]/td[6]/input")public WebElement quantity2;
	@FindBy(xpath="//textarea[contains(@class,'AdditionalComment')]")public WebElement comment;
	@FindBy(xpath="//*[@id='Body_ddlRequestReason']")public WebElement reason;
	@FindBy(xpath="//button[@id='btnSubmit']")public WebElement submitRequest;
	@FindBy(xpath="//h4[@id='confirm-label']")public WebElement confirmModalTitle;
	@FindBy(xpath="//div[@id='confirm']/div[2]/div/div[3]/button[2]")public WebElement cancelBtn;
	@FindBy(xpath="//div[@id='confirm']/div[2]/div/div[3]/button[1]")public WebElement okBtn;
	@FindBy(xpath="//span[text()='>Country']")public WebElement changeCountry;
	
	public void cscUserhandOutRequest() throws Exception {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(role).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@id,'Repeater1_SwitchUserRole') and normalize-space()='CSC']")).click();
		Thread.sleep(2000);
		action.moveToElement(changeCountry).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='INDIA']")).click();
		Thread.sleep(1000);
		searchArticleComponentTxt.sendKeys("pax");
		searchArticleComponentBtn.click();
		Thread.sleep(3000);
		int rowNos= driver.findElements(By.xpath("//*[@id='tbl_Articles']/tbody/tr")).size();
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
		for(int j=1;j<=size1stInnerRow;j++) {//size1stInnerRow== Ncomponent Rown Number
			driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(j)+"]//td[1]")).click();
			try {
			   if(Store.isDisplayed()) {
				int storeRowNos=driver.findElements(By.xpath("//table[contains(@class,'dataTableSubDatacontainer')]//thead//th[text()='Store']//parent::tr//parent::thead//parent::table//tbody//tr")).size();
			    for(int k=1;k<=storeRowNos;k++) {
			    String stockNo=driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer')]//thead//th[text()='Store']//parent::tr//parent::thead//parent::table//tbody//tr["+Integer.toString(k)+"]//td[5]")).getText();
			    int stockNum=Integer.parseInt(stockNo);
			    if(stockNum!=0) {
			    	driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer')]//thead//th[text()='Store']//parent::tr//parent::thead//parent::table//tbody//tr["+Integer.toString(k)+"]//td[6]//div[@title='Reserve']")).click();
			    	int comps=driver.findElements(By.xpath("//input[@type='number' and contains(@class,'salesQty')]")).size();
			    	for(int c=1;c<=comps;c++) {
			    		driver.findElement(By.xpath("(//input[@type='number' and contains(@class,'salesQty')])["+Integer.toString(c)+"]")).clear();
			    		Thread.sleep(2000);
			    		driver.findElement(By.xpath("(//input[@type='number' and contains(@class,'salesQty')])["+Integer.toString(c)+"]")).sendKeys("1");
			    	}
			    	Thread.sleep(6000);
			    	JavascriptExecutor jse = (JavascriptExecutor)driver;
			    	jse.executeScript("arguments[0].click()", submit);
			    	Thread.sleep(6000);
			    	okButn.click();
			    	break;
			      };
			     }
			      break;
			   }
			   
			}catch(Exception e) {
				if(j==size1stInnerRow) {
				driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(firstExpandableRow)+"]/td[1]")).click();
				firstExpandableRow=firstExpandableRow+1;
				cscUserhandOutRequest();
				break;
				}
			}
		}

	}
}
