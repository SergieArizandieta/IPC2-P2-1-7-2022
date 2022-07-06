package Listas;

import javax.swing.JComboBox;

import objetos.Orden_trabajo;
import objetos.Servicio;

public class Simple3 {
	int contador;
	Nodo_Simple_3 primero;

	public Simple3() {
		this.primero = null;
	}

	public void insert(Orden_trabajo orden) {
		Nodo_Simple_3 new_node = new Nodo_Simple_3(contador + 1,orden);
		orden.noOrden = contador+ 1;
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
			Nodo_Simple_3 actual = this.primero;
			while (actual != null) {
				System.out.println(actual.info);
				actual.orden.print();
				actual = actual.next;
			}
		}
	}

	public void Delete(int data) {
		if (isNone() == false) {
			Nodo_Simple_3 actual = this.primero;
			Nodo_Simple_3 anterior = null;

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

class Nodo_Simple_3 {

	Nodo_Simple_3 next;
	int  info;
	Orden_trabajo orden;

	public Nodo_Simple_3(int info,Orden_trabajo orden) {
		this.next = null;
		this.info = info;
		this.orden = orden;
	}
}
