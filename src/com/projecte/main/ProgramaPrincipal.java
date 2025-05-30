package com.projecte.main;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.projecte.menus.*;
import com.projecte.acceso.*;

public class ProgramaPrincipal {

    private static Menu menuInicio = new Menu("Menu de inicio", new String[] {"Registro","Inicio de sesión","Salir"});
    private static Menu menuUsuario = new Menu("Menu Usuarios", new String[] {"Ver mi lista de Peliculas","Ver mi lista de Actores","Ver mi lista de Directores", "Agregar Peliculas","Agregar Actores","Agregar Directores","Salir"});
    private static Menu menuAdministrador = new Menu("Menu Administrador", new String[] {"Eliminar Usuario","Ver mi lista de Actores","Ver mi lista de Directores", "Agregar Peliculas","Agregar Actores","Agregar Directores","Salir"});


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        boolean correctoInicioSesion = false;        
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
                    correctoInicioSesion = new Login().login();
                    if (correctoInicioSesion) {
                        menuUsuario.mostrarMenu();
                    }
                }
                case 3 -> System.out.println("Saliendo...\n");  
                default -> {
                    if (opcion != -1) System.out.println("Opción incorrecta\n");
                }
            }
        } while (opcion != 3 && correctoInicioSesion == false);

    } //fin main
}