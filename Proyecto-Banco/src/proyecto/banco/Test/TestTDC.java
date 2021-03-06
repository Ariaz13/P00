package proyecto.banco.Test;

import proyecto.banco.Model.Cuenta;
import proyecto.banco.Model.TDC;

public class TestTDC {
    public static void main(String[] args) {
        TDC tc = new TDC();
        Cuenta cta = new Cuenta();
                        
        System.out.println("Elegir que hacer: 1.-Consultar 2.-Retirar 3.-Depositar");
        
        int r = new java.util.Scanner(System.in).nextInt();
        
        switch (r){
            case 1: 
                tc.cc.conectar();
                tc.verificarTarjeta("1234567890123456");
                Cuenta cuenta = tc.consultar("1234567890123456"); 
                System.out.println(cuenta.getSaldo());
            break;
            
            case 2:
                tc.cc.conectar();
                tc.retirar(300,"1234567890123456");
                tc.cc.desconectar();
            break;
            
            case 3:
                tc.cc.conectar();
                tc.depositar(400, "1234567890123456");
                tc.cc.desconectar();
            break;
        }
    }
}