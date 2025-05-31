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
        agregarEntidades(rutaFicheroPeliculas, null); //obtengo la lista del fichero que está viendo y su opcion
    }

    public void agregarEntidades(int rutaFicheroPeliculas,Usuario usuario){
        String archivoSalida = null;
        switch (rutaFicheroPeliculas) {
            case 1 -> archivoSalida = "Projecte-Java/src/com/projecte/datos/actor.dades";
            case 2 -> archivoSalida = "Projecte-Java/src/com/projecte/datos/peliculas.dades";
            case 3 -> archivoSalida = "Projecte-Java/src/com/projecte/datos/director.dades";
            case 4 -> archivoSalida = "Regresando"; 
            default -> {
                System.out.println("Opcion in valida");
                return;
            }
        }
        System.out.println("Añadiendo datos en "+ archivoSalida);

        try (BufferedReader br = new BufferedReader(new FileReader(archivoSalida))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println("llinea "+ linea);

                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

@Override
    public String toString() {
        return "Usuari [rol=" + rol + ", id=" + id + ", poblacion=" + poblacion + ", nombreUsuario=" + nombreUsuario
                + "]";
    }
}