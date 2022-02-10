/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Administrador;
import Modelo.Estudiante;
import Vista.InfLogin;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 * Clase controlador login, la cual permite capturar las peticiones que se realicen en la ventana login.
 * @author Cristian Alexis Alegria C.
 * @version 1.0.0
 * @since SIGED 1.0.0
 */
public class ControladorLogin implements ActionListener{
    private ControladorPrincipal clControladorPrincipal;
    private int inId;
    private String stContrasenia;
    
     
    /**
    *Metodo constructor que inicializa el controlador principal.
    *@param clControladorPrincipal ControladorPrincipal:Controlador Principal.
    *@since SIGED 1.0.0
    */
    public ControladorLogin(ControladorPrincipal clControladorPrincipal) {
        this.clControladorPrincipal = clControladorPrincipal;
    }  
    
    public ControladorPrincipal getClControladorPrincipal() {
        return clControladorPrincipal;
    }

    public void setClControladorPrincipal(ControladorPrincipal clControladorPrincipal) {
        this.clControladorPrincipal = clControladorPrincipal;
    }   

    public int getInId() {
        return inId;
    }

    public void setInId(int inId) {
        this.inId = inId;
    }

    public String getStContrasenia() {
        return stContrasenia;
    }

    public void setStContrasenia(String stContrasenia) {
        this.stContrasenia = stContrasenia;
    }
    
    

    /**
    *Metodo encargado colocar el titulo a la ventana login administrador y colocar un nombre al comando de accion del boton entrar. 
    *@since SIGED 1.0.0
    */
    public void iniciarInfLoginAdministrador(){         
        clControladorPrincipal.getInfLoginAdministrador().setTitle("Login Administrador");            
         //Se añaden las acciones a los controles
        clControladorPrincipal.getInfLoginAdministrador().getBtnEntrar().setActionCommand("EntrarAdministrador");
        //centrado de formulario             
    } 
    
    /**
    *Metodo encargado colocar el titulo a la ventana login estudiante y colocar un nombre al comando de accion del boton entrar. 
    *@since SIGED 1.0.0
    */
    public void iniciarInfLoginEstudiante(){         
        clControladorPrincipal.getInfLoginEstudiante().setTitle("Login Estudiante");            
         //Se añaden las acciones a los controles
        clControladorPrincipal.getInfLoginEstudiante().getBtnEntrar().setActionCommand("EntrarEstudiante");
        //centrado de formulario             
    } 
    
    /**
    *Metodo encargado de abrir la ventana login estudiante, mostrar todo los componentes que la conforman,de centrarla en pantalla y
    *activar los escuchadores de eventos que ocurran en ella.  
    *@since SIGED 1.0.0
    */
    public void iniciarLogueoEstudiante(){
       // if(clControladorPrincipal.estaCerrado(clControladorPrincipal.getInfLoginEstudiante())){//se crea nuevo
           
            clControladorPrincipal.setInfLoginEstudiante(new InfLogin());            
            clControladorPrincipal.getFrmPrincipal().getDstContenedorPrincipal().add(clControladorPrincipal.getInfLoginEstudiante());        
            
            clControladorPrincipal.getInfLoginEstudiante().getBtnEntrar().addActionListener(this);         
            centrarVentanaEstudiante(clControladorPrincipal.getInfLoginEstudiante());           
            iniciarInfLoginEstudiante();
       /*}
       else{
          JOptionPane.showMessageDialog(this.clControladorPrincipal.getFrmPrincipal(),"La ventana de 'Login Estudiante' ya esta abierta.");
       }*/
    }
    
    /**
    *Metodo encargado de abrir la ventana login administrador , mostrar todo los componentes que la conforman,de centrarla en pantalla y
    *activar los escuchadores de eventos que ocurran en ella.  
    *@since SIGED 1.0.0
    */
    public void iniciarLogueoAdministrador(){
        //if(clControladorPrincipal.estaCerrado(clControladorPrincipal.getInfLoginAdministrador())){//se crea nuevo
            clControladorPrincipal.setInfLoginAdministrador( new InfLogin());            
            clControladorPrincipal.getFrmPrincipal().getDstContenedorPrincipal().add(clControladorPrincipal.getInfLoginAdministrador());
            
            clControladorPrincipal.getInfLoginAdministrador().getBtnEntrar().addActionListener(this); 
            centrarVentanaAdministrador(clControladorPrincipal.getInfLoginAdministrador());            
            iniciarInfLoginAdministrador();
            
      /* } else{
          JOptionPane.showMessageDialog(this.clControladorPrincipal.getFrmPrincipal(),"La ventana de 'Login Adminitrador' ya esta abierta.");
       }*/
    }  
    
    /**
    *Metodo encargado de centrar la ventana login administrador
    *@param infVentana JInternalFrame:Ventana login
    *@since SIGED 1.0.0
    */
    public void centrarVentanaAdministrador(JInternalFrame infVentana){       
        
        clControladorPrincipal.getInfLoginAdministrador().setLocation(clControladorPrincipal.centradoXY(infVentana));
        clControladorPrincipal.getInfLoginAdministrador().setVisible(true);
    }
   
    /**
    *Metodo encargado de centrar la ventana login estudiante.
    *@param infVentana JInternalFrame:Ventana login.
    *@since SIGED 1.0.0
    */
    public void centrarVentanaEstudiante(JInternalFrame infVentana){       
        
        clControladorPrincipal.getInfLoginEstudiante().setLocation(clControladorPrincipal.centradoXY(infVentana));
        clControladorPrincipal.getInfLoginEstudiante().setVisible(true);
    }
    
    
    
    /**
    *Metodo encargado de capturar y reponder a los eventos que ocurran en la ventana login.
    *@param actionEvent ActionEvent:Evento que se acciona. 
    *@since SIGED 1.0.0
    */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        
        String stComando = actionEvent.getActionCommand();
        Estudiante clEstudiante = null;
        Administrador clAdministrador = null;
        
        
        if(stComando.equals("EntrarEstudiante")){
             clEstudiante = new Estudiante();               
            if(clControladorPrincipal.getInfLoginEstudiante().validarcamposLogin()){
                
                clControladorPrincipal.getInfLoginEstudiante().limpiarMensajes();
                capturarDatosLoginEstudiante();
                clEstudiante.setInId(inId);                
                clEstudiante = clEstudiante.consultarUsuario();
                
               if(clEstudiante!=null){
                   clEstudiante.destroyClEstudianteBD();
                   clEstudiante.setStContrasenia(stContrasenia);
                   clEstudiante = clEstudiante.validarContraseniaUsuario();
                   if(clEstudiante!=null){
                         clEstudiante.destroyClEstudianteBD();
                         clControladorPrincipal.setClEstudiante(clEstudiante);                        
                        
                         habilitarOpcionesEstudianteLogueado();
                         clControladorPrincipal.getInfLoginEstudiante().limpiarCamposTxt();
                         clEstudiante.setStContrasenia("");
                   }else{
                      clControladorPrincipal.getInfLoginEstudiante().getLblMensajeContrasenia().setText("Contraseña Incorrecta");
                   }             
                
               }else{
                  clControladorPrincipal.getInfLoginEstudiante().getLblMensajeLogueo().setText("Usuario No Existe");
                }
            }     
        }else{
          if(stComando.equals("EntrarAdministrador")){
                clAdministrador = new Administrador();                      
                if(clControladorPrincipal.getInfLoginAdministrador().validarcamposLogin()){
                    clControladorPrincipal.getInfLoginAdministrador().limpiarMensajes();
                    capturarDatosLoginAdministrador();
                    clAdministrador.setInId(inId);
                    clAdministrador = clAdministrador.consultarUsuario();
                    if(clAdministrador!=null){
                       clAdministrador.destroyClAdministradorBD();
                       clAdministrador.setStContrasenia(stContrasenia);
                       clAdministrador = clAdministrador.validarContraseniaUsuario();
                       if(clAdministrador!=null){
                           
                          clAdministrador.destroyClAdministradorBD();
                          clControladorPrincipal.setClAdministrador(clAdministrador);  
                          
                          habilitarOpcionesAdministradorLogueado();
                          clControladorPrincipal.getInfLoginAdministrador().limpiarCamposTxt();
                          clAdministrador.setStContrasenia("");
                          
                      }else{
                        clControladorPrincipal.getInfLoginAdministrador().getLblMensajeContrasenia().setText("Contraseña Incorrecta");
                      }                   
                    }else{
                      clControladorPrincipal.getInfLoginAdministrador().getLblMensajeLogueo().setText("Usuario No Existe");
                    }
               }
            }       
        }     
    }
    
    /**
    *Metodo encargado de habilitar las opciones de un administrador logueado.
    *@since SIGED 1.0.0
    */
    
    public void habilitarOpcionesAdministradorLogueado(){
          clControladorPrincipal.getFrmPrincipal().getMnuSalir().setEnabled(true);
          clControladorPrincipal.getFrmPrincipal().getMnuAdministracion().setEnabled(true);
          clControladorPrincipal.getFrmPrincipal().getMnuIngresar().setEnabled(false);
          clControladorPrincipal.getInfLoginAdministrador().dispose();
    }
    
    /**
    *Metodo encargado de habilitar las opciones de un estudiante logueado.
    *@since SIGED 1.0.0
    */
    public void habilitarOpcionesEstudianteLogueado(){
         clControladorPrincipal.getFrmPrincipal().getMnuSalir().setEnabled(true);
         clControladorPrincipal.getFrmPrincipal().getMnuEstudiante().setEnabled(true);
         clControladorPrincipal.getFrmPrincipal().getMnuIngresar().setEnabled(false);
         clControladorPrincipal.getInfLoginEstudiante().dispose();
    
    }
    
    /**
    *Metodo encargado de capturar los datos que el usuario digito en  los campos de la ventana login administrador
    *@since SIGED 1.0.0
    */
    public  void capturarDatosLoginAdministrador(){
       inId =  Integer.parseInt(clControladorPrincipal.getInfLoginAdministrador().getTxtNombreUsuario().getText());
       stContrasenia = clControladorPrincipal.getInfLoginAdministrador().getPwdContrasenia().getText();
    }
    
    /**
    *Metodo encargado de capturar los datos que el usuario digito en  los campos de la ventana login estudiante
    *@since SIGED 1.0.0
    */
    public  void capturarDatosLoginEstudiante(){
       inId =  Integer.parseInt(clControladorPrincipal.getInfLoginEstudiante().getTxtNombreUsuario().getText());
       stContrasenia = clControladorPrincipal.getInfLoginEstudiante().getPwdContrasenia().getText();
    }
     
   
}
