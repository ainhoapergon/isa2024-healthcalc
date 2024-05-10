# Health calculator
  
> **Project title: isa2024-healtcalc**

> **Author: Ainhoa Pérez González**

*Content:*

- [Practice 1](#practice-1)
- [Practice 2](#practice-2)
- [Practice 3](#practice-3)
- [Practice 4](#practice-4)
- [Practice 5](#practice-5)
- [Practice 6](#practice-6)


# Practice 1

This calculator is designed to calculate *ideal weight* and *Basal Metabolic Rate (BMR)* for an individual.
We have two methods in our java class HealthCalcImpl.java for each calculation: idealWeight() and basalMetabolicRate().

All the possible input parameters are:

| Parameters | Measurements                 |
|------------|------------------------------|
|  Height    | in centimeters               |
|  Gender    |'m' for man and 'w' for woman |
|  Weight    | in kilograms                 |
|  Age       | in years                     |

Both methods handle possible exceptions (errors) if the individual has any invalid parameter (explained ahead in the **Health Calculator Test Cases section**)

## Repository state

This repository has the following structure:
- Main branch which contains the final code.
- HealthCalcImpl branch which contains every changes or corrections on both tests and the main java class codes.

Here is the diagram with all the "commits" used:

![Commits image](./images/commits.png "All commits")

(All the images uploaded into GitHub were also a commit named "Subida de fotos para completar archivo README.md" but this
last commit was done after taking the screenshot. Also the final commit to post the final "README.md" is called "Actualización README.md").

## Health Calculator Test Cases

This section outlines the test cases for the Health Calculator.

![Tests image](./images/tests.png "Test Results")

Here is a short explanation of each one:


### Ideal Weight Calculation

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

### Basal Metabolic Rate Calculation

- **Test Case 5: Basal Metabolic Rate for Men**
  - Description: Calculate the BMR for a man based on his weight, height, and age.
  - Input: Weight (in kilograms), height (in centimeters), gender ('m'), age (in years).
  - Expected Output: BMR value.

- **Test Case 6: Basal Metabolic Rate for Women**
  - Description: Calculate the BMR for a woman based on her weight, height, and age.
  - Input: Weight (in kilograms), height (in centimeters), gender('w'), age (in years).
  - Expected Output: BMR value.

- **Test Case 7: Invalid Gender for BMR**
  - Description: Ensure the calculator throws an error when invalid gender is entered for BMR calculation.
  - Input: Invalid gender character (other than 'm' or 'w').
  - Expected Outcome: An error message indicating that gender is invalid.

- **Test Case 8: Invalid Age for BMR**
  - Description: Ensure the calculator throws an error when invalid age is entered for BMR calculation.
  - Input: Negative or zero values for age.
  - Expected Outcome: An error message indicating that age is invalid.

- **Test Case 9: Invalid Height for BMR**
  - Description: Ensure the calculator throws an error when invalid height is entered for BMR calculation.
  - Input: Negative or zero values for height.
  - Expected Outcome: An error message indicating that height is invalid.

- **Test Case 10: Invalid Weight for BMR**
  - Description: Ensure the calculator throws an error when invalid weight is entered for BMR calculation.
  - Input: Negative or zero values weight.
  - Expected Outcome: An error message indicating that weight is invalid.

# Practice 2

In this practice we will be seeing the use cases for our calculator. The use cases diagram is a method for describing the functional requirements of a system from the perspective of its users. In this diagram we see the actors and the actions we can achieve using the system.

I will be using **Dia Diagram Editor** to create my diagrams (it is a free software).

## Use cases - First diagram

In this first diagram we can see that the person (actor) can use the system to calculate the ideal weight or the basal metabolic rate (BMR). In order to do that, the person must enter the parameters needed for every calculation (for example, when calculating ideal weight, the person must enter height and gender). The system will handle the possible errors when entering a wrong parameter (for example, when entering a negative age).

![Diagram1 image](./images/UseCases1.png "Use Cases 1")

### Use case: Calculate Basal Metabolic Rate (BMR)

In this section I will be specifying some aspects for the use case for calculating the basal metabolic rate in our calculator.

- **Use Case Name**: Calculate Basal Metabolic Rate (BMR)
- **Primary Actor**: Person
- **Scope**: Health Calculator Application
- **Level**: User-goal level
- **Stakeholders and interests**:
  - A person who wants to know their BMR for a fitness planning.
  - A nutritionist or other health professional that find useful calculating BMR to provide dietary or exercise guidance.
- **Preconditions**: The calculator application is operational and accesible to the person.
- **Minimum guarantees**: The calculator will not crash and will handle invalid parameters.
- **Success guarantees**: The BMR will be calculated correctly according to the provided inputs.
- **Main success Scenario**: The person introduces valid parameters and the calculator displays the person's BMR.
- **Alternate Scenario**: The person introduces invalid parameters and the calculator shows an error.
- **Possible Extensions**: The calculator could allow the person to log in and save their data for future use.

## Use cases - Second diagram

Now I will be creating another use cases diagram but implementing two more possible use cases. The calculator could be able to calculate the ideal weight, basal metabolic rate (BMR), heart rate zones and Body Mass Index (BMI). **Heart rate zones** are typically calculated using a person's maximum heart rate (MHR) and resting heart rate (RHR). However, MHR can be estimated only using age if the actual max heart rate is not known. The **BMI** can be calculated using weight and height, knowing that the formula is weight(kg)/height^2(m). So it won't be necessary to add more parameters to our calculator. The second use cases diagram implementing those new cases should look like:

![Diagram2 image](./images/UseCases2.png "Use Cases 2")

# Practice 3

## User Stories for Health Calc

### User Story 1: Ideal Weight Calculation

- As a **person using the calculator**
- I want **to calculate my ideal weight**
- So that **I can establish a fitness planning based on my results**

*Acceptance Criteria:*

* First Scenario:
  - **Given**: an user that enters correctly their height and gender.
  - **When**: the user requests to calculate the ideal weight.
  - **Then**: the calculator returns the ideal weight according to their data.
    
* Second Scenario:
  - **Given**: an user that enters valid height and invalid gender.
  - **When**: the user requests to calculate the ideal weight.
  - **Then**: the calculator returns an error message saying "Invalid Gender".

* Third Scenario:
  - **Given**: an user that enters invalid height and valid gender
  - **When**: the user requests to calculate the ideal weight
  - **Then**: the calculator returns an error message saying "Invalid Height"


### User Story 2: Basal Metabolic Rate (BMR) Calculation

- As a **person using the calculator**
- I want **to calculate my BMR**
- So that **I can establish a diet with the calories I should consume to maintain my current weight**

*Acceptance Criteria:*
    
* First Scenario:
  - **Given**: an user that enters correctly weight, height, gender and age.
  - **When**: the user requests to calculate BMR.
  - **Then**: the calculator returns the BMR according to their data.
    
* Second Scenario:
  - **Given**: an user that enters valid weight, height, gender but invalid age.
  - **When**:  the user requests to calculate BMR.
  - **Then**: the calculator returns an error message saying "Invalid Age".
    
* Third Scenario:
  - **Given**: an user that enters valid weight, height, age but invalid gender.
  - **When**:  the user requests to calculate BMR.
  - **Then**: the calculator returns an error message saying "Invalid Gender".
    
* Fourth Scenario:
  - **Given**: an user that enters valid weight, age, gender but invalid height.
  - **When**: the user requests to calculate BMR.
  - **Then**: the calculator returns an error message saying "Invalid Height".
    
* Fifth Scenario:
  - **Given**: an user that enters valid height, age, gender but invalid weight.
  - **When**: the user requests to calculate BMR.
  - **Then**: the calculator returns an error message saying "Invalid Weight".

## BDD Tests using Cucumber

We have two feature archives for every user story: ["bmr.feature"](./src/test/java/healthcalc/resources/bmr.feature) and ["idealw.feature"](./src/test/java/healthcalc/resources/idealw.feature.feature). Also we have the Step Definitions according to each scenario.

In file ["output_tests.txt"](./doc/output_tests.txt) we can check out the exit in console when running the BDD tests using cucumber:

![Tests image](./images/testsCucumber.png "Cucumber tests")

 
# Practice 4

In this section, we will design the graphical interface of our calculator. First, we will create a **prototype interface** using the mockup design software "Pencil Project". Then, we will **develop the interface** with the help of the extension for the Eclipse IDE "Windows Builder".

## Prototype interface

As mentioned, I will be using "Pencil Project" to create the prototype. This previous design pops up two windows: one to use the calculator and the other one that shows up the result.

### Health Calculator Window

This window contains various panels. The first one is the introducing data section where the user must enter their gender, age, weight and height. Afterwards the data has been introduced, the user must select the calculation that wants to be computed. When every valid data is entered and the calculation has been selected, the user must press the button "Calculate". Meanwhile, the system will give some feedback on the calculation process (a progress bar for example).

### Results Window

This window contains the result. There are two more buttons here: the "Go back" button and the "New Calculation" button.

- **Go back**: This button will close the results window and take the user back to the health calculator saving the data introduced before, if there is a need to change any parameter or make another calculation with the same data.
- **New calculation**: This button will close the results window and take the user back but clearing the previous data from the health calculation to use it again.

Here an image of both windows for the interface. I could not change the background colours or any other details as it is a prototype.

![Prototype interface](./images/prototipo.png "Prototype interface")

## Graphical interface

In this section I developed a MVC (Model-View-Controller) for my calculator. I created two views (one for the calculator and another one for the results), the controller and the main program to execute and initialize them all. You can find all these archives on folder "gui" inside src/main. Here is the shortcut:

- ["Calculator View"](./src/main/java/healthcalc/gui/CalcVista.java)
- ["Results View"](./src/main/java/healthcalc/gui/ResultVista.java)
- ["Controller"](./src/main/java/healthcalc/gui/Controlador.java)
- ["Main program"](./src/main/java/healthcalc/gui/Main.java)

When I finished all these sections, I made a [".jar runnable"](HealthCalculator.jar) using Eclipse IDE. These archive can be executed in terminal using the following command on the current directory: "java -jar HealthCalculator.jar".

Here is the final view when executing it:

![Graphical interface](./images/interfazGrafica.png "Graphical interface")


# Practice 5

In this practice we will be evaluating two graphical interfaces from our classmates. I will be evaluating calculator D and calculator F.
Both reports will be available in folder "evaluation".

Some points to consider in this evaluation are feedback, metaphor, navigation, consistency, prevention, memory, efficiency, design, recovery, help and more.

- ["Calculator D report"](./evaluation/CalcD.pdf)
- ["Calculator F report"](./evaluation/CalcF.pdf)


# Practice 6

In this practice we will be seeing various **design patterns** for our calculator.

## Singleton pattern

First of all we will be applying the singleton pattern to our calculator to guarantee we only create one instance of our calculator. In order to do that, we will be modifying our version of ["HealthCalcImpl"](./src/main/java/healthcalc/HealthCalcImpl.java) as shown in the following class diagram:

![Singleton pattern](./design_patterns/Singleton.png "Singleton pattern")

The main changes are the private constructor and the new method to get the class instance. 

## Adapter pattern

The Costa del Sol hospital is now interested in our health calculator project, but they want to use a different interface called *HealthHospital*. This interface calculates as well the Basal Netabolic Rate and the Ideal Weight but using height in meters (instead of centimeters) and weight in grams (instead of kilograms). As it is incompatible with our first implementation, I will be using the adapter design pattern to avoid this problem and re-use our calculator and its methods. The Adapter design pattern allows objects with incompatible interfaces to interact by acting as a bridge between them. It's used to integrate classes that couldn't otherwise work together due to mismatched interfaces. All changes are shown in the following class diagram:

![Adapter pattern](./design_patterns/Adapter.png "Adapter pattern")

We used the ["HealthHospital"](./src/main/java/healthcalc/HealthHospital.java) interface and we created the ["HealthHospitalAdapter"](./src/main/java/healthcalc/HealthHospitalAdapter.java). class, which will "bridge" both interfaces.

## Registry proxy pattern

We have also been asked to keep a record of the number of times the calculator is used in the computer system, storing the patients data anonymously to calculate the average of the values entered and calculated. For this situation we have been given another interface called *HealthStats*. In this case we will be applying the registry proxy pattern which will store all the parameters and calculate all averages. All the changes are shown in the following class diagram:

![Registry proxy pattern](./design_patterns/Proxy.png "Registry proxy pattern")

We used the ["HealthStats"](./src/main/java/healthcalc/HealthStats.java) interface and the new class called ["HealthCalcProxy"](./src/main/java/healthcalc/HealthCalcProxy.java) which will store all data and manage the average calculations.

## Decorator pattern

Lastly, but not last, the Costa del Sol hospital asked us as well to create two different versions of our calculator: an *american version* and an *european version*.

- The American version will calculate the Basal Metabolic Rate and Ideal Weight using the patient's height in **feet** and the patient's weight in **pounds**. 
- The European version will calculate the Basal Metabolic Rate and Ideal Weight using the patient's height in **meters** and the patient's weight in **grams**.

Also, the system must show a message of the parameters introduced and the final calculation. This message will be shown in both languages: spanish and english (regardless the version type selected).

As our implementation HealthCalcImpl uses height in centimeters and weight in kilograms, I will be applying a decorator pattern. In order to do that we will have another abstract class called ["HealthCalcDecorator"](./src/main/java/healthcalc/HealthCalcDecorator.java), which will be the "Base Decorator". Then, two more classes that extends the previous one called ["AmericanCalcDecorator"](./src/main/java/healthcalc/AmericanCalcDecorator.java) and ["EuropeanCalcDecorator"](./src/main/java/healthcalc/EuropeanCalcDecorator.java). Each one will handle the calculations needed in their own metrics.

All changes applied are shown in the following class diagram:

![Decorator pattern](./design_patterns/Decorator.png "Decorator pattern")

## Implementation Verification

I have created some instances and simulated data to verify every pattern implementation in the ["Main"](./src/main/java/healthcalc/gui/Main.java) method. Here are the obtained results: 

![Implementation verification](./images/patterns.png "Implementation verification")






