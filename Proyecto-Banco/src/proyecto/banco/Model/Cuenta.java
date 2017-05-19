
package U.ProyectoBanco.Model;

public class Cuenta {

    private String nombre;
    private long noCuenta;
    private String fechaApertura;
    private String fechaVencimiento;
    private float saldo;
    private String tipo;

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    
    public void setNoCuenta(long noCuenta){
        this.noCuenta = noCuenta;
        // contar número de dígitos introducidos
    }
    public long getNoCuenta(){
        return noCuenta;
    }
    
    public void setFechaApertura(String fechaApertura){
        this.fechaApertura = fechaApertura;
    }
    public String getFechaApertura(){
        return fechaApertura;
    }
    
    public void setFechaVencimiento(String fechaVencimiento){
        this.fechaVencimiento = fechaVencimiento;
    }
    public String getFechaVencimiento(){
        return fechaVencimiento;
    }
    
    public void setSaldo(float dinero){
        
        this.saldo = saldo;
    }
    public float getSaldo(){
        return saldo;
    }
    
    public void setTipo(String tipo){
        if(saldo < 0){ // solo funciona si hay saldo deudor
            tipo = "Tarjeta de Crédito";
        } else{
            tipo = "Tarjeta de Débito";
        }
    }
    public String getTipo(){
        return tipo;
    }
    
    public void depósito(){
        // 1.Cheque 2.Efectivo 3.Transferencia bancaria
    }
    
    public void retiro(){
        // en TDD no aplica comisión
        
    }
    
    public void consulta(){
        // si es TDC genera comisión
        
    }
}
