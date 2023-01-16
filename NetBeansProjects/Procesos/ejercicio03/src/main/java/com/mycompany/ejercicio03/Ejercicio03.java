
package com.mycompany.ejercicio03;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Ejercicio03 {

    
    public static void main(String[] args) {
 
        
        VariableCompartida v1 = new VariableCompartida();
        AtomicInteger num = new AtomicInteger();
        Hebra h1 = new Hebra(v1,num);
        Hebra2 h2 = new Hebra2(v1,num);
        
        h1.start();
        h2.start();
        
        
       
        
          
        System.out.println("El proceso ha concluido!");
    }
    
}
