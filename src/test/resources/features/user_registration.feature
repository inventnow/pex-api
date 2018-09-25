Feature: Add user should be successfull

  Scenario: Customer register to PEX API
    Given a customer want to register with data "/mock/request/register_customer.json"
    When a customer send his data to API
    Then the status code is 201