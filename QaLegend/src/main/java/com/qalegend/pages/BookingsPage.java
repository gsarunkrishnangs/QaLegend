package com.qalegend.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qalegend.utilities.PageUtility;

public class BookingsPage {

	WebDriver driver;

	public BookingsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Bookings']")
	WebElement bookings_option;
	@FindBy(xpath = "//span[@class='select2-selection select2-selection--single']")
	WebElement businesslocation_combobox;
	@FindBy(xpath = "//input[@class='select2-search__field']")
	WebElement businesslocation_searchbox;
	@FindBy(xpath = "//td[text()='No data available in table']")
	WebElement nodata_message;
	@FindBy(xpath = "//button[@id='add_new_booking_btn']")
	WebElement addbooking_button;
	@FindBy(xpath="//span[@aria-labelledby=\"select2-business_location_id-container\"]")
	WebElement Customer;

	public void clickOnBookingsOption() {

		bookings_option.click();
	}

	public void clickOnBusinessLocationComboBox() {

		businesslocation_combobox.click();
	}

	public void enterLocation(String locationname) {

		businesslocation_searchbox.sendKeys(locationname);
	}

	public void enterKeyPress() {

		PageUtility pageutility = new PageUtility();
		pageutility.clickOnEnterKey();
	}

	public String getNoDataAvailableMessageText() {

		String usermessage = nodata_message.getText();
		return usermessage;
	}
	
	public void selectCustomerDropDownBox() {
		
		PageUtility pageutility = new PageUtility();
		pageutility.selectByVisibleText(Customer, "Shoney (12)");
	}

}
