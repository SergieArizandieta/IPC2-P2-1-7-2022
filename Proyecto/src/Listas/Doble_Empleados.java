package Listas;

import objetos.Empleado;

public class Doble_Empleados {
Nodo_Doble primero;
int contador = 0;
Nodo_Doble buscado;

	public Doble_Empleados() {
		this.primero = null;
	}
	
	public void insert(Empleado empleado) {
		Nodo_Doble new_node = new Nodo_Doble(contador + 1,empleado);
		if (isNone()) {
			this.primero = new_node;
		}else {
			contador++;
			empleado.identificador = contador;
			new_node.next = this.primero;
			this.primero.previous = new_node;
			this.primero = new_node;
		}	
	}
	
	public void showList() {
		if (isNone() == false) {
			Nodo_Doble actual = this.primero;
			while (actual != null) {
				System.out.println(actual.info);
				actual = actual.next;
			}
		}
	}
	
	public void Search(int data) {
		if (isNone() == false) {
			Nodo_Doble actual = this.primero;
			while (actual != null && actual.info != data) {
				actual = actual.next;
				if (actual == null) {
					buscado = null;
					System.out.println("No se encontro el dato: " + data);
					break;
				}
			}
			if (actual != null && actual.info == data) {
				buscado = actual;
				System.out.println("Dato encontrado: " + data);
			}
		}
	}
	
	public void Delete(int data) {
		if (isNone() == false) {
			Nodo_Doble actual = this.primero;

			while (actual != null && actual.info != data) {
				actual = actual.next;
			}
			
			if  (actual == null) {
				System.out.println("No se encontro el dato a eliminar: " + data);
			}else {
				
				if (actual.previous == null) {
					this.primero = actual.next;
					System.out.println("Se elimino el dato: " + data);
				} else if (actual != null) {
					actual.previous.next = actual.next;
					actual.next = null;
					System.out.println("Se elimino el dato: " + data);
				}
			}
			 
		}
	}
	
	public Boolean isNone() {
		return this.primero == null;
	}
}

class Nodo_Doble{	
	
	Nodo_Doble next, previous;
	int info;
	Empleado empleado;
	
	public Nodo_Doble(int info,Empleado empleado) {
		this.next =null;
		this.previous = null;
		this.info = info;
		this.empleado=empleado;
	}
}
