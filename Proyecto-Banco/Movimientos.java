
package proyecto.banco.Model;

public class Movimientos extends Exception{
    private int cantidad;
    private String tipoMov;
    private String fechaMov;
    private long saldo;
    private long retiro;
    private long depósito;
    
    public void setCantidad(int c){
        this.cantidad = c;
    }
    
    public int getCantidad(){
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
    
    public void setSaldo(long s){
        this.saldo = s;
    }
    
    public long getSaldo(){
        return saldo;
    }
    
    public void setRetiro(long r){
        this.retiro = r;
    }
    
    public long getRetiro(){
        return retiro;
    }
    
    public void setDepósito(long d){
        this.depósito = d;
    }
    
    public long getDepósito(){
        if(depósito <= 0){
            
        } else{
            
        }
            return depósito;
    }
}
