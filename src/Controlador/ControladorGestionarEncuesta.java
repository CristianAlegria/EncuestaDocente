/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Asignatura;
import Modelo.Caracteristica;
import Modelo.Encuesta;
import Modelo.EncuestaBD;
import Modelo.Pregunta;
import Modelo.PreguntaBD;
import Modelo.Tipo;
import Modelo.TipoBD;
import Vista.InfGestionEncuesta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author User
 */
public class ControladorGestionarEncuesta  implements ActionListener,MouseListener,ItemListener {
    private ControladorPrincipal clControladorPrincipal;
    private TipoBD clTipoBD;
    private Vector<Caracteristica>listaObjCaracteristica;
    private Encuesta clEncuesta;
    private Encuesta clEncuestaHeg;
    private Encuesta clEncuestaHee;
    private Vector <Encuesta>listaObjEncuestaHee;
    private Encuesta clEncuestaResgistro;
    private  Vector<Tipo>listaObjTipo;
    private  Vector<Encuesta>listaObjEncuesta;
    private  Vector<Encuesta>listaObjEncuestaHeg;
    private EncuestaBD clEncuestaBD;
    
    private Vector <Encuesta> listaObjEncuestaHabilitar;
 
    private PreguntaBD clPreguntaBD;
    private Tipo clTipo;
    private Pregunta clPregunta;
    private Caracteristica clCaracteristica;
    private int inOpcion;
    private Encuesta clEliminarAsignaturaEncuestaPregunta;
    private Encuesta clRegistrarAsignaturaEncuestaPregunta;
    

    public ControladorGestionarEncuesta(ControladorPrincipal clControladorPrincipal) {
        this.clControladorPrincipal = clControladorPrincipal;
    }
    
    public void activarEscuchadores(){
         //Gestion Encuesta
       clControladorPrincipal.getInfGestionEncuesta().getBtnReiniciarVentana().addActionListener(this);
       clControladorPrincipal.getInfGestionEncuesta().getBtnRegistrarEncuesta().addActionListener(this);
       clControladorPrincipal.getInfGestionEncuesta().getBtnListarPreguntas().addActionListener(this);
       clControladorPrincipal.getInfGestionEncuesta().getBtnModificarEncuesta().addActionListener(this);
       clControladorPrincipal.getInfGestionEncuesta().getBtnListarAsignaturas().addActionListener(this);
       clControladorPrincipal.getInfGestionEncuesta().getBtnAceptarEncuesta().addActionListener(this);       
       clControladorPrincipal.getInfGestionEncuesta().getBtnAniadirPregunta().addActionListener(this);
       clControladorPrincipal.getInfGestionEncuesta().getBtnAceptarAniadirPregunta().addActionListener(this);
       clControladorPrincipal.getInfGestionEncuesta().getCbxModificarEncuesta().addItemListener(this);
     
       //Habilitar Encuesta general       
       clControladorPrincipal.getInfGestionEncuesta().getBtnHabilitarHeg().addActionListener(this);
       clControladorPrincipal.getInfGestionEncuesta().getBtnListarAsignaturasHeg().addActionListener(this);
       clControladorPrincipal.getInfGestionEncuesta().getBntAceptarHeg().addActionListener(this);
       
       //Habilitar Encuesta especial      
       clControladorPrincipal.getInfGestionEncuesta().getBtnListarEncuestasHee().addActionListener(this);
       clControladorPrincipal.getInfGestionEncuesta().getBtnHabilitarHee().addActionListener(this);      
       clControladorPrincipal.getInfGestionEncuesta().getBtnAceptarHee().addActionListener(this);
       
    }
    
    public void iniciarGestionarEncuesta(){
      clControladorPrincipal.setInfGestionEncuesta(new InfGestionEncuesta());
      clControladorPrincipal.getFrmPrincipal().getDstContenedorPrincipal().add(clControladorPrincipal.getInfGestionEncuesta());
      activarEscuchadores();
      centrarVentana(clControladorPrincipal.getInfGestionEncuesta());
      clControladorPrincipal.getInfGestionEncuesta().setVisible(true); 
      iniciarInfGestionarEncuesta();
      deshabilitarComponentes();
      cargarCbxCaracteristica();
      deshabilitarComponentesHeg();      
      deshabilitarComponentesHee();
      
      clEncuesta = new Encuesta();
      inOpcion = -1;
    
    }

    public void centrarVentana(JInternalFrame infVentana){        
        clControladorPrincipal.getInfGestionEncuesta().setLocation(clControladorPrincipal.centradoXY(infVentana));
        
    }
    public void iniciarInfGestionarEncuesta(){         
        clControladorPrincipal.getInfGestionEncuesta().setTitle("Gestionar Encuesta General/Especial");            
        
        //Gestion Encuesta
        clControladorPrincipal.getInfGestionEncuesta().getBtnReiniciarVentana().setActionCommand("ReiniciarVentana");
        clControladorPrincipal.getInfGestionEncuesta().getBtnRegistrarEncuesta().setActionCommand("CrearEncuesta");
        clControladorPrincipal.getInfGestionEncuesta().getBtnListarPreguntas().setActionCommand("ListarPreguntas");
        clControladorPrincipal.getInfGestionEncuesta().getBtnModificarEncuesta().setActionCommand("ModificarEncuesta");
        clControladorPrincipal.getInfGestionEncuesta().getBtnListarAsignaturas().setActionCommand("ListarAsignaturas");
        clControladorPrincipal.getInfGestionEncuesta().getBtnAceptarEncuesta().setActionCommand("RegistrarFormulario");
        clControladorPrincipal.getInfGestionEncuesta().getBtnAniadirPregunta().setActionCommand("AniadirPregunta"); 
        clControladorPrincipal.getInfGestionEncuesta().getBtnAceptarAniadirPregunta().setActionCommand("AceptarAniadirPregunta"); 
        
        //Habilitar Encuesta general
        
       clControladorPrincipal.getInfGestionEncuesta().getBtnHabilitarHeg().setActionCommand("HabilitarHeg");
       clControladorPrincipal.getInfGestionEncuesta().getBtnListarAsignaturasHeg().setActionCommand("ListarAsignaturasHeg");
       clControladorPrincipal.getInfGestionEncuesta().getBntAceptarHeg().setActionCommand("AceptarHeg");
        
      //Habilitar Encuesta especial      
       clControladorPrincipal.getInfGestionEncuesta().getBtnListarEncuestasHee().setActionCommand("ListarEncuestasHee");
       clControladorPrincipal.getInfGestionEncuesta().getBtnHabilitarHee().setActionCommand("HabilitarHee");
       clControladorPrincipal.getInfGestionEncuesta().getBtnAceptarHee().setActionCommand("AceptarHee");
        
        
    }
    
   
    public  void cargarCbxCaracteristica(){
       clTipoBD = new TipoBD();
       listaObjCaracteristica = clTipoBD.listarCaracteristicas();  
       clControladorPrincipal.getInfGestionEncuesta().getCbxCaracteristica().addItem("Seleccione");
        for (int i = 0; i < listaObjCaracteristica.size(); i++) {
            clControladorPrincipal.getInfGestionEncuesta().getCbxCaracteristica().addItem(listaObjCaracteristica.get(i).getStNombre());
        }   
        clTipoBD = null;
        System.gc();
    }
    
    public void consultarPreguntas(int inCaracteristica){      
       clPreguntaBD = new PreguntaBD();     
       clEncuesta.setListaObjPregunta(clPreguntaBD.listarPreguntas(inCaracteristica));        
       clPreguntaBD = null;
       System.gc();    
    }
    public  void cargarTblPreguntas(){
       clControladorPrincipal.getInfGestionEncuesta().limpiarTabla(clControladorPrincipal.getInfGestionEncuesta().getTblPreguntas());
       Vector<String>listaStPreguntas;
       DefaultTableModel tblModelPregunta = (DefaultTableModel) clControladorPrincipal.getInfGestionEncuesta().getTblPreguntas().getModel();
       
       for (int i = 0; i < clEncuesta.getListaObjPregunta().size(); i++) {
            listaStPreguntas = new Vector();
            listaStPreguntas.add(clEncuesta.getListaObjPregunta().get(i).getStPregunta());
            listaStPreguntas.add(clEncuesta.getListaObjPregunta().get(i).getClTipo().getStNombre());
            
            tblModelPregunta.addRow(listaStPreguntas);
        }  
        clControladorPrincipal.getInfGestionEncuesta().setDefaultTableModel(tblModelPregunta);     
        
        
    }
    
    public  void ListarPreguntasModificar(int inIdCaracteristica){
      
       Vector<String>listaStPreguntas;
       DefaultTableModel tblModelPregunta = (DefaultTableModel) clControladorPrincipal.getInfGestionEncuesta().getTblPreguntas().getModel();
       clPreguntaBD = new PreguntaBD();
       Vector<Pregunta>listaObjPreguntaAux = clPreguntaBD.listarPreguntas(inIdCaracteristica);
       int inContador = 0;
       for (int i = 0; i <listaObjPreguntaAux.size(); i++) {
            inContador =0;
            for (int j = 0;  j< clEncuesta.getListaObjPregunta().size(); j++) {
              if(listaObjPreguntaAux.get(i).getInIdPregunta()==clEncuesta.getListaObjPregunta().get(j).getInIdPregunta()){
                 inContador++;
              }              
            }
            if(inContador==0){
                listaStPreguntas = new Vector();
                listaStPreguntas.add(listaObjPreguntaAux.get(i).getStPregunta());
                listaStPreguntas.add(listaObjPreguntaAux.get(i).getClTipo().getStNombre());            
                tblModelPregunta.addRow(listaStPreguntas); 
                clRegistrarAsignaturaEncuestaPregunta.agregarPreguntas(listaObjPreguntaAux.get(i));
              }    
        }  
        clControladorPrincipal.getInfGestionEncuesta().setDefaultTableModel(tblModelPregunta);    
    }
    
    public  void ListarAsignaturasModificar(){
      
       Vector<String>listaStAsignatura;
       DefaultTableModel tblModelAsignatura = (DefaultTableModel) clControladorPrincipal.getInfGestionEncuesta().getTblAsignaturas().getModel();
       clEncuestaBD = new EncuestaBD();
       Vector<Asignatura>listaObjAsignaturaAux = clEncuestaBD.listarAsignaturas();
       int inContador = 0;
       for (int i = 0; i <listaObjAsignaturaAux.size(); i++) {
            inContador =0;
            for (int j = 0;  j< clEncuesta.getListaObjAsignatura().size(); j++) {
              if(listaObjAsignaturaAux.get(i).getStCodigo().equals(clEncuesta.getListaObjAsignatura().get(j).getStCodigo())){
                 inContador++;
              }              
            }
            if(inContador==0){
                listaStAsignatura = new Vector();
                listaStAsignatura.add(listaObjAsignaturaAux.get(i).getStCodigo());
                listaStAsignatura.add(listaObjAsignaturaAux.get(i).getStNombre());            
                tblModelAsignatura.addRow(listaStAsignatura); 
                clRegistrarAsignaturaEncuestaPregunta.agregarAsignaturas(listaObjAsignaturaAux.get(i));
              }    
        }  
        clControladorPrincipal.getInfGestionEncuesta().setDefaultTableModel(tblModelAsignatura);    
    }
    
    public void capturarAsignaturasNoSeleccionadas(){
       int inColumnaCheckBox = 2;
        boolean blEstadoCheckBox = false;
       
        clEliminarAsignaturaEncuestaPregunta = new Encuesta();
         for (int i = 0; i < clEncuesta.getListaObjAsignatura().size(); i++){ 
            
            if(clControladorPrincipal.getInfGestionEncuesta().getTblAsignaturas().getValueAt(i,inColumnaCheckBox)!=null){ 
                blEstadoCheckBox =(boolean) clControladorPrincipal.getInfGestionEncuesta().getTblAsignaturas().getValueAt(i,inColumnaCheckBox);
                if(!blEstadoCheckBox){                  
                     clEliminarAsignaturaEncuestaPregunta.agregarAsignaturas(clEncuesta.getListaObjAsignatura().get(i));
                     System.out.println("Tamaño :inError "+clEncuesta.getListaInEncuestaAsignatura().size());
                     System.out.println("Tamaño :asiError "+clEncuesta.getListaObjAsignatura().size());
                     clEliminarAsignaturaEncuestaPregunta.agregarInEncuestaAsignatura(clEncuesta.getListaInEncuestaAsignatura().get(i));
                     clEliminarAsignaturaEncuestaPregunta.setInCodigo(clEncuesta.getInCodigo());
                                   
                }                
            }                    
        } 
        
    }
    
    public void eliminarAsignaturasDeEncuesta(){
      capturarAsignaturasNoSeleccionadas();
      clEncuestaBD = new EncuestaBD();
      clEncuestaBD.eliminarEncuestaAsignaturaFormulario(clEliminarAsignaturaEncuestaPregunta);      
      
      clEncuestaBD = null;
      System.gc();    
    }
    
    public void capturarAsignaturasSeleccionadasFormulario(){
       int inColumnaCheckBox = 2;
        boolean blEstadoCheckBox = false;
        int inContador =0;
        
        clRegistrarAsignaturaEncuestaPregunta.setInCodigo(clEncuesta.getInCodigo());
        Encuesta clEncuesta = new Encuesta();
        System.out.println("Donde arranca:"+this.clEncuesta.getListaObjAsignatura().size());
         System.out.println("Donde termina:"+clControladorPrincipal.getInfGestionEncuesta().getTblAsignaturas().getRowCount());
        // listaInAsignaturaEncuesta.add(clEliminarAsignaturaEncuestaPregunta.getListaInEncuestaAsignatura().get(i));
         for (int i = this.clEncuesta.getListaObjAsignatura().size(); i <clControladorPrincipal.getInfGestionEncuesta().getTblAsignaturas().getRowCount(); i++){ 
             
            if(clControladorPrincipal.getInfGestionEncuesta().getTblAsignaturas().getValueAt(i,inColumnaCheckBox)!=null){ 
                blEstadoCheckBox =(boolean) clControladorPrincipal.getInfGestionEncuesta().getTblAsignaturas().getValueAt(i,inColumnaCheckBox);
               
                System.out.println("Hola mundo 1"+blEstadoCheckBox);
                if(blEstadoCheckBox){                  
                    System.out.println("Hola mundo2");
                    clEncuesta.agregarAsignaturas(clRegistrarAsignaturaEncuestaPregunta.getListaObjAsignatura().get(inContador));               
                }         
            }
            inContador++;
        }
        clRegistrarAsignaturaEncuestaPregunta.setListaObjAsignatura(clEncuesta.getListaObjAsignatura());
    }
    public Encuesta capturarPreguntasSeleccionadasFormulario(){
       int inColumnaCheckBox = 2;
        boolean blEstadoCheckBox = false;
        int inContador =0;       
        
        Encuesta clEncuesta = new Encuesta();
        System.out.println("Donde arranca 3:"+this.clEncuesta.getListaObjPregunta().size());
         System.out.println("Donde termina 4:"+clControladorPrincipal.getInfGestionEncuesta().getTblPreguntas().getRowCount());
        
         for (int i = this.clEncuesta.getListaObjPregunta().size(); i <clControladorPrincipal.getInfGestionEncuesta().getTblPreguntas().getRowCount(); i++){ 
             
            if(clControladorPrincipal.getInfGestionEncuesta().getTblPreguntas().getValueAt(i,inColumnaCheckBox)!=null){ 
                blEstadoCheckBox =(boolean) clControladorPrincipal.getInfGestionEncuesta().getTblPreguntas().getValueAt(i,inColumnaCheckBox);
               
                System.out.println("Hola mundo 3"+blEstadoCheckBox);
                if(blEstadoCheckBox){                  
                    System.out.println("Hola mundo4");          
                     System.out.println("id Pregunta: "+clRegistrarAsignaturaEncuestaPregunta.getListaObjPregunta().get(inContador).getInIdPregunta());
                      clEncuesta.agregarPreguntas(clRegistrarAsignaturaEncuestaPregunta.getListaObjPregunta().get(inContador));
                }         
            }
            inContador++;
        } 
         return clEncuesta;
       
    }
    public void registraPreguntasAsignaturasAniadidas(){
      capturarAsignaturasSeleccionadasFormulario();    
      clEncuestaBD = new EncuestaBD(); 
      
       Vector<Pregunta>listaObjPreguntaAux = clRegistrarAsignaturaEncuestaPregunta.getListaObjPregunta();
      clRegistrarAsignaturaEncuestaPregunta.setListaObjPregunta(clEncuesta.getListaObjPregunta());
      
      Vector<Integer>listaInIdAsigEncues =clEncuestaBD.registrarEncuestaAsignatura(clRegistrarAsignaturaEncuestaPregunta);  
      clEncuestaBD.registrarFormulario(clRegistrarAsignaturaEncuestaPregunta,listaInIdAsigEncues);  
            
      clRegistrarAsignaturaEncuestaPregunta.setListaObjPregunta(listaObjPreguntaAux);
      clEncuestaBD.registrarFormulario(capturarPreguntasSeleccionadasFormulario(),cargarIdPreguntas(listaInIdAsigEncues));
      
      clEncuestaBD = null;
      System.gc();  
    }
    
    public Vector<Integer> cargarIdPreguntas(Vector<Integer>listaInIdAsigEncues){
       
        for (int i = 0; i <listaInIdAsigEncues.size(); i++) {
            clEncuesta.agregarInEncuestaAsignatura(listaInIdAsigEncues.get(i));            
        }
        return clEncuesta.getListaInEncuestaAsignatura(); 
    }
    
   
    public Encuesta capturarPreguntasNoSeleccionadas(){
       int inColumnaCheckBox = 2;
        boolean blEstadoCheckBox = false;
        int inContador =0;
        
         for (int i = 0; i < clEncuesta.getListaObjPregunta().size(); i++){ 
            
            if(clControladorPrincipal.getInfGestionEncuesta().getTblPreguntas().getValueAt(i,inColumnaCheckBox)!=null){ 
                blEstadoCheckBox =(boolean) clControladorPrincipal.getInfGestionEncuesta().getTblPreguntas().getValueAt(i,inColumnaCheckBox);
                if(!blEstadoCheckBox){                  
                     clEliminarAsignaturaEncuestaPregunta.agregarPreguntas(clEncuesta.getListaObjPregunta().get(i));                      
                                 
                }                
            }   
            clEliminarAsignaturaEncuestaPregunta.setListaInEncuestaAsignatura(clEncuesta.getListaInEncuestaAsignatura());
        } 
         return clEliminarAsignaturaEncuestaPregunta;
    }
    
     public void eliminarPreguntasAsignaturasDeEncuesta(){
      capturarPreguntasNoSeleccionadas();
      clEncuestaBD = new EncuestaBD();
      clEncuestaBD.eliminarPreguntaFormulario(clEliminarAsignaturaEncuestaPregunta);      
      
      clEncuestaBD = null;
      System.gc();    
    }
    
    public void consultarAsignaturas(){
         
       clEncuestaBD = new EncuestaBD();      
       
       clEncuesta.setListaObjAsignatura(clEncuestaBD.listarAsignaturas());        
       clPreguntaBD = null;
       System.gc();    
    }
    public  void cargarTblAsignaturas(){
       clControladorPrincipal.getInfGestionEncuesta().limpiarTabla(clControladorPrincipal.getInfGestionEncuesta().getTblAsignaturas()); 
       Vector<String>listaStAsignatura;
       DefaultTableModel tblModelAsignatura = (DefaultTableModel) clControladorPrincipal.getInfGestionEncuesta().getTblAsignaturas().getModel();
       
       for (int i = 0; i < clEncuesta.getListaObjAsignatura().size(); i++) {
            listaStAsignatura = new Vector();
            listaStAsignatura.add(clEncuesta.getListaObjAsignatura().get(i).getStCodigo());
            listaStAsignatura.add(clEncuesta.getListaObjAsignatura().get(i).getStNombre());            
            tblModelAsignatura.addRow(listaStAsignatura);
        }  
        clControladorPrincipal.getInfGestionEncuesta().setDefaultTableModel(tblModelAsignatura);     
        
        clEncuestaBD = null;
        System.gc();
    }
     
     public  void cargarPeriodoCreacion(){
       clControladorPrincipal.getInfGestionEncuesta().getCbxCreacionPeriodoEncuesta().addItem("Seleccione");
       clControladorPrincipal.getInfGestionEncuesta().getCbxCreacionPeriodoEncuesta().addItem("FEBRERO-JUNIO");
       clControladorPrincipal.getInfGestionEncuesta().getCbxCreacionPeriodoEncuesta().addItem("AGOSTO-DICIEMBRE");  
        
     }
     
    
     
     
     
     
   /* public  void cargarCbxTipoPreguntaConsultar(int idCaracteristica){
       clTipoBD = new  TipoBD();
       listaObjTipo = new Vector();
       listaObjTipo = clTipoBD.listarTipo(idCaracteristica);
       
       clControladorPrincipal.getInfGestionEncuesta().getCbxTipoPreguntaConsultar().addItem("Seleccione");
       
        for (int i = 0; i < listaObjTipo.size(); i++) {
              clControladorPrincipal.getInfGestionEncuesta().getCbxTipoPreguntaConsultar().addItem(listaObjTipo.get(i).getStNombre());
        }
       
       clTipoBD = null;
       System.gc();
    }*/
    
    public  void deshabilitarComponentes(){
      clControladorPrincipal.getInfGestionEncuesta().getDtcFecha().setEnabled(false);
      clControladorPrincipal.getInfGestionEncuesta().getCbxCreacionPeriodoEncuesta().setEnabled(false);   
      deshabilitarCbxModificarEncuesta();
      
      clControladorPrincipal.getInfGestionEncuesta().getBtnListarPreguntas().setEnabled(false);
      clControladorPrincipal.getInfGestionEncuesta().getBtnListarAsignaturas().setEnabled(false);
      clControladorPrincipal.getInfGestionEncuesta().getBtnAceptarEncuesta().setEnabled(false);
      clControladorPrincipal.getInfGestionEncuesta().getBtnAniadirPregunta().setEnabled(false);      
      
      deshabilitarComponentesAniadirPregunta();
      
      habilitarCbxCaracteristica();
    
    }
    public  void habilitarComponentesCrearModificar(){
      clControladorPrincipal.getInfGestionEncuesta().getBtnListarPreguntas().setEnabled(true);  
      clControladorPrincipal.getInfGestionEncuesta().getDtcFecha().setEnabled(true);
      clControladorPrincipal.getInfGestionEncuesta().getCbxCreacionPeriodoEncuesta().setEnabled(true);      
      
      clControladorPrincipal.getInfGestionEncuesta().getBtnListarAsignaturas().setEnabled(true);
      
      clControladorPrincipal.getInfGestionEncuesta().getBtnAceptarEncuesta().setEnabled(true);
      clControladorPrincipal.getInfGestionEncuesta().getBtnAniadirPregunta().setEnabled(true);
      deshabilitarCbxCaracteristica();
    }
    
    public  void habilitarCbxModificarEncuesta(){
       clControladorPrincipal.getInfGestionEncuesta().getCbxModificarEncuesta().setEnabled(true);
    }
    public  void deshabilitarCbxModificarEncuesta(){
       clControladorPrincipal.getInfGestionEncuesta().getCbxModificarEncuesta().setEnabled(false);
    }
    public  void deshabilitarCbxCaracteristica(){
       clControladorPrincipal.getInfGestionEncuesta().getCbxCaracteristica().setEnabled(false);
    }
     public  void habilitarCbxCaracteristica(){
       clControladorPrincipal.getInfGestionEncuesta().getCbxCaracteristica().setEnabled(true);
    }
    public  void habilitarComponentesAniadirPregunta(){
      clControladorPrincipal.getInfGestionEncuesta().getTxtTipo().setEnabled(true);
      clControladorPrincipal.getInfGestionEncuesta().getTxaPregunta().setEnabled(true);
      clControladorPrincipal.getInfGestionEncuesta().getBtnAceptarAniadirPregunta().setEnabled(true);
     
     
    }
    public  void deshabilitarComponentesAniadirPregunta(){
      clControladorPrincipal.getInfGestionEncuesta().getTxtTipo().setEnabled(false);
      clControladorPrincipal.getInfGestionEncuesta().getTxaPregunta().setEnabled(false);
      clControladorPrincipal.getInfGestionEncuesta().getBtnAceptarAniadirPregunta().setEnabled(false);     
     }
    
   
    public  void limpiarInformacionEncuesta(){
       
      clControladorPrincipal.getInfGestionEncuesta().getDtcFecha().setDate(null);         
      
      clControladorPrincipal.getInfGestionEncuesta().limpiarTabla(clControladorPrincipal.getInfGestionEncuesta().getTblPreguntas());
      clControladorPrincipal.getInfGestionEncuesta().limpiarTabla(clControladorPrincipal.getInfGestionEncuesta().getTblAsignaturas());     
    }
    
    public void inicializarCbxCaracteristica(){
    clControladorPrincipal.getInfGestionEncuesta().getCbxCaracteristica().setSelectedIndex(0);
    }
    
    public  void limpiarInformacionAniadirPregunta(){
      clControladorPrincipal.getInfGestionEncuesta().getTxtTipo().setText("");
      clControladorPrincipal.getInfGestionEncuesta().getTxaPregunta().setText("");      
    }
    public  void limpiarCbxCreacionPeriodoEncuesta(){
        clControladorPrincipal.getInfGestionEncuesta().getCbxCreacionPeriodoEncuesta().removeAllItems();
    }
    
   
     public  void limpiarCbxModificarEncuesta(){
        clControladorPrincipal.getInfGestionEncuesta().getCbxModificarEncuesta().removeAllItems();
    }
    
    public void limpiarCbx(){
       limpiarCbxCreacionPeriodoEncuesta();       
       limpiarCbxModificarEncuesta();       
    }
    
    
    public  void reiniciarVentana(){
     limpiarInformacionEncuesta();
     inicializarCbxCaracteristica();
     limpiarInformacionAniadirPregunta();
     deshabilitarComponentes();
     limpiarCbx();
     inOpcion = -1;
    
    }
    public  void limpiarMensajes(){
        //Gestion Ecnuesta
       clControladorPrincipal.getInfGestionEncuesta().getLblMensajeCaracteristicaPregunta().setText("");
       clControladorPrincipal.getInfGestionEncuesta().getLblMensajeAceptarAniadirPregunta().setText("");
       clControladorPrincipal.getInfGestionEncuesta().getLblMensajeFecha().setText("");
       clControladorPrincipal.getInfGestionEncuesta().getLblMensajePeriodo().setText("");
       clControladorPrincipal.getInfGestionEncuesta().getLblMensajePreguntaTabla().setText("");
       clControladorPrincipal.getInfGestionEncuesta().getLblMensajeAsignaturaTabla().setText("");
       clControladorPrincipal.getInfGestionEncuesta().getLblMensajeAceptarRegistroEncuesta().setText("");
       clControladorPrincipal.getInfGestionEncuesta().getLblMensajeTipoAniadir().setText("");
       clControladorPrincipal.getInfGestionEncuesta().getLblMensajePreguntaAniadir().setText("");
       clControladorPrincipal.getInfGestionEncuesta().getLblMensajeAceptarHee().setText("");
       
       //Habilatar Encuesta general
       clControladorPrincipal.getInfGestionEncuesta().getLblMensajeSeleccioneEncuestaHeg().setText("");
    }
    
    public void seleccionarAsignaturasPorDefecto(){
       int inColumna = 2;
        for (int i = 0; i < clControladorPrincipal.getInfGestionEncuesta().getTblAsignaturas().getRowCount(); i++) {           
                 clControladorPrincipal.getInfGestionEncuesta().getTblAsignaturas().setValueAt(true,i ,inColumna);     
        }   
    }
    public void seleccionarPreguntasPorDefecto(){
       int inColumna = 2;
        for (int i = 0; i < clControladorPrincipal.getInfGestionEncuesta().getTblPreguntas().getRowCount(); i++) {           
                 clControladorPrincipal.getInfGestionEncuesta().getTblPreguntas().setValueAt(true,i ,inColumna);     
        }   
    }
     
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
       
        String stComando = actionEvent.getActionCommand();
        limpiarMensajes();      
        
        if(stComando.equals("CrearEncuesta")){            
            limpiarCbx();
            limpiarInformacionAniadirPregunta();
            deshabilitarCbxModificarEncuesta();       
            limpiarInformacionEncuesta();            
            deshabilitarComponentes();
            
            if(clControladorPrincipal.getInfGestionEncuesta().getCbxCaracteristica().getSelectedIndex()>0){    
                inOpcion =0;
                deshabilitarCbxCaracteristica();
                habilitarComponentesCrearModificar();
                cargarPeriodoCreacion();            
                
             
                
            }else{
                clControladorPrincipal.getInfGestionEncuesta().getLblMensajeCaracteristicaPregunta().setText("Selecione Caracteristica De la Pregunta.");
            
            }            
        }else{
             if(stComando.equals("ReiniciarVentana")){
                reiniciarVentana();
             }else{
                if(stComando.equals("ListarPreguntas")){   
                    if(inOpcion==0){
                      consultarPreguntas(listaObjCaracteristica.get(clControladorPrincipal.getInfGestionEncuesta().getCbxCaracteristica().getSelectedIndex()-1).getInIdCaracteristica());
                      cargarTblPreguntas();      
                    }else{
                        if(inOpcion==1){
                           ListarPreguntasModificar(listaObjCaracteristica.get(clControladorPrincipal.getInfGestionEncuesta().getCbxCaracteristica().getSelectedIndex()-1).getInIdCaracteristica());
                        }
                    }                          
                    
                }else{
                     if(stComando.equals("ListarAsignaturas")){                          
                        if(inOpcion==0){ 
                            consultarAsignaturas();
                            cargarTblAsignaturas();                       
                            if(clControladorPrincipal.quitarEspacios(clControladorPrincipal.getInfGestionEncuesta().getCbxCaracteristica().getSelectedItem().toString()).equals("GENERAL")){
                               seleccionarAsignaturasPorDefecto();
                            }
                        }else{
                           if(inOpcion==1){
                              ListarAsignaturasModificar();                              
                           }
                        }
                     }else{
                          if(stComando.equals("AniadirPregunta")){   
                              habilitarComponentesAniadirPregunta();
                          }else{
                               if(stComando.equals("AceptarAniadirPregunta")){
                                 if(registrarInformacionPregunta()>-1){
                                     System.out.println(clPregunta.getStPregunta());
                                     System.out.println(clPregunta.getClTipo().getStNombre());
                                     aniadirPreguntaATabla();
                                     limpiarInformacionAniadirPregunta();
                                    
                                     
                                     clControladorPrincipal.getInfGestionEncuesta().getLblMensajeAceptarAniadirPregunta().setText("Se Registro y Se añadio A La Tabla Con Exito ");
                                 }                               
                               }else{
                                       if(stComando.equals("ModificarEncuesta")){
                                            
                                            limpiarCbx();                                            
                                            limpiarInformacionEncuesta();
                                            limpiarInformacionAniadirPregunta();
                                            deshabilitarComponentes();
                                            
                                            if(clControladorPrincipal.getInfGestionEncuesta().getCbxCaracteristica().getSelectedIndex()>0){                                             
                                                deshabilitarCbxCaracteristica();
                                                habilitarCbxModificarEncuesta(); 
                                                cargarPeriodoCreacion();
                                                cargarCbxModificarEncuesta();                                            
                                                habilitarCbxModificarEncuesta(); 
                                                clRegistrarAsignaturaEncuestaPregunta = new Encuesta();

                                            }else{
                                                clControladorPrincipal.getInfGestionEncuesta().getLblMensajeCaracteristicaPregunta().setText("Selecione Caracteristica De la Pregunta.");

                                            }                                                                  
                                       }else{
                                            if(stComando.equals("RegistrarFormulario")){
                                                if(inOpcion==0){
                                                    if(clControladorPrincipal.getInfGestionEncuesta().validarCamposGestionarEncuesta()){
                                                        resgistrarEncuesta();      
                                                        capturarAsignaturasSeleccionadas();
                                                        capturarPreguntasSeleccionadas();
                                                        registrarFormulario();   
                                                                                                              
                                                        reiniciarVentana();
                                                        clControladorPrincipal.getInfGestionEncuesta().getLblMensajeAceptarRegistroEncuesta().setText("Registro Exitoso");
                                                    }
                                                }else{
                                                     if(inOpcion==1){
                                                          if(clControladorPrincipal.getInfGestionEncuesta().validarCamposGestionarEncuesta()){
                                                             eliminarAsignaturasDeEncuesta();
                                                             eliminarPreguntasAsignaturasDeEncuesta();
                                                             registraPreguntasAsignaturasAniadidas();                                                              
                                                             reiniciarVentana();
                                                             clControladorPrincipal.getInfGestionEncuesta().getLblMensajeAceptarRegistroEncuesta().setText("Modificacion Exitosa");
                                                          }
                                                     }
                                                }
                                               
                                            }else{
                                                   if(stComando.equals("ListarAsignaturasHeg")){
                                                        if(clControladorPrincipal.getInfGestionEncuesta().getCbxEncuestaHeg().getSelectedIndex()>0){  
                                                           consultarAsignaturasHeg();
                                                           cargarTblAsignaturasHeg();
                                                        }else{
                                                            clControladorPrincipal.getInfGestionEncuesta().getLblMensajeSeleccioneEncuestaHeg().setText("Seleccione la Encuesta");
                                                        }
                                                   }else{
                                                         if(stComando.equals("HabilitarHeg")){ 
                                                             habilitarComponentesHeg();
                                                             cargarCbxEncuestaHeg();                                                   
                                                         
                                                         }else{
                                                              if(stComando.equals("AceptarHeg")){
                                                                  if(clControladorPrincipal.getInfGestionEncuesta().validarCamposHabilitarEncuestaGeneral()){
                                                                   consultarAsignaturasHeg();
                                                                   habilitarEncuestaGenera();
                                                                   limpiarInformacionHeg();
                                                                   deshabilitarComponentesHeg();    
                                                                   clControladorPrincipal.getInfGestionEncuesta().getLblMensajeAceptarHeg().setText("Operacion Exitosa");
                                                                   
                                                                  }
                                                              }else{
                                                                   if(stComando.equals("ListarEncuestasHee")){
                                                                       consultarAsignaturasHee();                                                                      
                                                                       cargarTablaEncuestaHee();
                                                                       
                                                                       
                                                                   
                                                                   }else{
                                                                        if(stComando.equals("HabilitarHee")){
                                                                            habilitarComponentesHee();
                                                                        }else{
                                                                             if(stComando.equals("AceptarHee")){
                                                                                /*Falta registrar encuestas habilitadas*/                                                                                 
                                                                                 habilitarEncuestaEspecial();
                                                                                 deshabilitarComponentesHee();
                                                                                 limpiarInformacionHee();
                                                                                 clControladorPrincipal.getInfGestionEncuesta().getLblMensajeAceptarHee().setText("Operacion Exitosa");
                                                                                 
                                                                             }
                                                                        
                                                                        }
                                                                   }
                                                              }
                                                         
                                                         }
                                                       
                                                   
                                                   }
                                            
                                            }
                                       
                                       }
                                 }
                               
                          } 
                     }
                
                }
             
             }
        }
        
    }
    
     
    public  int registrarInformacionPregunta(){
        
       clTipoBD = new TipoBD();      
       clPreguntaBD = new PreguntaBD();
       clTipo = null;
       clPregunta = new Pregunta();
       clCaracteristica = new Caracteristica();
       boolean blRegistrar = true;

       int inIdTipo =-1;  
       int inIdPregunta =-1;  
      
       String stTipo =clControladorPrincipal.quitarEspacios(clControladorPrincipal.getInfGestionEncuesta().getTxtTipo().getText().toUpperCase());
       int inCaracteristica = listaObjCaracteristica.get( clControladorPrincipal.getInfGestionEncuesta().getCbxCaracteristica().getSelectedIndex()-1).getInIdCaracteristica();      
       String stPregunta = clControladorPrincipal.getInfGestionEncuesta().getTxaPregunta().getText();      
       
       clTipo = clTipoBD.consultarTipo(stTipo);      
       
       if(clTipo!=null){
         inIdTipo = clTipo.getInIdTipo();
         
          if(clTipo.getClCaracteristica().getInIdCaracteristica()!=listaObjCaracteristica.get(
               clControladorPrincipal.getInfGestionEncuesta().getCbxCaracteristica().getSelectedIndex()-1).getInIdCaracteristica()){
              
               clControladorPrincipal.getInfGestionEncuesta().getLblMensajeAceptarAniadirPregunta().setText("Tipo "+stTipo+" Es De Encuesta "+ 
                                             clControladorPrincipal.quitarEspacios(clTipo.getClCaracteristica().getStNombre())+", Operacion Fallida");
               blRegistrar = false;
           
          } 
       } 
       
      if(blRegistrar){
          inIdPregunta = clPreguntaBD.consultarPregunta(stPregunta);
          if(inIdTipo==-1){
              clTipo = new Tipo();
              inIdTipo =  clTipoBD.registrarTipo(stTipo,inCaracteristica);   
           }        
           if(inIdPregunta==-1){
               System.out.println("Aqui1");
               inIdPregunta = clPreguntaBD.registrarPregunta(stPregunta,inIdTipo);
               System.out.println("Aqui2"+inIdPregunta);
               
               clTipo .setInIdTipo(inIdTipo);
               clTipo.setStNombre(stTipo);
               clCaracteristica.setInIdCaracteristica(inCaracteristica);
               clTipo.setClCaracteristica(clCaracteristica);
               clPregunta.setClTipo(clTipo);
               clPregunta.setInIdPregunta(inIdPregunta);
               clPregunta.setStPregunta(stPregunta);    
           }else{
              clControladorPrincipal.getInfGestionEncuesta().getLblMensajePreguntaAniadir().setText("La Pregunta Ya fue Registrada Anteriormente");
              inIdPregunta =-1;
           }  

                   
       }
       clTipoBD = null;
       clPreguntaBD = null;
       clTipo = null;
       clCaracteristica = null;
      
       System.gc(); 
       
     return inIdPregunta ;
    }
    
    public  void aniadirPreguntaATabla(){
        
        DefaultTableModel tblPregunta = (DefaultTableModel) clControladorPrincipal.getInfGestionEncuesta().getTblPreguntas().getModel();
        
        Vector<String>listaStPregunta = new Vector();
        listaStPregunta.add(clPregunta.getStPregunta());
        listaStPregunta.add(clPregunta.getClTipo().getStNombre());        
        tblPregunta.addRow(listaStPregunta);
        if(inOpcion==0){
           clEncuesta.agregarPreguntas(clPregunta);
        }else{
             if(inOpcion==1){                
               clRegistrarAsignaturaEncuestaPregunta.agregarPreguntas(clPregunta);                                   
             }
        }
        
        
    }
    public  String capturarFecha(){
       Date fecha =clControladorPrincipal.getInfGestionEncuesta().getDtcFecha().getDate();
       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd"); 
      return formato.format(fecha);
    }
    
    public  int resgistrarEncuesta(){      
      clEncuestaBD = new EncuestaBD(); 
      clEncuestaResgistro = new Encuesta();
      clEncuestaResgistro.setStFecha(capturarFecha());    
      clEncuestaResgistro.setStPeriodo(clControladorPrincipal.getInfGestionEncuesta().getCbxCreacionPeriodoEncuesta().getSelectedItem().toString());
      int inIdEncuesta = clEncuestaBD.registrarEncuesta(clEncuestaResgistro);
      System.out.println("IdEncuesta:"+inIdEncuesta);
      clEncuestaResgistro.setInCodigo(inIdEncuesta);
      clEncuestaBD = null;
      System.gc();
      return inIdEncuesta;
    
    }
 
    public void capturarAsignaturasSeleccionadas(){
        int inColumnaCheckBox = 2;
        boolean blEstadoCheckBox = false;
       
        
         for (int i = 0; i < clControladorPrincipal.getInfGestionEncuesta().getTblAsignaturas().getRowCount(); i++){ 
             System.out.println("Tamaño::"+clEncuesta.getListaObjAsignatura().size());
            if(clControladorPrincipal.getInfGestionEncuesta().getTblAsignaturas().getValueAt(i,inColumnaCheckBox)!=null){ 
                blEstadoCheckBox =(boolean) clControladorPrincipal.getInfGestionEncuesta().getTblAsignaturas().getValueAt(i,inColumnaCheckBox);
                if(blEstadoCheckBox){                  
                     clEncuestaResgistro.agregarAsignaturas(clEncuesta.getListaObjAsignatura().get(i));
                }                
            }                    
        } 
    }   
    
     public void capturarPreguntasSeleccionadas(){
        int inColumnaCheckBox = 2;
        boolean blEstadoCheckBox = false;
       
        
         for (int i = 0; i < clControladorPrincipal.getInfGestionEncuesta().getTblPreguntas().getRowCount(); i++){ 
            System.out.println("Tamaño::"+clEncuesta.getListaObjPregunta().size());
            if(clControladorPrincipal.getInfGestionEncuesta().getTblPreguntas().getValueAt(i,inColumnaCheckBox)!=null){ 
                blEstadoCheckBox =(boolean) clControladorPrincipal.getInfGestionEncuesta().getTblPreguntas().getValueAt(i,inColumnaCheckBox);
                if(blEstadoCheckBox){                  
                     clEncuestaResgistro.agregarPreguntas(clEncuesta.getListaObjPregunta().get(i));
                      System.out.println("Entroo7");
                }                
            }                    
        } 
    }
    
    public  Vector<Integer> registrarEncuestaAsignatura(){
      clEncuestaBD = new EncuestaBD();        
      Vector<Integer>listaInEncuestaAsignatura = clEncuestaBD.registrarEncuestaAsignatura(clEncuestaResgistro);      
      clEncuestaBD = null;
      System.gc();
     
     return listaInEncuestaAsignatura;    
    } 
    
    public void registrarFormulario(){
       clEncuestaBD = new EncuestaBD();
       System.out.println("contador Formulario:"+clEncuestaBD.registrarFormulario(clEncuestaResgistro, registrarEncuestaAsignatura()));  
       clEncuestaBD = null;
        System.gc();   
    }
    public  void cargarCbxModificarEncuesta(){
       clEncuestaBD = new EncuestaBD();
       int inIdCaracteristica = listaObjCaracteristica.get(clControladorPrincipal.getInfGestionEncuesta().getCbxCaracteristica().getSelectedIndex()-1).getInIdCaracteristica();
       listaObjEncuesta= clEncuestaBD.listarEncuestas(inIdCaracteristica);        
       clControladorPrincipal.getInfGestionEncuesta().getCbxModificarEncuesta().addItem("Seleccione");
        for (int i = 0; i < listaObjEncuesta.size(); i++) {
            clControladorPrincipal.getInfGestionEncuesta().getCbxModificarEncuesta().addItem(listaObjEncuesta.get(i).getStFecha()+" - "+listaObjEncuesta.get(i).getStPeriodo());
        }   
        clEncuestaBD = null;
        System.gc();
    }
    
    public  void consultarFomularioAModificar(){
      int inIdEncuesta = listaObjEncuesta.get(clControladorPrincipal.getInfGestionEncuesta().getCbxModificarEncuesta().getSelectedIndex()-1).getInCodigo();
      int inIdCaracteristica = listaObjCaracteristica.get(clControladorPrincipal.getInfGestionEncuesta().getCbxCaracteristica().getSelectedIndex()-1).getInIdCaracteristica();
      
      clEncuestaBD = new EncuestaBD();
      clEncuesta = clEncuestaBD.consultarFormulario(inIdEncuesta, inIdCaracteristica);
      
      clEncuestaBD = null;
      System.gc();    
    
    }
   
  

    @Override
    public void mouseClicked(MouseEvent me) {
        
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

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
       if(itemEvent.getStateChange()==ItemEvent.SELECTED){
          if(clControladorPrincipal.getInfGestionEncuesta().getCbxModificarEncuesta().getSelectedIndex()>0){            
                consultarFomularioAModificar();            
                cargarTblPreguntas();
                cargarTblAsignaturas(); 
                seleccionarAsignaturasPorDefecto();
                seleccionarPreguntasPorDefecto();
                habilitarComponentesCrearModificar();
                inOpcion = 1;
              try {
                  cargarInformacionEncuesta();
              } catch (ParseException ex) {
                 
              }
           }
       }        
    }
    
    public void cargarInformacionEncuesta() throws ParseException{
        
         DateFormat formatoFechaBD = new SimpleDateFormat("yyyy-MM-dd");
         Date dtFecha =formatoFechaBD.parse(clEncuesta.getStFecha());
      
         DateFormat formatoFechaJDateChooser = new SimpleDateFormat("dd-MM-yyyy");
           
         formatoFechaJDateChooser.format(dtFecha);
         
         clControladorPrincipal.getInfGestionEncuesta().getDtcFecha().setDate(dtFecha);

         if(clEncuesta.getStPeriodo().equals(clControladorPrincipal.getInfGestionEncuesta().getCbxCreacionPeriodoEncuesta().getItemAt(0).toString())){
             clControladorPrincipal.getInfGestionEncuesta().getCbxCreacionPeriodoEncuesta().setSelectedIndex(0);
         }else{
             clControladorPrincipal.getInfGestionEncuesta().getCbxCreacionPeriodoEncuesta().setSelectedIndex(1);
         }          
    }
    
    
    /**********************************************Habilitar Encuesta Con Caracteristica De Preguntas General**************/
    public  void deshabilitarComponentesHeg(){
      clControladorPrincipal.getInfGestionEncuesta().getCbxEncuestaHeg().setEnabled(false);
     
      
      clControladorPrincipal.getInfGestionEncuesta().getBtnListarAsignaturasHeg().setEnabled(false);    
      clControladorPrincipal.getInfGestionEncuesta().getBntAceptarHeg().setEnabled(false);
    } 
    
    public  void habilitarComponentesHeg(){
      clControladorPrincipal.getInfGestionEncuesta().getCbxEncuestaHeg().setEnabled(true);
     
      
      clControladorPrincipal.getInfGestionEncuesta().getBtnListarAsignaturasHeg().setEnabled(true); 
      clControladorPrincipal.getInfGestionEncuesta().getBntAceptarHeg().setEnabled(true);    
    }
    
    public  void limpiarInformacionHeg(){
      clControladorPrincipal.getInfGestionEncuesta().getCbxEncuestaHeg().removeAllItems();            
    
      clControladorPrincipal.getInfGestionEncuesta().limpiarTabla(clControladorPrincipal.getInfGestionEncuesta().getTblAsignaturasHeg());
    }
    
    public  void cargarCbxEncuestaHeg(){
       clEncuestaBD = new EncuestaBD();
       int inIdCaracteristica = 1;
       listaObjEncuestaHeg= clEncuestaBD.listarEncuestas(inIdCaracteristica); 
        clControladorPrincipal.getInfGestionEncuesta().getCbxEncuestaHeg().removeAllItems();
       clControladorPrincipal.getInfGestionEncuesta().getCbxEncuestaHeg().addItem("Seleccione");
        for (int i = 0; i < listaObjEncuestaHeg.size(); i++) {
            System.out.println("Estado "+listaObjEncuestaHeg.get(i).isBlEstado());
            if(listaObjEncuestaHeg.get(i).isBlEstado()){
                clControladorPrincipal.getInfGestionEncuesta().getCbxEncuestaHeg().addItem(listaObjEncuestaHeg.get(i).getStFecha()+" - "+listaObjEncuestaHeg.get(i).getStPeriodo()+"HABILITADA");
            }else{
                clControladorPrincipal.getInfGestionEncuesta().getCbxEncuestaHeg().addItem(listaObjEncuestaHeg.get(i).getStFecha()+" - "+listaObjEncuestaHeg.get(i).getStPeriodo());
            }
          
        }   
        clEncuestaBD = null;
        System.gc();
    }
    
     public  void consultarAsignaturasHeg(){
      int inIdEncuesta = listaObjEncuestaHeg.get(clControladorPrincipal.getInfGestionEncuesta().getCbxEncuestaHeg().getSelectedIndex()-1).getInCodigo();
      int inIdCaracteristica = 1;
      
      clEncuestaBD = new EncuestaBD();
      clEncuestaHeg = clEncuestaBD.consultarAsignaturas(inIdEncuesta, inIdCaracteristica,new Encuesta());      
      
      clEncuestaBD = null;
      System.gc();    
    
    }
    
     public  void cargarTblAsignaturasHeg(){
       clControladorPrincipal.getInfGestionEncuesta().limpiarTabla(clControladorPrincipal.getInfGestionEncuesta().getTblAsignaturasHeg()); 
       Vector<String>listaStAsignatura;
       DefaultTableModel tblModelAsignatura = (DefaultTableModel) clControladorPrincipal.getInfGestionEncuesta().getTblAsignaturasHeg().getModel();
       
       for (int i = 0; i < clEncuestaHeg.getListaObjAsignatura().size(); i++) {
            listaStAsignatura = new Vector();
            listaStAsignatura.add(clEncuestaHeg.getListaObjAsignatura().get(i).getStCodigo());
            listaStAsignatura.add(clEncuestaHeg.getListaObjAsignatura().get(i).getStNombre());            
            tblModelAsignatura.addRow(listaStAsignatura);
        }  
        clControladorPrincipal.getInfGestionEncuesta().setDefaultTableModel(tblModelAsignatura);     
        
        clEncuestaBD = null;
        System.gc();
    }     
    
     
    public  void habilitarEncuestaGenera(){
       clEncuestaBD = new EncuestaBD();
       
       int idCaracteristica = 1;
       Vector<Encuesta>listaObjEncuesta = clEncuestaBD.listarEncuestas(idCaracteristica);
       
        for (int i = 0; i <listaObjEncuesta.size() ; i++) {
             clEncuestaBD.modificarFormularioEstadoDeshabilitadoHeg(listaObjEncuesta.get(i).getInCodigo());            
        }
        clEncuestaBD.modificarFormularioEstadoHabilitadoHeg(clEncuestaHeg.getInCodigo());
      
       clEncuestaBD = null;
       System.gc();
    
    }
    /* **************************   Habilitar Encuesta Con Caracteristica De Preguntas Especial***************************/
     public void consultarTiposHee(){ 
       int inCaracteristica = 2;
       clPreguntaBD = new PreguntaBD();      
               
       listaObjTipo =clPreguntaBD.listarTipos(inCaracteristica);
       clPreguntaBD = null;
       System.gc();    
    }
  /*  public void cargarCbxTipoHee(){
       consultarTiposHee();
       clControladorPrincipal.getInfGestionEncuesta().getCbxTipoHee().removeAllItems();
       clControladorPrincipal.getInfGestionEncuesta().getCbxTipoHee().addItem("Seleccione");
        for (int i = 0; i < listaObjTipo.size(); i++) {
            clControladorPrincipal.getInfGestionEncuesta().getCbxTipoHee().addItem(listaObjTipo.get(i).getStNombre());
        }  
    }*/
    
    public void consultarAsignaturasHee(){
       int inCaracteristica = 2; 
       clEncuestaBD = new EncuestaBD();  
       listaObjEncuestaHee = new Vector();
       Vector <Encuesta>listaObjEncuestaAux= clEncuestaBD.listarEncuestas(inCaracteristica);
       
       for (int i = 0; i < listaObjEncuestaAux.size(); i++) {
              listaObjEncuestaHee.add(clEncuestaBD.consultarAsignaturas(listaObjEncuestaAux.get(i).getInCodigo(),inCaracteristica));     
       }        
       clPreguntaBD = null;
       System.gc();    
    }
    public void seleccionarEncuestasHabilitadasEnlaBD(){
       int inColumna = 3;
       int inContador =0;       
       
       
       for (int i = 0; i <listaObjEncuestaHee.size(); i++){ 
                System.out.println("Que paso1");
            for (int j = 0; j <listaObjEncuestaHee.get(i).getListaObjAsignatura().size(); j++){
                 System.out.println("Que paso2");
                if(listaObjEncuestaHee.get(i).isBlEstado()){
                  clControladorPrincipal.getInfGestionEncuesta().getTblEncuestasHee().setValueAt(true,inContador ,inColumna);                  
                }else{
                    System.out.println("es false");
                }
               
                 inContador++;
            }
       }          
    }
   
    
    public void cargarTablaEncuestaHee(){  
       
       clControladorPrincipal.getInfGestionEncuesta().limpiarTabla(clControladorPrincipal.getInfGestionEncuesta().getTblEncuestasHee()); 
       Vector<String>listaStEncuesta;
       DefaultTableModel tblModelEncuesta = (DefaultTableModel) clControladorPrincipal.getInfGestionEncuesta().getTblEncuestasHee().getModel();
       int inContador =0;
       for (int i = 0; i < listaObjEncuestaHee.size(); i++) {
            ++inContador;
           for (int j = 0; j < listaObjEncuestaHee.get(i).getListaObjAsignatura().size(); j++) {
                listaStEncuesta = new Vector();
                listaStEncuesta.add("Encuesta "+(inContador)+"."+listaObjEncuestaHee.get(i).getStFecha());
                listaStEncuesta.add(listaObjEncuestaHee.get(i).getListaObjAsignatura().get(j).getStCodigo());
                listaStEncuesta.add(listaObjEncuestaHee.get(i).getListaObjAsignatura().get(j).getStNombre()); 
                tblModelEncuesta.addRow(listaStEncuesta);
           }    
        }  
        clControladorPrincipal.getInfGestionEncuesta().setDefaultTableModel(tblModelEncuesta);     
       
        clEncuestaBD = null;
        System.gc();
        
         seleccionarEncuestasHabilitadasEnlaBD();
    }
    
    public void deshabilitarComponentesHee(){
         clControladorPrincipal.getInfGestionEncuesta().getBtnListarEncuestasHee().setEnabled(false);
         clControladorPrincipal.getInfGestionEncuesta().getBtnAceptarHee().setEnabled(false);    
    }
    public void habilitarComponentesHee(){
         clControladorPrincipal.getInfGestionEncuesta().getBtnListarEncuestasHee().setEnabled(true);
         clControladorPrincipal.getInfGestionEncuesta().getBtnAceptarHee().setEnabled(true);    
    }
    
    public  Vector <Encuesta>  capturarEncuestasSeleccionadasHee(){
       int inColumnaCheckBox = 3;
        boolean blEstadoCheckBox = false;           
        
        listaObjEncuestaHabilitar = new Vector();   
        int inContador =0;
         
         System.out.println("Tamaño vector listaObjEncuestaHee: "+  listaObjEncuestaHee.size());
         for (int i = 0; i <listaObjEncuestaHee.size(); i++){ 
               
                 for (int j = 0; j <listaObjEncuestaHee.get(i).getListaObjAsignatura().size(); j++){ 
                     System.out.println("Hola mundo sin validacion "+clControladorPrincipal.getInfGestionEncuesta().getTblEncuestasHee().getValueAt(inContador,inColumnaCheckBox));
                    if(clControladorPrincipal.getInfGestionEncuesta().getTblEncuestasHee().getValueAt(inContador,inColumnaCheckBox)!=null){ 
                        blEstadoCheckBox =(boolean) clControladorPrincipal.getInfGestionEncuesta().getTblEncuestasHee().getValueAt(inContador,inColumnaCheckBox);

                      
                        if(blEstadoCheckBox){                  
                            System.out.println("Hola mundo hee");          

                             listaObjEncuestaHabilitar.add(listaObjEncuestaHee.get(i));
                        }         
                    }else{
                         System.out.println("Es null hee");   
                    }   
                    inContador++;
                 }
                 
        }
         
         return listaObjEncuestaHabilitar;       
    }
    
    public  void habilitarEncuestaEspecial(){
       clEncuestaBD = new EncuestaBD();    
       capturarEncuestasSeleccionadasHee();
      
       int idCaracteristica = 2;
       Vector<Encuesta>listaObjEncuestaDeshabilitar = clEncuestaBD.listarEncuestas(idCaracteristica);       
     
        for (int j = 0; j <listaObjEncuestaDeshabilitar.size() ; j++) {
              clEncuestaBD.modificarFormularioEstadoDeshabilitadoHeg(listaObjEncuestaDeshabilitar.get(j).getInCodigo());    
        }
        
        for (int i = 0; i <listaObjEncuestaHabilitar.size() ; i++) {
               clEncuestaBD.modificarFormularioEstadoHabilitadoHeg( listaObjEncuestaHabilitar.get(i).getInCodigo());
        }
       clEncuestaBD = null;
       System.gc();    
    }
    
    public  void limpiarInformacionHee(){             
    
      clControladorPrincipal.getInfGestionEncuesta().limpiarTabla(clControladorPrincipal.getInfGestionEncuesta().getTblEncuestasHee());
    }
    
    
}
