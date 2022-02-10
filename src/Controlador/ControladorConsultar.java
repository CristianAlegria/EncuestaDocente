/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Docente;
import Modelo.Estudiante;
import Vista.InfConsultar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Clase controlador consultar, la cual permite capturar las peticiones que se realicen en la ventana consultar.
 * @author Cristian Alexis Alegria C.
 * @version 1.0.0
 * @since SIGED 1.0.0
 */
public class ControladorConsultar implements ActionListener{
    
     private ControladorPrincipal clControladorPrincipal;
     private Docente clDocente;
     private Estudiante clEstudiante;
     private Vector<String>listaStPersona;
     private int inId;

     
    /**
    *Metodo constructor que inicializa el controlador principal.
    *@param clControladorPrincipal ControladorPrincipal:Controlador Principal.
    *@since SIGED 1.0.0
    */
    public ControladorConsultar(ControladorPrincipal clControladorPrincipal) {
        this.clControladorPrincipal = clControladorPrincipal;
    }

    public ControladorPrincipal getClControladorPrincipal() {
        return clControladorPrincipal;
    }

    public void setClControladorPrincipal(ControladorPrincipal clControladorPrincipal) {
        this.clControladorPrincipal = clControladorPrincipal;
    }

    public Docente getClDocente() {
        return clDocente;
    }

    public void setClDocente(Docente clDocente) {
        this.clDocente = clDocente;
    }

    public Estudiante getClEstudiante() {
        return clEstudiante;
    }

    public void setClEstudiante(Estudiante clEstudiante) {
        this.clEstudiante = clEstudiante;
    }

    public Vector<String> getListaStPersona() {
        return listaStPersona;
    }

    public void setListaStPersona(Vector<String> listaStPersona) {
        this.listaStPersona = listaStPersona;
    }

   

    public int getInId() {
        return inId;
    }

    public void setInId(int inId) {
        this.inId = inId;
    }   
    
    /**
    *Metodo encargado colocar el titulo a la ventana consultar y colocar  nombres al comando de accion del botones buscar. 
    *@since SIGED 1.0.0
    */
    public void iniciarInfConsultar(){         
        clControladorPrincipal.getInfConsultar().setTitle("Consultar");            
         //Se añaden las acciones a los controles
        clControladorPrincipal.getInfConsultar().getBtnBuscarDocente().setActionCommand("BuscarDocente");
        clControladorPrincipal.getInfConsultar().getBtnBuscarEstudiante().setActionCommand("BuscarEstudiante");
        //centrado de formulario             
    } 
    

    /**
    *Metodo encargado de abrir la ventana consultar, mostrar todo los componentes que la conforman,de centrarla en pantalla y
    *activar los escuchadores de eventos que ocurran en ella.  
    *@since SIGED 1.0.0
    */
    public void iniciarConsulta(){
//        if(clControladorPrincipal.estaCerrado(clControladorPrincipal.getInfConsultar())){//se crea nuevo
           
            clControladorPrincipal.setInfConsultar(new InfConsultar());            
            clControladorPrincipal.getFrmPrincipal().getDstContenedorPrincipal().add(clControladorPrincipal.getInfConsultar());        
            
            //Se pone a escuchar
             clControladorPrincipal.getInfConsultar().getBtnBuscarDocente().addActionListener(this);
             clControladorPrincipal.getInfConsultar().getBtnBuscarEstudiante().addActionListener(this);
            
            //centrado de formulario
             centrarVentana(clControladorPrincipal.getInfConsultar());               
             iniciarInfConsultar();
       /*}
       else{
          JOptionPane.showMessageDialog(this.clControladorPrincipal.getFrmPrincipal(),"La ventana de 'Consultar' ya esta abierta.");
       }*/
    }
    
    /**
    *Metodo encargado de centrar la ventana consultar.
    *@param infVentana JInternalFrame:Ventana consultar.
    *@since SIGED 1.0.0
    */
    
     public void centrarVentana(JInternalFrame infVentana){       
        
        clControladorPrincipal.getInfConsultar().setLocation(clControladorPrincipal.centradoXY(infVentana));
        clControladorPrincipal.getInfConsultar().setVisible(true);
    }
     
    /**
    *Metodo encargado de capturar y reponder a los eventos que ocurran en la ventana consultar.
    *@param actionEvent ActionEvent:Evento que se acciona. 
    *@since SIGED 1.0.0
    */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
         String stComando = actionEvent.getActionCommand();         
         listaStPersona = new Vector();
         
         limpiarTabla(clControladorPrincipal.getInfConsultar().getTblInformacion());
         
         if (stComando.equals("BuscarDocente")){
             
             if(clControladorPrincipal.getInfConsultar().validarcampoConsultar("Cedula")){             
                  clDocente = new Docente();
                  inId = capturarId();                
                  clDocente = clDocente.buscarDocente(inId);  
                      
                 if (clDocente != null) {
                     clDocente.destroyClDocenteBD();
                     mostrarDatosTabla(setDatosDocente()); 
                     clDocente = null;
                     System.gc();
                 }else{
                   clControladorPrincipal.getInfConsultar().getLblMensajeId().setText("No Existe El Docente");
                 }                 
             }              
            
        }else{
               if (stComando.equals("BuscarEstudiante")){
                     
                    if(clControladorPrincipal.getInfConsultar().validarcampoConsultar("Codigo")){               
                         clEstudiante = new Estudiante();
                         
                         inId = capturarId();
                         
                         clEstudiante = clEstudiante.buscarEstudiante(inId);                             
                                             
                         if (clEstudiante != null) {
                             clEstudiante.destroyClEstudianteBD();
                             mostrarDatosTabla(setDatosEstudiante()); 
                             clEstudiante = null;
                             System.gc();
                         }else{
                             clControladorPrincipal.getInfConsultar().getLblMensajeId().setText("No Existe El Estudiante");
                        }             
                   }
                  
               }
         }
    }
    
    /**
    *Metodo encargado de capturar la identificacion del estudiante o docente a consultar y retornar su valor.
    *@return Retorna identificacion del estudiante o docente a consultar.
    *@since SIGED 1.0.0
    */
    public int capturarId(){
        
       return Integer.parseInt(clControladorPrincipal.getInfConsultar().getTxtId().getText());  
                              
    }
    
    /**
    *Metodo encargado de colocar y mostrar los datos en la tabla.
    *@param listaDatosPersona Vector de tipo String:Vector que contiene los datos de la persona a mostrar.
    *@since SIGED 1.0.0
    */
    public  void mostrarDatosTabla(Vector <String>listaDatosPersona){
        
        DefaultTableModel tblInformacion = (DefaultTableModel) clControladorPrincipal.getInfConsultar().getTblInformacion().getModel();        
        tblInformacion.addRow(listaDatosPersona);        
    }
    
    /**
    *Metodo encargado de asignar los datos del docente al vector listaStPersona.
    *@return Vector de tipo String listaStPersona:Vector con la informacion del docente.
    *@since SIGED 1.0.0
    */
    public  Vector<String> setDatosDocente(){
       listaStPersona.add(clDocente.getStNombreCompleto());
       listaStPersona.add(Integer.toString(clDocente.getClPlan().getIdplan()));
       
       return listaStPersona;
    
    }
   /**
    *Metodo encargado de asignar los datos del estudiante al vector  listaStPersona.
    *@return Vector de tipo String listaStPersona:Vector con la informacion del estudiante.
    *@since SIGED 1.0.0
    */
    public  Vector<String> setDatosEstudiante(){
       listaStPersona.add(clEstudiante.getStNombreCompleto());
       listaStPersona.add(Integer.toString(clEstudiante.getClPlan().getIdplan()));
       
       return listaStPersona;
    
    }
    
    /**
    *Metodo encargado de limpar la tabla de los datos que contenga.
    *@param tabla JTable:Tabla a limpiar.
    *@since SIGED 1.0.0
    */
    public void limpiarTabla(JTable tabla){
        try {
            DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
            int filas=tabla.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }   
    
}
