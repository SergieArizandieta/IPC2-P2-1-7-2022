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

public class Cola_facturas {
	int contador;
	Nodo_facturas primero;

	public Cola_facturas() {
		this.primero = null;
	}

	public void insert(Servicio servicio,Automovil auto,Double precion,Orden_trabajo orden) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		 
		Nodo_facturas new_node = new Nodo_facturas(contador + 1,servicio, auto, precion,orden);

			
			if (isNone()) {
				contador++;
				this.primero = new_node;
			} else {
				contador++;
				Nodo_facturas actual = this.primero;
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
			Nodo_facturas actual = this.primero;
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
		Object[][] datos = new Object[contador][4];
		
		
		if (isNone() == false) {
			int i = 0 ;
			Nodo_facturas actual = this.primero;
			while (actual != null) {
				datos[i][0] = actual.orden.noOrden;
				datos[i][1] = actual.servicio.nombre;
				datos[i][2] = actual.auto.marca;
				datos[i][3] = actual.precio;
				i++;
				System.out.println(actual.info);
				actual = actual.next;
			}
		}
		
		return datos;
	}
	


	public Servicio Search(int orden) {
		if (isNone() == false) {
			Nodo_facturas actual = this.primero;
			while (actual != null && actual.orden.noOrden != orden) {
				actual = actual.next;
				if (actual == null) {
					System.out.println("No se encontro el dato: " + orden);
					return null;
				}
			}
			if (actual != null && actual.orden.noOrden == orden) {
				System.out.println("Dato encontrado: " + orden);
				
				return actual.servicio;
			}
		}
		return null;
	}

	public void Delete(int data) {
		if (isNone() == false) {
			Nodo_facturas actual = this.primero;
			Nodo_facturas anterior = null;

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

class Nodo_facturas {

	Nodo_facturas next;
	int  info;
	Orden_trabajo orden;
	Servicio servicio;
	Automovil auto;
	Double precio;


	public Nodo_facturas(int info,Servicio servicio,Automovil auto,Double precio,Orden_trabajo orden) {
		this.next = null;
		this.info = info;
		this.servicio = servicio;
		this.auto=auto;
		this.precio=precio;
		this.orden=orden;
	}
}
