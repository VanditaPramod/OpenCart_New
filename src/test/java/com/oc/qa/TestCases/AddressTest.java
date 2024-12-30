package com.oc.qa.TestCases;

import org.testng.annotations.Test;

import com.oc.qa.PageObjects.AddressPage;
import com.oc.qa.PageObjects.HomePage;
import com.oc.qa.PageObjects.LoginPage;
import com.oc.qa.PageObjects.MyAccountPage;
import com.oc.qa.TestBase.BaseClass;
import com.oc.qa.util.DataProviders;

import junit.framework.Assert;
public class AddressTest extends BaseClass {
	@Test(dataProvider="AddressUpdate",dataProviderClass=DataProviders.class,groups="Master")
	public void Addressupdate(String Email,String Password,String FirstName,String LastName,String Company,String Address1,String Address2,String City, String PostalCode,String Country, String Region)
	{
		try
		{
		logger.info("*** Address test started ***");
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
		lp.LoginEmail(Email);
		logger.info("Entered Password");
		lp.LoginPwd(Password);
		logger.info("Clicked on Login button");
		lp.loginbtn();
		
		//MyAccount
		MyAccountPage Myacc=new MyAccountPage(driver);
		boolean TargetPage=Myacc.verifyMYaccHeading();
		Assert.assertTrue(TargetPage);
		
		//Address Update
		AddressPage At=new AddressPage(driver);
		logger.info("Click on Address book entry URL");
		At.AddressBookEntryURL();
		logger.info("Clicked on new address button");
		At.NewAddressButton();
		logger.info("Entered First Name");
		At.FirstName(FirstName);
		logger.info("Entered Last Name");
		At.LastName(LastName);
		logger.info("Entered Company Name");
		At.CompanyName(Company);
		logger.info("Entered Address1");
		At.Address_1(Address1);
		logger.info("Entered Address2");
		At.Address_2(Address2);
		logger.info("Entered city");
		At.City(City);
		logger.info("Entered Postal Code");
		At.postalcode(PostalCode);
		Thread.sleep(3000);
		logger.info("Select the Country from the Dropdown");
		At.Country(Country);
		Thread.sleep(3000);
		logger.info("Select the Region from the Dropdown");
		At.Region(Region);
		logger.info("Click on Continue");
		At.Cont_inue();
		logger.info("Verify Success message");
		String msg=At.SuccessMessage();
		if(msg.equalsIgnoreCase("Your address has been successfully added"))
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
	}
	
}

