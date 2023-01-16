
package com.mycompany.ejemplosvarios;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
/**
 *
 * @author MichanGalvanJamai
 */
public class Principal {

    public static Boolean esPrimo(Integer num){
            
        for (Integer i = 2 ; i <= num ; i++) {
            if(num%i==0) return false;
        }
        return true;
        }
   
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Número Inicial");
        Integer inicial = sc.nextInt();
        System.out.println("Número Fin");
        Integer fin = sc.nextInt();
        ArrayList<Integer> numeros2 = new ArrayList<Integer>();
        HashSet<Integer> numeros = new HashSet<Integer>(); 
        
        for(Integer i = inicial ; i <= fin ; i++){
            numeros.add(i);
            numeros2.add(i);
            
        }
        try{
          
            numeros2.addAll(numeros);
        
        }
        catch(Exception ex){
            System.out.println("Error al modificar la lista");
            System.out.println(ex);
            System.out.println(ex.getStackTrace());
        }
        System.out.println(numeros2);
        System.out.println(numeros2.size());
        
        
                
    }
    
}
