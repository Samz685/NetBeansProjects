package com.mycompany.ejercicio5multihilolorenlynch;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author LorenLynchMcrae
 */
public class Nodo extends Thread{
    
    ArrayList<Integer> listaDesordenada = new ArrayList();
    public Nodo(ArrayList<Integer> lista){
        this.listaDesordenada = lista;
    }
    
    
    
    public void anade(ArrayList<Integer> lista, int desde, int hasta){
        lista.addAll(listaDesordenada.subList(desde, hasta));
    }
    
    
    public void mezcla(ArrayList<Integer> lista1, ArrayList<Integer> lista2){
        
        ArrayList<Integer> resultado = new ArrayList();
        
        while(lista1.size() > 0 && lista2.size() > 0){
            
            if(lista1.get(0) < lista2.get(0)){
                
                resultado.add(lista1.get(0));
                lista1.remove(0);
                
            }else if(lista2.get(0) <= lista1.get(0)){
                
                resultado.add(lista2.get(0));
                lista2.remove(0);
            }
        }
        if(lista1.size() == 0){
            resultado.addAll(lista2);
        }else{
            resultado.addAll(lista1);
        }
        listaDesordenada = resultado;
    }
    @Override
    public void run(){
        
        if(listaDesordenada.size() > 1){
            
            float mitad = listaDesordenada.size()/2;
            ArrayList<Integer> mitadIzq = new ArrayList();
            ArrayList<Integer> mitadDcha = new ArrayList();
            anade(mitadIzq,0,(int) mitad);
            anade(mitadDcha,(int) mitad , listaDesordenada.size());
            
            if(mitad>1){
                
                Nodo nodoIzq = new Nodo(mitadIzq);
                Nodo nodoDcha = new Nodo(mitadDcha);
                nodoIzq.start();
                nodoDcha.start();
                
                try {
                    nodoIzq.join();
                    nodoDcha.join();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Nodo.class.getName()).log(Level.SEVERE, null, ex);
                }
                mezcla(nodoIzq.listaDesordenada, nodoDcha.listaDesordenada);
            }else{
                mezcla(mitadIzq, mitadDcha);
            }
        }
    }
}
tiene menú contextual
