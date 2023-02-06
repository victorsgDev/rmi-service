package org.example;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Registry registry;
        Scanner lector = new Scanner(System.in);
        try {
            registry = LocateRegistry.getRegistry("127.0.0.1", 5055);
            System.out.println("Hemos obtenido el registro");
            JugadorInterfaceRMI plantilla = (JugadorInterfaceRMI) registry.lookup("miPlantilla");
            System.out.println("Hemos obtenido el objeto remoto");
            System.out.println();
            String buscado;
            String opcion;
            do {
                escribirMenu();
                opcion = lector.nextLine().toUpperCase();
                switch (opcion) {
                    case "1":
                        System.out.println("Escribe nombre del jugador: ");
                        buscado = lector.nextLine();
                        System.out.println(plantilla.buscarNombre(buscado));
                        break;
                    case "2":
                        System.out.println("Escribe una posición: ");
                        buscado = lector.nextLine();
                        System.out.println(plantilla.buscarPosicion(buscado));
                        break;
                    case "3":
                        System.out.println("Escribe un Club: ");
                        buscado = lector.nextLine();
                        System.out.println(plantilla.buscarClub(buscado));
                        break;
                    case "4":
                        System.out.println("Escribe un dorsal de jugador: ");
                        buscado = lector.nextLine();
                        System.out.println(plantilla.buscarDorsal(buscado));
                        break;
                    case "5":
                        System.out.println("Escribe una nacionalidad: ");
                        buscado = lector.nextLine();
                        System.out.println(plantilla.buscarNacionalidad(buscado));
                        break;
                    case "0":
                        System.out.println("Programa finalizado");
                        break;
                    default:
                        System.out.println("Opción incorrecta");
                }
            } while (!opcion.equals("0"));
        } catch (RemoteException | NotBoundException e) {
            System.out.println(e.getMessage());
        }
        lector.close();
    }

    private static void escribirMenu() {
        System.out.println();
        System.out.println("Búsqueda de jugadores de la plantilla");
        System.out.println("--------------------------");
        System.out.println("1 = Por Nombre");
        System.out.println("2 = Por Posición");
        System.out.println("3 = Por Club");
        System.out.println("4 = Por dorsal");
        System.out.println("5 = Por Nacionalidad");
        System.out.println("0 = Terminar programa");
        System.out.println("--------------------------");
        System.out.println("¿Qué filtro/opción eliges?");
    }

}
