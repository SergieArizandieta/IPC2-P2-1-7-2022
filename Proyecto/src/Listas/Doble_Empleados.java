package Listas;

import javax.swing.JOptionPane;

import objetos.Empleado;

public class Doble_Empleados {
Nodo_Doble primero;
int contador = 0;
public Empleado buscado;

	public Doble_Empleados() {
		this.primero = null;
	}
	
	public void insert(Empleado empleado) {
		Nodo_Doble new_node = new Nodo_Doble(contador + 1,empleado);
		empleado.identificador = contador +1;
		
		if (isNone()) {
			contador++;
			this.primero = new_node;
		}else {
			contador++;
			
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
				actual.empleado.print();
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
					JOptionPane.showMessageDialog(null, "No se encontro la empleado!");
					break;
				}
			}
			if (actual != null && actual.info == data) {
				buscado = actual.empleado;
				System.out.println("Dato encontrado: " + data);
				JOptionPane.showMessageDialog(null, "Se encontro al empleado!");
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
				JOptionPane.showMessageDialog(null, "No se encontro el empleado a eliminar!");
			}else {
				
				if (actual.previous == null) {
					this.primero = actual.next;
					System.out.println("Se elimino el dato: " + data);
					JOptionPane.showMessageDialog(null, "Se elimino al empleado!");
				} else if (actual != null) {
					actual.previous.next = actual.next;
					actual.next = null;
					System.out.println("Se elimino el dato: " + data);
					JOptionPane.showMessageDialog(null, "Se elimino al empleado!");
				}
			}
			 
		}
	}
	
	public void Terminado() {
		buscado = null;
		
	}
	
	public Boolean isNone() {
		return this.primero == null;
	}
}

class Nodo_Doble{	
	
	Nodo_Doble next, previous;
	int info;
	public Empleado empleado;
	
	public Nodo_Doble(int info,Empleado empleado) {
		this.next =null;
		this.previous = null;
		this.info = info;
		this.empleado=empleado;
	}
}
