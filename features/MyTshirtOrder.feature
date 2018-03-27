Feature: Order confirmation verification in 'practice automation' online shopping portal

  Scenario: Place an order for a T-shirt using practice automation portal and verify in Order History
    Given user logs in to the application
    When user orders a tshirt
    Then orderId is displayed in order history

  Scenario: Update personal information in my account
    Given user logs in to the application
    When user edits user account details
    Then user details are updated
