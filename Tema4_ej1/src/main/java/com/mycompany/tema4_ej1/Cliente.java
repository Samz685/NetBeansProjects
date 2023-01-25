package com.mycompany.tema4_ej1;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args){
        Cliente cliente=new Cliente();
        cliente.connectServer();
    }
    
    private void connectServer(){
        try{
            Registry registro=LocateRegistry.getRegistry("127.0.0.1",7777);
            RMI interfaz=(RMI)registro.lookup("RemotoRMI");
            int suma=interfaz.sumar(10,2);
            System.out.println("La suma de 10 + 2 es "+suma);
            
            int resta=interfaz.restar(10,2);
            System.out.println("La resta entre 10 y 2 es "+resta);
            
            int multiplicacion=interfaz.multiplicar(10,2);
            System.out.println("La multiplicacion entre 10 y 2 es "+multiplicacion);
            
            int division=interfaz.dividir(10,2);
            System.out.println("La division entre 10 y 2 es "+division);
            
            Double porcentaje=interfaz.porcentaje(10.0,2.0);
            System.out.println("El 10% de 2 es "+porcentaje);
            
            int resto=interfaz.resto(10,2);
            System.out.println("El resto de la division entre 10 y 2 es "+resto);
            
            int media=interfaz.media(5, 10, 15, 25);
            System.out.println("La media de los numeros (5,10,15,25) es "+media);
            
            
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
