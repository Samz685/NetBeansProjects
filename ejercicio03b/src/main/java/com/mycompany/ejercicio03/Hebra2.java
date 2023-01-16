
package com.mycompany.ejercicio03;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Hebra2 extends Thread {
    
    private VariableCompartida vc;

    private AtomicInteger semaforo;

    public Hebra2(VariableCompartida vc, AtomicInteger semaforo) {
        this.vc=vc;
        this.semaforo=semaforo;
    }

    @Override
    public void run() {
        
        Boolean activo = true;
        int cont = 0;
        while(activo){
            if(semaforo.get()==0){
                if(cont == 99){
                    activo = false;
                }
                System.out.println(vc.getValor());
                cont++;
                semaforo.set(1);
            }
    }
   
}
}
