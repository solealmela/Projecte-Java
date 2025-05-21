package com.projecte.usuaris;

import com.projecte.entitat.*;
public class Usuari extends Persona {
    public Usuari(String nombre, String apellido, String fechaNacimiento, int id, boolean rol, String poblacion,
            String nombreUsuario, String contrasena) {
        super(nombre, apellido, fechaNacimiento);
        this.id = id;
        this.rol = rol;
        this.poblacion = poblacion;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    int id;
    boolean rol;
    String poblacion;
    String nombreUsuario; //Lo introducimos cada vez que se accede
    String contrasena;


}