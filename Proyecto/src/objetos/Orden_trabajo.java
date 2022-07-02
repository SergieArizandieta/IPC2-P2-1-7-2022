package objetos;

public class Orden_trabajo{
    public int noOrden;
    public Automovil auto;
    public Cliente cliente;
    public String fecha;
    public int estado;
    
    public Orden_trabajo(int noOrden,Automovil auto,Cliente cliente,String fecha,int estado) {
    	this.noOrden =noOrden;
    	this.auto =auto;
    	this.cliente =cliente;
    	this.fecha =fecha;
    	this.estado =estado;
    }

}