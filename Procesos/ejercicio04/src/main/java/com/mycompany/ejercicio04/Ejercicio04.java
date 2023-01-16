

package com.mycompany.ejercicio04;

import java.util.Scanner;


public class Ejercicio04 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduzca hasta que posición de fibonacci quiere llegar: ");
        int numero = sc.nextInt();
        
    
            
            Hebra h1 = new Hebra(numero);
            h1.start();
            while(h1.isAlive());
            System.out.println(h1.getfibAc());
        
           
           
           
           
           }
           
           
            
            
        
        
        
        
        
        
        
    }
