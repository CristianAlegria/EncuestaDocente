/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * Clase que contiene las caractristicas  que permiten conectarse con la base de datos.
 * @author Cristian Alexis Alegria C.
 * @version 1.0.0
 * @since SIGED 1.0.0
 */
public class Conexion {
     static final  String ST_CONTROLADOR = "org.postgresql.Driver";
     static final  String ST_URL_BASEDATOS = "jdbc:postgresql://localhost:5432/ProyectoEncuestaDocentePracticasDePruebas";//Formato (jdbc:postgresql//nombreHost:numeroPuerto/nombreDeBaseDeDatos
     static final  String ST_NOMBRE_USUARIO = "postgres";
     static final  String ST_CONTRASENIA = "12345ca9";
     
     private Statement instruccion;
     private ResultSet conjuntoDeResultados;
     private Connection conexion;

     
     /**
     * Constructor Conexion que permite conectarse con la base de datos.  
     * @since SIGED 1.0.0
     */
    public Conexion() {
        try {
              Class.forName(ST_CONTROLADOR);
              conexion = DriverManager.getConnection(ST_URL_BASEDATOS, ST_NOMBRE_USUARIO, ST_CONTRASENIA); 
              
              instruccion = conexion.createStatement();
              System.out.println("Conexion exitosa a esquema ProyectoEncuesta"); 
              
        } catch (Exception e) {
              System.out.println("error en la conexion");
        }      
    }
    
    /**
     * Metodo que permite realizar consultas a la base de datos.
     * @param stSql String:Sentencia sql a ejecutar.
     * @return ResultSet conjuntoDeResultados:Contiene la informacion de la consulta.
     * @since SIGED 1.0.0
     */
    public ResultSet consultar(String stSql){
        //JOptionPane.showMessageDialog(null,stSql);
        try {
            conjuntoDeResultados = instruccion.executeQuery(stSql);
        } catch (SQLException  e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }        
        
      return conjuntoDeResultados;
    }
    
    /**
     * Metodo que permite actualizar,eliminar e insertar: Registros o tablas.
     * @param stSql String:Sentencia sql a ejecutar.
     * @return int inResultado:Mayor o igual a cero si fue exitosa la ejecucion, -1 si fue lo contrario???
     * @since SIGED 1.0.0
     */
    public int  ejecutarSql(String stSql){
        int inResultado= 0;
       // JOptionPane.showMessageDialog(null,stSql);
        try {
            inResultado = instruccion.executeUpdate(stSql);
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, e.getMessage());
             inResultado =-1;
        }
         
      return inResultado;
    }
    
    /**
     * Metodo encargado de cerrar la conexion a la base de datos.
     *@since SIGED 1.0.0
     */  
     public void cerrarConexion() {
	  	try {
		   conexion.close();
		}catch (Exception  e) {
		        JOptionPane.showMessageDialog(null,"Ha ocurrido un error al intentar cerrar la conexion con postgres. Error:" + e.getMessage());                                   
		}
	}
}
