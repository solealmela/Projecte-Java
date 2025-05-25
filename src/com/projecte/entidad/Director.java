package com.projecte.entidad;

public class Director extends Persona {
    
    static private int id;
    static private String archivo = "src/com/projecte/usuarios/"+id+"/archivoDirectores.llista";

    public Director(String nombre, String apellido, String fechaNacimiento) {
        super(nombre, apellido, fechaNacimiento);
        //TODO Auto-generated constructor stub
    }

    
}
