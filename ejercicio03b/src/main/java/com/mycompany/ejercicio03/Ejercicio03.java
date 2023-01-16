
package com.mycompany.ejercicio03;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Ejercicio03 {

    
    public static void main(String[] args) {                                    //Al ejecutar el Principal:
                                                                                //Por un lado la Hebra1 uno recorre el for
                                                                                //Por otro la Hebra2 recoge los valores, pero como el for se recorre
        VariableCompartida v1 = new VariableCompartida();                       //tan rapido que cuando Hebra2 hace el "get" recoge el ultimo valor
        AtomicInteger num = new AtomicInteger();                                //del for de Hebra1
        Hebra h1 = new Hebra(v1,num);
        Hebra2 h2 = new Hebra2(v1,num);
        
        h1.start();
        h2.start();
        
        
       
        
          
        System.out.println("El proceso ha concluido!");
    }
    
}
