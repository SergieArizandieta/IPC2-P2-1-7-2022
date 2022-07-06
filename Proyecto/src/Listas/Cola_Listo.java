package Listas;

import java.awt.Desktop.Action;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import almacenamiento.Memoria;
import objetos.Automovil;
import objetos.Cliente;
import objetos.Empleado;
import objetos.Orden_trabajo;
import objetos.Servicio;

public class Cola_Listo {
	int contador;
	Nodo_listos primero;

	public Cola_Listo() {
		this.primero = null;
	}

	public void insert(Orden_trabajo orden_trabajo,Automovil auto ,Cliente cliente,Servicio servicio,Double total,Empleado empleado) {
		
		cliente.facturas.insert(servicio, auto, total, orden_trabajo);
		Nodo_listos new_node = new Nodo_listos(contador + 1, orden_trabajo, auto , cliente, servicio, total,empleado);

			
			if (isNone()) {
				contador++;
				this.primero = new_node;
			} else {
				contador++;
				Nodo_listos actual = this.primero;
				while (actual != null) {
					if(actual.next == null) {
						actual.next = new_node;
					}
					actual = actual.next;
				}
		
			}

	}

	public void showList() {
		if (isNone() == false) {
			System.out.println(" ATENCION ");
			Nodo_listos actual = this.primero;
			while (actual != null) {
				System.out.println(actual.info);
				actual.servicio.print();
				actual = actual.next;
			}
		}
	}
	

	
	public void Desencolar() {
		this.primero = this.primero.next;
	}
	
	public Object[][] tabla() {
		Object[][] datos = new Object[contador][5];
		
		
		if (isNone() == false) {
			int i = 0 ;
			Nodo_listos actual = this.primero;
			while (actual != null) {
				datos[i][0] = actual.orden_trabajo;
				datos[i][1] = actual.auto.marca;
				datos[i][2] = actual.cliente.nombre;
				datos[i][3] = actual.servicio.nombre;
				datos[i][4] = actual.total;
				i++;
				System.out.println(actual.info);
				actual = actual.next;
			}
		}
		
		return datos;
	}

	
	public void ComboBox(JComboBox<String> comboBox) {
		
		
		if (isNone() == false) {
			Nodo_listos actual = this.primero;
			while (actual != null) {
				comboBox.addItem(actual.servicio.nombre);
				actual = actual.next;
			}
		}
		
		comboBox.setBounds(620, 52, 338, 22);
	
		
	}

	public Servicio Search(String servicio) {
		if (isNone() == false) {
			Nodo_listos actual = this.primero;
			while (actual != null && actual.servicio.nombre.toLowerCase().equals(servicio)) {
				actual = actual.next;
				if (actual == null) {
					System.out.println("No se encontro el dato: " + servicio);
					return null;
				}
			}
			if (actual != null &&actual.servicio.nombre.equals(servicio)) {
				System.out.println("Dato encontrado: " + servicio);
				
				return actual.servicio;
			}
		}
		return null;
	}

	public void Delete(int data) {
		if (isNone() == false) {
			Nodo_listos actual = this.primero;
			Nodo_listos anterior = null;

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
}

class Nodo_listos {
	


	Nodo_listos next;
	int  info;
	Orden_trabajo orden_trabajo;
	Automovil auto ;
	Cliente cliente ;
	Servicio servicio ;
	Double total;
	Empleado empleado;

	public Nodo_listos(int info,Orden_trabajo orden_trabajo,Automovil auto ,Cliente cliente,Servicio servicio,Double total,Empleado empleado) {
		this.next = null;
		this.info = info;
		this.orden_trabajo = orden_trabajo;
		this.auto=auto;
		this.cliente=cliente;
		this.servicio = servicio;
		this.total = total;
		this.empleado=empleado;
	}
}
