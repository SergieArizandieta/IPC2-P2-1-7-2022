package objetos;

import Listas.Circular;
import Listas.Cola_facturas;
import Listas.Simple3;

public class Cliente{
    public Long DPI;
    public String nombre,usuario,password,tipo;
    public Circular autos = new Circular();
    public Cola_facturas facturas = new Cola_facturas();
    
    
    public Cliente( Long DPI ,String nombre, String usuario, String password , String tipo ,Circular autos) {
    	this.DPI = DPI;
    	this.nombre = nombre;
    	this.usuario = usuario;
    	this.password = password;
    	this.tipo = tipo;
    	this.autos = autos;
    }
}