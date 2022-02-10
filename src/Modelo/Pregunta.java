/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author User
 */
public class Pregunta {
    
    private int inIdPregunta;
    private String stPregunta;
    private Tipo clTipo;
    

    public Pregunta() {
    }

    public int getInIdPregunta() {
        return inIdPregunta;
    }

    public void setInIdPregunta(int inIdPregunta) {
        this.inIdPregunta = inIdPregunta;
    }

    public String getStPregunta() {
        return stPregunta;
    }

    public void setStPregunta(String stPregunta) {
        this.stPregunta = stPregunta;
    }

    public Tipo getClTipo() {
        return clTipo;
    }

    public void setClTipo(Tipo clTipo) {
        this.clTipo = clTipo;
    }
    
    
    
}
