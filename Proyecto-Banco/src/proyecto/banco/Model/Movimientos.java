package proyecto.banco.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    
    public Movimientos (){
        
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
        
    public ArrayList<String> verMov( String nCuenta){
        ArrayList <String> lista = new ArrayList();
        try{
            String sql = "Select * from Movimientos Where NoCuenta = '" + nCuenta + "'";
            ResultSet rs;
            try (Statement st = cc.c.createStatement()) {
                rs = st.executeQuery(sql);
                while (rs.next()){
                    lista.add(rs.getDouble("Monto")   + "," +
                            rs.getString("Tipo")    + "," +
                            rs.getString("NoCuenta") + ","+
                            rs.getString("Fecha"));
                }
            }
             rs.close();
             return lista;
             
        }catch (SQLException ex){
            System.err.println("Fallo" + ex.getMessage());
            return null;
        }
    }
    
}