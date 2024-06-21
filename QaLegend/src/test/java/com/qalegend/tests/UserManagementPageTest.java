package com.qalegend.tests;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegend.base.BaseFile;
import com.qalegend.constants.Constants;
import com.qalegend.constants.Messages;
import com.qalegend.pages.HomePage;
import com.qalegend.pages.LoginPage;
import com.qalegend.pages.UserManagementPage;
import com.qalegend.utilities.ExcelReaderUtility;

public class UserManagementPageTest extends BaseFile {
	@Test(description = "Verification of User options availability")
	public void verifyUserManagementUserOptions() {

		String username = ExcelReaderUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String password = ExcelReaderUtility.getIntegerData(0, 1, Constants.LOGIN_PAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassWord(password);
		HomePage home = login.clickOnLoginButton();
		UserManagementPage usermanagement = home.clickOnEndTourButton();
		usermanagement.clickOnUserManagementOption();
		usermanagement.waitForUsersOptionVisibility();
		Assert.assertTrue(usermanagement.checkUsersOptionAvailability(), Messages.MISSING_USEROPTION);

	}
}
