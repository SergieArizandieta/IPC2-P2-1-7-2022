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

public class Clientes extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JTextField textField_id_buscar;
	private JTextField textField_precio_biscquedsa;
	private JTextField textField_existencia_busquda;
	private JTextField textField_modelo_busqueda;
	private JTextField textField_marca_busqueda;
	private JTextField textfiel_nombre_busqueda;

	public Clientes(Memoria memoria) {

		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.TMCA", "TMCA");
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

		JLabel lblCargaMasiva = new JLabel("Carga Masiva");
		lblCargaMasiva.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCargaMasiva.setBounds(10, 44, 186, 29);
		panel.add(lblCargaMasiva);

		JButton btnSeleccionarArchivo = new JButton("Seleccionar Archivo");
		btnSeleccionarArchivo.setBounds(10, 84, 186, 23);
		panel.add(btnSeleccionarArchivo);

		JLabel lblNewLabel = new JLabel("Registro Clientes");
		lblNewLabel.setBounds(353, 11, 186, 29);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));

		btnSeleccionarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (fc.showOpenDialog(btnSeleccionarArchivo) == JFileChooser.APPROVE_OPTION) {

						String ruta = fc.getSelectedFile().toString();
						File txt = new File(ruta);
						Scanner reader = new Scanner(txt);

						while (reader.hasNextLine()) {

							String[] datos = reader.nextLine().split("-");
							
							
							
				
							
							
							
							String[] Autos = datos[5].split(";");
							
							Circular autos = new Circular();
							for (int i = 0; i < Autos.length; i++) {
								
								String[] datos_auto = Autos[i].split(",");
								Automovil auto= new Automovil(datos_auto[0],datos_auto[1],datos_auto[2],datos_auto[3]);
								autos.insert(auto);
							}
							//autos.showList()
							Cliente new_cliente = new Cliente(Long.valueOf( datos[0]) , datos[1], datos[2], datos[3] ,datos[4],autos);
							
							memoria.Clientes.insert(new_cliente);
							// new_empleado.print();
							//memoria.Servicios.insert(new_servicio);
							
						}

						memoria.Clientes.showList();

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
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_3, null);
		panel_3.setLayout(null);
		
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

