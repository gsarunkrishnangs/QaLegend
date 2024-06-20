package com.qalegend.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegend.base.BaseFile;
import com.qalegend.constants.Constants;
import com.qalegend.constants.Messages;
import com.qalegend.pages.HomePage;
import com.qalegend.pages.LoginPage;
import com.qalegend.utilities.ExcelReaderUtility;

public class HomePageTest extends BaseFile {
	@Test(groups = {"Sanity"}, description = "Verification of home page title")
	public void VerifyHomePageTitle() {

		String username = ExcelReaderUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String password = ExcelReaderUtility.getIntegerData(0, 1, Constants.LOGIN_PAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassWord(password);
		HomePage home = login.clickOnLoginButton();
		String expectedTitle = ExcelReaderUtility.getStringData(0, 1, Constants.HOME_PAGE);
		String actualTitle = home.getHomePageTitle();
		Assert.assertEquals(actualTitle, expectedTitle, Messages.HOME_TITLEMISMATCH);

	}

	@Test(groups= {"Regression"}, description = "Verification of user login date" )
	public void verifyUserLoginDate() {

		String username = ExcelReaderUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String password = ExcelReaderUtility.getIntegerData(0, 1, Constants.LOGIN_PAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassWord(password);
		HomePage home = login.clickOnLoginButton();
		String expectedDate = home.getCurrentDate();
		String actualDate = home.getLoginDate();
		Assert.assertEquals(actualDate, expectedDate, Messages.HOME_DATEMISMATCH);
	}

}
