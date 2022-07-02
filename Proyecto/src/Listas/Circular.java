package Listas;

import objetos.Automovil;

public class Circular {
	Nodo_Circular primero;

	public Circular() {
		this.primero = null;
	}

	public void insert(Automovil auto) {
		Nodo_Circular new_node = new Nodo_Circular(auto.placa,auto);

		if (isNone()) {
			this.primero = new_node;
		} else {
			new_node.next = this.primero.next;
			this.primero.next = new_node;
		}
	}

	public void showList() {
		Nodo_Circular actual = this.primero;

		if (isNone() == false) {
			do {
				System.out.println(actual.info);
				actual = actual.next;
			} while (actual != this.primero);
			
		}

	}
	
	public void Search(String data) {
		
		if (isNone() == false) {
			Nodo_Circular actual = this.primero;
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
	
	public void Delete(String data) {
		
		if (isNone() == false) {
			Nodo_Circular actual = this.primero;
			Nodo_Circular anterior = null;
			Boolean Encontrado = true;
			
			do {
				if (actual.info == data) {
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

class Nodo_Circular {

	Nodo_Circular next;
	String info;
	Automovil auto;
	public Nodo_Circular(String info,Automovil auto) {
		this.info = info;
		this.next = this;
		this.auto = auto;

	}
}
