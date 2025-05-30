package com.projecte.menus;

public class Menu {
    private String titulo;
    private String[] opciones;

    public Menu(String titulo, String[] opciones) {
        this.titulo = titulo;
        this.opciones = opciones;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public void setOpciones(String[] opciones) {
        this.opciones = opciones;

    }

    public void mostrarMenu() {
        System.out.println("=== " + titulo + " ===");
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ". " + opciones[i]);
        }
        System.out.print("Selecciona una opción: ");
    }

    public void listarDirectores() {

    }
    //Wenos dias
}
