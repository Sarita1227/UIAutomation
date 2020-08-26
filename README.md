# UI Automation

This is the sample test automation task in which below test scenario is included:
####Scenario 1
Scenario: User can change display language <br />
User is in application page https://uk.babbel.com/ <br />
Select display language and verify selected language page URL is changed <br />
Go back to home page and verify HomePage is displayed <br />
User selects any language and click on get started <br />
User verify the language Page Header and all learning options <br />
User navigate back to the home page <br />
####Scenario 2
Scenario: User can select any language to learn on register <br />
User is in application homepage https://uk.babbel.com/ <br />
User Clicks on Register button <br />
Verify user selects language to learn from different language options <br />
Verify register language page is opened with different learning options 
Then Navigate back and verify language selection page is displayed and navigate back to homepage 

####Explanation
First scenario is tested for two different set of data using Scenario outline with example keyword whereas the second scenario is tested for single set of data using Datatable. The focus is only on the architecture not on the test cases. 

###Tool Used :-
####Selenium Cucumber With BDD
<b>Advantage<b><br />
	
It is one the efficient tool for testing<br />
Quick and easy set up and execution<br />
Style of writing tests allow for easier reuse of code in the tests<br />
Feature file contains the scenarios which is written in Simple English language <br />
It allows automation of functional validation in easily readable and understandable format (like plain English) to Business Analysts, Developers, Testers, etc<br />

# Getting Started

Please follow below instruction to copy the project and running on your local machine for testing purpose

#### Prerequisites

Maven home: apache-maven-3.6.3

Java version: 1.8.0_231, vendor: Oracle Corporation

Chrome version: Version 84.0.4147.135 (Official Build) (64-bit)


This test was done on MAC but if you are running this code in windows then please download the chromedriver.exe file for windows and replace the file present in Chromedriver folder placed inside the project<br />
File can be dowloaded from the below link <br />
https://chromedriver.storage.googleapis.com/index.html?path=84.0.4147.30/

Make sure your Chromedriver.exe file is compatible with your chrome version

# Running the tests

Given scenario is automated using selenium cucumber.
Gherkin language is used in cucumber for these scenario.

#### Below is the work flow of calling methods in this framework

Feature File >>>> Step Definition File >>>> Main File

For example: Feature file is created for Automation demo in which scenario is written in gherkin language.
This feature file calls step definition file through glue code.
Then step definition file calls main page file in which all methods are defined.


#####Sarita Dash
#####27thAug 2020
