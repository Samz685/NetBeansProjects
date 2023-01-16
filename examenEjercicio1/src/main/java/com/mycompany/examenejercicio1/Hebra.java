
package com.mycompany.examenejercicio1;

import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Hebra  extends Thread {
    
    
    private final int metrosRecorrido = 10;
    private String animal;
    private int metrosConejo = 0;
    private int metrosTortuga = 0;
    
    
    
    public Hebra(String animal) {
        this.animal=animal;
           
    }

    public void carreraConejo() {

        for (int i = 0; i <= metrosRecorrido; i++) {
            
            System.out.println("Conejo: " + metrosConejo);
            metrosConejo += 1;
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hebra.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void carreraTortuga() {

        for (int i = 0; i <= metrosRecorrido; i++) {
            
            System.out.println("Tortuga: " + metrosTortuga);
            metrosTortuga += 1;
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hebra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   

    }

    @Override
    public void run() {

        if ("Conejo".equalsIgnoreCase(animal)) {

            carreraConejo();

        } else if ("Tortuga".equalsIgnoreCase(animal)) {

            carreraTortuga();

        }

    }
}
