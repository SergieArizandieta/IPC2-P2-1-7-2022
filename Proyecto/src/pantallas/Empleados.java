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
import javax.swing.JTextField;
import javax.swing.JLabel;
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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Empleados frame = new Empleados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Empleados() {

		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.TME", "TME");
		fc.setFileFilter(filter);
		fc.setCurrentDirectory(new File("./Test"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1004, 533);
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

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(124, 84, 306, 20);
		panel.add(textField);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(
				new DefaultComboBoxModel<String>(new String[] { "Mecanico", "ReceptorPagador", "Administrador" }));
		comboBox.setBounds(124, 112, 122, 22);
		panel.add(comboBox);

		JLabel lblNewLabel_2 = new JLabel("Rol: ");
		lblNewLabel_2.setBounds(81, 115, 36, 14);
		panel.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(124, 144, 306, 20);
		panel.add(textField_1);

		JLabel lblNewLabel_3 = new JLabel("Usuario: ");
		lblNewLabel_3.setBounds(64, 147, 61, 14);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_4.setBounds(45, 187, 80, 14);
		panel.add(lblNewLabel_4);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(124, 184, 306, 20);
		panel.add(textField_2);

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

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Modificar", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Nombre completo: ");
		lblNewLabel_1_1.setBounds(10, 169, 115, 14);
		panel_1.add(lblNewLabel_1_1);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(124, 166, 306, 20);
		panel_1.add(textField_3);

		JLabel lblNewLabel_2_1 = new JLabel("Rol: ");
		lblNewLabel_2_1.setBounds(81, 214, 36, 14);
		panel_1.add(lblNewLabel_2_1);

		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(354, 210, 122, 22);
		panel_1.add(comboBox_1);

		JLabel lblNewLabel_3_1 = new JLabel("Usuario: ");
		lblNewLabel_3_1.setBounds(64, 268, 61, 14);
		panel_1.add(lblNewLabel_3_1);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(124, 265, 306, 20);
		panel_1.add(textField_4);

		JLabel lblNewLabel_4_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_4_1.setBounds(45, 308, 80, 14);
		panel_1.add(lblNewLabel_4_1);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(124, 305, 306, 20);
		panel_1.add(textField_5);

		JButton Button_modificar = new JButton("Modificar");
		Button_modificar.setBounds(226, 354, 97, 23);
		panel_1.add(Button_modificar);

		JLabel lblNewLabel_1_1_1 = new JLabel("Identificador a buscar:");
		lblNewLabel_1_1_1.setBounds(10, 70, 132, 14);
		panel_1.add(lblNewLabel_1_1_1);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(135, 67, 306, 20);
		panel_1.add(textField_6);

		JButton Button_buscar = new JButton("Buscar");
		Button_buscar.setBounds(467, 66, 97, 23);
		panel_1.add(Button_buscar);

		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(124, 211, 122, 20);
		panel_1.add(textField_7);

		JLabel lblNewLabel_2_1_1 = new JLabel("Nuevo rol: ");
		lblNewLabel_2_1_1.setBounds(274, 214, 97, 14);
		panel_1.add(lblNewLabel_2_1_1);

		JLabel lblModificacin = new JLabel("Modificaci\u00F3n");
		lblModificacin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblModificacin.setBounds(422, 11, 186, 29);
		panel_1.add(lblModificacin);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
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

		// Butins ------------------------------------------------------
		Button_Ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnSeleccionarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (fc.showOpenDialog(Button_modificar) == JFileChooser.APPROVE_OPTION) {

					String ruta = fc.getSelectedFile().toString();
					File txt = new File(ruta);
					String data="";
					
					try (Scanner reader = new Scanner(txt)) {
						
						while(reader.hasNextLine()) {
							data += reader.nextLine()+"\n";
						}
						
						String rows [] = data.split("\n");
						int rowsAlumnos =rows.length;
						
						String columns[]=rows[0].split("-");
						int columnsAlumnos=columns.length;
						
						
						for(int i =0; i<rows.length;i++) {
							
							columns=rows[i].split("-");
							
							for(int j=0;j<columns.length;j++) {
								
								System.out.println(columns[j]);
								
							}	
						}
						

					} catch (Exception e2) {
						// TODO: handle exception
						System.out.println("Fallo 2");
					}

				} else {
					System.out.println("Fallo 1");

				}
				
			}
		});

		Button_modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				

			}
		});

	}
}
