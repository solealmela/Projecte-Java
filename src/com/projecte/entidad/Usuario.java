package com.projecte.entidad;

public class Usuario extends Persona {
    
    int id;
    String rol;
    String poblacion;
    String nombreUsuario; //Lo introducimos cada vez que se accede
    String contrasenya;

    public Usuario(String nombre, String apellido, String fechaNacimiento, int id, String poblacion, String nombreUsuario, String contrasenya) {
        super(nombre, apellido, fechaNacimiento);
        this.id = id;
        rol = "ROL.USUARIO";
        this.poblacion = poblacion;
        this.nombreUsuario = nombreUsuario;
        this.contrasenya = contrasenya;
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

    public String getContrasenya() {
        return contrasenya;
    }
  
    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }
  
@Override
    public String toString() {
        return "Usuari [rol=" + rol + ", id=" + id + ", poblacion=" + poblacion + ", nombreUsuario=" + nombreUsuario
                + "]";
    }
}