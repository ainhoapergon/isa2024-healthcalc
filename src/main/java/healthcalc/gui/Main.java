package healthcalc.gui;

import java.awt.EventQueue;

import healthcalc.AmericanCalcDecorator;
import healthcalc.EuropeanCalcDecorator;
import healthcalc.HealthCalc;
import healthcalc.HealthCalcImpl;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Comprobamos si el Decorator está implementado correctamente.
					System.out.println("-----------------------------------");
					System.out.println("Comprobación patrón Decorator:");
					HealthCalcImpl basicCalc = HealthCalcImpl.getInstancia();
					HealthCalc americanCalc = new AmericanCalcDecorator(basicCalc);
					HealthCalc europeanCalc = new EuropeanCalcDecorator(basicCalc);

					// Ejemplo: Hombre de 78 kg, 1.83m, 24 años  
					System.out.println("-----------------------------------");
					System.out.println("Calculadora Versión Americana:");			 
					americanCalc.basalMetabolicRate(171.961f, 6.003937f, 'm', 24);	   // Recordatorio: peso en libras y altura en pies.
					System.out.println("-----------------------------------");
					System.out.println("Calculadora Versión Europea:");    			 
					europeanCalc.basalMetabolicRate(78000f, 1.83f, 'm', 24);          // Recordatorio: peso en gramos y altura en metros.

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}