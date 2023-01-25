package com.mycompany.tema4_ej2;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.DecimalFormat;

public class Cliente {
    public static void main(String[] args){
        Cliente cliente=new Cliente();
        cliente.connectServer();
    }
    
    private void connectServer(){
        try{
            Registry registro=LocateRegistry.getRegistry("127.0.0.1",7777);
            RMI interfaz=(RMI)registro.lookup("RemotoRMI");
            
            DecimalFormat df = new DecimalFormat("#.00");
            
            Double resultado1=interfaz.librasEuros(10.0);
            System.out.println("10 libras son "+df.format(resultado1)+" euros");
            
            Double resultado2=interfaz.eurosLibras(10.0);
            System.out.println("10 euros son "+df.format(resultado2)+" libras");
            
            Double resultado3=interfaz.dolaresEuros(10.0);
            System.out.println("10 dolares son "+df.format(resultado3)+" euros");
            
            Double resultado4=interfaz.eurosDolares(10.0);
            System.out.println("10 euros valen "+df.format(resultado4)+" dolares");
            
            
            
            
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
