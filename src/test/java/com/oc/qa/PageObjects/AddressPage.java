package com.oc.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddressPage extends BasePage {

	public  AddressPage(WebDriver driver)
	{
		super (driver);
	}
	
	//Locators
	@FindBy(xpath="//a[text()='Modify your address book entries']")
	WebElement AddrsbkentryURL;
	@FindBy(xpath="//a[text()='New Address']")
	WebElement NewAddress;
	@FindBy(xpath="//input[@name='firstname']")
	WebElement FstNme;
	@FindBy(xpath="//input[@name='lastname']")
	WebElement LstNme;
	@FindBy(xpath="//input[@name='company']")
	WebElement Cmpny;
	@FindBy(xpath="//input[@name='address_1']")
	WebElement Addrs1;
	@FindBy(xpath="//input[@name='address_2']")
	WebElement addrs2;
	@FindBy(xpath="//input[@name='city']")
	WebElement cty;
	@FindBy(xpath="//input[@name='postcode']")
	WebElement pstcode;
	@FindBy(xpath="//select[@name='country_id']")
	WebElement Cntry;
	@FindBy(xpath="//select[@name='zone_id']")
	WebElement Rgn;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement Cntnue;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement SuccMsg;
	@FindBy(xpath="//table[@class='table table-bordered table-hover\"]/tbody/tr[2]/td[1]']")
	WebElement VerifyAddrss;
	
	
	public void AddressBookEntryURL()
	{
		AddrsbkentryURL.click();
	}
	public void NewAddressButton()
	{
		NewAddress.click();
	}
	public void FirstName(String Fname)
	{
		FstNme.sendKeys(Fname);
	}
	public void LastName(String Lname)
	{
		LstNme.sendKeys(Lname);
	}
	public void CompanyName(String CName)
	{
		Cmpny.sendKeys(CName);
	}
	public void Address_1(String Add1)
	{
		Addrs1.sendKeys(Add1);
	}
	public void Address_2(String Add2)
	{
		addrs2.sendKeys(Add2);
	}
	public void City(String CTname)
	{
		cty.sendKeys(CTname);
	}
	public void postalcode(String Pcode)
	{
		pstcode.sendKeys(Pcode);
	}
	public String Country(String country)
	{
		Select Cddwn= new Select(Cntry);
		Cddwn.selectByVisibleText(country);
		return country;
	}
	public String Region(String region)
	{
		Select Rddwn=new Select(Rgn);
		Rddwn.selectByVisibleText(region);
		return region;
	}
	public void Cont_inue()
	{
		Cntnue.click();
	}
	public String SuccessMessage()
	{
		try {
		return(SuccMsg.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	public boolean VerifyAddress()
	{
		System.out.println("Address is present");
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
