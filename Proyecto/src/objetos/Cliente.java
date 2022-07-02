package objetos;

public class Cliente{
    public Long DPI;
    public String nombre,usuario,password,tipo;

    
    public Cliente( Long DPI ,String nombre, String usuario, String password , String tipo ) {
    	this.DPI = DPI;
    	this.nombre = nombre;
    	this.usuario = usuario;
    	this.password = password;
    	this.tipo = tipo;
    }
}