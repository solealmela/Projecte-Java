package com.projecte.main;
import java.util.Scanner;

import com.projecte.acceso.*;
import com.projecte.menus.*;

public class ProgramaPrincipal {
    static Scanner sc = new Scanner(System.in);
    static int opcion;

    public static void main(String[] args) {
        mostrarMenu();
        opcion=sc.nextInt();
        switch (opcion) {
            case 1:
                registreUsuari();
<<<<<<< HEAD
=======
                mostrarMenu();
              
>>>>>>> 07bb6983df4dfc110b62a8f2fc1b64c030b0dcb8
            break;
            case 2:
                loginUsuario();
            break;
            case 3:
                
            break;
        }
        
    } //fin main

    public static void loginUsuario(){
        Login login1 = new Login();
        login1.login();
    }

    public static void registreUsuari(){
        Registro registro1 = new Registro();
        registro1.obtenerDatos();
    }

    public static void mostrarMenu(){
        String[] opciones = {"REGISTRE","LOGIN","SALIR"};
        Menu menuInicio = new Menu("Menu de inicio", opciones);
        menuInicio.mostrarMenu();
    }

    public static void menuInicioUsuario(){
        String[] opciones = {"Ver mi lista de Peliculas","Ver mi lista de Actores","Ver mi lista de Directores", "Agregar Peliculas",};
    }
}