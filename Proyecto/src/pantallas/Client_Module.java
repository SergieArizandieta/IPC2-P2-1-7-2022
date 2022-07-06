package pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import almacenamiento.Memoria;
import objetos.Automovil;
import objetos.Cliente;
import objetos.Servicio;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Generales.Generales;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextPane;

public class Client_Module extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTable table_1;
	private JTextField textField_1;


	public Client_Module(Memoria memoria,Cliente cliente) {
		String[] autos = { "Placa", "Marca", "Modelo", "Foto" };
		String[] factura = { "Orden", "Servicio", "Auto", "Precio" };
		
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
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 49, 487, 440);
		panel.add(scrollPane_2);
		
		table = new JTable();
		
		Object[][] autos_tabla = cliente.autos.data();
		table.setModel(new DefaultTableModel(autos_tabla, autos));
		scrollPane_2.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Autos");
		lblNewLabel.setBounds(10, 24, 46, 14);
		panel.add(lblNewLabel);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		memoria.Servicios.ComboBox(comboBox);
		panel.add(comboBox);
		
		JLabel lblServicios = new JLabel("Servicios");
		lblServicios.setBounds(620, 24, 114, 14);
		panel.add(lblServicios);
		
		JButton button_cerrarS_1 = new JButton("Seleecionar servico");
		button_cerrarS_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String placa = textField.getText();
				Automovil auto = cliente.autos.Search(placa);
				String servicio = comboBox.getSelectedItem().toString().toLowerCase();
				Servicio service = memoria.Servicios.Search(servicio);
				
				memoria.Espera.insert(service, cliente, auto,memoria);
				memoria.Espera.showList();
			}
		});
		button_cerrarS_1.setBounds(620, 224, 141, 23);
		panel.add(button_cerrarS_1);
		
		textField = new JTextField();
		textField.setBounds(620, 175, 152, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPlacaDelCarro = new JLabel("Placa del carro");
		lblPlacaDelCarro.setBounds(620, 150, 141, 14);
		panel.add(lblPlacaDelCarro);
		
		JButton button_cerrarS_1_1 = new JButton("Ver tablas");
		button_cerrarS_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tablas tabla = new Tablas(memoria);
				tabla.setVisible(true);
			}
		});
		button_cerrarS_1_1.setBounds(837, 466, 141, 23);
		panel.add(button_cerrarS_1_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Facturas", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Facturas");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 11, 204, 32);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Pagar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Generales.Numeros(textField_1.getText())) {
					int numero = Integer.valueOf(textField_1.getText());
					memoria.cola_listo.Delete(numero);
					cliente.facturas.Delete(numero);
				}
			}
		});
		btnNewButton.setBounds(878, 188, 89, 23);
		panel_1.add(btnNewButton);
		
		JScrollPane scrollPane_2_1 = new JScrollPane();
		scrollPane_2_1.setBounds(20, 54, 487, 440);
		panel_1.add(scrollPane_2_1);
		
		table_1 = new JTable();
		Object[][] data_facturas = cliente.facturas.tabla();
		
		table_1.setModel(new DefaultTableModel(data_facturas, factura));
		scrollPane_2_1.setViewportView(table_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(661, 157, 306, 20);
		panel_1.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Orden  de pago a pagar");
		lblNewLabel_2.setBounds(661, 132, 156, 14);
		panel_1.add(lblNewLabel_2);
		
		JButton button_cerrarS_2 = new JButton("actualizar");
		button_cerrarS_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client_Module clienteee = new Client_Module(memoria, cliente);
				dispose();
				clienteee.setVisible(true);
			}
		});
		button_cerrarS_2.setBounds(706, 11, 141, 23);
		contentPane.add(button_cerrarS_2);
		
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
