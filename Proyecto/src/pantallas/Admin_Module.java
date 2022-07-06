package pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import almacenamiento.Memoria;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_Module extends JFrame {

	private JPanel contentPane;

	public Admin_Module(Memoria memoria) {
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
		
		JButton btnRepuestos = new JButton("Repuestos");
		
		btnRepuestos.setBounds(223, 62, 127, 23);
		contentPane.add(btnRepuestos);
		
		JButton btnServicios = new JButton("Servicios");
		btnServicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Servicios servicio = new Servicios(memoria);
				dispose();
				servicio.setVisible(true);
			}
		});
		btnServicios.setBounds(27, 140, 127, 23);
		contentPane.add(btnServicios);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes clientes = new Clientes(memoria);
				dispose();
				clientes.setVisible(true);
			}
		});
		btnClientes.setBounds(223, 140, 127, 23);
		contentPane.add(btnClientes);
		
		JButton btnReportes = new JButton("Reportes");
		btnReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reportes reporte = new Reportes(memoria);
				reporte.setVisible(true);
			}
		});
		btnReportes.setBounds(133, 231, 127, 23);
		contentPane.add(btnReportes);
		
		
		//Butons--------------------------------------------------------------------------------------
		button_cerrarS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login(memoria);
				dispose();
				login.setVisible(true);
			}
		});
		
		btnRepuestos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Repuestos repuestos = new Repuestos(memoria);
				dispose();
				repuestos.setVisible(true);
			}
		});
		
		btnEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empleados empleados = new Empleados(memoria);
				dispose();
				empleados.setVisible(true);
			}
		});
	}

}
