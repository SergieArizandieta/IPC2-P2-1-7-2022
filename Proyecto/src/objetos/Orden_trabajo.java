package objetos;

public class Orden_trabajo{
    public int noOrden;
    public Automovil auto;
    public Cliente cliente;
    public String fecha;
    public String estado;
    
    public Orden_trabajo(Automovil auto,Cliente cliente,String fecha,String estado) {
    	this.auto =auto;
    	this.cliente =cliente;
    	this.fecha =fecha;
    	this.estado =estado;
    }
    
    public void print() {
    	System.out.println(this.auto + " " + this.cliente + " " + this.fecha + " " + this.estado);
    	
		
	}

}