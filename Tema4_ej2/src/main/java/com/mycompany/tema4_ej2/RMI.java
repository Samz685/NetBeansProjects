package com.mycompany.tema4_ej2;


import java.lang.reflect.Array;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMI extends Remote{
    public Double librasEuros(Double n1) throws RemoteException;
    public Double eurosLibras(Double n1) throws RemoteException;
    public Double dolaresEuros(Double n1) throws RemoteException;
    public Double eurosDolares(Double n1) throws RemoteException;
}
