/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 * Clase que contiene las caractristicas que definen a un Administrador  del sistema SIGED.
 * @author Cristian Alexis Alegria C.
 * @version 1.0.0
 * @since SIGED 1.0.0
 */
public class Administrador extends Persona{
    private AdministradorBD clAdministradorBD;
    public Administrador() {
        clAdministradorBD = new AdministradorBD();  
    }

    public AdministradorBD getClAdministradorBD() {
        return clAdministradorBD;
    }

    public void setClAdministradorBD(AdministradorBD clAdministradorBD) {
        this.clAdministradorBD = clAdministradorBD;
    }
    
    

    /**
    *Metodo encargado de consultar un administrador y retorna su informacion.    
    *@return Administrador administrador:Contiene la identificacion del administrador o null sino lo encontro.
    *@since SIGED 1.0.0
    */
    @Override
    public Administrador consultarUsuario(){
        clAdministradorBD = new AdministradorBD();     
        
      return clAdministradorBD.consultarAdministrador(inId);
        
    }

    /**
    *Metodo encargado de validar que la contraseña del administrador sea correcta. 
    *@return Administrador administrador:Contiene la identificacion del administrador o Administrador null sino es correcta la contraseña.
    *@since SIGED 1.0.0
    */
    @Override
    public Administrador validarContraseniaUsuario() {
        clAdministradorBD = new AdministradorBD();  
       
       return clAdministradorBD.validarContraseniaAdministrador(inId, stContrasenia);
        
    }

    /**
    *Metodo encargado de modificar la contrasenia del Admnistrador.    
    *@return dato int:Retorna uno, si la modificacion de la contraseña fue exitosa o cero sino lo fue.
    *@since SIGED 1.0.0
    */
    public int ModificarContraseniaAdminitrador(){
       clAdministradorBD = new AdministradorBD();   
       
      return clAdministradorBD.modificarContraseniaAdministrador(inId, stContrasenia);
       
    }
    
    /**
    *Metodo encargado de destruir el objeto clAdministradorBD.
    *@since SIGED 1.0.0
    */
    public void destroyClAdministradorBD(){
      clAdministradorBD = null;
      System.gc();
    }
    
    
}
