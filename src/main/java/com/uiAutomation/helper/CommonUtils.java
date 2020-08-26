package com.uiAutomation.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.uiAutomation.driver.DriverManager;

public class CommonUtils {

	public static Properties webElemProp = new Properties();
	public static ExtentTest test;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	static {
		org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.OFF);
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/extent-report.html");
		extent = new ExtentReports();
	    extent.attachReporter(htmlReporter);
	    htmlReporter.config().setDocumentTitle("Feature Report");
	    htmlReporter.config().setReportName("Test Report");
	    
	    htmlReporter.config().setTheme(Theme.STANDARD);
	    htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	    getElementsPath("webElement.properties");
	}

	public static ExtentTest getTest() {
		return test;
	}

	/**
	 * Wait for Page loaded
	 * 
	 * @throws Exception
	 */
	public void waitForPageLoaded() throws Exception {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};

		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(DriverManager.driver, 30);
		wait.until(expectation);
	}

	public static void getElementsPath(String fileName) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/inputSheets/" + fileName));
			webElemProp.load(reader);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Properties getWebElementProperties() {
		return webElemProp;
	}

	/**
	 * Click on element
	 * 
	 * @param element
	 */
	public void click(WebElement element) {
		element.click();
	}


	/**
	 * Select dropdown by value
	 * 
	 * @param element
	 * @param value
	 */
	public void selectDropdownElement(String element, String value, LocatorTypes type) {
		List<WebElement> elementList = findElements(element, type);
		for (WebElement elem : elementList) {
			if (elem.getText().equals(value)) {
				elem.click();
				break;
			}
		}
	}

	public boolean setAndVerifyFieldValue(String element, LocatorTypes type, String value) {
		boolean returnValue = false;
		WebElement ele = findElement(element, type);
		ele.sendKeys(value);
		ele.sendKeys(Keys.TAB);
		returnValue = ele.getText().equals(value) || ele.getAttribute("value").equals(value);
		return returnValue;

	}

	public void enterData(String element, String value, LocatorTypes type) {
		WebElement ele = findElement(element, type);
		ele.sendKeys(value);
		ele.sendKeys(Keys.TAB);

	}

	public boolean isElementNotPresent(String element, long timeUnit) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.driver, timeUnit);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(element)));
			return false;
		} catch (NoSuchElementException e) {
			return true;
		}
	}

	public void waitForElementVisibility(String element, int time) {
		WebDriverWait wait = new WebDriverWait(DriverManager.driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));

	}

	/**
	 * Follow a common pattern to
	 * 
	 * @param locatorName
	 * @return
	 */
	public WebElement findElement(String locatorName, LocatorTypes type) {
		WebElement element = null;
		switch (type) {
		case CSS:
			element = DriverManager.driver.findElement(By.cssSelector((locatorName)));
			break;
		case XPATH:
			element = DriverManager.driver.findElement(By.xpath((locatorName)));
			break;
		case ID:
			element = DriverManager.driver.findElement(By.id((locatorName)));
			break;
		case CLASSNAME:
			element = DriverManager.driver.findElement(By.className((locatorName)));
			break;
		case LINKTEXT:
			element = DriverManager.driver.findElement(By.linkText((locatorName)));
			break;
		case NAME:
			element = DriverManager.driver.findElement(By.name((locatorName)));
			break;
		case PARTIALLINKTEXT:
			element = DriverManager.driver.findElement(By.partialLinkText((locatorName)));
			break;
		case TAGNAME:
			element = DriverManager.driver.findElement(By.tagName((locatorName)));
			break;
		default:
			element = DriverManager.driver.findElement(By.xpath((locatorName)));
			break;
		}

		return element;
	}

	/**
	 * Find list of webElements
	 * 
	 * @param locatorName
	 * @param type
	 * @return
	 */
	public List<WebElement> findElements(String locatorName, LocatorTypes type) {
		List<WebElement> element = null;
		switch (type) {
		case CSS:
			element = DriverManager.driver.findElements(By.cssSelector((locatorName)));
			break;
		case XPATH:
			element = DriverManager.driver.findElements(By.xpath((locatorName)));
			break;
		case ID:
			element = DriverManager.driver.findElements(By.id((locatorName)));
			break;
		case CLASSNAME:
			element = DriverManager.driver.findElements(By.className((locatorName)));
			break;
		case LINKTEXT:
			element = DriverManager.driver.findElements(By.linkText((locatorName)));
			break;
		case NAME:
			element = DriverManager.driver.findElements(By.name((locatorName)));
			break;
		case PARTIALLINKTEXT:
			element = DriverManager.driver.findElements(By.partialLinkText((locatorName)));
			break;
		case TAGNAME:
			element = DriverManager.driver.findElements(By.tagName((locatorName)));
			break;
		default:
			element = DriverManager.driver.findElements(By.xpath((locatorName)));
			break;
		}

		return element;
	}

	public void scrollToView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

}
