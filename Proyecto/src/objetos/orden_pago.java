package objetos;

public class orden_pago{
    public int noOrden;
    public automovil auto;
    public cliente cliente;
    public String fecha;
    public int estado;
    
    public orden_pago(int noOrden,automovil auto,cliente cliente,String fecha,int estado) {
    	this.noOrden =noOrden;
    	this.auto =auto;
    	this.cliente =cliente;
    	this.fecha =fecha;
    	this.estado =estado;
    }

}