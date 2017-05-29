package proyecto.banco.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conection {
    Connection c;
    
    public void conectar(){
        try {
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/Banco", "Usuario", "contraseña");
        } catch (SQLException ex) {
            System.out.println("Problemas con la conexion " + ex.getMessage());
        }
    }
    
    public boolean verifyAccount(String number, int pin){
        try{
            Statement s = c.createStatement();
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
    
        public void desconectar(){
        try {
        c.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        
    public static void main(String[] args) {
        Conection conect = new Conection ();
        
        conect.conectar();
        conect.desconectar();
    }
    
}
