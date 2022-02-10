/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 * Clase que contiene las caractristicas que definen a un docente del sistema SIGED.
 * @author Cristian Alexis Alegria C.
 * @version 1.0.0
 * @since SIGED 1.0.0
 */
public class Docente extends Persona{

    private Plan clPlan;
    private  DocenteBD clDocenteBD;

    public Docente() {
    }   

    public Plan getClPlan() {
        return clPlan;
    }

    public void setClPlan(Plan clPlan) {
        this.clPlan = clPlan;
    }

    public DocenteBD getClDocenteBD() {
        return clDocenteBD;
    }

    public void setClDocenteBD(DocenteBD clDocenteBD) {
        this.clDocenteBD = clDocenteBD;
    }
    
    
    /**
    *Metodo encargado de buscar un docente y retorna su informacion.
    *@param inId int:Identificacion del docente a buscar.    
    *@return Objeto Docente:Contiene Nombre del docente e idplan al que pertenece o null sino lo encontro.
    *@since SIGED 1.0.0
    */
    public Docente buscarDocente(int inId){    
        clDocenteBD = new DocenteBD();
        return clDocenteBD.BuscarDocente(inId);
    }   
    
    /**
    *Metodo encargado de destruir el objeto clDocenteBD.
    *@since SIGED 1.0.0
    */
    public void destroyClDocenteBD(){
      clDocenteBD = null;
      System.gc();
    }
    
    @Override
    public Object consultarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object validarContraseniaUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
    
}
