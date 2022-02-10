/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Modelo.Docente;
import Modelo.Plan;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Clase que permite realizar diferentes consultas y actualizaciones a la base de datos de un docente.
 * @author Cristian Alexis Alegria C.
 * @version 1.0.0
 * @since SIGED 1.0.0
 */
public class DocenteBD {
    
    Conexion conexion;
    ResultSet resultSet;

    /**
    *Metodo constructor que inicializa la conexion. 
    *@since SIGED 1.0.0
    */
    public DocenteBD(){
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
    *Metodo encargado de buscar un docente y retorna su informacion.
    *@param inId int:Identificacion del docente a buscar.    
    *@return Docente docente:Contiene nombre del docente e idplan al que pertenece o null sino lo encontro. 
    *@since SIGED 1.0.0
    */
    public Docente BuscarDocente(int inId) {

        String stSql ="select d.nombre,p.idplan,d.iddocente\n" +
                        "from PLAN_DOCENTE pd\n" +
                        "inner join docente d\n" +
                        "on d.iddocente = pd.iddocente\n" +
                        "inner join plan p\n" +
                        "on p.idplan = pd.idplan\n" +
                        "where d.iddocente="+inId;
        //System.out.println(stSql);
        Docente clDocente =null;
        Plan clPlan;

        try{
          resultSet=conexion.consultar(stSql);
          if(resultSet.next()){
            clDocente = new Docente();
            clPlan = new Plan();
            clDocente.setStNombreCompleto(resultSet.getString("nombre")); 
            clPlan.setIdplan(Integer.parseInt(resultSet.getString("idplan")));
            clDocente.setClPlan(clPlan); 
            resultSet.close();
           }
     
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }
        conexion.cerrarConexion();
       
      return clDocente;
    }
    
}
