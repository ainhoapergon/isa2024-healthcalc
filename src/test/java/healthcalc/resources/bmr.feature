#Author: ainhoapergon@uma.es
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And, But: To enumerate more Given, When, Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@tag
Feature: BMR Calculation
  As a person using the calculator, I want to calculate my BMR, so that I can establish a diet with the calories I should consume to maintain my current weight.

  @tag1
  Scenario Outline: Computing the ideal weight of a person
    Given I have a health calculator
    When I compute the BMR using <weight>, <height>, <gender> and <age>
    Then The system returns <value>

   	Examples: 
      | weight | height | gender |  age |  value  |
      |   95   |  180   |  "m"   |  28  |  1940.0 |
      |   88   |  192   |  "m"   |  35  |  1910.0 |
      |   56   |  155   |  "w"   |  17  | 1282.75 |
      |   75   |  172   |  "w"   |  43  |  1449.0 |

  @tag2
  Scenario Outline: Computing the ideal weight of a person with invalid age
    Given I have a health calculator
    When I compute the BMR using valid <weight>, <height>, <gender> but invalid age <age>
    Then The system raises an exception

   	Examples: 
      | weight | height | gender |  age |
      |   95   |  180   |  "m"   |  0   |
      |   88   |  192   |  "m"   | -16  |
      |   56   |  155   |  "w"   |  0   |
      |   75   |  172   |  "w"   | -56  |

  @tag3
  Scenario Outline: Computing the ideal weight of a person with invalid gender
    Given I have a health calculator
    When I compute the BMR using valid <weight>, <height>, invalid <gender> and valid <age>
    Then The system raises an exception

   	Examples: 
      | weight | height | gender |  age |
      |   95   |  180   |  "p"   |  28  |
      |   88   |  192   |  "b"   |  35  |
      |   56   |  155   |  "z"   |  17  |
      |   75   |  172   |  "g"   |  43  |

  @tag4
  Scenario Outline: Computing the ideal weight of a person with invalid height
    Given I have a health calculator
    When I compute the BMR using valid <weight>, invalid <height>, and valid <gender>, <age>
    Then The system raises an exception

   	Examples: 
      | weight | height  | gender |  age |
      |   95   |  -180   |  "m"   |  28  |
      |   88   |  -192   |  "m"   |  35  |
      |   56   |  0      |  "w"   |  17  |
      |   75   |  -172   |  "w"   |  43  |

  @tag5
  Scenario Outline: Computing the ideal weight of a person with invalid weight
    Given I have a health calculator
    When I compute the BMR using invalid <weight> and valid <height>, <gender>, <age>
    Then The system raises an exception

   	Examples: 
      | weight | height | gender |  age |
      |   -95  |  180   |  "m"   |  28  |
      |   -88  |  192   |  "m"   |  35  |
      |   0    |  155   |  "w"   |  17  |
      |   -75  |  172   |  "w"   |  43  |