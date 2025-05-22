package com.projecte.acceso;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {
        public void login(String arxiu){
        Scanner sc = new Scanner(System.in);
        
try {
    System.out.println("Dime el nombre de usuario");
    String usuario=sc.nextLine();
    System.out.println("Dime la contraseña");
    String contraseña=sc.nextLine();
    BufferedReader lector= new BufferedReader(new FileReader(arxiu));
    String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
                String[] partes = linea.split(":");
                if(partes[0]==usuario && partes[3]==contraseña){
                    System.out.println("Bienvenido"+usuario);
                }
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    
        
        

    }
}
