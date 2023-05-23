Feature: Employee Management Service
  This feature deals with the Employee Management Service functionality of the application

  @regression
  Scenario Outline: Create an employee "<testid>"
    Given the employee's first name is "<firstName>"
    And the employee's last name is "<lastName>"
    And the employee's email is "<emailId>"
    When the create employee API is called
    Then the response status code should be 201
    And the response body should contain the employee's id, first name, last name, and email
    Examples:
      | firstName | lastName | emailId                | testid |
      | murali6   | domda    | murali.domda@gmail.com | 6 |
      | murali7   | domda    | murali.domda@gmail.com | 7  |
      | murali8   | domda    | murali.domda@gmail.com | 8  |
      | murali9   | domda    | murali.domda@gmail.com | 9  |
      | murali10  | domda    | murali.domda@gmail.com | 10 |
