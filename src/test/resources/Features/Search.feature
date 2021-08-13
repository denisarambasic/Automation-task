Feature: Search Feature
  Scenario Outline: Check if first search result match timestamp
    Given user is on homepage
    When user enters search term as <searchTerm> and confirms search
    And user clicks on History tab to open the History page
    And user clicks on the filter tab to open the filter section
    And user enters filter date as <filterDate> and confirms search
    Then first search result timestamp matches expected timestamp as <expectedTimestamp>
    Examples:
      |searchTerm   |filterDate|expectedTimestamp       |
      |Juraj Dobrila|2020-07-01|22:33, 24. travnja 2020.|