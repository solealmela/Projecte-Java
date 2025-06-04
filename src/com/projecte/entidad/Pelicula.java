package com.projecte.entidad;

import java.util.ArrayList;

public class Pelicula implements Comparable {

    private int id;
    private int duracionMinutos;
    private String nombre;
    private ArrayList actoresDeLaPeli = new ArrayList<>();
    private Director director;

    public Pelicula(int duracionMinutos, String nombre, ArrayList actoresDeLaPeli, Director director) {
        id++;
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

        public int compareTo(Pelicula o) { //Ordena de forma natural per titol
        try {
            if (this.getId()>o.getId()) {
                System.out.println("Estás comparando lo mismo");
            }else{
                System.out.println("No son iguales");;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int compareTo(Object o) {
        //Este metodo se ejecuta si el objeto que le pasamos es un objeto no de tipo Pelicula
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    
}
