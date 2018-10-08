Feature: Add user scenarios

  Scenario: Customer register to PEX API
    Given a customer want to register with data "/mock/request/register_customer.json"
    When a customer send his data to API
    Then the status code is 201

  Scenario: Customer register to PEX API with invalid email should failed
    Given a customer want to register with data "/mock/request/register_customer_invalid_email.json"
    When a customer send his data to API
    Then the status code is 400

  Scenario: Customer register to PEX API with empty identity no
    Given a customer want to register with data "/mock/request/register_customer_empty_identityno.json"
    When a customer send his data to API
    Then the status code is 400