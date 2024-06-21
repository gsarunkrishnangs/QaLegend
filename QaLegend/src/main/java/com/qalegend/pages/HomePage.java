package com.qalegend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegend.utilities.DateUtility;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//section[@class='content-header']")
	WebElement welcome_user;
	@FindBy(xpath = "//button[@class='btn btn-default btn-sm']")
	WebElement endtour_button;
	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	WebElement login_username;
	@FindBy(xpath = "//a[text()='Sign Out']")
	WebElement signout_button;
	@FindBy(xpath = "//div[@class='m-8 pull-left mt-15 hidden-xs']")
	WebElement datefield;

	public String getLoginUserText() {

		String user = welcome_user.getText();
		return user;
	}

	public String getHomePageTitle() {

		String title = driver.getTitle();
		return title;
	}

	public UserManagementPage clickOnEndTourButton() {

		endtour_button.click();
		return new UserManagementPage(driver);
	}

	public void clickOnLoginUserNameField() {

		login_username.click();
	}

	public void clickOnSignOutButton() {

		signout_button.click();

	}

	public String getLoginDate() {

		String loginDate = datefield.getText();
		return loginDate;
	}

	public String getCurrentDate() {

		String currentDate = DateUtility.getUserLoginDate("dd-MM-YYYY");
		return currentDate;
	}

	public BookingsPage clickOnEndTourOption() {

		endtour_button.click();
		return new BookingsPage(driver);
	}

	public ProductsPage clickOnEndTourHomeOption() {

		endtour_button.click();
		return new ProductsPage(driver);
	}
}
