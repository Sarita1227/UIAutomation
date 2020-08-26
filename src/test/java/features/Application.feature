Feature: Application functionality test 



Scenario: User can select any language to learn on register 
	Given User is in application homepage 
	Then  User Clicks on Register button 
		|Page Header |
		|What language do you want to learn? |
	Then Verify user selects language to learn from different language options 
		|Language |
		|German   |
	Then Verify register language page is opened with different learning options 
		|Page Header                   |
		|Why are you learning German?  |
	Then Navigate back and verify language selection page is displayed and navigate back to homepage 
	
Scenario Outline: User can change display language 
	Given User is in application page 
	Then Select display language as <Display Language> and verify selected language page <URL> is changed 
	Then Go back to home page and verify <HomePage> is displayed 
	Then User selects <Learn Language> and click on get started 
	Then User verify the language <Page Header> and all learning options 
	Then User navigate back to the home page 
	
	Examples: 
		| Display Language | URL                              | HomePage               |Learn Language |Page Header 				 |
		| Italiano		   | https://it.babbel.com/?locale=it | https://uk.babbel.com/ | German        |Why are you learning German? |
		| Deutsch          | https://de.babbel.com/?locale=de | https://uk.babbel.com/ | Italian       |Why are you learning Italian?|
		
	