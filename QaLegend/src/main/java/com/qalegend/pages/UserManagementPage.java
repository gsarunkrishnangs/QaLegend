package com.qalegend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegend.utilities.WaitUtility;

public class UserManagementPage {

	WebDriver driver;

	public UserManagementPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='User Management']")
	WebElement usermanagement_options;
	@FindBy(xpath = "//i[@class='fa fa-user']//following-sibling::span")
	WebElement users_option;
	@FindBy(xpath = "//i[@class='fa fa-briefcase']//following-sibling::span")
	WebElement roles_option;
	@FindBy(xpath = "//i[@class='fa fa-handshake-o']//following-sibling::span")
	WebElement agents_option;

	public void clickOnUserManagementOption() {

		usermanagement_options.click();

	}

	public UsersPage clickOnUsersOption() {

		users_option.click();
		return new UsersPage(driver);

	}

	public void waitForUsersOptionVisibility() {

		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElement(driver, users_option);
	}

	public boolean checkUsersOptionAvailability() {

		boolean usersOption = users_option.isDisplayed();
		return usersOption;
	}

	public boolean checkRolesOptionAvailability() {

		boolean rolesOption = roles_option.isDisplayed();
		return rolesOption;

	}

	public boolean checkAgentsOptionAvailability() {

		boolean agentsOption = agents_option.isDisplayed();
		return agentsOption;

	}

}
