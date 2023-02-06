package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Jugador implements Serializable {
    String id;
    String nombre;
    String posicion;
    String club;
    String dorsal;
    String nacionalidad;
}


