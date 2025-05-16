package com.projecte.main;
import java.util.Scanner;

public class ProgramaPrincipal {
    static Scanner sc = new Scanner(System.in);
    static int opcion;

    public static void main(String[] args) {
        mostrarMenu();
        opcion=sc.nextInt();
        switch (opcion) {
            case 1:
                registreUsuari();
            break;
            case 2:
                loginUsuari();
                
            break;
            case 3:
                
            break;
        
        }
        
    } //fin main

    public static void loginUsuari(){
        System.out.println("Dime el nombre del usuario y su contraseña");
    }

    public static void registreUsuari(){
        System.out.println("Nombre:");
        System.out.println("Apellido:");
        System.out.println("Fecha de nacimiento:");
        System.out.println("Email:");
        System.out.println("Contraseña:");
    }

    public static void mostrarMenu(){
        System.out.println("""
                1.REGISTRE
                2.LOGIN
                3.SALIR
                """);
    }
}