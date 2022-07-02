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

public class Empleados extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JTextField textField_nombre;
	private JTextField textField_usuario;
	private JTextField textField_password;
	private JTextField textField_nombre_buscar;
	private JTextField textField_usuario_busscar;
	private JTextField textField_password_buscar;
	private JTextField textField_id_buscar;
	private JTextField textField_rol_buscar;
	private JTextField textField_8;

	public Empleados(Memoria memoria) {

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

		JLabel lblNewLabel_1 = new JLabel("Nombre completo: ");
		lblNewLabel_1.setBounds(10, 87, 115, 14);
		panel.add(lblNewLabel_1);

		textField_nombre = new JTextField();
		textField_nombre.setColumns(10);
		textField_nombre.setBounds(124, 84, 306, 20);
		panel.add(textField_nombre);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Mecanico", "RepectorPagador", "Administrador" }));
		comboBox.setBounds(124, 112, 122, 22);
		panel.add(comboBox);

		JLabel lblNewLabel_2 = new JLabel("Rol: ");
		lblNewLabel_2.setBounds(81, 115, 36, 14);
		panel.add(lblNewLabel_2);

		textField_usuario = new JTextField();
		textField_usuario.setColumns(10);
		textField_usuario.setBounds(124, 144, 306, 20);
		panel.add(textField_usuario);

		JLabel lblNewLabel_3 = new JLabel("Usuario: ");
		lblNewLabel_3.setBounds(64, 147, 61, 14);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_4.setBounds(45, 187, 80, 14);
		panel.add(lblNewLabel_4);

		textField_password = new JTextField();
		textField_password.setColumns(10);
		textField_password.setBounds(124, 184, 306, 20);
		panel.add(textField_password);

		JButton Button_Ingresar = new JButton("Ingresar");
		Button_Ingresar.setBounds(226, 234, 97, 23);
		panel.add(Button_Ingresar);

		JLabel lblCargaMasiva = new JLabel("Carga Masiva");
		lblCargaMasiva.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCargaMasiva.setBounds(10, 333, 186, 29);
		panel.add(lblCargaMasiva);

		JButton btnSeleccionarArchivo = new JButton("Seleccionar Archivo");
		btnSeleccionarArchivo.setBounds(10, 384, 186, 23);
		panel.add(btnSeleccionarArchivo);

		JLabel lblNewLabel = new JLabel("Registro Empleado");
		lblNewLabel.setBounds(353, 11, 186, 29);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));

		// Butins ------------------------------------------------------
		Button_Ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre= null;
				String usuario = textField_usuario.getText();
				String password = textField_password.getText();
				
				if(Generales.Caracteres(textField_nombre.getText())) {
					nombre = textField_nombre.getText();
				}
				
				int rol = Empleado.setRol(comboBox.getSelectedItem().toString());
				
				if(nombre != null) {
					Empleado new_empleado = new Empleado(nombre, rol, usuario, password);
					memoria.Empleados.insert(new_empleado);
					memoria.Empleados.showList();
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
							int rol = Empleado.setRol(datos[1]);
							Empleado new_empleado = new Empleado(datos[0], rol, datos[2], datos[3]);
							// new_empleado.print();
							memoria.Empleados.insert(new_empleado);

						}

						memoria.Empleados.showList();

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

		JLabel lblNewLabel_1_1 = new JLabel("Nombre completo: ");
		lblNewLabel_1_1.setBounds(10, 169, 115, 14);
		panel_1.add(lblNewLabel_1_1);

		textField_nombre_buscar = new JTextField();
		textField_nombre_buscar.setColumns(10);
		textField_nombre_buscar.setBounds(124, 166, 306, 20);
		panel_1.add(textField_nombre_buscar);

		JLabel lblNewLabel_2_1 = new JLabel("Rol: ");
		lblNewLabel_2_1.setBounds(81, 214, 36, 14);
		panel_1.add(lblNewLabel_2_1);

		JComboBox<String> comboBox_buscar = new JComboBox<String>();
		comboBox_buscar.setModel(new DefaultComboBoxModel<String>(new String[] { "Mecanico", "RepectorPagador", "Administrador" }));
		comboBox_buscar.setBounds(354, 210, 122, 22);
		panel_1.add(comboBox_buscar);

		JLabel lblNewLabel_3_1 = new JLabel("Usuario: ");
		lblNewLabel_3_1.setBounds(64, 268, 61, 14);
		panel_1.add(lblNewLabel_3_1);

		textField_usuario_busscar = new JTextField();
		textField_usuario_busscar.setColumns(10);
		textField_usuario_busscar.setBounds(124, 265, 306, 20);
		panel_1.add(textField_usuario_busscar);

		JLabel lblNewLabel_4_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_4_1.setBounds(45, 308, 80, 14);
		panel_1.add(lblNewLabel_4_1);

		textField_password_buscar = new JTextField();
		textField_password_buscar.setColumns(10);
		textField_password_buscar.setBounds(124, 305, 306, 20);
		panel_1.add(textField_password_buscar);

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

		textField_rol_buscar = new JTextField();
		textField_rol_buscar.setEditable(false);
		textField_rol_buscar.setColumns(10);
		textField_rol_buscar.setBounds(124, 211, 122, 20);
		panel_1.add(textField_rol_buscar);

		JLabel lblNewLabel_2_1_1 = new JLabel("Nuevo rol: ");
		lblNewLabel_2_1_1.setBounds(274, 214, 97, 14);
		panel_1.add(lblNewLabel_2_1_1);

		JLabel lblModificacin = new JLabel("Modificaci\u00F3n");
		lblModificacin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblModificacin.setBounds(422, 11, 186, 29);
		panel_1.add(lblModificacin);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Eliminar", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Identificador a eliminar:");
		lblNewLabel_1_1_1_1.setBounds(10, 70, 132, 14);
		panel_2.add(lblNewLabel_1_1_1_1);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(151, 67, 306, 20);
		panel_2.add(textField_8);

		JButton Button_eliminar = new JButton("Eliminar");
		Button_eliminar.setBounds(467, 66, 97, 23);
		panel_2.add(Button_eliminar);

		JLabel lblEliminacin = new JLabel("Eliminaci\u00F3n");
		lblEliminacin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEliminacin.setBounds(422, 11, 186, 29);
		panel_2.add(lblEliminacin);
		
		JButton Button_cerrar = new JButton("Cerrar Sesion");
		Button_cerrar.setBounds(932, 13, 142, 23);
		contentPane.add(Button_cerrar);
		
		JButton Button_volver = new JButton("Volver");
		Button_volver.setBounds(977, 460, 97, 23);
		contentPane.add(Button_volver);

		//Buttons ----------------------------------------
		
		Button_eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Generales.Numeros(textField_id_buscar.getText())) {
					memoria.Empleados.Delete(Integer.valueOf(textField_id_buscar.getText()));
					memoria.Empleados.showList();
				}
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
				String nombre= null;
				String usuario = textField_usuario_busscar.getText();
				String password = textField_password_buscar.getText();
				
				if(Generales.Caracteres(textField_nombre_buscar.getText())) {
					nombre = textField_nombre_buscar.getText();
				}
				
				int rol = Empleado.setRol(comboBox_buscar.getSelectedItem().toString());
				
				if(nombre != null) {
					memoria.Empleados.buscado.nombre = nombre;
					memoria.Empleados.buscado.rol = rol;
					memoria.Empleados.buscado.usuario = usuario;
					memoria.Empleados.buscado.password = password;
					
					memoria.Empleados.showList();
					
				}
				
				memoria.Empleados.Terminado();
			}
		});
		
		Button_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Generales.Numeros(textField_id_buscar.getText())) {
					memoria.Empleados.Search(Integer.valueOf(textField_id_buscar.getText()));
					if(memoria.Empleados.buscado !=null) {
						textField_nombre_buscar.setText(memoria.Empleados.buscado.nombre);
						textField_rol_buscar.setText(memoria.Empleados.buscado.getRol());
						textField_usuario_busscar.setText(memoria.Empleados.buscado.usuario);
						textField_password_buscar.setText(memoria.Empleados.buscado.password);
					}
				}
			}
		});

	}
}
