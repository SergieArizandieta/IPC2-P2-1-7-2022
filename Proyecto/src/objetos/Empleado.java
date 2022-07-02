package objetos;

public class Empleado{
    public int identificador;
    public String nombre,usuario,password;
    public int rol;
    
    
    public Empleado(int identificador , String nombre, String usuario, String password ,  int rol) {
    	this.identificador = identificador;
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


}