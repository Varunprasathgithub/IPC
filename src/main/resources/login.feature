Feature: Login

  Scenario: Login to portal using valid login details

    Given I launch the URL
    And I am on the login page
    When I enter "prevajprojects@gmail.com" in the email field
    And I enter "prevaj@123" in the password field
    And I click on submit button
    Then I should be logged in successfully
    #And I close the road map popup
    And I close the browser session

  Scenario: Login to portal incorrect email

    Given I launch the URL
    And I am on the login page
    When I enter "prevajprojectsss@gmail.com" in the email field
    And I enter "prevaj@123" in the password field
    And I click on submit button
    Then I should (not) be logged in successfully
    And I verify the warning message
    And I close the browser session

  Scenario: Login to portal incorrect password

    Given I launch the URL
    And I am on the login page
    When I enter "prevajprojects@gmail.com" in the email field
    And I enter "prevaj@123456789" in the password field
    And I click on submit button
    Then I should (not) be logged in successfully
    And I verify the warning message
    And I close the browser session

  Scenario: Login to portal incorrect email and password

    Given I launch the URL
    And I am on the login page
    When I enter "prevajprojectsss@gmail.com" in the email field
    And I enter "prevaj@123456789" in the password field
    And I click on submit button
    Then I should (not) be logged in successfully
    And I verify the warning message
    And I close the browser session

  Scenario: Warning message when email feild is empty
    Given I launch the URL
    And I am on the login page
    When I enter "" in the email field
    And I enter "prevaj@123" in the password field
    Then I should see warning message under email feild
    And I close the browser session






