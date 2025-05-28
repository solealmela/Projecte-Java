package com.projecte.entidad;

public class Actor extends Gestionable implements Comparable {
    
    static private int id;
    static private String archivo = "src/com/projecte/usuarios/"+id+"/archivoActores.llista";


    public Actor(String nombre, String apellido, String fechaNacimiento) {
        super(nombre, apellido, fechaNacimiento);
        id++;
    }

    public void crearActor(){

    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
    
}