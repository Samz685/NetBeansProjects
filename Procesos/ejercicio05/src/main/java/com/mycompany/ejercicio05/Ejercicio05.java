
package com.mycompany.ejercicio05;

import java.util.ArrayList;
import java.lang.Integer;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Ejercicio05 {

    public static void main(String[] args) {
        
        
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(10);
        lista.add(20);
        lista.add(30);
        lista.add(40);
        
        System.out.println(lista);
        System.out.println("-----------------");
        
        ArrayList<Integer> lista2 = new ArrayList<>();
        lista2.add(100);
        lista2.add(200);
        lista2.add(300);
        lista2.add(400);
        lista2.add(500);
        lista2.add(600);
        
        System.out.println(lista2);
        System.out.println("-----------------");
        
        
    
        Nodo nodo = new Nodo(lista);
        System.out.println(nodo.toString());
        System.out.println("-----------------");
        
        nodo.añade(lista2, 0, 4);
        System.out.println(nodo.toString());
        System.out.println("-----------------");
        
      
        
       
        
    }
}
