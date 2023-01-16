package com.mycompany.ejercicio05final;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Nodo extends Thread {

    public static List<Integer> lista;

    public Nodo(List<Integer> lista) {
        this.lista = lista;
    }

    // Añade a la lista [desde,hasta)
    static void añade(List<Integer> listado, Integer desde, Integer hasta) {
        Integer cont = 0;

        for (Integer i = 0; i < lista.size(); i++) {
            if (i >= desde && i < hasta) {
                lista.add(i, listado.get(cont));
                cont++;
            }
        }
    }

    static void mezcla(List<Integer> lista, List<Integer> lista_2) {
        ArrayList<Integer> lista_temp = new ArrayList<>();
        Nodo n_1 = new Nodo(lista);
        Nodo n_2 = new Nodo((lista_2));

        // Ordenamos las listas
        try {
            n_1.start();
            n_2.start();
            n_1.join();
            n_2.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Integer max_size = null;

        if (lista.size() >= lista_2.size()) {
            max_size = lista.size();
        } else {
            max_size = lista_2.size();
        }

        for (Integer i = 0; i < max_size; i++) {
            if (n_1.getLista().get(i) != null && n_2.getLista().get(i) != null) {

            } else if (n_1.getLista().get(i) == null && n_2.getLista().get(i) != null) {

            } else if (n_1.getLista().get(i) != null && n_2.getLista().get(i) == null) {

            }
        }

    }

    public void run() {

    }

    public static List<Integer> getLista() {
        return lista;
    }

    @Override
    public String toString() {
        AtomicReference<String> tense = new AtomicReference<>("");
        lista.forEach(k -> {
            tense.set(tense.get() + k + " ");
        });
        return tense.get();
    }

}
