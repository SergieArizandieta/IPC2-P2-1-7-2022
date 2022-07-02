package Listas;

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

	public void Search(int data) {
		if (isNone() == false) {
			Nodo_Simple actual = this.primero;
			while (actual != null && actual.info != data) {
				actual = actual.next;
				if (actual == null) {
					System.out.println("No se encontro el dato: " + data);
					break;
				}
			}
			if (actual != null && actual.info == data) {
				System.out.println("Dato encontrado: " + data);
			}
		}
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
