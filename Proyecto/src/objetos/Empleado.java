package objetos;

public class Empleado{
    public int identificador;
    public String nombre,usuario,password;
    public int rol;
    
    
    public Empleado( String nombre,  int rol , String usuario, String password  ) {
    	this.nombre = nombre;
    	this.usuario = usuario;
    	this.password = password;
    	this.rol = rol;
    }


    public String getRol(){
        if(this.rol == 1){
            return "Mecanico";
        }else if(this.rol == 2){
            return "Administrador";
        }else if(this.rol == 3){
            return "Receptor/Pagador";
        }
        
		return null;
    }
    
    public static int setRol(String tipo) {
    	tipo = tipo.toLowerCase();
    	if(tipo.equals("mecanico")) {
    		return 1;
    	}else if(tipo.equals("administrador")) {
    		return 2;
    	}else if(tipo.equals("repectorpagador")) {
    		return 3;
    	}
    	return 0;
    }
    
    public void print() {
    	System.out.println(this.nombre + " " + this.usuario +  " " + this.password + " " + getRol() + " " + this.identificador);
		
	}

}