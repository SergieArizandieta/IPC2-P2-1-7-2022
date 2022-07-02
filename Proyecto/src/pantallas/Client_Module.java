package pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import almacenamiento.memoria;
import objetos.Cliente;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Client_Module extends JFrame {

	private JPanel contentPane;


	public Client_Module(memoria memoria,Cliente cliente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(305, 209, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel(cliente.nombre + " zzzz");
		lblNewLabel.setBounds(152, 71, 46, 14);
		contentPane.add(lblNewLabel);
	}
}
