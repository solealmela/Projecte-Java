package com.projecte.usuarios;

import java.io.FileReader;
import java.io.IOException;

import com.projecte.entidad.*;
public class Usuari extends Persona {
    String rol;
    int id;
    String poblacion;
    String nombreUsuario; //Lo introducimos cada vez que se accede
    String contrasena;

    public Usuari(String nombre, String apellido, String fechaNacimiento, int id, String poblacion,
            String nombreUsuario, String contrasena) {
        super(nombre, apellido, fechaNacimiento);
        this.id = id;
        rol = "ROL.USUARIO";
        this.poblacion = poblacion;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String isRol() {
        return rol;
    }
    public String getPoblacion() {
        return poblacion;
    }
    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    
    @Override
    public String toString() {
        return "Usuari [rol=" + rol + ", id=" + id + ", poblacion=" + poblacion + ", nombreUsuario=" + nombreUsuario
                + "]";
    }

}