package healthcalc.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.Component;

import javax.swing.AbstractButton;
import javax.swing.Box;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.Color;
import javax.swing.UIManager;

public class CalcVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textAge;
	private JTextField textWeight;
	private JTextField textHeight;
	private ButtonGroup bg = new ButtonGroup();
	private JComboBox<String> boxGender;
	private JButton btnCalculate;
	private JProgressBar progressBar;


	/**
	 * Create the frame.
	 */
	public CalcVista() {
		setTitle("Health Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 574);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSur = new JPanel();
		panelSur.setBackground(SystemColor.info);
		contentPane.add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new GridLayout(0, 1, 10, 10));
		
		JLabel lblChooseOneCalculation = new JLabel("Choose one calculation:");
		lblChooseOneCalculation.setForeground(new Color(128, 0, 128));
		lblChooseOneCalculation.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseOneCalculation.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelSur.add(lblChooseOneCalculation);
		
		JRadioButton rbtnIW = new JRadioButton("Ideal Weight");
		rbtnIW.setBackground(SystemColor.info);
		rbtnIW.setHorizontalAlignment(SwingConstants.CENTER);
		panelSur.add(rbtnIW);
		
		JRadioButton rbtnBMR = new JRadioButton("Basal Metabolic Rate");
		rbtnBMR.setBackground(SystemColor.info);
		rbtnBMR.setHorizontalAlignment(SwingConstants.CENTER);
		panelSur.add(rbtnBMR);
		
		JRadioButton rbtnBMI = new JRadioButton("Body Mass Index");
		rbtnBMI.setBackground(SystemColor.info);
		rbtnBMI.setHorizontalAlignment(SwingConstants.CENTER);
		panelSur.add(rbtnBMI);
		
		JRadioButton rbtnHRZ = new JRadioButton("Heart Rate Zones");
		rbtnHRZ.setBackground(SystemColor.info);
		rbtnHRZ.setHorizontalAlignment(SwingConstants.CENTER);
		panelSur.add(rbtnHRZ);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panelSur.add(horizontalStrut);
		
		btnCalculate = new JButton("Calculate");
		btnCalculate.setForeground(new Color(128, 0, 128));
		btnCalculate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCalculate.setBackground(UIManager.getColor("Button.light"));
		panelSur.add(btnCalculate);
		
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setVisible(false);
		progressBar.setForeground(new Color(128, 0, 128));
		panelSur.add(progressBar);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(SystemColor.info);
		contentPane.add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new GridLayout(3, 1, 0, 0));
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panelNorte.add(horizontalStrut_3);
		
		JLabel lblEnterData = new JLabel("Enter your data please:");
		lblEnterData.setForeground(new Color(128, 0, 128));
		lblEnterData.setBackground(SystemColor.info);
		lblEnterData.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterData.setHorizontalAlignment(SwingConstants.CENTER);
		panelNorte.add(lblEnterData);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panelNorte.add(horizontalStrut_2);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(new GridLayout(0, 3, 15, 10));
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setHorizontalAlignment(SwingConstants.TRAILING);
		layeredPane.add(lblGender);
		
		boxGender = new JComboBox<>();
		boxGender.setToolTipText("Select");
		boxGender.setModel(new DefaultComboBoxModel<String>(new String[] {"Masculine", "Feminine"}));
		boxGender.setSelectedIndex(-1);
		layeredPane.add(boxGender);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		layeredPane.add(horizontalStrut_4);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setHorizontalAlignment(SwingConstants.TRAILING);
		layeredPane.add(lblAge);
		
		textAge = new JTextField();
		layeredPane.add(textAge);
		textAge.setColumns(10);
		
		JLabel lblYears = new JLabel("(in years)");
		layeredPane.add(lblYears);
		
		JLabel lblWeight = new JLabel("Weight:");
		lblWeight.setHorizontalAlignment(SwingConstants.TRAILING);
		layeredPane.add(lblWeight);
		
		textWeight = new JTextField();
		textWeight.setColumns(10);
		layeredPane.add(textWeight);
		
		JLabel lblKG = new JLabel("(in kg)");
		layeredPane.add(lblKG);
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setHorizontalAlignment(SwingConstants.TRAILING);
		layeredPane.add(lblHeight);
		
		textHeight = new JTextField();
		textHeight.setColumns(10);
		layeredPane.add(textHeight);
		
		JLabel lblCM = new JLabel("(in cm)");
		layeredPane.add(lblCM);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		layeredPane.add(horizontalStrut_1);
		
		// Establece que solo se pueda seleccionar un sólo calculo (botón de radio)
		bg.add(rbtnIW);
		bg.add(rbtnBMI);
		bg.add(rbtnBMR);
		bg.add(rbtnHRZ);
	}

	public String getGender() {
		try {
			return boxGender.getSelectedItem().toString();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Please select gender.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
			return boxGender.getSelectedItem().toString();
		}
	}

	public int getAge() {
		try {
			return Integer.parseInt(textAge.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Please enter a valid age.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
			return -1;
		}
	}
	
	public float getWeight() {
		try {
			return Float.parseFloat(textWeight.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Please enter a valid weight.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
			return -1.0f;
		}
	}
	
	public int getTextHeight() {
		try {
			return Integer.parseInt(textHeight.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Please enter a valid height.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
			return -1;
		}
	}
	
	public String getBg() {
		for (Enumeration<AbstractButton> buttons = bg.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				return button.getText();
			}
		}
		return "";
	}
	
	public void resetView() {
        // Restablece todos los campos de texto y estados de los componentes
        textAge.setText("");
        textWeight.setText("");
        textHeight.setText("");
        bg.clearSelection();
		boxGender.setSelectedIndex(-1);
    }

	public void error(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public void registrarControlador(ActionListener ctrl) {
		btnCalculate.addActionListener(ctrl);
		btnCalculate.setActionCommand("Calculate");
	}

	// Estos dos métodos controlan la barra de progreso
	public void iniciarProgresoIndeterminado() {
        progressBar.setIndeterminate(true);
        progressBar.setVisible(true);
    }

    public void detenerProgresoIndeterminado() {
        progressBar.setIndeterminate(false);
        progressBar.setVisible(false);
    }
	
}
