package com.mycompany.ejercicio05;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Hebra extends Thread {

    private Nodo nodo;
    

    public Hebra(Nodo nodo) {
        this.nodo = nodo;

    }

    public Nodo getNodo() {
        return nodo;
    }

    public void setNodo(Nodo nodo) {
        this.nodo = nodo;
    }
    

   

    

    @Override
    public void run() {
        
        }

    }
