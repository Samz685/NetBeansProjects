
import java.util.ArrayList;
import java.util.Scanner;


public class Primos2 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce el PRIMER número");
        int num1 = sc.nextInt();
        System.out.println("Introduce el SEGUNDO número");
        int num2 = sc.nextInt();
        
        ArrayList<Integer> primos = new ArrayList<>();
        
        for (int i = num1 ; i <= num2 ; i++){
            
            if(esPrimo(i)){
                System.out.println("El numero " +i+ " es primo");
                primos.add(i);
            }
            
        }
        System.out.println(primos);
        
    }
    
    public static boolean esPrimo(int num1){
        
        boolean esPrimo = true;
      
       
        int divisor = num1/2;
        while (esPrimo && divisor > 1){
            int resto = num1%divisor;
            if (resto == 0){
                esPrimo = false;
            }divisor--;
        }
        
        /*if (esPrimo){
            System.out.println("Es primo");
        }else{
            System.out.println("No es primo");
        }*/
        
        return esPrimo;
    }
}
