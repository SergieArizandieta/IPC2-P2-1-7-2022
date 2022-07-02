package objetos;


public class Servicio{
    public int identificador;
    public String nombre,marca,modelo;
    // pila 
    public double precio,total;
    
    public Servicio (int identificador , String nombre,String marca,String modelo , double precio , double total) {
    	this.identificador = identificador;
    	this.nombre = nombre;
    	this.marca = marca;
    	this.modelo = modelo;
    	this.precio = precio;
    	this.total = total;
    }

}