Feature: Employee Management Service
  This feature deals with the Employee Management Service functionality of the application

  @regression
  Scenario Outline: Create an employee <testId>
    Given the employee's first name is "<firstName>"
    And the employee's last name is "<lastName>"
    And the employee's email is "<emailId>"
    When the create employee API is called
    Then the response status code should be 201
    And the response body should contain the employee's id, first name, last name, and email
    Examples:
    | testId | firstName | lastName | emailId                |
     | 1| murali1    | domda    | murali.domda@gmail.com |
    | 2 | murali2    | domda    | murali.domda@gmail.com |
    | 3 | murali3    | domda    | murali.domda@gmail.com |
    |4  | murali4    | domda    | murali.domda@gmail.com |
    | 5 | murali5    | domda    | murali.domda@gmail.com |



