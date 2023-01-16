
package com.mycompany.ejercicio02;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Ejercicio02 {

  
    public static void main(String[] args) {
       
        VariableCompartida v1 = new VariableCompartida();
        Hebra h1 = new Hebra(v1);
        Hebra h2 = new Hebra(v1);
        
        h1.start();
        h2.start();
        try {
            h1.join();
            h2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Ejercicio02.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        System.out.println(v1.getValor());
        
        
        
      
    }
    
}
