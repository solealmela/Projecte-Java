package com.projecte.menus;

<<<<<<< HEAD
import java.util.Scanner;

public class Menu {
    private String titulo;
    private String [] opciones;
    private Scanner scanner;


    public Menu(String titulo, String[] opciones, Scanner scanner) {
        this.titulo = titulo;
        this.opciones = opciones;
        this.scanner = new Scanner(System.in); // obtener el dato del escanner
=======
public class Menu {
   private String titulo;
   private String [] opciones;

    public Menu(String titulo, String[] opciones) {
    this.titulo = titulo;
    this.opciones = opciones;
>>>>>>> 147ea75371f79ec7a7f6722483380fded663a548
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
<<<<<<< HEAD
    }//titulo

=======
    }
>>>>>>> 147ea75371f79ec7a7f6722483380fded663a548

    public String[] getOpciones() {
        return opciones;
    }
    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
<<<<<<< HEAD
    }//opciones


    public Scanner getScanner() {
        return scanner;
    }
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }//scanner

    public int mostrar(){
        int opcion = -1;
        // do {
            
        // } while (condition);
        return opcion;
    }

    

=======
    }

    public void mostrarMenu(){
          System.out.println("=== " + titulo + " ===");
    for (int i = 0; i < opciones.length; i++) {
        System.out.println((i + 1) + ". " + opciones[i]);
    }
    System.out.print("Selecciona una opción: ");
    }
>>>>>>> 147ea75371f79ec7a7f6722483380fded663a548

    
}
