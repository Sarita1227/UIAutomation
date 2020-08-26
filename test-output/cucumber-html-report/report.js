$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/Application.feature");
formatter.feature({
  "line": 1,
  "name": "Application functionality test",
  "description": "",
  "id": "application-functionality-test",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "User can select any language to learn on register",
  "description": "",
  "id": "application-functionality-test;user-can-select-any-language-to-learn-on-register",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "User is in application homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User Clicks on Register button",
  "rows": [
    {
      "cells": [
        "Page Header"
      ],
      "line": 8
    },
    {
      "cells": [
        "What language do you want to learn?"
      ],
      "line": 9
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Verify user selects language to learn from different language options",
  "rows": [
    {
      "cells": [
        "Language"
      ],
      "line": 11
    },
    {
      "cells": [
        "German"
      ],
      "line": 12
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "Verify register language page is opened with different learning options",
  "rows": [
    {
      "cells": [
        "Page Header"
      ],
      "line": 14
    },
    {
      "cells": [
        "Why are you learning German?"
      ],
      "line": 15
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "Navigate back and verify language selection page is displayed and navigate back to homepage",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.user_is_in_application_homepage()"
});
formatter.result({
  "duration": 361858905,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_Clicks_on_Register_button(DataTable)"
});
formatter.result({
  "duration": 3453678310,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.verify_user_selects_language_to_learn_from_different_language_options(DataTable)"
});
formatter.result({
  "duration": 2254751686,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.verify_register_language_page_is_opened_with_different_learning_options(DataTable)"
});
formatter.result({
  "duration": 167158242,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.navigate_back_and_verify_language_selection_page_is_displayed()"
});
formatter.result({
  "duration": 7214954807,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 18,
  "name": "User can change display language",
  "description": "",
  "id": "application-functionality-test;user-can-change-display-language",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 19,
  "name": "User is in application page",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "Select display language as \u003cDisplay Language\u003e and verify selected language page \u003cURL\u003e is changed",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "Go back to home page and verify \u003cHomePage\u003e is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 22,
  "name": "User selects \u003cLearn Language\u003e and click on get started",
  "keyword": "Then "
});
formatter.step({
  "line": 23,
  "name": "User verify the language \u003cPage Header\u003e and all learning options",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "User navigate back to the home page",
  "keyword": "Then "
});
formatter.examples({
  "line": 26,
  "name": "",
  "description": "",
  "id": "application-functionality-test;user-can-change-display-language;",
  "rows": [
    {
      "cells": [
        "Display Language",
        "URL",
        "HomePage",
        "Learn Language",
        "Page Header"
      ],
      "line": 27,
      "id": "application-functionality-test;user-can-change-display-language;;1"
    },
    {
      "cells": [
        "Italiano",
        "https://it.babbel.com/?locale\u003dit",
        "https://uk.babbel.com/",
        "German",
        "Why are you learning German?"
      ],
      "line": 28,
      "id": "application-functionality-test;user-can-change-display-language;;2"
    },
    {
      "cells": [
        "Deutsch",
        "https://de.babbel.com/?locale\u003dde",
        "https://uk.babbel.com/",
        "Italian",
        "Why are you learning Italian?"
      ],
      "line": 29,
      "id": "application-functionality-test;user-can-change-display-language;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 28,
  "name": "User can change display language",
  "description": "",
  "id": "application-functionality-test;user-can-change-display-language;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 19,
  "name": "User is in application page",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "Select display language as Italiano and verify selected language page https://it.babbel.com/?locale\u003dit is changed",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "Go back to home page and verify https://uk.babbel.com/ is displayed",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 22,
  "name": "User selects German and click on get started",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 23,
  "name": "User verify the language Why are you learning German? and all learning options",
  "matchedColumns": [
    4
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "User navigate back to the home page",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.verify_User_Is_Already_In_HomePage()"
});
formatter.result({
  "duration": 87118985,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Italiano",
      "offset": 27
    },
    {
      "val": "https://it.babbel.com/?locale\u003dit",
      "offset": 70
    }
  ],
  "location": "StepDefinition.select_Display_Language_And_Verify_Selected_Language_Page_Changed(String,String)"
});
formatter.result({
  "duration": 5286147493,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "https://uk.babbel.com/",
      "offset": 32
    }
  ],
  "location": "StepDefinition.goBack_To_Home_Page_and_verify_page_is_displayed(String)"
});
formatter.result({
  "duration": 3509918017,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "German",
      "offset": 13
    }
  ],
  "location": "StepDefinition.user_selects_language_and_click_on_get_started(String)"
});
formatter.result({
  "duration": 3526131662,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Why are you learning German?",
      "offset": 25
    }
  ],
  "location": "StepDefinition.user_verify_the_language_Why_are_you_learning_German_and_all_learning_options(String)"
});
formatter.result({
  "duration": 207744935,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_navigate_back_to_the_home_page()"
});
formatter.result({
  "duration": 3340436264,
  "status": "passed"
});
formatter.scenario({
  "line": 29,
  "name": "User can change display language",
  "description": "",
  "id": "application-functionality-test;user-can-change-display-language;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 19,
  "name": "User is in application page",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "Select display language as Deutsch and verify selected language page https://de.babbel.com/?locale\u003dde is changed",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "Go back to home page and verify https://uk.babbel.com/ is displayed",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 22,
  "name": "User selects Italian and click on get started",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 23,
  "name": "User verify the language Why are you learning Italian? and all learning options",
  "matchedColumns": [
    4
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "User navigate back to the home page",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.verify_User_Is_Already_In_HomePage()"
});
formatter.result({
  "duration": 31075971,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Deutsch",
      "offset": 27
    },
    {
      "val": "https://de.babbel.com/?locale\u003dde",
      "offset": 69
    }
  ],
  "location": "StepDefinition.select_Display_Language_And_Verify_Selected_Language_Page_Changed(String,String)"
});
formatter.result({
  "duration": 5036361851,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "https://uk.babbel.com/",
      "offset": 32
    }
  ],
  "location": "StepDefinition.goBack_To_Home_Page_and_verify_page_is_displayed(String)"
});
formatter.result({
  "duration": 3433617148,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Italian",
      "offset": 13
    }
  ],
  "location": "StepDefinition.user_selects_language_and_click_on_get_started(String)"
});
formatter.result({
  "duration": 3014760485,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Why are you learning Italian?",
      "offset": 25
    }
  ],
  "location": "StepDefinition.user_verify_the_language_Why_are_you_learning_German_and_all_learning_options(String)"
});
formatter.result({
  "duration": 170992270,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_navigate_back_to_the_home_page()"
});
formatter.result({
  "duration": 3308236963,
  "status": "passed"
});
});