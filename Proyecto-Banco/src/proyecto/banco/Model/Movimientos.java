
package proyecto.banco.Model;

import java.sql.Date;

public class Movimientos extends Exception{
    private double cantidad;
    private String tipoMov;
    private Date fechaMov;
    private double saldo;
    
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
    
    public void setFechaMov(Date fM){
        this.fechaMov = fM;
    }
    
    public Date getFechaMov(){
        return fechaMov;
    }
    
    public void setSaldo(double s){
        this.saldo = s;
    }
    
    public double getSaldo(){
        return saldo;
    }
        
}
