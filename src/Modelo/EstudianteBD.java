/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;


import Modelo.Estudiante;
import Modelo.Plan;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Clase que permite realizar diferentes consultas y actualizaciones a la base de datos de un estudiante.
 * @author Cristian Alexis Alegria C.
 * @version 1.0.0
 * @since SIGED 1.0.0
 */
public class EstudianteBD {
    
    private Conexion conexion;
    private ResultSet resultSet;

    /**
    *Metodo constructor que inicializa la conexion.  
    *@since SIGED 1.0.0
    */
    public EstudianteBD(){
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
    *Metodo encargado de consultar un estudiante y retorna su informacion.
    *@param inId int:Identificacion del estudiante.
    *@return Estudiante estudiante:Contiene la identificacion del estudiante o null sino lo encontro. 
    *@since SIGED 1.0.0
    */
    public Estudiante consultarEstudiante(int inId){

        String stSql ="select * from estudiante where idestudiante ="+inId;
        //System.out.println(stSql);
        Estudiante estudiante =null;

        try{
          resultSet=conexion.consultar(stSql);
          if(resultSet.next()){
            estudiante = new Estudiante();
            estudiante.setInId(Integer.parseInt(resultSet.getString("idestudiante")));    
            resultSet.close();
            
           }
     
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }
        conexion.cerrarConexion();
       
     return estudiante;
    }
    
    
   
    /**
    *Metodo encargado de buscar un Estudiante y retorna su informacion.
    *@param inId int:Identificacion del estudiante a buscar.    
    *@return Estudiante estudiante:Contiene nombre del estudiante e idplan al que pertenece o null sino lo encontro. 
    *@since SIGED 1.0.0
    */
    public Estudiante BuscarEstudiante(int inId) {

        String stSql ="select e.nombre,pe.idplan\n" +
                        "from estudiante_plan ep\n" +
                        "inner join estudiante e\n" +
                        "on ep.idestudiante = e.idestudiante\n" +
                        "inner join plan pe\n" +
                        "on pe.idplan =ep.idplan\n" +
                        "where e.idestudiante="+inId;
        //System.out.println(stSql);
        Estudiante clEstudiante=null;
        Plan clPlan = null;

        try{
          resultSet=conexion.consultar(stSql);
          if(resultSet.next()){       
              
            clEstudiante = new Estudiante();
            clPlan = new Plan();
            clEstudiante.setStNombreCompleto(resultSet.getString("nombre")); 
            clPlan.setIdplan(Integer.parseInt(resultSet.getString("idplan")));
            clEstudiante.setClPlan(clPlan);
            resultSet.close();
            
           }
     
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }
        conexion.cerrarConexion();
        
       
     return clEstudiante;
    }
    
    /**
    *Metodo encargado de validar que la contraseña del estudiante sea correcta.    
    *@param inId int:Identificacion del estudiante.
    *@param stContrasenia String:Contraseña actual del estudiante.
    *@return Estudiante estudiante:Contiene la identificacion del estudiante o estudiante null sino es correcta la contraseña.    
    *@since SIGED 1.0.0
    */
    
    public Estudiante validarContraseniaEstudiante(int inId,String stContrasenia){

        String sql ="select * from estudiante where idestudiante ="+inId+" and contrasenia like "+"'"+stContrasenia+"'";
        Estudiante clEstudiante = null;

        try{
          resultSet=conexion.consultar(sql);
          if(resultSet.next()){
              clEstudiante = new Estudiante();
              clEstudiante .setInId(inId);
              resultSet.close();
           }
     
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }
        conexion.cerrarConexion();        
         return clEstudiante;
    }
    
    /**
    *Metodo encargado de modificar la contraseña del estudiante.
    *@param inId int:Identificacion del estudiante.
    *@param stContrasenia String:Contraseña  nueva  que se va arremplazar por la actual.
    *@return int dato:Uno si la modificacion fue exitosa, cero si fue lo contrario.
    *@since SIGED 1.0.0
    */
    
    public int modificarContraseniaEstudiante(int inId, String stContrasenia){

        String stSql ="update estudiante set contrasenia='"+stContrasenia+"' where idestudiante="+inId;        
        
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
