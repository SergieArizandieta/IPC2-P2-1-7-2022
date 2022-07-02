package Listas;

import objetos.Automovil;
import objetos.Cliente;

public class Circular_Doble {
	Nodo_Circular_doble primero;

	public Circular_Doble() {
		this.primero = null;
		this.ultimo = null;
	}

	public void insert(Cliente cliente,Circular autos) {
		Nodo_Circular_doble new_node = new Nodo_Circular_doble(cliente.DPI,cliente,autos);

		if (isNone()) {
			this.primero = new_node;
			this.ultimo = new_node;
		} else {
			new_node.next = this.primero.next;
			this.primero.next = new_node;
			
			this.ultimo.next = new_node;
			new_node.next = this.primero;
			new_node.previous = this.ultimo;
			this.ultimo = new_node;
			this.primero.previous = ultimo;
		}
	}

	public void showList() {
		Nodo_Circular_doble actual = this.primero;

		if (isNone() == false) {
			do {
				System.out.println(actual.info);
				actual = actual.next;
			} while (actual != this.primero);
			
		}

	}
	Nodo_Circular_doble ultimo;
	public void Search(Long data) {
		
		if (isNone() == false) {
			Nodo_Circular_doble actual = this.primero;
			Boolean Encontrado = true;
			do {
				if (actual.info.equals(data)) {
					System.out.println("Dato encontrado: " + data);
					Encontrado = false;
					break;
				}else {
					actual = actual.next;
				}
			} while (actual != this.primero );
			
			if(Encontrado) {
				System.out.println("No se encontro el dato: " + data);
			}
			
		}
	}
	
	public void Delete(Long data) {
		
		if (isNone() == false) {
			Nodo_Circular_doble actual = this.primero;
			Nodo_Circular_doble anterior = null;
			Boolean Encontrado = true;
			
			do {
				if (actual.info.equals( data)) {
					System.out.println("Se elimino el dato: " + data);
					
					if(anterior == null) {
						this.primero = this.primero.next;
						do {
							anterior = actual.next;
						} while (anterior != this.primero);
					}
					
					anterior.next = actual.next;
					actual.next = null;
					Encontrado = false;
					break;
					
				}else {
					anterior = actual;
					actual = actual.next;
				}
			} while (actual != this.primero );
			
			if(Encontrado) {
				System.out.println("No se encontro el dato a eliminar: " + data);
			}
			
		}
	}
	
	

	public Boolean isNone() {
		return this.primero == null;
	}

}

class Nodo_Circular_doble {

	Nodo_Circular_doble next,previous;
	Long info;
	Cliente cliente;
	Circular autos;
	public Nodo_Circular_doble(Long dPI,Cliente cliente,Circular autos) {
		this.info = dPI;
		this.next = this;
		this.previous = this;
		this.cliente = cliente;
		this.autos=autos;

	}
}
