package proyecto.banco.Test;

import java.util.ArrayList;
import proyecto.banco.Model.Movimientos;

public class TestMovimientos {

    public static void main(String[] args) {
        Movimientos tm = new Movimientos();
        
        ArrayList<String> l = new ArrayList();
        
        tm.cc.conectar();
        l = tm.verMov("1234567890123456");
        for (int i=0; i<l.size(); i ++)                          
                System.out.println(l.get(i));
            tm.cc.desconectar();
        
    }
    
}
