package com.oc.qa.TestCases;

import org.testng.annotations.Test;

import com.oc.qa.PageObjects.HomePage;
import com.oc.qa.PageObjects.LoginPage;
import com.oc.qa.PageObjects.MyAccountPage;
import com.oc.qa.PageObjects.SearchProductPage;
import com.oc.qa.TestBase.BaseClass;

import junit.framework.Assert;

public class SearchProductTest extends BaseClass{
	
	@Test(groups="Master")
	public void SearchproductTest()
	{
		try
		{
		logger.info("*** SearchProductTest test started ***");
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
		
		//SearchProductPage 
		SearchProductPage sp=new SearchProductPage(driver);
		logger.info("Enter product name");
		sp.searchprod(p.getProperty("searchproductname"));
		logger.info("Click on search button");
		sp.SerachButton();
		logger.info("Click on List view button");
		sp.prodListView();
		logger.info("Check the product name");
		Thread.sleep(3000);
		String txt=sp.productNametext();
		if (txt.equals("iPhone"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		logger.info("Add the product to cart");
		sp.AddtoCart();
		logger.info("Go to cart");
		sp.GoTocartItem();
		logger.info("Check the product name from the cart");
		Thread.sleep(5000);
		String carttxt=sp.productNametext();
		if (carttxt.equals("iPhone"))
		{
			System.out.println(carttxt);
			Assert.assertTrue(true);
		}
		else
		{
			
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
}		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

