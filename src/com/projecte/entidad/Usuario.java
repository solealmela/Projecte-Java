package com.projecte.entidad;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Usuario extends Gestionable {

    private int id;
    private String rol;
    private String poblacion;
    private String nombreUsuario;
    private String contrasenya;
    private String email;
    private Scanner scanner = new Scanner(System.in); 

    public Usuario(String nombre, String apellido, String fechaNacimiento, int id, String poblacion, String nombreUsuario, String contrasenya,String email) {
        super(nombre, apellido, fechaNacimiento);
        this.id = id;
        this.email = email; 
        rol = "ROL.USUARIO";
        this.poblacion = poblacion;
        this.nombreUsuario = nombreUsuario;
        this.contrasenya = contrasenya;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        String rutaArchivo = "src/com/projecte/datos/";
      
        switch (rutaFicheroPeliculas) {
            case 1 -> {
                rutaArchivo += "actor.dades"; 
            }
            case 2 -> {
                rutaArchivo += "peliculas.dades";
            }
            case 3 -> {
                rutaArchivo += "director.dades";
            } default -> {
                System.out.println("Ruta inválida.");
                return;
            }
        }
    
        System.out.println("Comprobando archivos en: " + rutaArchivo.substring(23));
    
        try (BufferedReader bf = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length >= 3) {
                    String id = partes[0];
                    String nombre = partes[1];
                    String apellido = partes[2];
                    System.out.println("ID: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido);
                } else {
                    System.out.println("Línea malformada: " + linea);
                }
            }
        } catch (IOException e) {
        System.out.println("Error al leer el fichero: " + e.getMessage());
    }
        String opcion;
        do {
            System.out.println("¿Deseas agregar algún dato? (S/N)");
            opcion = scanner.nextLine().trim();
            
            if (opcion.equalsIgnoreCase("s")) {
                agregarEntidades(rutaFicheroPeliculas, this, opcion);
            } else if (!opcion.equalsIgnoreCase("n")) {
                System.out.println("Dato incorrecto. Inténtalo de nuevo.");
            }
        } while (!opcion.equalsIgnoreCase("s") && !opcion.equalsIgnoreCase("n"));

            
    }//fin listar

    public void agregarEntidades(int rutaFicheroPeliculas,Usuario usuario, String opcion){
        String archivoSalida = null;
        String nombreArchivo = null;
      
        while (!opcion.equalsIgnoreCase("n")) { //bucle para añadir 
                
            switch (rutaFicheroPeliculas) {
                case 1 -> {archivoSalida = "src/com/projecte/datos/actor.dades";
                nombreArchivo = "archivoActores.llista"; } //estos son los nombres de los archivos en las carpetas de los usuarios
                case 2 -> {archivoSalida = "src/com/projecte/datos/peliculas.dades";
                nombreArchivo = "archivoPeliculas.llista";}
                case 3 -> {archivoSalida = "src/com/projecte/datos/director.dades";
                nombreArchivo = "archivoDirectores.llista";}
                case 4 -> {archivoSalida = "Regresando"; 
                return;}
                default -> {
                    System.out.println("Opcion in valida");
                    return;
                }
            }
            String rutaCarpetaUsuario = "src/com/projecte/usuarios/" + usuario.getId() + nombreUsuario+"/"; //ruta carpeta + la carpeta usuario         
            File carpetaUsuario = new File(rutaCarpetaUsuario);

            //verificamos que existe la carpeta
            if (!carpetaUsuario.exists() || !carpetaUsuario.isDirectory()) {
                System.out.println("la carpeta del usuario no existe: "+ rutaCarpetaUsuario);
                return;
            }

            String archivoDestino = rutaCarpetaUsuario + "/" + nombreArchivo; // junto la carpeta con el nombre del archivo

            try (
                BufferedReader br = new BufferedReader(new FileReader(archivoSalida));
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivoDestino))
                ) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println("llinea "+ linea);
                    bw.write(linea);
                    bw.newLine(); //leer la linea y crear una nueva
                }
                System.out.println("Datos copiados correctamente a: "+ archivoDestino);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("deseas agregar otro? S/N");
            opcion = scanner.nextLine();

        }


    }//fin agregar

@Override
    public String toString() {
        return "Usuari [rol=" + rol + ", id=" + id + ", poblacion=" + poblacion + ", nombreUsuario=" + nombreUsuario
        + "]";
    }
}