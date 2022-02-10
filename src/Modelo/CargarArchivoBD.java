/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *Clase que permite realizar diferentes consultas, actualizaciones y creaciones a la base de datos al cargar un archivo plano.
 *@author Cristian Alexis Alegria C.
 *@version 1.0.0
 *@since SIGED 1.0.0
 */
public class CargarArchivoBD {
    
    
    Conexion conexion;
    ResultSet resultSet;

    /**
    *Metodo constructor que inicializa la conexion.  
    *@since SIGED 1.0.0
    */
    public CargarArchivoBD(){
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
    *Metodo encargado de crear la tabla temporal Docente.
    *@param stPeriodo String:Periodo academico.
    *@return int inResultado:Cero si fue exitosa la creacion de la tabla.
    *@since SIGED 1.0.0
    */
    public int crearTablaTemporalDocente(String stPeriodo) {
        String stSql ="create table tabla_temporal_docente(\n" +
                        "idtabla_temporal_docente serial not null,\n" +
                        "iddocente int not null,\n" +
                        "nombredocente char(100)not null,\n" +
                        "idplan int not null,\n" +
                        "semestre int not null,\n" +
                        "idasignatura char(10)not null,\n" +
                        "idgrupo int not null,\n" +
                        "nombreasignatura char(100) not null,\n" +
                        "intensidad char(50),\n" +
                        "periodo varchar(10) not null default  '"+stPeriodo+"', \n"+
                        "constraint PK_tabla_temporal_docente primary key(idtabla_temporal_docente));";        
        
        int inResultado =0;

            try{
             System.out.println("Crea tabla"+(inResultado=conexion.ejecutarSql(stSql))); 


            }catch(Exception e){
              JOptionPane.showMessageDialog(null,e.getMessage());
            }
                
          return inResultado;
           
    }
    
    /**
    *Metodo encargado de crear la tabla temporal estudiante.
    *@param stPeriodo String:Periodo academico.
    *@return int inResultado:Cero si fue exitosa la creacion de la tabla.
    *@since SIGED 1.0.0
    */
    public int crearTablaTemporalEstudiante(String stPeriodo){
        String stSql ="create table tabla_temporal_estudiante(\n" +
                        "idtabla_temporal_estudiante serial not null,\n" +
                        "idestudiante int not null,\n" +
                        "nombre char(100)not null,\n" +
                        "correo char(100)not null,\n" +
                        "idplan int not null,\n" +
                        "periodo varchar(10) not null default  '"+stPeriodo+"', \n"+
                        "constraint PK_tabla_temporal_estudiante primary key(idtabla_temporal_estudiante));";        
        
        int inResultado =0;

            try{
              System.out.println("Crea tabla"+(inResultado=conexion.ejecutarSql(stSql))); 


            }catch(Exception e){
              JOptionPane.showMessageDialog(null,e.getMessage());
            }
                   
          return inResultado;
           
    } 
    
     /**
    *Metodo encargado de cargar el archivo plano docentes a la base de datos.
    *@param stRuta String:Ruta donde se encuentra el archivo plano.
    *@return int inResultado:Cero si fue exitosa la insercion del archivo plano a la base de datos o -1 si fue lo contrario.
    *@since SIGED 1.0.0
    */
    public int cargarArchivoDocentes(String stRuta){

        String stSql ="copy tabla_temporal_docente (iddocente,nombredocente,idplan,semestre,idasignatura,idgrupo,nombreasignatura,intensidad)" +
                        " from '"+stRuta+"' using delimiters ','  WITH CSV HEADER;";        
        
        int inResultado =0;

        try{
            System.out.println("copy tabla_temporal_docente:"+(inResultado=conexion.ejecutarSql(stSql))); 
         
        }catch(Exception e){
          JOptionPane.showMessageDialog(null,"No cumple con columnas que debe tener un archivo Listado docentes");
        }
             
      return inResultado;
    }
    
    /**
    *Metodo encargado de cargar el archivo plano estudiantes a la base de datos.
    *@param stRuta String:Ruta donde se encuentra el archivo plano.
    *@return int inResultado:Cero si fue exitosa la insercion del archivo plano a la base de datos o -1 si fue lo contrario.
    *@since SIGED 1.0.0
    */
    public int cargarArchivoEstudiantes(String stRuta) {

        String stSql ="copy tabla_temporal_estudiante(idestudiante,nombre,correo,idplan)  \n" +
                        " from  '"+stRuta+"' using delimiters ',' \n" +
                        " WITH CSV HEADER;";        
        
        int inResultado =0;

        try{
          System.out.println("copy tabla_temporal_estudiante:"+(inResultado=conexion.ejecutarSql(stSql)));
     
         
        }catch(Exception e){
          JOptionPane.showMessageDialog(null,"No cumple con columnas que debe tener un archivo listado Estudiantes");
        }
          
      return inResultado;
    }
    
    /**
    *Metodo encargado de insertar docentes a la base de datos.  
    *@return int inResultado:El numero de inserciones que realizo.
    *@since SIGED 1.0.0
    */
    
    public int insertarDocentes(){

        String stSql ="insert into DOCENTE(iddocente,nombre) select tabla.iddocente, upper(tabla.nombredocente) from \n" +
                "(select tempd.iddocente, tempd.nombredocente, count(tempd.iddocente)\n" +
                "from tabla_temporal_docente tempd \n" +
                "left join docente d\n" +
                "on tempd.iddocente = d.iddocente\n" +
                "where d.iddocente is null\n" +
                "group by tempd.iddocente, tempd.nombredocente\n" +
                "order by  tempd.iddocente asc) as tabla;";        
        
        int inResultado =0;

        try{
          System.out.println(inResultado=conexion.ejecutarSql(stSql)); 
     
         
        }catch(Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }
         
      return inResultado;
    }
    /**
    *Metodo encargado de insertar planes de docentes a la base de datos.   
    *@return int inResultado:El numero de inserciones que realizo.
    *@since SIGED 1.0.0
    */
    
    public int insertarPlanesDeDocente(){

        String stSql ="insert into plan(idplan)select  tabla.idplan from \n" +
                        "(select  tempd.idplan, count(tempd.idplan)\n" +
                        "from tabla_temporal_docente tempd\n" +
                        "left join plan p\n" +
                        "on tempd.idplan =  p.idplan\n" +
                        "where  p.idplan is null\n" +
                        "group by tempd.idplan\n" +
                        "order by  tempd.idplan asc) as tabla;";        
        
        int inResultado =0;

        try{
          System.out.println(inResultado=conexion.ejecutarSql(stSql)); 
     
         
        }catch(Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }
               
      return inResultado;
    }
    
    /**
    *Metodo encargado de insertar asignaturas a la base de datos.   
    *@return int inResultado:El numero de inserciones que realizo.
    *@since SIGED 1.0.0
    */
    
    
    public int insertarAsignaturas(){

        String stSql ="insert into asignatura(idasignatura,nombre)select tabla.idasignatura, upper(tabla.nombreasignatura) from \n" +
                        "(select tempd.idasignatura,tempd.nombreasignatura, count(tempd.idasignatura)\n" +
                        "from tabla_temporal_docente tempd\n" +
                        "left join asignatura a\n" +
                        "on tempd.idasignatura = a.idasignatura\n" +
                        "where a.idasignatura is null\n" +
                        "group by tempd.idasignatura,tempd.nombreasignatura\n" +
                        "order by  tempd.idasignatura asc) as tabla;";        
        
        int inResultado =0;

        try{
          System.out.println(inResultado=conexion.ejecutarSql(stSql)); 
     
         
        }catch(Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }
              
      return inResultado;
    }
    /**
    *Metodo encargado de insertar  grupos a la base de datos.   
    *@return int inResultado:El numero de inserciones que realizo.
    *@since SIGED 1.0.0
    */
    
    public int insertarGrupos(){

        String stSql ="insert into grupo(idgrupo)select tabla.idgrupo from \n" +
                        "(select tempd.idgrupo,count(tempd.idgrupo)\n" +
                        "from tabla_temporal_docente tempd\n" +
                        "left join grupo g\n" +
                        "on tempd.idgrupo = g.idgrupo\n" +
                        "where g.idgrupo is null\n" +
                        "group by tempd.idgrupo\n" +
                        "order by  tempd.idgrupo  asc) as tabla;";        
        
        int inResultado =0;

        try{
          System.out.println(inResultado=conexion.ejecutarSql(stSql)); 
     
         
        }catch(Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }
           
      return inResultado;
    }
    
    /**
    *Metodo encargado de insertar asignatura por grupo a la base de datos.   
    *@return int inResultado:El numero de inserciones que realizo.
    *@since SIGED 1.0.0
    */
    
     public int insertarAsignaturaGrupo(){

        String stSql ="insert into asignatura_grupo(idgrupo,idasignatura)select tabla.idgrupo,tabla.idasignatura from \n" +
                        "(select tempd.idgrupo,tempd.idasignatura\n" +
                        "from tabla_temporal_docente tempd\n" +
                        "left join grupo g\n" +
                        "on tempd.idgrupo = g.idgrupo\n" +
                        "left join asignatura t3\n" +
                        "on tempd.idasignatura = t3.idasignatura\n" +
                        "left join ASIGNATURA_GRUPO t4\n" +
                        "on t4.idasignatura = tempd.idasignatura and t4.idgrupo = tempd.idgrupo\n" +
                        "where t4.idasignatura is null and t4.idgrupo is null\n" +
                        "group by tempd.idgrupo,tempd.idasignatura,tempd.iddocente\n" +
                        "order by  tempd.iddocente  asc) as tabla;";        
        
        int inResultado =0;

        try{
          System.out.println(inResultado=conexion.ejecutarSql(stSql)); 
     
         
        }catch(Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }
          
      return inResultado;
    }
     
     /**
    *Metodo encargado de insertar plan por docente a la base de datos.   
    *@return int inResultado:El numero de inserciones que realizo.
    *@since SIGED 1.0.0
    */
     
    public int insertarPlanDocente(){

        String stSql ="insert into plan_docente(iddocente,idplan)select tabla.iddocente, tabla.idplan from \n" +
                        "(select tempd.iddocente, tempd.idplan\n" +
                        "from tabla_temporal_docente tempd\n" +
                        "left join plan p\n" +
                        "on tempd.idplan = p.idplan\n" +
                        "left join docente t3\n" +
                        "on tempd.iddocente = t3.iddocente\n" +
                        "left join plan_docente t4\n" +
                        "on t4.iddocente = tempd.iddocente and tempd.idplan = p.idplan\n" +
                        "where t4.iddocente is null and t4.idplan is null\n" +
                        "group by tempd.iddocente,tempd.idplan\n" +
                        "order by  tempd.iddocente asc) as tabla; ";        
        
        int inResultado =0;

        try{
          System.out.println(inResultado=conexion.ejecutarSql(stSql)); 
     
         
        }catch(Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }
               
      return inResultado;
    }
    /**
    *Metodo encargado de insertar asignaturas,grupo por plan, docente a la base de datos.   
    *@return int inResultado:El numero de inserciones que realizo.
    *@since SIGED 1.0.0
    */
    
    public int insertarAsignaturaGrupoPlanDocente(){

        String stSql ="insert into ASIGNATURA_GRUPO_PLAN_DOCENTE(idplan_docente,idasignatura_grupo,semestre,periodo)select tabla.idplan_docente, tabla.idasignatura_grupo, tabla.semestre, tabla.periodo  from \n" +
                        "(select pd.idplan_docente,ag.IDASIGNATURA_GRUPO,tempd.semestre,tempd.periodo \n" +
                        "from tabla_temporal_docente tempd\n" +
                        "left join plan p\n" +
                        "on tempd.idplan = p.idplan\n" +
                        "left join docente d\n" +
                        "on tempd.iddocente = d.iddocente\n" +
                        "left join plan_docente pd\n" +
                        "on pd.iddocente = tempd.iddocente and tempd.idplan = p.idplan\n" +
                        "left join grupo g\n" +
                        "on tempd.idgrupo = g.idgrupo\n" +
                        "left join asignatura a\n" +
                        "on tempd.idasignatura = a.idasignatura\n" +
                        "left join ASIGNATURA_GRUPO ag\n" +
                        "on ag.idasignatura = tempd.idasignatura and ag.idgrupo = tempd.idgrupo\n" +
                        "left join ASIGNATURA_GRUPO_PLAN_DOCENTE gpd\n" +
                        "on gpd.idplan_docente =  pd.idplan_docente and  gpd.IDASIGNATURA_GRUPO = ag.IDASIGNATURA_GRUPO\n" +
                        "where gpd.idplan_docente is null and gpd.IDASIGNATURA_GRUPO is null\n" +
                        "group by pd.idplan_docente,ag.IDASIGNATURA_GRUPO ,tempd.iddocente,tempd.semestre,tempd.periodo \n" +
                        "order by  tempd.iddocente asc) as tabla;";        
        
        int inResultado =0;

        try{
          System.out.println(inResultado=conexion.ejecutarSql(stSql)); 
     
         
        }catch(Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }
         
      return inResultado;
    }
    
    /**
    *Metodo encargado de insertar estudiantes a la base de datos.   
    *@return int inResultado:El numero de inserciones que realizo.
    *@since SIGED 1.0.0
    */
    
    public int insertarEstudiantes(){

        String stSql ="insert into estudiante(idestudiante,nombre,contrasenia)select tabla.idestudiante, upper(tabla.nombre),tabla.contrasenia from \n" +
                        "(select tempe.idestudiante,tempe.nombre,tempe.idestudiante as contrasenia\n" +
                        "from tabla_temporal_estudiante tempe\n" +
                        "left join estudiante e\n" +
                        "on tempe.idestudiante = e.idestudiante\n" +
                        "where e.idestudiante is null \n" +
                        "group by tempe.idestudiante,tempe.nombre\n" +
                        "order by  tempe.idestudiante asc) as tabla;";        
        
        int inResultado =0;

        try{
          System.out.println(inResultado=conexion.ejecutarSql(stSql)); 
     
         
        }catch(Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }
              
      return inResultado;
    }
    
    /**
    *Metodo encargado de insertar plan por estudiante a la base de datos.   
    *@return int inResultado:El numero de inserciones que realizo.
    *@since SIGED 1.0.0
    */
    
    public int insertarPlanesDeEstudiante(){

        String stSql ="insert into plan(idplan) select  tabla.idplan from \n" +
                        "(select tempe.idplan , count(tempe.idplan)\n" +
                        "from tabla_temporal_estudiante tempe\n" +
                        "left join plan pe\n" +
                        "on tempe.idplan = pe.idplan\n" +
                        "where pe.idplan is null \n" +
                        "group by tempe.idplan\n" +
                        "order by tempe.idplan asc) as tabla;";        
        
        int inResultado =0;

        try{
          System.out.println(inResultado=conexion.ejecutarSql(stSql)); 
     
         
        }catch(Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }
              
      return inResultado;
    }
    
    /**
    *Metodo encargado de insertar estudiante por plan  a la base de datos.   
    *@return int inResultado:El numero de inserciones que realizo.
    *@since SIGED 1.0.0
    */
    
    public int insertarEstudiantePlan(){

        String stSql ="insert into estudiante_plan(idestudiante,idplan) select tabla.idestudiante, tabla.idplan from \n" +
                        "(select tempe.idestudiante,tempe.idplan\n" +
                        "from tabla_temporal_estudiante tempe\n" +
                        "left join estudiante e\n" +
                        "on tempe.idestudiante = e.idestudiante\n" +
                        "left join plan pe\n" +
                        "on tempe.idplan = pe.idplan\n" +
                        "left join estudiante_plan ep\n" +
                        "on ep.idestudiante = tempe.idestudiante and ep.idplan =tempe.idplan\n" +
                        "where ep.idestudiante_plan is null \n" +
                        "group by tempe.idestudiante,tempe.idplan\n" +
                        "order by  tempe.idestudiante asc) as tabla;";        
        
        int inResultado =0;

        try{
          System.out.println(inResultado=conexion.ejecutarSql(stSql)); 
     
         
        }catch(Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }
            
      return inResultado;
    }
    
    /**
    *Metodo encargado de insertar matriculas a la base de datos.
    *@param stIdAsignatura String:Identificacion de la asignatura.
    *@param inIdGrupo int:Identificacion del grupo.
    *@return int inResultado:El numero de inserciones que realizo.
    *@since SIGED 1.0.0
    */
    
    public int matricular(String stIdAsignatura,int inIdGrupo){

        String stSql ="insert into matricula(idestudiante_plan,IDASIGNATURA_GRUPO_PLAN_DOCENTE)select tabla.idestudiante_plan, tabla.IDASIGNATURA_GRUPO_PLAN_DOCENTE from (\n" +
                            "select ep.idestudiante_plan,agpd.IDASIGNATURA_GRUPO_PLAN_DOCENTE\n" +
                            "from ASIGNATURA_GRUPO_PLAN_DOCENTE agpd\n" +
                            "inner join PLAN_DOCENTE pd\n" +
                            "on pd.idplan_docente = agpd.idplan_docente\n" +
                            "inner join docente d\n" +
                            "on d.iddocente = pd.iddocente\n" +
                            "inner join plan p\n" +
                            "on p.idplan = pd.idplan\n" +
                            "inner join ASIGNATURA_GRUPO ga\n" +
                            "on ga.IDASIGNATURA_GRUPO = agpd.IDASIGNATURA_GRUPO\n" +
                            "inner join grupo g\n" +
                            "on g.idgrupo = ga.idgrupo\n" +
                            "inner join asignatura a\n" +
                            "on a.idasignatura = ga.idasignatura\n" +
                            "inner join tabla_temporal_estudiante tempe\n" +
                            "on  tempe.idplan = tempe.idplan/* este siempre se va a cumplir*/\n" +
                            "inner join plan pe\n" +
                            "on  pe.idplan = tempe.idplan\n" +
                            "inner join estudiante e\n" +
                            "on tempe.idestudiante = e.idestudiante\n" +
                            "inner join estudiante_plan ep\n" +
                            "on ep.idestudiante = tempe.idestudiante and ep.idplan =tempe.idplan\n" +
                            "left join matricula m\n" +
                            "on m.IDASIGNATURA_GRUPO_PLAN_DOCENTE =agpd.IDASIGNATURA_GRUPO_PLAN_DOCENTE and m.idestudiante_plan = ep.idestudiante_plan\n" +
                            "where m.IDASIGNATURA_GRUPO_PLAN_DOCENTE is null and m.idestudiante_plan is null and  a.idasignatura  like '%"+stIdAsignatura+"%' and  g.idgrupo="+inIdGrupo+" and agpd.periodo =tempe.periodo \n" +
                            "order by ep.idestudiante_plan) as tabla  ;"; 
        
        
        
        
        int inResultado =0;

        try{
          System.out.println(inResultado=conexion.ejecutarSql(stSql)); 
     
         
        }catch(Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
       
      return inResultado;
    } 
    
    /**
    *Metodo encargado de insertar datos del docente a la base de datos, llamando a los metodos encargados de realizar esas tareas.    
    *@return int inContador:El numero de inserciones que realizo por cada tabla.
    *@since SIGED 1.0.0
    */
    
    public int insertarDatosDocente(){
       int inContador =0; 
       inContador+=insertarDocentes();
       inContador+=insertarPlanesDeDocente();
       inContador+=insertarAsignaturas();
       inContador+=insertarGrupos();
       inContador+=insertarAsignaturaGrupo();
       inContador+=insertarPlanDocente();
       inContador+=insertarAsignaturaGrupoPlanDocente();
       
       return  inContador;
    }    
    
    /**
    *Metodo encargado de insertar datos del estudiante a la base de datos, llamando a los metodos encargados de realizar esas tareas.
    *@param stIdAsignatura String:Identificacion de la asignatura.
    *@param stIdGrupo String:Identificacion del grupo.
    *@return int inContador:El numero de inserciones que realizo por cada tabla
    *@since SIGED 1.0.0
    */
    public int insertarDatosEstudiante(String stIdAsignatura,String stIdGrupo){
       int inIdGrupo = -1;
       int inContador = 0;
       inContador+=insertarEstudiantes();
       inContador+=insertarPlanesDeEstudiante();
       inContador+=insertarEstudiantePlan();      
       
       try {
              inIdGrupo = Integer.parseInt(stIdGrupo);
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"El archivo Listado Estudiantes debe tener un formato de nombre, por ejemplo: 106065M-50");
         }
         try {
              inContador+=matricular(stIdAsignatura,inIdGrupo);
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Verifique que  haya cargado el archivo listado Docentes");
         } 
        return inContador;
    } 
    
    /**
    *Metodo encargado de eliminar la tabla temporal estudiante.   
    *@return int inResultado:Cero si fue exitosa la eliminacion.
    *@since SIGED 1.0.0
    */
     
    public int eliminarTablaTemporalEstudiante(){
        String stSql ="drop table tabla_temporal_estudiante;";        
        
        int inResultado =0;

            try{
              System.out.println("ELIMNAR TABLA TEMPORAL ESTUDIANTE: "+(inResultado=conexion.ejecutarSql(stSql))); 


            }catch(Exception e){
              JOptionPane.showMessageDialog(null,e.getMessage());
            }
                  
          return inResultado;           
    }
    
    /**
    *Metodo encargado de eliminar la tabla temporal docente.   
    *@return int inResultado:Cero si fue exitosa la eliminacion.
    *@since SIGED 1.0.0
    */
    public int eliminarTablaTemporalDocente(){
        String stSql ="drop table tabla_temporal_docente;";        
        
        int inResultado =0;

            try{
              System.out.println(inResultado=conexion.ejecutarSql(stSql));
            }catch(Exception e){
              JOptionPane.showMessageDialog(null,e.getMessage());
            }
                  
          return inResultado;           
    }    
    
}
