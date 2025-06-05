package com.projecte.entidad;
import com.projecte.utils.Gestionable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pelicula implements Comparable<Pelicula>, Gestionable, Serializable {

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

    public List<Actor> getActoresDeLaPeli() {
        return actoresDeLaPeli;
    }

    public Director getDirector() {
        return director;
    }

    // compareTo para ordenar por nombre
    @Override
    public int compareTo(Pelicula otraPelicula) {
        return this.nombre.compareToIgnoreCase(otraPelicula.getNombre());
    }

    // Implementación de la interfaz Gestionable
    @Override
    public String getIdentificador() {
        return "P-" + id;
    }

    @Override
    public String resum() {
        return nombre + " (" + any + "), Dirigida por: " + (director != null ? director.resum() : "Desconocido");
    }

    @Override
    public void mostrarDetalls() {
        System.out.println("ID: " + getIdentificador());
        System.out.println("Título: " + nombre);
        System.out.println("Duración: " + duracionMinutos + " minutos");
        System.out.println("Año: " + any);
        System.out.println("Director: " + (director != null ? director.resum() : "No asignado"));
        System.out.println("Actores:");
        for (Actor actor : actoresDeLaPeli) {
            System.out.println("- " + actor.resum());
        }
    }
}
