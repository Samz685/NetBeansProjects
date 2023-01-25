package com.mycompany.tema4_ej1;

import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServerRMI extends UnicastRemoteObject implements RMI{

    public ServerRMI() throws RemoteException{
        super();
    }

    @Override
    public int sumar(int n1, int n2) throws RemoteException {
        return n1+n2;
    }
    @Override
    public int restar(int n1, int n2) throws RemoteException {
        return n1-n2;
    }
    @Override
    public int multiplicar(int n1, int n2) throws RemoteException {
        return n1*n2;
    }
    @Override
    public int dividir(int n1, int n2) throws RemoteException {
        return n1/n2;
    }
    @Override
    public Double porcentaje(Double n1, Double n2) throws RemoteException {
        return (n1*n2)/100;
    }
    @Override
    public int resto(int n1, int n2) throws RemoteException {
        return n1%n2;
    }
    @Override
    public int media(int n1, int n2, int n3, int n4) throws RemoteException {
    
        int[] array = {n1, n2, n3, n4};
        int suma = 0;
        int totalItems = 0;
        int resultado = 0;
        for(int i : array){
            
            suma += i;
            totalItems++;
        }
        resultado = suma/totalItems;
        
        return resultado;
    }
    
    public static void main(String[] args){
        try{
            Registry registro=LocateRegistry.createRegistry(7777);
            registro.rebind("RemotoRMI", new ServerRMI());
            System.out.println("Servidor activo");
        } catch (RemoteException e){
            System.out.println(e.getMessage());
        }
    }
    
}
