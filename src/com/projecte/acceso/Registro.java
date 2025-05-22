package com.projecte.acceso;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Registro {
    
    private Scanner sc = new Scanner(System.in);


    public void obtenerDatos() {
        System.out.println("Introduce tu nombre de usuario");
        String nombreUsuario = sc.nextLine();
        
        System.out.println("Introduce tus apellidos");
        String apellidos = sc.nextLine();
        
        System.out.println("Introduce tu email");
        String email = sc.nextLine();
        if (validarEmail(email) && !existeEmail(email)) {
            System.out.println("Introduce tu contraseña");
            String contrasenya = sc.nextLine();
            System.out.println("Repite la contraseña");
            String verificarContrasenya = sc.nextLine();

            if (contrasenya.equals(verificarContrasenya)) {
                System.out.println("Introduce tu población");
                String poblacion = sc.nextLine();
                
                System.out.println("Introduce tu fecha de nacimiento (dd-MM-YYYY)");
                String fechaNacimiento = sc.nextLine();

                

            } else {
                System.out.println("Las contraseñas no coinciden");
            }

        } else {
            System.out.println("Ese email no es válido");
        }
    }

    public boolean validarEmail(String email) {
        return email.indexOf('@') != -1;
    }

    public boolean existeEmail(String email) {
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader("archivoUsuarios.txt"))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(":");

                if (datos.length >= 3 && datos[3].equals(email)) {
                    encontrado = true;
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return encontrado;
    }














    // try {
    //         // BufferedWriter out = new BufferedWriter(new FileWriter("archivoUsuarios.txt", true));
    //         out.write((id+1):nombreUsuario + ":" + apellidos + ":" + email + ":" + contraseña + ":" + poblacion + ":" + fechaNacimiento);
    //         out.newLine(); // para que cada usuario esté en una línea distinta
    //         out.close();
    //     } catch (IOException e) {
    //         System.out.println("Se ha producido un error: " + e.getMessage());
    //     }
}