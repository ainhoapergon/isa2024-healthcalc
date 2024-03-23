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
Feature: Ideal Weight Calculation
  As a person using the calculator, I want to calculate my ideal weight, so that I can establish a fitness planning based on my results.

  @tag1
  Scenario Outline: Computing the ideal weight of a person
    Given I have a health calculator
    When I compute the ideal weight with <height> and <gender>
    Then The system returns <value>

   	Examples: 
      | height | gender | value |
      | 180    |   "m"  | 73.0  |
      | 192    |   "m"  | 82.0  |
      | 155    |   "w"  | 53.0  |
      | 172    |   "w"  | 63.2  |

  @tag2
  Scenario Outline: Computing the ideal weight with an invalid gender
    Given I have a health calculator
    When I compute the ideal weight with a valid height <height> but invalid gender <gender>
    Then The system raises an exception
   
   	Examples: 
      | height | gender |
      |  160   |   "g"  |
      |  173   |   "b"  |

  @tag3
  Scenario Outline: Computing the ideal weight with a invalid height
    Given I have a health calculator
    When I compute the ideal weight with an invalid height <height> but valid gender <gender>
    Then The system raises an exception
   
   	Examples: 
      |  height | gender |
      |  0      |  "m"   |
      | -180    |  "m"   |
      | -165    |  "w"   |


      
