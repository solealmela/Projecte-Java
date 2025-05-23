package com.projecte.acceso;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {

    public void login(){
        Scanner sc = new Scanner(System.in);
        String contrasenya="";
        String contrasenyaconfirmar="";
        
        try {
            System.out.println("Introduce el nombre de usuario:");
            String usuario = sc.nextLine();
            do {
            System.out.println("Introduce la contraseña:");
            contrasenya = sc.nextLine();
            System.out.println("Confirma la contraseña:");
            contrasenyaconfirmar = sc.nextLine();
            } while (contrasenya==contrasenyaconfirmar);

            BufferedReader lector = new BufferedReader(new FileReader("src/com/projecte/accesso/archivoUsuarios.txt"));
            String linea;
            boolean accesoConcedido = false;

            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(":");

                if (datos.length >= 5) {
                    if (datos[1].equals(usuario) && datos[4].equals(contrasenya)) {
                        System.out.println("Bienvenido, " + usuario);
                        accesoConcedido = true;
                        break;
                    }
                }
            }

            if (!accesoConcedido) {
                System.out.println("Usuario o contraseña incorrectos.");
            }

            lector.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } finally {
            sc.close(); // Se cierra el Scanner
        }

    }
}
