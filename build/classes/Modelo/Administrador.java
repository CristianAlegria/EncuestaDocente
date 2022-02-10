/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import BaseDeDatos.AdministradorBD;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Administrador extends Persona{
    private AdministradorBD administradorBD;
    public Administrador() {
        administradorBD = new AdministradorBD();  
    }

    @Override
    public Administrador consultarUsuario(){
        administradorBD = new AdministradorBD();     
        try {
            return administradorBD.consultarAdministrador(inId);
        } catch (SQLException ex) {
            
        }
        return null;
    }

    @Override
    public Administrador validarContraseniaUsuario() {
        administradorBD = new AdministradorBD();  
        try {
            return administradorBD.validarContraseniaAdministrador(inId, stContrasenia);
        } catch (SQLException ex) {
           
        }
        return null;
    }

   
    public int ModificarContraseniaAdminitrador() throws SQLException {
       administradorBD = new AdministradorBD();   
       try {
            return administradorBD.modificarContraseniaAdministrador(inId, stContrasenia);
        } catch (SQLException ex) {
           
        }
        return 0;
    }
    
    
    
}
