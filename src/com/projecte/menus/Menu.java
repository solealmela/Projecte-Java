package com.projecte.menus;

import java.util.Scanner;

public class Menu {
    private String titulo;
    private String [] opciones;
    private Scanner scanner;


    public Menu(String titulo, String[] opciones, Scanner scanner) {
        this.titulo = titulo;
        this.opciones = opciones;
        this.scanner = new Scanner(System.in); // obtener el dato del escanner
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }//titulo


    public String[] getOpciones() {
        return opciones;
    }
    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
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

    


    
}
