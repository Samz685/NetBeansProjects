package com.joselara.tema02_ejercicio05;

import java.util.ArrayList;
import java.util.List;

public class Nodo extends Thread{
    	List<Integer> lista = new ArrayList<Integer>();

	public Nodo(List<Integer> lista) {
		this.lista = lista;
	}

	private void anade(List<Integer> l, int desde, int hasta) {
		l.addAll(lista.subList(desde, hasta));
	}

	private void mezcla(List<Integer> l1, List<Integer> l2) {
		Integer e1, e2;
		List<Integer> listaResultado = new ArrayList<Integer>();
		while ((l1.size() > 0) && (l2.size() > 0)) {
			e1 = l1.get(0);
			e2 = l2.get(0);
			if (e1 > e2) {
				listaResultado.add(e2);
				l2.remove(0);
			} else {
				listaResultado.add(e1);
				l1.remove(0);
			}
		}
		if (l1.size() == 0) {
			listaResultado.addAll(l2);
		} else if (l2.size() == 0) {
			listaResultado.addAll(l1);
		}
		this.lista = listaResultado;
	}

	public void run() {
		if (lista.size() > 1) {
			// Se divide la lista en dos
			float mitad = lista.size() / 2.0f;
			List<Integer> lista1 = new ArrayList<Integer>();
			List<Integer> lista2 = new ArrayList<Integer>();
			anade(lista1, 0, (int) mitad);
			anade(lista2, (int) mitad, lista.size());
			if (mitad > 1.0) {
				// Se crean dos nuevas hebras
				Nodo h1 = new Nodo(lista1);
				Nodo h2 = new Nodo(lista2);
				h1.start();
				h2.start();
				try {
					h1.join();
					h2.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mezcla(h1.lista, h2.lista);
			} else {
				mezcla(lista1, lista2);
			}
		}
	}
}
