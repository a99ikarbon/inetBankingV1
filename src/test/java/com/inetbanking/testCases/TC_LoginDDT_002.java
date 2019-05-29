package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.commons.math3.analysis.function.Log;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd)
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		lp.setPassword(pwd);
		lp.clickSubmit();
		
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
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent()//user defined method created to check alert is present or not
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch (NoAlertPresentException e) {
			return false;
		}
		
	}
	
	
	@DataProvider(name="LoginData")
	String[][]getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/DDF.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getcellData(path, "Sheet1", i, j);//1 0
			}
		}
		return logindata;
	}
	
}
