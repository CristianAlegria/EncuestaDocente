/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.CargarArchivoBD;
import Modelo.ValidacionArchivoPlano;
import Vista.InfCargarArchivos;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;



/**
 * Clase controlador cargar archivo, la cual permite capturar las peticiones que se realicen en la ventana cargar archivo plano.
 * @author Cristian Alexis Alegria C.
 * @version 1.0.0
 * @since SIGED 1.0.0
 */
public class ControladorCargarArchivos implements  MouseListener{

    private ControladorPrincipal clControladorPrincipal;
    private String stAsignaturaGrupo;
    private String stRuta;
    private String stPeriodoAcademico;     
    private ValidacionArchivoPlano clValidacionArchivoPlano;
    private int inAnio;
    private int inMes;
    private CargarArchivoBD clCargarArchivoDocenteBD;
    private CargarArchivoBD clCargarArchivoEstudiantesBD;
    
   
     /**
    *Metodo constructor que inicializa el controlador principal.
    *@param clControladorPrincipal ControladorPrincipal:Controlador Principal.
    *@since SIGED 1.0.0
    */
    public ControladorCargarArchivos(ControladorPrincipal clControladorPrincipal) {
        this.clControladorPrincipal = clControladorPrincipal;
    }

    public ControladorPrincipal getClControladorPrincipal() {
        return clControladorPrincipal;
    }

    public void setClControladorPrincipal(ControladorPrincipal clControladorPrincipal) {
        this.clControladorPrincipal = clControladorPrincipal;
    }

    public String getStRuta() {
        return stRuta;
    }

    public void setStRuta(String stRuta) {
        this.stRuta = stRuta;
    }

    public ValidacionArchivoPlano getClValidacionArchivoPlano() {
        return clValidacionArchivoPlano;
    }

    public void setClValidacionArchivoPlano(ValidacionArchivoPlano clValidacionArchivoPlano) {
        this.clValidacionArchivoPlano = clValidacionArchivoPlano;
    }  
    
    public void iniciarInfCargarArchivo(){         
        clControladorPrincipal.getInfCargarArchivos().setTitle("Cargar Archivos ");            
                   
    }

    public String getStAsignaturaGrupo() {
        return stAsignaturaGrupo;
    }

    public void setStAsignaturaGrupo(String stAsignaturaGrupo) {
        this.stAsignaturaGrupo = stAsignaturaGrupo;
    }

    public String getStPeriodoAcademico() {
        return stPeriodoAcademico;
    }

    public void setStPeriodoAcademico(String stPeriodoAcademico) {
        this.stPeriodoAcademico = stPeriodoAcademico;
    }   

    public int getInAnio() {
        return inAnio;
    }

    public void setInAnio(int inAnio) {
        this.inAnio = inAnio;
    }

    public int getInMes() {
        return inMes;
    }

    public void setInMes(int inMes) {
        this.inMes = inMes;
    }

    public CargarArchivoBD getClCargarArchivoDocenteBD() {
        return clCargarArchivoDocenteBD;
    }

    public void setClCargarArchivoDocenteBD(CargarArchivoBD clCargarArchivoDocenteBD) {
        this.clCargarArchivoDocenteBD = clCargarArchivoDocenteBD;
    }

    public CargarArchivoBD getClCargarArchivoEstudiantesBD() {
        return clCargarArchivoEstudiantesBD;
    }

    public void setClCargarArchivoEstudiantesBD(CargarArchivoBD clCargarArchivoEstudiantesBD) {
        this.clCargarArchivoEstudiantesBD = clCargarArchivoEstudiantesBD;
    }
    
    
    
   /**
    *Metodo encargado de abrir la ventana cargar archivo, mostrar todo los componentes que la conforman,de centrarla en pantalla y
    *activar los escuchadores de eventos que ocurran en ella.  
    *@since SIGED 1.0.0
    */
    public void iniciarCargarArchivo(){
        //if(clControladorPrincipal.estaCerrado(clControladorPrincipal.getInfCargarArchivos())){//se crea nuevo
           
            clControladorPrincipal.setInfCargarArchivos(new InfCargarArchivos());            
            clControladorPrincipal.getFrmPrincipal().getDstContenedorPrincipal().add(clControladorPrincipal.getInfCargarArchivos());       
            
            activarEscuchadores();
            centrarVentana(clControladorPrincipal.getInfCargarArchivos());     
            iniciarInfCargarArchivo();
       /*}else{
          JOptionPane.showMessageDialog(this.clControladorPrincipal.getFrmPrincipal(),"La Ventana De 'Cargar Archivos ' ya esta abierta.");
       }*/
    }
    
     /**
    *Metodo encargado de escuchar cuando el usuario da click en cargar listado docentes o estudiantes.
    *@since SIGED 1.0.0
    */
    public void activarEscuchadores(){       
         clControladorPrincipal.getInfCargarArchivos().getLblCargarDocentes().addMouseListener(this);
         clControladorPrincipal.getInfCargarArchivos().getLblCargarEstudiantes().addMouseListener(this);
    }
    
    /**
    *Metodo encargado de centrar la ventana cargar archivo plano.
    *@param infVentana JInternalFrame:Ventana cargar archivo plano.
    *@since SIGED 1.0.0
    */
    public void centrarVentana(JInternalFrame infVentana){       
        
       clControladorPrincipal.getInfCargarArchivos().setLocation( clControladorPrincipal.centradoXY(infVentana));
       clControladorPrincipal.getInfCargarArchivos().setVisible(true);
    }
  
    @Override
    
    /**
    *Metodo encargado de capturar y reponder a los eventos que ocurran en la ventana cargar archivo plano.
    *@param actionEvent ActionEvent:Evento que se acciona. 
    *@since SIGED 1.0.0
    */
    public void mouseClicked(MouseEvent mouseEvent) {
        
        clControladorPrincipal.getInfCargarArchivos().getLblMensajeAceptar().setText("");
        clValidacionArchivoPlano  = new ValidacionArchivoPlano();
        clControladorPrincipal.getInfCargarArchivos().setFchBuscadorArchivo(new JFileChooser());
        stRuta = "";
        
        
        if(mouseEvent.getSource()== clControladorPrincipal.getInfCargarArchivos().getLblCargarDocentes()){          
                
            mostrarBuscadorDeArchivo();
            capturarRutaArchivoPlano();
            
            if(!stRuta.equals("")){
                if(clValidacionArchivoPlano.contenidoDelArchivoPlano(stRuta)){
                   if(clValidacionArchivoPlano.validarFomatoTxt(stRuta)){
                     clValidacionArchivoPlano = null;
                     System.gc();
                     capturarPeriodoAcademicoDocente();
                     ingresarInformacionDeArchivoDocentesBD();

                    }else{
                     if(!stRuta.equals("")){
                       clControladorPrincipal.getInfCargarArchivos().getLblMensajeAceptar().setText("El Archivo Debe Ser .txt");  
                      }                        
                    }
                }else{
                   clControladorPrincipal.getInfCargarArchivos().getLblMensajeAceptar().setText("El Archivo No Contiene Docentes"); 
                }
           }
            
        }else{
           if(mouseEvent.getSource()== clControladorPrincipal.getInfCargarArchivos().getLblCargarEstudiantes()){
              
               mostrarBuscadorDeArchivo();                                        
               capturarRutaArchivoPlano();
               if(!stRuta.equals("")){
                   if(clValidacionArchivoPlano.contenidoDelArchivoPlano(stRuta)){
                       if(clValidacionArchivoPlano.validarFomatoTxt(stRuta)){

                           clValidacionArchivoPlano = null;
                           System.gc();
                           stAsignaturaGrupo = capturarNombreDelArchivo();                  
                           capturarFecha();                  
                           stPeriodoAcademico = capturarPeriodoAcademicoEstudiantes(inAnio, inMes);
                           ingresarInformacionDeArchivoEstudianteBD();

                       }else{
                             if(!stRuta.equals("")){
                                clControladorPrincipal.getInfCargarArchivos().getLblMensajeAceptar().setText("El Archivo Debe Ser .txt");  
                             }                                       
                       }
                   }else{
                      clControladorPrincipal.getInfCargarArchivos().getLblMensajeAceptar().setText("El Archivo No Contiene Estudiantes"); 
                   }
                }
           }
        }
    }
    
    /**
    *Metodo encargado de mostrar el explorador de archivos.  
    *@since SIGED 1.0.0
    */    
    public void mostrarBuscadorDeArchivo(){
      clControladorPrincipal.getInfCargarArchivos().getFchBuscadorArchivo().
                                                      showOpenDialog(clControladorPrincipal.getInfCargarArchivos().getFchBuscadorArchivo());
    }
    
    /**
    *Metodo encargado de capturar la ruta del archivo plano.  
    *@since SIGED 1.0.0
    */  
    public void capturarRutaArchivoPlano(){
        try {
             stRuta = clControladorPrincipal.getInfCargarArchivos().getFchBuscadorArchivo().getSelectedFile().getAbsolutePath(); 
                   
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(clControladorPrincipal.getInfCargarArchivos(),"Error al Capturar  Ruta Archivo Plano");
        }   
    }
    
    /**
    *Metodo encargado de capturar el idAsignatura de stAsignaturaGrupo que es el nombre del archivo plano cargar listado estudiantes.  
    *@return stIdAsignatura String:Retorna la identificacion de la asignatura
    *@since SIGED 1.0.0
    */  
    public String capturarIdAsignatura(){
        String stIdAsignatura="";       
        
        int inPosicion = stAsignaturaGrupo.indexOf("-");       
        
        for (int i = 0; i <inPosicion; i++) {
            stIdAsignatura+=stAsignaturaGrupo.charAt(i);
        } 
        return stIdAsignatura;
    }
    
    /**
    *Metodo encargado de capturar el idGrupo de stAsignaturaGrupo que es el nombre del archivo plano cargar listado estudiantes y retornar idGrupo.
    *@return stIdGrupo String:Retorna la identificacion del grupo
    *@since SIGED 1.0.0
    */
    public String capturarIdGrupo(){       
        String stIdGrupo="";        
        int inPosicion = stAsignaturaGrupo.indexOf("-");
       
        for (int i = inPosicion+1; i <stAsignaturaGrupo.indexOf("."); i++) {
            stIdGrupo+=stAsignaturaGrupo.charAt(i);
        }  
        return stIdGrupo;
    }
    
    
    /**
    *Metodo encargado de capturar el nombre del archivo plano y retornarlo.
    *@return Retorna nombre del archivo plano de tipo String.
    *@since SIGED 1.0.0
    */
    public String capturarNombreDelArchivo(){
          return clControladorPrincipal.getInfCargarArchivos().getFchBuscadorArchivo().getSelectedFile().getName();    
    }
    
    /**
    *Metodo encargado de capturar el periodo academico del nombre del archivo plano listado docentes.  
    *@since SIGED 1.0.0
    */
    public void capturarPeriodoAcademicoDocente(){        
            stPeriodoAcademico="";
            String stNombreArchivo = capturarNombreDelArchivo();
            int inPosicionPeriodo1 = stNombreArchivo.indexOf("-I-");
            int inPosicionPeriodo2 = stNombreArchivo.indexOf("-II-");
            int inFinal = stNombreArchivo.indexOf(".");
            //System.out.println(inPosicionPeriodo1);
           // System.out.println(inPosicionPeriodo2);

            if(inPosicionPeriodo1>-1){
                 for (int i = inPosicionPeriodo1+1; i <inFinal; i++) {
                    stPeriodoAcademico+=stNombreArchivo.charAt(i);
                 }
            }else{
                if(inPosicionPeriodo2>-1){
                    for (int i = inPosicionPeriodo2+1; i <inFinal; i++) {
                       stPeriodoAcademico+=stNombreArchivo.charAt(i);
                    }
                }     
            }             
    }
    
    /**
    *Metodo encargado de ingresar la informacion del listado de docentes a la base de datos.  
    *@since SIGED 1.0.0
    */
    public void ingresarInformacionDeArchivoDocentesBD(){ 
       // boolean blValidacion = false;
        clCargarArchivoDocenteBD = new CargarArchivoBD();
        
        clCargarArchivoDocenteBD.crearTablaTemporalDocente(stPeriodoAcademico);  
        
        if(clCargarArchivoDocenteBD.cargarArchivoDocentes(stRuta)>=0){              
           if(clCargarArchivoDocenteBD.insertarDatosDocente()>0){
              clControladorPrincipal.getInfCargarArchivos().getLblMensajeAceptar().setText("Listado De Docentes Se Registro Con Exito");
           }else{
               clControladorPrincipal.getInfCargarArchivos().getLblMensajeAceptar().setText("Este Listado De Docentes Ya Fue Introducido Anteriormente");
           }
           
        }else{
            clControladorPrincipal.getInfCargarArchivos().getLblMensajeAceptar().setText("Registro Fallido");
        }
        clCargarArchivoDocenteBD.eliminarTablaTemporalDocente();
        clCargarArchivoDocenteBD.getConexion().cerrarConexion();
        destroyClCargarArchivoDocenteBD();
       // System.out.println("Docentes: "+stRuta);    
     
     }
    
    /**
    *Metodo encargado de ingresar la informacion del listado de estudiantes a la base de datos.  
    *@since SIGED 1.0.0
    */
    public void ingresarInformacionDeArchivoEstudianteBD(){ 
      // boolean blValidacion = false;
       clCargarArchivoEstudiantesBD = new CargarArchivoBD();         
       
       clCargarArchivoEstudiantesBD.crearTablaTemporalEstudiante(stPeriodoAcademico);
       
       if(clCargarArchivoEstudiantesBD.cargarArchivoEstudiantes(stRuta)>=0){         
           
            if(clCargarArchivoEstudiantesBD.insertarDatosEstudiante(capturarIdAsignatura(),capturarIdGrupo())>0){
               clControladorPrincipal.getInfCargarArchivos().getLblMensajeAceptar().setText("Listado De Estudiantes Se Registro Con Exito");
         
           }else{
               clControladorPrincipal.getInfCargarArchivos().getLblMensajeAceptar().setText("Este Listado De Estudiantes Ya Fue Introducido Anteriormente");
           }         
        
        }else{         
           clControladorPrincipal.getInfCargarArchivos().getLblMensajeAceptar().setText("Registro Fallido");
        }
       
        clCargarArchivoEstudiantesBD.eliminarTablaTemporalEstudiante();
        clCargarArchivoEstudiantesBD.getConexion().cerrarConexion();
        destroyClCargarArchivoEstudiantesBD();
      //System.out.println("Estudiante: "+stRuta);
      //System.out.println("stAsignaturaGrupo: "+stAsignaturaGrupo);   
    }
     
    
    /**
    *Metodo encargado de  capturar la fecha actual: año y mes.  
    *@since SIGED 1.0.0
    */
    public void capturarFecha(){
       Calendar calendar = Calendar.getInstance();
       inAnio = calendar.get(Calendar.YEAR);
       inMes = calendar.get(Calendar.MONTH) + 1;        
    }
    
    /**
    *Metodo encargado de  capturar el periodo academico para el listado de estudiantes segun la fecha actual del sistema y retornarlo en el formato. Ejemplo: "I-año" o "II-año".
    *@param inAnio int:Año.
    *@param inMes int:Mes.
    *@return stPeriodoAcademico String:Retorna el periodo academico
    *@since SIGED 1.0.0
    */
    public String capturarPeriodoAcademicoEstudiantes(int inAnio, int inMes){
        stPeriodoAcademico = "";
        if(inMes>=1&&inMes<7){
           stPeriodoAcademico = "I-"+inAnio;
        }else{
            if(inMes>=7&&inMes<13){
               stPeriodoAcademico = "II-"+inAnio;
            }
        }
       return stPeriodoAcademico;
   }
    
    /**
    *Metodo encargado de  destruir el objeto clCargarArchivoDocenteBD.  
    *@since SIGED 1.0.0
    */
    public void destroyClCargarArchivoDocenteBD(){
      clCargarArchivoDocenteBD = null;
      System.gc();
    }
   
    /**
    *Metodo encargado de  destruir el objeto clCargarArchivoEstudiantesBD.  
    *@since SIGED 1.0.0
    */
    public void destroyClCargarArchivoEstudiantesBD(){
      clCargarArchivoEstudiantesBD = null;
      System.gc();
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }   
}
