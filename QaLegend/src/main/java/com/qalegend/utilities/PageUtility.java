package com.qalegend.utilities;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	WebDriver driver;
	JavascriptExecutor js;

	
    public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);

	}

	public void selectByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);

	}

	public void selectDropDownByIndexValue(WebElement element, int value) {
		Select select = new Select(element);
		select.selectByIndex(value);
	}

	public boolean is_Selected(WebElement element) {
		return element.isSelected();
	}

	public boolean is_Displayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean is_Enabled(WebElement element) {
		return element.isEnabled();
	}

	public void alert_Accept() {
		driver.switchTo().alert().accept();
	}

	public void alert_Dismiss() {
		driver.switchTo().alert().dismiss();
	}

	public void alert_GetText() {
		driver.switchTo().alert().getText();
	}

	public void alert_SendKeys(String key) {
		driver.switchTo().alert().sendKeys(key);
	}

	public void scrollAndClick(WebElement element) {
		int y = 0;
		while (clickStatus(element)) {
			js.executeScript("window.scrollBy(0," + y + ")");
			y = y + 5;
		}

	}

	public boolean clickStatus(WebElement element) {
		try {
			element.click();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public void contextClick(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	public void moveToElement(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void doubleClick(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public void elementTODragAndDrop(WebElement elementDragged, WebElement elementPlaced) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(elementDragged, elementPlaced).perform();
	}

	public void javaScriptExecutorClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click;", element);
	}

	public void javaScriptExecutorScrollInToView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void javaScriptExecutorScrollForWard(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}

	public void javaScriptExecutorScrollBackWard(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)", "");
	}

	public String toGetAttributeValue(WebElement element, String attribute) {
		String attributeValue = element.getAttribute(attribute);
		return attributeValue;
	}

	public void navigateToBack(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void fileUpload(WebElement element,String path) throws Exception {
		Actions action=new Actions(driver);
		Robot robot=new Robot();
		Thread.sleep(1000);
		action.moveToElement(element).click().perform();
		StringSelection ss = new StringSelection(path);                             //for copying filepath to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
			
		}

}
