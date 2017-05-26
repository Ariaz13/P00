package proyecto.banco.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {
    Connection c;
    
    public void conectar(){
        try {
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/Banco", "Usuario", "contraseña");
        } catch (SQLException ex) {
            System.out.println("Problemas con la conexion " + ex.getMessage());
        }
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
