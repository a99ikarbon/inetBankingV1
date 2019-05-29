package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;



public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		log.info("clicked on new customer page");
		addcust.custName("satya");
		addcust.custgender("male");
		addcust.custdob("13","08","1985");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("516269");
		addcust.custtelephone("7996512638");
		
		String email=randomestring()+"@gmail.com";
		addcust.custmailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		log.info("validation started");
		boolean res=driver.getPageSource().contains("customer registered successfully!!");
		
		if(res=true)
		{
			Assert.assertTrue(true);
			log.info("test passed");
		}
		else
		{
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			log.info("test failed");
		}
		
	}

}
