package proyecto.banco;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto.banco.Model.*;
import proyecto.banco.Test.TestMovimientos;

public class ProyectoBanco {

    public static void main(String[] args) {
        Cuenta cta = new Cuenta();
        Conection c = new Conection(); 
        CuentaHabiente ch = new CuentaHabiente();
        TDC tc = new TDC();
        TDD td = new TDD();
        Validación v = new Validación();
        Movimientos mov = new Movimientos();
        
        System.out.println("Ingrese su numero de Cuenta");
        String cuenta = new java.util.Scanner(System.in).next();
        
        System.out.println("Ingrese su NIP");
        int nip = new java.util.Scanner(System.in).nextInt();
        
        v.cc.conectar();
        if (v.verifyAccount(cuenta, nip) == true){
            tc.cc.conectar();
            if (tc.verificarTarjeta(cuenta) == true){
                
                System.out.println("Elija que movimiento desea realizar  \n1.-Consulta \n2.-Retiro \n3.-Deposito");
                int m = new java.util.Scanner(System.in).nextInt();
                switch (m){
                    case 1:
                        System.out.println("Que desea consultar: \n1.-Saldo \n2.-Movimientos");
                        int con = new java.util.Scanner(System.in).nextInt();
                        if (con == 1){
                            Cuenta c1 = tc.consultar("" + cuenta); 
                            System.out.println(c1.getSaldo());
                        }else{
                           ArrayList<String> l = new ArrayList();
        
                            mov.cc.conectar();
                            l = mov.verMov("" + cuenta);
                            for (int i=0; i<l.size(); i ++)                          
                            System.out.println(l.get(i));
                            mov.cc.desconectar(); 
                            //System.exit(0);
                           
                        }
                    break;
                    case 2:
                        System.out.println("Ingrese la cantidad");
                        double cant = new java.util.Scanner(System.in).nextInt();
                        tc.retirar(cant, cuenta);              
                        
                    break;
                    case 3:
                                
                    try {
                        System.out.println("Ingrese la cantidad");
                        double cantd = new java.util.Scanner(System.in).nextInt();
                        if (cantd >= 0){
                        tc.depositar(cantd, cuenta);}
                        cta.depósito(cantd);
                    } catch (OperaciónErronea ex) {
                        Logger.getLogger(ProyectoBanco.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                    break;
                    default: System.out.println("\"Operacion Erronea\"");
                        
                }
                
            }tc.cc.desconectar();
            
            td.cc.conectar();
            if (td.verificarTarjeta(cuenta) == true){
                
                System.out.println("Elija que movimiento desea realizar  \n1.-Consulta \n2.-Retiro \n3.-Deposito");
                int m = new java.util.Scanner(System.in).nextInt();
                switch (m){
                    case 1:
                        System.out.println("Que desea consultar: \n1.-Saldo \n2.-Movimientos");
                        int con = new java.util.Scanner(System.in).nextInt();
                        if (con == 1){
                            Cuenta c1 = td.consultar("" + cuenta); 
                            System.out.println(c1.getSaldo());
                        }else{
                           ArrayList<String> l = new ArrayList();
        
                            mov.cc.conectar();
                            l = mov.verMov("" + cuenta);
                            for (int i=0; i<l.size(); i ++)                          
                            System.out.println(l.get(i));
                            mov.cc.desconectar(); 
                           
                        }
                    break;
                    case 2:
                        System.out.println("Ingrese la cantidad");
                        double cant = new java.util.Scanner(System.in).nextInt();
                        td.retirar(cant, cuenta);              
                        
                    break;
                    case 3:
                                
                    try {
                        System.out.println("Ingrese la cantidad");
                        double cantd = new java.util.Scanner(System.in).nextInt();
                        if (cantd >= 0){
                        td.depositar(cantd, cuenta);}
                        cta.depósito(cantd);
                    } catch (OperaciónErronea ex) {
                        Logger.getLogger(ProyectoBanco.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                    break;
                    default: System.out.println("\"Operacion Erronea\"");
                        
                }
                
            }td.cc.desconectar();
            
        }    
    }
  }


