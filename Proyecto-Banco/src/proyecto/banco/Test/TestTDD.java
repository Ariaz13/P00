package proyecto.banco.Test;

import proyecto.banco.Model.TDD;

public class TestTDD {

    public static void main(String[] args) {
        TDD td = new TDD();
        
        System.out.println("Elegir que hacer: 1.-Consultar 2.-Retirar 3.-Depositar");
        
        int r = new java.util.Scanner(System.in).nextInt();
        
        switch (r){
            case 1: 
                td.consultar();
            break;
            case 2:
                td.retirar(300);
            break;
            case 3:
                td.depositar(400);
            break;
        }
        
    }
    
}
