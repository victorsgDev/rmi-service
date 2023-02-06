package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class Servidor {
    public static void main(String[] args) {
        String host;
        int puerto = 5055;
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            System.out.println("No se ha podido obtener la dirección IP");
            System.out.println(e.getMessage());
            return;
        }

        try {
            Registry registry = LocateRegistry.createRegistry(puerto);
            JugadorRMI plantilla = new JugadorRMI();
            almacenar(plantilla.jugadores);
            registry.rebind("miPlantilla", plantilla);
            System.out.println("Servicio registrado en host " + host + " y puerto " + puerto);
        } catch (RemoteException e) {
            System.out.println("No se ha podido registrar el servicio");
            System.out.println(e.getMessage());
        }

    }

    private static void almacenar(ArrayList<Jugador> jugadores) {
        //Abrir fichero para escritura
        FileOutputStream file;
        ObjectOutputStream buffer;
        try {
            file = new FileOutputStream("src/main/resources/jugadores.dat");
            buffer = new ObjectOutputStream(file);
        } catch (IOException e) {
            System.out.println("Imposible acceder al archivo jugadores.dat");
            System.out.println(e.getMessage());
            return;
        }

        //Guarda objeto en el fichero
        try {
            buffer.writeObject(jugadores);
            System.out.println("Jugadores almacenados con éxito");
        } catch (IOException e) {
            System.out.println("Imposible almacenar el objeto");
            System.out.println(e.getMessage());
        }
        //Cerrar el fichero
        try {
            buffer.close();
            file.close();
        } catch (IOException e) {
            System.out.println("Imposible cerrar el fichero jugadores.dat");
            System.out.println(e.getMessage());
        }
    }
}