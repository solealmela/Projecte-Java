package com.projecte.acceso;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {

    public void login(String archivo){
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.println("Introduce el nombre de usuario");
            String usuario = sc.nextLine();
            System.out.println("Introduce la contraseña");
            String contrasenya = sc.nextLine();

            BufferedReader lector =  new BufferedReader(new FileReader(archivo));
            String linea;

            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
                String[] datos = linea.split(":"); //Lo separa por los dos puntos

                if (datos[0] == usuario && datos[3] == contrasenya){ //Si esta parte corresponde con los datos introducidos
                    System.out.println("Bienvenido" + usuario);
                }
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

    }
}
