package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws IOException, Exception {
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		Thread.sleep(3000);
		log.info("login completed");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			log.info("title matched");
		}
		else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			log.info("title not matched");
			
		}
		
	}

}
