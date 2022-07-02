package objetos;

public class empleado{
    public int identificador;
    public String nombre,usuario,password;
    public int rol;
    
    
    public empleado(int identificador , String nombre, String usuario, String password ,  int rol) {
    	
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