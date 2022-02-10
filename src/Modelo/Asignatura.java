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
public class Asignatura {
    
    private String stCodigo;
    private String stNombre;

    public Asignatura() {
    }

    public Asignatura(String stCodigo, String stNombre) {
        this.stCodigo = stCodigo;
        this.stNombre = stNombre;
    }

    public String getStCodigo() {
        return stCodigo;
    }

    public void setStCodigo(String stCodigo) {
        this.stCodigo = stCodigo;
    }   

    public String getStNombre() {
        return stNombre;
    }

    public void setStNombre(String stNombre) {
        this.stNombre = stNombre;
    }
    
    
    
}
