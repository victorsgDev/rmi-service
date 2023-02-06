package org.example;

import java.io.Serial;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class JugadorRMI extends UnicastRemoteObject implements JugadorInterfaceRMI {
    @Serial
    private static final long serialVersionUID = -4817856459999901795L;
    public final ArrayList<Jugador> jugadores;

    public JugadorRMI() throws RemoteException {
        jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Jug1", "Mauro Arambarri", "Mediocentro", "Getafe CF", "18", "Uruguayo"));
        jugadores.add(new Jugador("Jug2", "David Soria", "Portero", "Getafe CF", "13", "Español"));
        jugadores.add(new Jugador("Jug3", "Enes Unal", "Delantero", "Getafe CF", "10", "Turco"));
        jugadores.add(new Jugador("Jug4", "Borja Mayoral", "Delantero", "Getafe CF", "9", "Español"));
        jugadores.add(new Jugador("Jug5", "Damian Suarez", "Lateral", "Getafe CF", "22", "Uruguayo"));
        jugadores.add(new Jugador("Jug6", "Dakonam Djene", "Defensa", "Getafe CF", "2", "Togolés"));
        jugadores.add(new Jugador("Jug7", "Domingos Duarte", "Defensa", "Getafe CF", "6", "Portugués"));
    }


    @Override
    public String buscarNombre(String nombre) throws RemoteException {
        return null;
    }

    @Override
    public String buscarPosicion(String posicion) throws RemoteException {
        return null;
    }

    @Override
    public String buscarClub(String club) throws RemoteException {
        return null;
    }

    @Override
    public String buscarDorsal(String dorsal) throws RemoteException {
        return null;
    }

    @Override
    public String buscarNacionalidad(String nacionalidad) throws RemoteException {
        return null;
    }
}

