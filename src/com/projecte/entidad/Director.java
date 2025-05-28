package com.projecte.entidad;

public class Director extends Gestionable implements Comparable {
    
    static private int id;
    static private String archivo = "src/com/projecte/usuarios/"+id+"/archivoDirectores.llista";

    public Director(String nombre, String apellido, String fechaNacimiento) {
        super(nombre, apellido, fechaNacimiento);
        id++;
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    
}
