package com.projecte.acceso;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Registro {
    
    private Scanner sc = new Scanner(System.in);
    private static final String ARCHIVO = "src/com/projecte/usuarios/archivoUsuarios.txt";

    public void obtenerDatos() {
        //Creamos el ID de cada usuario a partir de las líneas que haya en el archivo
        int id = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            while (br.readLine() != null) {
                id++;
            }
        } catch (IOException e) {
            System.out.println("Error al obtener la id: " + e.getMessage());
        }

        System.out.println("Introduce tu nombre de usuario");
        String nombreUsuario = sc.nextLine();

        //Comprobamos que ese nombre de usuario no está en uso
        if (!existeDato(nombreUsuario, 1)) {
            System.out.println("Introduce tus apellidos");
            String apellidos = sc.nextLine();
            
            System.out.println("Introduce tu email");
            String email = sc.nextLine();

            //Comprobamos que el email contenga '@' y no esté en uso
            if (validarEmail(email) && !existeDato(email,3)) {
                System.out.println("Introduce tu contraseña");
                String contrasenya = sc.nextLine();
                System.out.println("Repite la contraseña");
                String verificarContrasenya = sc.nextLine();

                //Comprobamos si las contraseñas coinciden
                if (contrasenya.equals(verificarContrasenya)) {
                    System.out.println("Introduce tu población");
                    String poblacion = sc.nextLine();
                    
                    System.out.println("Introduce tu fecha de nacimiento (dd-MM-YYYY)");
                    String fechaNacimiento = sc.nextLine();

                    //Validamos que el formato de la fecha sea correcto
                    if (validarFecha(fechaNacimiento)) {

                        //Si todos los datos son correctos, los escribimos en el archivo 'archivoUsuarios.txt'
                        try (BufferedWriter out = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
                            String datos = id + ":" + nombreUsuario + ":" + apellidos + ":" + email + ":" + contrasenya + ":" + poblacion + ":" + fechaNacimiento;
                            out.write(datos);
                            out.newLine();

                            System.out.println("Usuario creado correctamente");
                        } catch (IOException e) {
                                System.out.println("Error al crear el usuario: " + e.getMessage());
                        }

                    } else {
                        System.out.println("Formato de fecha incorrecto");
                    }

                } else {
                    System.out.println("Las contraseñas no coinciden");
                }
            } else {
                System.out.println("Ese email no es válido");
            }
        } else {
            System.out.println("Nombre de usuario no disponible");
        }
    }

    //Método para validar que el email contiene '@'
    public boolean validarEmail(String email) {
        return email.indexOf('@') != -1;
    }

    //Método para comprobar si algún dato único (nombreUsuario, email) existe
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

    //Método para comprobar el formato de la fecha
    public boolean validarFecha(String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate.parse(fecha, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}