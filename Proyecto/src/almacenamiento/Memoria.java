package almacenamiento;
import Listas.Circular_Doble;
import Listas.Cola_Listo;
import Listas.Cola_atencion;
import Listas.Cola_espera;
import Listas.Doble_Empleados;
import Listas.Pila_Repuesto;
import Listas.Pila_Repuestos_Servicio;
import Listas.Simple;
import Listas.Simple3;
import objetos.*;

public class Memoria {
	public Cliente  clientesesion;
	public Doble_Empleados Empleados = new Doble_Empleados();
	public Pila_Repuesto Repuesto = new Pila_Repuesto ();
	public Simple Servicios = new Simple();
	public Circular_Doble Clientes = new Circular_Doble();
	public Cola_espera Espera = new Cola_espera();
	public Simple3 cola_orden = new Simple3() ;
	public Cola_atencion cola_atencion = new Cola_atencion();
	public Cola_Listo cola_listo = new Cola_Listo();
	
	public void incializar() {
		//Long id = Long.valueOf("3");
		//Cliente new_client = new Cliente(id,"any","anny","123",1);
		//clientesesion = new_client;
		//System.out.println(new_client.DPI + " " + new_client.nombre + " " + new_client.usuario + " " + new_client.tipo);
		//System.out.println("INICIANDO " + new_client.nombre);
		
	}
	
	
	public Cliente sesion(String usuario,String password) {
		
		clientesesion = Clientes.Search(usuario);
		
		if(clientesesion.password.equals(password)) {
			return clientesesion;
		}
		return null;
		
		
	}
	
	

}
