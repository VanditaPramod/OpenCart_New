package com.oc.qa.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement MyaccHomepage;
	@FindBy(xpath="//a[text()='Logout'][@class='list-group-item']")
	WebElement ClickLogout;
	
	
	public boolean verifyMYaccHeading()
	{
		try
		{
		return (MyaccHomepage.isDisplayed());
		}
		catch (Exception e)
		{
			return false;
		}
	}
	public void logout()
	{
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ClickLogout));
		ClickLogout.click();
	}
}
