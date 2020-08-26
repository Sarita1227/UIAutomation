package com.uiAutomation.testRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

	
	@RunWith(Cucumber.class)

	@CucumberOptions(
			features = "src/test/java/com/uiAutomation/features/Application.feature",
			glue = { "src/test/java/com/uiAutomation/stepDefinition" },
			plugin = { "pretty", "html:test-output/cucumber-html-report", "json:test-output/cucumber.json",
					"junit:test-output/cucumber.xml"}, 

			monochrome = true,
			strict = false, 
			dryRun = true)


	public class TestRunner {
		private static ExtentHtmlReporter htmlReporter;
		private static ExtentReports extent;
		
		
		@BeforeClass
		public static void beforeclass(){
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/extent-report.html");
			extent = new ExtentReports();
		    extent.attachReporter(htmlReporter);
		    htmlReporter.config().setDocumentTitle("Feature Report");
		    htmlReporter.config().setReportName("Test Report");
		    
		    htmlReporter.config().setTheme(Theme.STANDARD);
		    htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
			
		}
		
		public static ExtentHtmlReporter getHtmlReporter() {
			return htmlReporter;
		}

		public static ExtentReports getExtent() {
			return extent;
		}
	    
		@AfterClass
		public static void afterClass(){
			extent.flush();
		}

}
