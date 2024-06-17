package com.qalegend.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegend.base.BaseFile;
import com.qalegend.constants.Constants;
import com.qalegend.constants.Messages;
import com.qalegend.pages.LoginPage;
import com.qalegend.pages.ResetPasswordPage;
import com.qalegend.utilities.ExcelReaderUtility;

public class ResetPasswordPageTest extends BaseFile {
	@Test(groups= {"Sanity","Regression"})
	public void veriyErrorMessageWithInvalidMailId() {

		String emailId = ExcelReaderUtility.getStringData(0, 0, Constants.RESETPASSWORD_PAGE);
		LoginPage login = new LoginPage(driver);
		ResetPasswordPage reset = login.clickOnForgotPasswordLink();
		reset.enterEmail(emailId);
		reset.clickOnSendPasswordResetButton();
		String expectedErrorMessage = ExcelReaderUtility.getStringData(0, 1, Constants.RESETPASSWORD_PAGE);
		String actualErrorMessage = reset.getInvalidMailIdErrorMessageText();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, Messages.RESET_VALIDMAILID);

	}

	@Test(groups="Regression")
	public void veriySuccessMessageWithValidMailId() {

		String emailId = ExcelReaderUtility.getStringData(0, 2, Constants.RESETPASSWORD_PAGE);
		LoginPage login = new LoginPage(driver);
		ResetPasswordPage reset = login.clickOnForgotPasswordLink();
		reset.enterEmail(emailId);
		reset.clickOnSendPasswordResetButton();
		String expectedSuccessMessage = ExcelReaderUtility.getStringData(0, 3, Constants.RESETPASSWORD_PAGE);
		String actualSuccessMessage = reset.getValidMailIdSuccessMessageText();
		Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage, Messages.RESET_INVALIDMAILID);

	}

}
