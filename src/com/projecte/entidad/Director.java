package com.projecte.entidad;
public class Director extends Gestionable{  
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

}
