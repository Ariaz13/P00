
package proyecto.banco.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Validación {
    public Conection cc = new Conection();
         
        public boolean verifyAccount(String nCuenta, int nip){
        try{
            Statement s = cc.c.createStatement();
            ResultSet rs = s.executeQuery("Select * From CuentaHabiente "+ "Where NoCuenta = '" + nCuenta +"' and PIN = " + nip );
            if(rs.next()){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            System.err.println("Problemas con la ejecución de su sentencia " + e.getMessage());
        }        
        return false;        
    }   
}
