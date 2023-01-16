
package com.mycompany.ejercicio01;

import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Hebra  extends Thread {
    
    private final int numero;
    private final String mensaje;
    
    
    public Hebra(int veces, String msg) {
        this.numero=veces;
        this.mensaje=msg;   
    }
    
    @Override
    public void run(){
        
        for(int i = 0 ; i <= numero ; i++){
            System.out.println(mensaje);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hebra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
        
    }
}
