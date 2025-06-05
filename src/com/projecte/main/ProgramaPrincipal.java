package com.projecte.main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.projecte.menus.*;
import com.projecte.acceso.*;
import com.projecte.entidad.Pelicula;
import com.projecte.entidad.Usuario;

public class ProgramaPrincipal {

    private static Menu menuAdministrador = new Menu("Menu Administrador",
        new String[] { "Ver lista de Actores", "Ver lista de Peliculas", "Ver lista de Directores",
        "Añadir Directores", "Añadir Actores", "Añadir Peliculas", "Eliminar Usuarios",
        "Eliminar Entidad", "Salir" });

    private static Menu menuInicio = new Menu("Menu de inicio",
        new String[] { "Registro", "Inicio de sesión", "Salir" });

    private static Menu menuUsuario = new Menu("Menu Usuarios", new String[] { "Ver lista de Actores",
        "Ver lista de Peliculas", "Ver lista de Directores", "Ordenar Peliculas", "Salir" });

    private static Menu ordenarPeliculas = new Menu("Ordenar Peliculas", new String[] { "Per títol (Comparable)",
        "Per duració (Comparator)", "Per any + títol (Comparator múltiple)", "Salir" });

    private static Menu menuEliminarEntidad = new Menu("Eliminar Entidad",
        new String[] { "Eliminar Actores", "Eliminar Peliculas", "Eliminar Directores", "Volver" });


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        boolean correctoInicioSesion = false;
        String nombreUsuario = "";

        do {
            try {
                menuInicio.mostrarMenu();
                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("No has introducido una opción válida\n");
                sc.nextLine();
                opcion = -1;
            }
            switch (opcion) {
                case 1 -> new Registro().obtenerDatos();
                case 2 -> {
                    Login login = new Login();
                    correctoInicioSesion = login.login();
                    nombreUsuario = login.getNombreUsuario();

                    while (correctoInicioSesion) {
                        try {
                            Usuario usuario = login.datosUsuario(login.getIdUsuario());

                            if (nombreUsuario.equals("administrador")) {
                                int opcionAdmin;
                                do {
                                    menuAdministrador.mostrarMenu();
                                    try {
                                        opcionAdmin = sc.nextInt();
                                        sc.nextLine();

                                        switch (opcionAdmin) {
                                            case 1, 2 ,3-> {
                                                System.out.println("Ver lista de Actores");
                                                usuario.verListaGlobal(opcionAdmin);
                                            }
                                            case 5 -> {
                                                usuario.añadirEntidadGlobal(opcionAdmin);
                                                
                                            }
                                            case 6 -> {
                                                usuario.añadirEntidadGlobal(opcionAdmin);
                                                // Aquí invoca métodos según opción pero los hacen ustedes si pueden por la mañana
                                                System.out.println("Añadir Peliculas");
                                            }
                                            case 4-> {
                                                usuario.añadirEntidadGlobal(opcionAdmin);
                                                // Aquí invoca métodos según opción pero los hacen ustedes si pueden por la mañana
                                                System.out.println("Añadir director");
                                            }
                                            case 7-> {
                                                usuario.eliminarUsuario();
                                                System.out.println("Eliminar Usuarios");
                                            }
                                            // Caso para eliminar Actor, Director o Película
                                            case 8 -> {
                                                int opcionEliminar;
                                                do {
                                                    menuEliminarEntidad.mostrarMenu();
                                                    try {
                                                        opcionEliminar = sc.nextInt();
                                                        sc.nextLine();

                                                        switch (opcionEliminar) {
                                                            case 1, 2, 3 -> usuario.eliminarEntidadGeneral(opcionEliminar);
                                                            case 4 -> System.out.println("Volviendo al menú anterior...");
                                                            default -> System.out.println("Opción inválida. Inténtalo de nuevo.");
                                                        }
                                                    } catch (InputMismatchException e) {
                                                        System.out.println("Entrada inválida.");
                                                        sc.nextLine();
                                                        opcionEliminar = -1;
                                                    }
                                                } while (opcionEliminar != 4);
                                            }
                                            case 9 -> {
                                                System.out.println("Cerrando sesión del administrador...\n");
                                                correctoInicioSesion = false;
                                            }
                                            default -> System.out.println("Opción incorrecta.");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Entrada inválida.");
                                        sc.nextLine();
                                        opcionAdmin = -1;
                                    }
                                } while (opcionAdmin != 9);
                            } else {
                                int opcionUsuario;
                                do {
                                    menuUsuario.mostrarMenu();
                                    try {
                                        opcionUsuario = sc.nextInt();
                                        sc.nextLine();

                                        switch (opcionUsuario) {
                                            case 1, 2, 3 -> usuario.listar(opcionUsuario);
                                            case 4 -> { 
                                                ordenarPeliculas.mostrarMenu();
                                                int opcionOrden = sc.nextInt();
                                                sc.nextLine();

                                                List<Pelicula> peliculas = usuario.leerPeliculasDesdeArchivo();

                                                if (peliculas.isEmpty()) {
                                                    System.out.println("No hay películas registradas.");
                                                    return;
                                                }

                                                switch (opcionOrden) {
                                                    case 1 -> usuario.mostrarPeliculasOrdenadasPorTitulo(peliculas);
                                                    case 2 -> usuario.mostrarPeliculasOrdenadasPorDuracion(peliculas);
                                                    case 3 -> usuario.mostrarPeliculasOrdenadasPorAnyo(peliculas);
                                                    default -> System.out.println("Opción inválida.");
                                                }
                                            }
                                            case 5 -> {
                                                System.out.println("Cerrando sesión...\n");
                                                correctoInicioSesion = false;
                                            }
                                            default -> System.out.println("Opción incorrecta.");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Entrada no válida.");
                                        sc.nextLine();
                                        opcionUsuario = -1;
                                    }
                                } while (opcionUsuario != 5 && correctoInicioSesion);
                            }

                        } catch (Exception e) {
                            System.out.println("Error al obtener datos del usuario.");
                            correctoInicioSesion = false;
                        }
                    }
                }
                case 3 -> System.out.println("Saliendo...\n");
                default -> {
                    if (opcion != -1)
                        System.out.println("Opción incorrecta\n");
                }
            }
        } while (opcion != 3 && !correctoInicioSesion);

        sc.close();
    }
}
