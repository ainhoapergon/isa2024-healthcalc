package healthcalc;

/**
 * Registro de la calculadora. 
 * 
 * @author ISA
 *
 */

public interface HealthStats {

    /**
     * Método para calcular la altura media de todos los registros recogidos en la calculadora.
     * @return altura media de los registros.
     */
    public float alturaMedia();
    
    /**
     * Método para calcular el peso medio de todos los registros recogidos en la calculadora.
     * @return peso medio de los registros.
     */
    public float pesoMedio();

    /**
     * Método para calcular la edad media de todos los registros recogidos en la calculadora.
     * @return edad media de los registros.
     */
    public float edadMedia();

    /**
     * Método para calcular el BMR medio de todos los registros recogidos en la calculadora.
     * @return BMR medio de los registros.
     */
    public float bmrMedio();

    /**
     * Método para calcular el número total de hombres dentro de los registros recogidos en la calculadora.
     * @return Número total de hombres en los registros.
     */
    public int numSexoH();

    /**
     * Método para calcular el número total de mujeres dentro de los registros recogidos en la calculadora.
     * @return Número total de mujeres en los registros.
     */
    public int numSexoM();

        /**
     * Método para calcular el número total de pacientes (hombres y mujeres) dentro de los registros recogidos en la calculadora.
     * @return Número total de pacientes en los registros.
     */
    public int numTotalPacientes();

}
