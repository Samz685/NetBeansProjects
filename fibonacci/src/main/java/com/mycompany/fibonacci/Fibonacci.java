

package com.mycompany.fibonacci;

import java.util.Scanner;


public class Fibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //linea para crear scanner en el teclado
		System.out.println("Qué número de la serie Fibonacci quieres?");
		int numero = sc.nextInt();
		
		if (numero<3)	{
			System.out.print("El número en la posición "+numero+" es el 1.");
			
		} else {
				int fib1 = 1;
				int fib2 = 1;
				System.out.print("1");
			for(int i=3;i<=numero;i++)	{
				int fib3 = fib1 + fib2;
				System.out.print(" "+fib3);
				fib1 = fib2;
				fib2 = fib3;
				
			}
		}
    }
}

