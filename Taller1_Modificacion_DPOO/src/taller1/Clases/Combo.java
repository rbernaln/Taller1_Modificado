/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1.Clases;

import java.util.ArrayList;

/**
 *
 * @author perzi
 */
public class Combo {
    private double descuento;
    private String nombreCombo;
    private ArrayList<String> ingredientesCombo;
    private int calorias;

    public Combo() {
    }

    public Combo(double descuento, String nombreCombo, ArrayList<String> ingredientesCombo, int calorias) {
        this.descuento = descuento;
        this.nombreCombo = nombreCombo;
        this.ingredientesCombo = ingredientesCombo;
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
     * @return the ingredientesCombo
     */
    public ArrayList<String> getIngredientesCombo() {
        return ingredientesCombo;
    }

    /**
     * @param ingredientesCombo the ingredientesCombo to set
     */
    public void setIngredientesCombo(ArrayList<String> ingredientesCombo) {
        this.ingredientesCombo = ingredientesCombo;
    }
    
    

    /**
     * @return the descuento
     */
    public double getDescuento() {
        return descuento;
    }

    /**
     * @param descuento the descuento to set
     */
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    /**
     * @return the nombreCombo
     */
    public String getNombreCombo() {
        return nombreCombo;
    }

    /**
     * @param nombreCombo the nombreCombo to set
     */
    public void setNombreCombo(String nombreCombo) {
        this.nombreCombo = nombreCombo;
    }
    
    
}
