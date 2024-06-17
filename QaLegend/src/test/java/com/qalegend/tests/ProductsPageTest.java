package com.qalegend.tests;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegend.base.BaseFile;
import com.qalegend.constants.Constants;
import com.qalegend.constants.Messages;
import com.qalegend.pages.HomePage;
import com.qalegend.pages.LoginPage;
import com.qalegend.pages.ProductsPage;
import com.qalegend.utilities.ExcelReaderUtility;

public class ProductsPageTest extends BaseFile {

	@Test
	public void VerifyProductsFilter() {

		String username = ExcelReaderUtility.getStringData(0, 0, Constants.LOGIN_PAGE);
		String password = ExcelReaderUtility.getIntegerData(0, 1, Constants.LOGIN_PAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassWord(password);
		HomePage home = login.clickOnLoginButton();
		ProductsPage products = home.clickOnEndTourHomeOption();
		products.clickOnProductsOption();
		products.clickOnProductsListMenu();
		products.clickOnProductTypeCombobox();
		products.setProductTypeComboboxValue();
		products.clickOnCategoryCombobox();
		products.setCategoryComboboxValue();
		products.clickOnUnitCombobox();
		products.setUnitComboboxValue();
		products.clickOnBrandCombobox();
		products.setBrandComboboxValue();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String expectedSearchMessage = ExcelReaderUtility.getStringData(0, 0, Constants.PRODUCTS_PAGE);
		String actualSearchMessage = products.getSearchResultMessage();
		Assert.assertEquals(actualSearchMessage, expectedSearchMessage, Messages.WRONG_FILTERRESULT);
       
	}
}
