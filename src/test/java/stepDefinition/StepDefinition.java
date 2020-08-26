package stepDefinition;

import java.util.Map;

import org.junit.Assert;

import com.aventstack.extentreports.Status;
import com.uiAutomation.applicationPages.ApplicationPageMethod;
import com.uiAutomation.applicationPages.IPageData;
import com.uiAutomation.helper.CommonUtils;
import com.uiAutomation.helper.LaunchWebUrl;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import testRunner.TestRunner;

public class StepDefinition extends CommonUtils implements IPageData{

	boolean testResult = false;
	
	ApplicationPageMethod pageMethods = new ApplicationPageMethod();
	LaunchWebUrl launchUrl = new LaunchWebUrl();

	@Given("^User is in application page$")
	public void verify_User_Is_Already_In_HomePage() {
		test = TestRunner.getExtent().createTest("Test Step : verify_User_Is_Already_In_HomePage");
		try {
			testResult = pageMethods.verifyApplicationPageContent();
		} catch (Exception e) {
			test.log(Status.WARNING, "Error occured !!!" + e);
			testResult &= false;
		}
		Assert.assertEquals(true, testResult);
	}

	@Then("^Select display language as (.*) and verify selected language page (.*) is changed$")
	public void select_Display_Language_And_Verify_Selected_Language_Page_Changed(String language, String URL) {
		test = TestRunner.getExtent().createTest("Test Step : selectDisplayLanguageAs " + language + " AndVerifySelectedLanguagePageChanged");
		try {
			testResult = pageMethods.changeDisplayLanguage(language, URL);
			
		} catch (Exception e) {
			test.log(Status.WARNING, "Error occured !!!" + e);
			testResult &= false;
		}

		Assert.assertEquals(true, testResult);
	    
	}

	@Then("^Go back to home page and verify (.*) is displayed$")
	public void goBack_To_Home_Page_and_verify_page_is_displayed(String pageURl) {
		test = TestRunner.getExtent().createTest("Test Step : goBack_To_Home_Page_and_verify_page_is_displayed");
		try {
			testResult = pageMethods.navigateBackToPreviousPage(pageURl);
			
		} catch (Exception e) {
			test.log(Status.WARNING, "Error occured !!!" + e);
			testResult &= false;
		}

		Assert.assertEquals(true, testResult);
	}

	@Then("^User selects (.*) and click on get started$")
	public void user_selects_language_and_click_on_get_started(String language) {
		test = TestRunner.getExtent().createTest("Test Step : user_selects_language_ " + language + " and_click_on_get_started");
		try {
			testResult = pageMethods.selectLanguageAndGetStarted(language);
			
		} catch (Exception e) {
			test.log(Status.WARNING, "Error occured !!!" + e);
			testResult &= false;
		}

		Assert.assertEquals(true, testResult);
	}

	@Then("^User verify the language (.*) and all learning options$")
	public void user_verify_the_language_Why_are_you_learning_German_and_all_learning_options(String pageHeader) {
		test = TestRunner.getExtent().createTest(
				"Test Step : user_verify_the_language_Why_are_you_learning_German_and_all_learning_options");
		try {
			testResult = pageMethods.verifyPageHeaderAndContentItems(pageHeader,
					webElemProp.getProperty("LANGUAGE_PAGE_HEADER"), webElemProp.getProperty("LANGUAGE_PAGE_LEARNING_REASON_OPTION"),
					LEARNING_REASON_OPTIONS);

		} catch (Exception e) {
			test.log(Status.WARNING, "Error occured !!!" + e);
			testResult &= false;
		}

		Assert.assertEquals(true, testResult);
	}


	@Then("^User navigate back to the home page$")
	public void user_navigate_back_to_the_home_page() {
		test = TestRunner.getExtent().createTest("Test Step : user_is_in_application_homepage");
		try {
			testResult = pageMethods.navigateBackToPreviousPage(APPLICATION_URL);
			
		} catch (Exception e) {
			test.log(Status.WARNING, "Error occured !!!" + e);
			testResult &= false;
		}

		Assert.assertEquals(true, testResult);
	}

	@Given("^User is in application homepage$")
	public void user_is_in_application_homepage() {
		test = TestRunner.getExtent().createTest("Test Step : user_is_in_application_homepage");
		try {
			testResult = pageMethods.verifyApplicationPageContent();
			
		} catch (Exception e) {
			test.log(Status.WARNING, "Error occured !!!" + e);
			testResult &= false;
		}

		Assert.assertEquals(true, testResult);
	}

	@Then("^User Clicks on Register button$")
	public void user_Clicks_on_Register_button(DataTable mapData) {
		test = TestRunner.getExtent().createTest("Test Step : user_Clicks_on_Register_button");
		try {
			for (Map<String, String> data : mapData.asMaps(String.class, String.class)) {
			testResult = pageMethods.registerForLearning(data.get("Page Header"));
			}
			
		} catch (Exception e) {
			test.log(Status.WARNING, "Error occured !!!" + e);
			testResult &= false;
		}

		Assert.assertEquals(true, testResult);
	}

	@Then("^Verify user selects language to learn from different language options$")
	public void verify_user_selects_language_to_learn_from_different_language_options(DataTable mapData) {
		test = TestRunner.getExtent().createTest("Test Step : verify_user_selects_language_to_learn_from_different_language_options");
		try {
				for (Map<String, String> data : mapData.asMaps(String.class, String.class)) {
					testResult = pageMethods.verifyDisplayedLanguageAndSelectLanguageForRegister(data.get("Language"));
				}	
		} catch (Exception e) {
			test.log(Status.WARNING, "Error occured !!!" + e);
			testResult &= false;
		}

		Assert.assertEquals(true, testResult);
	}
	
	@Then("^Verify register language page is opened with different learning options$")
	public void verify_register_language_page_is_opened_with_different_learning_options(DataTable mapData) {
		test = TestRunner.getExtent()
				.createTest("Test Step : verify_register_language_page_is_opened_with_different_learning_options");
		try {
			for (Map<String, String> data : mapData.asMaps(String.class, String.class)) {
				testResult = pageMethods.verifyPageHeaderAndContentItems(data.get("Page Header"),
						webElemProp.getProperty("LANGUAGE_PAGE_HEADER"),
						webElemProp.getProperty("LANGUAGE_PAGE_LEARNING_REASON_OPTION"), LEARNING_REASON_OPTIONS);
			}
		} catch (Exception e) {
			test.log(Status.WARNING, "Error occured !!!" + e);
			testResult &= false;
		}

		Assert.assertEquals(true, testResult);
	}

	@Then("^Navigate back and verify language selection page is displayed and navigate back to homepage$")
	public void navigate_back_and_verify_language_selection_page_is_displayed() {
		test = TestRunner.getExtent()
				.createTest("Test Step : navigate_back_and_verify_language_selection_page_is_displayed");
		try {
			testResult = pageMethods.navigateBackFromMutiplePages();

		} catch (Exception e) {
			test.log(Status.WARNING, "Error occured !!!" + e);
			testResult &= false;
		}

		Assert.assertEquals(true, testResult);
	}



}
