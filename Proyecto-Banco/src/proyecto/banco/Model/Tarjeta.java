
package U.ProyectoBanco.Model;

import java.awt.Image;

public abstract class Tarjeta {
    
    private long noCuenta;
    private String fechaApertura;
    private String fechaVencimiento;
    Image foto;
    private float saldo;

    public void setNoCuenta(long noCuenta) {
        this.noCuenta = noCuenta;
    }

    public long getNoCuenta() {
        return noCuenta;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public Image getFoto() {
        return foto;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getSaldo() {
        return saldo;
    }

    public Tarjeta(){
        
    }
    
    public Tarjeta(long noCuenta, String fechaApertura, String fechaVencimiento, Image foto, float saldo) {
        this.noCuenta = noCuenta;
        this.fechaApertura = fechaApertura;
        this.fechaVencimiento = fechaVencimiento;
        this.foto = foto;
        this.saldo = saldo;
    }
    
    abstract void consultar();
    
    abstract void depositar();
    
    abstract void retirar();
    
    abstract void transferir();
    
}
