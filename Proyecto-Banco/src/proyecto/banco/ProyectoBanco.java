package proyecto.banco;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto.banco.Model.*;

public class ProyectoBanco {
Conection c = new Conection();
Cuenta cta = new Cuenta();
        CuentaHabiente ch = new CuentaHabiente();
        TDC tc = new TDC();
        TDD td = new TDD();
        Validación v = new Validación();
        Movimientos mov = new Movimientos();
        String cuenta;
        
    public static void main(String[] args) {
        ProyectoBanco b = new ProyectoBanco();
        b.show();
    
    }
    void show(){
        conectarTDC();
        conectarTDD();
        verificar();
        comparar();
    }
    
    void conectarTDC(){
        v.cc.conectar();
        tc.cc.conectar();
        mov.cc.conectar();
    }
    
    void conectarTDD(){
        v.cc.conectar();
        td.cc.conectar();
        mov.cc.conectar();
    }
    
    void verificar(){
        System.out.println("Ingrese su numero de Cuenta");
        cuenta = new java.util.Scanner(System.in).next();
        
        System.out.println("Ingrese su NIP");
        int nip = new java.util.Scanner(System.in).nextInt();
        
        if (v.verifyAccount(cuenta, nip) == true){
            comparar();
        }
    }
    
    void comparar(){
        if (tc.verificarTarjeta(cuenta) == true){
            conectarTDC();
            procesoTDC();
        }
        else if (td.verificarTarjeta(cuenta) == true){
            conectarTDD();
            procesoTDD();
        }
        else{
            System.out.println("No coincide la tarjeta");
        }   
    }
    
    void procesoTDC(){
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
        
                            l = mov.verMov("" + cuenta);
                            for (int i=0; i<l.size(); i ++)                          
                            System.out.println(l.get(i));
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
                        tc.depositar(jcantd, cuenta);}
                        cta.depósito(cantd);
                    } catch (OperaciónErronea ex) {
                        Logger.getLogger(ProyectoBanco.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                    case 4:
                        desconectarTDC();
                        System.out.println("Regrese pronto.");
                    break;
                    default: System.out.println("\"Operacion Erronea\"");
                } while(m = 4);
    }
    
    void procesoTDD(){
        System.out.println("Elija que movimiento desea realizar  \n1.-Consulta \n2.-Retiro \n3.-Deposito \n4.-Cerrar sesión");
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
                            l = mov.verMov("" + cuenta);
                            for (int i=0; i<l.size(); i ++)                          
                            System.out.println(l.get(i));
                           
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
                    case 4:
                        desconectarTDD();
                        System.out.println("Regrese pronto.");
                    break;
                    default: System.out.println("Operación errónea.");
                } while(m = 4);
    }

    void desconectarTDC(){
        v.cc.desconectar();
        tc.cc.desconectar();
        mov.cc.desconectar();
    }
    
    void desconectarTDD(){
        v.cc.desconectar();
        td.cc.desconectar();
        mov.cc.desconectar();
    }
}


