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

public class Cola_atencion {
	int contador;
	Nodo_atencion primero;

	public Cola_atencion() {
		this.primero = null;
	}

	public void insert(Servicio servicio,Cliente cliente,Automovil auto,Empleado empleado, Orden_trabajo orden) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		 
		Nodo_atencion new_node = new Nodo_atencion(contador + 1,servicio, cliente, auto, empleado,orden);
		
			
			if (isNone()) {
				contador++;
				this.primero = new_node;
			} else {
				contador++;
				Nodo_atencion actual = this.primero;
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
			Nodo_atencion actual = this.primero;
			while (actual != null) {
				System.out.println(actual.info);
				actual.servicio.print();
				actual = actual.next;
			}
		}
	}
	

	
	public void trabajars(Memoria memoria) {
		if (isNone() == false) {
			System.out.println(" TRABAJAR ");
			Nodo_atencion actual = this.primero;
			while (actual != null) {
				actual.empleado.ocupado = false;
				
				Orden_trabajo orden_trabajo = this.primero.orden;
				Automovil auto = this.primero.auto;
				Cliente cliente = this.primero.cliente;
				Servicio servicio = this.primero.servicio;
				servicio.usado++;
				Double total = servicio.mano_obra + servicio.pila.recorrer(memoria) ;
				Empleado empleado = this.primero.empleado;
				Desencolar();
				
				memoria.cola_listo.insert(orden_trabajo, auto, cliente, servicio, total, empleado);
				
				actual = actual.next;
			}
		}
	}
	
	
	public void Desencolar() {
		this.primero = this.primero.next;
	}
	
	public Object[][] tabla() {
		Object[][] datos = new Object[contador][4];
		
		
		if (isNone() == false) {
			int i = 0 ;
			Nodo_atencion actual = this.primero;
			while (actual != null) {
				datos[i][0] = actual.orden.noOrden;
				datos[i][1] = actual.auto.marca;
				datos[i][2] = actual.cliente.nombre;
				datos[i][3] = actual.empleado.nombre;
				i++;
				System.out.println(actual.info);
				actual = actual.next;
			}
		}
		
		return datos;
	}
	

	
	public void ComboBox(JComboBox<String> comboBox) {
		
		
		if (isNone() == false) {
			Nodo_atencion actual = this.primero;
			while (actual != null) {
				comboBox.addItem(actual.servicio.nombre);
				actual = actual.next;
			}
		}
		
		comboBox.setBounds(620, 52, 338, 22);
	
		
	}

	public Servicio Search(String servicio) {
		if (isNone() == false) {
			Nodo_atencion actual = this.primero;
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
			Nodo_atencion actual = this.primero;
			Nodo_atencion anterior = null;

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

class Nodo_atencion {

	Nodo_atencion next;
	int  info;
	Servicio servicio;
	Cliente cliente;
	Automovil auto;
	Orden_trabajo orden;
	Empleado empleado;

	public Nodo_atencion(int info,Servicio servicio,Cliente cliente,Automovil auto,Empleado empleado,Orden_trabajo orden) {
		this.next = null;
		this.info = info;
		this.servicio = servicio;
		this.cliente=cliente;
		this.auto=auto;
		this.empleado = empleado;
		this.orden = orden;
	}
}
