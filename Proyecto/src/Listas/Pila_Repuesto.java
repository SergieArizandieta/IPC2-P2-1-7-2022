package Listas;

import javax.swing.JOptionPane;

import objetos.Empleado;
import objetos.Repuesto;

public class Pila_Repuesto {
Nodo_Pila_Repuesto primero;
int contador = 0;
public Repuesto buscado;

	public Pila_Repuesto() {
		this.primero = null;
	}
	
	public void insert(Repuesto repuesto) {
		Nodo_Pila_Repuesto new_node = new Nodo_Pila_Repuesto(contador + 1,repuesto);
		repuesto.identificador = contador +1;
		
		if (isNone()) {
			contador++;
			this.primero = new_node;
		}else {
			contador++;
			new_node.next = this.primero;
			this.primero = new_node;
		}	
	}
	
	
	public Repuesto Cima() {
		return this.primero.repuesto;
	}
	

	public void Desapilar() {
		if (isNone() == false) {
			JOptionPane.showMessageDialog(null, "Se elimino el repuesto!");
			this.primero = this.primero.next;
					
		}
	}
	
	
	public void showList() {
		if (isNone() == false) {
			Nodo_Pila_Repuesto actual = this.primero;
			while (actual != null) {
				System.out.println(actual.info);
				actual.repuesto.print();
				actual = actual.next;
			}
		}
	}
	
	public void Search(int data) {
		if (isNone() == false) {
			Nodo_Pila_Repuesto actual = this.primero;
			while (actual != null && actual.info != data) {
				actual = actual.next;
				if (actual == null) {
					buscado = null;
					System.out.println("No se encontro el dato: " + data);
					JOptionPane.showMessageDialog(null, "No se encontro el repuesto!");
					break;
				}
			}
			if (actual != null && actual.info == data) {
				buscado = actual.repuesto;
				System.out.println("Dato encontrado: " + data);
				JOptionPane.showMessageDialog(null, "Se encontro el repuesto!");
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

class Nodo_Pila_Repuesto{	
	
	Nodo_Pila_Repuesto next;
	int info;
	public Repuesto repuesto;
	
	public Nodo_Pila_Repuesto(int info,Repuesto repuesto) {
		this.next =null;
		this.info = info;
		this.repuesto=repuesto;
	}
}
