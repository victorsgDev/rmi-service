package org.example;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface JugadorInterfaceRMI extends Remote {

    String buscarNombre(String nombre) throws RemoteException;
    String buscarPosicion(String posicion) throws RemoteException;
    String buscarClub(String club) throws RemoteException;
    String buscarDorsal(String dorsal) throws RemoteException;
    String buscarNacionalidad(String nacionalidad) throws RemoteException;

}
