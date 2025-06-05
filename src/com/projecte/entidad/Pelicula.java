package com.projecte.entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pelicula implements Comparable<Pelicula>, Serializable {

    private static int nextId = 1;

    private int id;
    private String nombre;
    private int duracionMinutos;
    private int any;
    private List<Actor> actoresDeLaPeli = new ArrayList<>();
    private Director director;

    public Pelicula(String nombre, int duracionMinutos, int any, List<Actor> actoresDeLaPeli, Director director) {
        this.id = nextId++;
        this.nombre = nombre;
        this.duracionMinutos = duracionMinutos;
        this.any = any;
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

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    @Override
    public int compareTo(Pelicula otraPelicula) {
        return this.nombre.compareToIgnoreCase(otraPelicula.getNombre());
    }
}
