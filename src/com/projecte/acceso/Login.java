package com.projecte.acceso;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {

    public String login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el nombre de usuario: ");
        String usuario = sc.nextLine();
        System.out.print("Introduce la contraseña: ");
        String contrasenya = sc.nextLine();

        //Booleanos para identificar el error
        boolean usuarioEncontrado = false;
        boolean accesoConcedido = false;

        try (BufferedReader lector = new BufferedReader(new FileReader("src/com/projecte/usuarios/archivoUsuarios.txt"))) {
            String linea;

            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(":");

                if (datos.length >= 5) {
                    if (datos[1].equals(usuario)) {
                        usuarioEncontrado = true;
                        if (datos[4].equals(contrasenya)) {
                            accesoConcedido = true;
                            System.out.println("Bienvenido/a, " + usuario);
                            return usuario;
                        }
                    }
                }
            }

            if (!usuarioEncontrado) {
                System.out.println("Error, el usuario no existe.");
            } else if (!accesoConcedido) {
                System.out.println("Error, contraseña incorrecta.");
            }
            return null;

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
