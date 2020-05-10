package com.pratice.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pratice.pageObjects.loginPage;

public class TC_LoginTest extends BaseClass{
	@Test
	public void LoginTest() throws IOException {
		
		logger.info("URL is Opened ");
		loginPage lp =new loginPage(driver);
		lp.setUserName(username);
		logger.info("Entered Username ");
		lp.setPassword(password);
		logger.info("Entered Password ");
		lp.clickSubmit();

		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			captureScreen(driver, "LoginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	}

}
