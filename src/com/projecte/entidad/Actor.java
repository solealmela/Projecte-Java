package com.projecte.entidad;
import com.projecte.utils.Gestionable;
import java.io.Serializable;

public class Actor extends Persona implements Gestionable, Serializable {

    private static int nextId = 1;
    private int id;

    private static final String archivoBase = "src/com/projecte/usuarios/";

    public Actor(String nombre, String apellido, String fechaNacimiento) {
        super(nombre, apellido, fechaNacimiento);
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }

    public String getArchivoRuta() {
        return archivoBase + id + "/archivoActores.llista";
    }

    // Implementación de Gestionable
    @Override
    public String getIdentificador() {
        return "A-" + id;
    }

    @Override
    public String resum() {
        return super.getNombre() + " " + super.getApellido();
    }

    @Override
    public void mostrarDetalls() {
        System.out.println("ID: " + getIdentificador());
        System.out.println("Nombre: " + super.getNombre());
        System.out.println("Apellido: " + super.getApellido());
        System.out.println("Fecha de nacimiento: " + super.getFechaNacimiento());
    }

}