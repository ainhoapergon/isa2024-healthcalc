# Health calculator
  
- **Project title: isa2024-healtcalc**
- **Author: Ainhoa Pérez González**

This calculator is designed to calculate *ideal weight* and *Basal Metabolic Rate (BMR)* for an individual.
We have two methods in our java class HealthCalcImpl.java for each calculation: idealWeight() and basalMetabolicRate().

All the possible input parameters are:
- Height (in centimeters).
- Gender ('m' for man and 'w' for woman).
- Weight (in kilograms).
- Age (in years).

Both methods handle possible exceptions (errors) if the individual has any invalid parameter (explained ahead in the **Health Calculator Test Cases section**)

# Repository state

This repository has the following structure:
- Main branch which contains the final code.
- HealthCalcImpl branch which contains every changes or corrections on both tests and the main java class codes.

Here is the diagram with all the "commits" used:

![Commits image](./images/commits.png "All commits")

(All the images uploaded into GitHub were also a commit named "Subida de fotos para completar archivo README.md" but this
last commit was done after taking the screenshot. Also the final commit to post the final "README.md" is called "Actualización README.md").

# Health Calculator Test Cases

This section outlines the test cases for the Health Calculator.

![Tests image](./images/tests.png "Test Results")

Here is a short explanation of each one:

## Ideal Weight Calculation

- **Test Case 1: Ideal Weight for Men**
  - Description: Calculate the ideal weight for a man based on his height.
  - Input: Height (in centimeters) and male gender character ('m').
  - Expected Output: Ideal weight (in kilograms).

- **Test Case 2: Ideal Weight for Women**
  - Description: Calculate the ideal weight for a woman based on her height.
  - Input: Height (in centimeters) and female gender character ('w').
  - Expected Output: Ideal weight (in kilograms).

- **Test Case 3: Invalid Height for Ideal Weight**
  - Description: Ensure the calculator throws an error when an invalid height is entered.
  - Input: Negative or zero values for height.
  - Expected Outcome: An error message indicating the height is invalid.

- **Test Case 4: Invalid Gender for Ideal Weight**
  - Description: Ensure the calculator throws an error when an invalid gender is entered.
  - Input: Invalid gender character (other than 'm' or 'w').
  - Expected Outcome: An error message indicating the gender is invalid.

## Basal Metabolic Rate Calculation

- **Test Case 4: Basal Metabolic Rate for Men**
  - Description: Calculate the BMR for a man based on his weight, height, and age.
  - Input: Weight (in kilograms), height (in centimeters), gender ('m'), age (in years).
  - Expected Output: BMR value.

- **Test Case 5: Basal Metabolic Rate for Women**
  - Description: Calculate the BMR for a woman based on her weight, height, and age.
  - Input: Weight (in kilograms), height (in centimeters), gender('w'), age (in years).
  - Expected Output: BMR value.

- **Test Case 6: Invalid Gender for BMR**
  - Description: Ensure the calculator throws an error when invalid gender is entered for BMR calculation.
  - Input: Invalid gender character (other than 'm' or 'w').
  - Expected Outcome: An error message indicating that gender is invalid.

- **Test Case 7: Invalid Age for BMR**
  - Description: Ensure the calculator throws an error when invalid age is entered for BMR calculation.
  - Input: Negative or zero values for age.
  - Expected Outcome: An error message indicating that age is invalid.

- **Test Case 8: Invalid Height for BMR**
  - Description: Ensure the calculator throws an error when invalid height is entered for BMR calculation.
  - Input: Negative or zero values for height.
  - Expected Outcome: An error message indicating that height is invalid.

- **Test Case 9: Invalid Weight for BMR**
  - Description: Ensure the calculator throws an error when invalid weight is entered for BMR calculation.
  - Input: Negative or zero values weight.
  - Expected Outcome: An error message indicating that weight is invalid.

