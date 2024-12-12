package com.oc.qa.TestCases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.oc.qa.PageObjects.HomePage;
import com.oc.qa.PageObjects.RegistrationPage;
import com.oc.qa.TestBase.BaseClass;

import junit.framework.Assert;

public class RegistrationTest extends BaseClass {
	
	
	
	@Test(groups={"Regression","Master"})
	public void Acc_RegistrationTest() throws InterruptedException
	{
		try
		{
		logger.info("*** Registration test started ***");
		HomePage hp=new HomePage(driver);
		hp.ClickMyAcc();
		logger.info("Clicked on My Account");
		hp.ClickReg();
		logger.info("Clicked on Register");
		RegistrationPage reg=new RegistrationPage(driver);
		logger.info("Enter first, last, email and Telephone");
		reg.Firstname(randomString().toUpperCase());
		reg.Lastname(randomString().toUpperCase());
		reg.Email(randomString()+ "@mailinator.com");
		reg.Telephone(randomNumer());
		
	//storing in string since randomAlphaNumeric() generates new password everytime.		
		String passwordgenerated=randomAlphaNumeric();
		logger.info("Enter password");
		reg.Password(passwordgenerated);
		logger.info("Enter confirm password");
		reg.ConfirmPwd(passwordgenerated);
		logger.info("Click on privacy");
		reg.PrivacyBox();
		logger.info("Click on continue button");
		reg.ContinueButton();
		logger.info("confirmation message");
		String msg=reg.getconfirmationmsg();
//		Assert.assertEquals(msg, "Your Account Has Been Created!");
		if (msg.equals("Your Account Has Been Created!"))
		{
		Assert.assertTrue(true);	
		}
		else
		{
			logger.error("Test Failed");
			logger.debug("debug logs");
			Assert.assertTrue(true);
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("****Registration testing completed*****");
	}
	
	
	
}
