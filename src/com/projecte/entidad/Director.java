package com.projecte.entidad;

import java.util.Iterator;

public class Director extends Gestionable implements Comparable, Iterable {

    static private int id;
    static private String archivo = "src/com/projecte/usuarios/" + id + "/archivoDirectores.llista";

    public Director(String nombre, String apellido, String fechaNacimiento) {
        super(nombre, apellido, fechaNacimiento);
        id++;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Director.id = id;
    }

    public int compareTo(Director director) {
        try {
            if (this.getId() > director.getId()) {
                System.out.println("Estás comparando lo mismo");
            } else {
                System.out.println("No son iguales");
                ;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int compareTo(Object o) {
        // Este metodo se ejecuta si el objeto que le pasamos es un objeto no de tipo
        // Director
        
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasNext'");
    }

    @Override
    public Object next() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'next'");
    }

    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

}
