
package proyecto.banco.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TDC implements Tarjeta{
    
    public Conection cc = new Conection();
    Cuenta cta = new Cuenta();
     
    String tar = "Crédito";
    
    @Override
    public boolean verificarTarjeta (String nCuenta){
        try{
            Statement s = cc.c.createStatement();
            ResultSet rs = s.executeQuery("Select * From Cuenta "+"Where TipoTarjeta = '" + tar +"' and NoCuenta = '" + nCuenta + "'");
            if(rs.next()){
                return true;
            }else{
                
            }
        }catch(SQLException e){
            System.err.println("Problemas con la ejecución de su sentencia " + e.getMessage());
        }        
        return false;        
    }

    
    @Override
    public Cuenta consultar(String nCuenta) {
        try{
            Statement s = cc.c.createStatement();            
            ResultSet rs = s.executeQuery("Select * From Cuenta "+ " Where NoCuenta = '" + nCuenta + "'");            
            if(rs.next()){
                return new Cuenta(rs.getFloat("Saldo"), rs.getString("TipoTarjeta"), rs.getString("NoCuenta"));
            }    
        }catch(SQLException e){
            System.err.println("Problemas con la consulta " + e.getMessage());
        }
        
        return null; 
    }

    @Override
    public void depositar(double cantidad, String nCuenta) {
        if (cantidad >= 0 ){
            try{
            Statement s = cc.c.createStatement();
            s.executeUpdate("Update Cuenta Set Saldo = Saldo + "+ cantidad + " Where NoCuenta= '"+ nCuenta + "'");
            Calendar calendario = Calendar.getInstance();
            s.execute("Insert into movimientos values (" + cantidad + ", 'Depósito', '"+ nCuenta + "', '"+
                    (calendario.get(Calendar.DAY_OF_MONTH)+"/"+  calendario.get(Calendar.MONTH)+"/"+ 
                     calendario.get(Calendar.YEAR)) +  "')");
        }catch(SQLException e){
            System.err.println("Problemas con la actualización " +
                               e.getMessage());
        }
        }
        try {
            cta.depósito(cantidad);
        } catch (OperaciónErronea ex) {
            System.out.println(ex.getMensaje());
        }
    }

    @Override
    public void retirar(double cantidad, String nCuenta) {
        
        if (cantidad >= 0)
        try{
            Statement s = cc.c.createStatement();
            s.executeUpdate("Update Cuenta Set Saldo = Saldo - "+ cantidad + " Where NoCuenta= '"+ nCuenta + "'");            
            Calendar calendario = Calendar.getInstance();
            s.execute("Insert into movimientos values (" + cantidad + ", 'Retiro', '"+ nCuenta + "', '"+
                    (calendario.get(Calendar.DAY_OF_MONTH)+"/"+  calendario.get(Calendar.MONTH)+"/"+ 
                     calendario.get(Calendar.YEAR)) +  "')");
        }catch(SQLException e){
            System.err.println("Problemas con la actualización " +
                                e.getMessage());
        }
        try {
            cta.retiro(cantidad);
        } catch (CantidadInsuficiente ex) {
        }
    }
    
}
