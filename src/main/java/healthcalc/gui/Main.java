package healthcalc.gui;

import java.awt.EventQueue;
import healthcalc.HealthCalcImpl;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Comprobamos si el Singleton está implementado correctamente.
					HealthCalcImpl modelo1 = HealthCalcImpl.getInstancia();
                    HealthCalcImpl modelo2 = HealthCalcImpl.getInstancia();

                    System.out.println("Referencia de modelo1: " + System.identityHashCode(modelo1));
                    System.out.println("Referencia de modelo2: " + System.identityHashCode(modelo2));
                    System.out.println("¿Es la misma instancia? " + (modelo1 == modelo2));

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