package healthcalc;

public class HealthHospitalAdapter implements HealthHospital {
    private HealthCalc calculadora;

    public HealthHospitalAdapter(HealthCalc calculadora) {
        this.calculadora = calculadora;
    }

    @Override
    public double bmr(char genero, int edad, float altura, int peso) throws Exception {
        // Convertimos el peso de g a kg y la altura de m a cm para usar HealthCalcImpl 
        float pesoEnKg = peso/1000.0f;
        int alturaEnCm = (int)(altura*100);

        try {
            return calculadora.basalMetabolicRate(pesoEnKg, alturaEnCm, genero, edad);
        } catch(Exception e) {
            throw new Exception("No se ha podido calcular el BMR.");
        }
    }

    @Override
    public int pesoIdeal(char genero, float altura) throws Exception {
        int alturaEnCm = (int)(altura*100);
        
        try {
            return (int)calculadora.idealWeight(alturaEnCm, genero)*1000;   // Devuelve el peso ideal en gramos
        } catch(Exception e) {
            throw new Exception("No se ha podido calcular el peso ideal.");
        }
    }
}
