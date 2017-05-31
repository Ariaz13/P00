package proyecto.banco.Test;

import proyecto.banco.Model.TDD;

public class TestTDD {

    public static void main(String[] args) {
        TDD td = new TDD();
                        
        System.out.println("Elegir que hacer: 1.-Consultar 2.-Retirar 3.-Depositar");
        
        int r = new java.util.Scanner(System.in).nextInt();
        
        switch (r){
            case 1: 
                td.cc.conectar();
                td.verificarTarjeta("9876543210987654");
                td.consultar("9876543210987654");
            break;
            
            case 2:
                td.cc.conectar();
                td.verificarTarjeta("9876543210987654");
                td.retirar(300,"9876543210987654");
                td.cc.desconectar();
            break;
            
            case 3:
                td.cc.conectar();
                td.verificarTarjeta("9876543210987654");
                td.depositar(400, "9876543210987654");
                td.cc.desconectar();
            break;
        }
    }
    
}
