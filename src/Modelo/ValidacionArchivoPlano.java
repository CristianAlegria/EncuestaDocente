/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Controlador.ControladorCargarArchivos;
import java.io.BufferedReader;
import java.io.FileReader;


/**
 * Clase encargada de validar archivo plano del sistema SIGED.
 * @author Cristian Alexis Alegria C.
 * @version 1.0.0
 * @since SIGED 1.0.0
 */
public class ValidacionArchivoPlano {
    
    ControladorCargarArchivos clControladorCargarArchivos;   

    public ValidacionArchivoPlano() {       
    }  

    public ControladorCargarArchivos getClControladorCargarArchivos() {
        return clControladorCargarArchivos;
    }

    public void setClControladorCargarArchivos(ControladorCargarArchivos clControladorCargarArchivos) {
        this.clControladorCargarArchivos = clControladorCargarArchivos;
    }
    
    
    
    public  boolean validarFomatoTxt(String stRuta){
       return  stRuta.contains(".txt");    
    }
    
    /**
    *Metodo encargado de capturar la informacion que contiene el achivo plano.   
    *@param stRuta String:Ruta donde se encuentra el archivo plano. 
    *@return String cadena:Informacion que contiene el archivo plano.    
    *@since SIGED 1.0.0
    */
    public  String capturarInformacionArchivoPlano(String stRuta){
         String cadena = "";
        try {
            FileReader fileReader = new FileReader(stRuta);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            boolean salida=true;
            int contador = 0;            
            
            while(salida){
              String texto = bufferedReader.readLine();
              if(texto!=null){
                if(contador>0){
                  String valores[];
                  valores = texto.split(",");
                    for (int i = 0; i < valores.length; i++) {
                       String nombre = valores[i];
                       cadena +=nombre+"-"; 
                    }                
                   cadena +="\n"; 
                  
                }else{
                  contador++;
                }
              }else{
                  salida = false;            
              }                    
            }            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  
        return  cadena;
    }
        
    /**
    *Metodo encargado de validar si el archivo plano contiene informacion.  
    *@param stRuta String:Ruta donde se encuentra el archivo plano. 
    *@return boolean validacion:true si contiene informacion false si esta vacio.  
    *@since SIGED 1.0.0
    */
    public boolean contenidoDelArchivoPlano(String stRuta){
        boolean validacion = true;
       if(capturarInformacionArchivoPlano(stRuta).equals("")){
         return false;
       }
     return validacion;
    }       
    
}
