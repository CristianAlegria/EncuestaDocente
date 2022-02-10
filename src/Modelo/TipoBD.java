/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class TipoBD {
    
    Conexion conexion;
    ResultSet resultSet;

    /**
    *Metodo constructor que inicializa la conexion.  
    *@since SIGED 1.0.0
    */
    public TipoBD(){
       conexion = new Conexion();       
    }

    public Conexion getConexion() {
        return conexion;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
    
    public Vector <Caracteristica> listarCaracteristicas(){    
         
        String stSql ="SELECT * FROM  CARACTERISTICA";
        
        Caracteristica clCaracteristica = null;
        Vector<Caracteristica> listaCaracteristica = new Vector();

        try{
          resultSet=conexion.consultar(stSql);
       
          while(resultSet.next()){
            clCaracteristica = new Caracteristica();
            clCaracteristica.setInIdCaracteristica(Integer.parseInt(resultSet.getString("idcaracteristica")));   
            clCaracteristica.setStNombre(resultSet.getString("nombre"));   
            listaCaracteristica.add(clCaracteristica);
            
           }
          resultSet.close();
     
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }
        conexion.cerrarConexion();
       
      return listaCaracteristica;
    }
    
    
    public int registrarTipo(String stNombre, int inIdCaracteristica){    
        String stSql = "INSERT INTO  TIPO(NOMBRE,IDCARACTERISTICA ) values('"+stNombre+"',"+inIdCaracteristica+")returning idtipo";
        int inResultado = 0;
        
        try{
          resultSet = conexion.consultar(stSql);
          
          if(resultSet.next()){
             inResultado = Integer.parseInt(resultSet.getString("idtipo"));
          }
          resultSet.close();
     
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }
        conexion.cerrarConexion();
      return inResultado;
    }
    
    public int modificarTipo(Tipo clTipo){
        int inResultado=0;
        String sql ="UPDATE tipo set nombre='"+clTipo.getStNombre()+"',idcaracteristica="+clTipo.getClCaracteristica().getInIdCaracteristica()+
                                            " where idtipo="+clTipo.getInIdTipo();
        try {
            inResultado = conexion.ejecutarSql(sql);
            
        }catch (Exception e) { }       
        conexion.cerrarConexion();
     return  inResultado;
    }
    
    
    public Tipo consultarTipo(String stTipo){

        Tipo clTipo = null;
        Caracteristica clCaracteristica = null;
        String sql ="select t.idtipo,t.nombre,c.idcaracteristica,c.nombre nombrecaracteristica "+
                    "from tipo t "+
                    "inner join caracteristica c "+
                    "on c.idcaracteristica = t.idcaracteristica "+                
                    "where t.nombre like '%"+stTipo+"%'";
        
      

        try{
          resultSet=conexion.consultar(sql);
          if(resultSet.next()){
              clTipo = new Tipo();
              clCaracteristica = new Caracteristica();
              clTipo.setInIdTipo(Integer.parseInt( resultSet.getString("idtipo")));   
              clTipo.setStNombre(resultSet.getString("nombre"));  
              clCaracteristica.setInIdCaracteristica(Integer.parseInt( resultSet.getString("idcaracteristica")));
              clCaracteristica.setStNombre(resultSet.getString("nombrecaracteristica"));  
              clTipo.setClCaracteristica(clCaracteristica);
          }

        }catch(Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }
         return clTipo;
    }
    
    public Vector<Tipo> listarTipo(int inCaracteristica){

        String sql ="select t.idtipo,t.nombre nombretipo,c.nombre nombrecaract\n" +
                    "from tipo t\n" +
                    "inner join caracteristica c\n" +
                    "on t.idcaracteristica = c.idcaracteristica\n" +
                    "where c.idcaracteristica = "+inCaracteristica;
        
        Vector<Tipo>listaObjTipo = new Vector();
        Tipo clTipo = null;
        Caracteristica clCaracteristica = null;        

        try{
          resultSet=conexion.consultar(sql);
          while(resultSet.next()){
              clTipo = new Tipo();
              clCaracteristica = new Caracteristica();
              clTipo.setInIdTipo(Integer.parseInt( resultSet.getString("idtipo")));     
              clTipo.setStNombre(resultSet.getString("nombretipo"));   
              clCaracteristica.setInIdCaracteristica(inCaracteristica);
              clCaracteristica.setStNombre(resultSet.getString("nombrecaract"));
              clTipo.setClCaracteristica(clCaracteristica);
              listaObjTipo.add(clTipo);
          }

        }catch(Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }
         return listaObjTipo;
    }
     
}
