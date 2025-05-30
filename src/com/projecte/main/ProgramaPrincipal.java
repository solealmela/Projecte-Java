package com.projecte.main;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.projecte.menus.*;
import com.projecte.acceso.*;
import com.projecte.entidad.Usuario;

public class ProgramaPrincipal {

    private static Menu menuInicio = new Menu("Menu de inicio", new String[] {"Registro","Inicio de sesión","Salir"});
    private static Menu menuUsuario = new Menu("Menu Usuarios", new String[] {"Ver mi lista de Peliculas","Ver mi lista de Actores","Ver mi lista de Directores", "Agregar Peliculas","Agregar Actores","Agregar Directores","Salir"});
    private static Menu menuAdministrador = new Menu("Menu Administrador", new String[] {"Eliminar Usuario","Ver mi lista de Actores","Ver mi lista de Directores", "Agregar Peliculas","Agregar Actores","Agregar Directores","Salir"});


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        Login login= new Login();
        String nombre="";
        
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
                case 1-> new Registro().obtenerDatos();
                case 2-> {nombre=login.login();
                    if (nombre.trim()=="") { //Si el nombre está vacío
                        if (nombre=="administrador") {
                            
                        }
                        menuUsuario.mostrarMenu();
                    }
                }
                case 3-> System.out.println("Saliendo...\n");
                default-> {
                    if (opcion != -1) System.out.println("Opción incorrecta\n");
                }
            }
        } while (opcion != 3);

    } //fin main
}