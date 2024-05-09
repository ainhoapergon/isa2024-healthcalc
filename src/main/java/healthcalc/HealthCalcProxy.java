package healthcalc;

import java.util.ArrayList;
import java.util.List;

public class HealthCalcProxy implements HealthStats {
    private List<Double> alturas = new ArrayList<>();
    private List<Double> pesos = new ArrayList<>();
    private List<Double> edades = new ArrayList<>();
    private List<Double> BMRs = new ArrayList<>();
    private int numHombres = 0;
    private int numMujeres = 0;
    private HealthHospitalAdapter calculadora;

    public HealthCalcProxy() {
        HealthCalcImpl modelo = HealthCalcImpl.getInstancia();
        this.calculadora = new HealthHospitalAdapter(modelo);
    }

    private float calcularMedia(List<Double> lista) {
        if (lista.isEmpty()) return 0;
        double total = lista.stream().mapToDouble(Double::doubleValue).sum();
        return (float)(total/lista.size());
    }

    @Override
    public float alturaMedia() {
        return calcularMedia(alturas);
    }

    @Override
    public float pesoMedio() {
        return calcularMedia(pesos);
    }

    @Override
    public float edadMedia() {
        return calcularMedia(edades);
    }

    @Override
    public float bmrMedio() {
        return calcularMedia(BMRs);
    }

    @Override
    public int numSexoH() {
        return numHombres;
    }

    @Override
    public int numSexoM() {
        return numMujeres;
    }

    @Override
    public int numTotalPacientes() {
        // Todos los cálculos requieren mínimamente introducir la altura asi que elegimos el tamaño de su array.
        int numPacientes = alturas.size(); 
        return numPacientes;
    }

    public double bmr(char genero, int edad, float altura, int peso) throws Exception {
        if (peso > 0 && altura > 0 && (genero == 'm' || genero == 'w') && edad > 0) {
            pesos.add((double)peso);
            alturas.add((double)altura);
            edades.add((double)edad);
            if (genero == 'm') numHombres++;
            else if (genero == 'w') numMujeres++;
            float BMR = (float)calculadora.bmr(genero, edad, altura, peso);
            BMRs.add((double)BMR);
            return BMR;
        } else {
            throw new Exception("Invalid parameters");
        }
    }

    public int pesoIdeal(char genero, float altura) throws Exception {
        if (altura > 0 && (genero == 'm' || genero == 'w')) {
            alturas.add((double)altura);
            if (genero == 'm') numHombres++;
            else if (genero == 'w') numMujeres++;
            return calculadora.pesoIdeal(genero, altura);
        } else {
            throw new Exception("Invalid Parameters");
        }
    }
}


