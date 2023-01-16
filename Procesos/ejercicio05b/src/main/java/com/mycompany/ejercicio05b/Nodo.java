
package com.mycompany.ejercicio05b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Nodo extends Thread{
    
    List<Integer> listaDes = new ArrayList<>();
    
    public Nodo(ArrayList<Integer> lista){
    this.listaDes = lista;
    }
    
    
    public void añade(List<Integer> lista, int d, int h){
    
        lista.addAll(lista.subList(d, h));
        
        
    }
    
    public void mezcla(List<Integer> l1, List<Integer> l2){
        
        ArrayList<Integer> resultado = new ArrayList<>();
        
        while(l1.size() > 0 && l2.size() > 0){
            
            if(l1.get(0) < l2.get(0)){
                resultado.add(l1.get(0));
                l1.remove(0);
                
            }else if(l2.get(0) < l1.get(0)){
                resultado.add(l2.get(0));
                l2.remove(0);
            }
        }
        
        if(l1.isEmpty()){
            resultado.addAll(l2);
        }else{
            resultado.addAll(l1);
        }
        listaDes = resultado;
       
       }
        
        
    
    public void run(){
        

       if(listaDes.size() > 1){
           
          float mitad = listaDes.size()/2;
          
          ArrayList<Integer> mitad1 = new ArrayList();
          ArrayList<Integer> mitad2 = new ArrayList();
          
          añade(mitad1, 0, (int)mitad );
          añade(mitad2, (int)mitad, listaDes.size());
          
           if (mitad > 1) {
               
               Nodo nodoUno = new Nodo(mitad1);
               Nodo nodoDos = new Nodo(mitad2);
               
               nodoUno.start();
               nodoDos.start();
               
              try {
                  nodoUno.join();
                  nodoDos.join();
              } catch (InterruptedException ex) {
                  Logger.getLogger(Nodo.class.getName()).log(Level.SEVERE, null, ex);
              }
               
               mezcla(nodoUno.listaDes, nodoDos.listaDes);
               
               
           }else
               mezcla(mitad1, mitad2);
           
         
       }
    }
}

    

