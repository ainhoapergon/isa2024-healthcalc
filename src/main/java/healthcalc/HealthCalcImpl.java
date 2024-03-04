package healthcalc;

public class HealthCalcImpl implements HealthCalc {
    
    public float idealWeight(int height, char gender) throws Exception {
        float idealW;

        if (height <= 0) {
            throw new Exception("Invalid Height");
        } if (gender != 'm' && gender != 'w') {
            throw new Exception("Invalid Gender");
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

        if (weight <= 0) {
            throw new Exception("Invalid Weight");
        } if (height <= 0) {
            throw new Exception("Invalid Height");
        } if (age <= 0) {
            throw new Exception("Invalid Age");
        } if (gender != 'm' && gender != 'w') {
            throw new Exception("Invalid Gender");
        }

        if (gender == 'm') {
            BMR = (float)(10*weight+6.25*height-5*age+5);
        } else {
            BMR = (float)(10*weight*6.25*height-5*age-161);
        }

        return BMR;
    }
}
