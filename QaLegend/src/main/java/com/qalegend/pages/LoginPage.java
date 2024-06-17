package com.qalegend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='username']")
	WebElement username_field; 
	@FindBy(xpath="//input[@id='password']")
	WebElement password_field;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement login_button;
	@FindBy(xpath="//strong[text()='These credentials do not match our records.']")
	WebElement error_message;
	@FindBy(xpath="//a[@class='btn btn-link']")
	WebElement forgotpassword_link;
	
	public void enterUserName(String username) {
		
		username_field.sendKeys(username);
	}
	
	public void enterPassWord(String password) {
		
		password_field.sendKeys(password);
	}
	
	public HomePage clickOnLoginButton() {
		
		login_button.click();
		return new HomePage(driver);
	}
	
	public String getInvalidCerdentialsErrorMessageText() {
		
		String message = error_message.getText();
		return message;
	}
	
	public ResetPasswordPage clickOnForgotPasswordLink() {
		
		forgotpassword_link.click();
		return new ResetPasswordPage(driver);
		
	}
}
