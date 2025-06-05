package com.projecte.acceso;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.projecte.entidad.Usuario;

public class Login {

    private String nombreUsuario;
    private String idUsuario;

    // Devuelve el ID del usuario que ha hecho login
    public String getIdUsuario() {
        return idUsuario;
    }
    
    // Devuelve el nombre del usuario que ha hecho login
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    // Método para realizar el login leyendo usuario y contraseña desde consola
    public boolean login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el nombre de usuario: ");
        String usuario = sc.nextLine();
        System.out.print("Introduce la contraseña: ");
        String contrasenya = sc.nextLine();

        boolean usuarioEncontrado = false;
        boolean accesoConcedido = false;

        // Lee el archivo con los datos de usuarios para validar credenciales
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
                            this.nombreUsuario = usuario;
                            this.idUsuario = datos[0];
                            return true;
                        }
                    }
                }
            }

            if (!usuarioEncontrado) {
                System.out.println("Error, el usuario no existe.");
            } else if (!accesoConcedido) {
                System.out.println("Error, contraseña incorrecta.");
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accesoConcedido;
    }

    // Obtiene los datos completos de un usuario dado su ID
    public Usuario datosUsuario(String idUsuario) throws IOException {
        try (BufferedReader leer= new BufferedReader(new FileReader("src/com/projecte/usuarios/archivoUsuarios.txt"))) {
            String linea;
            while ((linea = leer.readLine()) != null) {
                String[] datos = linea.split(":");
                if (datos.length >= 5 && datos[0].equals(idUsuario)) {
                    int id = Integer.parseInt(datos[0]);
                    String fechaNacimiento = datos[6];
                    String rol = "ROL_USUARIO"; 
                    String poblacion = datos[5];
                    String nombreUsuario = datos[1];
                    String contrasenya = datos[4];
                    String email = datos[3];
                    String apellido = datos[2];
                   
                    return new Usuario(id, nombreUsuario, apellido, fechaNacimiento, nombreUsuario, email, contrasenya, poblacion, rol);
                }
            }
        }
        return null;
    }
}
