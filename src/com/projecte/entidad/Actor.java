package com.projecte.entidad;

import java.util.Iterator;

public class Actor extends Gestionable implements Comparable, Iterable {
    
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

    @Override
    public int compareTo(Object o) {
        //Este metodo se ejecuta si el objeto que le pasamos es un objeto no de tipo Actor
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }


    
}