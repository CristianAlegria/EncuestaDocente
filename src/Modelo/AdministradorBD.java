/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Modelo.Administrador;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Clase que permite realizar diferentes consultas y actualizaciones a la base de datos de  un administrador.
 * @author Cristian Alexis Alegria C.
 * @version 1.0.0
 * @since SIGED 1.0.0
 */
public class AdministradorBD {
    Conexion conexion;
    ResultSet resultSet;

    /**
    *Metodo constructor que inicializa la conexion.  
    *@since SIGED 1.0.0
    */
    public AdministradorBD(){
       conexion = new Conexion();      
       
    }

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
    
    
    
    /**
    *Metodo encargado de consultar un administrador y retorna su informacion.
    *@param inId int:Identificacion del adminitrador.
    *@return Administrador administrador:Contiene la identificacion del administrador o null sino lo encontro. 
    *@since SIGED 1.0.0
    */
    public Administrador consultarAdministrador(int inId){

        String stSql ="select * from administrador where idadministrador ="+inId;
        
        Administrador administrador =null;

        try{
          resultSet=conexion.consultar(stSql);
       
          if(resultSet.next()){
            administrador = new Administrador();
            administrador.setInId(Integer.parseInt(resultSet.getString("idadministrador")));   
            resultSet.close();
           }
     
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }
        conexion.cerrarConexion();
       
      return administrador;
    }
    
    /**
    *Metodo encargado de validar que la contraseña del administrador sea correcta.     
    *@param inId int:Identificacion del administrador.
    *@param stContrasenia String:Contraseña actual del administrador.
    *@return Administrador administrador:Contiene la identificacion del administrador o administrador null sino es correcta la contraseña.    
    *@since SIGED 1.0.0
    */
    
    public Administrador validarContraseniaAdministrador(int inId, String stContrasenia){

        String stSql ="select nombres,apellidos from administrador where idadministrador ="+inId+" and contrasenia like "+"'"+stContrasenia+"'";        
        
        Administrador clAdministrador =null;

        try{
          resultSet=conexion.consultar(stSql);
          if(resultSet.next()){
              clAdministrador = new Administrador();
              clAdministrador.setInId(inId);
              clAdministrador.setStNombres(resultSet.getString("nombres"));
              clAdministrador.setStApellidos(resultSet.getString("apellidos"));
              resultSet.close();
           }
     
        
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }
        conexion.cerrarConexion();
        
      return clAdministrador;
    }
    
    /**
    *Metodo encargado de modificar la contraseña del adminsitrador.  
    *@param inId int:Identificacion del administrador.
    *@param stContrasenia String:Contraseña  nueva  que se va arremplazar por la actual.
    *@return int dato:Uno si la modificacion fue exitosa, cero si fue lo contrario.
    *@since SIGED 1.0.0
    */
    
     public int modificarContraseniaAdministrador(int inId, String stContrasenia){

        String stSql ="update administrador set contrasenia='"+stContrasenia+"' where idadministrador="+inId;        
        
        int inResultado =0;

        try{
          inResultado=conexion.ejecutarSql(stSql); 
     
         
        }catch(Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }
        conexion.cerrarConexion();        
      return inResultado;
    }
     
}
