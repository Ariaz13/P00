package proyecto.banco.Test;

import proyecto.banco.Model.Movimientos;

public class TestMovimientos {

    public static void main(String[] args) {
        Movimientos tm = new Movimientos();
        
        tm.cc.conectar();
        tm.verMovimientos("1234567890123456");
    }
    
}
