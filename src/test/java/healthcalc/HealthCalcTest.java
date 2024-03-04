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
		int invalidHeight= 0;
		char gender = 'w';
		float expectedMen = (float)(invalidHeight-100-((invalidHeight-150)/2.5));
		assertThrows(Exception.class, () -> calculator.idealWeight(invalidHeight, gender));
	}

	@Test
	@DisplayName("Este test verifica si lanza correctamente la excepción  en el método idealWeight() en caso de género inválido.")
	public void testIdealWeightInvalidGender() throws Exception {
		// Completar
	}

	/*
	 * Tests para el método basalMetabolicRate() de la clase HealthCalcImpl
	 * Cada uno de estos tests verifica si se lanzan correctamente las excepciones para parámetros inválidos
	 * y si se devuelven correctamente los valores para el género masculino y para el género femenino.
	 */

	@Test
	@DisplayName("Este test verifica si devuelve correctamente la TMB para género masculino.")
	public void testBMRMen() throws Exception {
		// Completar
	}

	@Test
	@DisplayName("Este test verifica si devuelve correctamente la TMB para género femenino.")
	public void testBMRWomen() throws Exception {
		// Completar
	}

	@Test
	@DisplayName("Este test verifica si lanza correctamente la excepción en el método basalMetabolicRate() en caso de género inválido.")
	public void testBMRInvalidGender() throws Exception {
		// Completar
	}

	@Test
	@DisplayName("Este test verifica si lanza correctamente la excepción en el método basalMetabolicRate() en caso de edad inválida.")
	public void testBMRInvalidAge() throws Exception {
		// Completar
	}

	@Test
	@DisplayName("Este test verifica si lanza correctamente la excepción en el método basalMetabolicRate() en caso de altura inválida.")
	public void testBMRInvalidHeight() throws Exception {
		// Completar
	}

	@Test
	@DisplayName("Este test verifica si lanza correctamente la excepción en el método basalMetabolicRate() en caso de peso inválido.")
	public void testBMRInvalidWeight() throws Exception {
		// Completar
	}
}
