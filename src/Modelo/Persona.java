/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 * Clase abstracta que espefica los datos basicos que debe tener cualquier usuario del sistema SIGED.
 * @author Cristian Alexis Alegria C.
 * @version 1.0.0
 * @since SIGED 1.0.0
 */
public  abstract class Persona{
    
      protected int inId;
      protected String stContrasenia;
      protected String stNombres;
      protected String stApellidos;
      protected String stNombreCompleto;      
      
    
    public Persona() {
    }

    public int getInId() {
        return inId;
    }

    public void setInId(int inId) {
        this.inId = inId;
    }

    public String getStContrasenia() {
        return stContrasenia;
    }

    public void setStContrasenia(String stContrasenia) {
        this.stContrasenia = stContrasenia;
    }

    public String getStNombres() {
        return stNombres;
    }

    public void setStNombres(String stNombres) {
        this.stNombres = stNombres;
    }

    public String getStApellidos() {
        return stApellidos;
    }

    public void setStApellidos(String stApellidos) {
        this.stApellidos = stApellidos;
    }

    public String getStNombreCompleto() {
        return stNombreCompleto;
    }

    public void setStNombreCompleto(String stNombreCompleto) {
        this.stNombreCompleto = stNombreCompleto;
    }   

     public abstract Object consultarUsuario();
     public abstract Object validarContraseniaUsuario();    
    
    
}
