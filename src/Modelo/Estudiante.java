/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 * Clase que contiene las caractristicas que definen a un Estudiante del sistema SIGED.
 * @author Cristian Alexis Alegria C.
 * @version 1.0.0
 * @since SIGED 1.0.0
 */
public class Estudiante extends Persona{
    private EstudianteBD clEstudianteBD;
    private Plan clPlan;
    
    public Estudiante() {
    }

    public Plan getClPlan() {
        return clPlan;
    }

    public void setClPlan(Plan clPlan) {
        this.clPlan = clPlan;
    }

    public EstudianteBD getClEstudianteBD() {
        return clEstudianteBD;
    }

    public void setClEstudianteBD(EstudianteBD clEstudianteBD) {
        this.clEstudianteBD = clEstudianteBD;
    }
    
    
    /**
    *Metodo encargado de buscar un Estudiante y retorna su informacion.
    *@param inId int:Identificacion del estudiante a buscar.    
    *@return Estudiante estudiante:Contiene nombre del estudiante e idplan al que pertenece.
    *@since SIGED 1.0.0
    */
    
    public Estudiante buscarEstudiante(int inId){
      clEstudianteBD = new EstudianteBD();
      return clEstudianteBD.BuscarEstudiante(inId);
    }
    
    /**
    *Metodo encargado de consultar un estudiante y retorna su informacion.      
    *@return Estudiante estudiante:Contiene la identificacion del estudiante o estudiante null sino lo encontro. 
    *@since SIGED 1.0.0
    */
    @Override
    public Estudiante consultarUsuario(){
      clEstudianteBD = new EstudianteBD();
      
      return clEstudianteBD.consultarEstudiante(inId);      
    }

    /**
    *Metodo encargado de validar que la contraseña del estudiante sea correcta.    
    *@return Estudiante estudiante:Contiene la identificacion del estudiante u  estudiante null sino es correcta la contraseña.
    *@since SIGED 1.0.0
    */
    @Override
    public Estudiante validarContraseniaUsuario() {
       clEstudianteBD = new EstudianteBD();       
        return clEstudianteBD.validarContraseniaEstudiante(inId, stContrasenia);
        
    }
    
    /**
    *Metodo encargado de modificar la contrasenia del estudiante.    
    *@return dato int:Retorna uno, si la modificacion de la contraseña fue exitosa o cero sino lo fue.
    *@since SIGED 1.0.0
    */
    public int ModificarContraseniaEstudiante(){
       clEstudianteBD = new EstudianteBD();   
      
       return clEstudianteBD.modificarContraseniaEstudiante(inId, stContrasenia);       
    }
    
    /**
    *Metodo encargado de destruir el objeto clEstudianteBD.
    *@since SIGED 1.0.0
    */
     public void destroyClEstudianteBD(){
      clEstudianteBD = null;
      System.gc();
    }
    
}
