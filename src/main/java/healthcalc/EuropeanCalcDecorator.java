package healthcalc;

public class EuropeanCalcDecorator extends HealthCalcDecorator {

    public EuropeanCalcDecorator(HealthCalc calculadora) {
        super(calculadora, "EU");
    }

    @Override
    public float idealWeight(float height, char gender) throws Exception {
        try {
            // Convertimos a parámetros compatibles con HealthCalc
            float heightInCM = (height*100);         // Convertir m a cm
            float idealWeight = calculadora.idealWeight(heightInCM, gender);
            formatoIdealWeight(idealWeight, gender, height);
            return idealWeight;
        } catch (Exception e) {
            throw new Exception("No se ha podido calcular el peso ideal en la calculadora Europea.", e);
        }
    }

    @Override
    public float basalMetabolicRate(float weight, float height, char gender, int age) throws Exception {
        try {
            // Convertimos a parámetros compatibles con HealthCalc
            float weightInKilograms = (weight/1000);     // Convertir gramos a kilogramos
            float heightInCM = (height*100);             // Convertir m a cm
            float bmr = calculadora.basalMetabolicRate(weightInKilograms, heightInCM, gender, age);
            formatoBMR(bmr, weight, height);
            return bmr;
        } catch (Exception e) {
            throw new Exception("No se ha podido calcular el BMR en la calculadora Europea.", e);
        }
    }

    @Override
    public float bodyMassIndex(float weight, float height) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bodyMassIndex'");
    }

    @Override
    public String heartRateZones(int age) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'heartRateZones'");
    }

}
