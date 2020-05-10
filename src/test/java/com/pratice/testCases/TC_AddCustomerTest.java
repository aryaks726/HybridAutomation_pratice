package com.pratice.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pratice.pageObjects.AddCustomerPage;
import com.pratice.pageObjects.loginPage;

public class TC_AddCustomerTest extends BaseClass{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		loginPage lp=new loginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		
		addcust.custName("Arya");
		addcust.custgender("male");
		addcust.custdob("10","15","1996");
		Thread.sleep(5000);
		addcust.custaddress("Nepal");
		addcust.custcity("Jhapa");
		addcust.custstate("Mechi");
		addcust.custpinno("3470158");
		addcust.custtelephoneno("9816905369");
		
		String email=randomestring()+"@yopmail.com";
		addcust.custemailid(email);
		Thread.sleep(3000);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}
	
	
}
