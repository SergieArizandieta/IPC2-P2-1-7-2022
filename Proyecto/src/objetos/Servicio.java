package objetos;

import Listas.Pila_Repuestos_Servicio;

public class Servicio{
    public int identificador;
    public String nombre,marca,modelo;
    public Pila_Repuestos_Servicio pila; 
    public double mano_obra;
    
    public Servicio ( String nombre,String marca,String modelo ,Pila_Repuestos_Servicio pila , double mano_obra) {
    	this.nombre = nombre;
    	this.marca = marca;
    	this.modelo = modelo;
    	this.pila = pila;
    	this.mano_obra = mano_obra;
    }
    
    public void print() {
    	System.out.println(this.nombre + " " + this.marca + " " + this.modelo +  " " + this.mano_obra);
		
	}

}