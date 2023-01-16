package com.mycompany.ejercicio05final;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        List<Integer> listado = new ArrayList<>();
        List<Integer> listado_2 = new ArrayList<>();

        ArrayList<Integer> lista = new ArrayList<>(Arrays.asList(31, 35, 32, 37, 39, 36, 33));

        Nodo nodo = new Nodo(lista);
        
        nodo.start();
        try {
            nodo.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(nodo.lista);
    }
}
