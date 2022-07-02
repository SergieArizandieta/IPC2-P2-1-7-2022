package pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import almacenamiento.memoria;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_Module extends JFrame {

	private JPanel contentPane;

	public Admin_Module(memoria memoria) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEmpleados = new JButton("Empleados");
		btnEmpleados.setBounds(27, 62, 127, 23);
		contentPane.add(btnEmpleados);
		
		JButton button_cerrarS = new JButton("Cerrar Sesión");
		button_cerrarS.setBounds(654, 11, 141, 23);
		contentPane.add(button_cerrarS);
		
		
		//Butons--------------------------------------------------------------------------------------
		button_cerrarS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login(memoria);
				dispose();
				login.setVisible(true);
			}
		});
		
		btnEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empleados empleados = new Empleados();
				dispose();
				empleados.setVisible(true);
			}
		});
	}

}
