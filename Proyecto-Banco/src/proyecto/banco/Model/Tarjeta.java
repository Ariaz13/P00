
package proyecto.banco.Model;

import javax.swing.JTextField;

public interface Tarjeta {
    
    abstract Cuenta consultar();
    
    abstract void depositar(double cantidad);
    
    abstract void retirar(double cantidad);
    
    
}
