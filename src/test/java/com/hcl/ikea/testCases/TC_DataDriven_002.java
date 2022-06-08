package com.hcl.ikea.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hcl.ikea.pageObjects.LoginPage;
import com.hcl.ikea.utilities.*;

public class TC_DataDriven_002 extends BaseClass
{

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setName(user);
		log.info("Entered Username");
		lp.setPassword(pwd);
		log.info("Entered Password");
		lp.submit();
		log.info("Submit button got clicked successfully");
		Thread.sleep(1000);
		lp.clearName();
		Thread.sleep(3000);
		
		if(driver.getTitle().equals("Spartacus V200")) {
			Assert.assertTrue(true);
			log.info("Test case got passed");
		}else {
			captureScreen(driver,"TC_DataDriven_002");
			log.info("Taking screenshot of failed test case");
			Assert.assertTrue(false);
			log.info("Test case got failed");
			log.info("***********************************************************************************");
		}
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			log.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			log.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			
		}
		
		
	}
	
	
	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/hcl/ikea/testData/LoginData.xlsx";
		
		int rownum=XLS_Reader.getRowCount(path, "Sheet1");
		int colcount=XLS_Reader.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLS_Reader.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}
	
}