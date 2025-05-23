package com.projecte.main;
import java.util.Scanner;

import com.projecte.menus.*;
import com.projecte.acceso.*;

public class ProgramaPrincipal {
    static Scanner sc = new Scanner(System.in);
    static int opcion;

    public static void main(String[] args) {
        mostrarMenu();
        opcion=sc.nextInt();
        switch (opcion) {
            case 1:
                registreUsuari();
                mostrarMenu();
              
            break;
            case 2:
                loginUsuario();
                Login login1 = new Login();
                login1.loginUsuario();
            break;
            case 3:
                
            break;
        
        }
        
    } //fin main

    public static void loginUsuario(){
        System.out.println("Dime el nombre del usuario y su contraseña");
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