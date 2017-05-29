
package proyecto.banco.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextField;

public class Validación {
    Conection cc = new Conection();
    
    public boolean verifyAccount(JTextField nCuenta, JTextField nip){
        try{
            Statement s = cc.c.createStatement();
            ResultSet rs = s.executeQuery("Select * From CuentaHabiente "+
                                          "Where NoCuenta = '" + nCuenta +
                                          "' and PIN = " + nip );
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

    public boolean verifyAccount() {
        return false;
    }
    
}
