package main;

import java.awt.EventQueue;

import almacenamiento.Memoria;
import pantallas.Login;

public class main {
	static Memoria memoria = new Memoria();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					memoria.incializar();
					System.out.println("Start");
					Login frame = new Login(memoria);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}