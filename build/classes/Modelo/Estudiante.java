/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import BaseDeDatos.EstudianteBD;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Estudiante extends Persona{
    private EstudianteBD estudianteBD;
    public Estudiante() {
    }
    
    @Override
    public Estudiante consultarUsuario(){
      estudianteBD = new EstudianteBD();
        try {
            return estudianteBD.consultarEstudiante(inId);
        } catch (SQLException ex) {
          
        }
        return null;
    }

    @Override
    public Estudiante validarContraseniaUsuario() {
       estudianteBD = new EstudianteBD();
        try {
            return estudianteBD.validarContraseniaEstudiante(inId, stContrasenia);
        } catch (SQLException ex) {            
        }         
       return null;
    }
    
    public int ModificarContraseniaEstudiante() throws SQLException {
       estudianteBD = new EstudianteBD();   
       try {
            return estudianteBD.modificarContraseniaEstudiante(inId, stContrasenia);
        } catch (SQLException ex) {
           
        }
        return 0;
    }
    
}
