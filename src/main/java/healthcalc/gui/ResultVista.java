package healthcalc.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
public class ResultVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldResult;
	private JButton btnGoBack;
	private JButton btnNewCalc; 


	/**
	 * Create the frame.
	 */
	public ResultVista() {
		setTitle("Results");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 243);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(SystemColor.info);
		contentPane.add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new GridLayout(3, 1, 0, 0));
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panelNorte.add(horizontalStrut);
		
		JLabel lblNewLabel = new JLabel("Your result is:");
		lblNewLabel.setForeground(new Color(128, 0, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelNorte.add(lblNewLabel);
		
		JPanel panelSur = new JPanel();
		panelSur.setBackground(SystemColor.info);
		contentPane.add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new GridLayout(0, 2, 20, 0));
		
		btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Tahoma", Font.ITALIC, 12));
		btnGoBack.setForeground(new Color(128, 0, 128));
		panelSur.add(btnGoBack);
		
		btnNewCalc = new JButton("New Calculation");
		btnNewCalc.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewCalc.setForeground(new Color(128, 0, 128));
		panelSur.add(btnNewCalc);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panelSur.add(horizontalStrut_2);
		
		JLabel lblNewLabel_1 = new JLabel("(this will clean your data)");
		lblNewLabel_1.setForeground(new Color(220, 20, 60));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelSur.add(lblNewLabel_1);
		
		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(SystemColor.info);
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(3, 3, 20, 0));
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panelCentro.add(verticalStrut_2);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panelCentro.add(horizontalStrut_3);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panelCentro.add(verticalStrut);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		panelCentro.add(verticalStrut_4);
		
		textFieldResult = new JTextField();
		textFieldResult.setEditable(false);
		panelCentro.add(textFieldResult);
		textFieldResult.setColumns(10);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panelCentro.add(verticalStrut_1);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panelCentro.add(horizontalStrut_4);
	}

	public void setResultado(String resultado) {
		this.textFieldResult.setText(resultado);
	}
	
	public void error(String msg) {
		textFieldResult.setText(msg);
	}

	public void registrarControlador(ActionListener ctrl) {
		btnGoBack.addActionListener(ctrl);
		btnGoBack.setActionCommand("Go Back");
		btnNewCalc.addActionListener(ctrl);
		btnNewCalc.setActionCommand("New Calculation");
	}

}
