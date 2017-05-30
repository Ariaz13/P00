
package proyecto.banco.Model;

public class Cuenta {

    private String numero;  //Numero de cuenta
    private double saldo;   //Saldo que tiene la cuenta
    private String imagen;  
    private String tipoTarjeta; //Si es de Crédito o Debito
    
    public Cuenta(String numero, double saldo, String imagen, String tipoTarjeta){
        this.numero = numero;
        this.saldo = saldo;
        this.imagen = imagen;
        this.tipoTarjeta = tipoTarjeta;
    }
    
    public Cuenta(double saldo, String imagen){        
        this.saldo = saldo;
        this.imagen = imagen;
    }

    public Cuenta() {
        
    }
    
    public void setNumero(String numero){
        this.numero = numero;
    }
    
    public String getNumero(){
        return this.numero;
    }
    		
    public void setSaldo(double cantidad) 
            throws OperaciónErronea{
        if(cantidad >= 0)
            saldo = cantidad;
        else
            throw new OperaciónErronea("Cantidad incorrecta\n" +
                                      "la cuenta es de débito");
    }
    
    public double getSaldo(){
        return saldo;
    }
    
    public void setImagen(String imagen){
        this.imagen = imagen;
    }
    
    public String getImagen(){
        return this.imagen;
    }
    
    public void setTipoTarjeta(String tarjeta){
        this.tipoTarjeta = tarjeta;
    }
    
    public String getTipoTarjeta (){
        return this.tipoTarjeta;
    }
    
    public void depósito(double cantidad) throws OperaciónErronea{
        if(cantidad >= 0)
            saldo += cantidad;
        else
            throw new OperaciónErronea("Cantidad incorrecta\n" + 
                                      "Se intentó depositar $" + cantidad +
									  "\nNo se reciben depósitos negativos");
    }
    
    public double retiro(double cantidad) throws CantidadInsuficiente{
        if(saldo < cantidad)
            throw new CantidadInsuficiente("Fondos insuficientes");
        else{
            saldo -= cantidad;
            return cantidad;
        }            
    }    
}
