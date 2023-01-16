package com.joselara.tema02_ejercicio05;

import java.util.ArrayList;
import java.util.List;

public class TestNodo {
    public static void main(String[] args) {
		List<Integer> lista = new ArrayList<Integer>();
		double valor=Math.random()*100;
		int total = (int) valor;
		for (int i=0;i<total;i+=2){
			double num = Math.random()*100;
			int numero=(int) num;
                        
                        if(numero%2==0){
                            lista.add(numero);
                        }
			
		}
		System.out.println(lista);
		Nodo n1 = new Nodo(lista);
		n1.start();
		try {
			n1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(n1.lista);
	}
}
