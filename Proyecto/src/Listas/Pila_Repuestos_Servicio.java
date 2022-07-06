package Listas;

import javax.swing.JOptionPane;

import almacenamiento.Memoria;
import objetos.Empleado;
import objetos.Repuesto;

public class Pila_Repuestos_Servicio {
Nodo_Pila primero;
int contador = 0;


	public Pila_Repuestos_Servicio() {
		this.primero = null;
	}
	
	public void insert(int repuesto) {
		Nodo_Pila new_node = new Nodo_Pila(contador + 1,repuesto);
		
		if (isNone()) {
			contador++;
			this.primero = new_node;
		}else {
			contador++;
			
			new_node.next = this.primero;
			this.primero = new_node;
		}	
	}
	
	public void showList() {
		if (isNone() == false) {
			Nodo_Pila actual = this.primero;
			while (actual != null) {
				System.out.println(actual.info);
				actual = actual.next;
			}
		}
	}
	
	public Double recorrer(Memoria memoria) {
		Double precio = 0.0;
		if (isNone() == false) {
			Nodo_Pila actual = this.primero;
			while (actual != null) {
				precio += memoria.Repuesto.Search(actual.repuesto);
				actual = actual.next;
			}
		}
		System.out.println("PRecio total repuestos");
		System.out.println(precio);
		
		return precio;
	}

	
	public int cima() {
		if (isNone() == false) {
			return this.primero.repuesto;		
		}
		return 0;
	}
	
	public void Delete(int data) {
		if (isNone() == false) {
			
			this.primero = this.primero.next;
					
		}
	}

	public Boolean isNone() {
		return this.primero == null;
	}
}

class Nodo_Pila{	
	
	Nodo_Pila next;
	int info;
	public int repuesto;
	
	public Nodo_Pila(int info,int repuesto) {
		this.next =null;

		this.info = info;
		this.repuesto=repuesto;
	}
}
