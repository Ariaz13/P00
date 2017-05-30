package proyecto.banco.Model;

public class CuentaHabiente extends Cuenta {
    private int nip;
    
    public CuentaHabiente(int nip,String nCuenta) {
        super(nCuenta);
        this.nip = nip;
        
               
    }
    
    public CuentaHabiente(){
        
    }
    
    public int getNip(){
        return this.nip;
    }
    
    
}
