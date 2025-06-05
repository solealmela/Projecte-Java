package com.projecte.acceso;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import com.projecte.entidad.Usuario;

public class Registro {

    private Scanner sc = new Scanner(System.in);
    private static final String ARCHIVO = "src/com/projecte/usuarios/archivoUsuarios.txt";

    public void obtenerDatos() {
        
        int id = 0;

        //Obtenemos el id a partir de las lineas del archivo 'archivoUsuarios.txt'
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            id = (int) br.lines().count();
        } catch (IOException e) {
            System.out.println("Error al obtener la id: " + e.getMessage());
        }

        //Pedimos los datos del usuario y validamos las entradas
        String nombreUsuario;
        do {
            System.out.print("\nIntroduce tu nombre de usuario: ");
            nombreUsuario = sc.nextLine().trim();
            if (!validarSinDosPuntos(nombreUsuario)) {
                System.out.println("No puede contener ':'");
            } else if (existeDato(nombreUsuario, 1)) {
                System.out.println("Ese nombre de usuario ya está en uso, intenta otro.");
            }
        } while (!validarSinDosPuntos(nombreUsuario) || existeDato(nombreUsuario, 1));

        String apellidos;
        do {
            System.out.print("Introduce tus apellidos: ");
            apellidos = sc.nextLine().trim();
            if (!validarSinDosPuntos(apellidos)) {
                System.out.println("No puede contener ':'");
            }
        } while (!validarSinDosPuntos(apellidos));

        String email;
        do {
            System.out.print("Introduce tu email: ");
            email = sc.nextLine().trim();
            if (!validarSinDosPuntos(email)) {
                System.out.println("No puede contener ':'");
            } else if (!validarEmail(email)) {
                System.out.println("Formato incorrecto de email, debe contener '@'");
            } else if (existeDato(email, 3)) {
                System.out.println("Ese email ya está en uso, prueba otro.");
            }
        } while (!validarSinDosPuntos(email) || !validarEmail(email) || existeDato(email, 3));

        String contrasenya;
        String verificarContrasenya = "";
        do {
            System.out.print("Introduce tu contraseña: ");
            contrasenya = sc.nextLine().trim();
            if (!validarSinDosPuntos(contrasenya)) {
                System.out.println("No puede contener ':'");
                continue;
            }
            System.out.print("Repite la contraseña: ");
            verificarContrasenya = sc.nextLine().trim();
            if (!contrasenya.equals(verificarContrasenya)) {
                System.out.println("Las contraseñas no coinciden, vuelve a intentarlo.");
            }
        } while (!validarSinDosPuntos(contrasenya) || !contrasenya.equals(verificarContrasenya));

        String poblacion;
        do {
            System.out.print("Introduce tu población: ");
            poblacion = sc.nextLine().trim();
            if (!validarSinDosPuntos(poblacion)) {
                System.out.println("No puede contener ':'");
            }
        } while (!validarSinDosPuntos(poblacion));

        String fechaNacimiento;
        do {
            System.out.print("Introduce tu fecha de nacimiento (dd-MM-YYYY): ");
            fechaNacimiento = sc.nextLine().trim();
            if (!validarSinDosPuntos(fechaNacimiento)) {
                System.out.println("No puede contener ':'");
            } else if (!validarFecha(fechaNacimiento)) {
                System.out.println("Formato de fecha incorrecto, vuelve a intentarlo.");
            }
        } while (!validarSinDosPuntos(fechaNacimiento) || !validarFecha(fechaNacimiento));

        try (BufferedWriter out = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            
            //Si ya hemos introducido los datos correctamente, añadiremos la linea de datos a 'archivoUsuarios.txt'
            String datos = id + ":" + nombreUsuario + ":" + apellidos + ":" + email + ":" + contrasenya + ":" + poblacion + ":" + fechaNacimiento;
            out.write(datos);
            out.newLine();

            //Se crea la carpeta del usuario
            String[] separarCorreo = email.split("@");
            String rutaCarpetaUsuario = "src/com/projecte/usuarios/" + id + separarCorreo[0];
            File carpetaUsuario = new File(rutaCarpetaUsuario);
            if (!carpetaUsuario.exists() && !carpetaUsuario.mkdir()) {
                System.out.println("No se pudo crear la carpeta del usuario");
            }

            //Se crean los archivos dentro de la carpeta
            try {
                new File(rutaCarpetaUsuario + "/archivoActores.llista").createNewFile();
                new File(rutaCarpetaUsuario + "/archivoDirectores.llista").createNewFile();
                new File(rutaCarpetaUsuario + "/archivoPeliculas.llista").createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear los archivos del usuario: " + e.getMessage());
            }

            System.out.println("\nUsuario creado correctamente");
        } catch (IOException e) {
            System.out.println("Error al crear el usuario: " + e.getMessage());
        }
    }


    // Método para validar que el email contiene '@'
    public boolean validarEmail(String email) {
        return email.indexOf('@') != -1;
    }

    // Método para comprobar si algún dato único (nombreUsuario, email) existe
    public boolean existeDato(String dato, int posicionDato) {
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(":");

                if (datos.length >= 3 && datos[posicionDato].equals(dato)) {
                    encontrado = true;
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return encontrado;
    }

    // Método para comprobar el formato de la fecha
    public boolean validarFecha(String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate.parse(fecha, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    //Método para validar que no se introduzca ':'
    public boolean validarSinDosPuntos(String entrada) {
        return !entrada.contains(":");
    }


    public void datosUsuario(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'datosUsuario'");
    }

}