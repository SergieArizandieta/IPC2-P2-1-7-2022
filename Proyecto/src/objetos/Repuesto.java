package objetos;

public class Repuesto{
    public int identificador;
    public String nombre,marca,modelo;
    public Boolean existencia;
    public double precio;
    
    public Repuesto(int identificador, String nombre , String marca , String modelo,Boolean existencia ,   double precio) {
    	this.identificador = identificador;
    	this.nombre = nombre;
    	this.marca = marca;
    	this.modelo = modelo;
    	this.existencia =existencia;
    	this.precio = precio;
    }
    
}