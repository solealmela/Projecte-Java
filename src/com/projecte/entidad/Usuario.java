package com.projecte.entidad;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Usuario extends Gestionable {

    private int id;
    private String rol;
    private String poblacion;
    private String nombreUsuario;
    private String contrasenya;

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

    public void listar(int rutaFicheroPeliculas) {
        String rutaArchivo = null;
        String descripcion = null;
    
        switch (rutaFicheroPeliculas) {
            case 1 -> {
                rutaArchivo = "Projecte-Java/src/com/projecte/datos/actor.dades";
                descripcion = "actor.dades";
            }
            case 2 -> {
                rutaArchivo = "Projecte-Java/src/com/projecte/datos/pelicula.dades";
                descripcion = "pelicula.dades";
            }
            case 3 -> {
                rutaArchivo = "Projecte-Java/src/com/projecte/datos/director.dades";
                descripcion = "director.dades";
            }
            default -> {
                System.out.println("Ruta inválida.");
                return;
            }
        }
    
        System.out.println("Comprobando archivos en: " + descripcion);
    
        try (BufferedReader bf = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                File archivo = new File(linea);
                if (archivo.exists()) {
                    System.out.println("Existe: " + linea);
                } else {
                    System.out.println("No existe: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }

@Override
    public String toString() {
        return "Usuari [rol=" + rol + ", id=" + id + ", poblacion=" + poblacion + ", nombreUsuario=" + nombreUsuario
                + "]";
    }
}