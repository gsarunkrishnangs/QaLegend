package com.qalegend.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage {

	WebDriver driver;

	public ProductsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Products']")
	WebElement products_option;
	@FindBy(xpath = "//a[text()='List Products']")
	WebElement listproducts_menu;
	@FindBy(xpath = "//span[@id='select2-product_list_filter_type-container']")
	WebElement producttype_combobox;
	@FindBy(xpath = "//span[text()='Single']")
	WebElement producttype_item;
	@FindBy(xpath = "//span[@id='select2-product_list_filter_category_id-container']")
	WebElement category_combobox;
	@FindBy(xpath = "//span[@id='select2-product_list_filter_unit_id-container']")
	WebElement unit_combobox;
	@FindBy(xpath = "//span[@id='select2-product_list_filter_brand_id-container']")
	WebElement brand_combobox;
	@FindBy(xpath = "//div[text()='Showing 1 to 3 of 3 entries']")
	WebElement searchresult_message;

	public void clickOnProductsOption() {

		products_option.click();
	}

	public void clickOnProductsListMenu() {

		listproducts_menu.click();

	}

	public Select getProductTypeSelect() {

		return new Select(producttype_combobox);
	}

	public void setProductType() {

		getProductTypeSelect().selectByVisibleText("Single");

	}

	public void clickOnCategoryCombobox() {

		producttype_combobox.click();

	}

	public void clickOnProductTypeCombobox() {

		category_combobox.click();

	}

	public void clickOnUnitCombobox() {

		unit_combobox.click();

	}

	public void clickOnBrandCombobox() {

		brand_combobox.click();

	}

	public void setProductTypeComboboxValue() {

		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public void setCategoryComboboxValue() {

		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public void setUnitComboboxValue() {

		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public void setBrandComboboxValue() {

		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public String getSearchResultMessage() {

		String searchResult = searchresult_message.getText();
		return searchResult;
	}
}
