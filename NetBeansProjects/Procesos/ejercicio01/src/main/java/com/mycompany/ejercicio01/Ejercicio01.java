
package com.mycompany.ejercicio01;


public class Ejercicio01 {

   
    public static void main(String[] args) {
       
        
        Hebra h1 = new Hebra(2,"Hola Mundo 1");           //Creamos los objetos apartir de Hilo, cada uno con mensj diferente
        Hebra h2 = new Hebra(2,"Hola Mundo 2");           
        Hebra h3 = new Hebra(2,"Hola Mundo 3");
        
        h3.start();                                              //Iniciamos cada uno de los hilos
        h1.start();
        h2.start();
        
        System.out.println("El main ha finalizado");           //El resultado: se imprime en primer lugar el syso porque requiere de menos calculo
    }                                                            //Las letras se mezclan una vez que se le añade un sleep al thread original
    
}
