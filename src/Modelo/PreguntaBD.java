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
public class PreguntaBD {
    
    Conexion clConexion;
    ResultSet resultSet;

    /**
    *Metodo constructor que inicializa la conexion.  
    *@since SIGED 1.0.0
    */
    public PreguntaBD(){
       clConexion = new Conexion();       
    }

    public Conexion getClConexion() {
        return clConexion;
    }

    public void setClConexion(Conexion clConexion) {
        this.clConexion = clConexion;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

   
    
    
    
    public int registrarPregunta(String stPregunta,int inIdtipo){    
        String stSql = "INSERT INTO  PREGUNTA(QUESTION ,IDTIPO) values('"+stPregunta+"',"+inIdtipo+")returning IDPREGUNTA";
        int inPregunta= 0;
        
        try{
          resultSet = clConexion.consultar(stSql);
          if(resultSet.next()){
           inPregunta = Integer.parseInt(resultSet.getString("IDPREGUNTA"));
          }   
        }catch(Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }
        clConexion.cerrarConexion();
       
      return inPregunta;
    }
    
    
    public Vector<Pregunta> listarPreguntas(){
          String stSql = "select p.idpregunta,p.question,t.idtipo,t.nombre as nombretipo,c.idcaracteristica,c.nombre as nombrecaracteristica\n" +
                            "from caracteristica c\n" +
                            "inner join tipo t\n" +
                            "on c.idcaracteristica = t.idcaracteristica\n" +
                            "inner join pregunta p\n" +
                            "on p.idtipo = t.idtipo\n"+
                            "order by t.nombre asc";
          
          Vector<Pregunta>listaPreguntas = new Vector();
          Caracteristica clCaracteristica = null;
          Tipo clTipo = null;
          Pregunta clPregunta = null;
          
          
          try{
          resultSet=clConexion.consultar(stSql);
       
          while(resultSet.next()){
            clCaracteristica = new Caracteristica();
            clTipo = new Tipo();
            clPregunta = new Pregunta();
            
            clCaracteristica.setInIdCaracteristica(Integer.parseInt(resultSet.getString("idcaracteristica")));
            clCaracteristica.setStNombre(resultSet.getString("nombrecaracteristica"));
            
              
            clTipo.setInIdTipo(Integer.parseInt(resultSet.getString("idtipo")));
            clTipo.setStNombre(resultSet.getString("nombretipo")); 
            
            clTipo.setClCaracteristica(clCaracteristica);
            clPregunta.setClTipo(clTipo);
            
            clPregunta.setInIdPregunta(Integer.parseInt(resultSet.getString("idpregunta"))); 
            clPregunta.setStPregunta(resultSet.getString("question")); 
            
            listaPreguntas.add(clPregunta);
            
           }
          resultSet.close();
     
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }
        clConexion.cerrarConexion();

      return listaPreguntas;
    }
    
    public Vector<Pregunta> listarPreguntas(int inCaracteristica) {

        String stSql ="select p.idpregunta,p.question,t.idtipo,t.nombre nombretipo,c.nombre nombrecaracteristica\n" +
                        "from pregunta p\n" +
                        "inner join tipo t\n" +
                        "on p.idtipo = t.idtipo\n" +
                        "inner join caracteristica c\n" +
                        "on t.idcaracteristica = c.idcaracteristica\n" +
                        "where c.idcaracteristica = "+inCaracteristica+"\n"+
                        "order by t.nombre asc";
                
                       // "where c.idcaracteristica = "+inCaracteristica+" and t.idtipo = "+inTipo;
        
        Pregunta clPregunta = null;
        Tipo clTipo = null;
        Caracteristica clCaracteristica = null;
        Vector<Pregunta>listaObjPregunta = new Vector();
        try{
          resultSet=clConexion.consultar(stSql);
          while(resultSet.next()){ 
              clPregunta = new Pregunta();
              clTipo = new Tipo();
              clCaracteristica = new Caracteristica();
              
              clPregunta.setInIdPregunta(Integer.parseInt(resultSet.getString("idpregunta")));
              clPregunta.setStPregunta(resultSet.getString("question"));
              clTipo.setInIdTipo(Integer.parseInt(resultSet.getString("idtipo")));
              clTipo.setStNombre(resultSet.getString("nombretipo"));
              clCaracteristica.setInIdCaracteristica(inCaracteristica);
              clCaracteristica.setStNombre("nombrecaracteristica");
              
              clPregunta.setClTipo(clTipo);
              clTipo.setClCaracteristica(clCaracteristica);  
              listaObjPregunta.add(clPregunta);              
            
           }
          resultSet.close();
     
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }
        clConexion.cerrarConexion();        
       
     return listaObjPregunta;
    }
    
    public Vector<Tipo> listarTipos(int inCaracteristica) {

        String stSql ="select t.idtipo,t.nombre, count(t.idtipo)\n" +
                        "from pregunta p\n" +
                        "inner join tipo t\n" +
                        "on p.idtipo = t.idtipo\n" +
                        "inner join caracteristica c\n" +
                        "on t.idcaracteristica = c.idcaracteristica\n" +
                        "where c.idcaracteristica = "+inCaracteristica+"\n"+
                        "group by t.idtipo,t.nombre\n"+
                        "order by t.nombre asc";
                
                  
        
       
        Tipo clTipo = null;
       
        Vector<Tipo>listaObjTipo = new Vector();
        try{
          resultSet=clConexion.consultar(stSql);
          while(resultSet.next()){ 
             
              clTipo = new Tipo();              
            
              clTipo.setInIdTipo(Integer.parseInt(resultSet.getString("idtipo")));
              clTipo.setStNombre(resultSet.getString("nombre"));            
             
              listaObjTipo.add(clTipo);              
            
           }
          resultSet.close();
     
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }
        clConexion.cerrarConexion();        
       
     return listaObjTipo;
    }
    public int modificarPregunta(Pregunta clPregunta){
        int inResultado=0;
        System.out.println(clPregunta.getStPregunta());
        String sql ="UPDATE pregunta set question='"+clPregunta.getStPregunta()+"',idtipo="+clPregunta.getClTipo().getInIdTipo()+
                                                   " where idpregunta="+clPregunta.getInIdPregunta();
        try {
            inResultado = clConexion.ejecutarSql(sql);
        } catch (Exception e) {
        }       
        
     return  inResultado;
    }
    
     public int consultarPregunta(String stPregunta){

        String sql ="select idpregunta  from pregunta where upper(question) like upper('"+stPregunta+"')";
        
        int inIdPregunta = -1;

        try{
          resultSet=clConexion.consultar(sql);
          if(resultSet.next()){
            
                inIdPregunta =Integer.parseInt(resultSet.getString("idpregunta"));         
          }

        }catch(Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }
         return inIdPregunta;
    }
     
     
     
     
    
}
