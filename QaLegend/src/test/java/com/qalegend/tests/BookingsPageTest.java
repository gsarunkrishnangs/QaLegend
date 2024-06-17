package com.qalegend.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.awt.AWTException;
import java.time.Duration;

import org.testng.annotations.Test;

import com.qalegend.base.BaseFile;
import com.qalegend.constants.Constants;
import com.qalegend.constants.Messages;
import com.qalegend.pages.BookingsPage;
import com.qalegend.pages.HomePage;
import com.qalegend.pages.LoginPage;
import com.qalegend.pages.UserManagementPage;
import com.qalegend.utilities.ExcelReaderUtility;

public class BookingsPageTest extends BaseFile {
	@Test
	public void verifyBookingListWithoutAnyBooking() {

		String username = ExcelReaderUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String password = ExcelReaderUtility.getIntegerData(0, 1, Constants.LOGIN_PAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassWord(password);
		HomePage home = login.clickOnLoginButton();
		BookingsPage bookings = home.clickOnEndTourOption();
		bookings.clickOnBookingsOption();
		bookings.clickOnBusinessLocationComboBox();
		String locationname = ExcelReaderUtility.getStringData(0, 0, Constants.BOOKINGS_PAGE);
		bookings.enterLocation(locationname);
		try {
			bookings.clickOnEnterKey();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String expectedUserMessage = ExcelReaderUtility.getStringData(0, 1, Constants.BOOKINGS_PAGE);
		String actualUserMessage = bookings.getNoDataAvailableMessageText();
		Assert.assertEquals(actualUserMessage, expectedUserMessage, Messages.DATA_AVAILABLE);
	}
}
