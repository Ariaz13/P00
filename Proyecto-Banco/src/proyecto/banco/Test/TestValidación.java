package proyecto.banco.Test;

import proyecto.banco.Model.Validación;

public class TestValidación {

    public static void main(String[] args) {
        Validación v = new Validación();
        v.cc.conectar();
        v.verifyAccount("1234567890123456", 1234);
    }
    
    
}
