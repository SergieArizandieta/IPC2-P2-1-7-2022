package pantallas;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import almacenamiento.Memoria;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Reportes extends JFrame {

	private JPanel contentPane;

	public Reportes(Memoria memoria) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Clientes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memoria.Clientes.reporte();
				memoria.Clientes.ReporteMostrar();
				try {

	                File objetofile = new File ("Reportes/Clientes.html");
	                Desktop.getDesktop().open(objetofile);

	            }catch (IOException ex) {

	                System.out.println(ex);

	            }
			}
		});
		btnNewButton.setBounds(10, 11, 187, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(10, 58, 187, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Tipo 10 repuestos mas caros");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memoria.Repuesto.reporte();
				memoria.Repuesto.ReporteMostrar();
				try {

	                File objetofile = new File ("Reportes/Repuestos.html");
	                Desktop.getDesktop().open(objetofile);

	            }catch (IOException ex) {

	                System.out.println(ex);

	            }
				
			}
		});
		btnNewButton_2.setBounds(10, 102, 187, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(10, 152, 187, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(10, 206, 187, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton("Cerrar");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_4_1.setBounds(235, 293, 187, 23);
		contentPane.add(btnNewButton_4_1);
	}

}
