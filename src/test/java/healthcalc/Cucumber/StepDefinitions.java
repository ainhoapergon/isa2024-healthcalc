package healthcalc.Cucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;

//import org.junit.jupiter.api.Assertions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
// import static org.junit.Assert.*;
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
        calculator = new HealthCalcImpl();
    }
	
	@When("I compute the ideal weight with {int} and {string}")
    public void i_compute_the_ideal_weight_with_and(int height, String gender) throws Exception {
		result = calculator.idealWeight(height, gender.charAt(0));
    }

	@Then("The system returns {double}")
    public void the_system_returns(double expected) {
        assertEquals(expected, result, 0.01);
    }

	@When("I compute the ideal weight with a valid height {int} but invalid gender {string}")
    public void i_compute_the_ideal_weight_with_a_valid_height_but_invalid_gender(int height, String gender) throws Exception {
        try {
            result = calculator.idealWeight(height, gender.charAt(0));
        } catch (Exception e) {
            raiseException = true;
        }   
    }

	@When("I compute the ideal weight with an invalid height {int} but valid gender {string}")
    public void i_compute_the_ideal_weight_with_an_invalid_height_but_valid_gender(int height, String gender) throws Exception {
        try {
            result = calculator.idealWeight(height, gender.charAt(0));
        } catch (Exception e) {
            raiseException = true;
        }   
    }

	@Then("The system raises an exception")
    public void the_system_raises_an_exception() {
        Assertions.assertTrue(raiseException);
    }
}
