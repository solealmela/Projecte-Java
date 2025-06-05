package com.projecte.entidad;
public class Director extends Gestionable implements Comparable<Director> {  
    static private int id;
    static private String archivo = "src/com/projecte/usuarios/" + id + "/archivoDirectores.llista";

    public Director(String nombre, String apellido, String fechaNacimiento) {
        super(nombre, apellido, fechaNacimiento);
        id++;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Director.id = id;
    }

    public int compareTo(Director director) {
        try {
            if (this.getId() > director.getId()) {
                System.out.println("Estás comparando lo mismo");
            } else {
                System.out.println("No son iguales");
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
