package proyecto.banco.Test;

import proyecto.banco.Model.Conection;

public class TestConection {
    public static void main(String[] args) {
        Conection conect = new Conection ();
        
        conect.conectar();
        conect.verifyAccount("1234567890123456", 1234);
        conect.desconectar();
    }
}
