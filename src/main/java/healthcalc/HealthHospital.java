package healthcalc;

/**
 * Versión de la calculadora de salud para el Hospital de Marbella
 * 
 * @author ISA
 *
 */

public interface HealthHospital {
	/**
	 * Calcula la Tasa Metabólica Basal (TMB) de una persona utilizando la siguiente fórmula
	 * Para hombres: TMB = 10 * peso + 6.25 * altura - 5 * edad + 5
	 * Para mujeres: TMB = 10 * peso + 6.25 * altura - 5 * edad - 161
	 *   
	 * @param peso	    El peso de una persona (en gramos).
	 * @param altura 	La altura de una persona (en metros).
	 * @param genero	El género de una persona ('m' or 'w').
	 * @param edad		La edad de una persona.
	 * @return	  		La Tasa Metabólica Basal (TMB o BMR) ded una persona.
	 * @throws Exception
	 */
	public double bmr(char genero, int edad, float altura, int peso) throws Exception;

     /**
	 * Calcula el peso ideal (PI) de una persona siguiendo la fórmula de Lorentz:
	 * Para hombres: PI = altura - 100 - (altura - 150) / 4
	 * Para mujeres: PI = altura - 100 - (altura - 150) / 2.5)
	 *
	 * @param altura 	Altura de la persona (m).
	 * @param genero	Género de la persona ('m' or 'w').
	 * @return 		 	Peso ideal de la persona (en gramos).
	 * @throws Exception 
	 */
	public int pesoIdeal(char genero, float altura) throws Exception;
}
