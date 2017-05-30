/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.banco.Test;

import proyecto.banco.Model.Conection;

/**
 *
 * @author Zaira1
 */
public class TestConection {
    public static void main(String[] args) {
        Conection conect = new Conection ();
        
        conect.conectar();
        conect.verifyAccount("1234567890123456", 1234);
        conect.desconectar();
    }
}
