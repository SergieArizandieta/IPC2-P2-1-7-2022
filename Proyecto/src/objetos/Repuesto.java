package objetos;

public class Repuesto{
    public int identificador,existencias,existencia;
    public String nombre,marca,modelo;
    public double precio;
    
    public Repuesto( String nombre , String marca , String modelo,int  existencias ,   double precio) {
    	this.nombre = nombre;
    	this.marca = marca;
    	this.modelo = modelo;
    	this.existencias =existencias;
    	this.precio = precio;
    }
    
    public void print() {
    	System.out.println(this.nombre + " " + this.marca +  " " + this.modelo + " " + this.existencias + " " + this.precio);
		
	}
    
}