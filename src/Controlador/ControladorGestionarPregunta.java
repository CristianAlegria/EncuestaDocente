/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Caracteristica;
import Modelo.Pregunta;
import Modelo.PreguntaBD;
import Modelo.Tipo;
import Modelo.TipoBD;
import Vista.InfGestionarPregunta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class ControladorGestionarPregunta implements ActionListener, MouseListener{

    private TipoBD clTipoBD;
    private PreguntaBD clPreguntaBD;
    private Vector<Caracteristica> listaCaracteristica;
    private Vector<Pregunta> listaPreguntas;
    private int inOpcionCaracteristica;
    private int inOpcionBoton;
    private Tipo clTipo;
    private int inFilaTabla;
    private Pregunta clPregunta;
    private Caracteristica clCaracteristica;    
    private ControladorPrincipal clControladorPrincipal;
    
    private String stTipo;
    private String stPregunta;
    private String stCaracteristica;
 
    
    
    
    public ControladorGestionarPregunta(ControladorPrincipal clControladorPrincipal) {
        this.clControladorPrincipal = clControladorPrincipal;
    }    

    public ControladorPrincipal getClControladorPrincipal() {
        return clControladorPrincipal;
    }

    public void setClControladorPrincipal(ControladorPrincipal clControladorPrincipal) {
        this.clControladorPrincipal = clControladorPrincipal;
    }

   
     /**
    *Metodo encargado de abrir la ventana Gestionar Pregunta, mostrar todo los componentes que la conforman,de centrarla en pantalla y
    *activar los escuchadores de eventos que ocurran en ella.  
    *@since SIGED 1.0.0
    */
    public void iniciarGestionarPregunta(){
           
            clControladorPrincipal.setInfGestionarPregunta(new InfGestionarPregunta());            
            clControladorPrincipal.getFrmPrincipal().getDstContenedorPrincipal().add(clControladorPrincipal.getInfGestionarPregunta());        
            
            //Se pone a escuchar
            clControladorPrincipal.getInfGestionarPregunta().getBtnRegistrarPregunta().addActionListener(this);
            clControladorPrincipal.getInfGestionarPregunta().getBtnListarPregunta().addActionListener(this);
            clControladorPrincipal.getInfGestionarPregunta().getBtnModificarPregunta().addActionListener(this);
            clControladorPrincipal.getInfGestionarPregunta().getBtnAceptar().addActionListener(this);        
            
            clControladorPrincipal.getInfGestionarPregunta().getTblPregunta().addMouseListener(this);
            
            
            //centrado de formulario
             centrarVentana(clControladorPrincipal.getInfGestionarPregunta());               
             iniciarInfGestionarPregunta();
             cargarListaCaracteristica();
                        
       
    }
    
    public  void cargarListaCaracteristica(){
       clTipoBD = new TipoBD();
       listaCaracteristica = clTipoBD.listarCaracteristicas();  
       clControladorPrincipal.getInfGestionarPregunta().getCbxCaracteristicaPregunta().addItem("Seleccione");
        for (int i = 0; i < listaCaracteristica.size(); i++) {
            clControladorPrincipal.getInfGestionarPregunta().getCbxCaracteristicaPregunta().addItem(listaCaracteristica.get(i).getStNombre());
        }    
    }
    
    /**
    *Metodo encargado de centrar la ventana de Gestionar Pregunta.
    *@param infVentana JInternalFrame:Ventana  GestionarPregunta.
    *@since SIGED 1.0.0
    */
    
    public void centrarVentana(JInternalFrame infVentana){       
        
        clControladorPrincipal.getInfGestionarPregunta().setLocation(clControladorPrincipal.centradoXY(infVentana));
        clControladorPrincipal.getInfGestionarPregunta().setVisible(true);
    }
     
     /**
    *Metodo encargado de colocar el titulo a la ventana Gestioanr Pregunta y colocar los nombres a los comandos de accion de los botones. 
    *@since SIGED 1.0.0
    */
    public void iniciarInfGestionarPregunta(){         
        clControladorPrincipal.getInfGestionarPregunta().setTitle("Gestionar Pregunta");            
        
        //Se añaden las acciones a los controles
        clControladorPrincipal.getInfGestionarPregunta().getBtnRegistrarPregunta().setActionCommand("RegistrarPregunta");
        clControladorPrincipal.getInfGestionarPregunta().getBtnModificarPregunta().setActionCommand("ModificarPregunta");
        clControladorPrincipal.getInfGestionarPregunta().getBtnListarPregunta().setActionCommand("ListarPregunta");
        clControladorPrincipal.getInfGestionarPregunta().getBtnAceptar().setActionCommand("Aceptar");
        deshabilitarCampos();
        deshabilitarBotonAceptar();
        clControladorPrincipal.getInfGestionarPregunta().getBtnModificarPregunta().setEnabled(false);
                  
    }
    
    public  void deshabilitarCampos(){
      clControladorPrincipal.getInfGestionarPregunta().getTxtTipo().setEditable(false);
      clControladorPrincipal.getInfGestionarPregunta().getTxaPregunta().setEditable(false);
      clControladorPrincipal.getInfGestionarPregunta().getCbxCaracteristicaPregunta().setEnabled(false);
    
    }
    public  void habilitarCampos(){
      clControladorPrincipal.getInfGestionarPregunta().getTxtTipo().setEditable(true);
      clControladorPrincipal.getInfGestionarPregunta().getTxaPregunta().setEditable(true);
      clControladorPrincipal.getInfGestionarPregunta().getCbxCaracteristicaPregunta().setEnabled(true);
    
    }
    
    public void limpiarMensajes(){
      clControladorPrincipal.getInfGestionarPregunta().getLblMensajeCaracteristicaPregunta().setText("");
      clControladorPrincipal.getInfGestionarPregunta().getLblMensajeTipoPregunta().setText("");
      clControladorPrincipal.getInfGestionarPregunta().getLblMensajePregunta().setText("");
      clControladorPrincipal.getInfGestionarPregunta().getLblMensajeAceptar().setText("");
      
    
    }
    
    public void limpiarInformacionMostrada(){
     clControladorPrincipal.getInfGestionarPregunta().getTxtTipo().setText("");
     clControladorPrincipal.getInfGestionarPregunta().getTxaPregunta().setText("");
     clControladorPrincipal.getInfGestionarPregunta().getCbxCaracteristicaPregunta().setSelectedIndex(0); 
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
         inOpcionCaracteristica = -1;         
        String stComando = actionEvent.getActionCommand();
        limpiarMensajes();
        
        if(stComando.equals("RegistrarPregunta")){  
            limpiarInformacionDePregunta();
            inOpcionBoton = 0;            
            habilitarCampos();
            deshabilitarBotonModificar();
            habilitarBotonAceptar();
            limpiarInformacionMostrada();            
        
        }else{
             if(stComando.equals("ModificarPregunta")){
                 inOpcionBoton = 1;  
                 habilitarBotonAceptar();
                 habilitarCampos();                
             
             }else{
                 if(stComando.equals("ListarPregunta")){
                     limpiarInformacionMostrada();
                     deshabilitarCampos();
                     deshabilitarBotonAceptar();
                     clControladorPrincipal.getInfGestionarPregunta().getLblMensajeAceptar().setText(""); 
                     llenarTablaPreguntas();                
                     
                 }else{
                      if(stComando.equals("Aceptar")){
                           
                           if(clControladorPrincipal.getInfGestionarPregunta().validarCamposGestionarPregunta()){

                               if(clControladorPrincipal.getInfGestionarPregunta().getCbxCaracteristicaPregunta().getSelectedIndex()>0){ 
                                    if(inOpcionBoton==1){
                                     inOpcionCaracteristica =  clControladorPrincipal.getInfGestionarPregunta().getCbxCaracteristicaPregunta().getSelectedIndex();
                                    }                             
                                    if(huboCambios()){
                                        if(registrarInformacionPregunta()>0){
                                            limpiarInformacionMostrada();
                                            deshabilitarCampos();
                                            if(inOpcionBoton==0){
                                              clControladorPrincipal.getInfGestionarPregunta().getLblMensajeAceptar().setText("La Pregunta Se Registró Exitosamente."); 
                                            }else{
                                                if(inOpcionBoton==1){
                                                    deshabilitarBotonModificar();                                                
                                                    clControladorPrincipal.getInfGestionarPregunta().getLblMensajeAceptar().setText("La Pregunta Se Modificó Exitosamente."); 
                                                }
                                            }
                                            deshabilitarBotonAceptar();

                                        }else{
                                               clControladorPrincipal.getInfGestionarPregunta().getLblMensajeAceptar().setText("Registro Fallido."); 
                                        }  
                                    }else{
                                         clControladorPrincipal.getInfGestionarPregunta().getLblMensajeAceptar().setText("Usted No Realizo Cambios, Modificacion Fallida.");
                                    }
                                }else{
                                    clControladorPrincipal.getInfGestionarPregunta().getLblMensajeCaracteristicaPregunta().setText("Seleccione Caracteristica de la Pregunta."); 
                                }         
                            }        
                       }                 
                 }
                 
             }
        }
    
    }

    public  void limpiarInformacionDePregunta(){
      stTipo = "";
      stPregunta = "";
      stCaracteristica = "";
    }
    public  int registrarInformacionPregunta(){
        
       clTipoBD = new TipoBD();      
       clPreguntaBD = new PreguntaBD();
       clTipo = new Tipo();
       clPregunta = new Pregunta();
       clCaracteristica = new Caracteristica();
       boolean blRegistrar = true;

       int inIdTipo =-1;  
       int inIdPregunta =-1;  
       int inResultado =-1;
       String stTipo =clControladorPrincipal.quitarEspacios(clControladorPrincipal.getInfGestionarPregunta().getTxtTipo().getText().toUpperCase());
       inOpcionCaracteristica =  clControladorPrincipal.getInfGestionarPregunta().getCbxCaracteristicaPregunta().getSelectedIndex();      
       String stPregunta = clControladorPrincipal.getInfGestionarPregunta().getTxaPregunta().getText();     
       
     
       System.out.print("Opcion: "+inOpcionBoton);
       if(inOpcionBoton==0){
            clTipo =clTipoBD.consultarTipo(stTipo);
           if(clTipo!=null){ 
                inIdTipo = clTipo.getInIdTipo();
                if(clTipo.getClCaracteristica().getInIdCaracteristica()!=listaCaracteristica.get(
                             clControladorPrincipal.getInfGestionarPregunta().getCbxCaracteristicaPregunta().getSelectedIndex()-1).getInIdCaracteristica()){

                    clControladorPrincipal.getInfGestionarPregunta().getLblMensajePregunta().setText("Tipo "+stTipo+" Es De Pregunta "+ 
                                                 clControladorPrincipal.quitarEspacios(clTipo.getClCaracteristica().getStNombre())+", Registro Fallido");
                    blRegistrar = false;
                }
           }
            if(blRegistrar){
                inIdPregunta = clPreguntaBD.consultarPregunta(stPregunta);
                System.out.println("inIdPregunta:"+inIdPregunta);
              
                if(inIdTipo==-1){
                  inIdTipo =  clTipoBD.registrarTipo(stTipo,inOpcionCaracteristica);   
                }       
                if(inIdPregunta==-1){

                   inResultado = clPreguntaBD.registrarPregunta(stPregunta,inIdTipo);
                }else{
                   clControladorPrincipal.getInfGestionarPregunta().getLblMensajePregunta().setText("La Pregunta Ya fue Registrada Anteriormente");
                }     
            }
                         
       }else{   
            if(inOpcionBoton==1){
               clTipo.setInIdTipo(listaPreguntas.get(inFilaTabla).getClTipo().getInIdTipo());
               clTipo.setClCaracteristica(clCaracteristica);
               clTipo.getClCaracteristica().setInIdCaracteristica(inOpcionCaracteristica);
               clTipo.setStNombre(stTipo);

               clPregunta.setInIdPregunta(listaPreguntas.get(inFilaTabla).getInIdPregunta());
               clPregunta.setStPregunta(stPregunta);
               clPregunta.setClTipo(clTipo);
               inResultado = clTipoBD.modificarTipo(clTipo);
               inResultado += clPreguntaBD.modificarPregunta(clPregunta);
              
            }
       }

       clTipoBD = null;
       clPreguntaBD = null;
       clTipo = null;
       clPregunta = null;
       clCaracteristica = null;
       System.gc(); 
       
     return inResultado ;
    }
   
    
    public  void llenarTablaPreguntas(){
        clControladorPrincipal.getInfGestionarPregunta().limpiarTabla( clControladorPrincipal.getInfGestionarPregunta().getTblPregunta());
        clPreguntaBD = new PreguntaBD();
        Vector<String>listaStPreguntas;
               
        DefaultTableModel tblModelPregunta = (DefaultTableModel) clControladorPrincipal.getInfGestionarPregunta().getTblPregunta().getModel();
        listaPreguntas = clPreguntaBD.listarPreguntas();
        
        for (int i = 0; i < listaPreguntas.size(); i++) {
            listaStPreguntas = new Vector();
            listaStPreguntas.add(listaPreguntas.get(i).getStPregunta());
            listaStPreguntas.add(listaPreguntas.get(i).getClTipo().getStNombre());
            listaStPreguntas.add(listaPreguntas.get(i).getClTipo().getClCaracteristica().getStNombre());
            tblModelPregunta.addRow(listaStPreguntas);
        }  
        clControladorPrincipal.getInfGestionarPregunta().setDefaultTableModel(tblModelPregunta);     
        
        clPreguntaBD = null;
        System.gc();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
       
         inFilaTabla = clControladorPrincipal.getInfGestionarPregunta().getTblPregunta().rowAtPoint(mouseEvent.getPoint());      
        //System.out.println("fila :"+fila);
        mostrarInformacionSeleccionada(inFilaTabla);       
    }  
    
    public  void mostrarInformacionSeleccionada(int inFila){
        
         stTipo =clControladorPrincipal.quitarEspacios(listaPreguntas.get(inFila).getClTipo().getStNombre());
         stPregunta = listaPreguntas.get(inFila).getStPregunta();
         stCaracteristica = "";
        
        clControladorPrincipal.getInfGestionarPregunta().getTxtTipo().setText(stTipo);
        clControladorPrincipal.getInfGestionarPregunta().getTxaPregunta().setText(stPregunta);
       
        
        for (int i = 0; i < listaCaracteristica.size(); i++) {
            
            if(listaPreguntas.get(inFila).getClTipo().getClCaracteristica().getInIdCaracteristica()==listaCaracteristica.get(i).getInIdCaracteristica()){
                 clControladorPrincipal.getInfGestionarPregunta().getCbxCaracteristicaPregunta().setSelectedIndex(i+1);
                 stCaracteristica =  listaCaracteristica.get(i).getStNombre();
                 
            }            
        } 
        habilitarBotonModificar();        
    }    
    public void habilitarBotonModificar(){
        clControladorPrincipal.getInfGestionarPregunta().getBtnModificarPregunta().setEnabled(true);    
    }
    public void deshabilitarBotonModificar(){
        clControladorPrincipal.getInfGestionarPregunta().getBtnModificarPregunta().setEnabled(false);    
    }
     public void habilitarBotonAceptar(){
        clControladorPrincipal.getInfGestionarPregunta().getBtnAceptar().setEnabled(true);    
    }
    public void deshabilitarBotonAceptar(){
        clControladorPrincipal.getInfGestionarPregunta().getBtnAceptar().setEnabled(false);    
    }
    
    public boolean huboCambios(){
      boolean validacion = true;
      
       if(stTipo.equals(clControladorPrincipal.getInfGestionarPregunta().getTxtTipo().getText()) &&
          stPregunta.equals(clControladorPrincipal.getInfGestionarPregunta().getTxaPregunta().getText())&&
          stCaracteristica.equals(clControladorPrincipal.getInfGestionarPregunta().getCbxCaracteristicaPregunta().getSelectedItem().toString())){
           validacion = false;
      }
       return validacion;
    
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
