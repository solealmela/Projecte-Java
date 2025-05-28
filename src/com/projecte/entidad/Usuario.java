package com.projecte.entidad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Usuario extends Persona {
    
    private int id;
    private String rol;
    private String poblacion;
    private String nombreUsuario;
    private String contrasenya;

    public Usuario(String nombre, String apellido, String fechaNacimiento, int id, String poblacion, String nombreUsuario, String contrasenya) {
        super(nombre, apellido, fechaNacimiento);
        this.id = id;
        rol = "ROL.USUARIO";
        this.poblacion = poblacion;
        this.nombreUsuario = nombreUsuario;
        this.contrasenya = contrasenya;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String isRol() {
        return rol;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public void listar(int reutaFicheroPeliculas){
        if (reutaFicheroPeliculas == 1) {
            try (BufferedReader bf = new BufferedReader(new FileReader("Projecte-Java/src/com/projecte/datos/actor.dades"))) {
                String linea;
                System.out.println("Comprobando archivos en: ../datos/actor.dades");
                while ((linea = bf.readLine()) != null){
                    File archivo = new File(linea);
                    if (archivo.exists()) {
                        System.out.println("existe "+ linea);
                    }else{
                        System.out.println("No existe "+ linea);
                    }
                } //fin while
            } catch (IOException e) {
                System.out.println("Error al leer el fichero "+ e.getMessage());
            }
        }else if (reutaFicheroPeliculas == 2) {
            try (BufferedReader bf = new BufferedReader(new FileReader("src/com/datos/director.dades"))) {
                String linea2;
                System.out.println("Comprobando archivos en: ../datos/actor.dades");
                while ((linea2 = bf.readLine()) != null){
                    File archivo = new File(linea2);
                    if (archivo.exists()) {
                        System.out.println("existe "+ linea2);
                    }else{
                        System.out.println("No existe "+ linea2);
                    }
                } //fin while
            } catch (IOException e) {
                System.out.println("Error al leer el fichero "+ e.getMessage());
            }
        }else if (reutaFicheroPeliculas == 3) {
            try (BufferedReader bf = new BufferedReader(new FileReader("src/com/datos/director.dades"))) {
                String linea3;
                System.out.println("Comprobando archivos en: ../datos/actor.dades");
                while ((linea3 = bf.readLine()) != null){
                    File archivo = new File(linea3);
                    if (archivo.exists()) {
                        System.out.println("existe "+ linea3);
                    }else{
                        System.out.println("No existe "+ linea3);
                    }
                } //fin while
            } catch (IOException e) {
                System.out.println("Error al leer el fichero "+ e.getMessage());
            }
        }
    }

@Override
    public String toString() {
        return "Usuari [rol=" + rol + ", id=" + id + ", poblacion=" + poblacion + ", nombreUsuario=" + nombreUsuario
                + "]";
    }
}