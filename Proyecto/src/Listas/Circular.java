package Listas;

import objetos.Automovil;

public class Circular {
	int contador = 0;
	Nodo_Circular primero;

	public Circular() {
		this.primero = null;
	}

	public void insert(Automovil auto) {
		Nodo_Circular new_node = new Nodo_Circular(auto.placa,auto);

		if (isNone()) {
			contador++;
			this.primero = new_node;
		} else {
			contador++;
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
	
	public Object[][] data(){
		Object[][] data = new Object[contador][4];
		Nodo_Circular actual = this.primero;
		
		
		if (isNone() == false) {
			int i=0;
			do {
				data[i][0]=actual.auto.placa;
				data[i][1]=actual.auto.marca;
				data[i][2]=actual.auto.modelo;
				data[i][3]=actual.auto.img;
				
				actual = actual.next;
				i++;
			} while (actual != this.primero);
			
		}
		
		
		return data;
	}
	
	public Automovil Search(String data) {
		
		if (isNone() == false) {
			Nodo_Circular actual = this.primero;
			Boolean Encontrado = true;
			do {
				if (actual.info.equals(data)) {
					System.out.println("Dato encontrado: " + data);
					Encontrado = false;
					return actual.auto;
				}else {
					actual = actual.next;
				}
			} while (actual != this.primero );
			
			if(Encontrado) {
				System.out.println("No se encontro el dato: " + data);
				return null;
			}
			
		}
		return null;
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
