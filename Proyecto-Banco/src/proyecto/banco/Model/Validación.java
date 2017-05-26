
package Model;

import View.Display;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Validación {
    Connection c;
    Display d = new Display();
    
    public void conectar(){
        try {
            c = DriverManager.getConnection( "", "", "");
        } catch (SQLException ex) {
            System.out.println("Problemas con la conexión.\n" + ex.getMessage());
        }
    }
    
    public boolean consultarCuenta(){
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("where " + nCuenta + " from cuenta");
            while(rs.next()){
                System.out.println(rs.getString("noCuenta"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }
    
    public boolean consultarNip(){
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("where " + nip + " = cuenta.noCuenta");
            while(rs.next()){
                System.out.println(rs.getString("nip"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }
    
    public void desconectar(){
        try {
            c.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
}
