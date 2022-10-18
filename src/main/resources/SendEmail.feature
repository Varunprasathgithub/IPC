Feature: SendEmail

  Scenario: Send single email

    Given I launch the URL
    And I am on the login page
    When I enter "prevajprojects@gmail.com" in the email field
    And I enter "prevaj@123" in the password field
    And I click on submit button
    Then I should be logged in successfully
    #And I close the road map popup
    And I click on staff emails button
    #And I close amy mail alert popup
    And I click on compose button
    And I click on single email button
    And I enter "jamesr@prevaj.com" in the To field
    And I click on send button
    And I click on send button in the popup
    Then I should see email is sent successfully