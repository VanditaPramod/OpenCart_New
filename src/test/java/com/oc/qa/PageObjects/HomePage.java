package com.oc.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	
	public HomePage(WebDriver driver)
	{
		super(driver);//Parent class driver
	}
	@FindBy(xpath="//a[@title='My Account']")
	WebElement MyAccLink;
	@FindBy(xpath="//ul//li//a[contains(text(),'Register')]")
	WebElement RegLink;
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement Login;
	
	
	public void ClickMyAcc()
	{
		MyAccLink.click();
	}
	
	public void ClickReg()
	{
		RegLink.click();
	}
	public void LoginButton()
	{
		Login.click();	}
}
