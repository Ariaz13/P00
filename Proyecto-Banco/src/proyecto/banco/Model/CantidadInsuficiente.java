package proyecto.banco.Model;

public class CantidadInsuficiente extends Exception{
    public CantidadInsuficiente(String mensaje){
        super(mensaje);
    }
    
    public String getMensaje (){
        return super.getMessage();
    }
}
