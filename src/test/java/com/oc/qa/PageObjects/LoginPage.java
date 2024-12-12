package com.oc.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage
{
public LoginPage(WebDriver driver)
{
	super(driver);
}
@FindBy(xpath="//input[@name='email']")
WebElement Txt_email;
@FindBy(xpath="//input[@name='password']")
WebElement Txt_Password;
@FindBy(xpath="//input[@type='submit']")
WebElement Btn_Login;

public void LoginEmail(String email)
{
	Txt_email.sendKeys(email);
}
public void LoginPwd(String logpwd)
{
	 Txt_Password.sendKeys(logpwd);
}
public void loginbtn()
{
	Btn_Login.click();
}
}
