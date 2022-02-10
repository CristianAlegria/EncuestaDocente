/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Controlador.ControladorPrincipal;

import Vista.FrmPrincipal;

//para el skin
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Clase que permite iniciar todo el sistema SIGED
 * @author Cristian Alexis Alegria C.
 * @version 1.0.0
 * @since SIGED 1.0.0
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        FrmPrincipal principal = new FrmPrincipal();
       //Para colocar un skin propio de java
        
        /*
                setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); 
                setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel"); 
                setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel"); 
                setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");//este es el que salia en el proyecto de desarrollo II
                setLookAndFeel("com.sun.java.swing.plaf windows.WindowsLookAndFeel");             
                setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel"); */
        
        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(principal);
            new ControladorPrincipal(principal).mostrarVentanaPrincipal();
        } catch (UnsupportedLookAndFeelException ex) {
            
        } catch (ClassNotFoundException ex) {
            
        } catch (InstantiationException ex) {
            
        } catch (IllegalAccessException ex) {
            
        }
        
    }
    
}
