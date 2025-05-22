package com.projecte.acceso;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {
        public void login(String arxiu){
        Scanner sc = new Scanner(System.in);
        
try {
    FileReader filereader = new FileReader(arxiu);
    System.out.println("Dime el usuario");
    String usuario=sc.nextLine();
    System.out.println("Dime la contraseña");
    String contraseña=sc.nextLine();

    filereader.close();
} catch (IOException e) {
    System.out.println("Error al leer el archivo: " + e.getMessage());
} finally {
    sc.close();
}
        
        

    }
}
