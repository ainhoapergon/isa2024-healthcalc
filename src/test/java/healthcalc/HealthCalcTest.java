package healthcalc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests para la calculadora de salud.")
public class HealthCalcTest {
	
	HealthCalc calculator = new HealthCalcImpl();
	
	/*
	 * Tests para el método idealWeight() de la clase HealthCalcImpl.
	 * Cada uno de estos tests verifica si se lanzan correctamente las excepciones para parámetros inválidos
	 * y si se devuelven correctamente los valores para el género masculino y para el género femenino.
	 */

	@Test
	@DisplayName("Este test verifica si devuelve correctamente el peso ideal masculino.")
	public void testIdealWeightMen() throws Exception {
		int heightMen = 180;
		char genderMen = 'm';
		float expectedMen = heightMen-100-((heightMen-150)/4);
		assertEquals(expectedMen, calculator.idealWeight(heightMen, genderMen));
	}
	
	@Test
	@DisplayName("Este test verifica si devuelve correctamente el peso ideal femenino.")
	public void testIdealWeightWomen() throws Exception {
		int heightWomen = 165;
		char genderWomen = 'w';
		float expectedMen = (float)(heightWomen-100-((heightWomen-150)/2.5));
		assertEquals(expectedMen, calculator.idealWeight(heightWomen, genderWomen));
	}

	@Test
	@DisplayName("Este test verifica si lanza correctamente la excepción en el método idealWeight() en caso de altura inválida.")
	public void testIdealWeightInvalidHeight() throws Exception {
		int invalidHeight = -10;
		char gender = 'w';
		assertThrows(Exception.class, () -> calculator.idealWeight(invalidHeight, gender));
		assertEquals("Invalid Height", (assertThrows(Exception.class, () -> calculator.idealWeight(invalidHeight, gender))).getMessage());
	}

	@Test
	@DisplayName("Este test verifica si lanza correctamente la excepción en el método idealWeight() en caso de género inválido.")
	public void testIdealWeightInvalidGender() throws Exception {
		int height = 180;
		char InvalidGender = 'f';
		assertThrows(Exception.class, () -> calculator.idealWeight(height, InvalidGender));
		assertEquals("Invalid Gender", (assertThrows(Exception.class, () -> calculator.idealWeight(height, InvalidGender))).getMessage());
	}

	/*
	 * Tests para el método basalMetabolicRate() de la clase HealthCalcImpl
	 * Cada uno de estos tests verifica si se lanzan correctamente las excepciones para parámetros inválidos
	 * y si se devuelven correctamente los valores para el género masculino y para el género femenino.
	 */

	@Test
	@DisplayName("Este test verifica si devuelve correctamente la TMB para género masculino.")
	public void testBMRMen() throws Exception {
		float weightMen = 90;
		int heightMen = 180;
		char genderMen = 'm';
		int ageMen = 50;
		float BMRMen = (float)(10*weightMen+6.25*heightMen-5*ageMen+5);
		assertEquals(BMRMen, calculator.basalMetabolicRate(weightMen, heightMen, genderMen, ageMen));
	}

	@Test
	@DisplayName("Este test verifica si devuelve correctamente la TMB para género femenino.")
	public void testBMRWomen() throws Exception {
		float weightWomen = 55;
		int heightWomen = 160;
		char genderWomen = 'w';
		int ageWomen = 30;
		float BMRWomen = (float)(10*weightWomen*6.25*heightWomen-5*ageWomen-161);
		assertEquals(BMRWomen, calculator.basalMetabolicRate(weightWomen, heightWomen, genderWomen, ageWomen));
	}

	@Test
	@DisplayName("Este test verifica si lanza correctamente la excepción en el método basalMetabolicRate() en caso de género inválido.")
	public void testBMRInvalidGender() throws Exception {
		float weight = 70;
		int height = 165;
		char invalidGender = 'f';
		int age = 45;
		assertThrows(Exception.class, () -> calculator.basalMetabolicRate(weight, height, invalidGender, age));
		assertEquals("Invalid Gender", (assertThrows(Exception.class, () -> calculator.basalMetabolicRate(weight, height, invalidGender, age))).getMessage());
	}

	@Test
	@DisplayName("Este test verifica si lanza correctamente la excepción en el método basalMetabolicRate() en caso de edad inválida.")
	public void testBMRInvalidAge() throws Exception {
		float weight = 70;
		int height = 165;
		char gender = 'w';
		int invalidAge = 0;
		assertThrows(Exception.class, () -> calculator.basalMetabolicRate(weight, height, gender, invalidAge));
		assertEquals("Invalid Age", (assertThrows(Exception.class, () -> calculator.basalMetabolicRate(weight, height, gender, invalidAge))).getMessage());
	}


	@Test
	@DisplayName("Este test verifica si lanza correctamente la excepción en el método basalMetabolicRate() en caso de altura inválida.")
	public void testBMRInvalidHeight() throws Exception {
		float weight = 70;
		int invalidHeight = -10;
		char gender = 'w';
		int age = 30;
		assertThrows(Exception.class, () -> calculator.basalMetabolicRate(weight, invalidHeight, gender, age));
		assertEquals("Invalid Height", (assertThrows(Exception.class, () -> calculator.basalMetabolicRate(weight, invalidHeight, gender, age))).getMessage());
	}

	@Test
	@DisplayName("Este test verifica si lanza correctamente la excepción en el método basalMetabolicRate() en caso de peso inválido.")
	public void testBMRInvalidWeight() throws Exception {
		float invalidWeight = -70;
		int height = 175;
		char gender = 'w';
		int age = 35;
		assertThrows(Exception.class, () -> calculator.basalMetabolicRate(invalidWeight, height, gender, age));
		assertEquals("Invalid Weight", (assertThrows(Exception.class, () -> calculator.basalMetabolicRate(invalidWeight, height, gender, age))).getMessage());
	}
}
