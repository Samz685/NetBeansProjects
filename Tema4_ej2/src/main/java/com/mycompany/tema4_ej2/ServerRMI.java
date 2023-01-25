package com.mycompany.tema4_ej2;

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
    public Double librasEuros(Double n1) throws RemoteException {
        
        Double resultado = n1*1.14;
        return resultado;
    }
    
    @Override
    public Double eurosLibras(Double n1) throws RemoteException {
        
        Double resultado = n1*0.88;
        return resultado;
    }
    
    @Override
    public Double dolaresEuros(Double n1) throws RemoteException {
        
        Double resultado = n1*0.92;
        return resultado;
    }
    
    @Override
    public Double eurosDolares(Double n1) throws RemoteException {
        
        Double resultado = n1*1.09;
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
