@GuardianNewsValidation

Feature: Confirm validity of The Guardian News

  Background: Search Google for news published in The Guardian news and confirm the validity of article


  @newsValidation
  Scenario Outline: Verify Valid News
    Given User launches Chrome Browser
    When User opens link "https://www.theguardian.com/tone/news"
    Then Verify if page title is displayed as "News | The Guardian"
    And Verify the logo for The Guardian exists in the page
    And Verify if article section is loaded successfully
    When User picks the article no "<serial no>" from The Guardian Page
    Then User launches another Chrome Browser
    And User opens link "https://www.google.com"
    Then Verify if page title is displayed as "Google"
    And Verify the google page is loaded
    Then User searches the news header from The Guardian Page in Google
    And Verify similar information on Google
    Then Confirm the news is valid or fake

    Examples:
      | serial no |
      | 1         |