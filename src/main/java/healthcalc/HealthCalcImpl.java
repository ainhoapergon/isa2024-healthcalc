package healthcalc;

public class HealthCalcImpl implements HealthCalc {

    private static HealthCalcImpl instancia;

    private HealthCalcImpl() {}   // Constructor privado para prevenir otras instancias

    // Método para obtener la instancia
    public static synchronized HealthCalcImpl getInstancia() {
        if (instancia == null) {
            instancia = new HealthCalcImpl();
        }
        return instancia;
    }    
    
    public float idealWeight(Person person) throws Exception {
        float idealW;
        float height = person.height();
        Gender gender = person.gender();

        if (height <= 0 || (gender != Gender.MALE && gender != Gender.FEMALE)) {
            throw new Exception("Invalid parameters");
        }
        if (gender == Gender.MALE) {
            idealW = (height-100-((height-150)/4));
        } else {
            idealW = (float)(height-100-((height-150)/2.5));
        }

        return idealW;
    }

    public float basalMetabolicRate(Person person) throws Exception {
        float BMR;
        float height = person.height();
        Gender gender = person.gender();
        float weight = person.weight();
        int age = person.age();

        if (weight <= 0 || height <= 0 || age <= 0 || (gender != Gender.MALE && gender != Gender.FEMALE)) {
            throw new Exception("Invalid parameters");
        }
        if (gender == Gender.MALE) {
            BMR = (float)(10*weight+6.25*height-5*age+5);
        } else {
            BMR = (float)(10*weight+6.25*height-5*age-161);
        }

        return BMR;
    }

    public float bodyMassIndex(Person person) throws Exception {
        float height = person.height();
        float weight = person.weight();

        if (weight <= 0 || height <= 0) {
            throw new Exception("Invalid parameters");
        }
        
        float BMI = weight/((float)Math.pow(height/100.0, 2));
        return BMI; 
    }

    public String heartRateZones(Person person) throws Exception {
        int age = person.age();

        if (age <= 0) {
            throw new Exception("Invalid parameters");
        }
        
        int heartRate = 220 - age;

        // Moderate-intensity
        int minMod = Math.round((float)(heartRate*0.64));
        int maxMod = Math.round((float)(heartRate*0.76));

        // Vigorous-intensity
        int minVig = Math.round((float)(heartRate*0.77));
        int maxVig = Math.round((float)(heartRate*0.93));

        String result = "Moderate: " + minMod + "-" + maxMod + ", Vigorous: " + minVig + "-" + maxVig;

        return result;
    }
        
}

