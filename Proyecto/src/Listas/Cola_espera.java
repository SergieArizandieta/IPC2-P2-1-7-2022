package Listas;

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

public class Cola_espera {
	int contador;
	Nodo_espera primero;

	public Cola_espera() {
		this.primero = null;
	}

	public void insert(Servicio servicio,Cliente cliente,Automovil auto,Memoria memoria) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		 
		Nodo_espera new_node = new Nodo_espera(contador + 1,servicio, cliente, auto);
		
		
		if(auto.modelo.toLowerCase().equals(servicio.modelo.toLowerCase()) && auto.marca.toLowerCase().equals(servicio.marca.toLowerCase())) {
			Orden_trabajo orden = new Orden_trabajo(auto, cliente,dtf.format(LocalDateTime.now()), "Cola para ser atendido");
			memoria.cola_orden.insert(orden);
			new_node.orden = orden;
			if (isNone()) {
				contador++;
				this.primero = new_node;
			} else {
				contador++;
				Nodo_espera actual = this.primero;
				while (actual != null) {
					if(actual.next == null) {
						actual.next = new_node;
					}
					actual = actual.next;
				}
				Ordenar();
			}
		}else {
			JOptionPane.showMessageDialog(null, "El auto y el servicio no corresponden");
		}
	}

	public void showList() {
		if (isNone() == false) {
			System.out.println(" ESPERA ");
			Nodo_espera actual = this.primero;
			while (actual != null) {
				System.out.println(actual.info);
				actual.servicio.print();
				actual = actual.next;
			}
		}
	}
	
	public void asignnado(Memoria memoria) {
		if (isNone() == false) {
			System.out.println(" ESPERA ");
			Nodo_espera actual = this.primero;
			while (actual != null) {
				Empleado mecanico = memoria.Empleados.Search_mecanicovacio();
				Orden_trabajo orden = memoria.Espera.orden_primero();
				Cliente cliente = memoria.Espera.cliente_primero();
				Automovil auto = memoria.Espera.auto_primero();
				Servicio servicio = memoria.Espera.servicio_primero();
				Desencolar();
				
				if(mecanico != null) {
					memoria.cola_atencion.insert(servicio, cliente, auto, mecanico,orden);
				}
				
				actual = actual.next;
			}
		}
	}
	
	public Object[][] tabla() {
		Object[][] datos = new Object[contador][3];
		
		
		if (isNone() == false) {
			int i = 0 ;
			Nodo_espera actual = this.primero;
			while (actual != null) {
				datos[i][0] = actual.orden.noOrden;
				datos[i][1] = actual.auto.marca;
				datos[i][2] = actual.cliente.nombre;
				i++;
				System.out.println(actual.info);
				actual = actual.next;
			}
		}
		
		return datos;
	}
	
	public void Ordenar() {
		Boolean validacion = true;
		
		if (isNone() == false) {
			Nodo_espera actual = this.primero;
			Nodo_espera anterior = null;
			while(validacion) {
				
				while (actual != null) {
					System.out.println(actual.info);
					actual.servicio.print();
					if(actual.cliente.tipo.toLowerCase().equals("normal")) {
						if(actual.next.cliente.tipo.toLowerCase().equals("oro")) {
							if(anterior != null) {
								anterior.next = actual.next;
								actual.next = anterior;
								break;
							}
						}
					}
					anterior =actual;
					actual = actual.next;
				}
				validacion = false;
				
			}

		}
	}
	
	public void ComboBox(JComboBox<String> comboBox) {
		
		
		if (isNone() == false) {
			Nodo_espera actual = this.primero;
			while (actual != null) {
				comboBox.addItem(actual.servicio.nombre);
				actual = actual.next;
			}
		}
		
		comboBox.setBounds(620, 52, 338, 22);
	
		
	}

	public Servicio Search(String servicio) {
		if (isNone() == false) {
			Nodo_espera actual = this.primero;
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
			Nodo_espera actual = this.primero;
			Nodo_espera anterior = null;

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
	
	public Orden_trabajo orden_primero() {
		return this.primero.orden;
	}
	public Cliente cliente_primero() {
		return this.primero.cliente;
	}
	public Automovil auto_primero() {
		return this.primero.auto;
	}
	public void Desencolar() {
		this.primero = this.primero.next;
	}
	
	public Servicio servicio_primero() {
		return this.primero.servicio;
	}
	
	
	
}

class Nodo_espera {

	Nodo_espera next;
	int  info;
	Servicio servicio;
	Cliente cliente;
	Automovil auto;
	Orden_trabajo orden;

	public Nodo_espera(int info,Servicio servicio,Cliente cliente,Automovil auto) {
		this.next = null;
		this.info = info;
		this.servicio = servicio;
		this.cliente=cliente;
		this.auto=auto;
	}
}
