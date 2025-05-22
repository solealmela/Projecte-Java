package com.projecte.entidad;
public abstract class Persona {
    private String nombre;
    private String apellido;
    private String fechaNacimiento; //datos de la persona

    public Persona(String nombre, String apellido, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    } //constructor

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }//nombre

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }//apellido

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }//fecha de nacimiento

}
