package healthcalc.gui;

import java.awt.EventQueue;
import healthcalc.HealthCalcProxy;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Comprobamos si el Proxy esta implementado correctamente.
					HealthCalcProxy modeloProxy = new HealthCalcProxy();
					modeloProxy.bmr('m', 19, 1.83f, 80000);
					modeloProxy.bmr('w', 23, 1.64f, 73000);
					float bmrMedio = modeloProxy.bmrMedio();
					float edadMedia = modeloProxy.edadMedia();
					int num = modeloProxy.numSexoM();

					System.out.println("Para un género m, una edad de 19, una altura de 1.83 y un peso de 80000 gramos");
					System.out.println("Y para un género w, una edad de 23, una altura de 1.64 y un peso de 73000 gramos");
					System.out.println("El BMR medio es " + bmrMedio);
					System.out.println("La edad media es " + edadMedia);
					System.out.println("El número de mujeres es: " + num);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}