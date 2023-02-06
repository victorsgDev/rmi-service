package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Objects;

@FunctionalInterface
public interface DataApi {

    String getData(String arg);
    ArrayList<Jugador> plantilla = receiveData();
    ArrayList<Jugador> dataToReturn = new ArrayList<>();
    static DataApi byName() {

        return arg -> {


        };

    }

    static ArrayList<Jugador> receiveData() {
        // Abrirfichero para lectura
        FileInputStream file = null;
        ObjectInputStream buffer = null;
        try {
            file = new FileInputStream("src/main/resources/jugadores.dat");
            buffer = new ObjectInputStream(file);
        } catch (IOException e) {
            System.out.println("Imposible abrir jugadores.dat");
            System.out.println(e.getMessage());
        }
        // Lee el objeto guardado en el archivo alumno.dat
        ArrayList<Jugador> plantilla = null;
        try {
            plantilla = (ArrayList<Jugador>) Objects.requireNonNull(buffer).readObject();
            System.out.println(plantilla);
            System.out.println("Data recogida con éxito");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Imposible leer jugadores.dat");
            System.out.println(e.getMessage());
        }
        // Cerrar el fichero
        try {
            assert buffer != null;
            buffer.close();
            file.close();
        } catch (IOException e) {
            System.out.println("Imposible cerrar el fichero");
            System.out.println(e.getMessage());
        }
        return plantilla;
    }

}
