package com.oc.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProductPage extends BasePage {
	public SearchProductPage(WebDriver driver)
	{
		super (driver);	
	}
	
//Locators
	@FindBy(xpath="//input[@type='text' and  @name='search']")
	WebElement SearchField;
	@FindBy (xpath="//button[@type='button' and @class='btn btn-default btn-lg']")
	WebElement SearchBtn;
	@FindBy (xpath="//i[@class='fa fa-th-list']")
	WebElement Listview;
	@FindBy (xpath="//div//h4//a[text()='iPhone']")
	WebElement IphoneText;
	@FindBy (xpath="//button[contains(@onclick, \"cart.add('40', '1')\")]")
	WebElement AddtoCartBtn;
	@FindBy (xpath="//button[contains(@data-toggle,\"dropdown\")][@type='button']")
	WebElement cart;
	@FindBy (xpath="//ul//li//table//tbody//tr//td//a[text()='iPhone']")
	WebElement CartIphone;
	
	public void searchprod(String productName)
	{
		SearchField.sendKeys(productName);
	}
	public void SerachButton()
	{
		SearchBtn.click();
	}
	public void prodListView()
	{
		Listview.click();	
	}
	public String productNametext()
	{
		try {
			return (IphoneText.getText());	
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
		
	}
	public void AddtoCart()
	{
		AddtoCartBtn.click();
	}
	public void GoTocartItem()
	{
		cart.click();	
	}
	public String CartIphoneText()
	{
		try {
			return (IphoneText.getText());	
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}	
	}
	

}
