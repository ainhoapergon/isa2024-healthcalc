package healthcalc.gui;

import java.awt.EventQueue;
import healthcalc.HealthCalcImpl;
import healthcalc.HealthHospital;
import healthcalc.HealthHospitalAdapter;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Comprobamos si el Adapter está implementado correctamente.
					HealthCalcImpl modelo = HealthCalcImpl.getInstancia();
					HealthHospital modeloHospital = new HealthHospitalAdapter(modelo);

					char genero = 'm';
					int edad = 35;
					float altura = 1.80f;
					int peso = 70;

					double bmr = modeloHospital.bmr(genero, edad, altura, peso);
					int pesoIdeal = modeloHospital.pesoIdeal(genero, altura);

					System.out.println("Para un genero " + genero + ", una edad de " + edad + ", una altura de " + altura + " y un peso de " + peso);
					System.out.println("El BMR es " + bmr);
					System.out.println("El peso ideal es: " + pesoIdeal);

					// CalcVista vista = new CalcVista();
					// vista.setVisible(true);
					// ResultVista resultVista = new ResultVista();
					// resultVista.setVisible(false);
					// Controlador controlador = new Controlador(modelo, vista, resultVista);
					// vista.registrarControlador(controlador);
					// resultVista.registrarControlador(controlador);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}