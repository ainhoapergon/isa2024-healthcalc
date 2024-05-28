package healthcalc.gui;

import java.awt.EventQueue;

import healthcalc.AmericanCalcDecorator;
import healthcalc.EuropeanCalcDecorator;
import healthcalc.Gender;
import healthcalc.HealthCalc;
import healthcalc.HealthCalcImpl;
import healthcalc.HealthCalcProxy;
import healthcalc.HealthHospital;
import healthcalc.HealthHospitalAdapter;
import healthcalc.PersonImpl;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					// Interfaz gráfica (descomentar para ejecutar el MVC)
					/* HealthCalcImpl modelo = HealthCalcImpl.getInstancia();
					CalcVista vista = new CalcVista();
					vista.setVisible(true);
					ResultVista resultVista = new ResultVista();
					resultVista.setVisible(false);
					Controlador controlador = new Controlador(modelo, vista, resultVista);
					vista.registrarControlador(controlador);
					resultVista.registrarControlador(controlador); */

					// Comprobamos si el Singleton está implementado correctamente.
					HealthCalcImpl modeloSingleton1 = HealthCalcImpl.getInstancia();
					HealthCalcImpl modeloSingleton2 = HealthCalcImpl.getInstancia();

					System.out.println("-----------------------------------");
					System.out.println("Comprobación patrón Singleton:");
					System.out.println("Referencia de modelo1: " + System.identityHashCode(modeloSingleton1));
					System.out.println("Referencia de modelo2: " + System.identityHashCode(modeloSingleton2));
					System.out.println("¿Es la misma instancia? " + (modeloSingleton1 == modeloSingleton2));

					// Comprobamos si el Adapter está implementado correctamente.
					HealthCalcImpl modeloNormal = HealthCalcImpl.getInstancia();
					HealthHospital modeloAdapter = new HealthHospitalAdapter(modeloNormal);

					char genero = 'm';
					int edad = 35;
					float altura = 1.80f;  // en metros
					int peso = 70000;  	   // en gramos

					double bmr = modeloAdapter.bmr(genero, edad, altura, peso);
					int pesoIdeal = modeloAdapter.pesoIdeal(genero, altura);
					
					System.out.println("-----------------------------------");
					System.out.println("Comprobación patrón Adapter:");
					System.out.println("Para un género " + genero + ", una edad de " + edad + ", una altura de " + altura + " m y un peso de " + peso + " gramos");
					System.out.println("El BMR es " + bmr);
					System.out.println("El peso ideal es: " + pesoIdeal + " g");

					// Comprobamos si el Proxy está implementado correctamente.
					HealthCalcProxy modeloProxy = new HealthCalcProxy();
					modeloProxy.bmr('m', 19, 1.83f, 80000);
					modeloProxy.bmr('w', 23, 1.64f, 73000);
					float bmrMedio = modeloProxy.bmrMedio();
					float edadMedia = modeloProxy.edadMedia();
					int num = modeloProxy.numSexoM();

					System.out.println("-----------------------------------");
					System.out.println("Comprobación patrón Proxy de Registro:");
					System.out.println("Para un género m, una edad de 19, una altura de 1.83 y un peso de 80000 gramos");
					System.out.println("Y para un género w, una edad de 23, una altura de 1.64 y un peso de 73000 gramos");
					System.out.println("El BMR medio es " + bmrMedio);
					System.out.println("La edad media es " + edadMedia);
					System.out.println("El número de mujeres es: " + num);

					// Comprobamos si el Decorator está implementado correctamente.
					System.out.println("-----------------------------------");
					System.out.println("Comprobación patrón Decorator:");
					HealthCalcImpl basicCalc = HealthCalcImpl.getInstancia();
					HealthCalc americanCalc = new AmericanCalcDecorator(basicCalc);
					HealthCalc europeanCalc = new EuropeanCalcDecorator(basicCalc);

					// Ejemplo: Hombre de 78 kg, 1.83m, 24 años  
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("Calculadora Versión Americana:");			 
					americanCalc.basalMetabolicRate(new PersonImpl(171.961f, 6.003937f, Gender.MALE, 24));	   // Recordatorio: peso en libras y altura en pies.
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("Calculadora Versión Europea:");    			 
					europeanCalc.basalMetabolicRate(new PersonImpl(78000f, 1.83f, Gender.MALE, 24));          // Recordatorio: peso en gramos y altura en metros.

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}