package com.projecte.acceso;

public class Registro {
    
}

package com.projecte.acceso;

import java.io.FileReader;
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

        System.out.println("Introduce tu contraseña");
        String contrasenya = sc.nextLine();
        System.out.println("Repite la contraseña");
        String verificarContrasenya = sc.nextLine();

        System.out.println("Introduce tu población");
        String poblacion = sc.nextLine();
        
        System.out.println("Introduce tu fecha de nacimiento");
        String fechaNacimiento = sc.nextLine();



    }

    public boolean validarEmail(String email) {
        return email.indexOf('@') != -1;
    }

    public boolean noExisteEmail(String email) {
        FileReader in = null;

        try {
            in = new FileReader("archivoUsuarios.txt");

            
        }
    }
}
