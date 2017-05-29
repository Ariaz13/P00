
package proyecto.banco.Model;

import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JTextField;

public class TDC extends Tarjeta{
    
    Conection conec = new Conection();
     String nombre = "Tarjeta de Crédito";
    
    public TDC(long noCuenta, Image foto, float saldo) {
        super(noCuenta, foto, saldo);
    }

    public TDC() {
        
    }

    public Cuenta consultar(JTextField nCuenta) {
        try{
            Statement s = conec.c.createStatement();            
            ResultSet rs = s.executeQuery("Select * From Cuenta "+
                                          "Where NoCuenta = '" + nCuenta + "'");            
            if(rs.next())
                return new Cuenta(rs.getInt("NoCuenta"),
                                  rs.getFloat("Saldo"), 
                                  rs.getString("TipoTarjeta"), 
                                  rs.getString("Imagen"));
        }catch(SQLException e){
            System.err.println("Problemas con la consulta " + e.getMessage());
        }
        
        return null; 
    }

    @Override
    public void depositar(double cantidad, JTextField nCuenta) {
        if (cantidad >= 0 ){
            try{
            Statement s = conec.c.createStatement();
            s.executeUpdate("Update Cuenta Set Saldo = Saldo + "+ cantidad +
                            " Where Numero= '"+ nCuenta + "'");
            Calendar calendario = Calendar.getInstance();
            s.execute("Insert into movimientos values ('" + 
                    nCuenta + "', 'Depósito', "+ "'"+
                    (calendario.get(Calendar.DAY_OF_MONTH)+"/"+ 
                     calendario.get(Calendar.MONTH)+"/"+ 
                     calendario.get(Calendar.YEAR)) + "', " + 
                    cantidad + ")");
        }catch(SQLException e){
            System.err.println("Problemas con la actualización " +
                               e.getMessage());
        }
        }
    }

    public void retirar(double cantidad, JTextField nCuenta) {
        try{
            Statement s = conec.c.createStatement();
            s.executeUpdate("Update Cuenta Set Saldo = Saldo - "+ cantidad +
                            " Where Numero= '"+ nCuenta + "'");            
            Calendar calendario = Calendar.getInstance();
            s.execute("Insert into movimientos values ('" + nCuenta + "', 'Retiro', "+ "'"+
                    (calendario.get(Calendar.DAY_OF_MONTH)+"/"+ calendario.get(Calendar.MONTH)+"/"+ 
                    calendario.get(Calendar.YEAR)) + "', " + cantidad + ")");
        }catch(SQLException e){
            System.err.println("Problemas con la actualización " +
                                e.getMessage());
        }
    }
    
}
