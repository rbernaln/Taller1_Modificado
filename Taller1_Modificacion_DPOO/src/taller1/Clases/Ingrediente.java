/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1.Clases;

/**
 *
 * @author perzi
 */
public class Ingrediente {
    private String nombre;
    private int costoAdicional;
    private int calorias;

    public Ingrediente() {
    }

    public Ingrediente(String nombre, int costoAdicional, int calorias) {
        this.nombre = nombre;
        this.costoAdicional = costoAdicional;
        this.calorias = calorias;
    }
    

    /**
     * @return the calorias
     */
    public int getCalorias() {
        return calorias;
    }

    /**
     * @param calorias the calorias to set
     */
    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the costoAdicional
     */
    public int getCostoAdicional() {
        return costoAdicional;
    }

    /**
     * @param costoAdicional the costoAdicional to set
     */
    public void setCostoAdicional(int costoAdicional) {
        this.costoAdicional = costoAdicional;
    }
    
    
}
