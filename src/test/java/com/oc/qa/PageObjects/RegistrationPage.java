package com.oc.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver)
	{
		super(driver);
	}
@FindBy(xpath="//input[@name='firstname']")
WebElement Fstnme;
@FindBy(xpath="//input[@name='lastname']")
WebElement lstnme;
@FindBy (xpath="//input[@name='email']")
WebElement eml;
@FindBy (xpath="//input[@name='telephone']")
WebElement tlphne;
@FindBy (xpath="//input[@name='password']")
WebElement pwd;
@FindBy (xpath="//input[@name='confirm']")
WebElement cnfpwd;
@FindBy (xpath="//input[@name='agree']")
WebElement privacy;
@FindBy (xpath="//input[@value='Continue']")
WebElement continuebtn;
@FindBy (xpath="//h1[contains(text(),'Your Account Has Been Created!')]")
WebElement sccsmsg;

public void Firstname(String name)
{
	Fstnme.sendKeys(name);
}
public void Lastname(String name)
{
	lstnme.sendKeys(name);
}
public void Email(String email)
{
	eml.sendKeys(email);
}
public void Telephone(String Tphone)
{
	tlphne.sendKeys(Tphone);
}
public void Password(String Pswd)
{
	pwd.sendKeys(Pswd);
}
public void ConfirmPwd(String cpwd)
{
	cnfpwd.sendKeys(cpwd);
}
public void PrivacyBox()
{
	privacy.click();
}
public void ContinueButton()
{
	continuebtn.click();;
}

public String getconfirmationmsg()
{
	try
	{
		return (sccsmsg.getText());
	}
	catch(Exception e)
	{
	return (e.getMessage())	;
	}
}
}
