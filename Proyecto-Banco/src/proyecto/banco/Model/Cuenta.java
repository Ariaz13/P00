
package proyecto.banco.Model;

public class Cuenta {

    private int numero;
    private float saldo;
    private String imagen;
    private String tipoTarjeta;
    
    public Cuenta(int numero, float saldo, String imagen, String tipoTarjeta){
        this.numero = numero;
        this.saldo = saldo;
        this.imagen = imagen;
        this.tipoTarjeta = tipoTarjeta;
    }
    
    public Cuenta(float saldo, String imagen){        
        this.saldo = saldo;
        this.imagen = imagen;
    }

    public Cuenta() {
    }
    
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public int getNumero(){
        return this.numero;
    }
    
	/*  El método setSaldo aplica para cuentas de débito, en las
		que el saldo no puede ser menor a cero, habrá de ajustarse
		sobre todo para cuentas derivadas de crédito y de débito.

		El interés por ahora es colocar excepciones definidas por 
		el usuario
	*/
		
    public void setSaldo(int cantidad) 
            throws MontoIncorrecto{
        if(cantidad >= 0)
            saldo = cantidad;
        else
            throw new MontoIncorrecto("Cantidad incorrecta\n" +
                                      "la cuenta es de débito");
    }
    
    public float getSaldo(){
        return saldo;
    }
    
    public void setImagen(String imagen){
        this.imagen = imagen;
    }
    
    public String getImagen(){
        return this.imagen;
    }
    
    public void depósito(float cantidad) throws MontoIncorrecto{
        if(cantidad >= 0)
            saldo += cantidad;
        else
            throw new MontoIncorrecto("Cantidad incorrecta\n" + 
                                      "Se intentó depositar $" + cantidad +
									  "\nNo se reciben depósitos negativos");
    }
    
    public float retiro(float cantidad) throws SaldoInsuficiente{
        if(saldo < cantidad)
            throw new SaldoInsuficiente("Fondos insuficientes");
        else{
            saldo -= cantidad;
            return cantidad;
        }            
    }    
}
