/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Vista.InfModificarContrasenia;
import Modelo.Administrador;
import Modelo.Estudiante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;


/**
 * Clase controlador modificar contraseña, la cual permite capturar las peticiones que se realicen en la ventana modificar contraseña.
 * @author Cristian Alexis Alegria C.
 * @version 1.0.0
 * @since SIGED 1.0.0
 */
public class ControladorModificarContrasenia implements ActionListener{

    
    private ControladorPrincipal clControladorPrincipal;
    private String stContraseniaActual;
    private String stContraseniaNueva;
    
    
    /**
    *Metodo constructor que inicializa el controlador principal.
    *@param clControladorPrincipal ControladorPrincipal:Controlador Principal.
    *@since SIGED 1.0.0
    */
    public ControladorModificarContrasenia(ControladorPrincipal clControladorPrincipal) {
        this.clControladorPrincipal = clControladorPrincipal;
    }

    public ControladorPrincipal getClControladorPrincipal() {
        return clControladorPrincipal;
    }

    public void setClControladorPrincipal(ControladorPrincipal clControladorPrincipal) {
        this.clControladorPrincipal = clControladorPrincipal;
    }

    public String getStContraseniaActual() {
        return stContraseniaActual;
    }

    public void setStContraseniaActual(String stContraseniaActual) {
        this.stContraseniaActual = stContraseniaActual;
    }

    public String getStContraseniaNueva() {
        return stContraseniaNueva;
    }

    public void setStContraseniaNueva(String stContraseniaNueva) {
        this.stContraseniaNueva = stContraseniaNueva;
    }
    
    
    /**
    *Metodo encargado de abrir la ventana modificar contraseña administrador , mostrar todo los componentes que la conforman,de centrarla en pantalla y
    *activar los escuchadores de eventos que ocurran en ella.  
    *@since SIGED 1.0.0
    */
    public void iniciarModificarContraseniaAdministrador(){
        //if(clControladorPrincipal.estaCerrado(clControladorPrincipal.getInfModificarContraseniaAdministrador())){//se crea nuevo           
            clControladorPrincipal.setInfModificarContraseniaAdministrador(new InfModificarContrasenia());
            clControladorPrincipal.getFrmPrincipal().getDstContenedorPrincipal().add(clControladorPrincipal.getInfModificarContraseniaAdministrador());    
            
            clControladorPrincipal.getInfModificarContraseniaAdministrador().btnGuardarCambios.addActionListener(this);
            centrarVentanaAdministrador(clControladorPrincipal.getInfModificarContraseniaAdministrador());
            iniciarInfCambiarContraseniaAdministrador();
      /* }
       else{
          JOptionPane.showMessageDialog(this.clControladorPrincipal.getFrmPrincipal(),"La ventana de 'Modificar Contraseña' ya esta abierta.");
       }*/
    }
    
    
    
    /**
    *Metodo encargado de centrar la ventana modificar contraseña estudiante.
    *@param infVentana JInternalFrame:Ventana modificar contraseña.
    *@since SIGED 1.0.0
    */
    public void centrarVentanaEstudiante(JInternalFrame infVentana){
     
        clControladorPrincipal.getInfModificarContraseniaEstudiante().setLocation(clControladorPrincipal.centradoXY(infVentana));
        clControladorPrincipal.getInfModificarContraseniaEstudiante().setVisible(true);
    }
    
    /**
    *Metodo encargado de centrar la ventana modificar contraseña administrador.
    *@param infVentana JInternalFrame:Ventana modificar contraseña.
    *@since SIGED 1.0.0
    */
    public void centrarVentanaAdministrador(JInternalFrame infVentana){
     
        clControladorPrincipal.getInfModificarContraseniaAdministrador().setLocation(clControladorPrincipal.centradoXY(infVentana));
        clControladorPrincipal.getInfModificarContraseniaAdministrador().setVisible(true);
    }
    
    /**
    *Metodo encargado de abrir la ventana modificar contraseña estudiante , mostrar todo los componentes que la conforman,de centrarla en pantalla y
    *activar los escuchadores de eventos que ocurran en ella.  
    *@since SIGED 1.0.0
    */
    public void iniciarModificarContraseniaEstudiante(){
//        if(clControladorPrincipal.estaCerrado(clControladorPrincipal.getInfModificarContraseniaEstudiante())){//se crea nuevo           
            clControladorPrincipal.setInfModificarContraseniaEstudiante(new InfModificarContrasenia());
            clControladorPrincipal.getFrmPrincipal().getDstContenedorPrincipal().add(clControladorPrincipal.getInfModificarContraseniaEstudiante());        
            
            clControladorPrincipal.getInfModificarContraseniaEstudiante().btnGuardarCambios.addActionListener(this);           
            centrarVentanaEstudiante(clControladorPrincipal.getInfModificarContraseniaEstudiante());            
            iniciarInfCambiarContraseniaEstudiante();
     /*  }
       else{
          JOptionPane.showMessageDialog(this.clControladorPrincipal.getFrmPrincipal(),"La ventana de 'Modificar Contraseña' ya esta abierta.");
       }*/
    }    
   
    /**
    *Metodo encargado colocar el titulo a la venta modificar contraseña administrador y colocar un nombre al comando de accion del boton guardar cambios. 
    *@since SIGED 1.0.0
    */
    
    public void iniciarInfCambiarContraseniaAdministrador(){         
        clControladorPrincipal.getInfModificarContraseniaAdministrador().setTitle("Modificar Contraseña Administrador");            
         //Se añaden las acciones a los controles
        clControladorPrincipal.getInfModificarContraseniaAdministrador().getBtnGuardarCambios().setActionCommand("GuardarCambiosAdministrador");
        //centrado de formulario             
    } 
    /**
    *Metodo encargado colocar el titulo a la venta modificar contraseña estudiante y colocar un nombre al comando de accion del boton guardar cambios. 
    *@since SIGED 1.0.0
    */
    
    public void iniciarInfCambiarContraseniaEstudiante(){         
        clControladorPrincipal.getInfModificarContraseniaEstudiante().setTitle("Modificar Contraseña Estudiante");            
         //Se añaden las acciones a los controles
        clControladorPrincipal.getInfModificarContraseniaEstudiante().getBtnGuardarCambios().setActionCommand("GuardarCambiosEstudiante");
        //centrado de formulario             
    } 
    
    /**
    *Metodo encargado de capturar y reponder a los eventos que ocurran en la ventana modificar contraseña.
    *@param actionEvent ActionEvent:Evento que se acciona. 
    *@since SIGED 1.0.0
    */
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
       
        String stComando = actionEvent.getActionCommand();
        int inResultado = 0;
         Administrador clAdministrador = null;
         Estudiante clEstudiante = null;
        
        if(stComando.equals("GuardarCambiosAdministrador")){
           
            if(clControladorPrincipal.getInfModificarContraseniaAdministrador().validarcamposModificarContrasenia()){
                clControladorPrincipal.getInfModificarContraseniaAdministrador().limpiarMensajes();
                // System.out.print("ENTRO");
                clAdministrador=clControladorPrincipal.getClAdministrador(); 
                capturarCamposInfModificarContraseniaAdministrador();
                clAdministrador.setStContrasenia(stContraseniaActual);
                clAdministrador = clAdministrador.validarContraseniaUsuario();
                
                if(clAdministrador!=null){
                    
                    clAdministrador.destroyClAdministradorBD();
                    clControladorPrincipal.setClAdministrador(clAdministrador);
                    clAdministrador.setStContrasenia(stContraseniaNueva);
                    
                    inResultado = clAdministrador.ModificarContraseniaAdminitrador();
                    clAdministrador.destroyClAdministradorBD();
                        
                    
                   if(inResultado!=0){
                         clControladorPrincipal.getInfModificarContraseniaAdministrador().getLblMensajeModificarContrasenia().setText("Cambios Guardados");
                         clControladorPrincipal.getInfModificarContraseniaAdministrador().limpiarCamposTxt();

                    }        
                }else{
                      clControladorPrincipal.getInfModificarContraseniaAdministrador().getLblMensajeModificarContrasenia().setText("Contraseña Actual Invalida");
                }
            }
        }else{
             if(stComando.equals("GuardarCambiosEstudiante")){
           
                if(clControladorPrincipal.getInfModificarContraseniaEstudiante().validarcamposModificarContrasenia()){
                    clControladorPrincipal.getInfModificarContraseniaEstudiante().limpiarMensajes();
                    // System.out.print("ENTRO");
                    clEstudiante = clControladorPrincipal.getClEstudiante();   
                    capturarCamposInfModificarContraseniaEstudiante();
                    clEstudiante.setStContrasenia(stContraseniaActual);
                    clEstudiante = clEstudiante.validarContraseniaUsuario();

                    if(clEstudiante!=null){
                        clEstudiante.destroyClEstudianteBD();
                        clControladorPrincipal.setClEstudiante(clEstudiante);
                        clEstudiante.setStContrasenia(stContraseniaNueva);
                        inResultado = clEstudiante.ModificarContraseniaEstudiante();
                        clEstudiante.destroyClEstudianteBD();
                        
                       if(inResultado!=0){
                             clControladorPrincipal.getInfModificarContraseniaEstudiante().getLblMensajeModificarContrasenia().setText("Cambios Guardados");
                             clControladorPrincipal.getInfModificarContraseniaEstudiante().limpiarCamposTxt();

                        }        
                    }else{
                          clControladorPrincipal.getInfModificarContraseniaEstudiante().getLblMensajeModificarContrasenia().setText("Contraseña Actual Invalida");
                    }
                }        
            }
        }
        System.gc();
    }
    
    
    /**
    *Metodo encargado de capturar los datos que el usuario digito en  los campos de la ventana modificar contraseña  administrador.  
    *@since SIGED 1.0.0
    */
    public void capturarCamposInfModificarContraseniaAdministrador(){
     stContraseniaActual =  clControladorPrincipal.getInfModificarContraseniaAdministrador().getPwdContraseniaActual().getText();   
     stContraseniaNueva =  clControladorPrincipal.getInfModificarContraseniaAdministrador().getPwdConfirmaContraseniaNueva().getText();
    }
    
    /**
    *Metodo encargado de capturar los datos que el usuario digito en  los campos de la ventana modificar contraseña  estudiante.  
    *@since SIGED 1.0.0
    */
   public void capturarCamposInfModificarContraseniaEstudiante(){
     stContraseniaActual =  clControladorPrincipal.getInfModificarContraseniaEstudiante().getPwdContraseniaActual().getText();   
     stContraseniaNueva =  clControladorPrincipal.getInfModificarContraseniaEstudiante().getPwdConfirmaContraseniaNueva().getText();
   }
    
}
