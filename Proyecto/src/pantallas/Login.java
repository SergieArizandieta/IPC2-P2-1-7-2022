package pantallas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import almacenamiento.memoria;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	String passwordAdmin = "1", userAdmin = "1";

	private JPanel contentPane;
	private JTextField UserText;
	private JPasswordField passwordField;
	private JLabel lblContrasea;
	private JButton Button_register;

	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/


	public Login(memoria memoria) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Usuario(DPI):");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(75, 95, 89, 14);
		contentPane.add(lblNewLabel);

		UserText = new JTextField();
		UserText.setBounds(174, 94, 152, 20);
		contentPane.add(UserText);
		UserText.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(174, 125, 152, 20);
		contentPane.add(passwordField);

		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContrasea.setBounds(82, 126, 82, 14);
		contentPane.add(lblContrasea);

		JButton Button_join = new JButton("Ingresar");

		Button_join.setBounds(237, 176, 89, 23);
		contentPane.add(Button_join);
		
		Button_register = new JButton("Registrarse");
	
		Button_register.setBounds(207, 210, 119, 23);
		contentPane.add(Button_register);

		// Botenes
		Button_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//check_in log_up = new check_in(storage);	
				//log_up.setVisible(true);
				//dispose();
			}
		});
		
		Button_join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String password = String.valueOf(passwordField.getPassword());
					String User = UserText.getText();
					
					if (User.equals(userAdmin) && password.equals(passwordAdmin)) {
						//JOptionPane.showMessageDialog(null, "Ingreso");

						Admin_Module admin_window = new Admin_Module(memoria);
						JOptionPane.showMessageDialog(null, "Bienvenido: Administrador");
						admin_window.setVisible(true);
						
						dispose();

					}else if (/*storage.SerchClient(User,password)*/ true) {
						//JOptionPane.showMessageDialog(null, "Client joined");
						
						
						Client_Module frame = new Client_Module(memoria,memoria.clientesesion);
						frame.setVisible(true);
						
						dispose();
						
						
					} else {
						JOptionPane.showMessageDialog(null, "Credenciales erroneas");
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Ocurrio un error");
				}

			}
		});

	}
}
