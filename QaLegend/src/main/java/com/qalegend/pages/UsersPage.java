package com.qalegend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegend.utilities.PageUtility;
import com.qalegend.utilities.WaitUtility;

public class UsersPage {

	WebDriver driver;

	public UsersPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
	WebElement add_button;
	@FindBy(xpath = "//input[@id='surname']")
	WebElement prefix_textbox;
	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstname_textbox;
	@FindBy(xpath = "//input[@id='last_name']")
	WebElement lastname_textbox;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email_textbox;
	@FindBy(xpath = "//input[@id='username']")
	WebElement username_textbox;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password_textbox;
	@FindBy(xpath = "//input[@id='confirm_password']")
	WebElement confirmpassword_textbox;
	@FindBy(xpath = "//input[@id='cmmsn_percent']")
	WebElement salescommissionpercentage_textbox;
	@FindBy(xpath = "//button[@id='submit_user_button']")
	WebElement save_button;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement search_box;
	@FindBy(xpath = "//td[text()='Mercy.Okuneva']")
	WebElement name_list;
	@FindBy(xpath = "//i[@class='fa fa-dashboard']//following-sibling::span")
	WebElement home_option;
	@FindBy(xpath = "//span[@aria-labelledby='select2-role-container']")
	WebElement role_combobox;

	public void clickOnAddButton() {

		add_button.click();
	}

	public void enterPrefix(String prefix) {

		prefix_textbox.sendKeys(prefix);

	}

	public void enterFirstName(String firstname) {

		firstname_textbox.sendKeys(firstname);

	}

	public void enterLastName(String lastname) {

		lastname_textbox.sendKeys(lastname);

	}

	public void enterEmail(String email) {

		email_textbox.sendKeys(email);

	}

	public void selectRoleDropDownBox() {

		PageUtility pageutility = new PageUtility();
		pageutility.selectByVisibleText(role_combobox, "Supervisor");
	}

	public void enterNewUserName(String uname) {

		username_textbox.sendKeys(uname);

	}

	public void enterNewPassWord(String pword) {

		password_textbox.sendKeys(pword);

	}

	public void enterConfirmPassWord(String confirmpword) {

		confirmpassword_textbox.sendKeys(confirmpword);

	}

	public void enterCommissionPercentage(String salescommission) {

		salescommissionpercentage_textbox.sendKeys(salescommission);

	}

	public void clickOnSaveButton() {

		save_button.click();
		
	}
	
	public void waitForSearchBoxVisibility() {
		
		WaitUtility waitutility = new WaitUtility();
        waitutility.waitForElement(driver, search_box);
	}

	public void enterSearchText(String searchname) {

		search_box.sendKeys(searchname);

	}

	public String getNewlyAddedUser() {

		String userResult = name_list.getText();
		return userResult;
	}

	public HomePage clickOnHomeOption() {

		home_option.click();
		return new HomePage(driver);
	}

}
