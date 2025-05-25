package com.projecte.acceso;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {

    public void login(){
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Introduce el nombre de usuario:");
            String usuario = sc.nextLine();
            System.out.println("Introduce la contraseña:");
            String contrasenya = sc.nextLine();
            
            BufferedReader lector = new BufferedReader(new FileReader("src/com/projecte/usuarios/archivoUsuarios.txt"));
            String linea;
            boolean accesoConcedido = false;

            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(":");

                if (datos.length >= 5) {
                    if (datos[1].equals(usuario) && datos[4].equals(contrasenya)) {
                        System.out.println("Bienvenido/a, " + usuario);
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
        } catch(Exception e){
            e.printStackTrace();
        }finally {
        }

    }
}
