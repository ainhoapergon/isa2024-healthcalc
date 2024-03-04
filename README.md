# isa2024-healtcalc
Health calculator

This calculator is designed to calculate ideal weight and Basal Metabolic Rate (BMR) for an individual.

# Health Calculator Test Cases

This section outlines the test cases for the Health Calculator.

## Ideal Weight Calculation

- **Test Case 1: Ideal Weight for Men**
  - Description: Calculate the ideal weight for a man based on his height.
  - Input: Height (in centimeters) and male gender character ("m").
  - Expected Output: Ideal weight (in kilograms).

- **Test Case 2: Ideal Weight for Women**
  - Description: Calculate the ideal weight for a woman based on her height.
  - Input: Height (in centimeters) and female gender character ("w").
  - Expected Output: Ideal weight (in kilograms).

- **Test Case 3: Invalid Gender for Ideal Weight**
  - Description: Ensure the calculator throws an error when an invalid gender is entered.
  - Input: Height (in centimeters) and an invalid gender character (other than "m" or "w").
  - Expected Outcome: An error message indicating the gender is invalid.

- **Test Case 4: Invalid Gender for Ideal Weight**
  - Description: Ensure the calculator throws an error when an invalid gender is entered.
  - Input: Invalid Height (could be a negative value) and a gender character.
  - Expected Outcome: An error message indicating the height is invalid.

## Basal Metabolic Rate Calculation

- **Test Case 4: Basal Metabolic Rate for Men**
  - Description: Calculate the BMR for a man based on his weight, height, and age.
  - Input: Weight (in kilograms), height (in centimeters), gender ("m"), age (in years).
  - Expected Output: BMR value.

- **Test Case 5: Basal Metabolic Rate for Women**
  - Description: Calculate the BMR for a woman based on her weight, height, and age.
  - Input: Weight (in kilograms), height (in centimeters), gender("w"), age (in years).
  - Expected Output: BMR value.

- **Test Case 6: Invalid Gender for BMR**
  - Description: Ensure the calculator throws an error when invalid gender is entered for BMR calculation.
  - Input: Invalid gender character (other than "m" or "w").
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

