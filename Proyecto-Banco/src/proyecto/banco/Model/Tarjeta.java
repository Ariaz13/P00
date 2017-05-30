
package proyecto.banco.Model;

public interface Tarjeta {
    
    abstract boolean verificarTarjeta(String nCuenta);
    
    abstract Cuenta consultar(String nCuenta);
    
    abstract void depositar(double cantidad, String nCuenta);
    
    abstract void retirar(double cantidad, String nCuenta);
    
    
}
