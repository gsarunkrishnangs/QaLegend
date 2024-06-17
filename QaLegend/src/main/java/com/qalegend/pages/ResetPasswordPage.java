package com.qalegend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage {

	WebDriver driver;

	public ResetPasswordPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='email']")
	WebElement email_address;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement passwordresetlink_button;
	@FindBy(xpath = "//strong[text()='The email must be a valid email address.']")
	WebElement warning_message;
	@FindBy(xpath = "//div[@class='alert alert-success']")
	WebElement success_message;

	public void enterEmail(String email) {

		email_address.sendKeys(email);

	}

	public void clickOnSendPasswordResetButton() {

		passwordresetlink_button.click();
	}

	public String getInvalidMailIdErrorMessageText() {

		String errorMessage = warning_message.getText();
		return errorMessage;
	}

	public String getValidMailIdSuccessMessageText() {

		String successMessage = success_message.getText();
		return successMessage;
	}
}
