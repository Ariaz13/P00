
package proyecto.banco.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CuentaHabiente extends Cuenta{
     
    Conection conec = new Conection();

    public CuentaHabiente(int numero, float saldo, String imagen, String tipoTarjeta) {
        super(numero, saldo, imagen, tipoTarjeta);
    }
    
    public boolean verifyAccount(String number, int pin){
        try{
            Statement s = conec.c.createStatement();
            ResultSet rs = s.executeQuery("Select * From CuentaHabiente "+
                                          "Where NoCuenta = '" + number +
                                          "' and PIN = " + pin );            
            if(rs.next())
                return true;
            else
                System.err.println("Revise sus datos de registro");
        }catch(SQLException e){
            System.err.println("Problemas con la ejecución de su sentencia " + 
                               e.getMessage());
        }        
        return false;        
    }
    
    
}
