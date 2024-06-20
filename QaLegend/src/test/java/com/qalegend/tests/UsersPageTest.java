package com.qalegend.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegend.base.BaseFile;
import com.qalegend.constants.Constants;
import com.qalegend.constants.Messages;
import com.qalegend.pages.HomePage;
import com.qalegend.pages.LoginPage;
import com.qalegend.pages.UserManagementPage;
import com.qalegend.pages.UsersPage;
import com.qalegend.utilities.ExcelReaderUtility;
import com.qalegend.utilities.RandomDatasUtility;

public class UsersPageTest extends BaseFile {

	@Test(groups= {"Smoke"}, description = "Verification of new user addition")
	public void verifyAddUser() {

		String username = ExcelReaderUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String password = ExcelReaderUtility.getIntegerData(0, 1, Constants.LOGIN_PAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassWord(password);
		HomePage home = login.clickOnLoginButton();
		UserManagementPage usermanagement = home.clickOnEndTourButton();
		usermanagement.clickOnUserManagementOption();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		UsersPage userpage = usermanagement.clickOnUsersOption();
		userpage.clickOnAddButton();
		String preFix = ExcelReaderUtility.getStringData(0, 0, Constants.USERS_PAGE);
		userpage.enterPrefix(preFix);
		String firstName = RandomDatasUtility.getFirstName();
		userpage.enterFirstName(firstName);
		String lastName = RandomDatasUtility.getLastName();
		userpage.enterLastName(lastName);
		String mailId = firstName + "." + lastName + "@gmail.com";
		userpage.enterEmail(mailId);
		String newUserName = firstName + "." + lastName;
		userpage.enterNewUserName(newUserName);
		String mainPassword = firstName + "." + lastName;
		userpage.enterNewPassWord(mainPassword);
		String confirmPassword = firstName + "." + lastName;
		userpage.enterConfirmPassWord(confirmPassword);
		String commissionPercentage = ExcelReaderUtility.getIntegerData(0, 1, Constants.USERS_PAGE);
		userpage.enterCommissionPercentage(commissionPercentage);
		userpage.clickOnSaveButton();
		String nameSearch = ExcelReaderUtility.getStringData(0, 3, Constants.USERS_PAGE);
		userpage.enterSearchText(nameSearch);
		String expectedUser = ExcelReaderUtility.getStringData(0, 2, Constants.USERS_PAGE);
		String actualUser = userpage.getNewlyAddedUser();
		Assert.assertEquals(actualUser, expectedUser, Messages.USERADD_FAILURE);

	}

	@Test(description = "Verification of login with new user")
	public void veriyLoginWithNewlyAddedUser() {

		String username = ExcelReaderUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String password = ExcelReaderUtility.getIntegerData(0, 1, Constants.LOGIN_PAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassWord(password);
		HomePage home = login.clickOnLoginButton();
		UserManagementPage usermanagement = home.clickOnEndTourButton();
		usermanagement.clickOnUserManagementOption();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		UsersPage userpage = usermanagement.clickOnUsersOption();
		userpage.clickOnAddButton();
		String preFix = ExcelReaderUtility.getStringData(0, 0, Constants.USERS_PAGE);
		userpage.enterPrefix(preFix);
		String firstName = RandomDatasUtility.getFirstName();
		userpage.enterFirstName(firstName);
		String lastName = RandomDatasUtility.getLastName();
		userpage.enterLastName(lastName);
		String mailId = firstName + "." + lastName + "@gmail.com";
		userpage.enterEmail(mailId);
		String newUserName = firstName + "." + lastName;
		userpage.enterNewUserName(newUserName);
		String mainPassword = firstName + "." + lastName;
		userpage.enterNewPassWord(mainPassword);
		String confirmPassword = firstName + "." + lastName;
		userpage.enterConfirmPassWord(confirmPassword);
		String commissionPercentage = ExcelReaderUtility.getIntegerData(0, 1, Constants.USERS_PAGE);
		userpage.enterCommissionPercentage(commissionPercentage);
		userpage.clickOnSaveButton();
		HomePage homeNew = userpage.clickOnHomeOption();
		homeNew.clickOnLoginUserNameField();
		homeNew.clickOnSignOutButton();
		String userName = ExcelReaderUtility.getStringData(0, 3, Constants.LOGIN_PAGE);
		String passWord = ExcelReaderUtility.getStringData(0, 3, Constants.LOGIN_PAGE);
		login.enterUserName(userName);
		login.enterPassWord(passWord);
		login.clickOnLoginButton();
		String expectedMessage = ExcelReaderUtility.getStringData(0, 2, Constants.HOME_PAGE);
		String actualMessage = home.getLoginUserText();
		Assert.assertEquals(actualMessage, expectedMessage, Messages.WRONG_USER);
	}

}
