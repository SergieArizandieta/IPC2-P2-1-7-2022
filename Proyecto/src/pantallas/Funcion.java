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

public class Funcion extends JFrame {

	private JPanel contentPane;


	public Funcion(Memoria memoria) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 274, 176);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cola de espera a mecanicos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memoria.Espera.asignnado(memoria);
			}
		});
		btnNewButton.setBounds(10, 11, 195, 23);
		contentPane.add(btnNewButton);
		
		JButton btnMecanicoAtencion = new JButton("Mecanico atencion");
		btnMecanicoAtencion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memoria.cola_atencion.trabajars(memoria);
			}
		});
		btnMecanicoAtencion.setBounds(10, 66, 195, 23);
		contentPane.add(btnMecanicoAtencion);
	}

}
