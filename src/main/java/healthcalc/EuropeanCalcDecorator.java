package healthcalc;

public class EuropeanCalcDecorator extends HealthCalcDecorator {

    public EuropeanCalcDecorator(HealthCalcImpl calculadora) {
        super(calculadora, "EU");
    }

    @Override
    public float idealWeight(Person person) throws Exception {
        float height = person.height();
        Gender gender = person.gender();

        try {
            // Convertimos a parámetros compatibles con HealthCalc
            float heightInCM = (height*100);         // Convertir m a cm
            double idealWeight = calculadora.getIdealBodyWeight(new PersonImpl(heightInCM, gender));
            formatoIdealWeight((float)idealWeight, gender, height);
            return (float)idealWeight;
        } catch (Exception e) {
            throw new Exception("No se ha podido calcular el peso ideal en la calculadora Europea.", e);
        }
    }

    @Override
    public float basalMetabolicRate(Person person) throws Exception {
        float height = person.height();
        Gender gender = person.gender();
        float weight = person.weight();
        int age = person.age();

        try {
            // Convertimos a parámetros compatibles con HealthCalc
            float weightInKilograms = (weight/1000);     // Convertir gramos a kilogramos
            float heightInCM = (height*100);             // Convertir m a cm
            double bmr = calculadora.basalMetabolicRate(new PersonImpl(weightInKilograms, heightInCM, gender, age));
            formatoBMR(bmr, weight, height);
            return (float)bmr;
        } catch (Exception e) {
            throw new Exception("No se ha podido calcular el BMR en la calculadora Europea.", e);
        }
    }

    @Override
    public float bodyMassIndex(Person person) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bodyMassIndex'");
    }

    @Override
    public String heartRateZones(Person person) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'heartRateZones'");
    }

}
