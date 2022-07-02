package almacenamiento;
import Listas.Doble_Empleados;
import objetos.*;

public class Memoria {
	public Cliente  clientesesion;
	public Doble_Empleados Empleados = new Doble_Empleados();
	
	public void incializar() {
		Long id = Long.valueOf("3");
		Cliente new_client = new Cliente(id,"any","anny","123",1);
		clientesesion = new_client;
		System.out.println(new_client.DPI + " " + new_client.nombre + " " + new_client.usuario + " " + new_client.tipo);
		System.out.println("INICIANDO " + new_client.nombre);
		
	}
	
	

	
}
