package com.projecte.main;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.projecte.menus.*;
import com.projecte.acceso.*;
import com.projecte.entidad.Usuario;

public class ProgramaPrincipal {

    private static Menu menuAdministrador = new Menu("menu Administrador", new String[] {"Añadir Directores","Añadir Actores","Añadir Peliculas","Eliminar Usuarios","Ver lista de Peliculas","Ver lista de Actores","Ver lista de Directores", "Salir"});
    private static Menu menuInicio = new Menu("Menu de inicio", new String[] {"Registro","Inicio de sesión","Salir"});
    private static   Menu menuUsuario = new Menu("Menu Usuarios", new String[] {"Ver lista de Actores","Ver lista de Peliculas","Ver lista de Directores","Salir"});

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
                                        sc.nextLine(); // limpiar entrada

                                        switch (opcionAdmin) {
                                            case 1, 2, 3, 4, 5, 6, 7, 8 -> {
                                                // Aquí invoca métodos según opción pero los hacen ustedes si pueden por la mañana
                                                System.out.println("Funcionalidad aún no implementada.");
                                            }
                                            case 11 -> {
                                                System.out.println("Cerrando sesión de administrador...\n");
                                                correctoInicioSesion = false; // Volverá al menú de inicio
                                            }
                                            default -> System.out.println("Opción incorrecta.");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Entrada inválida.");
                                        sc.nextLine();
                                        opcionAdmin = -1;
                                    }
                                } while (opcionAdmin != 11);
                            } else {
                                int opcionUsuario;
                                do {
                                    menuUsuario.mostrarMenu();
                                    try {
                                        opcionUsuario = sc.nextInt();
                                        sc.nextLine(); // consumir salto de línea

                                        switch (opcionUsuario) {
                                            case 1, 2, 3 -> usuario.listar(opcionUsuario);
                                            case 4 -> {
                                                System.out.println("Cerrando sesión...\n");
                                                correctoInicioSesion = false; // Volverá al menú de inicio
                                            }
                                            default -> System.out.println("Opción incorrecta.");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Entrada no válida.");
                                        sc.nextLine(); // limpiar entrada
                                        opcionUsuario = -1;
                                    }
                                } while (opcionUsuario != 4 && correctoInicioSesion);
                            }

                        } catch (Exception e) {
                            System.out.println("Error al obtener datos del usuario.");
                            correctoInicioSesion = false;
                        }
                    }
                }

                case 3 -> System.out.println("Saliendo...\n");  
                default -> {
                    if (opcion != -1) System.out.println("Opción incorrecta\n");
                }
            }
        } while (opcion != 3 && !correctoInicioSesion);

        sc.close();

    } //fin main
}