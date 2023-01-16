
package com.mycompany.ejercicio05b;

import java.util.ArrayList;
import java.lang.Integer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio05b {

    public static void main(String[] args) {
        
        
        ArrayList<Integer> lista = new ArrayList<>(Arrays.asList(31,35,32,37,39,36,33));
        Nodo nodo = new Nodo(lista);
        
        nodo.start();
        
        try {
            nodo.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Ejercicio05b.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Esta es la lista ordenada: " + nodo.listaDes);
        System.out.println(lista.size());
       
    }
}
