package Listas;

import java.io.FileOutputStream;

import javax.swing.JComboBox;
import javax.swing.text.Document;



import objetos.Servicio;

public class Simple {
	int contador;
	Nodo_Simple primero;

	public Simple() {
		this.primero = null;
	}

	public void insert(Servicio servicio) {
		Nodo_Simple new_node = new Nodo_Simple(contador + 1,servicio);
		servicio.identificador = contador+ 1;
		if (isNone()) {
			contador++;
			this.primero = new_node;
		} else {
			contador++;
			new_node.next = this.primero;
			this.primero = new_node;
		}
	}

	public void showList() {
		if (isNone() == false) {
			Nodo_Simple actual = this.primero;
			while (actual != null) {
				System.out.println(actual.info);
				actual.servicio.print();
				actual = actual.next;
			}
		}
	}
	
	public void ComboBox(JComboBox<String> comboBox) {
		
		
		if (isNone() == false) {
			Nodo_Simple actual = this.primero;
			while (actual != null) {
				comboBox.addItem(actual.servicio.nombre);
				actual = actual.next;
			}
		}
		
		comboBox.setBounds(620, 52, 338, 22);
	
		
	}

	public Servicio Search(String servicio) {
		if (isNone() == false) {
			Nodo_Simple actual = this.primero;
			while (actual != null && !actual.servicio.nombre.toLowerCase().equals(servicio)) {
				actual = actual.next;
				if (actual == null) {
					System.out.println("No se encontro el dato: " + servicio);
					return null;
				}
			}
			if (actual != null &&actual.servicio.nombre.toLowerCase().equals(servicio)) {
				System.out.println("Dato encontrado: " + servicio);
				return actual.servicio;
			}
		}
		return null;
	}

	public void Delete(int data) {
		if (isNone() == false) {
			Nodo_Simple actual = this.primero;
			Nodo_Simple anterior = null;

			while (actual != null && actual.info != data) {
				anterior = actual;
				actual = actual.next;
			}

			if (anterior == null) {
				this.primero = actual.next;
				System.out.println("Se elimino el dato: " + data);
			} else if (actual != null) {
				anterior.next = actual.next;
				actual.next = null;
				System.out.println("Se elimino el dato: " + data);
			} else {
				System.out.println("No se encontro el dato a eliminar: " + data);
			}
		}
	}

	public Boolean isNone() {
		return this.primero == null;
	}
	 
	public void pdf() {

		 
	}
     
}

class Nodo_Simple {

	Nodo_Simple next;
	int  info;
	Servicio servicio;

	public Nodo_Simple(int info,Servicio servicio) {
		this.next = null;
		this.info = info;
		this.servicio = servicio;
	}
}
