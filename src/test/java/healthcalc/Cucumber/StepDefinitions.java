package healthcalc.Cucumber;

import org.junit.jupiter.api.Assertions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import healthcalc.Gender;
import healthcalc.HealthCalcImpl;

public class StepDefinitions {
	
	private HealthCalcImpl calculator;
	private double result;
	private boolean raiseException;
	
	@Before
	public void initialization() {
		calculator = null;
	    result = -1;
	    raiseException = false;
	}
	
	@Given("I have a health calculator")
    public void i_have_a_health_calculator() {
        // calculator = new HealthCalcImpl();
        HealthCalcImpl calculator = HealthCalcImpl.getInstancia();
    }
	
	@When("I compute the ideal weight with {int} and {string}")
    public void i_compute_the_ideal_weight(int height, String gender) throws Exception {
        Gender newGender = Gender.valueOf(gender.toUpperCase());
		result = calculator.idealWeight(height, newGender);
    }

	@Then("The system returns {float}")
    public void the_system_returns(double expected) {
        Assertions.assertEquals(expected, result, 0.01);
    }

	@When("I compute the ideal weight with a valid height {int} but invalid gender {string}")
    public void i_compute_the_ideal_weight_with_invalid_gender(int height, String gender) throws Exception {
        try {
            Gender newGender = Gender.valueOf(gender.toUpperCase());
            result = calculator.idealWeight(height, newGender);
        } catch (Exception e) {
            raiseException = true;
        }   
    }

	@When("I compute the ideal weight with an invalid height {int} but valid gender {string}")
    public void i_compute_the_ideal_weight_with_invalid_height(int height, String gender) throws Exception {
        try {
            Gender newGender = Gender.valueOf(gender.toUpperCase());
            result = calculator.idealWeight(height, newGender);
        } catch (Exception e) {
            raiseException = true;
        }   
    }

    @When("I compute the BMR using {float}, {int}, {string} and {int}")
    public void i_compute_the_BMR(float weight, int height, String gender, int age) throws Exception {
        Gender newGender = Gender.valueOf(gender.toUpperCase());
        result = calculator.basalMetabolicRate(weight, height, newGender, age); 
    }

    @When("I compute the BMR using valid {float}, {int}, {string} but invalid age {int}")
    public void i_compute_the_BMR_with_invalid_age(float weight, int height, String gender, int age) throws Exception {
        try {
            Gender newGender = Gender.valueOf(gender.toUpperCase());
            result = calculator.basalMetabolicRate(weight, height, newGender, age);
        } catch (Exception e) {
            raiseException = true;
        }       
    }

    @When("I compute the BMR using valid {float}, {int}, invalid {string} and valid {int}")
    public void i_compute_the_BMR_with_invalid_gender(float weight, int height, String gender, int age) throws Exception {
        try {
            Gender newGender = Gender.valueOf(gender.toUpperCase());
            result = calculator.basalMetabolicRate(weight, height, newGender, age);
        } catch (Exception e) {
            raiseException = true;
        }       
    }

    @When("I compute the BMR using valid {float}, invalid {int}, and valid {string}, {int}")
    public void i_compute_the_BMR_with_invalid_height(float weight, int height, String gender, int age) throws Exception {
        try {
            Gender newGender = Gender.valueOf(gender.toUpperCase());
            result = calculator.basalMetabolicRate(weight, height, newGender, age);
        } catch (Exception e) {
            raiseException = true;
        }       
    }

    @When("I compute the BMR using invalid {float} and valid {int}, {string}, {int}")
    public void i_compute_the_BMR_with_invalid_weight(float weight, int height, String gender, int age) throws Exception {
        try {
            Gender newGender = Gender.valueOf(gender.toUpperCase());
            result = calculator.basalMetabolicRate(weight, height, newGender, age);
        } catch (Exception e) {
            raiseException = true;
        }       
    }

	@Then("The system raises an exception")
    public void the_system_raises_an_exception() {
        Assertions.assertTrue(raiseException);
    }
}
