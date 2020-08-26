package com.uiAutomation.helper;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.uiAutomation.applicationPages.IPageData;
import com.uiAutomation.driver.DriverManager;
import com.uiAutomation.driver.DriverManagerFactory;
import com.uiAutomation.driver.DriverType;

public class LaunchWebUrl extends CommonUtils implements IPageData {

	DriverManager webDr;
	
	boolean returnValue = false;
	
	public boolean loadAppUrl() throws Exception {
			webDr = DriverManagerFactory.getManager(DriverType.CHROME);
			DriverManager.driver = webDr.getDriver();
			DriverManager.driver.manage().deleteAllCookies();
			DriverManager.driver.navigate().to("https://uk.babbel.com/");
			waitForPageLoaded();
			test.log(Status.INFO, "Verify the application is loaded successfully");
			WebElement loginPageELement = findElement(webElemProp.getProperty("HOMEPAGE_HEADER"), LocatorTypes.CSS);
			returnValue = loginPageELement.isDisplayed();

			returnValue &= DriverManager.driver.getTitle().equalsIgnoreCase(APPLICATION_PAGE_TITLE);

			if (returnValue) {
				test.log(Status.PASS, "The method <b>loadAppUrl passed");
			} else {
				test.log(Status.FAIL, "The method <b>loadAppUrl failed");
			}
			return returnValue;

	}

}
