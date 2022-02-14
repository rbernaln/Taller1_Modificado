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
public class ProductoMenu {
    private String nombre;
    private int precioBase;
    private int calorias;

    public ProductoMenu() {
    }

    public ProductoMenu(String nombre, int precioBase, int calorias) {
        this.nombre = nombre;
        this.precioBase = precioBase;
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
     * @return the precioBase
     */
    public int getPrecioBase() {
        return precioBase;
    }

    /**
     * @param precioBase the precioBase to set
     */
    public void setPrecioBase(int precioBase) {
        this.precioBase = precioBase;
    }
    
    
}
