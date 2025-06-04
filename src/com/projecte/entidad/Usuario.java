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
    private String email; // nueva variable para obtener el correo del usuario
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

    public void listar(int rutaFicheroPeliculas ) {
        String rutaArchivo = null;
        String descripcion = null;
        
        System.out.println("cosa");
        //int rutaFicheroPeliculas = scanner.nextInt();
    
        switch (rutaFicheroPeliculas) {
            case 1 -> {
                rutaArchivo = "Projecte-Java/src/com/projecte/datos/actorDades.txt";
                descripcion = "actor.dades";
            }
            case 2 -> {
                rutaArchivo = "Projecte-Java/src/com/projecte/datos/PeliculasDades.txt";
                descripcion = "pelicula.dades";
            }
            case 3 -> {
                rutaArchivo = "Projecte-Java/src/com/projecte/datos/directorDades.txt";
                descripcion = "director.dades";
            }
            case 4 -> {
                rutaArchivo = "Projecte-Java/src/com/projecte/datos/actorDades.txt";
                descripcion = "actor.dades";
            }
            case 5 -> {
                rutaArchivo = "Projecte-Java/src/com/projecte/datos/PeliculasDades.txt";
                descripcion = "pelicula.dades";
            }
            case 6 -> {
                rutaArchivo = "Projecte-Java/src/com/projecte/datos/directorDades.txt";
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
          System.out.println("deseas agregar algun archivo S/N");
        String opcion = scanner.nextLine();
        if (opcion.equalsIgnoreCase("s")) {
             agregarEntidades(rutaFicheroPeliculas, null, opcion); //obtengo la lista del fichero que está viendo y su opcion
        }else if (opcion.equalsIgnoreCase("n")) {
            return;
        }else{
            System.out.println("Dato incorrecto"); //meterlo dentro de un while
        }
       
    }//fin listar

    public void agregarEntidades(int rutaFicheroPeliculas,Usuario usuario, String opcion){
        String archivoSalida = null;
        String nombreArchivo = null;
      
        while (!opcion.equalsIgnoreCase("n")) { //bucle para añadir 
                
            switch (rutaFicheroPeliculas) {
                case 1 -> {archivoSalida = "Projecte-Java/src/com/projecte/datos/actor.dades";
                nombreArchivo = "archivoActores.llista"; } //estos son los nombres de los archivos en las carpetas de los usuarios
                case 2 -> {archivoSalida = "Projecte-Java/src/com/projecte/datos/peliculas.dades";
                nombreArchivo = "archivoPeliculas.llista";}
                case 3 -> {archivoSalida = "Projecte-Java/src/com/projecte/datos/director.dades";
                nombreArchivo = "archivoDirectores.llista";}
                case 4 -> {archivoSalida = "Regresando"; 
                return;}
                default -> {
                    System.out.println("Opcion in valida");
                    return;
                }
            }
            String rutaCarpetaUsuario = "Projecte-Java/src/com/projecte/usuarios/" + usuario.getId() + nombreUsuario; //ruta carpeta + la carpeta usuario         
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