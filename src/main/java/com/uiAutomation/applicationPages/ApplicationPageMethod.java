package com.uiAutomation.applicationPages;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.uiAutomation.driver.DriverManager;
import com.uiAutomation.helper.CommonUtils;
import com.uiAutomation.helper.LocatorTypes;

public class ApplicationPageMethod extends CommonUtils implements IPageData {
	
	boolean returnValue = false;
	
	/**
	 * Verify application page content is displayed
	 * @return
	 */
	public boolean verifyApplicationPageContent() {
		test.log(Status.INFO, "Verify the user is in application homepage");
		WebElement pageContent = findElement(webElemProp.getProperty("APPPLICATION_PAGE_CONTENT"), LocatorTypes.CSS);
		returnValue = pageContent.getText().trim().equals(APPLICATION_PAGE_CONTENT);
		returnValue &= DriverManager.driver.getCurrentUrl().equals(APPLICATION_URL);
		if (returnValue) {
			test.log(Status.PASS, "The method <b>changeDisplayLanguage passed");
		} else {
			test.log(Status.FAIL, "The method <b>changeDisplayLanguage failed");
		}

		return returnValue;
	}
	
	/**
	 * Verify user can change display language 
	 * @param itemName
	 * @param expectedUrl
	 * @return
	 * @throws InterruptedException
	 */
	public boolean changeDisplayLanguage(String itemName, String expectedUrl) throws InterruptedException {
		test.log(Status.INFO, "Verify Current Display language is name is displayed on dropdown field");
		WebElement dropdownField = findElement(webElemProp.getProperty("DISPLAY_LANGUAGE_DROPDOWN"), LocatorTypes.CSS);
		returnValue = dropdownField.getText().equals(DEFAULT_DISPLAY_LANGUAGE);

		test.log(Status.INFO, "Click on the dropdown and verify dropdown is opened");
		click(dropdownField);
		WebElement dropdownItem = findElement(webElemProp.getProperty("DISPLAY_LANGUAGE_DROPDOWN_SECTION"),
				LocatorTypes.CSS);
		returnValue &= dropdownItem.isDisplayed();
		test.log(Status.INFO, "Select a language from the dropdown items");
		selectDropdownElement(webElemProp.getProperty("DISPLAY_LANGUAGE_DROPDOWN_SECTION"), itemName, LocatorTypes.CSS);
		Thread.sleep(3000);
		test.log(Status.INFO, "Verify the selected language page is loaded");
		returnValue &= DriverManager.driver.getCurrentUrl().equals(expectedUrl);

		if (returnValue) {
			test.log(Status.PASS, "The method <b>changeDisplayLanguage passed");
		} else {
			test.log(Status.FAIL, "The method <b>changeDisplayLanguage failed");
		}

		return returnValue;
	}
	
	/**
	 * Navigate back to previous page
	 * @param homePageUrl
	 * @return
	 * @throws InterruptedException
	 */
	public boolean navigateBackToPreviousPage(String homePageUrl) throws InterruptedException {
		String currentUrl = DriverManager.driver.getCurrentUrl();
		returnValue = !currentUrl.equals(homePageUrl);
		test.log(Status.INFO, "Execute browser back and verify the previous page is displayed");

		DriverManager.driver.navigate().back();
		Thread.sleep(3000);

		returnValue &= DriverManager.driver.getCurrentUrl().equals(homePageUrl);
		if (returnValue) {
			test.log(Status.PASS, "The method <b>navigateBackToPreviousPage passed");
		} else {
			test.log(Status.FAIL, "The method <b>navigateBackToPreviousPage failed");
		}

		return returnValue;
	}

	/**
	 * Select language to learn and click on get started
	 * @param language
	 * @return
	 */
	public boolean selectLanguageAndGetStarted(String language) {
		test.log(Status.INFO, "Click on select language dropdown and verify dropdown is displayed");
		WebElement selectLanguage = findElement(webElemProp.getProperty("LEARN_LANGUAGE_DROPDOWN"), 
				LocatorTypes.CSS);
		returnValue = selectLanguage.getText().equals("Spanish");
		click(selectLanguage);
		test.log(Status.INFO, "Select language you want to learn");
		selectDropdownElement(webElemProp.getProperty("LEARN_LANGUAGE_DROPDOWN_SECTION"), language, LocatorTypes.CSS);
		returnValue &= selectLanguage.getText().equals(language);
		test.log(Status.INFO, "Click on get started");
		WebElement getStarted = findElement(webElemProp.getProperty("GET_STARTED_BTN"), 
				LocatorTypes.CSS);
		returnValue &= getStarted.isDisplayed();
		click(getStarted);
		waitForElementVisibility(webElemProp.getProperty("LANGUAGE_PAGE_HEADER"), 60);
		WebElement pageheader = findElement(webElemProp.getProperty("LANGUAGE_PAGE_HEADER"), LocatorTypes.CSS);
		returnValue &= pageheader.isDisplayed();
		if (returnValue) {
			test.log(Status.PASS, "The method <b>selectLanguageAndGetStarted passed");
		} else {
			test.log(Status.FAIL, "The method <b>selectLanguageAndGetStarted failed");
		}

		return returnValue;
	}
	
	/**
	 * Verify the requested page is displayed and verify page items
	 * @param languageHeader
	 * @param element
	 * @param expectedArray
	 * @return
	 */
	public boolean verifyPageHeaderAndContentItems(String languageHeader, String pageEle, String element, String[] expectedArray) {
		test.log(Status.INFO, "Verify the selected page is displayed");
		WebElement pageHeader = findElement(pageEle, LocatorTypes.CSS);
		returnValue = pageHeader.isDisplayed() && pageHeader.getText().equals(languageHeader);
		test.log(Status.INFO, "Verify all the options are displayed");
		returnValue &= commonMethodToCompareList(element, expectedArray);
		if (returnValue) {
			test.log(Status.PASS, "The method <b>verifyLanguagePageContent passed");
		} else {
			test.log(Status.FAIL, "The method <b>verifyLanguagePageContent failed");
		}

		return returnValue;
	}
	
	/**
	 * Common method to verify item in list
	 * @param element
	 * @param expectedArray
	 * @return
	 */
	public boolean commonMethodToCompareList(String element, String[] expectedArray) {
		List<WebElement> learningReason = findElements(element, LocatorTypes.CSS);
		returnValue = !learningReason.isEmpty();
		List<String> actualOpt = new ArrayList<String>();
		for (WebElement elem : learningReason) {
			actualOpt.add(elem.getText().trim());
		}
		for (int i = 0; i < expectedArray.length; i++) {
			returnValue &= actualOpt.contains(expectedArray[i]);

			if (!returnValue) {
				test.log(Status.FAIL, "The expected list " + actualOpt + " doesnot contain the expected item "
						+ expectedArray[i]);
			}

		}

		return returnValue;
	}
	
	/**
	 * Register for learning new language
	 * @return
	 */
	public boolean registerForLearning(String registerLangHeader) {
		test.log(Status.INFO, "Verify register button is enabled");
		WebElement registerBtn = findElement(webElemProp.getProperty("REGISTER_BTN"), LocatorTypes.CSS);
		returnValue = registerBtn.isDisplayed();
		test.log(Status.INFO, "Click on register button");
		click(registerBtn);
		waitForElementVisibility(webElemProp.getProperty("REGISTRATION_PAGE_LANGUAGE_HEADER"), 60);
		WebElement pageheader = findElement(webElemProp.getProperty("REGISTRATION_PAGE_LANGUAGE_HEADER"), LocatorTypes.CSS);
		returnValue &= pageheader.isDisplayed() && pageheader.getText().equals(registerLangHeader);
		if (returnValue) {
			test.log(Status.PASS, "The method <b>registerForLearning passed");
		} else {
			test.log(Status.FAIL, "The method <b>registerForLearning failed");
		}
		return returnValue;
	}
	
	/**
	 * Verify the language contains different language and click on a language to learn
	 * @param language
	 * @return
	 */
	public boolean verifyDisplayedLanguageAndSelectLanguageForRegister(String language) {
		test.log(Status.INFO, "Verify the Language page on register displays multiple languages");
		returnValue = commonMethodToCompareList(webElemProp.getProperty("LANGUAGE_ITEMS"), LEARNING_LANGUAGE_OPTIONS);
		test.log(Status.INFO, "Select a language to learn");
		List<WebElement> languageLearn = findElements(webElemProp.getProperty("LANGUAGE_ITEMS"), LocatorTypes.CSS);
		for(WebElement elem : languageLearn) {
			if(elem.getText().trim().equals(language)) {
				test.log(Status.INFO, "Select " + language + " to learn");
				elem.click();
				break;
			}
		}
		waitForElementVisibility(webElemProp.getProperty("LANGUAGE_PAGE_HEADER"), 60);
		if (returnValue) {
			test.log(Status.PASS, "The method <b>verifyDisplayedLanguageAndSelectLanguageForRegister passed");
		} else {
			test.log(Status.FAIL, "The method <b>verifyDisplayedLanguageAndSelectLanguageForRegister failed");
		}
		return returnValue;
	}
	
	/**
	 * Navigate back from different pages to home page
	 * @return
	 * @throws InterruptedException
	 */
	public boolean navigateBackFromMutiplePages() throws InterruptedException {
		test.log(Status.INFO, "Navigate from from register language reason page to select language page");
		returnValue = navigateBackToPreviousPage(LANGUAGE_PAGE_URL);
		test.log(Status.INFO, "Navigate back to home page fromselect language page");
		returnValue &= navigateBackToPreviousPage(APPLICATION_URL);

		if (returnValue) {
			test.log(Status.PASS, "The method <b>navigateBackFromMutiplePages passed");
		} else {
			test.log(Status.FAIL, "The method <b>navigateBackFromMutiplePages failed");
		}
		return returnValue;
	}
}
