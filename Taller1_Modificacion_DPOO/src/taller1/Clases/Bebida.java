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
public class Bebida {
    private String nombreBebida;
    private int precioBebida;
    private int calorias;

    public Bebida() {
    }

    public Bebida(String nombreBebida, int precioBebida, int calorias) {
        this.nombreBebida = nombreBebida;
        this.precioBebida = precioBebida;
        this.calorias = calorias;
    }
    

    /**
     * @return the nombreBebida
     */
    public String getNombreBebida() {
        return nombreBebida;
    }

    /**
     * @param nombreBebida the nombreBebida to set
     */
    public void setNombreBebida(String nombreBebida) {
        this.nombreBebida = nombreBebida;
    }

    /**
     * @return the precioBebida
     */
    public int getPrecioBebida() {
        return precioBebida;
    }

    /**
     * @param precioBebida the precioBebida to set
     */
    public void setPrecioBebida(int precioBebida) {
        this.precioBebida = precioBebida;
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
    
    
}
