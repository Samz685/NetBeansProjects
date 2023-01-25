package com.mycompany.tema4_ej1;


import java.lang.reflect.Array;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMI extends Remote{
    public int sumar(int n1, int n2) throws RemoteException;
    public int restar(int n1, int n2) throws RemoteException;
    public int multiplicar(int n1, int n2) throws RemoteException;
    public int dividir(int n1, int n2) throws RemoteException;
    public Double porcentaje(Double n1, Double n2) throws RemoteException;
    public int resto(int n1, int n2) throws RemoteException;
    public int media(int n1, int n2, int n3, int n4) throws RemoteException;
}
