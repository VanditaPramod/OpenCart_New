package com.oc.qa.TestCases;

import org.testng.annotations.Test;

import com.oc.qa.PageObjects.HomePage;
import com.oc.qa.PageObjects.LoginPage;
import com.oc.qa.PageObjects.MyAccountPage;
import com.oc.qa.TestBase.BaseClass;
import com.oc.qa.util.DataProviders;

import junit.framework.Assert;


/*Data is valid  - login success - test pass  - logout
	login failed - test fail

Data is invalid - login success - test fail  - logout
	login failed - test pass
*/

public class LoginTestDDT extends BaseClass{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class, groups="Master")
	public void verify_loginDDT(String email, String pwd, String exp) throws InterruptedException
	{
logger.info("***** stating TC_003_LoginDDT ******");
		
		try
		{	
	
	HomePage hp=new HomePage(driver);
	logger.info("Clicked on My Account");
	hp.ClickMyAcc();
	logger.info("Clicked on Login button");
	hp.LoginButton();
	
	//Login Page
	LoginPage lp=new LoginPage(driver);
	logger.info("Enter an Email");
	lp.LoginEmail(email);
	logger.info("Entered Password");
	lp.LoginPwd(pwd);
	logger.info("Clicked on Login button");
	lp.loginbtn();
	
	//MyAccount
	MyAccountPage Myacc=new MyAccountPage(driver);
	boolean TargetPage=Myacc.verifyMYaccHeading();
	if(exp.equalsIgnoreCase("Valid"))
	{
		if(TargetPage==true)
		{			
			Myacc.logout();
			Assert.assertTrue(true);
			
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	
	if(exp.equalsIgnoreCase("Invalid"))
	{
		if(TargetPage==true)
		{
			Myacc.logout();
			Assert.assertTrue(false);
			
		}
		else
		{
			Assert.assertTrue(true);
		}
	}
	
	}catch(Exception e)
	{
		Assert.fail();
	}
	Thread.sleep(3000);
	logger.info("***** Finished TC_003_LoginDDT ******");
	
	
		}
	}

