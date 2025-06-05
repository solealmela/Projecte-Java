package com.projecte.entidad;
import com.projecte.utils.Gestionable;
import java.io.Serializable;

public class Director extends Persona implements Gestionable, Serializable {

    private static int contadorId = 0;
    private int id;

    public Director(String nombre, String apellido, String fechaNacimiento) {
        super(nombre, apellido, fechaNacimiento);
        this.id = contadorId++;
    }

    public int getId() {
        return id;
    }

    // Implementación de la interfaz Gestionable
    @Override
    public String getIdentificador() {
        return "D-" + id;
    }

    @Override
    public String resum() {
        return super.getNombre() + " " + super.getApellido() + " (ID: " + getIdentificador() + ")";
    }

    @Override
    public void mostrarDetalls() {
        System.out.println("ID: " + getIdentificador());
        System.out.println("Nombre: " + super.getNombre());
        System.out.println("Apellido: " + super.getApellido());
        System.out.println("Fecha de nacimiento: " + super.getFechaNacimiento());
    }
}
