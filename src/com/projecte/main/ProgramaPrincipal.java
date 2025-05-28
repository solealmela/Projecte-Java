package com.projecte.main;
import java.util.Scanner;

import com.projecte.menus.*;
import com.projecte.acceso.*;

public class ProgramaPrincipal {

    private static Menu menuInicio = new Menu("Menu de inicio", new String[] {"Registro","Inicio de sesión","Salir"});

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            menuInicio.mostrarMenu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    new Registro().obtenerDatos();
                    break;
                case 2:
                    new Login().login();
                    break;
                case 3:
                    System.out.println("Saliendo...\n");
                    break;
                default: 
                    System.out.println("Opción incorrecta");
                    break;
            }

        } while (opcion != 3);

    } //fin main

    public static void menuInicioUsuario(){
        String[] opciones = {"Ver mi lista de Peliculas","Ver mi lista de Actores","Ver mi lista de Directores", "Agregar Peliculas","Agregar Actores","Agregar Directores","Salir"};
        Menu menuUsuario = new Menu("Menu Usuarios", opciones);
        menuUsuario.mostrarMenu();
    }
}