package pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import almacenamiento.Memoria;
import objetos.Cliente;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;

public class Client_Module extends JFrame {

	private JPanel contentPane;


	public Client_Module(Memoria memoria,Cliente cliente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1029, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button_cerrarS = new JButton("Cerrar Sesi\u00F3n");
		button_cerrarS.setBounds(862, 11, 141, 23);
		contentPane.add(button_cerrarS);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 48, 993, 528);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Automoviles", null, panel, null);
		panel.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Mecanico", "RepectorPagador", "Administrador" }));
		comboBox.setBounds(10, 29, 224, 22);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(76, 110, 89, 23);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("AS", null, panel_1, null);
		
		//Butons--------------------------------------------------------------------------------------
				button_cerrarS.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Login login = new Login(memoria);
						dispose();
						login.setVisible(true);
					}
				});
	}
}
