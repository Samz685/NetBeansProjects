

package com.mycompany.examenejercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;


public class ExamenEjercicio1 {

    public static void main(String[] args) {
        
       Hebra conejo = new Hebra("Conejo");
       Hebra tortuga = new Hebra("Tortuga");
       
       conejo.start();
       tortuga.start();
       
        /*
       Apartado B. Usamos el método joín para darle prioridad a tortuga,
       y y de esta manera conejo esperará a que termine tortuga su proceso
      tortuga.start();
      
        try {
            tortuga.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ExamenEjercicio1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conejo.start();
      
         */
    }

}
