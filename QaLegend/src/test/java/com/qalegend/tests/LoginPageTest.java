package com.qalegend.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegend.base.BaseFile;
import com.qalegend.constants.Constants;
import com.qalegend.constants.Messages;
import com.qalegend.listeners.ReTryAnalyzerListener;
import com.qalegend.pages.HomePage;
import com.qalegend.pages.LoginPage;
import com.qalegend.utilities.DataProviderUtility;
import com.qalegend.utilities.ExcelReaderUtility;

public class LoginPageTest extends BaseFile {

	@Test(retryAnalyzer = ReTryAnalyzerListener.class, description = "Verification of User login with valid credentials")
	public void verifyUserLogin() {

		String username = ExcelReaderUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String password = ExcelReaderUtility.getIntegerData(0, 1, Constants.LOGIN_PAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassWord(password);
		HomePage home = login.clickOnLoginButton();
		String expectedMessage = ExcelReaderUtility.getStringData(0, 0, Constants.HOME_PAGE);
		String actualMessage = home.getLoginUserText();
		Assert.assertEquals(actualMessage, expectedMessage, Messages.LOGIN_FAILURE);

	}

	@Test(dataProvider = "InvalidLoginUserCredentials", dataProviderClass = DataProviderUtility.class, description = "Verification of User login with invalid credentials")
	public void verifyUserLoginWithInvalidCredentials(String username, String password) {

		LoginPage login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassWord(password);
		login.clickOnLoginButton();
		String expectedErrorMessage = ExcelReaderUtility.getStringData(0, 2, Constants.LOGIN_PAGE);
		String actualErrorMessage = login.getInvalidCerdentialsErrorMessageText();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, Messages.LOGIN_SUCCESS);

	}

}
