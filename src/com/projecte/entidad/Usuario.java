package com.projecte.entidad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Usuario extends Persona {

    private int id;
    private String nombreUsuario;
    private String email;
    private String contrasenya;
    private String poblacion;
    private String rol;
    private Scanner scanner = new Scanner(System.in);

    public Usuario(int id, String nombre, String apellido, String fechaNacimiento, String nombreUsuario, String email,
            String contrasenya, String poblacion, String rol) {
        super(nombre, apellido, fechaNacimiento);
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.contrasenya = contrasenya;
        this.poblacion = poblacion;
        this.rol = "ROL_USUARIO";
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

    public String getRol() {
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

    //Método para listar los archivos
    public void listar(int opcionRuta) {
        String rutaArchivo = "src/com/projecte/datos/";

        switch (opcionRuta) {
            case 1 -> {
                rutaArchivo += "actor.dades";
                System.out.println("Comprobando archivo de Actores en: actor.dades");

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
                            System.out.println("Línea mal hecha: " + linea);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error al leer el fichero de Actores: " + e.getMessage());
                }
            }

            case 2 -> {
                rutaArchivo += "peliculas.dades";
                System.out.println("Comprobando archivo de Películas en: peliculas.dades");

                // Creamos una lista vacía para ir guardando los objetos Pelicula
                List<Pelicula> listaPeliculas = new ArrayList<>();

                try (BufferedReader bf = new BufferedReader(new FileReader(rutaArchivo))) {
                    String linea;
                    while ((linea = bf.readLine()) != null) {
                        // id:nombre:duracionMinutos:any:idDirector:idsActores
                        String[] partes = linea.split(":");
                        if (partes.length >= 4) {
                            // Extraemos el nombre, duración y año
                            String nombrePelicula = partes[1].trim();
                            int duracion = Integer.parseInt(partes[2].trim());
                            int anyo = Integer.parseInt(partes[3].trim());

                            Pelicula p = new Pelicula(nombrePelicula, duracion, anyo, new java.util.ArrayList<>(), 
                                                      null);

                            listaPeliculas.add(p);
                        } else {
                            System.out.println("Línea mal hecha en peliculas.dades: " + linea);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error al leer el fichero de Películas: " + e.getMessage());
                    return;
                }

                if (listaPeliculas.isEmpty()) {
                    System.out.println("No hay películas registradas.\n");
                    return;
                }

                // Orden natural por título
                Collections.sort(listaPeliculas);
                System.out.println("\n--- Películas ordenadas por título ---");
                for (Pelicula p : listaPeliculas) {
                    System.out.println(p.getNombre() + " - Año: " + p.getAny() + " - Duración: " + p.getDuracionMinutos() + " min");
                }

                // Ordenar por duración
                Collections.sort(listaPeliculas, new Comparator<Pelicula>() {
                    @Override
                    public int compare(Pelicula p1, Pelicula p2) {
                        return Integer.compare(p1.getDuracionMinutos(), p2.getDuracionMinutos());
                    }
                });
                System.out.println("\n--- Películas ordenadas por duración ---");
                for (Pelicula p : listaPeliculas) {
                    System.out.println(p.getNombre() + " - Año: " + p.getAny() + " - Duración: " + p.getDuracionMinutos() + " min");
                }

                // Ordenar por año y en caso de empate, ordenamos por título
                Collections.sort(listaPeliculas, new Comparator<Pelicula>() {
                    @Override
                    public int compare(Pelicula p1, Pelicula p2) {
                        int cmpAny = Integer.compare(p1.getAny(), p2.getAny());
                        if (cmpAny == 0) {
                            return p1.getNombre().compareToIgnoreCase(p2.getNombre());
                        }
                        return cmpAny;
                    }
                });
                System.out.println("\n--- Películas ordenadas por año ---");
                for (Pelicula p : listaPeliculas) {
                    System.out.println(p.getNombre() + " - Año: " + p.getAny() + " - Duración: " + p.getDuracionMinutos() + " min");
                }
            }

            case 3 -> {
                rutaArchivo += "director.dades";
                System.out.println("Comprobando archivo de Directores en: director.dades");
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
                            System.out.println("Línea mal hecha: " + linea);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error al leer el fichero de Directores: " + e.getMessage());
                }
            }

            default -> {
                System.out.println("Opción inválida.");
                return;
            }
        } // fin switch

        String opcion;
        do {
            System.out.println("\n¿Deseas agregar algún dato? (S/N)");
            opcion = scanner.nextLine().trim();

            if (opcion.equalsIgnoreCase("s")) {
                agregarEntidades(opcionRuta, this);
            } else if (opcion.equalsIgnoreCase("n")) {
                System.out.println("No se agregará ningún dato en el archivo");
            } else {
                System.out.println("Introduce un valor válido (S/N)");
            }

        } while (!opcion.equalsIgnoreCase("s") && !opcion.equalsIgnoreCase("n"));

    } // fin listar()

    public void agregarEntidades(int rutaFicheroPeliculas, Usuario usuario) {
        String archivoSalida = "src/com/projecte/datos/";
        String nombreArchivo = "";

        switch (rutaFicheroPeliculas) {
            case 1 -> {
                archivoSalida += "actor.dades";
                nombreArchivo = "archivoActores.llista";
            }
            case 2 -> {
                archivoSalida += "peliculas.dades";
                nombreArchivo = "archivoPeliculas.llista";
            }
            case 3 -> {
                archivoSalida += "director.dades";
                nombreArchivo = "archivoDirectores.llista";
            }
            case 4 -> {
                System.out.println("Saliendo...");
                return;
            }
            default -> {
                System.out.println("Opción inválida.");
                return;
            }
        }

        String rutaCarpetaUsuario = "src/com/projecte/usuarios/" + (usuario.getId()) + usuario.getNombre()+"/"; //ruta carpeta + la carpeta usuario 
        File carpetaUsuario = new File(rutaCarpetaUsuario);

        if (!carpetaUsuario.exists() || !carpetaUsuario.isDirectory()) {
            System.out.println("La carpeta del usuario no existe: " + rutaCarpetaUsuario);
            return;
        }

        String archivoDestino = rutaCarpetaUsuario + nombreArchivo;

        String opcion;
        do {
            try (
                BufferedReader br = new BufferedReader(new FileReader(archivoSalida));
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivoDestino, true))
            ) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    bw.write(linea);
                    bw.newLine();
                }
                System.out.println("Datos copiados correctamente a: " + archivoDestino);
            } catch (IOException e) {
                System.out.println("Error al copiar los datos: " + e.getMessage());
            }

            System.out.println("¿Deseas agregar otro? (S/N)");
            opcion = scanner.nextLine().trim();

        } while (!opcion.equalsIgnoreCase("n"));
        
    } // fin agregar

        public void añadirEntidadGlobal(int tipoEntidad) {
        String archivo = switch (tipoEntidad) {
            case 1 -> "src/com/projecte/datos/actor.dades";
            case 2 -> "src/com/projecte/datos/peliculas.dades";
            case 3 -> "src/com/projecte/datos/director.dades";
            default -> "Error al añadir";
        };

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            System.out.print("Introduce el ID: ");
            String id = scanner.nextLine();
            System.out.print("Introduce el nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Introduce el apellido: ");
            String apellido = scanner.nextLine();

            String nuevaLinea = id + ":" + nombre + ":" + apellido;
            bw.write(nuevaLinea);
            bw.newLine();
            System.out.println("Entidad añadida correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public void verListaGlobal(int tipoEntidad) { // verficar porque este no es necesario
        String archivo = "src/com/projecte/datos/";

        archivo += switch (tipoEntidad) {
            case 1 -> "actor.dades";
            case 2 -> "peliculas.dades";
            case 3 -> "director.dades";
            default -> "Error al ver la lista";
        };

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            System.out.println("Contenido del archivo:");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void eliminarUsuario(String nombreCarpetaUsuario) {
        File carpeta = new File("src/com/projecte/usuarios/" + nombreCarpetaUsuario);
        if (!carpeta.exists() || !carpeta.isDirectory()) {
            System.out.println("La carpeta del usuario no existe.");
            return;
        }

        eliminarCarpetaRecursiva(carpeta);
        System.out.println("Carpeta del usuario eliminada correctamente.");
    }

    private void eliminarCarpetaRecursiva(File carpeta) {
        File[] archivos = carpeta.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                    eliminarCarpetaRecursiva(archivo);
                } else {
                    archivo.delete();
                }
            }
        }
        carpeta.delete();
    }

    @Override
    public String toString() {
        return "Usuari [rol=" + rol + ", id=" + id + ", poblacion=" + poblacion + ", nombreUsuario=" + nombreUsuario + "]";
    }
}