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
public  abstract class Persona {

    
      protected int inId;
      protected String stContrasenia;
      protected String stNombres;
      protected String stApellidos;
      
      
    
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

    

     public abstract Object consultarUsuario();
     public abstract Object validarContraseniaUsuario();
     
     
    
    
}
