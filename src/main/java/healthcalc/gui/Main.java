package healthcalc.gui;

import java.awt.EventQueue;
import healthcalc.HealthCalcImpl;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HealthCalcImpl modelo = new HealthCalcImpl();
					CalcVista vista = new CalcVista();
					vista.setVisible(true);
					ResultVista resultVista = new ResultVista();
					resultVista.setVisible(false);
					Controlador controlador = new Controlador(modelo, vista, resultVista);
					vista.registrarControlador(controlador);
					resultVista.registrarControlador(controlador);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
