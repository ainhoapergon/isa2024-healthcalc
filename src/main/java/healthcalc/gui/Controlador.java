
package healthcalc.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

import healthcalc.*;

public class Controlador implements ActionListener { 
	private HealthCalcImpl modelo;
	private CalcVista vista;
	private ResultVista resultVista;
	
	public Controlador(HealthCalcImpl modelo, CalcVista vista, ResultVista resultVista) {
		this.modelo = modelo;
		this.vista = vista;
		this.vista.registrarControlador(this);
		this.resultVista = resultVista;
		this.resultVista.registrarControlador(this);
	}

	@Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if ("Calculate".equals(comando)) {
            realizarCalculo();
			resultVista.setVisible(true);
        }

		if ("Go Back".equals(comando)) {
            volverCalc();
        }

		if ("New Calculation".equals(comando)) {
			limpiarCalc();
		}
    }

	private void volverCalc() {
		// Cierra la ventana de resultados si está abierta
		if (resultVista != null) {
			resultVista.dispose();
		}
	}

	private void limpiarCalc() {
		volverCalc();
		vista.resetView();
	}


	private void realizarCalculo() {
		// Mostrar la barra de progreso
		vista.iniciarProgresoIndeterminado();
	
		// Crea el SwingWorker para realizar los cálculos en segundo plano y actualizar la barra de progreso
		SwingWorker<Object, Void> worker = new SwingWorker<Object, Void>() {
			@Override
			protected Object doInBackground() {
				try {
					String genderString = vista.getGender();
					char gender = (genderString.equals("Masculine")) ? 'm' : 'w';
					int age = vista.getAge();
					float weight = vista.getWeight();
					int height = vista.getTextHeight();
					
					String calculationType = vista.getBg();
					switch (calculationType) {
						case "Ideal Weight":
							return modelo.idealWeight(height, gender);
						case "Basal Metabolic Rate":
							return modelo.basalMetabolicRate(weight, height, gender, age);
						case "Body Mass Index":
							return modelo.bodyMassIndex(weight, height);
						case "Heart Rate Zones":
							return modelo.heartRateZones(age);
						default:
							throw new IllegalArgumentException("Invalid calculation type selected.");
					}
				} catch (Exception e) {
					return e;
				}
			}
	
			@Override
        	protected void done() {
            try {
                // Ocultar la barra de progreso cuando termina
                vista.detenerProgresoIndeterminado();
                
                Object result = get();
                if (result instanceof Exception) {
                    // Si el resultado es una excepción, mostrar un error
					resultVista.setVisible(false);
					vista.error("An error has occurred, please check if you have introduced all data correctly.");
                } else {
                    // Si el resultado es un valor numérico, actualizar la vista de resultados
                    resultVista.setResultado(String.valueOf(result));
                    resultVista.setVisible(true);
                }
            } catch (InterruptedException | ExecutionException e) {
                // Manejar adecuadamente la excepción lanzada por el método get()
                vista.error("Error retrieving the calculation result.");
            }
        }
    };

    worker.execute(); // Ejecutar el SwingWorker
	}
}
