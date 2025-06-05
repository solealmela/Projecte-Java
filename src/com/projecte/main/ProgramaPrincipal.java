package com.projecte.main;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.projecte.menus.*;
import com.projecte.acceso.*;
import com.projecte.entidad.Usuario;

public class ProgramaPrincipal {

    private static Menu menuAdministrador = new Menu("menu Administrador", new String[] {"Añadir Directores","Añadir Actores","Añadir Peliculas","Eliminar Usuarios","Ver mi lista de Peliculas","Ver mi lista de Actores","Ver mi lista de Directores", "Agregar Peliculas","Agregar Actores","Agregar Directores","Salir"});
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
                    if (correctoInicioSesion) {
                        try {
                            Usuario usuario = login.datosUsuario(login.getIdUsuario());

                            if (nombreUsuario.equals("administrador")) {
                                menuAdministrador.mostrarMenu();
                            } else {
                                menuUsuario.mostrarMenu();
                                opcion = sc.nextInt();
                                switch (opcion) { //submenu
                                    case 1, 2, 3 -> {
                                    usuario.listar(opcion);}
                                    case 4 ->{ menuInicio.mostrarMenu();
                                    }
                                    default -> {
                                        // x cosa
                                    }
                                }
                        }

                        } catch (Exception e) {
                            // TODO: handle exception
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