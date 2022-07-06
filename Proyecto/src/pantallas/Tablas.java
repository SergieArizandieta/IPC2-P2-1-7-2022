package pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import Generales.Generales;
import Listas.Circular;
import Listas.Pila_Repuestos_Servicio;
import almacenamiento.Memoria;
import objetos.Automovil;
import objetos.Cliente;
import objetos.Empleado;
import objetos.Repuesto;
import objetos.Servicio;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Tablas extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	public Tablas(Memoria memoria) {
		String[] espera = { "Orden", "Automovil", "Cliente" };
		String[] atencion = { "Orden", "Automovil", "Cliente","Mecanico" };
		String[] listos = { "Orden", "Automovil", "Cliente","Servicio","Total" };

		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.TMCA", "TMCA");
		fc.setFileFilter(filter);
		fc.setCurrentDirectory(new File("./Test"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1094, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 968, 556);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Cola espera", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 483, 506);
		panel.add(scrollPane_2);
		table = new JTable();
		Object[][] esperadata = memoria.Espera.tabla();
		table.setModel(new DefaultTableModel(esperadata, espera));
		scrollPane_2.setViewportView(table);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Carros atencion", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_2_1 = new JScrollPane();
		scrollPane_2_1.setBounds(27, 11, 483, 506);
		panel_1.add(scrollPane_2_1);
		
		table_1 = new JTable();
		
		Object[][] atenciondata = memoria.cola_atencion.tabla();
		table_1.setModel(new DefaultTableModel(atenciondata, atencion));
		scrollPane_2_1.setViewportView(table_1);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Carros listos", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2_1_1 = new JScrollPane();
		scrollPane_2_1_1.setBounds(10, 11, 483, 506);
		panel_2.add(scrollPane_2_1_1);
		
		table_2 = new JTable();
	
		Object[][] listosdata = memoria.cola_listo.tabla();
		table_2.setModel(new DefaultTableModel(listosdata, listos));
		scrollPane_2_1_1.setViewportView(table_2);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(977, 460, 97, 23);
		contentPane.add(btnCerrar);
		
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});

	}
}

