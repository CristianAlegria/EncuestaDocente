/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.util.Vector;

/**
 *
 * @author User
 */
public class Encuesta {
    
    private int inCodigo;
    private String stFecha;
    private String stPeriodo;
    private boolean blEstado;
    
    private Vector<Pregunta>listaObjPregunta;
    private Vector<Asignatura>listaObjAsignatura;
    private Vector<Integer>listaInEncuestaAsignatura;
    private Vector<Integer>listaInFormulario;

    public Encuesta() {
        listaObjAsignatura = new Vector();
        listaObjPregunta = new Vector();
        listaInEncuestaAsignatura = new Vector();
        listaInFormulario = new Vector();
    }

    public boolean isBlEstado() {
        return blEstado;
    }

   

    public void setBlEstado(boolean blEstado) {
        this.blEstado = blEstado;
    }
    
    

    public int getInCodigo() {
        return inCodigo;
        
    }

    public void setInCodigo(int inCodigo) {
        this.inCodigo = inCodigo;
    }

    public String getStFecha() {
        return stFecha;
    }

    public void setStFecha(String stFecha) {
        this.stFecha = stFecha;
    }

    public String getStPeriodo() {
        return stPeriodo;
    }

    public void setStPeriodo(String stPeriodo) {
        this.stPeriodo = stPeriodo;
    }

    public Vector<Pregunta> getListaObjPregunta() {
        return listaObjPregunta;
    }

    public void setListaObjPregunta(Vector<Pregunta> listaObjPregunta) {
        this.listaObjPregunta = listaObjPregunta;
    }

    public Vector<Asignatura> getListaObjAsignatura() {
        return listaObjAsignatura;
    }

    public Vector<Integer> getListaInFormulario() {
        return listaInFormulario;
    }

    public void setListaInFormulario(Vector<Integer> listaInFormulario) {
        this.listaInFormulario = listaInFormulario;
    }

    
    public void setListaObjAsignatura(Vector<Asignatura> listaObjAsignatura) {
        this.listaObjAsignatura = listaObjAsignatura;
    }
    
    public void agregarAsignaturas(Asignatura clAsignatura) {
        listaObjAsignatura.add(clAsignatura);
    }
    public void agregarPreguntas(Pregunta clPregunta) {
        listaObjPregunta.add(clPregunta);
    }

    public Vector<Integer> getListaInEncuestaAsignatura() {
        return listaInEncuestaAsignatura;
    }

    public void setListaInEncuestaAsignatura(Vector<Integer> listaInEncuestaAsignatura) {
        this.listaInEncuestaAsignatura = listaInEncuestaAsignatura;
    }

    
     public void agregarInEncuestaAsignatura(int id) {
        listaInEncuestaAsignatura.add(id);
    }
    public void agregarInFormulario(int id) {
        listaInFormulario.add(id);
    }
    
    
    
}
