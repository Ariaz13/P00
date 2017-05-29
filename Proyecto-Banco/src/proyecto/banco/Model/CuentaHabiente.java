
package proyecto.banco.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CuentaHabiente extends Cuenta{
     
    Conection conec = new Conection();

    public CuentaHabiente(int numero, float saldo, String imagen, String tipoTarjeta) {
        super(numero, saldo, imagen, tipoTarjeta);
    }
    
    
    
    
}
