package com.mycompany.examenejercicio3;

import java.util.ArrayList;

public class ExamenEjercicio3 {
    
    public static void main(String[] args) {
        
		ArrayList<Integer> lista = new ArrayList();
                
		double valor=Math.random()*100;
		int total = (int) valor;
		for (int i=0;i<total;i+=2){
			double num = Math.random()*100;
			int numero=(int) num;
                        //añadimos solo los números que son pares a la lista
                        if(numero%2==0){
                            lista.add(numero);
                        }
			
		}
		System.out.println("Array generado de forma aleatoria: "+lista);
		Nodo n1 = new Nodo(lista);
		n1.start();
		try {
			n1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Array de números pares ordenado de menor a mayor: "+n1.lista);
	}
}