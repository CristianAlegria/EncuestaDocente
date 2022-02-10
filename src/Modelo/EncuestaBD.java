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
public class EncuestaBD {
    
     
    private Conexion clConexion;
    private ResultSet resultSet;

   
    public EncuestaBD(){
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
    
  public int registrarEncuesta(Encuesta encuesta){
      /*  String stSql ="INSERT INTO encuesta (idencuesta,fecha,periodo)"
                    + " values(((SELECT MAX(idencuesta) FROM encuesta )+1),'"+encuesta.getStFecha()+"','"+encuesta.getStPeriodo()+"')returning idencuesta"; */  
        
      String stSql ="INSERT INTO encuesta (fecha,periodo,estado)"
                    + " values('"+encuesta.getStFecha()+"','"+encuesta.getStPeriodo()+"','false')returning idencuesta";   
        int inEncuesta = 0;
        System.out.println(stSql);
        try{
           resultSet = clConexion.consultar(stSql);
           if(resultSet.next()){
             inEncuesta = Integer.parseInt(resultSet.getString("idencuesta"));
           }
         
          
          
        }catch(Exception e){
         JOptionPane.showMessageDialog(null, e.getMessage());
        }       
     return inEncuesta;
    }
  
  public int ModificarEncuesta(Encuesta clEncuesta){
     
      String stSql ="UPDATE encuesta set fecha = '"+clEncuesta.getStFecha()+"',periodo="+clEncuesta.getStPeriodo()+"' where idencuesta = "+clEncuesta.getInCodigo();
                   
        int inEncuesta = 0;
        try{
          inEncuesta = clConexion.ejecutarSql(stSql);    
        }catch(Exception e){
         JOptionPane.showMessageDialog(null, e.getMessage());
        }       
     return inEncuesta;
    }
    
   public Vector<Integer> registrarEncuestaAsignatura(Encuesta encuesta){
      int inContador = 0;
      Vector<Integer>listaInEncuestaAsignatura = new Vector();
      System.out.println("Tamaño al insertar: "+encuesta.getListaObjAsignatura().size());
       for (int i = 0; i < encuesta.getListaObjAsignatura().size(); i++) {          
      
            /*String stSql ="INSERT INTO ENCUESTA_ASIGNATURA (IDENCUESTA_ASIGNATURA,IDENCUESTA,IDASIGNATURA)"
                        + " values(((SELECT MAX(IDENCUESTA_ASIGNATURA) FROM ENCUESTA_ASIGNATURA )+1),"+encuesta.getInCodigo()+",'"+encuesta.getListaObjAsignatura().get(i).getStCodigo()+"')returning IDENCUESTA_ASIGNATURA"; */  
            String stSql ="INSERT INTO ENCUESTA_ASIGNATURA (IDENCUESTA,IDASIGNATURA)"
                        + " values("+encuesta.getInCodigo()+",'"+encuesta.getListaObjAsignatura().get(i).getStCodigo()+"')returning IDENCUESTA_ASIGNATURA";   
          
            System.out.println(stSql);
            try{
                 resultSet = clConexion.consultar(stSql);     
                 if(resultSet.next()){
                    listaInEncuestaAsignatura.add(Integer.parseInt(resultSet.getString("IDENCUESTA_ASIGNATURA")));
                 }
                         

            }catch(Exception e){
             JOptionPane.showMessageDialog(null, e.getMessage());
            }
       }
     return listaInEncuestaAsignatura;
    }
  
    public int  eliminarEncuestaAsignatura(Encuesta clEncuesta){
      int inContador = 0;  
      System.out.println(" Delete clEncuesta.getListaObjAsignatura().size();"+ clEncuesta.getListaObjAsignatura().size());
       for (int i = 0; i < clEncuesta.getListaObjAsignatura().size(); i++) {    
            
           String stSql ="DELETE FROM ENCUESTA_ASIGNATURA  where IDENCUESTA_ASIGNATURA='"+clEncuesta.getListaInEncuestaAsignatura().get(i)+"' and idencuesta="+clEncuesta.getInCodigo();
                     
           System.out.println(stSql);
            try{
                 inContador+= clConexion.ejecutarSql(stSql);                        

            }catch(Exception e){
             JOptionPane.showMessageDialog(null, e.getMessage());
            }
       }
     return inContador;
    }
  
  public int  registrarFormulario(Encuesta encuesta,Vector<Integer>listaInEncuestaAsignatura){
       int inResultado = 0;
       System.out.println("encuesta.getListaObjPregunta().size() BD:"+encuesta.getListaObjPregunta().size());
        System.out.println("listaInEncuestaAsignatura.size() BD:"+listaInEncuestaAsignatura.size());
       for (int i = 0; i < listaInEncuestaAsignatura.size(); i++) { 
            for (int j = 0; j <encuesta.getListaObjPregunta().size(); j++) {   
      
                String stSql ="INSERT INTO FORMULARIO(IDENCUESTA_ASIGNATURA,IDPREGUNTA)"
                            + " values("+listaInEncuestaAsignatura.get(i)+","+encuesta.getListaObjPregunta().get(j).getInIdPregunta()+")";  

                try{
                  
                   System.out.println(stSql);

                  inResultado+=clConexion.ejecutarSql(stSql);

                }catch(Exception e){
                 JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
       }
       
     return inResultado;
    }
  
  public int eliminarEncuestaAsignaturaFormulario(Encuesta clEncuesta){
       int inResultado = 0;
       
       for (int i = 0; i < clEncuesta.getListaInEncuestaAsignatura().size(); i++) {     
      
                String stSql ="DELETE FROM formulario  where IDENCUESTA_ASIGNATURA="+clEncuesta.getListaInEncuestaAsignatura().get(i);

                try{
                  
                   System.out.println(stSql);

                  inResultado+=clConexion.ejecutarSql(stSql);

                }catch(Exception e){
                 JOptionPane.showMessageDialog(null, e.getMessage());
                }
            
       }
       eliminarEncuestaAsignatura(clEncuesta);
     return inResultado;
    }
  
  public int eliminarPreguntaFormulario(Encuesta clEncuesta){
       int inResultado = 0;
       
       for (int i = 0; i < clEncuesta.getListaObjPregunta().size(); i++) { 
                for (int j = 0; j < clEncuesta.getListaInEncuestaAsignatura().size(); j++) {           
      
                    String stSql ="DELETE FROM formulario  where IDPREGUNTA="+clEncuesta.getListaObjPregunta().get(i).getInIdPregunta()+" and IDENCUESTA_ASIGNATURA="+clEncuesta.getListaInEncuestaAsignatura().get(j);

                    try{

                       System.out.println(stSql);

                      inResultado+=clConexion.ejecutarSql(stSql);

                    }catch(Exception e){
                     JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }           
       }
      
     return inResultado;
    }
    

   
    public Vector<Asignatura> listarAsignaturas(){
        Vector <Asignatura>listaObjAsignatura= new  Vector();
         Asignatura clAsignatura =null;
         String sql ="select * from asignatura order by nombre asc";      
            

        try{
          resultSet=clConexion.consultar(sql);
          while(resultSet.next()){
            clAsignatura = new Asignatura();
            clAsignatura.setStCodigo(resultSet.getString("idasignatura"));
            clAsignatura.setStNombre(resultSet.getString("nombre"));
            
            listaObjAsignatura.add(clAsignatura);                 
          }
          resultSet.close();

        }catch(Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }    
         return listaObjAsignatura;     
     }
    
    public Vector<Encuesta> listarEncuestas(int inIdCaracteristica){
        Vector <Encuesta>listaObjEncuentas= new  Vector();
         Encuesta clEncuesta = null;
         String sql ="select e.idencuesta,e.periodo,e.fecha,e.estado, count(e.idencuesta)\n"+                      
                        "from formulario f\n" +
                        "inner join ENCUESTA_ASIGNATURA encA\n" +
                        "on f.IDENCUESTA_ASIGNATURA = encA.IDENCUESTA_ASIGNATURA\n" +
                        "inner join ENCUESTA e\n" +
                        "on e.idencuesta = encA.idencuesta\n" +
                        "inner join pregunta p\n" +
                        "on f.idpregunta=p.idpregunta\n" +
                        "inner join tipo t\n" +
                        "on t.idtipo = p.idtipo\n" +
                        "inner join caracteristica c\n" +
                        "on c.idcaracteristica= t.idcaracteristica\n"+                 
                        "inner join asignatura a\n" +
                        "on a.idasignatura=encA.idasignatura\n" +
                        "where c.idcaracteristica="+inIdCaracteristica+"\n" +
                        "group by e.idencuesta,e.periodo,e.fecha,e.estado\n" +
                        "order by e.fecha desc ";   
       

        try{
          resultSet=clConexion.consultar(sql);
          while(resultSet.next()){
            clEncuesta = new Encuesta();
            clEncuesta.setInCodigo(Integer.parseInt(resultSet.getString("idencuesta")));
            clEncuesta.setStPeriodo(resultSet.getString("periodo"));
            if(resultSet.getString("estado").equals("t")){
                 clEncuesta.setBlEstado(true);
            }else{
               clEncuesta.setBlEstado(false);
            }
          
           System.out.println("Estado resulset:"+  clEncuesta.isBlEstado());
           clEncuesta.setStFecha(resultSet.getString("fecha"));
            
            listaObjEncuentas.add(clEncuesta);                 
          }
          resultSet.close();

        }catch(Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }    
         return listaObjEncuentas;     
    }
    
    public Encuesta consultarFormulario(int inIdEncuesta,int inIdCaracteristica){
        Encuesta clEncuesta = consultarPreguntasAsignaturas(inIdEncuesta, inIdCaracteristica);    
        return clEncuesta;
    
    }
      
     public Encuesta consultarPreguntasAsignaturas(int inIdEncuesta,int inIdCaracteristica){
        Encuesta clEncuesta = null;
        Pregunta clPregunta = null;
        Tipo clTipo = null;
        Caracteristica clCaracteristica = null;
         
        int incontador =0;
        String sql ="select p.idpregunta, p.question,t.idtipo,t.nombre as nombretipo,\n" +
                        "e.idencuesta,e.periodo,e.fecha,c.idcaracteristica,c.nombre as nombrecarac, count(*)\n" +
                        "from formulario f\n" +
                        "inner join ENCUESTA_ASIGNATURA encA\n" +
                        "on f.IDENCUESTA_ASIGNATURA = encA.IDENCUESTA_ASIGNATURA\n" +
                        "inner join ENCUESTA e\n" +
                        "on e.idencuesta = encA.idencuesta\n" +
                        "inner join pregunta p\n" +
                        "on f.idpregunta=p.idpregunta\n" +
                        "inner join tipo t\n" +
                        "on t.idtipo = p.idtipo\n" +
                        "inner join caracteristica c\n" +
                        "on c.idcaracteristica= t.idcaracteristica\n" +
                        "inner join asignatura a\n" +
                        "on a.idasignatura=encA.idasignatura\n" +
                        "where e.idencuesta = "+inIdEncuesta+" and c.idcaracteristica="+inIdCaracteristica+"\n" +
                        "group by p.idpregunta, p.question,t.idtipo,t.nombre,\n" +
                        "e.idencuesta,e.periodo,e.fecha,c.idcaracteristica,c.nombre\n" +
                        "order by t.nombre asc";
          
        try{
          resultSet=clConexion.consultar(sql);
          
        
        while(resultSet.next()){
            
            if(incontador==0){
              clEncuesta = new Encuesta();
            }
            incontador++;           
            clPregunta = new Pregunta();
            clTipo = new Tipo();
            clCaracteristica = new Caracteristica();
            
            clEncuesta.setInCodigo(Integer.parseInt(resultSet.getString("idencuesta")));
            clEncuesta.setStPeriodo(resultSet.getString("periodo"));
            clEncuesta.setStFecha(resultSet.getString("fecha"));          
            
            
            clPregunta.setInIdPregunta(Integer.parseInt(resultSet.getString("idpregunta")));
            clPregunta.setStPregunta(resultSet.getString("question"));
            
            clTipo.setInIdTipo(Integer.parseInt(resultSet.getString("idtipo")));
            clTipo.setStNombre(resultSet.getString("nombretipo"));
            
            clCaracteristica.setInIdCaracteristica(Integer.parseInt(resultSet.getString("idcaracteristica")));
            clCaracteristica.setStNombre(resultSet.getString("nombrecarac"));
            
            clTipo.setClCaracteristica(clCaracteristica);
            clPregunta.setClTipo(clTipo);            
           
            clEncuesta.agregarPreguntas(clPregunta);
        }
          resultSet.close();

        }catch(Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }  
        return consultarAsignaturas(inIdEncuesta, inIdCaracteristica, clEncuesta);
     }
     
     public Encuesta consultarAsignaturas(int inIdEncuesta,int inIdCaracteristica,Encuesta clEncuesta){      
         
         Asignatura clAsignatura = null;
                  
         int incontador =0;
         
         String sql ="select encA.IDENCUESTA_ASIGNATURA, a.idasignatura, a.nombre as nombreasignatura,\n" +
                        "e.idencuesta,e.periodo,e.fecha,c.idcaracteristica,c.nombre as nombrecarac,e.idencuesta ,count(p.idpregunta)\n" +
                        "from formulario f\n" +
                        "inner join ENCUESTA_ASIGNATURA encA\n" +
                        "on f.IDENCUESTA_ASIGNATURA = encA.IDENCUESTA_ASIGNATURA\n" +
                        "inner join ENCUESTA e\n" +
                        "on e.idencuesta = encA.idencuesta\n" +
                        "inner join pregunta p\n" +
                        "on f.idpregunta=p.idpregunta\n" +
                        "inner join tipo t\n" +
                        "on t.idtipo = p.idtipo\n" +
                        "inner join caracteristica c\n" +
                        "on c.idcaracteristica= t.idcaracteristica\n" +
                        "inner join asignatura a\n" +
                        "on a.idasignatura=encA.idasignatura\n" +
                        "where e.idencuesta = "+inIdEncuesta+" and c.idcaracteristica="+inIdCaracteristica+"\n" +
                        "group by encA.IDENCUESTA_ASIGNATURA,a.idasignatura, a.nombre,e.idencuesta,e.periodo,e.fecha,c.idcaracteristica,c.nombre,e.idencuesta\n" +
                        "order by a.nombre asc";       

        try{
          resultSet=clConexion.consultar(sql);
          
        
          while(resultSet.next()){            
            
            clAsignatura = new Asignatura();           
           
            clEncuesta.agregarInEncuestaAsignatura(Integer.parseInt(resultSet.getString("IDENCUESTA_ASIGNATURA")));          
            
            clEncuesta.setInCodigo(Integer.parseInt(resultSet.getString("idencuesta")));
            clAsignatura.setStCodigo(resultSet.getString("idasignatura"));
            clAsignatura.setStNombre(resultSet.getString("nombreasignatura"));            
            
            clEncuesta.agregarAsignaturas(clAsignatura);
            
          }
          resultSet.close();

        }catch(Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }    
         return clEncuesta;     
     }
     
      public Encuesta consultarAsignaturas(int inIdEncuesta,int inIdCaracteristica){      
         
         Asignatura clAsignatura = null;
         Encuesta clEncuesta = new Encuesta();
         Vector<Encuesta>listaObjEncuesta = new Vector();               
       
         
         String sql ="select encA.IDENCUESTA_ASIGNATURA, a.idasignatura, a.nombre as nombreasignatura,\n" +
                        "e.idencuesta,e.periodo,e.fecha,e.estado,c.idcaracteristica,c.nombre as nombrecarac,e.idencuesta ,count(p.idpregunta)\n" +
                        "from formulario f\n" +
                        "inner join ENCUESTA_ASIGNATURA encA\n" +
                        "on f.IDENCUESTA_ASIGNATURA = encA.IDENCUESTA_ASIGNATURA\n" +
                        "inner join ENCUESTA e\n" +
                        "on e.idencuesta = encA.idencuesta\n" +
                        "inner join pregunta p\n" +
                        "on f.idpregunta=p.idpregunta\n" +
                        "inner join tipo t\n" +
                        "on t.idtipo = p.idtipo\n" +
                        "inner join caracteristica c\n" +
                        "on c.idcaracteristica= t.idcaracteristica\n" +
                        "inner join asignatura a\n" +
                        "on a.idasignatura=encA.idasignatura\n" +
                        "where e.idencuesta = "+inIdEncuesta+" and c.idcaracteristica="+inIdCaracteristica+"\n" +
                        "group by encA.IDENCUESTA_ASIGNATURA,a.idasignatura, a.nombre,e.idencuesta,e.periodo,e.fecha,e.estado,c.idcaracteristica,c.nombre,e.idencuesta\n" +
                        "order by a.nombre asc";       

          System.out.println(sql);
          System.out.println();
           System.out.println();
        try{
          resultSet=clConexion.consultar(sql);
          
        
          while(resultSet.next()){    
           
            
           
            clAsignatura = new Asignatura();
            
            clEncuesta.setStFecha(resultSet.getString("fecha"));
            clEncuesta.setStPeriodo(resultSet.getString("periodo"));
            clEncuesta.setInCodigo(Integer.parseInt(resultSet.getString("idencuesta")));
           
            clEncuesta.agregarInEncuestaAsignatura(Integer.parseInt(resultSet.getString("IDENCUESTA_ASIGNATURA")));  
            clAsignatura.setStCodigo(resultSet.getString("idasignatura"));
            clAsignatura.setStNombre(resultSet.getString("nombreasignatura"));  
             if(resultSet.getString("estado").equals("t")){
                 clEncuesta.setBlEstado(true);
            }else{
               clEncuesta.setBlEstado(false);
            }
            
            clEncuesta.agregarAsignaturas(clAsignatura);  
            
          }
          resultSet.close();

        }catch(Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }    
         return clEncuesta;     
     }
     
     public int modificarFormularioEstadoDeshabilitadoHeg(int idEncuestDeshabilitada){
            int inResultado = 0;               

            String stSql ="update encuesta set estado = 'false' where idencuesta="+idEncuestDeshabilitada;

            try{

               System.out.println(stSql);

              inResultado+=clConexion.ejecutarSql(stSql);

            }catch(Exception e){
             JOptionPane.showMessageDialog(null, e.getMessage());
            }  
        
     return inResultado;
    }
     
      public int modificarFormularioEstadoHabilitadoHeg(int idEncuestaHabilitada){
            int inResultado = 0;               

            String stSql ="update encuesta set estado = 'true' where idencuesta="+idEncuestaHabilitada;

            try{

               System.out.println(stSql);

              inResultado+=clConexion.ejecutarSql(stSql);

            }catch(Exception e){
             JOptionPane.showMessageDialog(null, e.getMessage());
            }  
      
     return inResultado;
    }
     
    
     
     
    
    
}
