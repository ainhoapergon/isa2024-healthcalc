package healthcalc;

public class AmericanCalcDecorator extends HealthCalcDecorator {

    public AmericanCalcDecorator(HealthCalc calculadora) {
        super(calculadora, "AM");
        //TODO Auto-generated constructor stub
    }

    @Override
    public float idealWeight(Person person) throws Exception {
        float height = person.height();
        Gender gender = person.gender();

        try {
            // Convertimos a parámetros compatibles con HealthCalc
            float heightInCM = (height * 30.48f);      // Convertir pies a cm
            float idealWeight = calculadora.idealWeight(new PersonImpl(heightInCM, gender));
            float idealWeightInPounds = idealWeight*2.20462f;
            formatoIdealWeight(idealWeightInPounds, gender, height);
            return idealWeightInPounds;
        } catch (Exception e) {
            throw new Exception("No se ha podido calcular el peso ideal en la calculadora Americana.", e);
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
            float weightInKilograms = (weight / 2.20462f);      // Convertir libras a kilogramos
            float heightInCM = (height * 0.3048f)*100;          // Convertir pies a cm
            float bmr = calculadora.basalMetabolicRate(new PersonImpl(weightInKilograms, heightInCM, gender, age));
            float bmrInPounds = bmr;
            formatoBMR(bmrInPounds, weight, height);
            return bmrInPounds;
        } catch (Exception e) {
            throw new Exception("No se ha podido calcular el BMR en la calculadora Americana.", e);
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
