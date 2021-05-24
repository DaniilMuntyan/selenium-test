Feature: Epam website
  Scenario: Changing language to Polska
    Given I am on the main web page
    When I change location by clicking on Global (Polska)
    Then I should see page was translated
  Scenario: Getting to "contact us"
    Given I am on the main web page
    When I click "contact us" button
    Then I should get redirected to the contact us page
  Scenario: Check the event
    Given About-who-we-are page opened
    When I click on "meet us"
    Then I should get all information about the event
  Scenario: Seeing cybersecurity latest works of the company
    Given Cybersecurity web page opened
    When I click on "EXPLORE OUR LATEST WORK"
    Then I should see several links to the pages with text describing the work
  Scenario: Privacy policy
    Given I am on the main web page
    When I click on privacy policy link
    Then I should be redirected to Privacy policy page
  Scenario: Accessing FAQ
    Given I am on the main web page
    When I click on FAQ
    Then I should be redirected to the FAQ page
  Scenario: Search bar:
    Given I am on the main web page
    When I click on search symbol
    Then I should see search input box
  Scenario: Email
    Given Careers page opened in By location
    When I go to contacts of the company
    Then I should be able to find the mail of company