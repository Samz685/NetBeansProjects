
package com.mycompany.ejercicio02;


public class Hebra extends Thread{
    
    
    private VariableCompartida vc;

    public Hebra(VariableCompartida vc) {
        this.vc = vc;
    }

    @Override
    public void run() {
        
        for(int i = 0; i< 10 ; i++){
            vc.inc();
        }
       
    }
    
    
}
