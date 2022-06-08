package com.hcl.ikea.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecoveryAdmin_MergeCompReplenishment {

	public WebDriver driver;

	public RecoveryAdmin_MergeCompReplenishment(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='txtUser'] [@id='txtUser']") WebElement userName;
	@FindBy(xpath = "//*[@id=\"sidebar-wrapper\"]/ul/li[3]") public WebElement ManageStockMouseHover;
	@FindBy(xpath="//span[contains(text(),'Component Inventory')]") public WebElement compInventory;
	@FindBy(xpath = "//span[contains(text(),'Component Replenishment')]")public WebElement compReplenishment;
	@FindBy(xpath="//input[contains(@name,'txtSearch') and @id='Body_txtSearch']")
	public WebElement searchArticleComponentTxt;
	@FindBy(xpath="//input[contains(@name,'btnSearch') and @id='Body_btnSearch']")
	public WebElement searchArticleComponentBtn; 
	@FindBy(xpath = "//div[@class = 'col-md-12 col-sm-12 col-lg-8 searchFormArea']/input[@type='submit']") public WebElement SearchButtonAddStock;
	@FindBy(xpath="//table[@id='tbl_Articles']/tbody/tr[1]/td[5]//a[@title='Add New Spare Part']") public WebElement addNewSparePart1stRow;
	@FindBy(xpath="//table[contains(@class,'dataTableSubDatacontainer Component')]//thead//tr//th[contains(text(),'Part No')]") public WebElement partNoHeading;
    @FindBy(xpath="//input[contains(@id,'SearchComponent')]")  public WebElement searchComp;
    @FindBy(xpath="//input[contains(@id,'btnMerge') and @value='GO']") public WebElement goBtn;
    @FindBy(xpath="//button[@id='btnCompSearch']") public WebElement searchBtn;
    @FindBy(xpath="//p[text()='Component Merged']") public WebElement compMergeMsg;
    @FindBy(xpath="//h4[normalize-space()='Search Component(s)']//preceding-sibling::button[@class='close']//span")public WebElement closeBtn;
    @FindBy(xpath="//p[text()='Component Merged']//parent::div//following-sibling::div//button[normalize-space()='OK']") public WebElement okBtn;
    
	public void searchInManageStockToReplenishment() throws InterruptedException {
		Actions ac = new Actions(driver);
		ac.moveToElement(ManageStockMouseHover).perform();
//		driver.findElement(By.xpath("//*[@id='sidebar-wrapper']/ul/li[3]/ul/li[1]/a")).click();
		compReplenishment.click();
		searchArticleComponentTxt.sendKeys("pax");
		searchArticleComponentBtn.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='Body_btnSearch']")).click();
	}
	
	public void mergeComponent() throws InterruptedException {
		int rowNos=driver.findElements(By.xpath("//table[@id='tbl_Articles']/tbody/tr")).size();
		int firstExpandableRow=0;
		String partno1=null;
		String articleNo=null;
		int cCompRowNo=0;
		int cCompArticleRowNo=0;
		String cComp="";
		String nComp="";
		String fittingsComp="";
		WebElement mergeBtn;
		for(int i=1;i<=rowNos;i++) {
			if(i>=10) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				 js.executeScript("window.scrollBy(0,564)", " ");
				 Thread.sleep(4000);
			}
			System.out.println("All compNos are :"+nComp+" "+cComp+" "+fittingsComp);
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(i)+"]/td[1]")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(i)+"]/td[1]")));
//			driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(i)+"]/td[1]")).click();
			try {
			if(partNoHeading.isDisplayed()) {
				firstExpandableRow=i;
//				System.out.println("the first part-decribed row is "+firstExpandableRow);
//				articleNo=driver.findElement(By.xpath("(//table[@id='tbl_Articles']//tbody//tr//td[contains(@class,' col-md-2 full-width fixLineHeight paddingFix')])["+Integer.toString(i+1)+"]")).getText();
//				System.out.println("the Article No for which component should be linked"+articleNo);
				int compRowsSize=driver.findElements(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr")).size();
				for(int j=1;j<=compRowsSize;j++) {
				
				if(i>=10) {
					 js.executeScript("window.scrollBy(0,564)", " ");
					 Thread.sleep(4000);
				}
				String compNo=driver.findElement(By.xpath("//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr["+Integer.toString(j)+"]//td[2]")).getText();
				
				
				if(nComp.length()==0 && compNo.startsWith("N")) {
					nComp=compNo;
					System.out.println("nComp :"+nComp);
				}
				if(cComp.length()==0 && compNo.startsWith("C")) {
					cComp=compNo;
					cCompArticleRowNo=i;
					cCompRowNo=j;
					System.out.println("cComp : "+cComp);
				}
				if(fittingsComp.length()==0 && !compNo.startsWith("N") && !compNo.startsWith("C")) {
					fittingsComp=compNo;
					System.out.println("fittingsComp :"+fittingsComp);
				}
				if(j==compRowsSize) {
				driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(i)+"]/td[1]")).click();
				}
				if(nComp.length()!=0 && cComp.length()!=0 && fittingsComp.length()!=0) {
					System.out.println("compos are :"+nComp+" "+cComp+" "+fittingsComp);
					break;
				 }
		    	}
				
		       }
			
			}catch(Exception e) {
				
			}
			if(nComp.length()!=0 && cComp.length()!=0 && fittingsComp.length()!=0) {
			break;
			}
		}
		driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(cCompArticleRowNo)+"]/td[1]")).click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr)["+Integer.toString(cCompRowNo)+"]//td[7]//div[@title='Merge component(s)']")));
		mergeBtn=driver.findElement(By.xpath("(//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr)["+Integer.toString(cCompRowNo)+"]//td[7]//div[@title='Merge component(s)']"));
//	
		Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", mergeBtn);
		searchComp.sendKeys(nComp);
		Thread.sleep(4000);
		searchBtn.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='ComponentsDiv']//input[contains(@data-newcomponentno,'"+nComp+"')]")).click();
		goBtn.click();
		try {
//		if(compMergeMsg.isDisplayed()) {
			System.out.println("merge msg sjhown");
//			okBtn.click();type name = new type();
//			closeBtn.click();
			jse.executeScript("arguments[0].click()", okBtn);
			Thread.sleep(3000);
//		} 
		}catch(Exception e) {
			
		}
		
	    
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(cCompArticleRowNo)+"]/td[1]")));
	    WebElement chevronOfCComp=driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(cCompArticleRowNo)+"]/td[1]"));
	    jse.executeScript("arguments[0].click()", chevronOfCComp);

		Thread.sleep(8000);
//		driver.findElement(By.xpath("//table[@id='tbl_Articles']/tbody/tr["+Integer.toString(cCompArticleRowNo)+"]/td[1]")).click();
		Thread.sleep(5000);
		mergeBtn=driver.findElement(By.xpath("(//table[contains(@class,'dataTableSubDatacontainer Component')]//tbody//tr)["+Integer.toString(cCompRowNo)+"]//td[7]//div[@title='Merge component(s)']"));
		jse.executeScript("arguments[0].click()", mergeBtn);
//		mergeBtn.click();
		searchComp.clear();
		searchComp.sendKeys(fittingsComp);
		Thread.sleep(4000);
		searchBtn.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='ComponentsDiv']//input[contains(@data-newcomponentno,'"+cComp+"')]")).click();
		goBtn.click();
//		}	
//		break;
	}
		
 }
 

