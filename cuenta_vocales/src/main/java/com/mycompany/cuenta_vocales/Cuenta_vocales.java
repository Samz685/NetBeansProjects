
package com.mycompany.cuenta_vocales;

import java.util.Scanner;

public class Cuenta_vocales {

    public static void main(String[] args) {
        
        String vocales;
        String nueva = "";
        int aC = 0;
        int eC = 0;
        int iC = 0;
        int oC = 0;
        int uC = 0;
        
        
        System.out.println("Introduce una palabra: ");
        Scanner sc = new Scanner(System.in);
        
        String word = sc.nextLine();
        
        for (int i = 0; i < word.length(); i++) {
            
            char a = word.charAt(i);
            
           if(a == 'a'){
               aC = +1;   
           } else if((a == 'e'){
               
               
           }
           
           
           
           
            
        }
        System.out.println(nueva);
        
    }
}
