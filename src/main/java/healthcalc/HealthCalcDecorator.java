package healthcalc;

public abstract class HealthCalcDecorator implements HealthCalc {
    protected HealthCalc calculadora;
    protected String version;

    public HealthCalcDecorator(HealthCalc calculadora, String version) {
        this.version = version;
        this.calculadora = calculadora;
    }

    protected void formatoIdealWeight(float idealWeight, Gender gender, float height) {
        if ("EU".equals(version)) {
            System.out.println(String.format("La persona con altura %.2f metros tiene un peso ideal de %.2f. gramos.", height, idealWeight));
            System.out.println(String.format("The person with a height of %.2f meters has an ideal weight of %.2f. grames.", height, idealWeight));
        } else if ("AM".equals(version)) {
            System.out.println(String.format("La persona con altura %.2f pies tiene un peso ideal de %.2f. libras.", height, idealWeight));
            System.out.println(String.format("The person with a height of %.2f feet has an ideal weight of %.2f. pounds.", height, idealWeight));
        } else {
            System.out.println("Versión inválida de la calculadora.");
        }
    }
    
    protected void formatoBMR(float bmr, float weight, float height) {
        if ("EU".equals(version)) {
            System.out.println(String.format("La persona con altura %.2f metros y un peso de %.0f gramos tiene un BMR de %.2f.", height, weight, bmr));
            System.out.println(String.format("The person with a height of %.2f meters and a weight of %.0f gramos has a BMR of %.2f.", height, weight, bmr));
        } else if("AM".equals(version)) {
            System.out.println(String.format("La persona con altura %.2f pies y un peso de %.0f libras tiene un BMR de %.2f.", height, weight, bmr));
            System.out.println(String.format("The person with a height of %.2f feet and a weight of %.0f pounds has a BMR of %.2f.", height, weight, bmr));
        } else {
            System.out.println("Versión inválida de la calculadora.");
        }
    }

    // Métodos abstractos 
    public abstract float idealWeight(Person person) throws Exception;
    public abstract float basalMetabolicRate(Person person) throws Exception;
}   
