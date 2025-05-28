package com.projecte.entidad;

import java.util.ArrayList;

public class Pelicula {

    private int id;
    private int duracionMinutos;
    private String nombre;
    private ArrayList actoresDeLaPeli= new ArrayList<>();
    private Director director;

    public Pelicula(int duracionMinutos, String nombre, ArrayList actoresDeLaPeli, Director director) {
        id++;
        this.duracionMinutos = duracionMinutos;
        this.nombre = nombre;
        this.actoresDeLaPeli = actoresDeLaPeli;
        this.director = director;
    }

    
}
