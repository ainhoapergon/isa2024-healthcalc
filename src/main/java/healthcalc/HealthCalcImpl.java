package healthcalc;

public class HealthCalcImpl implements HealthCalc {
    
    public float idealWeight(int height, char gender) throws Exception {
        float idealW;

        if (height <= 0 || (gender != 'm' && gender != 'w')) {
            throw new Exception("Invalid parameters");
        }
        if (gender  == 'm') {
            idealW = height-100-((height-150)/4);
        } else {
            idealW = (float)(height-100-((height-150)/2.5));
        }

        return idealW;
    }

    public float basalMetabolicRate(float weight, int height, char gender, int age) throws Exception {
        float BMR;

        if (weight <= 0 || height <= 0 || age <= 0 || (gender != 'm' && gender != 'w')) {
            throw new Exception("Invalid parameters");
        }
        if (gender == 'm') {
            BMR = (float)(10*weight+6.25*height-5*age+5);
        } else {
            BMR = (float)(10*weight+6.25*height-5*age-161);
        }

        return BMR;
    }

    public float bodyMassIndex(float weight, int height) throws Exception {
        if (weight <= 0 || height <= 0) {
            throw new Exception("Invalid parameters");
        }
        
        float BMI = weight/((float)Math.pow(height/100.0, 2));
        return BMI; 
    }

    public String heartRateZones(int age) throws Exception {
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

