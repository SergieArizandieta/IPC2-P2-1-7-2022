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

import Generales.Generales;
import almacenamiento.Memoria;
import objetos.Empleado;
import objetos.Repuesto;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Repuestos extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JTextField textField_nombre;
	private JTextField textField_marca;
	private JTextField textField_id_buscar;
	private JTextField textField_modelo;
	private JTextField textField_existencias;
	private JTextField textField_precio;
	private JTextField textField_precio_biscquedsa;
	private JTextField textField_existencia_busquda;
	private JTextField textField_modelo_busqueda;
	private JTextField textField_marca_busqueda;
	private JTextField textfiel_nombre_busqueda;

	public Repuestos(Memoria memoria) {

		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.TME", "TME");
		fc.setFileFilter(filter);
		fc.setCurrentDirectory(new File("./Test"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 968, 472);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Agregar", null, panel, null);
		panel.setLayout(null);

		JLabel lblManual = new JLabel("Manual");
		lblManual.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblManual.setBounds(10, 38, 186, 29);
		panel.add(lblManual);

		JLabel lblNewLabel_1 = new JLabel("Nombre repuesto: ");
		lblNewLabel_1.setBounds(10, 87, 115, 14);
		panel.add(lblNewLabel_1);

		textField_nombre = new JTextField();
		textField_nombre.setColumns(10);
		textField_nombre.setBounds(124, 84, 306, 20);
		panel.add(textField_nombre);

		textField_marca = new JTextField();
		textField_marca.setColumns(10);
		textField_marca.setBounds(124, 119, 306, 20);
		panel.add(textField_marca);

		JLabel lblNewLabel_3 = new JLabel("Marca:");
		lblNewLabel_3.setBounds(64, 119, 61, 14);
		panel.add(lblNewLabel_3);

		JButton Button_Ingresar = new JButton("Ingresar");
		Button_Ingresar.setBounds(204, 256, 97, 23);
		panel.add(Button_Ingresar);

		JLabel lblCargaMasiva = new JLabel("Carga Masiva");
		lblCargaMasiva.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCargaMasiva.setBounds(10, 333, 186, 29);
		panel.add(lblCargaMasiva);

		JButton btnSeleccionarArchivo = new JButton("Seleccionar Archivo");
		btnSeleccionarArchivo.setBounds(10, 384, 186, 23);
		panel.add(btnSeleccionarArchivo);

		JLabel lblNewLabel = new JLabel("Registro Repuesto");
		lblNewLabel.setBounds(353, 11, 186, 29);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNewLabel_3_2 = new JLabel("Modelo:");
		lblNewLabel_3_2.setBounds(64, 153, 61, 14);
		panel.add(lblNewLabel_3_2);
		
		textField_modelo = new JTextField();
		textField_modelo.setColumns(10);
		textField_modelo.setBounds(124, 153, 306, 20);
		panel.add(textField_modelo);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Existencias:");
		lblNewLabel_3_2_1.setBounds(53, 190, 61, 14);
		panel.add(lblNewLabel_3_2_1);
		
		textField_existencias = new JTextField();
		textField_existencias.setColumns(10);
		textField_existencias.setBounds(124, 184, 306, 20);
		panel.add(textField_existencias);
		
		JLabel lblNewLabel_3_2_1_1 = new JLabel("Precio:");
		lblNewLabel_3_2_1_1.setBounds(76, 215, 61, 14);
		panel.add(lblNewLabel_3_2_1_1);
		
		textField_precio = new JTextField();
		textField_precio.setColumns(10);
		textField_precio.setBounds(124, 215, 306, 20);
		panel.add(textField_precio);

		// Butins ------------------------------------------------------
		Button_Ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre= null;
				String marca = null;
				String  modelo = null;
				double precio = 0; 
				int existencias = 0;
				
				if(Generales.Caracteres(textField_nombre.getText()) && Generales.Caracteres(textField_marca.getText())  && Generales.Numeros_Dobles(textField_precio.getText()) &&  Generales.Numeros(textField_existencias.getText())) {
					nombre = textField_nombre.getText();
					marca = textField_marca.getText();
					modelo =textField_modelo.getText();
					precio = Double.valueOf(textField_precio.getText());
					existencias = Integer.valueOf(textField_existencias.getText());
					
					Repuesto repuesto = new Repuesto(nombre,marca,modelo,existencias,precio);
					memoria.Repuesto.insert(repuesto);
					memoria.Repuesto.showList();
				}
				
			}
		});

		btnSeleccionarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (fc.showOpenDialog(btnSeleccionarArchivo) == JFileChooser.APPROVE_OPTION) {

						String ruta = fc.getSelectedFile().toString();
						File txt = new File(ruta);
						Scanner reader = new Scanner(txt);

						while (reader.hasNextLine()) {

							String[] datos = reader.nextLine().split("-");
							
							Repuesto new_repuesto = new Repuesto(datos[0], datos[1], datos[2],Integer.valueOf( datos[3]) , Double.valueOf(datos[4]));
							// new_empleado.print();
							memoria.Repuesto.insert(new_repuesto);

						}

						memoria.Repuesto.showList();

					} else {
						JOptionPane.showMessageDialog(null, "Ocurrio un error en la lectura de los datos");

					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Ocurrio un error en la lectura de los datos");
				}

			}
		});

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Modificar", null, panel_1, null);
		panel_1.setLayout(null);

		JButton Button_modificar = new JButton("Modificar");
		Button_modificar.setBounds(226, 354, 97, 23);
		panel_1.add(Button_modificar);

		JLabel lblNewLabel_1_1_1 = new JLabel("Identificador a buscar:");
		lblNewLabel_1_1_1.setBounds(10, 70, 132, 14);
		panel_1.add(lblNewLabel_1_1_1);

		textField_id_buscar = new JTextField();
		textField_id_buscar.setColumns(10);
		textField_id_buscar.setBounds(135, 67, 306, 20);
		panel_1.add(textField_id_buscar);

		JButton Button_buscar = new JButton("Buscar");
		Button_buscar.setBounds(467, 66, 97, 23);
		panel_1.add(Button_buscar);

		JLabel lblModificacin = new JLabel("Modificaci\u00F3n");
		lblModificacin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblModificacin.setBounds(422, 11, 186, 29);
		panel_1.add(lblModificacin);
		
		JLabel lblNewLabel_3_2_1_1_1 = new JLabel("Precio:");
		lblNewLabel_3_2_1_1_1.setBounds(86, 272, 61, 14);
		panel_1.add(lblNewLabel_3_2_1_1_1);
		
		textField_precio_biscquedsa = new JTextField();
		textField_precio_biscquedsa.setColumns(10);
		textField_precio_biscquedsa.setBounds(134, 272, 306, 20);
		panel_1.add(textField_precio_biscquedsa);
		
		JLabel lblNewLabel_3_2_1_2 = new JLabel("Existencias:");
		lblNewLabel_3_2_1_2.setBounds(63, 247, 61, 14);
		panel_1.add(lblNewLabel_3_2_1_2);
		
		textField_existencia_busquda = new JTextField();
		textField_existencia_busquda.setColumns(10);
		textField_existencia_busquda.setBounds(134, 241, 306, 20);
		panel_1.add(textField_existencia_busquda);
		
		JLabel lblNewLabel_3_2_2 = new JLabel("Modelo:");
		lblNewLabel_3_2_2.setBounds(74, 210, 61, 14);
		panel_1.add(lblNewLabel_3_2_2);
		
		textField_modelo_busqueda = new JTextField();
		textField_modelo_busqueda.setColumns(10);
		textField_modelo_busqueda.setBounds(134, 210, 306, 20);
		panel_1.add(textField_modelo_busqueda);
		
		JLabel lblNewLabel_3_1 = new JLabel("Marca:");
		lblNewLabel_3_1.setBounds(74, 176, 61, 14);
		panel_1.add(lblNewLabel_3_1);
		
		textField_marca_busqueda = new JTextField();
		textField_marca_busqueda.setColumns(10);
		textField_marca_busqueda.setBounds(134, 176, 306, 20);
		panel_1.add(textField_marca_busqueda);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre repuesto: ");
		lblNewLabel_1_1.setBounds(20, 144, 115, 14);
		panel_1.add(lblNewLabel_1_1);
		
		textfiel_nombre_busqueda = new JTextField();
		textfiel_nombre_busqueda.setColumns(10);
		textfiel_nombre_busqueda.setBounds(134, 141, 306, 20);
		panel_1.add(textfiel_nombre_busqueda);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Eliminar", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblEliminacinPila = new JLabel("Eliminaci\u00F3n Pila");
		lblEliminacinPila.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEliminacinPila.setBounds(422, 132, 186, 29);
		panel_2.add(lblEliminacinPila);
		
		JButton Button_eliminar_1 = new JButton("Eliminar");
		
		Button_eliminar_1.setBounds(434, 193, 97, 23);
		panel_2.add(Button_eliminar_1);
		
		JButton Button_cerrar = new JButton("Cerrar Sesion");
		Button_cerrar.setBounds(932, 13, 142, 23);
		contentPane.add(Button_cerrar);
		
		JButton Button_volver = new JButton("Volver");
		Button_volver.setBounds(977, 460, 97, 23);
		contentPane.add(Button_volver);

		//Buttons ----------------------------------------
		
		Button_eliminar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memoria.Repuesto.Desapilar();
				memoria.Repuesto.showList();
			}
		});
		

		
		Button_cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login(memoria);
				dispose();
				login.setVisible(true);
			}
		});
		
		Button_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_Module admin = new Admin_Module(memoria);
				dispose();
				admin.setVisible(true);
			}
		});
		
		Button_modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = null;
				String marca = null;
				String  modelo = null;
				double precio = 0; 
				int existencias = 0;
				
				if(Generales.Caracteres(textfiel_nombre_busqueda.getText()) && Generales.Caracteres(textField_marca_busqueda.getText())  && Generales.Numeros_Dobles(textField_precio_biscquedsa.getText()) &&  Generales.Numeros(textField_existencia_busquda.getText())) {
					memoria.Repuesto.buscado.nombre = textfiel_nombre_busqueda.getText();
					memoria.Repuesto.buscado.marca = textField_marca_busqueda.getText();
					memoria.Repuesto.buscado.modelo =textField_modelo_busqueda.getText();
					memoria.Repuesto.buscado.precio = Double.valueOf(textField_precio_biscquedsa.getText());
					memoria.Repuesto.buscado.existencia = Integer.valueOf(textField_existencia_busquda.getText());
			
					memoria.Repuesto.showList();
				}
			
				memoria.Repuesto.Terminado();
			}
		});
		
		Button_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Generales.Numeros(textField_id_buscar.getText())) {
					memoria.Repuesto.Search(Integer.valueOf(textField_id_buscar.getText()));
					if(memoria.Repuesto.buscado !=null) {
						textfiel_nombre_busqueda.setText(memoria.Repuesto.buscado.nombre);
						textField_marca_busqueda.setText(memoria.Repuesto.buscado.marca);
						textField_modelo_busqueda.setText(memoria.Repuesto.buscado.modelo);
						textField_existencia_busquda.setText(String.valueOf( memoria.Repuesto.buscado.existencia));
						textField_precio_biscquedsa.setText(String.valueOf(memoria.Repuesto.buscado.precio));
					}
				}
			}
		});

	}
}

