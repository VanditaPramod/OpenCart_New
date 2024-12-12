package com.oc.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	 WebDriver driver; //instance variable
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;//this class driver
		PageFactory.initElements(driver, this);
	}
}
