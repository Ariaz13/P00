
package proyecto.banco.Model;

import java.awt.Image;

public abstract class Tarjeta {
    
    private long noCuenta;
    Image foto;
    private float saldo;

    public void setNoCuenta(long noCuenta) {
        this.noCuenta = noCuenta;
    }

    public long getNoCuenta() {
        return noCuenta;
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

    
    public Tarjeta(long noCuenta, Image foto, float saldo) {
        this.noCuenta = noCuenta;
        this.foto = foto;
        this.saldo = saldo;
    }
    
    abstract void consultar();
    
    abstract void depositar();
    
    abstract void retirar();
    
    
}
