package com.projecte.entidad;

import java.util.ArrayList;
import java.util.List;

public class Pelicula implements Comparable<Pelicula> {

    private static int nextId = 1; // Generador de IDs únicos

    private int id;
    private int duracionMinutos;
    private String nombre;
    private List<Actor> actoresDeLaPeli = new ArrayList<>();
    private Director director;

    public Pelicula(int duracionMinutos, String nombre, List<Actor> actoresDeLaPeli, Director director) {
        this.id = nextId++;
        this.duracionMinutos = duracionMinutos;
        this.nombre = nombre;
        this.actoresDeLaPeli = actoresDeLaPeli;
        this.director = director;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int compareTo(Pelicula otraPelicula) {
        return this.nombre.compareToIgnoreCase(otraPelicula.getNombre());
    }
}
