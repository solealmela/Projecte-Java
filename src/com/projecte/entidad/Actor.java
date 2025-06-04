package com.projecte.entidad;

public class Actor extends Gestionable implements Comparable<Actor> {

    static private int id;
    static private String archivo = "src/com/projecte/usuarios/"+id+"/archivoActores.llista";


    public Actor(String nombre, String apellido, String fechaNacimiento) {
        super(nombre, apellido, fechaNacimiento);
        id++;
    }

    public void crearActor(){

    }
        public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Actor.id = id;
    }

    public int compareTo(Actor o) {
        try {
            if (this.getId()>o.getId()) {
                System.out.println("Estás comparando lo mismo");
            }else{
                System.out.println("No son iguales");;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}