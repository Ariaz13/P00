
package proyecto.banco.Model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Movimientos {
    private double cantidad;
    private String tipoMov;
    private String fechaMov;
    private String nCuenta;

    public Movimientos(double cantidad, String tipoMov, String nCuenta, String fecha) {
        this.cantidad = cantidad;
        this.tipoMov = tipoMov;
        this.fechaMov = fecha;
        this.nCuenta = nCuenta;
    }
    
    public Movimientos(){
        
    }
    
    
    public void setCantidad(double c){
        this.cantidad = c;
    }
    
    public double getCantidad(){
        return cantidad;
    }
    
    public void setTipoMov(String tM){
        this.tipoMov = tM;
    }
    
    public String getTipoMov(){
        return tipoMov;
    }
    
    public void setFechaMov(String fM){
        this.fechaMov = fM;
    }
    
    public String getFechaMov(){
        return fechaMov;
    }
    
    public void setNCuenta(String cta){
        this.nCuenta = cta;
    }
    
    public String getNCuenta (){
        return nCuenta;
    }
    
    public Conection cc = new Conection();
    
    public Movimientos verMovimientos (String nCuenta) {
        try{
            Statement s = cc.c.createStatement();            
            ResultSet rs = s.executeQuery("Select * From Movimientos Where NoCuenta = '" + nCuenta + "'");            
            if(rs.next())
                return new Movimientos(rs.getDouble("MONTO"), rs.getString("Tipo"), rs.getString("NoCuenta"), rs.getString("Fecha"));
        }catch(SQLException e){
            System.err.println("Problemas con la consulta " + e.getMessage());
        }
        
        return null;   

    }
        
}
