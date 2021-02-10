package com.kontas.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TuitionProMain {

	public WebDriver driver;
	@FindBy(id="name1")
	public WebElement name;
	@FindBy(id="surname1")
	public WebElement surname;
	@FindBy(id="loginButton")
	public WebElement loginButton;
	
	public TuitionProMain(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}	
	
	
}
