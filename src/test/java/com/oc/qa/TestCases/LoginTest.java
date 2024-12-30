package com.oc.qa.TestCases;

import org.testng.annotations.Test;

import com.oc.qa.PageObjects.HomePage;
import com.oc.qa.PageObjects.LoginPage;
import com.oc.qa.PageObjects.MyAccountPage;
import com.oc.qa.TestBase.BaseClass;

import junit.framework.Assert;

public class LoginTest extends BaseClass
{
	@Test (groups={"Sanity","Regression","Master"})
	public void Acc_LoginTest()
	{
		try
		{
			logger.info("*** Login test started ***");
			//Home Page
			HomePage hp=new HomePage(driver);
			logger.info("Clicked on My Account");
			hp.ClickMyAcc();
			logger.info("Clicked on Login button");
			hp.LoginButton();
			
			//Login Page
			LoginPage lp=new LoginPage(driver);
			logger.info("Enter an Email");
			lp.LoginEmail(p.getProperty("email"));
			logger.info("Entered Password");
			lp.LoginPwd(p.getProperty("password"));
			logger.info("Clicked on Login button");
			lp.loginbtn();
			
			//MyAccount
			MyAccountPage Myacc=new MyAccountPage(driver);
			boolean TargetPage=Myacc.verifyMYaccHeading();
			Assert.assertTrue(TargetPage);
		}		
		catch(Exception e)
		{
			Assert.fail();
		}
	}
}
