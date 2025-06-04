package com.projecte.entidad;

public class Actor extends Gestionable{

    static private int id;
    static private String archivo = "src/com/projecte/usuarios/"+id+"/archivoActores.llista";


    public Actor(String nombre, String apellido, String fechaNacimiento) {
        super(nombre, apellido, fechaNacimiento);
        id++;
    }

    public void crearActor(){

    }
        public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Actor.id = id;
    }

}