
package proyecto.banco.Model;

import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

public abstract class TDC extends Tarjeta{
    
    Conection conec = new Conection();
    
    public TDC(long noCuenta, Image foto, float saldo) {
        super(noCuenta, foto, saldo);
    }

    public Cuenta consultar(long noCuenta) {
        try{
            Statement s = conec.c.createStatement();            
            ResultSet rs = s.executeQuery("Select * From Cuenta "+
                                          "Where NoCuenta = '" + noCuenta + "'");            
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

    void depositar(double monto, long noCuenta) {
        if (monto >= 0 ){
            try{
            Statement s = conec.c.createStatement();
            s.executeUpdate("Update Cuenta Set Saldo = Saldo + "+ monto +
                            " Where Numero= '"+ noCuenta + "'");
            Calendar calendario = Calendar.getInstance();
            s.execute("Insert into movimientos values ('" + 
                    noCuenta + "', 'Depósito', "+ "'"+
                    (calendario.get(Calendar.DAY_OF_MONTH)+"/"+ 
                     calendario.get(Calendar.MONTH)+"/"+ 
                     calendario.get(Calendar.YEAR)) + "', " + 
                    monto + ")");
        }catch(SQLException e){
            System.err.println("Problemas con la actualización " +
                               e.getMessage());
        }
        }
    }
    

    void retirar(double monto, long noCuenta ) {
        try{
            Statement s = conec.c.createStatement();
            s.executeUpdate("Update Cuenta Set Saldo = Saldo - "+ monto +
                            " Where Numero= '"+ noCuenta + "'");            
            Calendar calendario = Calendar.getInstance();
            s.execute("Insert into movimientos values ('" + noCuenta + "', 'Retiro', "+ "'"+(calendario.get(Calendar.DAY_OF_MONTH)+"/"+ calendario.get(Calendar.MONTH)+"/"+ calendario.get(Calendar.YEAR)) + "', " + monto + ")");
        }catch(SQLException e){
            System.err.println("Problemas con la actualización " +
                               e.getMessage());

        
    }
    
    } 
}
