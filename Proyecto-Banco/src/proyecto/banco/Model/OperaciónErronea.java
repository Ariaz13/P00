package proyecto.banco.Model;

public class OperaciónErronea extends Exception{
    OperaciónErronea(String mensaje){
        super(mensaje);
    }
    
    public String getMensaje(){
        return super.getMessage();
    }
}
